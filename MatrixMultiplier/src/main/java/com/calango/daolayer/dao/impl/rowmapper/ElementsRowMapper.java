package com.calango.daolayer.dao.impl.rowmapper;

import com.calango.daolayer.model.Elements;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author Calango
 */
public class ElementsRowMapper implements RowMapper {

    @Override
	public final Object mapRow(final ResultSet rs,
			final int i) throws SQLException {
        Elements elements = new Elements();
        elements.setElementId(rs.getInt("element_id"));
        elements.setRowId(rs.getInt("row_id"));
        elements.setColumnId(rs.getInt("column_id"));
        elements.setValue(rs.getInt("value"));
        elements.setMatrixId(rs.getInt("matrix_id"));
        return elements;
    }
    
}
