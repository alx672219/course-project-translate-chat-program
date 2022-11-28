package views;

import contact_usecases.add_contact_use_case.AddContactInputBoundary;
import contact_usecases.add_contact_use_case.AddContactInteractor;
import contact_usecases.delete_contact_use_case.DeleteContactInputBoundary;
import contact_usecases.delete_contact_use_case.DeleteContactInteractor;
import entities.User;
import services.DBInitializer;
import services.DBService;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class ContactScreen extends JPanel{
    ArrayList<MemberVO>members = new ArrayList<MemberVO>();

    Long userID;

    ArrayList<Long> contacts;

    ContactController contactController;

    public static void main(String[] args) throws ExecutionException, InterruptedException, FileNotFoundException {
        AddContactInputBoundary addContactInteractor = new AddContactInteractor();
        DeleteContactInputBoundary deleteContactInteractor = new DeleteContactInteractor();
        ContactController contactController1 = new ContactController(addContactInteractor, deleteContactInteractor);
        DBInitializer dbInitializer = new DBInitializer();
        dbInitializer.init();

        DBService dbService = new DBService();
        User targetUser = dbService.getUserDetails(1);
        ArrayList<Long> contacts = targetUser.getContacts();

        JFrame application = new JFrame("Application");
        application.add(new ContactScreen(1L, contacts, contactController1));
        application.pack();
        application.setVisible(true);
    }

    public ContactScreen(Long userID, ArrayList<Long> contacts,
                         ContactController contactController) throws ExecutionException, InterruptedException {

        this.userID = userID;

        this.contacts = contacts;

        this.contactController = contactController;

        setBounds(200, 100, 400, 200);

        //Columns
        String[] colNames = new String[]{"User ID"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);


        //Input Panel at the bottom of the screen


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(2,1));

        JPanel panel = new JPanel();
        JTextField tfUserid = new JTextField(6);

        panel.add(new JLabel("User ID"));
        panel.add(tfUserid);
        bottomPanel.add(panel);

        JPanel panel2 = new JPanel();
        JButton btnAdd = new JButton("Add");
        JButton btnDel = new JButton("Delete");
        panel2.add(btnAdd);
        panel2.add(btnDel);
        bottomPanel.add(panel2);

        String[] rows = new String[2];


        for (int i = 0; i < this.contacts.size(); i++) {
            rows[0] = String.valueOf(contacts.get(i));
            model.addRow(rows);
            members.add(new MemberVO(contacts.get(i)));



        }



        //members.add(new MemberVO(0L));





        tfUserid.setText("");

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Add
                String[] rows = new String[2];
                rows[0] = tfUserid.getText();
                model.addRow(rows);

                tfUserid.setText("");


                Long contactID = Long.parseLong(rows[0]);
                try {

                    contactController.addContact(userID, contactID);
                } catch (ExecutionException | InterruptedException ex) {
                    throw new RuntimeException(ex);
                }


                members.add(new MemberVO(contactID));


            }
        });

        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                int rowIndex = table.getSelectedRow();


                if (rowIndex == -1) return;
                model.removeRow(rowIndex);

                Long contactID = members.get(rowIndex).userid;

                try {
                    contactController.deleteContact(userID, contactID);
                } catch (ExecutionException | InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                members.remove(rowIndex);

            }
        });



        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
        }

        class MemberVO{
        private final Long userid;

        public MemberVO(Long userid){
            this.userid = userid;
        }




    }

}
