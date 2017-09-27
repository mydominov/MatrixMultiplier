package com.calango.common.history;

/**
 *
 * @author Calango
 */
public class HistoryMatrixStorage {
    /**
     * 
     */
    private String matrixName = null;
    /**
     * 
     */
    private int[][] matrix1 = null; 
    /**
     * 
     */
    private int[][] matrix2 = null; 
    /**
     * 
     */
    private int[][] matrixResult = null;
    
    /**
     * @param matrixName name of the matrix
     * @param matrix1 first matrix
     * @param matrix2 second matrix
     * @param matrixResult result
     */
    HistoryMatrixStorage(final String matrixName, final int[][] matrix1, 
    		final int[][] matrix2, final int[][] matrixResult){
        this.matrixName = matrixName;
        this.matrix1 = matrix1;
        this.matrix2 = matrix2;
        this.matrixResult = matrixResult;
    }
            
    /**
     * @return matrix name
     */
    public final String getMatrixName() {
        return matrixName;
    }

    /**
     * @param matrixName matrix name
     */
    public final void setMatrixName(final String matrixName) {
        this.matrixName = matrixName;
    }

    /**
     * @return matrix 1
     */
    public final int[][] getMatrix1() {
        return matrix1;
    }

    /**
     * @param matrix1 first matrix
     */
    public final void setMatrix1(final int[][] matrix1) {
        this.matrix1 = matrix1;
    }

    /**
     * @return matrix 2
     */
    public final int[][] getMatrix2() {
        return matrix2;
    }

    /**
     * @param matrix2 second matrix
     */
    public final void setMatrix2(final int[][] matrix2) {
        this.matrix2 = matrix2;
    }

    /**
     * @return result
     */
    public final int[][] getMatrixResult() {
        return matrixResult;
    }

    /**
     * @param matrixResult result
     */
    public final void setMatrixResult(final int[][] matrixResult) {
        this.matrixResult = matrixResult;
    }
}
