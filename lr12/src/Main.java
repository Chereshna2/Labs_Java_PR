import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание:");
        System.out.println("1 - Задание 1");
        System.out.println("2 - Задание 2");
        System.out.print("Ваш выбор: ");

        int choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                runTask1();
                break;
            case 2:
                runTask2();
                break;
            default:
                System.out.println("Неверный номер задания.");
        }

        scanner.close();
    }

    public static void runTask1() {
        Map<String, Employee> employees = new HashMap<>();

        employees.put("Alice", new Manager("Alice", 1, 5000, 5));
        employees.put("Bob", new Manager("Bob", 2, 5500, 8));
        employees.put("Carol", new Manager("Carol", 3, 6000, 3));

        employees.put("David", new Engineer("David", 4, 4000, "Java"));
        employees.put("Eve", new Engineer("Eve", 5, 4200, "Python"));
        employees.put("Frank", new Engineer("Frank", 6, 4500, "C++"));

        employees.put("Grace", new Intern("Grace", 7, 1000, 3));
        employees.put("Henry", new Intern("Henry", 8, 1200, 6));

        System.out.println("ЗАДАНИЕ 1:");
        Iterator<String> keyIterator = employees.keySet().iterator();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            Employee emp = employees.get(key);
            System.out.println("Ключ: " + key + " -> " + emp);
        }
    }

    public static void runTask2() {
        List<Student> students = new ArrayList<>();

        List<Integer> g1 = new ArrayList<>(); g1.add(4); g1.add(5); g1.add(4); g1.add(3); g1.add(5);
        List<Integer> g2 = new ArrayList<>(); g2.add(2); g2.add(3); g2.add(2); g2.add(2); g2.add(3);
        List<Integer> g3 = new ArrayList<>(); g3.add(5); g3.add(5); g3.add(5); g3.add(4); g3.add(5);
        List<Integer> g4 = new ArrayList<>(); g4.add(3); g4.add(3); g4.add(3); g4.add(3); g4.add(3);
        List<Integer> g5 = new ArrayList<>(); g5.add(1); g5.add(2); g5.add(1); g5.add(2); g5.add(1);
        List<Integer> g6 = new ArrayList<>(); g6.add(4); g6.add(4); g6.add(5); g6.add(4); g6.add(4);

        students.add(new Student(1, "Алексей", "Г1", 1, g1));
        students.add(new Student(2, "Борис", "Г1", 2, g2));
        students.add(new Student(3, "Виктория", "Г2", 1, g3));
        students.add(new Student(4, "Галина", "Г2", 3, g4));
        students.add(new Student(5, "Дмитрий", "Г3", 2, g5));
        students.add(new Student(6, "Елена", "Г3", 4, g6));

        System.out.println("ЗАДАНИЕ 2");
        System.out.println("Исходный список:");
        Iterator<Student> studentIterator = students.iterator();
        while (studentIterator.hasNext()) {
            Student s = studentIterator.next();
            System.out.println(s);
        }

        Iterator<Student> removeIterator = students.iterator();
        while (removeIterator.hasNext()) {
            if (removeIterator.next().getAverageGrade() < 3.0) {
                removeIterator.remove();
            }
        }

        System.out.println("\nПосле удаления студентов со средним баллом < 3:");
        Iterator<Student> afterRemoveIterator = students.iterator();
        while (afterRemoveIterator.hasNext()) {
            Student s = afterRemoveIterator.next();
            System.out.println(s);
        }

        Iterator<Student> courseIterator = students.iterator();
        while (courseIterator.hasNext()) {
            Student s = courseIterator.next();
            if (s.getAverageGrade() >= 3.0) {
                s.setCourse(s.getCourse() + 1);
            }
        }

        System.out.println("\nПосле перевода на следующий курс:");
        Iterator<Student> afterCourseIterator = students.iterator();
        while (afterCourseIterator.hasNext()) {
            Student s = afterCourseIterator.next();
            System.out.println(s);
        }

        System.out.println("\nСтуденты на 2 курсе:");
        printStudents(students, 2);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student a, Student b) {
                int gradeCompare;
                if (a.getAverageGrade() > b.getAverageGrade()) {
                    gradeCompare = -1;
                } else if (a.getAverageGrade() < b.getAverageGrade()) {
                    gradeCompare = 1;
                } else {
                    gradeCompare = 0;
                }

                if (gradeCompare != 0) {
                    return gradeCompare;
                }

                return (-1)*a.getName().compareTo(b.getName());
            }
        });

        System.out.println("\nПосле сортировки (по убыванию балла, затем по имени):");
        Iterator<Student> sortedIterator = students.iterator();
        while (sortedIterator.hasNext()) {
            Student s = sortedIterator.next();
            System.out.println("ID: " + s.getId() +
                    ", имя: " + s.getName() +
                    ", средний балл: " + String.format("%.2f", s.getAverageGrade()));
        }
    }

    public static void printStudents(List<Student> students, int course) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getCourse() == course) {
                System.out.println(s);
            }
        }
    }
}