package com.calango.daolayer.dao.impl.rowmapper;

import com.calango.daolayer.model.Matrix;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Calango
 */
public class MatrixRowMapper implements RowMapper {

    @Override
	public final Object mapRow(final ResultSet rs, 
			final int rowNum) throws SQLException {
        Matrix matrix = new Matrix();
        matrix.setMatrixId(rs.getInt("matrix_id"));
        matrix.setUserId(rs.getInt("user_id"));
        matrix.setMatrixName(rs.getString("matrix_name"));
        matrix.setMatrixRow(rs.getInt("matrix_row"));
        matrix.setMatrixColumn(rs.getInt("matrix_column"));
        return matrix;
    }
    
}
