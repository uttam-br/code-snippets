package controllers;

import exceptions.ParkingFullException;
import models.Invoice;
import models.ParkingTicket;
import models.constants.VehicleType;
import services.ParkingService;

public class ParkingController {

    private final ParkingService parkingService = new ParkingService();

    public ParkingTicket parkVehicle(String parkingLotName, String entryGateName, int operatorId, String vehicleRegistrationNumber, VehicleType vehicleType) {
        try {
            return parkingService.parkVehicle(parkingLotName, entryGateName, operatorId, vehicleRegistrationNumber, vehicleType);
        } catch (ParkingFullException parkingFullException) {
            System.out.println("Parking full for " + vehicleType);
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
        return null;
    }

    public Invoice unParkVehicle(String parkingLotName, ParkingTicket parkingTicket, String exitGateName, int operatorId) {
        try {
            return parkingService.unParkVehicle(parkingLotName, parkingTicket, exitGateName, operatorId);
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
        return null;
    }

}
