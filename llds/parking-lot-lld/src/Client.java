import exceptions.ParkingSpotNotAvailableException;
import models.*;

public class Client {

    public static void main(String[] args) {

        ParkingLotManagement parkingLotManagement = new ParkingLotManagement();

        Vehicle bike = new Vehicle(VehicleType.SMALL, "1");
        Vehicle car = new Vehicle(VehicleType.MEDIUM, "2");

        try {
            parkingLotManagement.viewParkingLot();

            ParkingTicket ticket1 = parkingLotManagement.parkVehicle(bike);
            parkingLotManagement.viewParkingLot();

            ParkingTicket ticket2 = parkingLotManagement.parkVehicle(car);
            parkingLotManagement.viewParkingLot();

            Invoice invoice1 = parkingLotManagement.unparkVehicle(ticket1);
            System.out.println("Invoice : Vehicle = " + invoice1.getVehicle().getRegistration() + ", Cost = "
                    + invoice1.getCost());
            parkingLotManagement.viewParkingLot();

            Invoice invoice2 = parkingLotManagement.unparkVehicle(ticket2);
            System.out.println("Invoice : Vehicle = " + invoice2.getVehicle().getRegistration() + ", Cost = "
                    + invoice2.getCost());
            parkingLotManagement.viewParkingLot();

        } catch (ParkingSpotNotAvailableException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }

}
