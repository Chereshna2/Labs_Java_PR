package org.example;
class Car {
    private String brand;
    private String model;
    private int year;
    private int mileage;






































    public Car(String brand, String model, int year, int mileage) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.mileage = mileage;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public void drive(int km) {
        if (km > 0) {
            mileage += km;
        } else {
            System.out.println("Количество километров должно быть положительным!");
        }
    }

    public void displayInfo() {
        System.out.println("Автомобиль: " + brand + " " + model +
                ", год выпуска: " + year +
                ", пробег: " + mileage + " км");
    }
}


public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Avangard", 2020, 15000);

        car.displayInfo();

        car.drive(100);

        car.displayInfo();
    }
}
