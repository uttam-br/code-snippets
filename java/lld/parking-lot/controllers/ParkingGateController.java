package controllers;

import models.constants.ParkingGateType;
import services.ParkingGateService;

import java.util.List;

public class ParkingGateController {

    private static final ParkingGateService parkingGateService = new ParkingGateService();

    public void createParkingGate(String parkingLotName, String gateName, ParkingGateType parkingGateType, List<Integer> operatorIds) {
        try {
            parkingGateService.createParkingGate(parkingLotName, gateName, parkingGateType, operatorIds);
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }

}
