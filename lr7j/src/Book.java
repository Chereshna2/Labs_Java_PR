class Book {
    private String title;
    private String author;
    private int pages;


    private static int totalBooks = 0;
    private static int totalPages = 0;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;

        totalBooks++;
        totalPages += pages;
    }


    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }

    public static int getAveragePages() {
        if (totalBooks == 0) return 0;
        return totalPages / totalBooks;
    }

    public void displayInfo() {
        System.out.println("Книга: " + title + ", автор: " + author + ", страниц: " + pages);
    }
}
