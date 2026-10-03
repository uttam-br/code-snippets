package models;

import java.time.LocalDateTime;

public class ParkingTicket {

    private ParkingSpot parkingSpot;
    private Vehicle vehicle;
    private LocalDateTime startsAt;
    private LocalDateTime endsAt;

    // Getters and Setters
    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public ParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }

    public void setStartsAt(LocalDateTime time) {
        this.startsAt = time;
    }

    public LocalDateTime getStartsAt() {
        return this.startsAt;
    }

    public void setEndsAt(LocalDateTime time) {
        this.endsAt = time;
    }

    public LocalDateTime getEndsAt() {
        return this.endsAt;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

}
