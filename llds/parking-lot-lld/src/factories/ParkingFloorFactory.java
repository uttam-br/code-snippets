package factories;

import java.util.*;

import models.ParkingFloor;
import models.ParkingSpot;
import models.ParkingSpotType;

public class ParkingFloorFactory {
    
    public static ParkingFloor createParkingFloor(String name, int small, int medium, int large) {
        List<ParkingSpot> parkingSpots = new ArrayList<>();

        parkingSpots.addAll(ParkingSpotFactory.createParkingSpots(ParkingSpotType.SMALL, small));
        parkingSpots.addAll(ParkingSpotFactory.createParkingSpots(ParkingSpotType.MEDIUM, medium));
        parkingSpots.addAll(ParkingSpotFactory.createParkingSpots(ParkingSpotType.LARGE, large));

        ParkingFloor parkingFloor = new ParkingFloor(name, parkingSpots);

        return parkingFloor;
    }

}
