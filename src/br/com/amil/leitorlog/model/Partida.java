package br.com.amil.leitorlog.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Partida {
	
	@Id 
	private long idPartida;
	@Temporal(value = TemporalType.DATE)
	private Date data;
	@Temporal(value = TemporalType.TIME)
	private Date horaInicio;
	@Temporal(value = TemporalType.TIME)
	private Date horaFim;

	public Partida() {
	}

	public Partida(long idPartida,Date data, Date horaInicio) {
		this.idPartida = idPartida;
		this.data = data;
		this.horaInicio = horaInicio;
	}
	
	public long getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(long idPartida) {
		this.idPartida = idPartida;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getHoraFim() {
		return horaFim;
	}
	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
