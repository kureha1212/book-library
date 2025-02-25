package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class BookForm {
    public static void main(String[] args) {
        // フレームの作成
        JFrame frame = new JFrame("書籍管理システム");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // ラベルとテキストボックスの作成
        JLabel titleLabel = new JLabel("タイトル:");
        titleLabel.setBounds(30, 30, 100, 25);
        frame.add(titleLabel);

        JTextField titleField = new JTextField();
        titleField.setBounds(150, 30, 200, 25);
        frame.add(titleField);

        JLabel authorLabel = new JLabel("著者:");
        authorLabel.setBounds(30, 70, 100, 25);
        frame.add(authorLabel);

        JTextField authorField = new JTextField();
        authorField.setBounds(150, 70, 200, 25);
        frame.add(authorField);

        JLabel genreLabel = new JLabel("ジャンル:");
        genreLabel.setBounds(30, 110, 100, 25);
        frame.add(genreLabel);

        JTextField genreField = new JTextField();
        genreField.setBounds(150, 110, 200, 25);
        frame.add(genreField);

        JLabel yearLabel = new JLabel("出版年:");
        yearLabel.setBounds(30, 150, 100, 25);
        frame.add(yearLabel);

        JTextField yearField = new JTextField();
        yearField.setBounds(150, 150, 200, 25);
        frame.add(yearField);

        // ボタンの作成
        JButton addButton = new JButton("書籍を追加");
        addButton.setBounds(150, 200, 120, 30);
        frame.add(addButton);

        // ボタンのアクション
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                String genre = genreField.getText();
                int year = Integer.parseInt(yearField.getText());

                BookDAO.addBook(title, author, genre, year);
                JOptionPane.showMessageDialog(frame, "書籍を追加しました！");
            }
        });

        // フレームを表示
        frame.setVisible(true);
    }
}
