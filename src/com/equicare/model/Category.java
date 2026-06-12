package com.equicare.model;

public class Category {

	private int id;
	private String name;
	
	public Category() {}
	
	public void setId(int id) {
		
		this.id = id;
		
	}
		
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	public int getId() { return id; }
	public String getName() { return name; }
	
	@Override
	public String toString() {
		
		return name;
		
	}
	
	@Override
	public boolean equals(Object obj) {

	    if (this == obj) return true;

	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }

	    Category other = (Category) obj;
	    return name.equals(other.name);
	
	}
	
}
