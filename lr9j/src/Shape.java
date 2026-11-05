public abstract class Shape {
    private String color;
    private double x;
    private double y;

    public Shape(String color, double x, double y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor() { return color; }
    public double getX() { return x; }
    public double getY() { return y; }

    public void setColor(String color) { this.color = color; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public abstract double calculateArea();

    public abstract void draw();

    public void displayInfo() {
        System.out.println("Фигура: цвет = " + color + ", координаты центра = (" + x + "; " + y + ")");
    }
}