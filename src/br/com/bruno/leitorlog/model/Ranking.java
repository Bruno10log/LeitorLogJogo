package br.com.bruno.leitorlog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Ranking.findUser", query="SELECT r FROM Ranking r WHERE r.partida = :partida AND r.user = :user"),
	@NamedQuery(name="Ranking.findAllUsers", query="SELECT r FROM Ranking r WHERE r.partida = :partida"),
	@NamedQuery(name="Ranking.findRanking", query="SELECT NEW br.com.bruno.leitorlog.model.RankingPartida("
													+ "r.partida,r.user, r.qtdMatou, r.qtdMorreu, (r.qtdMatou - r.qtdMorreu)) "
													+ "FROM Ranking r "
													+ "WHERE r.partida = :partida " 
													+ "ORDER BY r.qtdMatou - r.qtdMorreu DESC, r.user")
})
public class Ranking {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRanking;
	
	@ManyToOne @JoinColumn(name="idPartida") 
	private Partida partida;

	private String user;
	
	private long qtdMatou;
	private long qtdMorreu;
	
	public Ranking() {
	}
	
	public Ranking(Partida partida, String user, long qtdMatou, long qtdMorreu) {
		this.partida   = partida;
		this.user      = user;
		this.qtdMatou  = qtdMatou;
		this.qtdMorreu = qtdMorreu;
	}
	
	public long getQtdAssassinatos() {
		return qtdMatou;
	}
	
	public void setQtdAssassinatos(long qtdMatou) {
		this.qtdMatou = qtdMatou;
	}

	public long getQtdMortes() {
		return qtdMorreu;
	}

	public void setQtdMortes(long qtdMortes) {
		this.qtdMorreu = qtdMortes;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getIdRanking() {
		return idRanking;
	}

	public void setIdRanking(int idRanking) {
		this.idRanking = idRanking;
	}

}
