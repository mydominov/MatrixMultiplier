package com.calango.common.multiply.matrixmultiplication;

import com.calango.common.matrixbeans.MatrixBean;
import com.calango.common.matrixbeans.MatrixResult;

/**
 *
 * @author Calango
 */
public class Multiplying {
	
    /**
     * @param row
     * @param column
     * @param matrixBean
     * @param mxRes
     */
    public final void multyply(final int row, final int column, 
    		final MatrixBean matrixBean, final MatrixResult mxRes) {
        int i;
        for (i = 0; i < matrixBean.getColumnLen1(); i++) {
            mxRes.setMatrixResult(row, column,
                matrixBean.getMatrix1().get(row)[i] 
                		* matrixBean.getMatrix2().get(i)[column]);
        }
    }
    
}
