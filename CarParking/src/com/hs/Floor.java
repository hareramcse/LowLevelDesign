package com.hs;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Floor {
	private final int floorNumber;
	private final List<ParkingSpot> spots = new ArrayList<>();

	public Floor(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int floorNumber() {
		return floorNumber;
	}

	public void addSpot(ParkingSpot spot) {
		spots.add(spot);
	}

	public int countAvailable(SpotType type) {
		return (int) spots.stream().filter(s -> s.type() == type && !s.isOccupied()).count();
	}

	Optional<List<ParkingSpot>> findAndReserve(Vehicle vehicle) {
		VehicleType vehicleType = vehicle.vehicleType();
		for (SpotType preferred : preferredSpotOrder(vehicleType)) {
			if (vehicleType == VehicleType.TRUCK) {
				Optional<List<ParkingSpot>> pair = findContiguousLargePair();
				if (pair.isPresent()) {
					pair.get().forEach(s -> s.setOccupied(true));
					return pair;
				}
			} else {
				Optional<ParkingSpot> spot = findSingleSpot(preferred, vehicleType);
				if (spot.isPresent()) {
					spot.get().setOccupied(true);
					return Optional.of(List.of(spot.get()));
				}
			}
		}
		return Optional.empty();
	}

	private List<SpotType> preferredSpotOrder(VehicleType vehicleType) {
		return switch (vehicleType) {
			case MOTORCYCLE -> List.of(SpotType.MOTORCYCLE, SpotType.COMPACT, SpotType.LARGE);
			case CAR -> List.of(SpotType.COMPACT, SpotType.LARGE);
			case TRUCK -> List.of(SpotType.LARGE);
		};
	}

	private Optional<ParkingSpot> findSingleSpot(SpotType spotType, VehicleType vehicleType) {
		return spots.stream()
				.filter(s -> s.type() == spotType && !s.isOccupied() && ParkingSpot.canFit(vehicleType, s.type()))
				.findFirst();
	}

	private Optional<List<ParkingSpot>> findContiguousLargePair() {
		for (int i = 0; i < spots.size() - 1; i++) {
			ParkingSpot a = spots.get(i);
			ParkingSpot b = spots.get(i + 1);
			if (a.type() == SpotType.LARGE && b.type() == SpotType.LARGE
					&& !a.isOccupied() && !b.isOccupied()
					&& b.spotNumber() == a.spotNumber() + 1) {
				return Optional.of(List.of(a, b));
			}
		}
		return Optional.empty();
	}
}
