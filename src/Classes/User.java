/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.*;
import Others.MyConn;
import cafemanagementsystem.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author dinis
 */
public class User {

    private String userID;
    private String fName;
    private String lName;
    private String nic;
    private String addressLine1;
    private String addressLine2;
    private String email;
    private String role;
    private String password;
    private String tele;
    private int saltNumber;
    private double salary;

    public User() {

    }

    public User(String ID, String fName, String lName, String nic, String address1, String address2, String email, String role,
            String password, String tele, int saltNo, double salary) {

        this.userID = ID;
        this.fName = fName;
        this.lName = lName;
        this.nic = nic;
        this.addressLine1 = address1;
        this.addressLine2 = address2;
        this.email = email;
        this.role = role;
        this.password = password;
        this.tele = tele;
        this.saltNumber = saltNo;
        this.salary = salary;

    }

    public void setId(String ID) {
        this.userID = ID;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public void setAddress1(String address1) {
        this.addressLine1 = address1;
    }

    public void setAddress2(String address2) {
        this.addressLine2 = address2;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public void setSaltNo(int saltNo) {
        this.saltNumber = saltNo;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return userID;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getNic() {
        return nic;
    }

    public String getAddress1() {
        return addressLine1;
    }

    public String getAddress2() {
        return addressLine2;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }

    public String getTele() {
        return tele;
    }

    public int getSaltNo() {
        return saltNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void logIn() {

        try {

            String search = "Select Count(*) from user where user_id = ?";
            ResultSet rs = MyConn.search(search, userID);
            if (rs.next()) {

                int count = rs.getInt(1);
                if (count > 0) {

                    String pwdSearch = "Select fname, role, password, salt_no from user where user_id = ?";
                    ResultSet rs2 = MyConn.search(pwdSearch, userID);

                    if (rs2.next()) {

                        String dbPassword = rs2.getString("password");
                        saltNumber = rs2.getInt("salt_no");
                        String role = rs2.getString("role");
                        fName = rs2.getString("fname");

                        boolean isPwdCorrect = VerifyPassword.verify(password, saltNumber, dbPassword);
                        if (isPwdCorrect) {

                            Date date = java.sql.Date.valueOf(LocalDate.now());
                            Time time = java.sql.Time.valueOf(LocalTime.now());

                            Login login = new Login(userID, time, date);
                            login.saveRecord();

                            if (role.equals("Branch Manager")) {
                                new BranchManagerProfile(userID, fName).setVisible(true);
                            } else if (role.equals("Administrator")) {
                                new AdminProfile(userID, fName).setVisible(true);
                            } else if (role.equals("HR Manager")) {
                                new HRProfile(userID, fName).setVisible(true);
                            } else if (role.equals("Accountant")) {
                                new AccountantProfile(userID, fName).setVisible(true);
                            } else if (role.equals("Head Chef")) {
                                new HeadChefProfile(userID, fName).setVisible(true);
                            } else if (role.equals("Supervisor")) {
                                new SupervisorProfile(userID, fName).setVisible(true);
                            } else if (role.equals("Chef")) {
                                new chefProfile(userID, fName).setVisible(true);
                            } else if (role.equals("Employee")) {
                                new EmployeeProfile(userID, fName).setVisible(true);
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid User Role");
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid password");
                        }

                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid user id");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public int logOut() {
        JFrame f = new JFrame();
        int result = JOptionPane.showConfirmDialog(f, "Do you want to log out");
        return result;
    }

    public void addUser(String contact2) {

        try {

            String insert = "Insert into user (user_id, fname, lname, nic, address_line1, address_line2, email, role, password, salary, salt_no) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            int affectedRows1 = MyConn.save(insert, userID, fName, lName, nic, addressLine1, addressLine2, email, role, password, salary, saltNumber);

            String insertTele1 = "Insert into user_contact (user_id, tele) values (?, ?)";
            int affectedRows2 = MyConn.save(insertTele1, userID, tele);

            String insertTele2 = "Insert into user_contact (user_id, tele) values (?, ?)";
            int affectedRows3 = MyConn.save(insertTele2, userID, contact2);

            if (affectedRows1 == 1 && affectedRows2 == 1 && affectedRows3 == 1) {
                JOptionPane.showMessageDialog(null, "User Added Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "User Added Faild");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateUser(String userRole, String contact2) {

        try {

            if (userRole.equals("admin")) {

                JFrame f = new JFrame();
                if (JOptionPane.showConfirmDialog(f, "Do you want to perform this update?") == JOptionPane.YES_NO_OPTION) {
                    String admUpdate = "update user set fname = ?, lname = ?, nic = ?, address_line1 = ?, address_line2 = ?, email = ?, salary = ?, role = ? where user_id = ? ";
                    int upRows = MyConn.save(admUpdate, fName, lName, nic, addressLine1, addressLine2, email, salary, role, userID);

                    String DeleteContacts = "Delete from user_contact where user_id = ?";
                    MyConn.save(DeleteContacts, userID);

                    String insertTele1 = "Insert into user_contact (user_id, tele) values (?, ?)";
                    int teleRows1 = MyConn.save(insertTele1, userID, tele);

                    String insertTele2 = "Insert into user_contact (user_id, tele) values (?, ?)";
                    int teleRows2 = MyConn.save(insertTele2, userID, contact2);

                    if (teleRows1 == 1 && teleRows2 == 1 && upRows == 1) {
                        JOptionPane.showMessageDialog(null, "Update Successfull");
                    } else {
                        JOptionPane.showMessageDialog(null, "Faild");
                    }
                }

            } else {

                JFrame f = new JFrame();
                if (JOptionPane.showConfirmDialog(f, "Do you want to perform this update?") == JOptionPane.YES_NO_OPTION) {
                    String ouUpdate = "update user set fname = ?, lname = ?, nic = ?, address_line1 = ?, address_line2 = ?, email = ? where user_id = ? ";
                    int upRows = MyConn.save(ouUpdate, fName, lName, nic, addressLine1, addressLine2, email, userID);

                    String DeleteContacts = "Delete from user_contact where user_id = ?";
                    MyConn.save(DeleteContacts, userID);

                    String insertTele1 = "Insert into user_contact (user_id, tele) values (?, ?)";
                    int teleRows1 = MyConn.save(insertTele1, userID, tele);

                    String insertTele2 = "Insert into user_contact (user_id, tele) values (?, ?)";
                    int teleRows2 = MyConn.save(insertTele2, userID, contact2);

                    if (teleRows1 == 1 && teleRows2 == 1 && upRows == 1) {
                        JOptionPane.showMessageDialog(null, "Update Successfull");
                    } else {
                        JOptionPane.showMessageDialog(null, "Faild");
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet viewUser(String selectedColumns, String filterConditions, Object... params) {
        ResultSet rs = null;
        try {
            String query = "SELECT " + selectedColumns + " FROM user";
            if (filterConditions != null && !filterConditions.trim().isEmpty()) {
                query += " WHERE " + filterConditions;
            }
            rs = MyConn.search(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void removeUser() {

        JFrame f = new JFrame();
        if (JOptionPane.showConfirmDialog(f, "Do you want to Delete this user?") == JOptionPane.YES_NO_OPTION) {

            try {

                String delete = "Delete from user where user_id = ?";
                int rows = MyConn.save(delete, userID);

                if (rows == 1) {
                    JOptionPane.showMessageDialog(null, "Successfully Deleted");
                } else {
                    JOptionPane.showMessageDialog(null, "Successfully Faild");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
