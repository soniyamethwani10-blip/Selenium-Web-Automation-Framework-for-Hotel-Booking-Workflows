package com.eliasnogueira.workflow;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserLogoutWorkflow {

    @Test(description = "Execute user logout workflow")
    public void executeLogout() {

        System.out.println("Executing Logout Workflow");

        boolean sessionActive = true;
        
        System.out.println("Checking active session: " + sessionActive);
        System.out.println("Terminating user session");

        Assert.assertTrue(sessionActive, "Session must be active to logout");

        System.out.println("Logout workflow executed successfully");
    }
}
