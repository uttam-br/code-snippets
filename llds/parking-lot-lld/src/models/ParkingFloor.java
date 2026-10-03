package models;

import java.util.*;

public class ParkingFloor {

    private String name;
    private List<ParkingSpot> spots;

    public ParkingFloor(String name, List<ParkingSpot> spots) {
        this.name = name;
        this.spots = spots;
    }

    // Getters and Setters
    public List<ParkingSpot> getSpots() {
        return this.spots;
    }

    public String getName() {
        return name;
    }


}