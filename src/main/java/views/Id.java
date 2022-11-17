//package views;
//
//import java.awt.*;
//
//import java.awt.event.ActionEvent;
//
//import java.awt.event.ActionListener;
//
//import java.io.IOException;
//
//
//import javax.swing.*;
//
//import javax.swing.table.DefaultTableModel;
//
//class Id extends JFrame implements ActionListener{
//
//    static JTextField tf=new JTextField(8);
//
//    JButton btn = new JButton("Enter");
//
//
//
//    ChatScreen cf;
//
//    public Id(){}
//
//    public Id(ChatScreen cf) {
//
//        super("ID");
//
//
//        this.cf = cf;
//
//        // Columns
//        String[] colNames = new String[]{"User ID"};
//        DefaultTableModel model = new DefaultTableModel(colNames, 0);
//
//        JTable table = new JTable(model);
//        JScrollPane scrollPane = new JScrollPane(table);
//        add(scrollPane, BorderLayout.CENTER);
//
//        JPanel panel = new JPanel();
//        JTextField tfUserID = new JTextField(6);
//
//        panel.add(new JLabel("User ID"));
//        panel.add(tfUserID);
//
//        JPanel panel2 = new JPanel();
//        JButton btnEnter = new JButton("Enter");
//        panel2.add(btnEnter);
//
//        String[] rows = new String[2];
//        model.addRow(rows);
////        setLayout(new FlowLayout());
//
//
//
//
//
//
////        setLayout(new FlowLayout());
////
////        add(new JLabel("Current User ID"));
////
////        add(tf);
////
////        add(btn);
//
////        setLayout(new FlowLayout());
////
////        add(new JLabel("ID"));
////
////        add(tf);
//
//        btn.addActionListener(this);
//
//
//
//        setBounds(300, 300, 250, 100);
//
//        setVisible(true);
//
//    }
//
//
//
//    public void actionPerformed(ActionEvent e) {
//
//        cf.isFirst = false;
//
//        cf.setVisible(true);
//
//        this.dispose();
//
//    }
//
//     public String getId(){
//
//        return tf.getText();
//
//    }
//
//}