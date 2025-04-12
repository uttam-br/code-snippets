package models;

import models.enums.ParkingGateType;

import java.util.List;

public class ParkingGate {

    private List<Operator> operators;
    private ParkingGateType type;


    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public ParkingGateType getType() {
        return type;
    }

    public void setType(ParkingGateType type) {
        this.type = type;
    }
}
