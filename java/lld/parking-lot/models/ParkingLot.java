package models;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {

    private String name;
    private List<ParkingFloor> parkingFloors = new ArrayList<>();
    private List<Operator> operators = new ArrayList<>();
    private List<ParkingGate> entryGates = new ArrayList<>();
    private List<ParkingGate> exitGates = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<ParkingGate> getEntryGates() {
        return entryGates;
    }

    public void setEntryGates(List<ParkingGate> entryGates) {
        this.entryGates = entryGates;
    }

    public List<ParkingGate> getExitGates() {
        return exitGates;
    }

    public void setExitGates(List<ParkingGate> exitGates) {
        this.exitGates = exitGates;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }
}
