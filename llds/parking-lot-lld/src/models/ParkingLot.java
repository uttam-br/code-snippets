package models;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import exceptions.ParkingSpotNotAvailableException;
import factories.ParkingFloorFactory;
import strategies.cost.ParkingCostCalculator;
import strategies.cost.TimeBasedParkingCostCalculator;
import strategies.parking.LinearVehicleParkingStrategy;
import strategies.parking.VehicleParkingStrategy;

public class ParkingLot {

    private List<ParkingFloor> floors;
    private VehicleParkingStrategy vehicleParkingStrategy;
    private ParkingCostCalculator parkingCostCalculator;

    private ParkingLot() {
        this.floors = List.of(
                ParkingFloorFactory.createParkingFloor("Ground Floor", 2, 2, 1),
                ParkingFloorFactory.createParkingFloor("First Floor", 4, 1, 0));

        vehicleParkingStrategy = new LinearVehicleParkingStrategy(this.floors);
        parkingCostCalculator = new TimeBasedParkingCostCalculator();
    }

    public ParkingTicket parkVehicle(Vehicle vehicle) throws ParkingSpotNotAvailableException {
        // park the vehicle
        ParkingSpot parkingSpot = vehicleParkingStrategy.getAvailableParkingSpot(vehicle);

        if (parkingSpot == null) {
            throw new ParkingSpotNotAvailableException(
                    "Vehicle " + vehicle.getRegistration() + " cannot be parked as parking is full.");
        }

        parkingSpot.setVehicle(vehicle);

        // generate the parking ticket
        ParkingTicket ticket = new ParkingTicket();
        ticket.setStartsAt(LocalDateTime.now());
        ticket.setParkingSpot(parkingSpot);
        ticket.setVehicle(vehicle);

        return ticket;
    }

    public Invoice unparkVehicle(ParkingTicket ticket) {
        ticket.setEndsAt(LocalDateTime.now());

        // calcluate parking cost
        double cost = parkingCostCalculator.calculateParkingCost(ticket);

        Vehicle vehicle = ticket.getParkingSpot().getVehicle();

        // free parking spot
        ticket.getParkingSpot().setVehicle(null);

        // create invoice
        Invoice invoice = new Invoice(ticket, vehicle, cost);

        return invoice;
    }

    // Singleton Logic
    private static ParkingLot instance;

    public static ParkingLot getInstance() {
        if (instance == null) {
            synchronized (ParkingLot.class) {
                if (instance == null) {
                    instance = new ParkingLot();
                }
            }
        }
        return instance;
    }

    // Getters and Setters

    public List<ParkingFloor> getFloors() {
        return this.floors;
    }

}
