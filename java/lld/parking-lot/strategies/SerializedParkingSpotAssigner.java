package strategies;

import models.ParkingFloor;
import models.ParkingGate;
import models.ParkingLot;
import models.ParkingSpot;
import models.constants.VehicleType;

public class SerializedParkingSpotAssigner implements ParkingSpotAssigner {

    @Override
    public ParkingSpot assignParkingSpot(ParkingLot parkingLot, ParkingGate entry, VehicleType vehicleType) {

        for (ParkingFloor parkingFloor: parkingLot.getParkingFloors()) {
            for(ParkingSpot parkingSpot: parkingFloor.getParkingSpots()) {
                if (!parkingSpot.isOccupied() && vehicleFitsIntoSpot(vehicleType, parkingSpot.getParkingSpotType())) {
                    return parkingSpot;
                }
            }
        }

        return null;
    }

}
