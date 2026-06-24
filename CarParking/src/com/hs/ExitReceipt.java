package com.hs;

import java.time.LocalDateTime;

public record ExitReceipt(String ticketId, double fee, LocalDateTime exitTime) {
}
