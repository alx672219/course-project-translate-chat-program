package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;

public class ChatScreen extends JFrame implements ActionListener {
    JTextArea txtA = new JTextArea();

    JTextField txtF = new JTextField(15);

    JButton btnTransfer = new JButton("Send");

    JButton btnExit = new JButton("Close");

    boolean isFirst=true;

    JPanel p1 = new JPanel();

    public ChatScreen() {

        super("Chat");


        new Id(this);



        add("Center", txtA);



        p1.add(txtF);

        p1.add(btnTransfer);

        p1.add(btnExit);

        add("South", p1);



        // Creating class for messages



        btnTransfer.addActionListener(this);

        btnExit.addActionListener(this);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setBounds(300, 300, 350, 300);

        setVisible(false);

    }



    public void actionPerformed(ActionEvent e){

        String id = Id.getId();

        if(e.getSource()==btnTransfer){// WHen pressing send button

            // When you press send button without typing messages

            if(txtF.getText().equals("")){

                return;

            }

            txtA.append("["+id+"] "+ txtF.getText()+"\n");

            txtF.setText("");

        }else{

            this.dispose();

        }

    }

}


