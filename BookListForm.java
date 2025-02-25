package library;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookListForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("書籍一覧");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        String[] columns = {"ID", "タイトル", "著者", "ジャンル", "出版年"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        List<Book> books = BookDAO.listBooks();
        for (Book book : books) {
            Object[] row = {
                    book.getId(),
                    book.getTitle(),
                    book.getAuthor(),
                    book.getGenre(),
                    book.getYear()
            };
            tableModel.addRow(row);
        }

        frame.setVisible(true);
    }
}
