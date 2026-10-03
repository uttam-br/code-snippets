package models;

public class BikeParkingSpot extends ParkingSpot {

    public BikeParkingSpot() {
        super(ParkingSpotType.SMALL);
    }

    @Override
    public boolean doesItFit(VehicleType vehicleType) {
        return vehicleType == VehicleType.SMALL;
    }

}
