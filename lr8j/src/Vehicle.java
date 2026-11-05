public class Vehicle {
    private String brand;
    private int year;
    private double speed;

    public Vehicle(String brand, int year, double speed) {
        this.brand = brand;
        this.year = year;
        this.speed = speed;
    }

    public void move() {
        System.out.println("Транспортное средство движется");
    }

    public void displayInfo() {
        System.out.println("Марка: " + brand + ", год: " + year +
                ", макс. скорость: " + speed + " км/ч");
    }
    public void test1() {
        System.out.println("Марка: " + brand + ", год: " + year +
                ", макс. скорость: " + speed + " км/ч");
    }
    public abstract int met();
}