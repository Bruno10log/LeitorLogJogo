package br.com.bruno.leitorlog.consultas;

import br.com.bruno.leitorlog.model.Partida;
import br.com.bruno.leitorlog.model.Ranking;

public class RankingPartida extends Ranking {

	private long pontos;
	private int awards;
	
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

	public int getAwards() {
		return awards;
	}

	public void setAwards(int awards) {
		this.awards = awards;
	}
	
}
