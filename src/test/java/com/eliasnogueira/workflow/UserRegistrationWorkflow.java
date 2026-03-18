package com.eliasnogueira.workflow;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationWorkflow {

    @Test(description = "Execute user registration workflow")
    public void executeRegistration() {

        System.out.println("Executing User Registration Workflow");

        String email = "newuser@email.com";
        String password = "SecurePass123!";
        String country = "Brazil";

        System.out.println("Processing registration for: " + email);
        
        boolean emailValid = email.contains("@");
        boolean passwordValid = password.length() >= 8;
        boolean countryValid = country != null && !country.isEmpty();

        Assert.assertTrue(emailValid, "Email format is invalid");
        Assert.assertTrue(passwordValid, "Password must be at least 8 characters");
        Assert.assertTrue(countryValid, "Country must be selected");

        System.out.println("User registration workflow executed successfully");
    }
}
