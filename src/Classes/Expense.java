/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.swing.JOptionPane;

/**
 *
 * @author dinis
 */
public class Expense {

    private int expenceId;
    private String type;
    private Date madeDate;
    private Time madeTime;
    private double amount;

    public Expense() {

    }

    public Expense(String type, Date mDate, Time mTime, double amount) {

        this.type = type;
        this.madeDate = mDate;
        this.madeTime = mTime;
        this.amount = amount;

    }

    public void setExpenceId(int id) {
        this.expenceId = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMDate(Date mDate) {
        this.madeDate = mDate;
    }

    public void setMTime(Time mTime) {
        this.madeTime = mTime;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getExpenceId() {
        return expenceId;
    }

    public String getType() {
        return type;
    }

    public Date getMDate() {
        return madeDate;
    }

    public Time getMTime() {
        return madeTime;
    }

    public double getAmount() {
        return amount;
    }

    public ResultSet viewExpence(String selectedColumns, String condition, Object... params) {
        ResultSet rs = null;
        try {

            String search = "Select " + selectedColumns + " from expense";
            if (condition != null && !condition.trim().isEmpty()) {
                search += " where " + condition;
            }

            rs = MyConn.search(search, params);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    public void addExpence() {

        try {

            String addExpence = "Insert into expense (type, made_date, made_time, amount) values (?, ?, ?, ?)";
            int result = MyConn.save(addExpence, type, madeDate, madeTime, amount);

            if (result == 1) {

                String getNewId = "SELECT LAST_INSERT_ID() AS id";
                ResultSet rs = MyConn.search(getNewId);
                int newItemId = -1;
                if (rs.next()) {
                    newItemId = rs.getInt("id");
                }

                Date cgdate = Date.valueOf(LocalDate.now());
                Time cgtime = Time.valueOf(LocalTime.now());

                ExpenseLog log = new ExpenseLog(newItemId, "Insert", cgdate, cgtime, 0, amount);
                log.addExpenseLog();

                JOptionPane.showMessageDialog(null, "Successfully Marked");
            } else {
                JOptionPane.showMessageDialog(null, "failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateExpence() {

        try {

            String getQty = "Select amount from expense where expense_id = ?";
            ResultSet rs = MyConn.search(getQty, expenceId);

            int oldAmount = -1;
            if (rs.next()) {
                oldAmount = rs.getInt("amount");
            } else {
                JOptionPane.showMessageDialog(null, "Item not found");
                return;
            }

            String upExpence = "update expense set type = ?, amount = ? where expense_id = ?";
            int result = MyConn.save(upExpence, type, amount, expenceId);

            if (result == 1) {

                if (oldAmount != amount) {

                    Date cgdate = Date.valueOf(LocalDate.now());
                    Time cgtime = Time.valueOf(LocalTime.now());
                    ExpenseLog log = new ExpenseLog(expenceId, "Update", cgdate, cgtime, oldAmount, amount);
                    log.addExpenseLog();

                }

                JOptionPane.showMessageDialog(null, "Successfully Marked");
            } else {

                JOptionPane.showMessageDialog(null, "failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
