package br.com.bruno.leitorlog.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import br.com.bruno.leitorlog.control.LerLog;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("------------------  Leitor do log do Jogo ---------------------");
		
		Properties objProp = new Properties();
		FileInputStream objFileInp = new FileInputStream("leitor.properties");
		objProp.load(objFileInp);
		
		File objFile = new File(objProp.getProperty("prop.file").toString());
		
		if(!objFile.exists()) {
			System.out.println("Arquivo não encontrado, verifique o arquivo de properties");
			throw new FileNotFoundException();
		}
		
		LerLog objler = new LerLog();
		ShowRanking objShow = new ShowRanking();
		
		objler.ler(objFile);
		objShow.montaRanking();
	
	}
	
}
