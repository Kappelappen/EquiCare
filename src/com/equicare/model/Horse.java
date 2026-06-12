package com.equicare.model;

public class Horse {

	private int id;
	private String name;
	private String breed;
	private String gender;
	private String birthdate;
	private String color;
	private String height;
	private String weight;
	private String status;
	
	public Horse() {}
	
	public void setId(int id) {
		
		this.id = id;
		
	}
	
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setBreed(String breed) {
		
		this.breed = breed;
		
	}
	
	public void setGender(String gender) {
		
		this.gender = gender;
		
	}
	
	public void setBirthdate(String birthdate) {
		
		this.birthdate = birthdate;
		
	}
	
	public void setColor(String color) {
		
		this.color = color;
		
	}
	
	public void setHeight(String height) {
		
		this.height = height;
		
	}
			
	public void setWeight(String weight) {
		
		this.weight = weight;
		
	}
	
	public void setStatus(String status) {
		
		this.status = status;
		
	}
	
	public int getId() { return id; }
	public String getName() { return name; }
	public String getBreed() { return breed; }
	public String getGender() { return gender; }
	public String getBirthdate() { return birthdate; }
	public String getColor() { return color; }
	public String getHeight() { return height; }
	public String getWeight() { return weight; }
	public String getStatus() { return status; }
	
	@Override
	public String toString() { return name; }
	
	@Override
	public boolean equals(Object obj) {

	    if (this == obj) return true;

	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }

	    Horse other = (Horse) obj;
	    return name.equals(other.name);
	
	}
		
}
