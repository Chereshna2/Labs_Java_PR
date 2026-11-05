public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator("Casio", "1.0");
        ScientificCalculator sciCalc = new ScientificCalculator("Casio", "2.0");
        EngineeringCalculator engCalc = new EngineeringCalculator("Casio", "3.0");

        System.out.println("=== Перегрузка в базовом классе ===");
        System.out.println("calculate(2, 3)       = " + calc.calculate(2, 3));
        System.out.println("calculate(2, 3, 4)    = " + calc.calculate(2, 3, 4));
        System.out.println("calculate(2.5, 3.5)   = " + calc.calculate(2.5, 3.5));
        System.out.println("calculate(2, 3.5)     = " + calc.calculate(2, 3.5));

        System.out.println("\n=== Переопределение getDescription() ===");
        System.out.println(calc.getDescription());
        System.out.println(sciCalc.getDescription());
        System.out.println(engCalc.getDescription());

        System.out.println("\n=== Уникальные перегруженные методы наследников ===");
        System.out.println("sciCalc.calculate(\"add\", 2.5, 3.5) = " + sciCalc.calculate("add", 2.5, 3.5));
        System.out.println("engCalc.calculate(10, 5, \"mul\")    = " + engCalc.calculate(10, 5, "mul"));

        System.out.println("\n=== Полиморфизм: массив базового типа ===");
        Calculator[] calculators = {calc, sciCalc, engCalc};
        for (Calculator c : calculators) {
            System.out.println(c.getDescription());
        }
    }
}