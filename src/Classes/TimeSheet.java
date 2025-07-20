/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author dinis
 */
public class TimeSheet {

    private String userID;
    private LocalDate date;
    private LocalTime clockinTime;
    private LocalTime clockoffTime;

    public TimeSheet() {

    }

    public TimeSheet(String userID, LocalDate date, LocalTime clockinTime, LocalTime clockoffTime) {

        this.userID = userID;
        this.date = date;
        this.clockinTime = clockinTime;
        this.clockoffTime = clockoffTime;

    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setClockinTime(LocalTime clockinTime) {
        this.clockinTime = clockinTime;
    }

    public void setClockoffTime(LocalTime clockoffTime) {
        this.clockoffTime = clockoffTime;
    }

    public String getUserID() {
        return userID;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getClockinTime() {
        return clockinTime;
    }

    public LocalTime getClockoffTime() {
        return clockoffTime;
    }

    public void markClockin() {

        try {

            String search = "Select clockin_time from time_sheet where user_id = ? and date =?";
            ResultSet rs = MyConn.search(search, userID, date);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "You have already marked the Clock-In-Time");
            } else {

                String markIn = "Insert into time_sheet (user_id, date, clockin_time) values (?, ?, ?)";
                int rows = MyConn.save(markIn, userID, date, clockinTime);

                if (rows == 1) {
                    JOptionPane.showMessageDialog(null, "Successfully marked the attendance");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed");
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void markClockoff() {

        try {

            String search = "Select clockoff_time from time_sheet where user_id = ? and date =?";
            ResultSet rs = MyConn.search(search, userID, date);

            if (rs.next()) {

                Time offTime = rs.getTime("clockoff_time");
                if (offTime != null) {
                    JOptionPane.showMessageDialog(null, "You have already marked the Clock of time");
                } else {

                    String markOff = "Update time_sheet set clockoff_time = ? where user_id = ? and date = ?";
                    int rows = MyConn.save(markOff, clockoffTime, userID, date);

                    if (rows == 1) {
                        JOptionPane.showMessageDialog(null, "Off time marked successfully");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed");
                    }

                }

            } else {
                JOptionPane.showMessageDialog(null, "Clock off time not marked yet");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void viewAttendance() {

    }
}
