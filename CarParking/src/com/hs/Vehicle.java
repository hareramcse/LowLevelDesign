package com.hs;

public class Vehicle {
    private String licensePlate;
    private String type;
    private int size;

    public Vehicle(String licensePlate, String type, int size) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.size = size;
    }

    // Getters
    public String getLicensePlate() {
        return licensePlate;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }
}
