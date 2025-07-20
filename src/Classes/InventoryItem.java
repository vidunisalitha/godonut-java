/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author dinis
 */
public class InventoryItem {

    private int itemId;
    private String name;
    private String type;
    private double price;
    private int quantity;
    private String unit;

    public InventoryItem() {

    }

    public InventoryItem(String name, String type, double price, int qty, String unit) {

        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = qty;
        this.unit = unit;

    }

    public void setItemId(int id) {
        this.itemId = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void seType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQty(int qty) {
        this.quantity = qty;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getItemId(int id) {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public ResultSet viewInvenory(String selectedColumns, String filterConditions, Object... params) {

        ResultSet rs = null;
        try {
            String query = "SELECT " + selectedColumns + " FROM inventory_item";
            if (filterConditions != null && !filterConditions.trim().isEmpty()) {
                query += " WHERE " + filterConditions;
            }
            rs = MyConn.search(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;

    }

    public void addItem() {

        try {

            String addItem = "Insert into inventory_item (name, type, price, quantity, unit) values(?, ?, ?, ?, ?)";
            int result = MyConn.save(addItem, name, type, price, quantity, unit);

            if (result == 1) {
                String getNewId = "SELECT LAST_INSERT_ID() AS id";
                ResultSet rs = MyConn.search(getNewId);
                int newItemId = -1;
                if (rs.next()) {
                    newItemId = rs.getInt("id");
                }

                Date cgdate = Date.valueOf(LocalDate.now());
                Time cgtime = Time.valueOf(LocalTime.now());
                StockLog log = new StockLog(newItemId, "Insert", cgdate, cgtime, 0, quantity);
                log.addStockLog();

                JOptionPane.showMessageDialog(null, "Successfully added the item");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeItem() {

        try {

            String getQty = "Select quantity from inventory_item where item_id = ?";
            ResultSet rs = MyConn.search(getQty, itemId);

            int oldQty = -1;
            if (rs.next()) {
                oldQty = rs.getInt("quantity");
            } else {
                JOptionPane.showMessageDialog(null, "Item not found");
                return;
            }

            String rmItem = "Delete from inventory_item where item_id = ?";
            int result = MyConn.save(rmItem, itemId);

            if (result == 1) {

                Date cgdate = Date.valueOf(LocalDate.now());
                Time cgtime = Time.valueOf(LocalTime.now());
                StockLog log = new StockLog(itemId, "Delete", cgdate, cgtime, oldQty, 0);
                log.addStockLog();
                JOptionPane.showMessageDialog(null, "Successfully deleted the item");

            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateItem() {

        try {

            String getQty = "Select quantity from inventory_item where item_id = ?";
            ResultSet rs = MyConn.search(getQty, itemId);

            int oldQty = -1;
            if (rs.next()) {
                oldQty = rs.getInt("quantity");
            } else {
                JOptionPane.showMessageDialog(null, "Item not found");
                return;
            }

            String upItem = "Update inventory_item set name = ?, type = ?, price = ?, quantity = ?, unit = ? where item_id = ?";
            int result = MyConn.save(upItem, name, type, price, quantity, unit, itemId);

            if (result == 1) {

                if (oldQty != quantity) {

                    Date cgdate = Date.valueOf(LocalDate.now());
                    Time cgtime = Time.valueOf(LocalTime.now());
                    StockLog log = new StockLog(itemId, "Update", cgdate, cgtime, oldQty, quantity);
                    log.addStockLog();

                }

                JOptionPane.showMessageDialog(null, "Successfully Updated the item");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
