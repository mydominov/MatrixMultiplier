package com.calango.daolayer.model;

/**
 *
 * @author Calango
 */
public class Elements {
	
    /**
     * 
     */
    private int elementId;
    /**
     * 
     */
    private int rowId;
    /**
     * 
     */
    private int columnId;
    /**
     * 
     */
    private int value;
    /**
     * 
     */
    private int matrixId;
    
    /**
     * 
     */
    public Elements() { }
    
    /**
     * @param elementId
     * @param rowID
     * @param columnID
     * @param value
     * @param matrixID
     */
    public Elements(final int elementId, final int rowID, 
    		final int columnID, final int value, final int matrixID) {
        this.elementId = elementId;
        this.rowId = rowID;
        this.columnId = columnID;
        this.value = value;
        this.matrixId = matrixID;
    }

    /**
     * @return
     */
    public final int getElementId() {
        return elementId;
    }
    
    /**
     * @return
     */
    public final int getRowId() {
        return rowId;
    }

    /**
     * @return
     */
    public final int getColumnId() {
        return columnId;
    }

    /**
     * @return
     */
    public final int getValue() {
        return value;
    }

    /**
     * @return
     */
    public final int getMatrixId() {
        return matrixId;
    }

    /**
     * @param elementId
     */
    public final void setElementId(final int elementId) {
        this.elementId = elementId;
    }

    /**
     * @param rowId
     */
    public final void setRowId(final int rowId) {
        this.rowId = rowId;
    }

    /**
     * @param columnId
     */
    public final void setColumnId(final int columnId) {
        this.columnId = columnId;
    }

    /**
     * @param value
     */
    public final void setValue(final int value) {
        this.value = value;
    }

    /**
     * @param matrixId
     */
    public final void setMatrixId(final int matrixId) {
        this.matrixId = matrixId;
    }  
}
