package br.com.bruno.leitorlog.file;

import java.util.EmptyStackException;

import br.com.bruno.leitorlog.config.ConstantsLog;
import br.com.bruno.leitorlog.control.LogDetail;

public class StructFile extends Struct {

	private char[] data = new char[10];
	private char[] hora = new char[8];
	private char[] separador = new char[3];
	private char[] info = new char[50];
	
	public StructFile(String linha){
		
		try {
			
			if(linha.trim().length() == 0) {
				throw new EmptyStackException();
			}
			
			data = linha.substring(0,10).toCharArray();
			hora = linha.substring(10,19).toCharArray();
			setSeparador(linha.substring(19,22).toCharArray());
			info = linha.substring(22,linha.length() ).toCharArray();
			
		} catch(NullPointerException e) {
			e.printStackTrace(); 
			throw new NullPointerException(); 
		}
		
	}
	
	public String getData() {
		return String.valueOf(data);
	}

	public void setData(String data) {
		this.data = super.formataCampo(this.data, data);
	}
	
	public String getHora() {
		return String.valueOf(hora);
	}

	public void setHora(String hora) {
		this.data = super.formataCampo(this.hora, hora);
	}
	
	public String getInfo() {
		return String.valueOf(info);
	}

	public void setInfo(String info) {
		this.data = super.formataCampo(this.info, info);
	}

	public LogDetail getType() {
		if(this.getInfo().contains(ConstantsLog.NEW_MATCH)) {
			return LogDetail.NEW_MATCH;
		} else if(this.getInfo().contains(ConstantsLog.KILLED)) {
		    return LogDetail.KILLED;
		} else if(this.getInfo().contains(ConstantsLog.MATCH_ENDED)) {
			return LogDetail.MATCH_ENDED;
		} else {
			return null;
		}
	}

	public char[] getSeparador() {
		return separador;
	}

	public void setSeparador(char[] separador) {
		this.separador = separador;
	}
	
}
