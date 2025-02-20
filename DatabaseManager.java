package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseManager {
    // データベースのURL (library.dbのパス)
    private static final String URL = "jdbc:sqlite:src/library/library.db";

    // データベース接続を取得
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // テーブルを作成
    public static void initialize() {
        // テーブル作成のSQL
        String sql = "CREATE TABLE IF NOT EXISTS books (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "title TEXT NOT NULL, " +
                     "author TEXT NOT NULL, " +
                     "genre TEXT, " +
                     "year INTEGER)";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            // SQLを実行してテーブル作成
            stmt.execute(sql);
            System.out.println("テーブル作成完了");
        } catch (SQLException e) {
            // エラー発生時にエラーメッセージを表示
            e.printStackTrace();
        }
    }
}
