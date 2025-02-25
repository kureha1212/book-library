package library;
import javax.swing.JButton;
import javax.swing.JFrame;

public class MainMenu {
    public static void main(String[] args) {
        JFrame frame = new JFrame("書籍管理システム");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton addButton = new JButton("書籍を追加");
        addButton.setBounds(100, 50, 200, 30);
        frame.add(addButton);

        JButton listButton = new JButton("書籍を表示");
        listButton.setBounds(100, 100, 200, 30);
        frame.add(listButton);

        JButton updateButton = new JButton("書籍を更新");
        updateButton.setBounds(100, 150, 200, 30);
        frame.add(updateButton);

        JButton deleteButton = new JButton("書籍を削除");
        deleteButton.setBounds(100, 200, 200, 30);
        frame.add(deleteButton);

        // アクション設定
        addButton.addActionListener(e -> BookForm.main(null));
        listButton.addActionListener(e -> BookListForm.main(null));
        updateButton.addActionListener(e -> BookUpdateForm.main(null));
        deleteButton.addActionListener(e -> BookDeleteForm.main(null));

        frame.setVisible(true);
    }
}
