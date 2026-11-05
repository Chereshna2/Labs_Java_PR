import java.util.List;

public class Student {
    private int id;
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(int id, String name, String group, int course, List<Integer> grades) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (int g : grades) sum += g;
        return sum / grades.size();
    }

    public int getCourse() { return course; }
    public void setCourse(int course) { this.course = course; }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getGroup() { return group; }

    @Override
    public String toString() {
        return "ID: " + id + ", имя: " + name + ", группа: " + group +
                ", курс: " + course + ", средний балл: " +
                String.format("%.2f", getAverageGrade());
    }
}