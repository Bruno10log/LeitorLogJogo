package br.com.bruno.leitorlog.view;

import java.util.List;

import br.com.bruno.leitorlog.dao.RankingDao;
import br.com.bruno.leitorlog.model.Ranking;
import br.com.bruno.leitorlog.model.RankingPartida;

public class ShowRanking {

	
	public void montaRanking() {
		
		RankingDao objDao = new RankingDao();
		
		List<RankingPartida> listaRanking = objDao.getRanking();
		
		System.out.println("---------------------------- RANKING DA PARTIDA ------------------------------------");
		System.out.println("LUGAR           |           JOGADOR           |   Matou  |  Foi Morto  |   Pontos   ");
		
		
		String saida = "";
		
		for(RankingPartida objRanking : listaRanking) {
			saida = "0         "  + objRanking.getUser() + 
					objRanking.getQtdAssassinatos()  + objRanking.getQtdMortes() + objRanking.getPontos() ;
			System.out.println(saida);
		}
		
	}
}
