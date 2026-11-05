public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[5];

        vehicles[0] = new Car("Toyota", 2020, 220, 4);
        vehicles[1] = new Car("BMW", 2022, 250, 2);
        vehicles[2] = new Car("Kia", 2018, 190, 4);
        vehicles[3] = new Plane("Boeing 737", 2015, 850, 11000);
        vehicles[4] = new Plane("Airbus A320", 2019, 870, 12000);

        for (Vehicle v : vehicles) {
            v.displayInfo();
            v.move();
            System.out.println("----------------------------------");
        }
        Vehicle vehicle = new Car("Toyota", 2020, 220, 4);
        Car car = new Car("Toyota", 2020, 220, 4);
        vehicle.test1();
        vehicle.test2();
        car.test1();
        car.test2();
    }
}