package services;

import models.ParkingFloor;
import models.ParkingSpot;
import models.constants.ParkingSpotType;

import java.util.ArrayList;

public class ParkingSpotService {

    private static final ParkingFloorService parkingFloorService = new ParkingFloorService();

    public void createParkingSpot(String parkingLotName, int floorNumber, ParkingSpotType parkingSpotType) throws Exception {
        ParkingSpot parkingSpot = new ParkingSpot();
        parkingSpot.setParkingSpotType(parkingSpotType);
        parkingSpot.setOccupied(false);

        ParkingFloor parkingFloor = parkingFloorService.getParkingFloor(parkingLotName, floorNumber);

        int parkingSpotNumber = 1;
        if (parkingFloor.getParkingSpots() == null) {
            parkingFloor.setParkingSpots(new ArrayList<>());
        } else {
            parkingSpotNumber = parkingFloor.getParkingSpots().get(parkingFloor.getParkingSpots().size() - 1).getParkingSpotNumber() + 1;
        }
        parkingSpot.setParkingSpotNumber(parkingSpotNumber);

        parkingFloor.getParkingSpots().add(parkingSpot);
    }

}
