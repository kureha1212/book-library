package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDatabase2 {
    public static void main(String[] args) {
        // SQLiteデータベースに接続
        String url = "jdbc:sqlite:src/library/library.db";
        try (Connection conn = DriverManager.getConnection(url)) {
            // クエリを実行して結果を取得
            String sql = "SELECT * FROM books";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // 結果を表示
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String genre = rs.getString("genre");
                int year = rs.getInt("year");

                System.out.println("ID: " + id + ", Title: " + title + ", Author: " + author + ", Genre: " + genre + ", Year: " + year);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
//SQLite JDBCを使ってEclipse内で確認