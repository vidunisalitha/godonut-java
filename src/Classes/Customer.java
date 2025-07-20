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
public class Customer {

    private int cusId;
    private String fName;
    private String lName;
    private String addressLine1;
    private String addressLine2;
    private String tele;

    public Customer() {

    }

    public Customer(String fName, String lName, String address1, String address2, String tele) {

        this.fName = fName;
        this.lName = lName;
        this.addressLine1 = address1;
        this.addressLine2 = address2;
        this.tele = tele;

    }

    public void setCusId(int Id) {
        this.cusId = Id;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public void setLName(String lName) {
        this.lName = lName;
    }

    public void setAddress1(String address1) {
        this.addressLine1 = address1;
    }

    public void setAddress2(String address2) {
        this.addressLine2 = address2;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public int getCusId() {
        return cusId;
    }

    public String getFName() {
        return fName;
    }

    public String getLName() {
        return lName;
    }

    public String getAddress1() {
        return addressLine1;
    }

    public String getAddress2() {
        return addressLine2;
    }

    public String getTele() {
        return tele;
    }

    public ResultSet viewCustomer(String selectedColumns, String filterConditions, Object... params) {

        ResultSet rs = null;
        try {
            String query = "SELECT " + selectedColumns + " FROM customer";
            if (filterConditions != null && !filterConditions.trim().isEmpty()) {
                query += " WHERE " + filterConditions;
            }
            rs = MyConn.search(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }

    public void addCustomer() {

        try {

            String insert = "Insert into customer (fname, lname, address_line1, address_line2, tele) values (?, ?, ?, ?, ?)";
            int rows = MyConn.save(insert, fName, lName, addressLine1, addressLine2, tele);

            if (rows == 1) {
                JOptionPane.showMessageDialog(null, "Successfull");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateCustomer() {

        try {

            String update = "update customer set fname = ?, lname = ?, address_line1 = ?, address_line2 = ?, tele = ? where cus_id = ?";
            int rows = MyConn.save(update, fName, lName, addressLine1, addressLine2, tele, cusId);

            if (rows == 1) {
                JOptionPane.showMessageDialog(null, "Update Successfull");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeCustomer() {

        try {

            String delete = "Delete from customer where cus_id = ?";
            int rows = MyConn.save(delete, cusId);

            if (rows == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
