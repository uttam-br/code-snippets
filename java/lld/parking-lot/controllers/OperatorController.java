package controllers;

import models.Operator;
import services.OperatorService;

import java.util.Optional;

public class OperatorController {

    private static final OperatorService operatorService = new OperatorService();

    public void createOperator(String parkingLotName, String operatorName) {
        try {
            operatorService.createOperator(parkingLotName, operatorName);
        } catch (Exception e) {
            System.out.println("Error occurred : " + e.getMessage());
        }
    }

    public Optional<Operator> getOperator(int operatorId) {
        return operatorService.getOperator(operatorId);
    }

}
