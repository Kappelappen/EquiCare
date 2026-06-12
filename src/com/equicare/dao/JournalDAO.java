package com.equicare.dao;

import com.equicare.model.Category;
import com.equicare.model.Horse;
import com.equicare.model.JournalEntry;

public interface JournalDAO {
	
	public java.util.List<Category> findCategories();
	public void writeEntry(int horseId, JournalEntry entry);
	public java.util.List<JournalEntry> findAll(int id);
	public java.util.List<JournalEntry> findEntries();
	public JournalEntry findById(int id);
	public Horse findHorse(int id);
	public void updateEntry(int id, JournalEntry entry);
	public void deleteJournal(int id);

}
