package views;

import entities.User;
import services.DBInitializer;
import services.DBService;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
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



public class ContactScreen extends JFrame{
    ArrayList<MemberVO>members = new ArrayList<MemberVO>();
    DBService dbService;

    public ContactScreen() throws ExecutionException, InterruptedException {
        this.dbService = new DBService();
        DBInitializer dbInitializer = new DBInitializer();
        try {
            dbInitializer.init();
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        setTitle("Contacts");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setBounds(200, 100, 400, 200);

        //columns
        String[] colNames = new String[]{"User ID"};
        DefaultTableModel model = new DefaultTableModel(colNames, 0);

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        //테이블 아래쪽에 데이터 입력 할수있는 패널
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

        // Fetch list of all users from database
        User targetUser = dbService.getUserDetails(1);
        ArrayList<Long> contacts = targetUser.getContacts();
        System.out.println(contacts);

        for (int i = 0; i < contacts.size(); i++) {
            rows[0] = String.valueOf(contacts.get(i));
            model.addRow(rows);
            members.add(new MemberVO(contacts.get(i)));

        }

        // contats is array of integers
        // but your row[1] which is showoing contacts is a string

        // Display it with their contact
        model.addRow(rows);

        tfUserid.setText("");







        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //입력된 값 테이블에 추가하기
                //입력된 값들을 한줄 데이터 배열로 만들기





                String[] rows = new String[2];
                rows[0] = tfUserid.getText();
                model.addRow(rows);

                tfUserid.setText("");


                Long userid = Long.parseLong(rows[0]);


                User targetUser = null;
                try {
                    targetUser = dbService.getUserDetails(1); // 이게 모냐 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                try {
                    dbService.addContact(targetUser, userid);
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }


                members.add(new MemberVO(userid));


            }
        });
        //선택한 줄 지우기
        btnDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //선택한 줄의 번호 알아내기


                int rowIndex = table.getSelectedRow();
                //선택 안하고 누를 경우 리턴값 -1
                if (rowIndex == -1) return;
                model.removeRow(rowIndex);
                System.out.println(members.size());
                Long userid = members.get(rowIndex).userid;

                DBService dbService = new DBService();
                User targetUser = null;
                try {
                    targetUser = dbService.getUserDetails(1);
                } catch (ExecutionException ex) {
                    throw new RuntimeException(ex);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }


                try {
                    dbService.deleteContact(targetUser, userid);
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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ContactScreen();
    }
}
