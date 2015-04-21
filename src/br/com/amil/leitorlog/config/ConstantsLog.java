package br.com.amil.leitorlog.config;

import java.util.regex.Pattern;


public class ConstantsLog {
	
	public static final String NEW_MATCH = "New match";
	public static final String MATCH = "Match";
	public static final String WORLD = "<WORLD>";
	public static final String MATCH_ENDED = "ended";
	public static final String KILLED = "killed";
	
	public static final Pattern PATTERN_IDMATCH = Pattern.compile(".*" + NEW_MATCH + " ([0-9]+).*");
	public static final Pattern PATTERN_KILL = Pattern.compile("([a-zA-Z0-9<?>?]+) " + 
														KILLED + " ([a-zA-Z0-9]+) ([a-zA-Z]+) ([a-zA-Z0-9]+).*");
	
	public static final Pattern PATTERN_END = Pattern.compile(MATCH +  " ([0-9]+) .*");
	
	/*
	23/04/2013 15:36:04 - Roman killed Nick using M16
    23/04/2013 15:36:33 - <WORLD> killed Nick by DROWN
    23/04/2013 15:39:22 - Match 11348965 has ended
*/
}
