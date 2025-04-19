package services;

import models.ParkingLot;
import repositories.ParkingLotRepository;

public class ParkingLotService {

    private ParkingLotRepository parkingLotRepository = new ParkingLotRepository();

    public ParkingLot createParkingLot(String name) throws Exception {
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setName(name);
        parkingLotRepository.save(parkingLot);
        return parkingLot;
    }

    public ParkingLot getParkingLot(String name) throws Exception {
        return parkingLotRepository.findByName(name);
    }

    public void saveParkingLot(ParkingLot parkingLot) {
        parkingLotRepository.save(parkingLot);
    }

}
