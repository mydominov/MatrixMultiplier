package com.calango.common.history;

import com.calango.daolayer.dao.impl.JdbcElementsDAO;
import com.calango.daolayer.dao.impl.JdbcHistoryDAO;
import com.calango.daolayer.dao.impl.JdbcMatrixDAO;
import com.calango.daolayer.model.Matrix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author calango
 *
 */
public class ShowHistory {
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
     * @param selectedDate date you need to show
     * @return matrices storage
     */
    public final HistoryMatrixStorage historyUpdate(final String selectedDate) {
        ApplicationContext context = 
    		new ClassPathXmlApplicationContext("spring-database.xml");
        JdbcHistoryDAO historyDAO = (JdbcHistoryDAO) context.getBean(
        		"historyDAO");
        JdbcMatrixDAO matrixDAO = (JdbcMatrixDAO) context.getBean("matrixDAO");
        JdbcElementsDAO elementsDAO = (JdbcElementsDAO) context.getBean(
        		"elementsDAO");
        int i, j;
        int matrixID = historyDAO.findIdByDate(selectedDate);
        Matrix mx1 = matrixDAO.findByID(matrixID);
        Matrix mx2 = matrixDAO.findByID(matrixID + 1);
        Matrix mx3 = matrixDAO.findByID(matrixID + 2);
        matrixName = mx1.getMatrixName();
        int row1 = mx1.getMatrixRow();
        int row2 = mx2.getMatrixRow();
        int row3 = mx3.getMatrixRow();
        int column1 = mx1.getMatrixColumn();
        int column2 = mx2.getMatrixColumn();
        int column3 = mx3.getMatrixColumn();
        matrix1 = new int[row1][column1];
        matrix2 = new int[row2][column2];  
        System.out.println(row1 + " " + column1);
        System.out.println(row2 + " " + column2);
        System.out.println(row3 + " " + column3);
        //Insert Matrix1
        for (i = 0; i < row1; i++) {
			for (j = 0; j < column1; j++) {
                matrix1[i][j] = elementsDAO.getValue(matrixID, i, j);
			}
		}
       //Insert Matrix2               
        matrixID++;
        for (i = 0; i < row2; i++) {
			for (j = 0; j < column2; j++) {
                matrix2[i][j] = elementsDAO.getValue(matrixID, i, j);
			}
		}
        //Insert Matrix3
        matrixResult = new int[row3][column3];
        matrixID++;
        for (i = 0; i < row3; i++) {
			for (j = 0; j < column3; j++) {
                matrixResult[i][j] = elementsDAO.getValue(matrixID, i, j);
			}
		}
        HistoryMatrixStorage storage = new HistoryMatrixStorage(
            matrixName, matrix1, matrix2, matrixResult);
        return storage;
    }       
}