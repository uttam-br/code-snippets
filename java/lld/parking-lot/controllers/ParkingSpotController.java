package controllers;

import models.constants.ParkingSpotType;
import services.ParkingSpotService;

public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService = new ParkingSpotService();

    public void createParkingSpot(String parkingLotName, int floorNumber, ParkingSpotType parkingSpotType) {
        try {
            parkingSpotService.createParkingSpot(parkingLotName, floorNumber, parkingSpotType);
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }

}
