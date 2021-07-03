import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Process {
    static Boolean login(String cred[], Connection con) throws SQLException {
        if (con != null) {
            System.out.println("Correct");
            if (cred != null) {
                try {
                    int id = Integer.parseInt(cred[0]);
                    String pass = cred[1];
                    System.out.println("pass");
                    PreparedStatement stmt = con.prepareStatement("select * from data where id=? and password=?");
                    stmt.setInt(1, id);
                    stmt.setString(2, pass);
                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("success");
                        GUI.userPanel(rs.getString("name"), rs);
                        GUI.loginpanel.dispose();
                        return true;
                    } else {
                        JOptionPane.showMessageDialog(GUI.loginpanel, "Wrong ID or Password");
                    }
                } catch (NumberFormatException e) {
                    System.out.println(e);
                }

            }
        }
        return false;
    }

    static void Search(String searchText) {
        int searchField = Integer.parseInt(searchText);
        PreparedStatement stmt;
        try {
            stmt = App.con.prepareStatement("select * from data where id=?");
            stmt.setInt(1, searchField);
            ResultSet res = stmt.executeQuery();
            if (res.next()) {
                Employ.obj.setId(res.getInt("id"));
                Employ.obj.setName(res.getString("name"));
                Employ.obj.setDept(res.getString("dept"));
                Employ.obj.setSalary(res.getString("salary"));
                Employ.obj.setMobileNum(res.getString("mobile"));
                Employ.obj.setPassword(res.getString("password"));
            } else {
                JOptionPane.showMessageDialog(GUI.loginpanel, "No Record Found!!");
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    static void add() {
        System.out.println(Employ.obj.toString());
        Statement stmt;
        try {
            String sql = "insert into data values('" + Employ.obj.getId() + "','" + Employ.obj.getName() + "','"
                    + Employ.obj.getDept() + "','" + Employ.obj.getSalary() + "','" + Employ.obj.getMobileNum() + "','"
                    + Employ.obj.getPassword() + "')";

            stmt = App.con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            // TODO: handle exception
            e.getStackTrace();
        }
    }

    static void clear() {
        GUI.idText.setText("");
        GUI.nameText.setText("");
        GUI.deptText.setText("");
        GUI.mobileText.setText("");
        GUI.salaryText.setText("");
        GUI.passwordText.setText("");
    }

    static void delete() {
        Statement stmt;
        try {
            String sql = "DELETE from data WHERE id = '" + GUI.idText.getText() + "'";
            stmt = App.con.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static void edit() {
        PreparedStatement stmt;
        System.out.println("edit func");
        try {
            stmt = App.con
                    .prepareStatement("UPDATE data SET name = ? , dept = ? , mobile = ? , salary = ? , password = ?");
            stmt.setString(1, Employ.obj.getName());
            stmt.setString(2, Employ.obj.getDept());
            stmt.setString(3, Employ.obj.getMobileNum());
            stmt.setString(4, Employ.obj.getSalary());
            stmt.setString(5, Employ.obj.getPassword());
            int i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println(i + "edited");
            }
        } catch (Exception e) {

        }
    }

}
