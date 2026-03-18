package com.eliasnogueira.workflow;

import com.eliasnogueira.BaseWeb;
import com.eliasnogueira.page.booking.AccountPage;
import com.eliasnogueira.page.booking.ConfirmationPage;
import com.eliasnogueira.page.booking.DetailPage;
import com.eliasnogueira.page.booking.RoomPage;
import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

@Epic("Hotel Booking Automation")
@Feature("Room Booking")
@Story("User books a hotel room successfully")
@Severity(SeverityLevel.CRITICAL)
public class BookingWorkflow extends BaseWeb {

    @Test(description = "Execute complete booking workflow from account creation to confirmation")
    @Description("Verify that a user can complete the room booking workflow from account creation to confirmation")
    @Owner("Automation Team")
    @TmsLink("BOOKING-001")
    public void executeCompleteBookingWorkflow() {
        
        // Booking data
        String email = "testuser@example.com";
        String password = "SecurePass123!";
        String country = "Brazil";
        String budget = "$100 - $499";
        String roomType = "Business";
        String roomDescription = "This is a test booking for automation validation. The room should be ready for testing purposes.";

        Allure.step("Initialize booking data", () -> {
            Allure.parameter("Email", email);
            Allure.parameter("Country", country);
            Allure.parameter("Budget", budget);
            Allure.parameter("Room Type", roomType);
        });

        // Step 1: Fill Account Information
        AccountPage accountPage = new AccountPage();
        accountPage.fillEmail(email);
        accountPage.fillPassword(password);
        accountPage.selectCountry(country);
        accountPage.selectBudget(budget);
        accountPage.clickNewsletter();
        
        // Navigate to Room Selection
        accountPage.next();

        // Step 2: Select Room Type
        RoomPage roomPage = new RoomPage();
        roomPage.selectRoomType(roomType);
        
        // Navigate to Extra Details
        roomPage.next();

        // Step 3: Fill Extra Details
        DetailPage detailPage = new DetailPage();
        detailPage.fillRoomDescription(roomDescription);
        
        // Submit Booking
        detailPage.bookRoom();

        // Step 4: Validate Booking Confirmation
        ConfirmationPage confirmationPage = new ConfirmationPage();
        
        // Assertions using SoftAssertions for comprehensive reporting
        SoftAssertions softly = new SoftAssertions();
        
        softly.assertThat(confirmationPage.isBookingSuccessful())
              .as("Booking should be successful")
              .isTrue();
        
        String successMessage = confirmationPage.getSuccessMessage();
        softly.assertThat(successMessage)
              .as("Success message should contain 'Done' or similar confirmation text")
              .containsIgnoringCase("Done");
        
        String confirmationDetails = confirmationPage.getConfirmationDetails();
        softly.assertThat(confirmationDetails)
              .as("Confirmation details should mention reservation was made")
              .containsIgnoringCase("reservation");
        
        softly.assertAll();
    }
}
