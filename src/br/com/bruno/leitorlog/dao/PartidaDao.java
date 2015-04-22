package br.com.bruno.leitorlog.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.bruno.leitorlog.data.Match;
import br.com.bruno.leitorlog.model.JPAUtil;
import br.com.bruno.leitorlog.model.Partida;

public class PartidaDao {
	
	public static Partida objPartida = null;

	public void salvar(Partida objPartida) {
		
		EntityManager em = JPAUtil.getEntityManager();		
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(objPartida);
		tx.commit();
		
		em.close();
	}
	
	public void salvar(Match objMatch) {
		
		objPartida = findPartida(objMatch.getIdMatch());
		
		if(objPartida != null) {
			removePartida(objPartida);
		}
		
		objPartida = new Partida(objMatch.getIdMatch(), objMatch.getData() ,objMatch.getHora());
		salvar(objPartida);
	}
	
	public void finalizar(Date horaFim) {
	
		objPartida.setHoraFim(horaFim);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(objPartida);
		tx.commit();
		
		em.close();
	}
	
	public Partida findPartida(long idPartida) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Partida objPartida = em.find(Partida.class, idPartida);
		
		return objPartida;
	}
	
	public void removePartida(Partida partida) {
		
		LogPartidaDao objDao = new LogPartidaDao();
		RankingDao objRankingDao = new RankingDao();
		
		objDao.limparLog(partida);
		objRankingDao.limpaRanking(partida);
		
		EntityManager em = JPAUtil.getEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		partida = em.merge(partida);
		em.remove(partida);
		tx.commit();
		
		em.close();
	}

	
}
