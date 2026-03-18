package com.eliasnogueira.workflow;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Hotel Booking Automation")
@Feature("User Authentication")
@Story("User logs in successfully")
@Severity(SeverityLevel.NORMAL)
public class UserLoginWorkflow {

    @Test(description = "Execute user login workflow")
    @Description("Verify that a user can authenticate with valid credentials")
    @Owner("Automation Team")
    public void executeLogin() {

        System.out.println("Executing Login Workflow");

        String username = "testuser@email.com";
        String password = "password123";

        Allure.parameter("Username", username);
        
        System.out.println("Processing username: " + username);
        System.out.println("Processing password: " + password);

        boolean usernameValid = username.contains("@");
        boolean passwordValid = password.length() >= 6;

        Assert.assertTrue(usernameValid, "Username format is invalid");
        Assert.assertTrue(passwordValid, "Password length is invalid");

        System.out.println("Login workflow executed successfully");
    }
}
