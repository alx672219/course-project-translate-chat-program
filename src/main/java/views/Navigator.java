package views;

import javax.swing.*;

public interface Navigator {
    void showScreen(String name);
    JPanel getScreen(String name);
}
