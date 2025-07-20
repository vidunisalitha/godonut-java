/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author dinis
 */
public class Order {

    protected int orderId;
    protected String type;
    protected Date madeDate;
    protected Time madeTime;
    protected String status;

    public Order() {

    }

    public Order(String type, Date mDate, Time mTime, String status) {

        //   this.orderId = Id;
        this.type = type;
        this.madeDate = mDate;
        this.madeTime = mTime;
        this.status = status;

    }

    public void setOrderId(int Id) {
        this.orderId = Id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMadeDate(Date mDate) {
        this.madeDate = mDate;
    }

    public void setMadeTime(Time mTime) {
        this.madeTime = mTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getType() {
        return type;
    }

    public Date getMadeDate() {
        return madeDate;
    }

    public Time getMadeTime() {
        return madeTime;
    }

    public String getStatus() {
        return status;
    }

    public ResultSet viewOrder(String selectedColumns, String joinClause, String whereClause, Object... params) {
        ResultSet rs = null;
        try {
            String search = "Select " + selectedColumns + " from order as o";
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

    public int addOrder(double amount, double serviceCharge, double discount, double tax, double total, String uid) {

        try {
            String sql = "INSERT INTO `Order` (made_date, made_time, order_type, status, amount, service_charge, discount, tax, total, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            int result = MyConn.save(sql, madeDate, madeTime, type, status, amount, serviceCharge, discount, tax, total, uid);

            if (result == 1) {
                ResultSet rs = MyConn.search("SELECT LAST_INSERT_ID()");
                if (rs.next()) {
                    int orderId = rs.getInt(1);
                    JOptionPane.showMessageDialog(null, "Order successfully added with ID: " + orderId);
                    return orderId;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Failed to add order");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;

    }

    public void addProductsToOrder(int orderId, ArrayList<String> productIds) {

        try {
            for (String productId : productIds) {
                String sql = "INSERT INTO Product_order (order_id, product_id) VALUES (?, ?)";
                int result = MyConn.save(sql, orderId, productId);
                if (result != 1) {
                    JOptionPane.showMessageDialog(null, "Failed to add product: " + productId);
                }
            }
            JOptionPane.showMessageDialog(null, "Products successfully added to the order!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void generateBill() {

    }

    public void calculateTotal() {

    }

}
