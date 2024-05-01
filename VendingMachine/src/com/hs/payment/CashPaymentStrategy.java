package com.hs.payment;

public class CashPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Payment of $" + amount + " processed successfully (Cash)");
        return true;
    }
}
