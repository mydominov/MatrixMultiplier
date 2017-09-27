package com.calango.daolayer.model;

/**
 *
 * @author Calango
 */
public class UserList {
    /**
     * 
     */
    private int userID;
    /**
     * 
     */
    private String userLogin;
    /**
     * 
     */
    private String userPassword;
    
    /**
     * @param userID
     * @param userLogin
     * @param userPassword
     */
    public UserList(final int userID, final String userLogin, 
    		final String userPassword){
        this.userID = userID;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    /**
     * @return
     */
    public final int getUserID() {
        return userID;
    }

    /**
     * @return
     */
    public final String getUserLogin() {
        return userLogin;
    }

    /**
     * @return
     */
    public final String getUserPassword() {
        return userPassword;
    }

    /**
     * @param userID
     */
    public final void setUserID(final int userID) {
        this.userID = userID;
    }

    /**
     * @param userLogin
     */
    public final void setUserLogin(final String userLogin) {
        this.userLogin = userLogin;
    }

    /**
     * @param userPassword
     */
    public final void setUserPassword(final String userPassword) {
        this.userPassword = userPassword;
    }
}
