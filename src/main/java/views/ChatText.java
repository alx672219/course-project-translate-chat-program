package views;

import javax.swing.*;
import java.awt.*;

public class ChatText extends JTextPane {
    private Color borderColor = Color.BLUE;
    private Color bgColor = Color.GREEN;

    public ChatText() {
        setBackground(new Color(0, 0, 0, 0));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g2 = (Graphics2D) graphics;
        g2.setColor(bgColor);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 5, 5);
        super.paintComponent(graphics);
    }

}
