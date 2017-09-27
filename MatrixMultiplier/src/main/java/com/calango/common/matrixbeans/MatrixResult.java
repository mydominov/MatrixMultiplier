package com.calango.common.matrixbeans;

/**
 *
 * @author Calango
 */
public class MatrixResult {
    /**
     * 
     */
    private int[][] matrixResult;
    /**
     * 
     */
    private int row;
    /**
     * 
     */
    private int column;
    
    /**
     * @param row
     * @param column
     */
    public final void createMatrixResult(final int row, final int column) {
        matrixResult = new int[row][column];
        this.row = row;
        this.column = column;
    }
    
    /**
     * @return
     */
    public final int[][] getMatrixResult() {
        return matrixResult;
    }

    /**
     * @param i
     * @param j
     * @param value
     */
    public final void setMatrixResult(final int i, final int j, final int value) {
        this.matrixResult[i][j] += value;
    }

    /**
     * @return
     */
    public final int getRow() {
        return row;
    }

    /**
     * @return
     */
    public final int getColumn() {
        return column;
    }
    
}
