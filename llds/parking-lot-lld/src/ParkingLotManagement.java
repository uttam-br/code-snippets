
import models.*;
import exceptions.ParkingSpotNotAvailableException;

public class ParkingLotManagement {

    private ParkingLot parkingLot;

    ParkingLotManagement() {
        this.parkingLot = ParkingLot.getInstance();
    }

    ParkingTicket parkVehicle(Vehicle vehicle) throws ParkingSpotNotAvailableException {
        return this.parkingLot.parkVehicle(vehicle);
    }

    Invoice unparkVehicle(ParkingTicket ticket) {
        return this.parkingLot.unparkVehicle(ticket);
    }

    void viewParkingLot() {
        System.out.println();
        System.out.println();
        System.out.println("****** PARKING LOT ******");
        // print each floor
        for (ParkingFloor floor : this.parkingLot.getFloors()) {
            System.out.println("****** " + floor.getName() + " ******");
            for (ParkingSpot spot : floor.getSpots()) {
                if (spot.getVehicle() == null) {
                    System.out.print("|_|");
                } else {
                    String vehicleType = "S";
                    if (spot.getVehicle().getType() == VehicleType.LARGE) {
                        vehicleType = "L";
                    } else if (spot.getVehicle().getType() == VehicleType.MEDIUM) {
                        vehicleType = "M";
                    }
                    System.out.print("|" + vehicleType + "|");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
