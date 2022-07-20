package com.e_park.booking.dtos;

public class Car {

    private Long id;
    private String model;
    private String license;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public Car(String model, String license) {
        this.model = model;
        this.license = license;
    }
}
