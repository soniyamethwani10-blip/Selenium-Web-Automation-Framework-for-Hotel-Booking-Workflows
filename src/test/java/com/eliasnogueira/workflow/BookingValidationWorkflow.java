package com.eliasnogueira.workflow;

import org.testng.Assert;
import org.testng.annotations.Test;

public class BookingValidationWorkflow {

    @Test(description = "Execute booking validation workflow")
    public void validateBooking() {

        System.out.println("Executing Booking Validation Workflow");

        String bookingId = "BK123456";
        String status = "CONFIRMED";
        boolean paymentReceived = true;

        System.out.println("Validating booking: " + bookingId);
        System.out.println("Status: " + status);
        System.out.println("Payment received: " + paymentReceived);

        Assert.assertNotNull(bookingId, "Booking ID must not be null");
        Assert.assertEquals(status, "CONFIRMED", "Booking status should be confirmed");
        Assert.assertTrue(paymentReceived, "Payment must be received");

        System.out.println("Booking validation workflow executed successfully");
    }
}
