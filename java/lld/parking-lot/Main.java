import controllers.*;
import models.Invoice;
import models.ParkingLot;
import models.ParkingTicket;
import models.Payment;
import models.constants.ParkingGateType;
import models.constants.ParkingSpotType;
import models.constants.VehicleType;

import java.util.List;
import java.util.Optional;

public class Main {

    private static ParkingLotController parkingLotController = new ParkingLotController();
    private static ParkingGateController parkingGateController = new ParkingGateController();
    private static ParkingFloorController parkingFloorController = new ParkingFloorController();
    private static ParkingSpotController parkingSpotController = new ParkingSpotController();
    private static OperatorController operatorController = new OperatorController();
    private static PaymentController paymentController = new PaymentController();
    private static ParkingController parkingController = new ParkingController();

    public static void main(String[] args) {

        // create parking lot
        Optional<ParkingLot> parkingLotOptional = parkingLotController.createParkingLot("My Parking Lot");
        if (parkingLotOptional.isEmpty()) {
            System.out.println("Unable to create parking lot with given name");
            return;
        }
        ParkingLot parkingLot = parkingLotOptional.get();

        // create 2 parking floors
        parkingFloorController.createParkingFloor(parkingLot.getName(), 1);
        parkingFloorController.createParkingFloor(parkingLot.getName(), 2);

        // create 5 parking spots in first floor
        parkingSpotController.createParkingSpot(parkingLot.getName(), 1, ParkingSpotType.SMALL);
        parkingSpotController.createParkingSpot(parkingLot.getName(), 1, ParkingSpotType.SMALL);
        parkingSpotController.createParkingSpot(parkingLot.getName(), 1, ParkingSpotType.MEDIUM);
        parkingSpotController.createParkingSpot(parkingLot.getName(), 1, ParkingSpotType.MEDIUM);
        parkingSpotController.createParkingSpot(parkingLot.getName(), 1, ParkingSpotType.LARGE);

        // create 2 parking spots in second floor
        parkingSpotController.createParkingSpot(parkingLot.getName(), 2, ParkingSpotType.LARGE);
        parkingSpotController.createParkingSpot(parkingLot.getName(), 2, ParkingSpotType.SMALL);

        // create operators
        operatorController.createOperator(parkingLot.getName(), "A");
        operatorController.createOperator(parkingLot.getName(), "B");
        operatorController.createOperator(parkingLot.getName(), "C");
        operatorController.createOperator(parkingLot.getName(), "D");
        operatorController.createOperator(parkingLot.getName(), "E");
        operatorController.createOperator(parkingLot.getName(), "F");
        operatorController.createOperator(parkingLot.getName(), "G");

        // create 2 parking entry gates
        parkingGateController.createParkingGate(parkingLot.getName(), "ENTRY_1", ParkingGateType.ENTRY_GATE, List.of(1, 2));
        parkingGateController.createParkingGate(parkingLot.getName(), "ENTRY_2", ParkingGateType.ENTRY_GATE, List.of(3, 4));
        // create 1 parking exit gate
        parkingGateController.createParkingGate(parkingLot.getName(), "EXIT_1", ParkingGateType.EXIT_GATE, List.of(5, 6, 7));

        // print parking lot
        parkingLotController.printParkingLot(parkingLot.getName());

//        // park car, truck, and bike
        ParkingTicket carParkingTicket =
                parkingController.parkVehicle(parkingLot.getName(), "ENTRY_1", 1, "1", VehicleType.CAR);
        ParkingTicket truckParkingTicket =
                parkingController.parkVehicle(parkingLot.getName(), "ENTRY_2", 3, "2", VehicleType.TRUCK);
        ParkingTicket bikeParkingTicket =
                parkingController.parkVehicle(parkingLot.getName(), "ENTRY_2", 4, "3", VehicleType.BIKE);
        ParkingTicket truckParkingTicket2 =
                parkingController.parkVehicle(parkingLot.getName(), "ENTRY_2", 3, "4", VehicleType.TRUCK);
        ParkingTicket bikeParkingTicket2 =
                parkingController.parkVehicle(parkingLot.getName(), "ENTRY_2", 4, "5", VehicleType.BIKE);
        ParkingTicket bikeParkingTicket3 =
                parkingController.parkVehicle(parkingLot.getName(), "ENTRY_2", 4, "7", VehicleType.BIKE);
        ParkingTicket truckParkingTicket3 =
                parkingController.parkVehicle(parkingLot.getName(), "ENTRY_2", 3, "6", VehicleType.TRUCK);

        // print parking lot
        parkingLotController.printParkingLot(parkingLot.getName());

        // un-park truck
        Invoice truckParkingInvoice = parkingController.unParkVehicle(parkingLot.getName(), truckParkingTicket, "EXIT_1", 5);
        Payment payment = paymentController.makePayment(truckParkingInvoice);
        System.out.println("Total parking amount for truck " + truckParkingInvoice.getTotalAmount());

        // un-park bike
        Invoice bikeParkingInvoice = parkingController.unParkVehicle(parkingLot.getName(), bikeParkingTicket, "EXIT_1", 6);
        System.out.println("Total parking amount for bike " + bikeParkingInvoice.getTotalAmount());

        // print parking lot
        parkingLotController.printParkingLot(parkingLot.getName());

    }

}
