package com.calango.common.matrixbeans;

/**
 *
 * @author Calango
 */
public class GeneralBean {
	
    /**
     * 
     */
    private String userRole = "Admin";
    /**
     * 
     */
    private String matrixName;

    /**
     * @return role
     */
    public final String getUserRole() {
        return userRole;
    }

    /**
     * @param userRole role
     */
    public final void setUserRole(final String userRole) {
        this.userRole = userRole;
    }

    /**
     * @return name
     */
    public final String getMatrixName() {
        return matrixName;
    }

    /**
     * @param matrixName name
     */
    public final void setMatrixName(final String matrixName) {
        this.matrixName = matrixName;
    }
}
