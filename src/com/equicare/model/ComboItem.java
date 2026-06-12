package com.equicare.model;

public class ComboItem implements Comparable<ComboItem> {

    private int id;
    private String name;

    public ComboItem() {}
    
    public void setId(int id) {
    	
    	this.id = id;
    	
    }
    
    public void setName(String name) {
    	
    	this.name = name;
    	
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(ComboItem other) {

        if (other == null ||
            other.getName() == null) {

            return 1;
        }

        return this.name.compareToIgnoreCase(
            other.getName()
        );
    }
    
    @Override
	public boolean equals(Object obj) {

	    if (this == obj) return true;

	    if (getName() == null || obj == null || 
	    	getClass() != obj.getClass()) {
	        return false;
	    }

	    ComboItem other = (ComboItem) obj;
	    return name.equals(other.name);
	
	}
}