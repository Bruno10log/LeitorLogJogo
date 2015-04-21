package br.com.bruno.leitorlog.view;

import java.io.File;

import br.com.bruno.leitorlog.control.LerLog;

public class Main {
	
	public static void main(String[] args) {
		
		System.out.println("------------------  Leitor do log do Jogo ---------------------");
		
		File objFile = new File("Jogo.txt");
		LerLog objler = new LerLog();
		ShowRanking objShow = new ShowRanking();
		
		objler.ler(objFile);
		objShow.montaRanking();
		
		
	}
}
