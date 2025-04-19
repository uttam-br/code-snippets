package strategies;

import models.ParkingTicket;

import java.time.ZoneOffset;

public class TimeBasedParkingAmountCalculator implements ParkingAmountCalculator {

    @Override
    public double calculate(ParkingTicket parkingTicket) {
        double BIKE_PER_MINUTE_RATE = 1d;
        double TRUCK_PER_MINUTE_RATE = 10d;
        double CAR_PER_MINUTE_RATE = 4d;

        double amount = 0d;

        long minutes = (parkingTicket.getExitTime().toEpochSecond(ZoneOffset.UTC) - parkingTicket.getEntryTime().toEpochSecond(ZoneOffset.UTC)) / 60;

        switch (parkingTicket.getVehicle().getVehicleType()) {
            case TRUCK: {
                amount = minutes * TRUCK_PER_MINUTE_RATE;
                break;
            }
            case CAR: {
                amount = minutes * CAR_PER_MINUTE_RATE;
                break;
            }
            case BIKE: {
                amount = minutes * BIKE_PER_MINUTE_RATE;
                break;
            }
        }

        return amount;
    }

}
