package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Frameworks/Drivers layer

/**
 * A basic registration screen with text fields and two buttons, the "Sign Up" button will
 * attempt to create an account while the "login" button will navigate to the login page.
 */
public class RegisterScreen extends JPanel implements ActionListener {
    /**
     * The username chosen by the user
     */
    HintTextField username = new HintTextField("Enter username...");
    /**
     * The email chosen by the user
     */
    HintTextField email = new HintTextField("Enter email...");
    /**
     * The password
     */
    HintPasswordField password = new HintPasswordField("Enter password...  ");
    /**
     * The second password to make sure the user understands
     */
    HintPasswordField repeatPassword = new HintPasswordField("Confirm password...");
    /**
     * A dropdown with any possible language as a choice
     */
    JComboBox default_lang;


    /**
     * A window with a title and a JButton
     */
    public RegisterScreen(String[] languages) {
        this.default_lang = new AutoFillDropdown(languages);

        JLabel title = new JLabel("Register");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        username.setBorder(BorderFactory.createTitledBorder("Username"));
        email.setBorder(BorderFactory.createTitledBorder("Email"));

        JButton signUp = new JButton("Sign up");
        JButton login = new JButton("Login");


        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(login);

        // Allows you to type into the dropdown menu
        default_lang.setEditable(true);

        signUp.addActionListener(this);
        login.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(username);
        this.add(email);
        this.add(password);
        this.add(repeatPassword);
        this.add(default_lang);

        this.add(title);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO: Implement actionPerformed
    }
}
