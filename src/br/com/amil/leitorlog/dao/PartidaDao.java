package br.com.amil.leitorlog.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.amil.leitorlog.data.Match;
import br.com.amil.leitorlog.model.JPAUtil;
import br.com.amil.leitorlog.model.Partida;

public class PartidaDao {
	
	public static Partida objPartida = null;

	public void salvar(Match objMatch) {
		
		objPartida = new Partida(objMatch.getIdMatch(), objMatch.getData() ,objMatch.getHora());
		EntityManager em = JPAUtil.getEntityManager();
		
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(objPartida);
		tx.commit();
		
		em.close();
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
	
	/*
	public Partida consultarPorId(Long id) {
	    EntityManager entityManager = JPAUtil.getEntityManager();
	    Partida objPartida = null;
	    try {
	      //Consulta uma pessoa pelo seu ID.
	      objPartida = entityManager.find(Partida.class, id);
	    } finally {
	      entityManager.close();
	    }
	    return objPartida;
	} */
	
	
	
}
