public class Calculator {
    private String model;
    private String version;

    public Calculator(String model, String version) {
        this.model = model;
        this.version = version;
    }

    public int calculate(int a, int b) {
        return a + b;
    }

    public int calculate(int a, int b, int c) {
        return a + b + c;
    }

    public double calculate(double a, double b) {
        return a + b;
    }

    public double calculate(int a, double b) {
        return a * b;
    }

    public String getDescription() {
        return "Обычный калькулятор";
    }

    public String getModel() {
        return model;
    }

    public String getVersion() {
        return version;
    }
}