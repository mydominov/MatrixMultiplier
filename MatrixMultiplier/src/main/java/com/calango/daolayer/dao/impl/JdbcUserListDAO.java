package com.calango.daolayer.dao.impl;

import com.calango.daolayer.model.UserList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author Calango
 */
public class JdbcUserListDAO {
	
    /**
     * 
     */
    private DataSource dataSource;
    
    /**
     * @param dataSource
     */
    public final void setDataSource(final DataSource dataSource) {
	this.dataSource = dataSource;
    }

    /**
     * @param login
     * @param password
     * @return
     */
    public final Object findByID(final String login, final String password) {
        String sqlForID = "SELECT * FROM elements WHERE "
                + "(login = " + login + ") AND "
                + "(password = " + password + ")";
        
        try (Connection conn = dataSource.getConnection()) {
            Statement statement = conn.createStatement();
            UserList userList = null;
            ResultSet rs = statement.executeQuery(sqlForID);
            if (rs.next()) {
                userList = new UserList(
                    rs.getInt("user_id"),
                    rs.getString("login"), 
                    rs.getString("password")
                );
            }
            rs.close();
            statement.close();
            return userList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
