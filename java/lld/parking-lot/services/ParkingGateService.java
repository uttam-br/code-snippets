package services;

import models.Operator;
import models.ParkingGate;
import models.ParkingLot;
import models.constants.ParkingGateType;

import java.util.List;

public class ParkingGateService {

    private static final ParkingLotService parkingLotService = new ParkingLotService();
    private static final OperatorService operatorService = new OperatorService();

    public void createParkingGate(String parkingLotName, String gateName, ParkingGateType parkingGateType, List<Integer> operatorIds) throws Exception {
        List<Operator> operators = operatorService.getOperators(operatorIds);

        ParkingGate parkingGate = new ParkingGate();
        parkingGate.setGateName(gateName);
        parkingGate.setOperators(operators);
        parkingGate.setParkingGateType(parkingGateType);

        ParkingLot parkingLot = parkingLotService.getParkingLot(parkingLotName);

        switch (parkingGateType) {
            case ENTRY_GATE -> parkingLot.getEntryGates().add(parkingGate);
            case EXIT_GATE -> parkingLot.getExitGates().add(parkingGate);
        }

        parkingLotService.saveParkingLot(parkingLot);
    }

}
