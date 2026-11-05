class Car {
    private String brand;
    private String model;
    private int year;
    private int mileage;
    private int a;
    private static int d;

    public int getA(){
        return this.a;
    }
    public void setA(int a)
    {
        this.a=a;
    }

    public Car(String brand, String model, int year, int mileage, int a)
    {
        this(brand, model, year, mileage);
        setA(a);
    }
    public static void test()
    {
        System.out.println(d);
    }
    public void test1()
    {
        System.out.println(brand+"  "+model+"  "+year+"  "+mileage+"  "+a);
    }
    /*
        Car a = new Car();
        a.test1();
        Car.test();
     */






























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