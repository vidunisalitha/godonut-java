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

public class StockLog {

    private int logId;
    private int itemId;
    private String action;
    private Date changeDate;
    private Time changeTime;
    private int oldQuantity;
    private int newQuantity;

    public StockLog() {

    }

    public StockLog(int itemId, String action, Date changeDate, Time changeTime, int oldQuantity, int newQuantity) {

        this.itemId = itemId;
        this.action = action;
        this.changeDate = changeDate;
        this.changeTime = changeTime;
        this.oldQuantity = oldQuantity;
        this.newQuantity = newQuantity;

    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
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

    public void setOldQuantity(int oldQuantity) {
        this.oldQuantity = oldQuantity;
    }

    public void setNewQuantity(int newQuantity) {
        this.newQuantity = newQuantity;
    }

    public int getLogId() {
        return logId;
    }

    public int getItemId() {
        return itemId;
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

    public int getOldQuantity() {
        return oldQuantity;
    }

    public int getNewQuantity() {
        return newQuantity;
    }

    public void addStockLog() {

        try {
            
            String log = "Insert into stock_log (item_id, action, change_date, change_time, old_quantity, new_quantity) values (?, ?, ?, ?, ?, ?)";
            int result = MyConn.save(log, itemId, action, changeDate, changeTime, oldQuantity, newQuantity);
            
            if (result == 1) {
                System.out.println("Sucess");
            } else {
                System.out.println("Sucess");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
   public ResultSet viewStockLog(String selectedColumns, String joinClause, String whereClause, Object... params) {
        ResultSet rs = null;
        try {
            String search = "Select " + selectedColumns + " from stock_log as sl";
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
