package strategies.parking;

import java.util.*;

import exceptions.ParkingSpotNotAvailableException;
import models.*;

public abstract class VehicleParkingStrategy {

    List<ParkingFloor> floors;

    VehicleParkingStrategy(List<ParkingFloor> floors) {
        this.floors = floors;
    }
    
    public abstract ParkingSpot getAvailableParkingSpot(Vehicle vehicle) throws ParkingSpotNotAvailableException;

}
