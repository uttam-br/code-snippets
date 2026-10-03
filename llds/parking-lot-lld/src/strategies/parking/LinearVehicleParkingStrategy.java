package strategies.parking;

import java.util.*;

import models.ParkingFloor;
import models.ParkingSpot;
import models.Vehicle;

public class LinearVehicleParkingStrategy extends VehicleParkingStrategy {

    public LinearVehicleParkingStrategy(List<ParkingFloor> floors) {
        super(floors);
    }

    @Override
    public ParkingSpot getAvailableParkingSpot(Vehicle vehicle) {
        for (ParkingFloor floor: floors) {
            for (ParkingSpot spot: floor.getSpots()) {
                if (spot.getVehicle() == null && spot.doesItFit(vehicle.getType())) {
                    return spot;
                }
            }
        }

        return null;
    }

}
