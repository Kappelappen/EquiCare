package com.equicare.model;

public class FeedInfo {

	private int horseId;
	private String feedType;
	private String amount;
	private String supplements;
	private String notes;
	
	public FeedInfo() {}
	
	public void setHorseId(int id) {
		
		this.horseId = id;
		
	}
	
	public void setFeedType(String type) {
		
		this.feedType = type;
		
	}
	
	public void setAmount(String amount) {
		
		this.amount = amount;
		
	}
	
	public void setSupplements(String supplements) {
		
		this.supplements = supplements;
		
	}
	
	public void setNotes(String notes) {
		
		this.notes = notes;
		
	}
	
	public int getHorseId() { return horseId; }
	public String getType() { return feedType; }
	public String getAmount() { return amount; }
	public String getSupplements() { return supplements; }
	public String getNotes() { return notes; }
	
}
