package br.com.bruno.leitorlog.view;

import java.util.List;

import br.com.bruno.leitorlog.consultas.ArmaFavorita;
import br.com.bruno.leitorlog.consultas.RankingPartida;
import br.com.bruno.leitorlog.dao.LogPartidaDao;
import br.com.bruno.leitorlog.dao.PartidaDao;
import br.com.bruno.leitorlog.dao.RankingDao;

public class ShowRanking {
	
	public void montaRanking() {
		
		RankingDao objDao = new RankingDao();
		
		List<RankingPartida> listaRanking = objDao.getRanking();
		
		
		System.out.println("---------------------------- RANKING DA PARTIDA : " + PartidaDao.objPartida.getIdPartida() + " ------------------------------------");
		System.out.println("LUGAR              |JOGADOR            |Matou              |Foi Morto          |Pontos              |Awards             ");
		
		
		String saida = "";
		int lugar =  1;
		for(RankingPartida objRanking : listaRanking) {
			saida = formataCampo(String.valueOf(lugar)) + 
					formataCampo(objRanking.getUser()) +  
					formataCampo(objRanking.getQtdAssassinatos() + "x") +
					formataCampo(objRanking.getQtdMortes() + "x") +
					formataCampo(String.valueOf(objRanking.getPontos())) +
					formataCampo(String.valueOf(objRanking.getAwards()));
			System.out.println(saida);
			lugar++;
		}
		
		montaInfoAdicional(listaRanking);
		
	}
	
	public void montaInfoAdicional(List<RankingPartida> listaRanking) {
		
		LogPartidaDao objLDao = new LogPartidaDao();
		RankingPartida objCampeao = listaRanking.get(0);
		ArmaFavorita objArma = null;
		objArma = objLDao.getArmaFavorita(objCampeao.getUser());
		
		System.out.println("\n---------------- ARMA FAVORITA DO CAMPEÃO -----------------------");
		System.out.println("Modelo             |Mortes");
		System.out.println(formataCampo(objArma.getArmaFavorita()) + formataCampo(objArma.getQtdMortes() + "")); 
		
		System.out.println("\n---------------- STREAK --------------------------");
		System.out.println(objLDao.maiorSequenciaDeMortes());
		
	}
	
	public String formataCampo(String conteudo){
		
		String retorno;
		if (conteudo.length() > 20){
			retorno = conteudo.substring(0, 20);
		}else{
			retorno = String.format("%-" + 20 + "s", conteudo); 	 
		}
		
		return retorno;
		
	}
}
