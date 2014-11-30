import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Container;

public class DungeonWindow {
    private JTextArea textArea = new JTextArea(40, 80);
    private JTextField textField = new JTextField();
    private JButton button = new JButton("Send");

    public void show() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container pane = frame.getContentPane();
        pane.add(new JScrollPane(textArea), BorderLayout.NORTH);
        pane.add(new JLabel("Send"), BorderLayout.LINE_START);
        pane.add(textField, BorderLayout.CENTER);
        pane.add(button, BorderLayout.LINE_END);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        (new DungeonWindow()).show();
    }
}
