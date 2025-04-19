package controllers;

import services.ParkingFloorService;

public class ParkingFloorController {

    private ParkingFloorService parkingFloorService = new ParkingFloorService();

    public void createParkingFloor(String parkingLotName, int floorNumber) {
        try {
            parkingFloorService.createParkingFloor(parkingLotName, floorNumber);
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }

}
