public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Avangard", 2020, 15000);

        car.displayInfo();

        car.drive(100);

        car.displayInfo();
    }
}
