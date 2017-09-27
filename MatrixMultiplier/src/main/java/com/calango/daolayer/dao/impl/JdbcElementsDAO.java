package com.calango.daolayer.dao.impl;

import com.calango.daolayer.dao.ElementsDAO;
import com.calango.daolayer.dao.impl.rowmapper.ElementsRowMapper;
import com.calango.daolayer.model.Elements;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Calango
 */
public class JdbcElementsDAO implements ElementsDAO {
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
	public final Object findByID(final int elementId) {
        String sqlForID = "SELECT * FROM elements WHERE matrix_id = ?";
        Elements element = (Elements) jdbcTemplate.queryForObject(
			sqlForID, new Object[] { elementId },
				new ElementsRowMapper());
        return element;
    }

    @Override
	public final int getValue(final int matrixId, final int rowId, 
			final int columnId){
        String sqlForValue = "SELECT * FROM elements WHERE (matrix_id = ?)"
        		+ "AND (row_id = ?) AND (column_id = ?)";
        Elements element = (Elements) jdbcTemplate.queryForObject(
			sqlForValue, new Object[] { matrixId, rowId, columnId }, 
			new ElementsRowMapper());
        return element.getValue();
    } 

    @Override
	public final void insert(final Elements insertObject) {
        String insertElements = "INSERT INTO elements (row_id, column_id, "
        		+ "value, matrix_id) VALUES(?, ?, ?, ?)";
                jdbcTemplate.update(insertElements, new Object[] {
                		insertObject.getRowId(),
                			insertObject.getColumnId(), 
                				insertObject.getValue(), 
                					insertObject.getMatrixId()
		});
    }
}