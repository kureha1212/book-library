package library;

import java.util.List;
// src/library/Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseManager.initialize();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- 書籍管理システム ---");
            System.out.println("1. 書籍を追加");
            System.out.println("2. 書籍を表示");
            System.out.println("3. 書籍を更新");
            System.out.println("4. 書籍を削除");
            System.out.println("0. 終了");
            System.out.print("選択してください: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // 改行文字を消費

            switch (choice) {
                case 1:
                    System.out.print("タイトル: ");
                    String title = scanner.nextLine();
                    System.out.print("著者: ");
                    String author = scanner.nextLine();
                    System.out.print("ジャンル: ");
                    String genre = scanner.nextLine();
                    System.out.print("出版年: ");
                    int year = scanner.nextInt();
                    BookDAO.addBook(title, author, genre, year);
                    break;

                
                case 2:
                    List<Book> books = BookDAO.listBooks();
                    if (books.isEmpty()) {
                        System.out.println("書籍がありません。");
                    } else {
                        for (Book book : books) {
                            System.out.println(book);
                        }
                    }
                    break;

                case 3:
                    System.out.print("更新する書籍のID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("新しいタイトル: ");
                    title = scanner.nextLine();
                    System.out.print("新しい著者: ");
                    author = scanner.nextLine();
                    System.out.print("新しいジャンル: ");
                    genre = scanner.nextLine();
                    System.out.print("新しい出版年: ");
                    year = scanner.nextInt();
                    BookDAO.updateBook(id, title, author, genre, year);
                    break;

                case 4:
                    System.out.print("削除する書籍のID: ");
                    id = scanner.nextInt();
                    BookDAO.deleteBook(id);
                    break;

                case 0:
                    System.out.println("システムを終了します。");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("無効な選択です。もう一度選んでください。");
            }
        }
    }
}
