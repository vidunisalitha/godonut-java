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
public class Notification {

    private int noteID;
    private Date madeDate;
    private String description;
    private String status;

    public Notification() {

    }

    public Notification(Date madeDate, String description, String status) {

        this.madeDate = madeDate;
        this.description = description;
        this.status = status;

    }

    public void setNoteID(int noteID) {
        this.noteID = noteID;
    }

    public void setMadeDate(Date madeDate) {
        this.madeDate = madeDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getMadeDate() {
        return madeDate;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }

    public int getNoteID() {
        return noteID;
    }

    public ResultSet viewNote(String selectedColumns, String joinClause, String whereClause, Object... params) {
        ResultSet rs = null;
        try {
            String search = "Select " + selectedColumns + " from notification as n";
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

    public void addNote(String uid) {

        try {

            String insert = "Insert into notification(user_id, made_date, description, status) values (?, ?, ?, ?)";
            int result = MyConn.save(insert, uid, madeDate, description, status);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Sent");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeNote() {

        try {

            String remove = "Delete from notification where note_id = ?";
            int result = MyConn.save(remove, noteID);

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
