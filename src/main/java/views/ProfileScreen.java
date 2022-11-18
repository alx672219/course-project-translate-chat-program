package views;

import profile_customization_use_case.CustomizationInputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProfileScreen extends JFrame{

    private CustomizationInputBoundary cib;


    public ProfileScreen() {

        setTitle("Profile");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(200, 100, 400, 200);

        JPanel panel1 = new JPanel();
        JButton setLang = new JButton();

        setLang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cib.changeLanguage();
            }
        });
    }

    public static void main(String[] args) {
        new ProfileScreen();
    }
}
