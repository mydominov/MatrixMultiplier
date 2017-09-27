package com.calango.daolayer.dao;

import com.calango.daolayer.model.History;
import java.util.List;

/**
 *
 * @author Calango
 */
public interface HistoryDAO {
	
    /**
     * @param id
     * @return
     */
    History findByID(int id);
    
    /**
     * @param date
     * @return
     */
    int findIdByDate(String date);
    
    /**
     * @return
     */
    List<String> getDatesList();
    
    /**
     * @param insertObject
     */
    void insertHistory(History insertObject);
    
}