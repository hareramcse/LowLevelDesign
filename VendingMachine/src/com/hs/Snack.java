package com.hs;

class Snack implements Product {
    private String name;
    private double price;

    public Snack(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
