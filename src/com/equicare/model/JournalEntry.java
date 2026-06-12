package com.equicare.model;

public class JournalEntry {
	
	private int id;
	private int horseId;
	private String name;
	private String breed;
	private String date;
	private String category;
	private String headline;
	private String notes;

	public JournalEntry() {}
	
	public void setId(int id) {
		
		this.id = id;
		
	}
	
	public void setHorseId(int id) {
		
		this.horseId = id;
		
	}
		
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public void setBreed(String breed) {
		
		this.breed = breed;
		
	}
	
	public void setDate(String date) {
		
		this.date = date;
		
	}
	
	public void setCategory(String category) {
		
		this.category = category;
		
	}
	
	public void setHeadline(String headline) {
		
		this.headline = headline;
		
	}
	
	public void setNotes(String notes) {
		
		this.notes = notes;
		
	}
	
	public int getId() { return id; }
	public int getHorseId() { return horseId; }
	public String getName() { return name; }
	public String getBreed() { return breed; }
	public String getDate() { return date; }
	public String getCategory() { return category; }
	public String getHeadline() { return headline; }
	public String getNotes() { return notes; }
	
	@Override
	public String toString() { return category.toString(); }
	
	@Override
	public boolean equals(Object obj) {

	    if (this == obj) return true;

	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }

	    JournalEntry other = (JournalEntry) obj;
	    return name.equals(other.name);
	
	}
	
}
