package models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ParkingTicket {

    private Customer customer;
    private Vehicle vehicle;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private ParkingSpot parkingSpot;

}
