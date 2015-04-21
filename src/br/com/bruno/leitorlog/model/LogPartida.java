package br.com.bruno.leitorlog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="LogPartida.findAll", query="select l FROM LogPartida l WHERE l.partida = :partida"),
	@NamedQuery(name="LogPartida.pesquisaQuantidadeMortes", query="SELECT COUNT(l) FROM LogPartida l " +  
                                                                "WHERE l.userVitima = :user " +
																"AND l.partida = :partida"),
																
	@NamedQuery(name="LogPartida.pesquisaQuantidadeAssassinatos", query="SELECT COUNT(l) FROM LogPartida l " + 
																	  "WHERE l.userAssassino = :user " +
																	  "AND l.partida = :partida"),
		
	@NamedQuery(name="LogPartida.pesquisaArmaFavorita", query="SELECT NEW br.com.bruno.leitorlog.consultas.ArmaFavorita(l.modeloArma, COUNT(l)) FROM LogPartida l " +
															    "WHERE l.partida = :partida " +  
															    "AND l.userAssassino = :user " +
															    "GROUP BY l.modeloArma " +
															    "ORDER BY COUNT(l) desc")
})
public class LogPartida {
	
	@ManyToOne @JoinColumn(name="idPartida")
	private Partida partida;
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idLog;
	
	@Temporal(value = TemporalType.TIME)
	private Date hora;

	private String userAssassino;
	
	private String userVitima;
	
	private String modeloArma;
	
	public LogPartida() {
	}
	
	public LogPartida(Partida partida, Date hora, String assassino, String vitima, String arma) {
		this.partida = partida;
		this.hora = hora;
		this.userAssassino = assassino;
		this.userVitima = vitima;
		this.modeloArma = arma;
	}
	
	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public String getUserAssassino() {
		return userAssassino;
	}

	public void setUserAssassino(String userAssassino) {
		this.userAssassino = userAssassino;
	}

	public String getUserVitima() {
		return userVitima;
	}

	public void setUserVitima(String userVitima) {
		this.userVitima = userVitima;
	}

	public String getModeloArma() {
		return modeloArma;
	}

	public void setModeloArma(String modeloArma) {
		this.modeloArma = modeloArma;
	}
	
}
