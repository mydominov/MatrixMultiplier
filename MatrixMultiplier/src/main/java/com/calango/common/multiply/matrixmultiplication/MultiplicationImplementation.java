package com.calango.common.multiply.matrixmultiplication;

import com.calango.common.matrixbeans.MatrixBean;
import com.calango.common.matrixbeans.MatrixResult;

/**
 *
 * @author Calango
 */
public class MultiplicationImplementation {
    /**
     * 
     */
    private final int nThreads = 5;
    
    /**
     * 
     */
    private final int sleepTime = 100;
    
    /**
     * @param matrixBean 
     * @return result of multiplication
     */
    public final MatrixResult multiply(final MatrixBean matrixBean) {
        MatrixResult result = new MatrixResult();
        WorkQueue workQueue = new WorkQueue(nThreads);
        int row, column;
        result.createMatrixResult(matrixBean.getRowLen1(),
        		matrixBean.getColumnLen2());
        for (row = 0; row < matrixBean.getRowLen1(); row++) {
			for (column = 0; column < matrixBean.getColumnLen2(); column++) {
                ThreadMultiply multiplyMission = new ThreadMultiply();
                multiplyMission.setWork(row, column, matrixBean, result);
                workQueue.execute(multiplyMission); 
            }
		}
        while (!workQueue.isAllWorkDone()) {
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return result;
    }    
}
