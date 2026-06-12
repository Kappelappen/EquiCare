package com.equicare.dao;

import javax.swing.DefaultListModel;

import com.equicare.model.ComboItem;
import com.equicare.model.Horse;

public interface ListDAO {
    
    java.util.List<ComboItem> findComboItems(String tableName);

    void saveAll(DefaultListModel<ComboItem> model,
    String tableName);

}
