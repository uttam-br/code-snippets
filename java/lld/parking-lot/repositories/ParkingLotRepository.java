package repositories;

import models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private static final Map<String, ParkingLot> parkingLotMap = new HashMap<>();

    public void save(ParkingLot parkingLot) {
        parkingLotMap.put(parkingLot.getName(), parkingLot);
    }

    public ParkingLot findByName(String name) throws Exception {
        if (!parkingLotMap.containsKey(name)) {
            throw new Exception("Parking lot with given name does not exists");
        }
        return parkingLotMap.get(name);
    }

}
