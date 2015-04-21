package br.com.bruno.leitorlog.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.bruno.leitorlog.model.JPAUtil;
import br.com.bruno.leitorlog.model.Ranking;

public class RankingDao {
	
	public void salvar(String user) {
	
		Ranking objRanking = new Ranking(PartidaDao.objPartida, user, 0, 0);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		if(findUser(user) == null) {
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.persist(objRanking);
			tx.commit();
			em.close();
		}
		
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
	
	/*
	public void atualizarRanking() {
		EntityManager em = JPAUtil.getEntityManager();
		Ranking objRanking;
		int qtdMatou = 0;
		int qtdMorreu = 0;
		
		
		for(Partida partida : listaPartidas) {
		
			qtdMatou = (int)em.createNamedQuery("LogPartida.pesquisaQuantidadeMortes")
												.setParameter("partida", partida)
												.setParameter("", value)
					
					qtdMorreu = 
			
		}
	}
*/
}
