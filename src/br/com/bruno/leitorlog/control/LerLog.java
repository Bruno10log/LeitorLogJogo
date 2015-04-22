package br.com.bruno.leitorlog.control;

import java.io.File;
import java.util.Scanner;

import br.com.bruno.leitorlog.file.StructFile;

public class LerLog {

	public void ler(File arquivo) {
	   Scanner objScan = null;     
	   try { 
	      objScan = new Scanner(arquivo);
	      StructFile objFile;
	      while (objScan.hasNextLine()) {  
	         objFile = new StructFile(objScan.nextLine());    
	         processarInfo(objFile);     
	      }
	   }
	   catch (Exception e) {  
	      throw new RuntimeException("Impossível ler o arquivo.", e);  
	   } finally {  
	      objScan.close();  
	   } 
	  
	}
	
	private static void processarInfo(StructFile objFile) {
		objFile.getType().saveLog(objFile);	
	}
	
}
