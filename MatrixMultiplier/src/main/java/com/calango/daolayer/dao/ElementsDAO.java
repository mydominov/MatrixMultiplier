package com.calango.daolayer.dao;

import com.calango.daolayer.model.Elements;

/**
 *
 * @author Calango
 */
public interface ElementsDAO {
	
    /**
     * @param id
     * @return
     */
    Object findByID(int id);
    
    /**
     * @param matrixID
     * @param rowID
     * @param columnID
     * @return
     */
    int getValue(int matrixID, int rowID, int columnID);
    
    /**
     * @param insertObject
     */
    void insert(Elements insertObject);
    
}
