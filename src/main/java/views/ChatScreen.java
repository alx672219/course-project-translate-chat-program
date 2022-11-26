package views;

import entities.Chat;
import entities.Message;
import entities.User;

import gateways.MessageDeleteFirebaseSystem;
import gateways.MessageEditFirebaseSystem;
import message_edit_delete_use_case.*;

import gateways.MessageSearchFirebaseSystem;
import message_search_use_case.MessageSearchGateway;
import message_search_use_case.MessageSearchInputBoundary;
import message_search_use_case.MessageSearchInteractor;
import message_search_use_case.MessageSearchOutputBoundary;

import services.DBInitializer;
import services.DBService;
import user_send_message.MessageInputBoundary;
import user_send_message.MessageInteractor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.ExecutionException;

import javax.swing.*;
import javax.swing.text.BadLocationException;

public class ChatScreen extends JPanel {

    String      appName     = "Translation Chat App";
    ChatScreen     mainGUI;
    JFrame      newFrame    = new JFrame(appName);
    JButton     sendMessage;
    JTextField  messageBox;
    JTextPane chatBox;
    JTextField  usernameChooser;
    JFrame      preFrame;

    DBInitializer dbInitializer;

    String  username;

    User sender;

    User receiver;

    MessageEditController editController;
    MessageDeleteController deleteController;
    MessageSearchController searchController;

    SendMessageController sendMessageController;

    int chatID;

    int senderID;

    int receiverID;

    String senderName;

    ArrayList<Message> messages;

    Navigator nav;

//    public static void main(String[] args) throws ParseException, ExecutionException, InterruptedException, FileNotFoundException {
//
//        MessageEditGateway eGateway = new MessageEditFirebaseSystem();
//        MessageEditOutputBoundary ePresenter = new MessageEditPresenter();
//        MessageEditInputBoundary eInteractor  = new MessageEditInteractor(eGateway, ePresenter);
//        MessageEditController eController = new MessageEditController(eInteractor);
//
//        MessageDeleteGateway dGateway = new MessageDeleteFirebaseSystem();
//        MessageDeleteOutputBoundary dPresenter = new MessageDeletePresenter();
//        MessageDeleteInputBoundary dInteractor  = new MessageDeleteInteractor(dGateway, dPresenter);
//        MessageDeleteController dController = new MessageDeleteController(dInteractor);
//
//        MessageSearchGateway sGateway = new MessageSearchFirebaseSystem();
//        MessageSearchOutputBoundary sPresenter = new MessageSearchPresenter();
//        MessageSearchInputBoundary sInteractor  = new MessageSearchInteractor(sGateway, sPresenter);
//        MessageSearchController sController = new MessageSearchController(sInteractor);
//
//        MessageInputBoundary messageInteractor = new MessageInteractor();
//        SendMessageController sendMessageController = new SendMessageController(messageInteractor);
//
//        DBInitializer dbInitializer = new DBInitializer();
//        dbInitializer.init();
//        DBService dbService = new DBService();
//        ArrayList<Message> messages = dbService.getAllMessages(3);
//
//        User sender = dbService.getUserDetails(4);
//        String senderName = sender.getName();
//
//
//
//        new ChatScreen(4, 5, 3, senderName, eController, dController, sController, sendMessageController, messages);
//    }

    public ChatScreen(Navigator nav, int senderID, int receiverID, int chatID, String senderName,
                      MessageEditController editController, MessageDeleteController deleteController,
                      MessageSearchController searchController, SendMessageController sendMessageController,
                      ArrayList<Message> messages) {
        this.deleteController = deleteController;
        this.editController = editController;
        this.searchController = searchController;
        this.chatID = chatID;
        this.senderID = senderID;
        this.receiverID = receiverID;
        this.senderName = senderName;
        this.sendMessageController = sendMessageController;
        this.messages = messages;
        this.nav = nav;

        this.mainGUI = this;
        this.runChatScreen();
    }

