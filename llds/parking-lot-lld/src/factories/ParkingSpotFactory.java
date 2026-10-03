package factories;

import java.util.*;
import models.*;

public class ParkingSpotFactory {
    
    public static List<ParkingSpot> createParkingSpots(ParkingSpotType type, int qty) {
        List<ParkingSpot> spots = new ArrayList<>();

        for (int i=0; i<qty; i++) {
            ParkingSpot parkingSpot;

            switch (type) {
                case LARGE:
                    parkingSpot = new TruckParkingSpot();
                    break;
                case MEDIUM:
                    parkingSpot = new CarParkingSpot();
                    break;
                case SMALL:
                    parkingSpot = new BikeParkingSpot();
                    break;
                default:
                    parkingSpot = new BikeParkingSpot();
                    break;
            }

            spots.add(parkingSpot);
        }

        return spots;
    }

}
