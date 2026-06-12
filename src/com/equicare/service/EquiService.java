package com.equicare.service;

import com.equicare.dao.HorseDAO;
import com.equicare.dao.HorseDAOImpl;
import com.equicare.dao.ListDAO;
import com.equicare.dao.ListDAOImpl;
import com.equicare.dao.JournalDAO;
import com.equicare.dao.JournalDAOImpl;
import com.equicare.databasse.DataBank;
import com.equicare.model.Category;
import com.equicare.model.ComboItem;
import com.equicare.model.FeedInfo;
import com.equicare.model.Health;
import com.equicare.model.Horse;
import com.equicare.model.Identification;
import com.equicare.model.JournalEntry;
import com.equicare.model.Stable;
import com.equicare.model.TrainingInfo;
import com.equicare.model.UserComments;

import java.sql.Connection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EquiService {

    public final DataBank dataBank;
    public final Connection connection;

    private final ListDAO listDAO;
    public final JournalDAO journalDAO;
    public final HorseDAO horseDAO;
    
    public EquiService(DataBank dataBank) {

        this.dataBank = dataBank;
        
        this.connection = dataBank.getConnection();
        this.listDAO = new ListDAOImpl(connection);
        this.journalDAO = new JournalDAOImpl(connection);
        this.horseDAO = new HorseDAOImpl(connection);
        
    }
    
    public void saveHorseInfo(Horse horse,
        Identification identification, Stable stable,
        Health health, FeedInfo feeding,
        TrainingInfo training,
        UserComments comments) {
    	
      	int horseId = horse.getId();
	       	
       	identification.setHorseId(horseId);
       	stable.setHorseId(horseId);
       	health.setHorseId(horseId);
       	feeding.setHorseId(horseId);
       	training.setHorseId(horseId);
       	comments.setHorseId(horseId);
	        
       	horseDAO.saveIdentification(identification);
       	horseDAO.saveStable(stable);
       	horseDAO.saveHealth(health);
       	horseDAO.saveFeeding(feeding);
       	horseDAO.saveTraining(training);
       	horseDAO.saveComments(comments);
    	
    }
    
    public void updateHorseInfo(int currentRow, 
    	Horse horse, Identification identification, Stable stable,
        Health health, FeedInfo feeding,TrainingInfo training,
        UserComments comments) {
        	
	 	this.horseDAO.updateHorse(currentRow, horse);
	  	this.horseDAO.updateIdentification(currentRow, identification);
	   	this.horseDAO.updateStable(currentRow, stable);
	   	this.horseDAO.updateFeeding(currentRow, feeding);
	   	this.horseDAO.updateTraining(currentRow, training);
	   	this.horseDAO.updateComments(currentRow, comments);
	    	
    }
    
    public Horse findHorse(int id) {
    	
    	Horse horse = horseDAO.findById(id);
    	return horse;
    	
    }
    
    public Horse findJournalHorse(int id) {
    	
    	Horse horse = journalDAO.findHorse(id);
    	return horse;
    	
    }
    
    public java.util.List<JournalEntry> findEntries(int id) {
    	
    	java.util.List<JournalEntry> entries = journalDAO.findAll(id);    	
    	return entries;
    	
    }
    
    public JournalEntry findJournal(int id) {
    	
    	JournalEntry entry = journalDAO.findById(id);   
    	    	
    	return entry;
    	    	
    }
    
    public void doDeleteHorse(int currentRow) {
    	
    	if (currentRow != -1) {
    	
    		this.horseDAO.deleteHorse(currentRow);
    	
    	}
    }
    
    public boolean validateHorse(Horse horse) {

    	boolean result = true;
    	
        if (horse == null) {
            
        	String msg = "Horse object is null";
        	JOptionPane.showMessageDialog(new JFrame(), msg);
        	result = false;
        	
        }

        if (horse.getName() == null || 
        	horse.getName().trim().isEmpty()) {

        	String msg = "Horse name is required";
        	JOptionPane.showMessageDialog(new JFrame(), msg);        	
            result = false;
        	
        }

        if (horse.getBreed() == null) {

            String msg = "Breed must be selected";
            JOptionPane.showMessageDialog(new JFrame(), msg);
            result = false;;
            
        }
        
        return result;
        
    }
    
    public void insertComboItems(DefaultListModel<ComboItem> model,
        String tableName) {

        if (model.getSize() != 0) {

        	this.listDAO.saveAll(model, tableName);
            
        }
    }
    
    public void saveEntry(int horseId, JournalEntry entry) {
    	
    	this.journalDAO.writeEntry(horseId, entry);
    	
    }

    public List<ComboItem> fetchComboItems(String tableName) {

        return listDAO.findComboItems(tableName);
    
    }

    public Horse createHorse(Horse horse) {

    	validateHorse(horse);
        return horseDAO.saveHorse(horse);
    
    }
   
    public List<Horse> fetchAllHorses() {

        return horseDAO.findAll();
            
    }
    
    public List<Category> fetchAllCategories() {
    	
    	return journalDAO.findCategories();
    	
    }
    
    public java.util.List<JournalEntry> fetchSelectedEntries(int id) {
    	
    	java.util.List<JournalEntry> list = journalDAO.findAll(id);
    	
    	return list;
    	
    }
    
    public void deleteJournal(int id) {
    	
    	this.journalDAO.deleteJournal(id);
    	
    }

    public int getHorseCount() {

        String sql = "SELECT COUNT(*) FROM horses";

        try (var stmt = connection.createStatement();
             var rs = stmt.executeQuery(sql)) {

            return rs.next() ? rs.getInt(1) : 0;

        } catch (Exception e) {

            throw new RuntimeException(
                    "Failed to count horses",
                    e
            );
        }
    }

    public Connection getConnection() {
        return connection;
    }
}