package com.calango.common.multiply.matrixmultiplication;

import com.calango.common.matrixbeans.MatrixBean;
import com.calango.common.matrixbeans.MatrixResult;

/**
 *
 * @author Calango
 */
public class ThreadMultiply implements Runnable {
    /**
     * 
     */
    private int rowID;
    /**
     * 
     */
    private int columnID;
    /**
     * 
     */
    private MatrixBean matrixBean;
    /**
     * 
     */
    private MatrixResult mxRes;
    
    /**
     * @param row
     * @param column
     * @param matrixBean
     * @param mxRes
     */
    public final void setWork(final int row, final int column, 
    		final MatrixBean matrixBean, final MatrixResult mxRes) {
        rowID = row;
        columnID = column;
        this.matrixBean = matrixBean;
        this.mxRes = mxRes;
    }
        
    @Override
		public final synchronized void run() { 
            Multiplying multiplying = new Multiplying();
            multiplying.multyply(rowID, columnID, matrixBean, mxRes);
        }
}
