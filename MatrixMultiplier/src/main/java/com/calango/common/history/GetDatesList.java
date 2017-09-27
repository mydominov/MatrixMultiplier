package com.calango.common.history;

import com.calango.daolayer.dao.impl.JdbcHistoryDAO;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Calango
 */
public class GetDatesList {
    /**
     * @return list of dates from db
     */
    public final List<String> getDatesList() {
        ApplicationContext context = 
    		new ClassPathXmlApplicationContext("spring-database.xml");
        JdbcHistoryDAO historyDAO = (JdbcHistoryDAO) context.getBean(
        		"historyDAO");
        List<String> dates = historyDAO.getDatesList();
        return dates;
    }
    
}