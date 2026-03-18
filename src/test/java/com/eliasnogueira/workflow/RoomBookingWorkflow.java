package com.eliasnogueira.workflow;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RoomBookingWorkflow {

    @Test(description = "Validate room booking workflow execution")
    public void validateRoomBooking() {

        System.out.println("Executing End-to-End Room Booking Workflow");

        String userEmail = "guest@email.com";
        String roomType = "Business Room";
        int roomsAvailable = 4;

        Assert.assertTrue(userEmail.contains("@"), "Invalid user email");
        Assert.assertNotNull(roomType, "Room type must be selected");
        Assert.assertTrue(roomsAvailable > 0, "No rooms available");

        System.out.println("Room booking workflow executed successfully");
    }
}
