package br.com.bruno.leitorlog.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.bruno.leitorlog.dao.LogPartidaDao;
import br.com.bruno.leitorlog.dao.PartidaDao;
import br.com.bruno.leitorlog.dao.RankingDao;
import br.com.bruno.leitorlog.data.Acao;
import br.com.bruno.leitorlog.data.Match;
import br.com.bruno.leitorlog.file.StructFile;

public enum LogDetail implements ILogDetail {
	
	NEW_MATCH {

		@Override
		public void saveLog(StructFile objStruct) {
			
			Match objMatch = new Match(objStruct);
			
			PartidaDao objDao = new PartidaDao();
			objDao.salvar(objMatch);	
		}
		
	},
	
	KILLED {

		@Override
		public void saveLog(StructFile objStruct) {
			Acao objAcao = new Acao(objStruct);
			
			LogPartidaDao objDao = new LogPartidaDao();
			objDao.salvar(objAcao);
			
			RankingDao objRankingDao = new RankingDao();
			objRankingDao.salvar(objAcao.getNomeAssassinado());
			objRankingDao.salvar(objAcao.getNomeAssassino());
			
		}
		
	},
	
	MATCH_ENDED {

		@Override
		public void saveLog(StructFile objStruct) {
			
			PartidaDao objDao = new PartidaDao();
			RankingDao objRankingDao = new RankingDao();
			
			SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm:ss");  
		
			try {
				objDao.finalizar(formatHour.parse(objStruct.getHora()));
				objRankingDao.atualizarRanking();
				
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
