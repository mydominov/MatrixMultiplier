package com.calango.daolayer.dao;

import com.calango.daolayer.model.Matrix;

/**
 *
 * @author Calango
 */
public interface MatrixDAO {
	
    /**
     * @param id
     * @return
     */
    Matrix findByID(int id);
    
    /**
     * @param matrixId
     * @return
     */
    String findMatrixNameById(int matrixId);
    
    /**
     * @param inserObject
     */
    void insertRecord(Matrix inserObject);
    
    /**
     * @param matrixName
     * @param row
     * @param column
     * @return
     */
    int findIdByNameAndLen(String matrixName, int row, int column);
    
}
