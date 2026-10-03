package strategies.cost;

import models.ParkingTicket;

public interface ParkingCostCalculator {

    public double calculateParkingCost(ParkingTicket ticket);

}