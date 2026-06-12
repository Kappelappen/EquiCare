package com.equicare.model;

public class TrainingInfo {
	
	private int horseId;
	private String location;
	private String discipline;
	private String level;
	private String  trainer;
	
	public TrainingInfo() {}
	
	public void setHorseId(int id) {
		
		this.horseId = id;
		
	}
	
	public void setLocation(String location) {
		
		this.location = location;
		
	}
	
	public void setDiscipline(String discipline) {
		
		this.discipline = discipline;
		
	}
	
	public void setLevel(String level) {
		
		this.level = level;
		
	}
	
	public void setTrainer(String trainer) {
		
		this.trainer = trainer;
		
	}
	
	public int getHorseId() { return horseId; }
	public String getLocation() { return location; }
	public String getDiscipline() { return discipline; }
	public String getLevel() { return level; }
	public String getTrainer() { return trainer; }
	
}
