package com.UI;

import entities.User;
import services.DBInitializer;
import services.DBService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ProfileScreen extends JFrame{
    DBInitializer dbInitializer = new DBInitializer();
    DBService dbService = new DBService();
    private JButton button1;
    private JPanel panel1;


    public ProfileScreen() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    dbInitializer.init();
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }


                User user = null;
                String default_lang = "English";

                dbService.updateDefaultLang(user, default_lang);
            }
        });
    }

    public static void main(String[] args) {
        new ProfileScreen();
    }
}
