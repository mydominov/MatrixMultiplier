package com.calango.common.multiply;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calango.common.matrixbeans.MatrixBean;

/**
 *
 * @author Calango
 */
public class MatrixReader {
	
    /**
     * @param request http request
     * @param response http responce
     * @return Matrix request => Matrix bean
     * @throws ArrayStoreException exception
     */
    public final MatrixBean readFromTextArea(
            final HttpServletRequest request, 
            final HttpServletResponse response) throws ArrayStoreException {
        MatrixBean matrixBean = new MatrixBean();
        String matrixLines1, matrixLines2;
        matrixLines1 = request.getParameter("matrix1");
        matrixLines2 = request.getParameter("matrix2");
        /**
         * If one of the matrix or both of them are empty:  
         *  the program return the error massage to the matrix page 
         *  and show it to the user.
         */
        if ((matrixLines1.isEmpty()) && (matrixLines2.isEmpty())) {
            throw new ArrayStoreException("Matrix 1 AND Matrix 2 are empty.");
        }
        if (matrixLines1.isEmpty()) {
            throw new ArrayStoreException("Matrix 1 is empty.");
        }
        if (matrixLines2.isEmpty()) {
            throw new ArrayStoreException("Matrix 2 is empty.");
        }    
        /**
         * If both matrixs are not empty:
         *  the program reads and converts to int them from the text-area
         */
        // Reading the first block
        read(matrixBean, matrixLines1, true);
        //Reading the second block
        read(matrixBean, matrixLines2, false);
        //Set length
        matrixBean.setMcesLength();
        /**
         * The program returns bean if the reading has been succeeded
         */
        return matrixBean;
    }    
    
    /**
     * @param mxBean matrix bean
     * @param mxLines string lines of the matrix
     * @param fst is this matrix first?
     * @throws ArrayStoreException exception
     */
    private void read(final MatrixBean mxBean, final String mxLines, 
    		final boolean fst) throws ArrayStoreException {
        try (BufferedReader reader = new BufferedReader(
        		new StringReader(mxLines))) {
            String[] spiltLine;
            int[] matrixString;
            int j;
            for (String line; (line = reader.readLine()) != null;) {
                j = 0;
                spiltLine = line.split(" ");
                matrixString = new int[spiltLine.length];
                for (String s: spiltLine) {
                    if (!("".equals(s))) {
						matrixString[j++] = Integer.parseInt(s);
					}
                }
                if (fst) {
					mxBean.setMatrix1(matrixString);
				} else {
					mxBean.setMatrix2(matrixString);
				}
            }     
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            throw new ArrayStoreException("Invalid input of data.");
        }
    }
}
