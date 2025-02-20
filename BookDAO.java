// src/library/BookDAO.java
package library;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // 書籍の追加 (CREATE)
    public static void addBook(String title, String author, String genre, int year) {
        String sql = "INSERT INTO books (title, author, genre, year) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.setInt(4, year);
            pstmt.executeUpdate();
            System.out.println("書籍を追加しました");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 書籍の更新 (UPDATE)
    public static void updateBook(int id, String title, String author, String genre, int year) {
        String sql = "UPDATE books SET title=?, author=?, genre=?, year=? WHERE id=?";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, title);
            pstmt.setString(2, author);
            pstmt.setString(3, genre);
            pstmt.setInt(4, year);
            pstmt.setInt(5, id);
            pstmt.executeUpdate();
            System.out.println("書籍を更新しました");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 書籍の削除 (DELETE)
    public static void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id=?";

        try (Connection conn = DatabaseManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("書籍を削除しました");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 書籍のリストを取得 (READ)
    public static List<Book> listBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");
                
             

                books.add(new Book(id, title, author, genre, year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }
}
