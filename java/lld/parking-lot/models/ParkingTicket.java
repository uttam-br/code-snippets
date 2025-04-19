package models;

import java.time.LocalDateTime;

public class ParkingTicket {

    private Vehicle vehicle;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private ParkingSpot parkingSpot;
    private ParkingGate entryGate;
    private ParkingGate exitGate;
    private Operator entryOperator;
    private Operator exitOperator;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public ParkingGate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(ParkingGate entryGate) {
        this.entryGate = entryGate;
    }

    public ParkingGate getExitGate() {
        return exitGate;
    }

    public void setExitGate(ParkingGate exitGate) {
        this.exitGate = exitGate;
    }

    public Operator getEntryOperator() {
        return entryOperator;
    }

    public void setEntryOperator(Operator entryOperator) {
        this.entryOperator = entryOperator;
    }

    public Operator getExitOperator() {
        return exitOperator;
    }

    public void setExitOperator(Operator exitOperator) {
        this.exitOperator = exitOperator;
    }
}
