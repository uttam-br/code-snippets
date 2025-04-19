package controllers;

import models.ParkingFloor;
import models.ParkingGate;
import models.ParkingLot;
import models.ParkingSpot;
import services.ParkingLotService;

import java.util.Optional;

public class ParkingLotController {

    private ParkingLotService parkingLotService = new ParkingLotService();

    public Optional<ParkingLot> createParkingLot(String name) {
        try {
            return Optional.of(parkingLotService.createParkingLot(name));
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
        return Optional.empty();
    }

    public Optional<ParkingLot> getParkingLot(String name) {
        try {
            return Optional.of(parkingLotService.getParkingLot(name));
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
        return Optional.empty();
    }

    public void printParkingLot(String name) {
        try {
            ParkingLot parkingLot = parkingLotService.getParkingLot(name);

            System.out.println();
            System.out.println("----------------* " + name + " *-----------------");
            System.out.println();

            System.out.println("-------* PARKING ENTRY GATES *-------");
            for (ParkingGate parkingGate : parkingLot.getEntryGates()) {
                System.out.println(parkingGate.getGateName());
            }
            System.out.println();

            System.out.println("-------* PARKING EXIT GATES *-------");
            for (ParkingGate parkingGate : parkingLot.getExitGates()) {
                System.out.println(parkingGate.getGateName());
            }
            System.out.println();

            for (ParkingFloor parkingFloor : parkingLot.getParkingFloors()) {
                System.out.println("-------* Floor " + parkingFloor.getFloor() + " *-------");
                for (ParkingSpot parkingSpot : parkingFloor.getParkingSpots()) {
                    System.out.print("|");
                    if (parkingSpot.isOccupied()) {
                        switch (parkingSpot.getVehicle().getVehicleType()) {
                            case CAR -> System.out.print("_C_");
                            case BIKE -> System.out.print("_B_");
                            case TRUCK -> System.out.print("_T_");
                        }
                    } else {
                        System.out.print("___");
                    }
                    System.out.print("|");
                }
                System.out.println();
            }

            System.out.println();

        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }

    }

}
