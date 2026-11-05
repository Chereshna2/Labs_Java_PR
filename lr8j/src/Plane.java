public class Plane extends Vehicle {
    private double altitude;

    public Plane(String brand, int year, double speed, double altitude) {
        super(brand, year, speed);
        this.altitude = altitude;
    }

    @Override
    public void move() {
        System.out.println("Летит в небе");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Высота полёта: " + altitude + " м");
    }


}