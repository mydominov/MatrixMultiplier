package com.calango.daolayer.model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 *
 * @author Calango
 */
@Entity
@Table(name = "history")
public class History implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    @Id
    @Column(name = "history_id", nullable = false)        
    private int historyId;
    /**
     * 
     */
    @Column(name = "matrix1_id")
    private int matrix1Id;
    /**
     * 
     */
    @Column(name = "matrix2_id")
    private int matrix2Id;
    /**
     * 
     */
    @Column(name = "matrix_result_id")
    private int matrixResultId;
    /**
     * 
     */
    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)        
    private Timestamp date;

    /**
     * 
     */
    public History() { }
    
    /**
     * @param historyId
     * @param matrix1ID
     * @param matrix2ID
     * @param matrixResultID
     * @param date
     */
    public History(final int historyId, final int matrix1ID, 
    		final int matrix2ID, final int matrixResultID, 
    			final Timestamp date) {
        this.historyId = historyId;
        this.matrix1Id = matrix1ID;
        this.matrix2Id = matrix2ID;
        this.matrixResultId = matrixResultID;
        this.date = date;
    }

    /**
     * @return
     */
    public final int getHistoryId() {
        return historyId;
    }    
        
    /**
     * @return
     */
    public final int getMatrix1Id() {
        return matrix1Id;
    }

    /**
     * @return
     */
    public final int getMatrix2Id() {
        return matrix2Id;
    }

    /**
     * @return
     */
    public final int getMatrixResultId() {
        return matrixResultId;
    }

    /**
     * @return
     */
    public final Timestamp getDate() {
        return date;
    }

    /**
     * @param historyId
     */
    public final void setHistoryId(final int historyId) {
        this.historyId = historyId;
    }

    /**
     * @param matrix1Id
     */
    public final void setMatrix1Id(final int matrix1Id) {
        this.matrix1Id = matrix1Id;
    }

    /**
     * @param matrix2Id
     */
    public final void setMatrix2Id(final int matrix2Id) {
        this.matrix2Id = matrix2Id;
    }

    /**
     * @param matrixResultId
     */
    public final void setMatrixResultId(final int matrixResultId) {
        this.matrixResultId = matrixResultId;
    }

    /**
     * @param date
     */
    public final void setDate(final Timestamp date) {
        this.date = date;
    }
}
