public class Intern extends Employee {
    private int duration;

    public Intern(String name, int id, double salary, int duration) {
        super(name, id, salary);
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Intern{name='" + name + "', id=" + id + ", salary=" + salary +
                ", duration=" + duration + "}";
    }
}