package com.equicare.model;

public class Identification {
	
	private int horseId;
	private String chipNumber;
	private String passportNumber;
	private String registrationNumber;
	private String insuranceNumber;
	private String imagePath;
	
	public Identification() {}
	
	public void setHorseId(int id) {
		
		this.horseId = id;
		
	}
	
	public void setChipNumber(String number) {
		
		this.chipNumber = number;
		
	}
	
	public void setPassportNumber(String number) {
		
		this.passportNumber = number;
		
	}
	
	public void setRegistrationNumber(String number) {
		
		this.registrationNumber = number;
		
	}
	
	public void setInsuranceNumber(String number) {
		
		this.insuranceNumber = number;
		
	}
	
	public void setImagePath(String path) {
		
		this.imagePath = path;
		
	}
	
	public int getHorseId() { return horseId; }
	public String getChipNumber() { return chipNumber; }
	public String getPassportNumber() { return passportNumber; }
	public String getRegistrationNumber() { return registrationNumber; }
	public String getInsuranceNumber() { return insuranceNumber; }
	public String getImagePath() { return imagePath; }

}
