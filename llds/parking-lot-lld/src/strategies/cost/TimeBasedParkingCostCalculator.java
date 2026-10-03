package strategies.cost;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

import models.*;

public class TimeBasedParkingCostCalculator implements ParkingCostCalculator {

    private final Integer PER_HOUR_CHARAGES = 20;
    private final Integer PER_MINUTE_CHARGES = 2;

    private final Map<VehicleType, Double> parkingCostMultiplier;

    public TimeBasedParkingCostCalculator() {
        parkingCostMultiplier = new HashMap<>();

        parkingCostMultiplier.put(VehicleType.LARGE, 2.0);
        parkingCostMultiplier.put(VehicleType.MEDIUM, 1.2);
        parkingCostMultiplier.put(VehicleType.SMALL, 1.0);
    }

    @Override
    public double calculateParkingCost(ParkingTicket ticket) {
        // LocalDateTime startsAt = ticket.getStartsAt();
        LocalDateTime startsAt = LocalDateTime.of(2026, 10, 01, 10, 0);
        LocalDateTime endsAt = ticket.getEndsAt();

        Duration duration = Duration.between(startsAt, endsAt);

        long hours = duration.toHours();
        long minutes = duration.toMinutes() - (hours * 60);

        return parkingCostMultiplier.getOrDefault(ticket.getVehicle().getType(), 1.0)
                * (hours * PER_HOUR_CHARAGES + minutes * PER_MINUTE_CHARGES);
    }

}
