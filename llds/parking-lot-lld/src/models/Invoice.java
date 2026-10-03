package models;

public class Invoice {

    private ParkingTicket ticket;
    private Vehicle vehicle;
    private double cost;

    public Invoice(ParkingTicket ticket, Vehicle vehicle, double cost) {
        this.ticket = ticket;
        this.vehicle = vehicle;
        this.cost = cost;
    }

    // Getters and Setters
    public ParkingTicket getParkingTicket() {
        return this.ticket;
    }

    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public double getCost() {
        return this.cost;
    }

}
