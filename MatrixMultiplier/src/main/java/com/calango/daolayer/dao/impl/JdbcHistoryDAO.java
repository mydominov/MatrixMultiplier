package com.calango.daolayer.dao.impl;

import com.calango.daolayer.dao.HistoryDAO;
import com.calango.daolayer.model.History;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Admin
 */
public class JdbcHistoryDAO implements HistoryDAO {
	
    /**
     * 
     */
    private JdbcTemplate jdbcTemplate;
 
    /**
     * @param jdbcTemplate
     */
    public final void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
	public final History findByID(final int historyId) {
        String sqlForID = "SELECT * FROM history WHERE history_id = ?";
        History history = (History) jdbcTemplate.queryForObject(
			sqlForID, new Object[] { historyId }, 
				new BeanPropertyRowMapper(History.class));
        return history;
    }

    @Override
	public final int findIdByDate(final String date) {
        try {
            String sqlForDate = "SELECT * FROM history WHERE date = ?";
            History history = (History) jdbcTemplate.queryForObject(
            	sqlForDate, new Object[] { date }, 
            		new BeanPropertyRowMapper(History.class));
            return history.getMatrix1Id();
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("No date was found: " + date);
            return 1;
        }
    }

    @Override
	public final List<String> getDatesList() {
        String sqlForDates = "SELECT date FROM history";
        List<String> dates = 
                (List<String>) jdbcTemplate.queryForList(
                		sqlForDates, String.class);
        return dates;
    }

    @Override
	public final void insertHistory(final History insertObject) {
        String insertHistorySql = "INSERT INTO history (matrix1_id, "
        		+ "matrix2_id, matrix_result_id, date) VALUES(?, ?, ?, NOW())"; 
        jdbcTemplate.update(insertHistorySql, new Object[] { 
        		insertObject.getMatrix1Id(),
                    insertObject.getMatrix2Id(),
                    	insertObject.getMatrixResultId()
		});
    }  
}
