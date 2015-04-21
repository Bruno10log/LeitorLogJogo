package br.com.bruno.leitorlog.consultas;

public class ArmaFavorita {
	
	private String armaFavorita;
	private long qtdMortes;
	
	public ArmaFavorita(String armaFavorita, long qtdMortes) {
		this.armaFavorita = armaFavorita;
		this.qtdMortes = qtdMortes;
	}
	
	public String getArmaFavorita() {
		return armaFavorita;
	}
	
	public void setArmaFavorita(String armaFavorita) {
		this.armaFavorita = armaFavorita;
	}
	
	public long getQtdMortes() {
		return qtdMortes;
	}
	
	public void setQtdMortes(long qtdMortes) {
		this.qtdMortes = qtdMortes;
	}
}
