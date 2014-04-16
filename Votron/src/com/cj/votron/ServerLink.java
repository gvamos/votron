package com.cj.votron;

public class ServerLink {
	
	static ServerLink instance = new ServerLink();
	public static ServerLink getInstance(){ return instance; }
	
	String getText(String uri){
		return "uri foo ";
	}
}
