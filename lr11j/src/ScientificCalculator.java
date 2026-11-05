public class ScientificCalculator extends Calculator {

    public ScientificCalculator(String model, String version) {
        super(model, version);
    }

    @Override
    public String getDescription() {
        return "Научный калькулятор";
    }

    public double calculate(String operation, double a, double b) {
        switch (operation) {
            case "add": return a + b;
            case "sub": return a - b;
            case "mul": return a * b;
            case "div": return b != 0 ? a / b : 0;
            default: return 0;
        }
    }
}