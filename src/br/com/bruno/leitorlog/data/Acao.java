package br.com.bruno.leitorlog.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import br.com.bruno.leitorlog.config.ConstantsLog;
import br.com.bruno.leitorlog.file.StructFile;

public class Acao {
	
	private Date hora;
	private String nomeAssassino;
	private String nomeAssassinado;
	private String nomeArma;
	
	public Acao(StructFile objStruct) {
		
		SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm:ss");  
		
		try {
			hora = formatHour.parse(objStruct.getHora());
			setAssassinato(objStruct.getInfo());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public Date getHora() {
		return hora;
	}
	
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	public String getNomeAssassino() {
		return nomeAssassino;
	}
	
	public void setNomeAssassino(String nomeAssassino) {
		this.nomeAssassino = nomeAssassino;
	}
	
	public String getNomeAssassinado() {
		return nomeAssassinado;
	}
	
	public void setNomeAssassinado(String nomeAssassinado) {
		this.nomeAssassinado = nomeAssassinado;
	}
	
	public String getNomeArma() {
		return nomeArma;
	}
	
	public void setNomeArma(String nomeArma) {
		this.nomeArma = nomeArma;
	}
	
	private void setAssassinato(String texto) {
		
		Matcher matcher = ConstantsLog.PATTERN_KILL.matcher(texto);
		
		if(matcher.matches() && matcher.groupCount() >= 1){
	        nomeAssassino = matcher.group(1);
	        nomeAssassinado = matcher.group(2);
	        nomeArma = matcher.group(4);
	    }
	}
	
	
}
