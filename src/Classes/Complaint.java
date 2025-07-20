/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author dinis
 */
public class Complaint {

    private int compId;
    private LocalDate madeDate;
    private String description;
    private String status;

    public Complaint() {

    }

    public Complaint(int id, LocalDate mDate, String description, String status) {

        this.compId = id;
        this.madeDate = mDate;
        this.status = status;
        this.description = description;

    }

    public void setComId(int id) {
        this.compId = id;
    }

    public void setMDate(LocalDate mDate) {
        this.madeDate = mDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getComId() {
        return compId;
    }

    public LocalDate getMDate() {
        return madeDate;
    }

    public String getDescription() {
        return description;
    }

    public String gsetStatus() {
        return status;
    }

    public ResultSet viewComplaint(String selectedColumns, String condition, Object... params) {
        ResultSet rs = null;
        try {

            String search = "Select " + selectedColumns + " from complaint";
            if (condition != null && !condition.trim().isEmpty()) {
                search += " where " + condition;
            }
            
            rs = MyConn.search(search, params);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    public void approveComplaint() {
        
        try {
            
            String update = "update complaint set status = ? where comp_id = ?";
            MyConn.save(update, status, compId);
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeComplaint() {

        try {

            String delete = "Delete from complaint where comp_id = ?";
            int rows = MyConn.save(delete, compId);
            
            if (rows == 1) {
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void makeComplaint() {

        try {

            String insert = "Insert into complaint (made_date, description, status) values (?, ?, ?)";
            int rows = MyConn.save(insert, madeDate, description, status);
            
            if (rows == 1) {
                JOptionPane.showMessageDialog(null, "Sent for review");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
