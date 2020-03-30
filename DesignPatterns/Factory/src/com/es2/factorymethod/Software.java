package com.es2.factorymethod;

public class Software implements Product{
    private String getB;

    protected Software() {
    }

    public String getBrand() {
        return this.getB;
    }

    public void setBrand(String brand) {
        this.getB = brand;
    }

}
