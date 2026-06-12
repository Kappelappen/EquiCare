package com.equicare.model;

public class HorseNode {

	private String name;
	private String key;
	
	public HorseNode(String name, String key) {
		
		this.name = name;
		this.key = key;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setKey(String key) {
		
		this.key = key;
		
	}
	
	public String getName() { return name; }
	public String getKey() { return key; }
	
	@Override
	public String toString() { return name; }
		
}
