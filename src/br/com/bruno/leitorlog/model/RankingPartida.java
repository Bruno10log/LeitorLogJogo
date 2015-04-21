package br.com.bruno.leitorlog.model;

public class RankingPartida extends Ranking {

	private long pontos;
	
	public RankingPartida(Partida partida, String user, long qtdMatou, long qtdMorreu, long pontos){
		super(partida, user, qtdMatou, qtdMorreu);
		this.pontos = pontos;
	}

	public long getPontos() {
		return pontos;
	}

	public void setPontos(long pontos) {
		this.pontos = pontos;
	}
	
}
