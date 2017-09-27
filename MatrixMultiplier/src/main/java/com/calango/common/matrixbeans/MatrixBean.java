package com.calango.common.matrixbeans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Calango
 */
public class MatrixBean {
    /**
     * 
     */
    private final List<int[]> matrix1 = new ArrayList<>();
    /**
     * 
     */
    private final List<int[]> matrix2 = new ArrayList<>();
    /**
     * 
     */
    private int rowLen1;
    /**
     * 
     */
    private int rowLen2;
    /**
     * 
     */
    private int columnLen1;
    /**
     * 
     */
    private int columnLen2;

    /**
     * @return
     */
    public List<int[]> getMatrix1() {
        return matrix1;
    }

    /**
     * @param matrix1String
     */
    public void setMatrix1(int[] matrix1String) {
        this.matrix1.add(matrix1String);
    }

    /**
     * @return
     */
    public List<int[]> getMatrix2() {
        return matrix2;
    }

    /**
     * @param matrix2String
     */
    public void setMatrix2(int[] matrix2String) {
        this.matrix2.add(matrix2String);
    }
    
    /**
     * 
     */
    public void setMcesLength(){
        rowLen1 = matrix1.size();
        columnLen1 = matrix1.get(0).length;
        rowLen2 = matrix2.size();
        columnLen2 = matrix2.get(0).length;
    }

    /**
     * @return
     */
    public int getRowLen1() {
        return rowLen1;
    }

    /**
     * @return
     */
    public int getRowLen2() {
        return rowLen2;
    }

    /**
     * @return
     */
    public int getColumnLen1() {
        return columnLen1;
    }

    /**
     * @return
     */
    public int getColumnLen2() {
        return columnLen2;
    }
    
    
}
