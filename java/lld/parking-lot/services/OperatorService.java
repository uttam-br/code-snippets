package services;

import models.Operator;
import models.ParkingLot;
import repositories.OperatorRepository;

import java.util.List;
import java.util.Optional;

public class OperatorService {

    public static final ParkingLotService parkingLotService = new ParkingLotService();
    private static final OperatorRepository operatorRepository = new OperatorRepository();

    public void createOperator(String parkingLotName, String operatorName) {
        try {
            ParkingLot parkingLot = parkingLotService.getParkingLot(parkingLotName);
            Operator operator = new Operator();
            operator.setName(operatorName);
            operatorRepository.save(operator);

            parkingLot.getOperators().add(operator);
            parkingLotService.saveParkingLot(parkingLot);
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }

    public Optional<Operator> getOperator(int operatorId) {
        try {
            Operator operator = operatorRepository.getById(operatorId);
            return Optional.of(operator);
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
        return Optional.empty();
    }

    public List<Operator> getOperators(List<Integer> operatorIds) {
        return operatorIds.stream()
                .filter(operatorId -> getOperator(operatorId).isPresent())
                .map(operatorId -> getOperator(operatorId).get())
                .toList();
    }

}
