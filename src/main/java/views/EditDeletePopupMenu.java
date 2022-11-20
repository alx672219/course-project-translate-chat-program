package views;

import message_edit_delete_use_case.MessageDeleteData;
import message_edit_delete_use_case.MessageEditData;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

public class EditDeletePopupMenu extends JPopupMenu {
    JMenuItem edit;
    JMenuItem delete;
    int chatID;
    int messageID;
    MessageDeleteController deleteController;
    MessageEditController editController;
    JTextArea message;
    JPanel parentPanel;
    JTextPane chatBox;
    String username;


    public EditDeletePopupMenu(int chatID, int messageID, MessageDeleteController deleteController,
                               MessageEditController editController, JTextArea message, JPanel parentPanel, JTextPane
                                chatBox, String username){
        this.chatID = chatID;
        this.messageID = messageID;
        this.edit = new JMenuItem("Edit");
        this.delete = new JMenuItem("Delete");
        this.edit.addActionListener(new EditActionListener());
        this.delete.addActionListener(new DeleteActionListener());
        this.deleteController = deleteController;
        this.editController = editController;
        this.add(edit);
        this.add(delete);
        this.message = message;
        this.parentPanel = parentPanel;
        this.chatBox = chatBox;
        this.username = username;

    }
    class EditActionListener implements ActionListener{
        HintTextField editTextField;
        JFrame editApplication;

        @Override
        public void actionPerformed(ActionEvent e) {
            editApplication = new JFrame("Edit");
            editTextField = new HintTextField("Edit Message...");
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
            JButton editButton = new JButton("Edit");
            mainPanel.add(editTextField);
            mainPanel.add(editButton);
            editButton.addActionListener(new EditButtonActionListener());
            editApplication.add(mainPanel);
            editApplication.pack();
            editApplication.setVisible(true);

        }
        class EditButtonActionListener implements  ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
                editController.editMessage(new MessageEditData(editTextField.getText(), messageID));
                JOptionPane.showMessageDialog(editApplication, "Edited!");
                message.setText("<" + username + ">:  " + editTextField.getText());
            }
        }
    }
    class DeleteActionListener implements  ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                deleteController.delete(new MessageDeleteData(messageID, chatID));
                //chatBox.remove(message);
                //chatBox.revalidate();
                //chatBox.repaint();
            } catch (ExecutionException | InterruptedException ex){

                JOptionPane.showMessageDialog(parentPanel, "Something went wrong! Please try again!");
            }


        }
    }

}
