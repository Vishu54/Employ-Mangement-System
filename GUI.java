import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class GUI {
    static JFrame loginpanel = new JFrame();
    static JTextField idText = new JTextField(5);
    static JTextField nameText = new JTextField(5);
    static JTextField deptText = new JTextField(5);
    static JTextField mobileText = new JTextField(5);
    static JTextField salaryText = new JTextField(5);
    static JTextField passwordText = new JTextField(5);

    static void login() {

        loginpanel.setResizable(false);
        JLabel userLabel = new JLabel("USERNAME");
        JLabel passwordLabel = new JLabel("PASSWORD");
        JTextField userTextField = new JTextField();
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("LOGIN");
        JButton AdminLogin = new JButton("ADMIN");
        JCheckBox showPassword = new JCheckBox("Show Password");

        loginpanel.setLayout(null);

        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        AdminLogin.setBounds(200, 300, 100, 30);

        loginpanel.add(userLabel);
        loginpanel.add(passwordLabel);
        loginpanel.add(userTextField);
        loginpanel.add(passwordField);
        loginpanel.add(showPassword);
        loginpanel.add(loginButton);
        loginpanel.add(AdminLogin);

        String cred[] = new String[2];

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    cred[0] = userTextField.getText();
                    cred[1] = passwordField.getText();
                    userTextField.setText("");
                    passwordField.setText("");
                    App.loginFlag = Process.login(cred, App.con);
                    System.out.println(App.loginFlag);

                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        showPassword.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub
                if (showPassword.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }

        });

        AdminLogin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                // TODO Auto-generated method stub
                if (userTextField.getText().equals("101") && passwordField.getText().equals("admin")) {
                    System.out.println("admin");
                    GUI.adminPanel();
                    loginpanel.dispose();
                }
            }
        });

        loginpanel.setTitle("Login");
        loginpanel.setVisible(true);
        loginpanel.setBounds(10, 10, 370, 600);
        loginpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginpanel.setResizable(false);
    }

    static void adminPanel() {
        JFrame adminpanel = new JFrame("MyPanel");
        adminpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        adminpanel.setBounds(10, 10, 750, 550);
        adminpanel.setResizable(false);
        adminpanel.setVisible(true);

        JTextField searchText = new JTextField(5);
        JButton searchBtn = new JButton("Search");
        JButton addBtn = new JButton("Add");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");
        JButton clrBtn = new JButton("Clear");
        JButton refreshBtn = new JButton("Table");
        JLabel adminLabel = new JLabel("ADMIN PANEL");
        JLabel idLabel = new JLabel("ID");
        JLabel nameLabel = new JLabel("Name");
        JLabel deptLabel = new JLabel("Dept");
        JLabel mobileLabel = new JLabel("Mobile No");
        JLabel salaryLabel = new JLabel("Salary");
        JLabel passwordLabel = new JLabel("Password");
        JButton logoutBtn = new JButton("Logout");
        JButton printbtn = new JButton("Print");

        adminpanel.setPreferredSize(new Dimension(752, 437));
        adminpanel.setLayout(null);

        adminpanel.add(searchText);
        adminpanel.add(searchBtn);
        adminpanel.add(addBtn);
        adminpanel.add(editBtn);
        adminpanel.add(deleteBtn);
        adminpanel.add(clrBtn);
        adminpanel.add(refreshBtn);
        adminpanel.add(adminLabel);
        adminpanel.add(idLabel);
        adminpanel.add(nameLabel);
        adminpanel.add(deptLabel);
        adminpanel.add(mobileLabel);
        adminpanel.add(salaryLabel);
        adminpanel.add(passwordLabel);
        adminpanel.add(idText);
        adminpanel.add(nameText);
        adminpanel.add(deptText);
        adminpanel.add(mobileText);
        adminpanel.add(salaryText);
        adminpanel.add(passwordText);
        adminpanel.add(logoutBtn);
        adminpanel.add(printbtn);

        searchText.setBounds(50, 75, 130, 40);
        searchBtn.setBounds(205, 75, 100, 40);
        addBtn.setBounds(45, 440, 100, 40);
        editBtn.setBounds(175, 440, 100, 40);
        deleteBtn.setBounds(305, 440, 100, 40);
        clrBtn.setBounds(435, 440, 100, 40);
        refreshBtn.setBounds(565, 440, 100, 40);
        adminLabel.setBounds(320, 5, 125, 35);
        idLabel.setBounds(75, 177, 100, 25);
        nameLabel.setBounds(75, 268, 100, 25);
        deptLabel.setBounds(75, 358, 100, 25);
        mobileLabel.setBounds(420, 177, 100, 25);
        salaryLabel.setBounds(420, 270, 100, 25);
        passwordLabel.setBounds(420, 365, 100, 25);
        idText.setBounds(190, 170, 140, 40);
        nameText.setBounds(190, 260, 140, 40);
        deptText.setBounds(190, 350, 140, 40);
        mobileText.setBounds(535, 170, 140, 40);
        salaryText.setBounds(535, 260, 140, 40);
        passwordText.setBounds(535, 350, 140, 40);
        logoutBtn.setBounds(585, 25, 100, 40);
        printbtn.setBounds(535, 75, 100, 40);

        idText.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        nameText.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        deptText.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        salaryText.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        mobileText.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        passwordText.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);

        searchBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    Process.Search(searchText.getText());
                } catch (Exception er) {
                    // TODO: handle exception
                    System.err.println(er);
                }
                idText.setText(String.valueOf(Employ.obj.getId()));
                nameText.setText(Employ.obj.getName());
                deptText.setText(Employ.obj.getDept());
                mobileText.setText(String.valueOf(Employ.obj.getMobileNum()));
                salaryText.setText(String.valueOf(Employ.obj.getSalary()));
                passwordText.setText(Employ.obj.getPassword());
            }

        });

        addBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                try {
                    Employ.obj.setId(Integer.parseInt(idText.getText()));
                    Employ.obj.setName(nameText.getText());
                    Employ.obj.setDept(deptText.getText());
                    Employ.obj.setMobileNum(mobileText.getText());
                    Employ.obj.setSalary(salaryText.getText());
                    Employ.obj.setPassword(passwordText.getText());
                    Process.add();
                    Process.clear();
                } catch (Exception er) {
                    // TODO: handle exception
                    System.err.println(er);
                }

            }

        });

        clrBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Process.clear();
            }
        });

        deleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                Process.delete();
                Process.clear();
            }
        });
        refreshBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame tableframe = new JFrame();
                DefaultTableModel tableModel = new DefaultTableModel();
                JTable table = new JTable(tableModel);
                tableModel.addColumn("ID");
                tableModel.addColumn("Name");
                tableModel.addColumn("Dept");
                tableModel.addColumn("Salary");
                tableModel.addColumn("Mobile");
                tableModel.addColumn("Password");

                PreparedStatement stmt;
                try {
                    stmt = App.con.prepareStatement("select * from data");
                    int row = 0;
                    ResultSet res = stmt.executeQuery();
                    while (res.next()) {
                        tableModel.insertRow(row,
                                new Object[] { res.getInt("id"), res.getString("name"), res.getString("dept"),
                                        res.getString("salary"), res.getString("mobile"), res.getString("password") });
                        row++;
                    }
                } catch (SQLException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                table.setEnabled(false);
                tableframe.setSize(550, 350);
                tableframe.add(new JScrollPane(table));
                tableframe.setVisible(true);

            }

        });
        logoutBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                adminpanel.dispose();
                GUI.login();

            }

        });
        editBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                try {
                    Employ.obj.setId(Integer.parseInt(idText.getText()));
                    Employ.obj.setName(nameText.getText());
                    Employ.obj.setDept(deptText.getText());
                    Employ.obj.setMobileNum(mobileText.getText());
                    Employ.obj.setSalary(salaryText.getText());
                    Employ.obj.setPassword(passwordText.getText());
                    Process.edit();
                } catch (Exception e) {
                    // TODO: handle exception
                    System.err.println(e);
                }
            }

        });
        printbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent event) {
                // TODO Auto-generated method stub
                try {
                    FileWriter myWriter = new FileWriter(Employ.obj.getId() + ".txt");
                    myWriter.write("ID-> " + Employ.obj.getId() + "\n" + "Name-> " + Employ.obj.getName() + "\n"
                            + "Dept-> " + Employ.obj.getDept() + "\n" + "Salary-> " + Employ.obj.getSalary() + "\n"
                            + "Mobile Number-> " + Employ.obj.getMobileNum() + "\n" + "Password-> "
                            + Employ.obj.getPassword() + "\n");
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();

                }
            }
        });

    }

    static void userPanel(String empname, ResultSet rs) throws SQLException {

        JFrame usrpanel = new JFrame();
        usrpanel.setPreferredSize(new Dimension(687, 376));
        usrpanel.setBounds(10, 10, 700, 450);
        usrpanel.setLayout(null);
        usrpanel.setVisible(true);
        usrpanel.setResizable(false);
        usrpanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel username;
        JLabel idlbl;
        JLabel namelbl;
        JLabel deptlbl;
        JLabel salarylbl;
        JLabel mobilelbl;
        JLabel passwordlbl;
        JTextField idtxt;
        JTextField nametxt;
        JTextField depttxt;
        JTextField salarytxt;
        JTextField mobiletxt;
        JTextField passwordtxt;
        JButton logoutbtn;

        username = new JLabel("Hi  " + empname);
        idlbl = new JLabel("ID");
        namelbl = new JLabel("Name");
        deptlbl = new JLabel("Dept");
        salarylbl = new JLabel("Salary");
        mobilelbl = new JLabel("Mobile no.");
        passwordlbl = new JLabel("Password");
        idtxt = new JTextField(5);
        nametxt = new JTextField(5);
        depttxt = new JTextField(5);
        salarytxt = new JTextField(5);
        mobiletxt = new JTextField(5);
        passwordtxt = new JTextField(5);
        logoutbtn = new JButton("Logout");

        usrpanel.add(username);
        usrpanel.add(idlbl);
        usrpanel.add(namelbl);
        usrpanel.add(deptlbl);
        usrpanel.add(salarylbl);
        usrpanel.add(mobilelbl);
        usrpanel.add(passwordlbl);
        usrpanel.add(idtxt);
        usrpanel.add(nametxt);
        usrpanel.add(depttxt);
        usrpanel.add(salarytxt);
        usrpanel.add(mobiletxt);
        usrpanel.add(passwordtxt);
        usrpanel.add(logoutbtn);

        username.setBounds(305, 35, 145, 55);
        idlbl.setBounds(60, 140, 100, 40);
        namelbl.setBounds(60, 210, 100, 40);
        deptlbl.setBounds(60, 280, 100, 40);
        salarylbl.setBounds(375, 140, 100, 40);
        mobilelbl.setBounds(375, 210, 100, 40);
        passwordlbl.setBounds(375, 280, 100, 40);
        idtxt.setBounds(165, 140, 140, 40);
        nametxt.setBounds(165, 210, 140, 40);
        depttxt.setBounds(165, 280, 140, 40);
        salarytxt.setBounds(480, 140, 140, 40);
        mobiletxt.setBounds(480, 210, 140, 40);
        passwordtxt.setBounds(480, 280, 140, 40);
        logoutbtn.setBounds(565, 20, 100, 25);

        try {
            idtxt.setText(String.valueOf(rs.getInt("id")));
            nametxt.setText(rs.getString("name"));
            depttxt.setText(rs.getString("dept"));
            salarytxt.setText(rs.getString("salary"));
            mobiletxt.setText(rs.getString("mobile"));
            passwordtxt.setText(rs.getString("password"));
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e);
        }

        idtxt.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        nametxt.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        depttxt.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        salarytxt.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        mobiletxt.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);
        passwordtxt.setHorizontalAlignment((int) JFrame.CENTER_ALIGNMENT);

        idtxt.setEditable(false);
        nametxt.setEditable(false);
        depttxt.setEditable(false);
        salarytxt.setEditable(false);
        mobiletxt.setEditable(false);
        passwordtxt.setEditable(false);

        logoutbtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                GUI.login();
                usrpanel.dispose();
            }
        });
    }

}
