package com.equicare.model;

public class Stable {
	
	private int horseId;
	private String name;
	private String stableBox;
	private String arrivalDate;
	private String owner;
	private String emergencyContact;
	
	public Stable() {}
	
	public void setHorseId(int horseId) {
		
		this.horseId = horseId;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setStableBox(String box) {
		
		this.stableBox = box;
		
	}
	
	public void setArrivalDate(String date) {
		
		this.arrivalDate = date;
		
	}
	
	public void setOwner(String owner) {
		
		this.owner = owner;
	
	}
	
	public void setEmergencyContact(String contact) {
		
		this.emergencyContact = contact;
		
	}
	
	public int getHorseId() { return horseId; }
	public String getName() { return name; }
	public String getBox() { return stableBox; }
	public String getArrivalDate() { return arrivalDate; }
	public String getOwner() { return owner; }
	public String getEmergencyContact() { return emergencyContact; }
	
}
