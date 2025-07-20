/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Time;

/**
 *
 * @author dinis
 */
public class Login {
    
    private String userId;
    private Time loggedTime;
    private Date loggedDate;
    
    public Login(){
    
    }
    
    public Login(String uId, Time lTime, Date lDate){
        
        this.userId = uId;
        this.loggedTime = lTime;
        this.loggedDate = lDate;
        
    }
    
    public void setUserId(String uId){
        this.userId = uId;
    }
    
    public void setLoggedTime(Time lTime){
        this.loggedTime = lTime;
    }
    
    public void setLoggedDate(Date lDate){
        this.loggedDate = lDate;
    }
    
    public String getUserId(){
        return userId;
    }
    
    public Time getLoggedTime(){
        return loggedTime;
    }
    
    public Date getLoggedDate(){
        return loggedDate;
    }
    
   public ResultSet viewRecord(String selectedColumns, String joinClause, String whereClause, Object... params) {
        ResultSet rs = null;
        try {
            String search = "Select " + selectedColumns + " from login as l";
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
    
    public void saveRecord(){
        
        try {
            
            String saveLogin = "Insert into login (user_id, logged_time, logged_date) values (?, ?, ?)";
            int rows = MyConn.save(saveLogin, userId, loggedTime, loggedDate);
            
            if (rows == 1) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
}
