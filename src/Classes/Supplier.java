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
public class Supplier {

    private int supId;
    private String fName;
    private String lName;
    private String addressLine1;
    private String addressLine2;
    private String email;
    private String tele;

    public Supplier() {

    }

    public Supplier(String fName, String lName, String address1, String address2, String email, String tele) {

        this.fName = fName;
        this.lName = lName;
        this.addressLine1 = address1;
        this.addressLine2 = address2;
        this.email = email;
        this.tele = tele;

    }

    public void setSupId(int Id) {
        this.supId = Id;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTele(String tele) {
        this.tele = tele;
    }

    public int getSupId() {
        return supId;
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

    public String getEmail() {
        return email;
    }

    public ResultSet viewSupplier(String selectedColumns, String filterConditions, Object... params) {

        ResultSet rs = null;
        try {
            String query = "SELECT " + selectedColumns + " FROM supplier";
            if (filterConditions != null && !filterConditions.trim().isEmpty()) {
                query += " WHERE " + filterConditions;
            }
            rs = MyConn.search(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }

    public void addsupplier(String contact02) {

        try {

            String insert = "Insert into supplier (fname, lname, address_line1, address_line2, email) values (?, ?, ?, ?, ?)";
            int result = MyConn.save(insert, fName, lName, addressLine1, addressLine2, email);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Added");

                String getSuppId = "Select Last_insert_id()";
                ResultSet rs = MyConn.search(getSuppId);

                if (rs.next()) {
                    supId = rs.getInt(1);

                    String insertTele01 = "Insert into supplier_contact (supp_id, tele) values (?, ?)";
                    int rows1 = MyConn.save(insertTele01, supId, tele);

                    String insertTele02 = "Insert into supplier_contact (supp_id, tele) values (?, ?)";
                    int rows2 = MyConn.save(insertTele02, supId, contact02);

                    if (rows1 == 1 && rows2 == 1) {
                        System.out.println("Success");
                    } else {
                        System.out.println("Failed");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Error getting supp Id");
                }

            } else {
                JOptionPane.showMessageDialog(null, "Faiiled");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeSupplier() {

        try {

            String delete = "Delete from supplier where supp_id = ?";
            int result = MyConn.save(delete, supId);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Successfully Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateSupplier(String contact02) {

        try {

            String update = "Update supplier set fname = ?, lname = ?, address_line1 = ?, address_line2 = ?, email = ? where supp_id = ?";
            int result = MyConn.save(update, fName, lName, addressLine1, addressLine2, email, supId);
            
            String deleteTele = "Delete from supplier_contact where supp_id = ?";
            MyConn.save(deleteTele, supId);
         
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Successfully Failed");
            }
            
            String insertTele01 = "Insert into supplier_contact (supp_id, tele) values (?, ?)";
                    int rows1 = MyConn.save(insertTele01, supId, tele);

                    String insertTele02 = "Insert into supplier_contact (supp_id, tele) values (?, ?)";
                    int rows2 = MyConn.save(insertTele02, supId, contact02);

                    if (rows1 == 1 && rows2 == 1) {
                        System.out.println("Success");
                    } else {
                        System.out.println("Failed");
                    }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
