package services;

import models.ParkingFloor;
import models.ParkingLot;
import repositories.ParkingLotRepository;

import java.util.ArrayList;
import java.util.Optional;

public class ParkingFloorService {

    private final ParkingLotService parkingLotService = new ParkingLotService();
    private final ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

    public ParkingFloor createParkingFloor(String parkingLotName, int floorNumber) throws Exception {
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setFloor(floorNumber);

        ParkingLot parkingLot = parkingLotService.getParkingLot(parkingLotName);
        if (parkingLot.getParkingFloors() == null) {
            parkingLot.setParkingFloors(new ArrayList<>());
        }
        parkingLot.getParkingFloors().add(parkingFloor);

        parkingLotRepository.save(parkingLot);

        return parkingFloor;
    }

    public ParkingFloor getParkingFloor(String parkingLotName, int floorNumber) throws Exception {
        ParkingLot parkingLot = parkingLotRepository.findByName(parkingLotName);

        if (parkingLot.getParkingFloors() == null) {
            throw new Exception("Parking floor does not exists...");
        }

        Optional<ParkingFloor> parkingFloorOptional = parkingLot.getParkingFloors().stream()
                .filter(parkingFloor -> parkingFloor.getFloor() == floorNumber)
                .findFirst();

        if (parkingFloorOptional.isEmpty()) {
            throw new Exception("Parking floor does not exists...");
        }

        return parkingFloorOptional.get();
    }

}
