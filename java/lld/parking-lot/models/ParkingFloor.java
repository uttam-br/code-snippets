package models;

import models.enums.ParkingSpotType;

import java.util.List;
import java.util.Map;

public class ParkingFloor {

    private int floorNumber;

    private Map<ParkingSpotType, List<ParkingSpot>> parkingSpots;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Map<ParkingSpotType, List<ParkingSpot>> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(Map<ParkingSpotType, List<ParkingSpot>> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
