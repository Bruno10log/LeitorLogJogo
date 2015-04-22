package br.com.bruno.leitorlog.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static final EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("testeAmil");
	
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	
	
}
