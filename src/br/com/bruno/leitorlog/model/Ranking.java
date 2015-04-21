package br.com.bruno.leitorlog.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name="Ranking.findUser",query="SELECT r FROM Ranking r WHERE r.partida = :partida AND r.user = :user")
})
public class Ranking {
	
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRanking;
	
	@ManyToOne @JoinColumn(name="idPartida") 
	private Partida partida;

	private String user;
	
	private int qtdMatou;
	private int qtdMorreu;
	
	public Ranking() {
	}
	
	public Ranking(Partida partida, String user, int qtdMatou, int qtdMorreu) {
		this.partida   = partida;
		this.user      = user;
		this.qtdMatou  = qtdMatou;
		this.qtdMorreu = qtdMorreu;
	}
	
	public int getQtdAssassinatos() {
		return qtdMatou;
	}
	
	public void setQtdAssassinatos(int qtdMatou) {
		this.qtdMatou = qtdMatou;
	}

	public int getQtdMortes() {
		return qtdMorreu;
	}

	public void setQtdMortes(int qtdMortes) {
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
