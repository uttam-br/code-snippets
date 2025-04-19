
# LLD - Parking Lot

1. Requirements
   - Parking lot can have multiple floors
   - Parking lot can support parking for multiple type/size of parking spots
   - Parking lot can have multiple entry and exit gates
   - Gate can have one or more operators.
   - Customer can enter via any of the entry gate.
   - At entry gate, operator will give user the parking ticket.
   - Parking ticket will have start time, vehicle information, end time, parking floor, assigned parking spot.
   - Vehicle information contains vehicle number, type.
   - Customer can exit via any of the exit gate.
   - At exit gate, operator will generate bill.
   - Bill contains ticket information, and total amount.
   - Customer can pay via cash, or online.
   - Customer will get invoice after payment.

   - Good to have Requirements:
     - Parking lot can have multiple tiers of parking (Regular, Luxury, Ultra Luxury)


2. Entities

   - ParkingLot
     - name - String
     - parkingFloors - List<ParkingFloor>
     - entryGates - List<ParkingGate>
     - exitGates - List<ParkingGate>
   - ParkingFloor
     - floorNumber: int
     - parkingSpots: Map<ParkingSpotType, List<ParkingSpot>>
   - ParkingSpot
     - type: ParkingSpotType
     - occupied: boolean
     - parkingFloor: ParkingFloor
   - ParkingSpotType - ENUM{SMALL, REGULAR, LARGE}
   - ParkingGate
     - operators: List<Operator>
     - type: ParkingGateType (enum = {ENTRY_GATE, EXIT_GATE})
   - Customer
     - name: String
     - vehicles: List<Vehicle>
   - Operator
     - operatorId: int
     - name: String
   - ParkingTicket
     - customer: Customer
     - vehicle: Vehicle
     - startTime: DateTime
     - endTime: DateTime
     - parkingSpot: ParkingSpot
     - entryGate: ParkingGate
     - exitGate: ParkingGate
   - Vehicle
     - registrationNumber
     - type: VehicleType (CAR, BIKE, EV)
   - Bill
     - parkingTicket: ParkingTicket
     - paymentMethods: List<PaymentMethod>
     - paymentReciept: PaymentReceipt
     - totalAmount: double
   - PaymentMethod
     - amount: double
     - referenceId: String
     - type: ENUM(CASH, ONLINE)

3. Schema Design

4. Design Patterns
    - Singleton design pattern for ParkingLot
    - Factory Design Pattern for creating ParkingSpot objects.
    - Strategy pattern while generating bill.
    - Observer design pattern when parking spot becomes available.