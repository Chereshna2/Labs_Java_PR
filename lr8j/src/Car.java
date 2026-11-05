public class Car extends Vehicle {
    private int doors;

    public Car(String brand, int year, double speed, int doors) {
        super(brand, year, speed);
        this.doors = doors;
    }

    @Override
    public void move() {
        System.out.println("Едет по дороге");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Количество дверей: " + doors);
    }
    public void test2() {
        System.out.println("Количество дверей: " + doors);
    }

}