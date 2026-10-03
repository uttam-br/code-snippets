package models;

public class CarParkingSpot extends ParkingSpot {

    public CarParkingSpot() {
        super(ParkingSpotType.MEDIUM);
    }

    @Override
    public boolean doesItFit(VehicleType vehicleType) {
        return vehicleType == VehicleType.SMALL || vehicleType == VehicleType.MEDIUM;
    }

}
