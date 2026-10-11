package com.cars;

public class Car{
    private String make, model, vin, plateNumber;
    private int year, millage;

    public String getMake(){
        return make;
    }

    public String getModel(){
        return model;
    }

    public String getVin(){
        return vin;
    }

    public String getPlateNumber(){
        return plateNumber;
    }

    public int getYear(){
        return year;
    }

    public int getMillage(){
        return millage;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMillage(int millage) {
        this.millage = millage;
    }

    
}