/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.sql.Date;

/**
 *
 * @author dinis
 */
public class Logsheet {

    private int sheetID;
    private String type;
    private Date madeDate;
    private String description;

    public Logsheet() {

    }

    public Logsheet(String type, Date madeDate, String description) {

        this.type = type;
        this.madeDate = madeDate;
        this.description = description;

    }

    public void setSheetID(int sheetID) {
        this.sheetID = sheetID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMadeDate(Date madeDate) {
        this.madeDate = madeDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSheetID() {
        return sheetID;
    }

    public String getType() {
        return type;
    }

    public Date getMadeDate() {
        return madeDate;
    }

    public String getDescription() {
        return description;
    }

    public ResultSet viewLog(String selectedColumns, String filterConditions, Object... params) {

        ResultSet rs = null;
        try {
            String query = "SELECT " + selectedColumns + " FROM log_sheet";
            if (filterConditions != null && !filterConditions.trim().isEmpty()) {
                query += " WHERE " + filterConditions;
            }
            rs = MyConn.search(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }

    public void addLog(String userId) {

        try {

            String save = "Insert into log_sheet (type, made_date, description, user_id) values (?, ?, ?, ?)";
            int result = MyConn.save(save, type, madeDate, description, userId);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfull Added");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateLog() {

        try {

            String update = "Update log_sheet set type = ?, description = ? where sheet_id = ?";
            int result = MyConn.save(update, type, description, sheetID);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfull Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeLog() {

        try {

            String delete = "Delete from log_sheet where sheet_id = ?";
            int result = MyConn.save(delete, sheetID);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfull Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
