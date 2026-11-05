public class Main {
    public static void main(String[] args) {

        Book b1 = new Book("Война и мир", "Толстой", 999);
        Book b2 = new Book("Преступление и наказание", "Достоевский", 595);
        Book b3 = new Book("Джульетта", "Толстой", 687);
        Book b4 = new Book("Ночь", "Чехов", 798);


        b1.displayInfo();
        b2.displayInfo();
        b3.displayInfo();
        b4.displayInfo();


        System.out.println("Среднее количество страниц: " + Book.getAveragePages());
    }
}