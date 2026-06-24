package com.hs;

import java.time.LocalDate;

public record ReturnReceipt(String rentalId, LocalDate returnDate, double lateFee, double totalDue) {
}
