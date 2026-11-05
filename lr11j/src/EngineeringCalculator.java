public class EngineeringCalculator extends Calculator {

    public EngineeringCalculator(String model, String version) {
        super(model, version);
    }

    @Override
    public String getDescription() {
        return "Инженерный калькулятор";
    }

    public int calculate(int a, int b, String operation) {
        switch (operation) {
            case "add": return a + b;
            case "sub": return a - b;
            case "mul": return a * b;
            case "div": return b != 0 ? a / b : 0;
            default: return 0;
        }
    }
}