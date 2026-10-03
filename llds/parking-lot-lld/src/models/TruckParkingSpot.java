package models;

public class TruckParkingSpot extends ParkingSpot {

    public TruckParkingSpot() {
        super(ParkingSpotType.LARGE);
    }

    @Override
    public boolean doesItFit(VehicleType vehicleType) {
        return vehicleType == VehicleType.SMALL || vehicleType == VehicleType.MEDIUM
                || vehicleType == VehicleType.LARGE;
    }

}
