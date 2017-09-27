package com.calango.common.history;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author calango
 *
 */
public class HistoryServlet extends HttpServlet {
	/**
	 * serial version number.
	 */
	private static final long serialVersionUID = 1L;
    
    /**
     * 
     */
    public HistoryServlet() {
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
        processing(request, response);
    }

    @Override
	protected final void doPost(
            final HttpServletRequest request,
            final HttpServletResponse response)
            throws ServletException, IOException {
        processing(request, response);
    }
    
    /**
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void processing(
            final HttpServletRequest request,
            	final HttpServletResponse response) throws ServletException, 
    				IOException{
        String selectedDate = request.getParameter("date");
        if (selectedDate == null) {
            GetDatesList getterDates = new GetDatesList();
            List<String> dates = getterDates.getDatesList();
            request.setAttribute("datesList", dates);
            request.getRequestDispatcher("ShowHistory.jsp").forward(request,
            		response);
        } else {
            ShowHistory update = new ShowHistory();
            HistoryMatrixStorage storage = update.historyUpdate(selectedDate);
            request.setAttribute("matrixName", storage.getMatrixName());
            request.setAttribute("matrix1", storage.getMatrix1());
            request.setAttribute("matrix2", storage.getMatrix2());
            request.setAttribute("matrixResult", storage.getMatrixResult());
            request.getRequestDispatcher("history.jsp").forward(request,
            		response);
        }
    }
    
    @Override
	public final void destroy() {
        super.destroy();
    }
}