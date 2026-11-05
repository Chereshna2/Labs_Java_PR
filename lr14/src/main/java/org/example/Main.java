package org.example;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1-5):");
        System.out.println("1 - Информация о группе");
        System.out.println("2 - 10 целых чисел и минимум");
        System.out.println("3 - Разделение чисел на кратные 3 и остальные");
        System.out.println("4 - Влажность воздуха");
        System.out.println("5 - Количество отрицательных чисел");
        System.out.print("Ваш выбор: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            switch (choice) {
                case 1:
                    File file1 = new File("group.txt");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {
                        writer.write("Группа: 5-04-0612-02\n");
                        writer.write("Специальность: Разработка и сопровождение ПО ИС\n");
                        writer.write("Курс: 2\n");
                    }
                    System.out.println("Информация о файле");
                    System.out.println("Имя файла: " + file1.getName());
                    System.out.println("Размер: " + file1.length() + " байт");
                    System.out.println("Путь: " + file1.getAbsolutePath());
                    System.out.println("Существует: " + (file1.exists() ? "Да" : "Нет"));

                    System.out.println("\nСодержимое файла");
                    try (BufferedReader reader = new BufferedReader(new FileReader(file1))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                        }
                    }
                    break;

                case 2:
                    File file2 = new File("numbers.txt");
                    System.out.println("Введите 10 целых чисел:");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
                        for (int i = 0; i < 10; i++) {
                            System.out.print("Число " + (i + 1) + ": ");
                            int num = scanner.nextInt();
                            writer.write(num + "\n");
                        }
                    }
                    System.out.println("\nЧтение из файла");
                    int min = Integer.MAX_VALUE;
                    try (BufferedReader reader = new BufferedReader(new FileReader(file2))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            int num = Integer.parseInt(line.trim());
                            System.out.println(num);
                            if (num < min) min = num;
                        }
                    }
                    System.out.println("Минимальное значение: " + min);
                    break;

                case 3:
                    File f = new File("f.txt");
                    File g = new File("g.txt");
                    File h = new File("h.txt");
                    Random random = new Random();

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(f))) {
                        for (int i = 0; i < 20; i++) {
                            writer.write(random.nextInt(100) + "\n");
                        }
                    }

                    try (BufferedReader reader = new BufferedReader(new FileReader(f));
                         BufferedWriter writerG = new BufferedWriter(new FileWriter(g));
                         BufferedWriter writerH = new BufferedWriter(new FileWriter(h))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            int num = Integer.parseInt(line.trim());
                            if (num % 3 == 0) {
                                writerG.write(num + "\n");
                            } else {
                                writerH.write(num + "\n");
                            }
                        }
                    }
                    System.out.println("Файлы g.txt и h.txt созданы.");
                    break;

                case 4:
                    File file4 = new File("humidity.txt");
                    System.out.println("Введите 12 значений влажности:");
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file4))) {
                        for (int i = 0; i < 5; i++) {
                            System.out.print("Значение " + (i + 1) + ": ");
                            String input = scanner.nextLine().trim();
                            input = input.replace(',', '.');

                            double val = Double.parseDouble(input);
                            writer.write(val + "\n");
                        }
                    }
                    System.out.println("\nРезультаты");
                    double sum = 0;
                    int count = 0;
                    try (BufferedReader reader = new BufferedReader(new FileReader(file4))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            double val = Double.parseDouble(line.trim());
                            sum += val;
                            count++;
                        }
                    }
                    System.out.printf("Средняя влажность: %.2f%n", sum / count);
                    break;

                case 5:
                    File file5 = new File("f_negative.txt");
                    Random random5 = new Random();

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(file5))) {
                        for (int i = 0; i < 10; i++) {
                            writer.write((random5.nextInt(100) - 50) + "\n");
                        }
                    }

                    int negatives = 0;
                    try (BufferedReader reader = new BufferedReader(new FileReader(file5))) {
                        String line;
                        while ((line = reader.readLine()) != null) {
                            int num = Integer.parseInt(line.trim());
                            if (num < 0) negatives++;
                        }
                    }
                    System.out.println("Количество отрицательных значений: " + negatives);
                    break;

                default:
                    System.out.println("Неверный номер задания.");
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("\nПрограмма завершена.");
        }
    }
}