package com.hs;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.hs.payment.CreditCardPayment;
import com.hs.payment.PaymentMethod;
import com.hs.strategy.DailyRentalStrategy;
import com.hs.strategy.WeeklyRentalStrategy;

public class CarRentalSystemTest {
	public static void main(String[] args) {
		RentalSystem rentalSystem = new RentalSystem();
		rentalSystem.addCar(1, "Toyota Camry", 50.0);
		rentalSystem.addMotorcycle(2, "Honda CBR", 30.0);

		Customer customer1 = new Customer(101, "John Doe", "123-456-7890");
		Customer customer2 = new Customer(102, "Jane Smith", "987-654-3210");
		rentalSystem.addCustomer(customer1);
		rentalSystem.addCustomer(customer2);

		PaymentMethod creditCard = new CreditCardPayment("1234 5678 9012 3456", "12/25", "123");

		LocalDate week1Start = LocalDate.of(2026, 7, 1);
		LocalDate week1End = LocalDate.of(2026, 7, 6);

		List<Vehicle> available = rentalSystem.searchAvailable(week1Start, week1End, VehicleType.CAR);
		System.out.println("Cars available Jul 1-6: " + available.size());

		Optional<Rental> rental1 = rentalSystem.reserve(101, 1, week1Start, week1End, new DailyRentalStrategy(),
				creditCard);

		// Overlapping reservation should fail
		rentalSystem.reserve(102, 1, LocalDate.of(2026, 7, 3), LocalDate.of(2026, 7, 8),
				new DailyRentalStrategy(), creditCard);

		// Non-overlapping reservation should succeed
		rentalSystem.reserve(102, 1, LocalDate.of(2026, 7, 10), LocalDate.of(2026, 7, 12),
				new DailyRentalStrategy(), creditCard);

		// Weekly pricing on motorcycle
		rentalSystem.reserve(101, 2, LocalDate.of(2026, 8, 1), LocalDate.of(2026, 8, 8),
				new WeeklyRentalStrategy(), creditCard);

		rentalSystem.displayFleet();
		System.out.println("Active rentals: " + rentalSystem.getActiveRentals().size());

		// Return with late fee (due Jul 6, returned Jul 8)
		rental1.ifPresent(r -> rentalSystem.returnRental(r.rentalId(), LocalDate.of(2026, 7, 8))
				.ifPresent(receipt -> System.out.println("Returned " + receipt.rentalId() + " | late fee=$"
						+ receipt.lateFee())));

		System.out.println("Active rentals after return: " + rentalSystem.getActiveRentals().size());
	}
}
