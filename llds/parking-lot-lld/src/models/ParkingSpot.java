package models;

public abstract class ParkingSpot {

    private final ParkingSpotType type;
    private Vehicle vehicle;

    ParkingSpot(ParkingSpotType type) {
        this.type = type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpotType getType() {
        return type;
    }

    public abstract boolean doesItFit(VehicleType vehicleType);

}
