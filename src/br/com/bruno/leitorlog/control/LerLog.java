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
	
	public static void main(String[] args) {
		String log = "23/04/2013 15:34:22 - New match 11348969 has started";
		StructFile objFile = new StructFile(log);
		processarInfo(objFile);
		
		log = "23/04/2013 15:36:04 - Roman killed Nick using M16";
		objFile = new StructFile(log);
		processarInfo(objFile);
		
		log = "23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN";
		objFile = new StructFile(log);
		processarInfo(objFile);
		
		log = "23/04/2013 15:36:40 - Nick killed Roman using M16";
		objFile = new StructFile(log);
		processarInfo(objFile);
		
		log = "23/04/2013 15:36:40 - Nick killed Bruno using M16";
		objFile = new StructFile(log);
		processarInfo(objFile);
		
		log = "23/04/2013 15:36:40 - Bruno killed Nick using M16";
		objFile = new StructFile(log);
		processarInfo(objFile);
		
		log = "23/04/2013 15:36:40 - Nick killed Bruno using M16";
		objFile = new StructFile(log);
		processarInfo(objFile);
		
		log = "23/04/2013 15:36:40 - Nick killed Roman using M16";
		objFile = new StructFile(log);
		processarInfo(objFile);
		
		log = "23/04/2013 15:36:40 - Nick killed Roman using M16";
		objFile = new StructFile(log);
		processarInfo(objFile);
		
		log = "23/04/2013 15:39:22 - Match 11348969 has ended";
		objFile = new StructFile(log);
		processarInfo(objFile);
		
	}
		
	public static void processarInfo(StructFile objFile) {
		objFile.getType().saveLog(objFile);	
	}
	
}
