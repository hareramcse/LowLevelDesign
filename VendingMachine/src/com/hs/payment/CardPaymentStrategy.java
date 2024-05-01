package com.hs.payment;

public class CardPaymentStrategy implements PaymentStrategy {
    @Override
    public boolean pay(double amount) {
        System.out.println("Payment of $" + amount + " processed successfully (Card)");
        return true;
    }
}
