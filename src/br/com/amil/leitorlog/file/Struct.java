package br.com.amil.leitorlog.file;
import java.util.ArrayList;


public class Struct {
	
	ArrayList<String> struct = new ArrayList<String>();
	
	public char[] formataCampo(char[] campo, String conteudo){
	
		if (conteudo.length() > campo.length){
			campo = conteudo.substring(0, campo.length).toCharArray();
		}else{
	 	campo = String.format("%-" + campo.length + "s", conteudo).toCharArray(); 	 
		}
		return campo;
		
	}
	
	public String toString(){
		
		String linha = "";
		
		for(String campo: this.struct){
			linha += campo;
		}
		
		return linha;
	}
	

	
	
}
