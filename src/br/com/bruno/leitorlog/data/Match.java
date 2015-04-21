package br.com.bruno.leitorlog.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import br.com.bruno.leitorlog.config.ConstantsLog;
import br.com.bruno.leitorlog.file.StructFile;

public class Match {
	
	private Date data;
	private Date hora;
	private long idMatch;
	
	public Match(StructFile objStructFile){
		
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy"); 
		SimpleDateFormat formatHour = new SimpleDateFormat("HH:mm:ss");  
		
		try {
			setData(formatDate.parse(objStructFile.getData()));
			setHora(formatHour.parse(objStructFile.getHora()));
			setIdMatch(encontrarId(objStructFile.getInfo()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public Match(){
		
	}

	private long encontrarId(String texto) {
        Matcher matcher =  ConstantsLog.PATTERN_IDMATCH.matcher(texto);
        long idMatch = 0;
 
        if(matcher.matches() && matcher.groupCount() == 1){
            idMatch = Long.parseLong(matcher.group(1));
        }
        return idMatch;
    }

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(long idMatch) {
		this.idMatch = idMatch;
	}

}
