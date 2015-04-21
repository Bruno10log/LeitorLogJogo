package br.com.amil.leitorlog.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.amil.leitorlog.data.Acao;
import br.com.amil.leitorlog.model.JPAUtil;
import br.com.amil.leitorlog.model.LogPartida;

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
}
