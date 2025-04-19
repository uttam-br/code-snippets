package strategies;

import models.ParkingGate;
import models.ParkingLot;
import models.ParkingSpot;
import models.constants.ParkingSpotType;
import models.constants.VehicleType;

public interface ParkingSpotAssigner {

    ParkingSpot assignParkingSpot(ParkingLot parkingLot, ParkingGate entry, VehicleType vehicleType);

    default boolean vehicleFitsIntoSpot(VehicleType vehicletype, ParkingSpotType parkingSpotType) {
        return switch (vehicletype) {
            case BIKE -> true;
            case CAR -> parkingSpotType == ParkingSpotType.LARGE || parkingSpotType == ParkingSpotType.MEDIUM;
            case TRUCK -> parkingSpotType == ParkingSpotType.LARGE;
        };
    }

}
