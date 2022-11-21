package views;

import javax.swing.*;
import java.awt.*;

public class CardLayoutNavigator implements Navigator {
    private final CardLayout layout;
    private final JPanel screens;

    public CardLayoutNavigator(CardLayout layout, JPanel screens) {
        this.layout = layout;
        this.screens = screens;
    }

    @Override
    public void showScreen(String name) {
        layout.show(screens, name);
    }
}
