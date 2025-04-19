package models;

import models.constants.ParkingGateType;

import java.util.List;

public class ParkingGate {

    private String gateName;
    List<Operator> operators;
    private ParkingGateType parkingGateType;

    public String getGateName() {
        return gateName;
    }

    public void setGateName(String gateName) {
        this.gateName = gateName;
    }

    public List<Operator> getOperators() {
        return operators;
    }

    public void setOperators(List<Operator> operators) {
        this.operators = operators;
    }

    public ParkingGateType getParkingGateType() {
        return parkingGateType;
    }

    public void setParkingGateType(ParkingGateType parkingGateType) {
        this.parkingGateType = parkingGateType;
    }
}
