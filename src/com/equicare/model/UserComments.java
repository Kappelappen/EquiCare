package com.equicare.model;

public class UserComments {
	
	private int horseId;
	private String comments;
	
	public UserComments() {}
	
	public void setHorseId(int id) {
		
		this.horseId = id;
		
	}
	
	public void setUserComments(String comments) {
		
		this.comments = comments;
		
	}
	
	public int getHorseId() { return horseId; }
	public String getComments() { return comments; }

}