    public void runChatScreen() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager
                                .getSystemLookAndFeelClassName());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    mainGUI.display();
                }
            });
        }

    public void display() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel searchBarPanel = new SearchBarPanel(searchController, chatID);

        mainPanel.add(searchBarPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLUE);
        southPanel.setLayout(new GridBagLayout());

        messageBox = new JTextField(30);
        messageBox.requestFocusInWindow();

        sendMessage = new JButton("Send Message");
        sendMessage.addActionListener(new sendMessageButtonListener());

        chatBox = new JTextPane();
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        //chatBox.setLineWrap(true);

        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.LINE_START;
        left.fill = GridBagConstraints.HORIZONTAL;
        left.weightx = 512.0D;
        left.weighty = 1.0D;

        GridBagConstraints right = new GridBagConstraints();
        right.insets = new Insets(0, 10, 0, 0);
        right.anchor = GridBagConstraints.LINE_END;
        right.fill = GridBagConstraints.NONE;
        right.weightx = 1.0D;
        right.weighty = 1.0D;

        southPanel.add(messageBox, left);
        southPanel.add(sendMessage, right);

        mainPanel.add(BorderLayout.SOUTH, southPanel);

        // Initialize chatbox with all saved messages from the chat
        for (Message currMessage : this.messages) {
            JTextArea messageArea = new JTextArea();
            messageArea.setLineWrap(true);
            messageArea.setEditable(false);
            messageArea.setFont(new Font("Serif", Font.PLAIN, 15));
            messageArea.setText("<" + senderName + ">:  " + currMessage.getMessage());
            //chatBox.setCaretPosition(chatBox.getDocument().getLength());
            chatBox.setSelectionStart(chatBox.getDocument().getLength());
            chatBox.setSelectionEnd(chatBox.getDocument().getLength());
            chatBox.insertComponent(messageArea);

            try {
                chatBox.getDocument().insertString(chatBox.getDocument().getLength(),"\n", null);
            } catch (BadLocationException e) {
                throw new RuntimeException(e);
            }
        }

        newFrame.add(mainPanel);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(470, 300);
        newFrame.setVisible(true);
    }

    public JTextArea displayMessage() {
        JTextArea messageArea = new JTextArea();
        messageArea.setLineWrap(true);
        messageArea.setEditable(false);
        messageArea.setFont(new Font("Serif", Font.PLAIN, 15));
        messageArea.setText("<" + senderName + ">:  " + messageBox.getText());
        //chatBox.setCaretPosition(chatBox.getDocument().getLength());
        chatBox.setSelectionStart(chatBox.getDocument().getLength());
        chatBox.setSelectionEnd(chatBox.getDocument().getLength());
        chatBox.insertComponent(messageArea);
        try {
            chatBox.getDocument().insertString(chatBox.getDocument().getLength(),"\n", null);
        } catch (BadLocationException e) {
            throw new RuntimeException(e);
        }
        // Persists message to database
        sendMessage();

        // Clear the message box for new input
        messageBox.setText("");

        // Clear the message box for new input
        messageBox.setText("");

        return messageArea;
    }

    public void sendMessage() {
        Date curr_date = new Date();

        try {
            sendMessageController.sendMessage(chatID, messageBox.getText(), senderID, receiverID, curr_date);
        } catch (ExecutionException | InterruptedException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    class sendMessageButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (messageBox.getText().length() < 1) {
                // do nothing
            } else if (messageBox.getText().equals(".clear")) {
                chatBox.setText("Cleared all messages\n");
                messageBox.setText("");
            } else {
                JTextArea messageArea = displayMessage();

                List<Integer> ids = new ArrayList<>();
//                ids.add(nextMessageID);
                ids.add(chatID); //Change to chatID later

                List<Object> controllers = new ArrayList<>();
                controllers.add(editController);
                controllers.add(deleteController);

                messageArea.addMouseListener(new EditDeletePopupListener(ids, controllers, messageArea,
                        (JPanel) messageBox.getParent(), chatBox, senderName));

            }

            messageBox.requestFocusInWindow();
        }
    }
    static class EditDeletePopupListener extends MouseAdapter{
        List<Integer> ids;
        List<Object> controllers;
        JTextArea message;
        JPanel parentPanel;
        JTextPane chatBox;
        String userName;


        public EditDeletePopupListener(List<Integer> ids, List<Object> controllers, JTextArea message, JPanel parentPanel, JTextPane
            chatBox, String userName){
            this.ids = ids;
            this.controllers = controllers;
            this.message = message;
            this.parentPanel = parentPanel;
            this.chatBox = chatBox;
            this.userName = userName;

        }
        public void mousePressed(MouseEvent e){
            if(e.isPopupTrigger()){
                doPop(e);
            }}


        public void doPop(MouseEvent e){
            EditDeletePopupMenu editDeletePopupMenu = new EditDeletePopupMenu(this.ids, this.controllers, message, parentPanel, chatBox, userName);
            editDeletePopupMenu.show(e.getComponent(), e.getXOnScreen(), e.getYOnScreen());


        }
        public void mouseReleased(MouseEvent e){
            if(e.isPopupTrigger()){
                doPop(e);
            }}


    }
}