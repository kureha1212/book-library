package library;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class BookUpdateForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("書籍更新");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(new JLabel("書籍更新画面"));
        frame.setVisible(true);
    }
}
