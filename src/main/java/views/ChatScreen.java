package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;

public class ChatScreen implements ActionListener {
    JTextField textField;
    private static JPanel jPanel;
    private static Box vertical = Box.createVerticalBox();

    private static JFrame jFrame = new JFrame();
    private static DataOutputStream dout;

    public ChatScreen() {
        jFrame.setLayout(null);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
