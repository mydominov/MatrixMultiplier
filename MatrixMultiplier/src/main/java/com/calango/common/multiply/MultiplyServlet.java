package com.calango.common.multiply;

import com.calango.common.matrixbeans.GeneralBean;
import com.calango.common.matrixbeans.MatrixBean;
import com.calango.common.matrixbeans.MatrixResult;
import com.calango.common.multiply.matrixmultiplication.MultiplicationImplementation;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author calango
 *
 */
public class MultiplyServlet extends HttpServlet {
	
	/**
	 * serial version number.
	 */
	private static final long serialVersionUID = 1L;
	
    /**
     * 
     */
    public MultiplyServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    }

    @Override
	protected final void doGet(
            final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    @Override
	protected final void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        process(request, response);
    }

    /**
     * @param request http request
     * @param response http response
     * @throws ServletException exception
     * @throws IOException file exception
     */
    private void process(
            final HttpServletRequest request,
            	final HttpServletResponse response) throws ServletException, 
    				IOException {
        try {
            GeneralBean genBean = new GeneralBean();
            MatrixReader mxReader = new MatrixReader();
            InsertRecord insertRecord = new InsertRecord();
            MultiplicationImplementation multiplyCentre = 
            		new MultiplicationImplementation();
            response.setContentType("text/html");
            genBean.setMatrixName(request.getParameter("matrix_name"));
            if ("".equals(genBean.getMatrixName())) {
				genBean.setMatrixName("Default Name");
			}
            MatrixBean matrixBean = mxReader.readFromTextArea(request, response);
            if (matrixBean.getColumnLen1() != matrixBean.getRowLen2()) {
                throw new ArrayStoreException("Matrices are not consistent!");
            }
            MatrixResult result = multiplyCentre.multiply(matrixBean);
            insertRecord.insert(genBean, matrixBean, result);
            request.setAttribute("matrixName", genBean.getMatrixName());
            request.setAttribute("matrixResult", result.getMatrixResult());
            request.getServletContext().getRequestDispatcher("/answer.jsp").
            	forward(request, response);
        } catch (ArrayStoreException ex) {
                request.setAttribute("error", ex.getMessage());
                request.getServletContext().getRequestDispatcher(
                		"/welcome/matrix").forward(
                				request, response);            
        }
    }
    
    @Override
	public final void destroy() {
        super.destroy();
    }
}