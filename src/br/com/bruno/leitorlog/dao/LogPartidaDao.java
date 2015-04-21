package br.com.bruno.leitorlog.dao;

import java.util.List;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.bruno.leitorlog.consultas.ArmaFavorita;
import br.com.bruno.leitorlog.data.Acao;
import br.com.bruno.leitorlog.model.JPAUtil;
import br.com.bruno.leitorlog.model.LogPartida;
import br.com.bruno.leitorlog.model.Ranking;

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
		
	public ArmaFavorita getArmaFavorita(String user) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ArmaFavorita objArma = (ArmaFavorita) em.createNamedQuery("LogPartida.pesquisaArmaFavorita")
												.setParameter("partida", PartidaDao.objPartida)
												.setParameter("user", user)
												.setMaxResults(1)
												.getSingleResult();
												
		return objArma;											
	}

	@SuppressWarnings("unchecked")
	public int maiorSequenciaDeMortes(String user) {
		
		EntityManager em = JPAUtil.getEntityManager();
		int indice = 0;
		int maximos[] = new int[100];
		
		Query query = em.createNamedQuery("LogPartida.findUser")
						.setParameter("user", user)
						.setParameter("partida", PartidaDao.objPartida);
		try {
			List<LogPartida> listaLogs = query.getResultList();
		
			for(LogPartida objLog: listaLogs) {
				if(objLog.getUserAssassino().equals(user)) {
					maximos[indice]++;
				} else {
					indice++;
				}
			}
		} catch(NoResultException e) {
			e.printStackTrace();
			return 0;
		}
		
		return getMax(maximos);
		
	}

	@SuppressWarnings("unchecked")
	public String maiorSequenciaDeMortes() {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		List<Ranking> listaRanking = em.createNamedQuery("Ranking.findAllUsers")
                					.setParameter("partida", PartidaDao.objPartida)
                					.getResultList();
		
		TreeMap<Integer, String> listaUsers = new TreeMap<Integer, String>();
		
		for(Ranking objRanking : listaRanking) {
			listaUsers.put(maiorSequenciaDeMortes(objRanking.getUser()),objRanking.getUser());
		}
		
		return  listaUsers.get(listaUsers.lastKey()) + " - " + listaUsers.lastKey() ;
	
	}

	public int getMax(int[] mortes){
	       
		 int max = 0;//aqui a variável max recebe o valor do primeiro item do array    
         for (int i = 1; i < mortes.length; i++) {//aqui a iteração irá ocorrer    
            if (mortes[i] > max){ //caso o valor da posição i seja maior que o valor de max, max será substituído pelo valor da i-ésima posição.    
                max = mortes[i];   
            }  
         }    
         
         return max;
	}
	
}
