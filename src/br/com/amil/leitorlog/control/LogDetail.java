package br.com.amil.leitorlog.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import br.com.amil.leitorlog.dao.LogPartidaDao;
import br.com.amil.leitorlog.dao.PartidaDao;
import br.com.amil.leitorlog.data.Acao;
import br.com.amil.leitorlog.data.Match;
import br.com.amil.leitorlog.file.StructFile;

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
			
		}
		
	},
	
	MATCH_ENDED {

		@Override
		public void saveLog(StructFile objStruct) {
			
			PartidaDao objDao = new PartidaDao();
			SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm:ss");  
		
			try {
				objDao.finalizar(formatHour.parse(objStruct.getHora()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	
}
