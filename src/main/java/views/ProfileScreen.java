package views;

import controllers.CustomizationController;
import profile_customization_use_case.CustomizationResponse;
import shared.UserDetails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ProfileScreen extends JPanel implements ActionListener{
    CustomizationController controller;

    JLabel nameLabel = new JLabel("Name");
    JLabel passLabel = new JLabel("Password");
    JLabel langLabel = new JLabel("Default Language");

    JTextField nameField = new JTextField(50);
    HintPasswordField passField = new HintPasswordField("Enter new password");
    JComboBox<String> langBox;
    UserDetails user;
    Navigator nav;
    HashMap<String, String> langs;


    public ProfileScreen(HashMap<String, String> languages, CustomizationController controller, UserDetails user, Navigator nav) {
        this.controller = controller;
        this.user = user;
        this.langs = languages;
        this.nav = nav;
        String[] langsAsString = languages.keySet().toArray(new String[0]);
        Arrays.sort(langsAsString);

        JLabel title = new JLabel("Profile");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton nameButton = new JButton("set name");
        JButton passButton = new JButton("set password");
        JButton langButton = new JButton("set default language");

        nameButton.addActionListener(this);
        passButton.addActionListener(this);
        langButton.addActionListener(this);

        nameField.setText(user.getUsername());

        JPanel nameSection = new JPanel();
        nameSection.add(nameLabel);
        nameSection.add(nameField);
        nameSection.add(nameButton);

        JPanel passSection = new JPanel();
        passSection.add(passLabel);
        passSection.add(passField);
        passSection.add(passButton);

        JPanel langSection = new JPanel();
        langSection.add(langLabel);
        this.langBox = new AutoFillDropdown(langsAsString);
        langSection.add(langBox);
        langSection.add(langButton);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(nameSection);
        this.add(passSection);
        this.add(langSection);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        String name = this.nameField.getText();
        String password = new String(this.passField.getPassword());
        String default_lang = langs.get((String) this.langBox.getSelectedItem());

        switch (source) {
            case "set name" -> {
                try {
                    CustomizationResponse resp = controller.changeName(name, default_lang, password, user);
                    JOptionPane.showMessageDialog(this, "Updated name!");
                    HomeScreen home = (HomeScreen) nav.getScreen("home");
                    home.setState(new UserDetails(resp.getName(), resp.getUid(), resp.getDefaultLanguage(), new ArrayList<>()));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this, exception.getMessage());
                }
            }
            case "set password" -> {
                System.out.println(password.length());
                try {
                    CustomizationResponse resp = controller.changePassword(name, default_lang, password, user);
                    JOptionPane.showMessageDialog(this, "Updated password!");
                    HomeScreen home = (HomeScreen) nav.getScreen("home");
                    home.setState(new UserDetails(resp.getName(), resp.getUid(), resp.getDefaultLanguage(), new ArrayList<>()));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this, exception.getMessage());
                }
            }
            case "set default language" -> {
                try {
                    CustomizationResponse resp = controller.changeLanguage(name, default_lang, password, user);
                    JOptionPane.showMessageDialog(this, "Updated default language!");
                    HomeScreen home = (HomeScreen) nav.getScreen("home");
                    home.setState(new UserDetails(resp.getName(), resp.getUid(), resp.getDefaultLanguage(), new ArrayList<>()));
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(this, exception.getMessage());
                }
            }
        }
    }
}
