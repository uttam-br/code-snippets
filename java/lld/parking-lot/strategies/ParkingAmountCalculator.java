package strategies;

import models.ParkingTicket;

public interface ParkingAmountCalculator {

    double calculate(ParkingTicket parkingTicket);

}
