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
public class Request {

    private int reqId;
    private LocalDate madeDate;
    private String description;
    //private String type;
    private String status;

    public Request() {

    }

    public Request(int id, LocalDate mDate, String description, String type, String status) {

        this.reqId = id;
        this.madeDate = mDate;
        this.description = description;
        // this.type = type;
        this.status = status;

    }

    public void setReqId(int id) {
        this.reqId = id;
    }

    public void setMDate(LocalDate mDate) {
        this.madeDate = mDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public void setType(String type) {
//        this.type = type;
//    }
    public void setStatus(String status) {
        this.status = status;
    }

    public int getReqId() {
        return reqId;
    }

    public LocalDate getMDate() {
        return madeDate;
    }

    public String getDescription() {
        return description;
    }

//    public String getType() {
//        return type;
//    }
    public String setStatus() {
        return status;
    }

    public ResultSet viewRequest(String selectedColumns, String condition, Object... params) {
        ResultSet rs = null;
        try {

            String search = "Select " + selectedColumns + " from request";
            if (condition != null && !condition.trim().isEmpty()) {
                search += " where " + condition;
            }

            rs = MyConn.search(search, params);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    public void makeRequest(String userId) {

        try {

            String insert = "Insert into request (made_date, description, status, user_id) values (?, ?, ?, ?)";
            int rows = MyConn.save(insert, madeDate, description, status, userId);

            if (rows == 1) {
                JOptionPane.showMessageDialog(null, "Request added for review");
            } else {
                JOptionPane.showMessageDialog(null, "Faild");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeRequest() {

        try {

            String delete = "Delete from request where req_id = ?";
            int rows = MyConn.save(delete, reqId);
            
            if (rows == 1) {
                JOptionPane.showMessageDialog(null, "Request Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void passRequest() {
        try {

            String approve = "Update request set status = ? where req_id = ?";
            MyConn.save(approve, status, reqId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void approveRequest() {

        try {

            String approve = "Update request set status = ? where req_id = ?";
            MyConn.save(approve, status, reqId);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void denyRequest() {

        try {

            String approve = "Update request set status = ? where req_id = ?";
            MyConn.save(approve, status, reqId);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
