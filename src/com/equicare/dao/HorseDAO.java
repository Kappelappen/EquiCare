package com.equicare.dao;

import com.equicare.model.FeedInfo;
import com.equicare.model.Health;
import com.equicare.model.Horse;
import com.equicare.model.Identification;
import com.equicare.model.Stable;
import com.equicare.model.TrainingInfo;
import com.equicare.model.UserComments;

public interface HorseDAO {

	public Horse saveHorse(Horse horse);
	public void saveIdentification(Identification id);
    public void saveStable(Stable stable);
    public void saveHealth(Health health);
    public void saveTraining(TrainingInfo training);
    public void saveFeeding(FeedInfo feeding);
    public void saveComments(UserComments uc);
    public void deleteHorse(int currentRow);
    public java.util.List<Horse> findAll();
    public Horse findById(int id);
    
    public void updateHorse(int currentRow, Horse horse);
	public void updateIdentification(int currentRow, Identification id);
	public void updateStable(int currentRow, Stable stable);
	public void updateFeeding(int currentRow, FeedInfo info);
	public void updateTraining(int currentRow, TrainingInfo training);
	public void updateComments(int currentRow, UserComments comments);
    
	
}
