/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author dinis
 */
public class Branch {

    private int branchID;
    private String email;
    private String location;
    private String contactNumber;

    public Branch() {

    }

    public Branch(String email, String location, String contactNumber) {

        this.email = email;
        this.location = location;
        this.contactNumber = contactNumber;

    }

    public void setBranchID(int branchID) {
        this.branchID = branchID;
    }

    public void setEmail(String name) {
        this.email = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public int getBranchID() {
        return branchID;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void addBranch() {

        try {

            String insert = "Insert into branch (location, email, Telephone) values (?, ?, ?)";
            int result = MyConn.save(insert, location, email, contactNumber);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Added");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet viewBranch(String selectedColumns, String condition, Object... params) {

        ResultSet rs = null;
        try {

            String search = "Select " + selectedColumns + " from branch";
            if (condition != null && !condition.trim().isEmpty()) {
                search += " where " + condition;
            }

            rs = MyConn.search(search, params);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;

    }

    public void updateBranch() {

        try {

            String update = "Update branch set location = ?, email = ?, telephone = ? where branch_id = ?";
            int result = MyConn.save(update, location, email, contactNumber, branchID);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeBranch() {

        try {

            String delete = "Delete from branch where branch_id = ?";
            int result = MyConn.save(delete, branchID);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
