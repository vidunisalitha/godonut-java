/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author dinis
 */
public class Report {

    private String userID;
    private LocalDate date;
    private LocalTime made_time;
    private String type;

    public Report() {

    }

    public Report(String userID, LocalDate date, LocalTime time, String type) {

        this.userID = userID;
        this.date = date;
        this.made_time = time;
        this.type = type;

    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserID() {
        return userID;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public ResultSet viewRecord(String selectedColumns, String filterConditions, Object... params) {
        ResultSet rs = null;
        try {
            String query = "SELECT " + selectedColumns + " FROM report";
            if (filterConditions != null && !filterConditions.trim().isEmpty()) {
                query += " WHERE " + filterConditions;
            }
            rs = MyConn.search(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void saveRecord() {

        try {

            String save = "Insert into report (user_id, made_time, date, type) values (?, ?, ?, ?)";
            int result = MyConn.save(save, userID, made_time, date, type);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfull");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
