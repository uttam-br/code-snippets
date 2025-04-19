package services;

import exceptions.ParkingFullException;
import models.*;
import models.constants.VehicleType;
import strategies.ParkingAmountCalculator;
import strategies.ParkingSpotAssigner;
import strategies.SerializedParkingSpotAssigner;
import strategies.TimeBasedParkingAmountCalculator;

import java.time.LocalDateTime;

public class ParkingService {

    private final ParkingLotService parkingLotService = new ParkingLotService();
    private final ParkingGateService parkingGateService = new ParkingGateService();
    private final OperatorService operatorService = new OperatorService();

    private final ParkingSpotAssigner parkingSpotAssigner = new SerializedParkingSpotAssigner();
    private final ParkingAmountCalculator parkingAmountCalculator = new TimeBasedParkingAmountCalculator();

    public ParkingTicket parkVehicle(
            String parkingLotName,
            String entryGateName,
            int operatorId,
            String vehicleRegistrationNumber,
            VehicleType vehicleType
    ) throws Exception {

        ParkingLot parkingLot = parkingLotService.getParkingLot(parkingLotName);
        ParkingGate entryGate = parkingLot.getEntryGates().stream()
                .filter(gate -> gate.getGateName().equalsIgnoreCase(entryGateName))
                .findFirst().get();

        ParkingTicket parkingTicket = new ParkingTicket();
        parkingTicket.setEntryGate(entryGate);
//        parkingTicket.setEntryTime(LocalDateTime.now());
        parkingTicket.setEntryTime(LocalDateTime.parse("2025-04-19T06:00:00.0")); // for testing
        parkingTicket.setEntryOperator(operatorService.getOperator(operatorId).get());

        // get parking spot using algorithm
        ParkingSpot assignedParkingSpot = parkingSpotAssigner.assignParkingSpot(parkingLot, entryGate, vehicleType);
        if (assignedParkingSpot == null) {
            throw new ParkingFullException("Parking Full !!!");
        }

        assignedParkingSpot.setOccupied(true);
        Vehicle vehicle = new Vehicle(vehicleRegistrationNumber, vehicleType);
        assignedParkingSpot.setVehicle(vehicle);

        parkingTicket.setVehicle(vehicle);
        parkingTicket.setParkingSpot(assignedParkingSpot);
        return parkingTicket;
    }

    public Invoice unParkVehicle(String parkingLotName, ParkingTicket parkingTicket, String exitGateName, int operatorId) throws Exception {
        ParkingLot parkingLot = parkingLotService.getParkingLot(parkingLotName);

        ParkingGate exitGate = parkingLot.getExitGates().stream()
                .filter(gate -> gate.getGateName().equalsIgnoreCase(exitGateName)).findFirst().get();

        parkingTicket.getParkingSpot().setVehicle(null);
        parkingTicket.getParkingSpot().setOccupied(false);
//        parkingTicket.setExitTime(LocalDateTime.now());
        parkingTicket.setExitTime(LocalDateTime.parse("2025-04-19T12:00:00.0")); // for testing
        parkingTicket.setExitGate(exitGate);
        parkingTicket.setExitOperator(operatorService.getOperator(operatorId).get());

        Invoice invoice = new Invoice();

        invoice.setParkingTicket(parkingTicket);

        double totalAmount = parkingAmountCalculator.calculate(parkingTicket);

        invoice.setTotalAmount(totalAmount);

        return invoice;
    }


}
