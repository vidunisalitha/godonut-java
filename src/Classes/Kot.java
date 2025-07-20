/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author dinis
 */
public class Kot {

    private int kotID;
    private String status;

    public Kot() {

    }

    public Kot(int kotID, String status) {

        this.kotID = kotID;
        this.status = status;

    }

    public void setKotId(int id) {
        this.kotID = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getKotId() {
        return kotID;
    }

    public String getStatus() {
        return status;
    }

    public ResultSet viewKot(String selectedColumns, String joinClause, String whereClause, Object... params) {
        ResultSet rs = null;
        try {
            String search = "Select " + selectedColumns + " from kot as k";
            if (joinClause != null && !joinClause.trim().isEmpty()) {
                search += " " + joinClause;
            }
            if (whereClause != null && !whereClause.trim().isEmpty()) {
                search += " where " + whereClause;
            }
            rs = MyConn.search(search, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void addKot(int oid, String uid) {

        try {

            String addKot = "Insert into kot (status, order_id, user_id) values (?, ?, ?)";
            int result = MyConn.save(addKot, status, oid, uid);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "KOT Added");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateKotStatus() {

        try {

            String upS = "update kot set status = ? where kot_id = ?";
            int result = MyConn.save(upS, status, kotID);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "KOT Added");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendKot(List<String> products, int orderId, String userId) {
        try {

            String sql = "INSERT INTO Kot (status, order_id, user_id) VALUES (?, ?, ?)";
            int result = MyConn.save(sql, status, orderId, userId);

            if (result == 1) {
                String message = "KOT Added Successfully\nOrder ID: " + orderId + "\nProducts: " + String.join(", ", products);
                JOptionPane.showMessageDialog(null, message);
            } else {
                JOptionPane.showMessageDialog(null, "Failed to send KOT");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
