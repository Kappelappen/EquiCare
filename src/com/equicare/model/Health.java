package com.equicare.model;

public class Health {

	private int horseId;
	private String veterinarian;
	private String allergies;
	private String conditions;
	private String vaccinationStatus;
	private String lastCheckup;
	
	public Health() {}
	
	public void setHorseId(int id) {
		
		this.horseId = id;
		
	}
	
	public void setVeterinarian(String veterinarian) {
		
		this.veterinarian = veterinarian;
		
	}
	
	public void setAllergies(String allergies) {
		
		this.allergies = allergies;
		
	}
	
	public void setConditions(String conditions) {
		
		this.conditions = conditions;
		
	}	
	
	public void setVaccinationStatus(String status) {
		
		this.vaccinationStatus = status;
		
	}
	
	public void setLastCheckup(String checkUp) {
		
		this.lastCheckup = checkUp;
		
	}
	
	public int getHorseId() { return horseId; }
	public String getVeterinarian() { return veterinarian; }
	public String getAllergies() { return allergies; }
	public String getConditions() { return conditions; }
	public String getVaccinationStatus() { return vaccinationStatus; }
	public String getLastCheckup() { return lastCheckup; }
	
}
