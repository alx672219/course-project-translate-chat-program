package views;

import entities.User;
import profile_customization_use_case.CustomizationGateway;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class HomeScreen extends JPanel implements ActionListener{

    Map<String, Object> controllers;
    Navigator nav;
    User currUser;

    HashMap<String, String> langs;

    public HomeScreen(HashMap<String, String> langs, Map<String, Object> controllers, Navigator nav) {
        this.controllers = controllers;
        this.nav = nav;
        this.langs = langs;
    }

    public void finalizeScreen(User user) {
        this.currUser = user;
//        JLabel label = new JLabel(String.valueOf(currUser.getUser_id()));
//        this.add(label);
        //TODO: Add all the screens (ChatScreen, ProfileScreen, ContactScreen)
        BorderLayout borderLayout = new BorderLayout();
        this.setLayout(borderLayout);
        addLeftPanel();
        addRightPanel();
    }

    private void addRightPanel() {

        JPanel rightPanel = new JPanel();
        BorderLayout borderLayout =  new BorderLayout();
        rightPanel.setLayout(borderLayout);
        this.add(rightPanel, BorderLayout.EAST);
        this.putClientProperty("right", rightPanel);
        addOpenChatBtn(rightPanel);

    }

    private void addOpenChatBtn(JPanel panel) {
        JButton openChatBtn = new JButton("Open Chat");
        openChatBtn.addActionListener(this);
        panel.add(openChatBtn, BorderLayout.NORTH);
    }

    private void addLeftPanel() {
        JPanel leftPanel = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        leftPanel.setLayout(borderLayout);
        this.add(leftPanel, BorderLayout.WEST);
        this.putClientProperty("left", leftPanel);
        addButtons(leftPanel);
        addContactScreen(leftPanel);
    }

    private void addContactScreen(JPanel panel) {
        try {
            ContactScreen contactScreen =  new ContactScreen(currUser.getUser_id());
            panel.add(contactScreen, BorderLayout.SOUTH);
            panel.putClientProperty("contact", contactScreen);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void addButtons(JPanel panel) {
        JPanel topLeftPanel = new JPanel();
        BorderLayout borderLayout = new BorderLayout();
        topLeftPanel.setLayout(borderLayout);
        panel.add(topLeftPanel, BorderLayout.NORTH);
        topLeftPanel.add(new JLabel("Your User ID: " + String.valueOf(currUser.getUser_id())), BorderLayout.CENTER);
        addLogout(topLeftPanel);
        addCustomize(topLeftPanel);
    }

    private void addCustomize(JPanel panel) {
        JButton customizeBtn = new JButton("Customize");
        customizeBtn.addActionListener(this);
        panel.add(customizeBtn, BorderLayout.EAST);
    }

    private void addLogout(JPanel panel) {

        JButton logoutBtn = new JButton("Log out");
        logoutBtn.addActionListener(this);
        panel.add(logoutBtn, BorderLayout.WEST);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String source = e.getActionCommand();
        if (source.equals("Log out")) {
            nav.showScreen("login");
            this.removeAll();
            this.revalidate();
        } else if (source.equals("Customize")) {
            JFrame customizeWindow = new JFrame("Customize");
            CustomizationController cController = (CustomizationController) this.controllers.get("customization");
            Map<String, String> langs = new HashMap<>();


            ProfileScreen profileScreen = new ProfileScreen(this.langs, cController, currUser);
            customizeWindow.add(profileScreen);
            customizeWindow.pack();
            customizeWindow.setVisible(true);

        } else if (source.equals("Open Chat")) {
            ContactScreen contactScreen = (ContactScreen) ((JPanel) this.getClientProperty("left"))
                    .getClientProperty("contact");
            JPanel rightPanel = (JPanel) this.getClientProperty("right");
            int contactID = contactScreen.getSelectedRowUserID();
            if (contactID == -1) {
                JOptionPane.showMessageDialog(this, "Select a row.");
            } else {
                JLabel contactIDLabel = new JLabel("Contact ID:" + contactID);
                rightPanel.add(contactIDLabel, BorderLayout.SOUTH);
                addChatScreen(rightPanel, contactID);
            }

        }
    }

    private void addChatScreen(JPanel panel, int contactID) {
        int currUserID = this.currUser.getUser_id();
    }
}
