package com.hs;

import java.util.List;
import java.util.Optional;

public class VehicalParkingTest {
	public static void main(String[] args) throws InterruptedException {
		Floor floor1 = new Floor(1);
		floor1.addSpot(new ParkingSpot(1, 1, SpotType.MOTORCYCLE));
		floor1.addSpot(new ParkingSpot(2, 1, SpotType.COMPACT));
		floor1.addSpot(new ParkingSpot(3, 1, SpotType.LARGE));
		floor1.addSpot(new ParkingSpot(4, 1, SpotType.LARGE));

		Floor floor2 = new Floor(2);
		floor2.addSpot(new ParkingSpot(1, 2, SpotType.MOTORCYCLE));
		floor2.addSpot(new ParkingSpot(2, 2, SpotType.COMPACT));
		floor2.addSpot(new ParkingSpot(3, 2, SpotType.LARGE));
		floor2.addSpot(new ParkingSpot(4, 2, SpotType.LARGE));

		ParkingLot lot = new ParkingLot(List.of(floor1, floor2), new HourlyPricingStrategy());
		ParkingAttendant attendant = new ParkingAttendant(lot);

		Vehicle bike = new Vehicle("BIKE01", VehicleType.MOTORCYCLE);
		Vehicle car = new Vehicle("CAR01", VehicleType.CAR);
		Vehicle truck = new Vehicle("TRK01", VehicleType.TRUCK);

		System.out.println("Floor 1 compact available: " + attendant.availableSpots(1, SpotType.COMPACT));

		Optional<ParkingTicket> bikeTicket = attendant.parkVehicle(bike);
		Optional<ParkingTicket> carTicket = attendant.parkVehicle(car);
		Optional<ParkingTicket> truckTicket = attendant.parkVehicle(truck);

		bikeTicket.ifPresent(t -> System.out.println("Parked: " + t));
		carTicket.ifPresent(t -> System.out.println("Parked: " + t));
		truckTicket.ifPresent(t -> System.out.println("Parked: " + t));

		System.out.println("Floor 1 compact available after parking: " + attendant.availableSpots(1, SpotType.COMPACT));

		// truck needs 2 contiguous LARGE spots — uses floor 1; second truck spills to floor 2
		Vehicle truck2 = new Vehicle("TRK02", VehicleType.TRUCK);
		attendant.parkVehicle(truck2)
				.ifPresent(t -> System.out.println("Parked: " + t));

		if (carTicket.isPresent()) {
			Thread.sleep(50); // tiny duration so hourly fee logic runs
			attendant.exit(carTicket.get().ticketId())
					.ifPresent(r -> System.out.println("Exit " + carTicket.get().vehicle().licensePlate()
							+ " | fee=$" + r.fee() + " at " + r.exitTime()));
		}

		System.out.println("Floor 1 compact available after car exit: " + attendant.availableSpots(1, SpotType.COMPACT));
	}
}
