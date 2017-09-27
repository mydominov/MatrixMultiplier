package com.calango.daolayer.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Calango
 */
@Entity
@Table(name = "matrix")
public class Matrix implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @Id
    @Column(name = "matrix_id", nullable = false)   
    private int matrixId;
    /**
     * 
     */
    @Column(name = "user_id")
    private int userId;
    /**
     * 
     */
    @Column(name = "matrix_name")        
    private String matrixName;
    /**
     * 
     */
    @Column(name = "matrix_row")
    private int matrixRow;
    /**
     * 
     */
    @Column(name = "matrix_column")
    private int matrixColumn;
    
    /**
     * 
     */
    public Matrix() { }
    
    /**
     * @param matrixId
     * @param userId
     * @param matrixName
     * @param matrixRow
     * @param matrixColumn
     */
    public Matrix(final int matrixId, final int userId, 
    		final String matrixName, final int matrixRow,
                    final int matrixColumn){
        this.matrixId = matrixId;
        this.userId = userId;
        this.matrixName = matrixName;
        this.matrixRow = matrixRow;
        this.matrixColumn = matrixColumn;
    }

    /**
     * @return
     */
    public final int getMatrixId() {
        return matrixId;
    }

    /**
     * @return
     */
    public final int getUserId() {
        return userId;
    }

    /**
     * @return
     */
    public final String getMatrixName() {
        return matrixName;
    }

    /**
     * @param matrixId
     */
    public final void setMatrixId(final int matrixId) {
        this.matrixId = matrixId;
    }

    /**
     * @param userId
     */
    public final void setUserId(final int userId) {
        this.userId = userId;
    }

    /**
     * @param matrixName
     */
    public final void setMatrixName(final String matrixName) {
        this.matrixName = matrixName;
    }

    /**
     * @return
     */
    public final int getMatrixRow() {
        return matrixRow;
    }

    /**
     * @param matrixRow
     */
    public final void setMatrixRow(final int matrixRow) {
        this.matrixRow = matrixRow;
    }

    /**
     * @return
     */
    public final int getMatrixColumn() {
        return matrixColumn;
    }

    /**
     * @param matrixColumn
     */
    public final void setMatrixColumn(final int matrixColumn) {
        this.matrixColumn = matrixColumn;
    }

}
