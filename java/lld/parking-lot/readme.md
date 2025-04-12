
# LLD - Parking Lot

1. Requirements

- Parking lot can have multiple floors
- Parking lot can support parking for multiple type/size of parking spots
- Parking lot can have multiple entry and exit gates
- Gate can have one or more operators.
- Parking lot can have multiple tiers of parking (Regular, Luxury, Ultra Luxury) // good to have req.
- Customer can enter via any of the entry gate.
- At entry gate, operator will give user the parking ticket.
- Parking ticket will have start time, vehicle information, end time, parking floor, assigned parking spot.
- Vehicle information contains vehicle number, type.
- Customer can exit via any of the exit gate.
- At exit gate, operator will generate bill.
- Bill contains ticket information, and total amount.
- Customer can pay via cash, or online.
- Customer will get invoice after payment.


2. Entities

   - ParkingLot
     - name - String
     - parkingFloors - List<ParkingFloor>
     - parkingGates - List<ParkingGate>
   - ParkingFloor
     - floorNumber: int
     - parkingSpots: Map<ParkingSpotType, List<ParkingSpot>>
   - ParkingSpot
     - type: ParkingSpotType
     - occupied: boolean
     - parkingFloor: ParkingFloor
   - ParkingSpotType (ENUM)
     - SMALL
     - REGULAR
     - LARGE 
   - ParkingGate
     - operators: List<Operator>
     - type: ParkingGateType
   - Customer
     - name: String
     - address: Location
     - vehicles: List<Vehicle>
   - Operator
     - name: String
     - userid: String
     - password: String
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
     - payment: Payment
     - totalAmount: double
   - Payment
     - paymentMethods: List<PaymentMethod>
     - status: ENUM(SUCCESS, FAILED)
   - PaymentMethod
     - amount: double
     - referenceId: String
     - type: ENUM(CASH, ONLINE)
   - ParkingGateType (ENUM)
     - ENTRY_GATE
     - EXIT_GATE

3. Schema
    - Determine while coding. Easier.

4. Design Patterns
    - Factory Design Pattern for creating ParkingSpot objects.
    - Strategy pattern while generating bill.
    - Observer design pattern when parking spot becomes available.
    - 