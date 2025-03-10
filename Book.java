package library;

public class Book {
    private int id;
    private String title;
    private String author;
    private String genre;
    private int year;

    // 引数付きコンストラクタ
    public Book(int id, String title, String author, String genre, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    // ゲッターとセッター
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Year: " + year;
    }
}
