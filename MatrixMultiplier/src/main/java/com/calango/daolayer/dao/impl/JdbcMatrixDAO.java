package com.calango.daolayer.dao.impl;

import com.calango.daolayer.dao.MatrixDAO;
import com.calango.daolayer.dao.impl.rowmapper.MatrixRowMapper;
import com.calango.daolayer.model.Matrix;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Calango
 */
public class JdbcMatrixDAO implements MatrixDAO {
	
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
	public final Matrix findByID(final int matrixId) {
        String sqlForID = "SELECT * FROM matrix WHERE matrix_id = ?";
        Matrix matrix = (Matrix) jdbcTemplate.queryForObject(
        		sqlForID, new Object[] { matrixId }, 
        			new MatrixRowMapper());
        return matrix;
    }
    
    @Override
	public final String findMatrixNameById(final int matrixId) {
    	return findByID(matrixId).getMatrixName();
    }

    @Override
	public final void insertRecord(final Matrix insertObject) {
        String insertMatrix = "INSERT INTO matrix (user_id, matrix_name, "
        		+ "matrix_row, matrix_column) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(insertMatrix, new Object[] { 
        		insertObject.getUserId(),
        		insertObject.getMatrixName(),
        		insertObject.getMatrixRow(), 
        		insertObject.getMatrixColumn()
        });
    }

    @Override
	public final int findIdByNameAndLen(final String matrixName, 
			final int row, final int column) {
        String sqlForName = "SELECT * FROM matrix WHERE (matrix_name = ?) AND "
                + "(matrix_row = ?) AND (matrix_column = ?)";
        Matrix matrix = (Matrix) jdbcTemplate.queryForObject(
        		sqlForName, new Object[] { matrixName, row, column }, 
        			new MatrixRowMapper());
        return matrix.getMatrixId();
    }
}