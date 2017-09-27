package com.calango.common.multiply;


import com.calango.common.matrixbeans.GeneralBean;
import com.calango.common.matrixbeans.MatrixBean;
import com.calango.common.matrixbeans.MatrixResult;
import com.calango.daolayer.dao.impl.JdbcElementsDAO;
import com.calango.daolayer.dao.impl.JdbcHistoryDAO;
import com.calango.daolayer.dao.impl.JdbcMatrixDAO;
import com.calango.daolayer.model.Elements;
import com.calango.daolayer.model.History;
import com.calango.daolayer.model.Matrix;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Calango
 */
public class InsertRecord {
	
    /**
     * @param genBean bean with matrix name and user role
     * @param mxBean matrix 1 and matrix 2
     * @param result matrix result
     */
    public final void insert(final GeneralBean genBean, final MatrixBean mxBean, 
    		final MatrixResult result) {
                ApplicationContext context = 
    		new ClassPathXmlApplicationContext("spring-database.xml");
        JdbcHistoryDAO historyDAO = (JdbcHistoryDAO) context.getBean(
        		"historyDAO");
        JdbcMatrixDAO matrixDAO = (JdbcMatrixDAO) context.getBean("matrixDAO");
        JdbcElementsDAO elementsDAO = (JdbcElementsDAO) context.getBean(
        		"elementsDAO");
        Elements elements;
        History history;
        int i, j;
        //insert matrix 1
        Matrix matrix1 = new Matrix(
                1,
                1,
                genBean.getMatrixName(),
                mxBean.getRowLen1(),
                mxBean.getColumnLen1()
        );
        Matrix matrix2 = new Matrix(
                1,
                1,
                genBean.getMatrixName(),
                mxBean.getRowLen2(),
                mxBean.getColumnLen2()
        ); 
        Matrix matrix3 = new Matrix(
                1,
                1,
                genBean.getMatrixName(),
                result.getRow(),
                result.getColumn()
        );        
        matrixDAO.insertRecord(matrix1);
        //getting max matrix ID
        int maxID = matrixDAO.findIdByNameAndLen(genBean.getMatrixName(),
                mxBean.getRowLen1(), mxBean.getColumnLen1());
        //insert matrix 2
        matrixDAO.insertRecord(matrix2);
        //insert matrix 3
        matrixDAO.insertRecord(matrix3);
        //Insert Element1
        for (i = 0; i < mxBean.getRowLen1(); i++) {
                for (j = 0; j < mxBean.getColumnLen1(); j++) {
                    elements = new Elements(
                            1,
                            i,
                            j,
                            mxBean.getMatrix1().get(i)[j],
                            maxID
                    );
                    elementsDAO.insert(elements);
                }
        }
                //Insert Element2
        for (i = 0; i < mxBean.getRowLen2(); i++) {
                for (j = 0; j < mxBean.getColumnLen2(); j++) {
                    elements = new Elements(
                            1,
                            i,
                            j,
                            mxBean.getMatrix2().get(i)[j],
                            maxID + 1
                    );
                    elementsDAO.insert(elements);
                }
        }
                        //Insert Element3
        for (i = 0; i < result.getRow(); i++) {
                for (j = 0; j < result.getColumn(); j++) {
                    elements = new Elements(
                            1,
                            i,
                            j,
                            result.getMatrixResult()[i][j],
                            maxID + 2
                    );
                    elementsDAO.insert(elements);
                }
        }
        history = new History(0, maxID, maxID + 1, maxID + 2, null);
        historyDAO.insertHistory(history);   
    }
    
}