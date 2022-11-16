package views;

import java.awt.FlowLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.IOException;



import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTextArea;

import javax.swing.JTextField;

class Id extends JFrame implements ActionListener{

    static JTextField tf=new JTextField(8);

    JButton btn = new JButton("Enter");



    ChatScreen cf;

    public Id(){}

    public Id(ChatScreen cf) {

        super("ID");


        this.cf = cf;





        setLayout(new FlowLayout());

        add(new JLabel("ID"));

        add(tf);

        add(btn);



        btn.addActionListener(this);



        setBounds(300, 300, 250, 100);

        setVisible(true);

    }



    public void actionPerformed(ActionEvent e) {

        cf.isFirst = false;

        cf.setVisible(true);

        this.dispose();

    }

    static public String getId(){

        return tf.getText();

    }

}