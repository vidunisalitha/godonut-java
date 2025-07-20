/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author dinis
 */
import Others.MyConn;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

public class ExpenseLog {

    private int logId;
    private int expenseId;
    private String action;
    private Date changeDate;
    private Time changeTime;
    private double oldAmount;
    private double newAmount;

    public ExpenseLog() {

    }

    public ExpenseLog(int expenseId, String action, Date changeDate, Time changeTime, double oldAmount, double newAmount) {

        this.expenseId = expenseId;
        this.action = action;
        this.changeDate = changeDate;
        this.changeTime = changeTime;
        this.oldAmount = oldAmount;
        this.newAmount = newAmount;

    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public void setChangeTime(Time changeTime) {
        this.changeTime = changeTime;
    }

    public void setOldAmount(double oldAmount) {
        this.oldAmount = oldAmount;
    }

    public void setNewAmount(double newAmount) {
        this.newAmount = newAmount;
    }

    public int getLogId() {
        return logId;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public String getAction() {
        return action;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public Time getChangeTime() {
        return changeTime;
    }

    public double getOldAmount() {
        return oldAmount;
    }

    public double getNewAmount() {
        return newAmount;
    }

    public void addExpenseLog() {

        try {

            String log = "Insert into expense_log (expense_id, action, change_date, change_time, old_amount, new_amount) values (?, ?, ?, ?, ?, ?)";
            int result = MyConn.save(log, expenseId, action, changeDate, changeTime, oldAmount, newAmount);

            if (result == 1) {
                System.out.println("success");
            } else {
                System.out.println("Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet viewExpenceLog(String selectedColumns, String joinClause, String whereClause, Object... params) {
        ResultSet rs = null;
        try {
            String search = "Select " + selectedColumns + " from expense_log as el";
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
}
