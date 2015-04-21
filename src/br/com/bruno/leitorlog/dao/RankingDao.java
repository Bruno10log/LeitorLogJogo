package br.com.bruno.leitorlog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.bruno.leitorlog.config.ConstantsLog;
import br.com.bruno.leitorlog.model.JPAUtil;
import br.com.bruno.leitorlog.model.Ranking;
import br.com.bruno.leitorlog.model.RankingPartida;

public class RankingDao {
	
	public void salvar(String user) {
	
		Ranking objRanking = new Ranking(PartidaDao.objPartida, user, 0, 0);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		if(user.equals(ConstantsLog.WORLD)) {
			return;
		}
		
		if(findUser(user) == null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(objRanking);
			tx.commit();
			em.close();
		}
		
	}
	
	private void salvar(Ranking objRanking) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(objRanking);
		tx.commit();
		em.close();
		
	}
	
	public Ranking findUser(String user) {
		EntityManager em = JPAUtil.getEntityManager();
	    Ranking objRanking = null;
		
	    try {
	        objRanking = (Ranking) em.createNamedQuery("Ranking.findUser")
		   								.setParameter("partida", PartidaDao.objPartida)
		   								.setParameter("user", user)
										.getSingleResult();
	    } catch (Exception e) {
	   
	    }
	       return objRanking;
	}
	
	@SuppressWarnings("unchecked")
	public void atualizarRanking() {
	
		EntityManager em = JPAUtil.getEntityManager();
		long qtdMatou = 0;
		long qtdMorreu = 0;
		
		List<Ranking> listaRanking = em.createNamedQuery("Ranking.findAllUsers")
				                                .setParameter("partida", PartidaDao.objPartida)
				                                .getResultList();
		
		for(Ranking objRanking : listaRanking) {
		
			qtdMorreu = (long) em.createNamedQuery("LogPartida.pesquisaQuantidadeMortes")
												.setParameter("partida", objRanking.getPartida())
												.setParameter("user", objRanking.getUser())
												.getSingleResult();
					
			qtdMatou = (long) em.createNamedQuery("LogPartida.pesquisaQuantidadeAssassinatos")
												 .setParameter("partida", objRanking.getPartida())
												 .setParameter("user", objRanking.getUser())
												 .getSingleResult();
			
			objRanking.setQtdAssassinatos(qtdMatou);
			objRanking.setQtdMortes(qtdMorreu);
			
			salvar(objRanking);			
		}
	}
	
	public List<RankingPartida> getRanking() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		List<RankingPartida> listaRanking = em.createNamedQuery("Ranking.findRanking")
											.setParameter("partida", PartidaDao.objPartida)
											.getResultList();
		
		return listaRanking;
	}
	
	
}
