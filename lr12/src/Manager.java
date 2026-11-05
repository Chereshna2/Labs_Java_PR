public class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public String toString() {
        return "Manager{name='" + name + "', id=" + id + ", salary=" + salary +
                ", teamSize=" + teamSize + "}";
    }
}