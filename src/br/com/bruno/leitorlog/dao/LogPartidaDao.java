package br.com.bruno.leitorlog.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.bruno.leitorlog.data.Acao;
import br.com.bruno.leitorlog.model.JPAUtil;
import br.com.bruno.leitorlog.model.LogPartida;
import br.com.bruno.leitorlog.model.Partida;

public class LogPartidaDao {
	
	private LogPartida objLog;
	
	public void salvar(Acao objAcao) {
		
		objLog = new LogPartida(PartidaDao.objPartida, objAcao.getHora(),objAcao.getNomeAssassino(), 
									objAcao.getNomeAssassinado(),objAcao.getNomeArma());
		
		EntityManager em = JPAUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(objLog);
		tx.commit();
		
		em.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Partida> buscaLogPartida(Partida partida) {
		
		List<Partida> partidas = null;
		try{
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createNamedQuery("LogPartida.findAll")
							.setParameter("partida", PartidaDao.objPartida);
			partidas = query.getResultList();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return partidas;
	}
}
