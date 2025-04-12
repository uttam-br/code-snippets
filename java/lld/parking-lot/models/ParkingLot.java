package models;

import java.util.List;

public class ParkingLot {

    private List<ParkingFloor> parkingFloors;
    private List<ParkingGate> parkingGates;
    private String name;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<ParkingGate> getParkingGates() {
        return parkingGates;
    }

    public void setParkingGates(List<ParkingGate> parkingGates) {
        this.parkingGates = parkingGates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
