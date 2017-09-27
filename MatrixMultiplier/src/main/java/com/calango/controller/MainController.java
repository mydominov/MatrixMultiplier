package com.calango.controller;

import com.calango.common.history.GetDatesList;
import com.calango.common.history.HistoryMatrixStorage;
import com.calango.common.history.ShowHistory;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Calango
 */
@Controller
@RequestMapping(value = "/welcome")
public class MainController {
	
    /**
     * @return welcome page
     */
    @RequestMapping(value = "")
	public final String welcome() {
        return "welcome";
    }
    
    /**
     * @return matrix page
     */
    @RequestMapping(value = "/matrix")
	public final String matrix() {
        return "matrix";
    }
    
    /**
     * @param request
     * @param response
     * @param model
     * @return answer page
     */
    @RequestMapping(value = "/matrix/show", method = RequestMethod.POST)
	public final String calculate(final HttpServletRequest request, 
    		final HttpServletResponse response, final Model model) {
        String name = (String) request.getAttribute("matrixName");
        int[][] mx = (int[][]) request.getAttribute("matrixResult");
        model.addAttribute("matrixName", name);
        model.addAttribute("matrixResult", mx);
        return "answer";
    }
    
    /**
     * @param model
     * @return show history page
     */
    @RequestMapping(value = "/history")
	public final String history(final Model model) {
        GetDatesList getterDates = new GetDatesList();
        List<String> dates = getterDates.getDatesList();
        model.addAttribute("datesList", dates);
        return "ShowHistory";
    }
    
    /**
     * @param date
     * @param model
     * @return show matrix page
     */
    @RequestMapping(value = "/history/ShowDate", method = RequestMethod.POST)
	public final String showRecordByDate(
			@RequestParam("date") final String date, 
				final Model model) {
            ShowHistory update = new ShowHistory();
            HistoryMatrixStorage storage = update.historyUpdate(date);
            System.out.println(storage.getMatrixName());
            model.addAttribute("matrixName", storage.getMatrixName());
            model.addAttribute("matrix1", storage.getMatrix1());
            model.addAttribute("matrix2", storage.getMatrix2());
            model.addAttribute("matrixResult", storage.getMatrixResult());
        return "ShowMatrix";
    }
}
