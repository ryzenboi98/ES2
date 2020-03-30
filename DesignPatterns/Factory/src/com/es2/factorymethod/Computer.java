package com.es2.factorymethod;

public class Computer implements Product{
    private String getB;

    protected Computer() {
    }

    public String getBrand() {
        return getB;
    }

    public void setBrand(String brand) {
        this.getB = brand;
    }
}
