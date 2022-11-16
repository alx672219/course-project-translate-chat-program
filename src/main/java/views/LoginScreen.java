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
public class LoginScreen extends JPanel implements ActionListener {
    /**
     * The username chosen by the user
     */
    HintTextField username = new HintTextField("LOGIN...");
    /**
     * The email chosen by the user
     */
    HintTextField email = new HintTextField("LOGIN...");
    /**
     * The password
     */
    HintPasswordField password = new HintPasswordField("LOGIN...  ");
    /**
     * The second password to make sure the user understands
     */
    HintPasswordField repeatPassword = new HintPasswordField("LOGIN...");
    /**
     * A dropdown with any possible language as a choice
     */
    LoginController controller;
    Navigator nav;


    /**
     * A window with a title and a JButton
     */
    public LoginScreen(LoginController controller,Navigator nav) {
        this.controller = controller;
        this.nav = nav;

        JLabel title = new JLabel("Login");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        username.setBorder(BorderFactory.createTitledBorder("Username"));
        email.setBorder(BorderFactory.createTitledBorder("Email"));

        JButton signUp = new JButton("Sign up");
        JButton login = new JButton("Login");

        JPanel buttons = new JPanel();
        buttons.add(signUp);
        buttons.add(login);


        signUp.addActionListener(this);
        login.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(username);
        this.add(email);
        this.add(password);
        this.add(repeatPassword);

        this.add(title);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        if (source.equals("Sign up")) {
            nav.showScreen("register");
        } else if (source.equals("Login")) {
            // TODO: Navigate to Login Page
            JOptionPane.showMessageDialog(this, "Not yet implemented!");
        }
    }
}

