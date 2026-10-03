package models;

public class Vehicle {

    private String registration;
    private VehicleType type;

    public Vehicle(VehicleType type, String registration) {
        this.type = type;
        this.registration = registration;
    }

    public String getRegistration() {
        return this.registration;
    }

    public VehicleType getType() {
        return type;
    }

}
