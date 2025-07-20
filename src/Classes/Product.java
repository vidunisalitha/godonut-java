/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author dinis
 */
public class Product {

    private String productID;
    private String name;
    private String category;
    private String description;
    private double price;
    private boolean availability;

    public Product() {

    }

    public Product(String productID, String name, String category, String description, double price) {

        this.productID = productID;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.availability = availability;

    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean getAvailability() {
        return availability;
    }

    public ResultSet viewProduct(String selectedColumns, String filterConditions, Object... params) {
        ResultSet rs = null;
        try {
            String query = "SELECT " + selectedColumns + " FROM product as p";
            if (filterConditions != null && !filterConditions.trim().isEmpty()) {
                query += " WHERE " + filterConditions;
            }
            rs = MyConn.search(query, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void addProduct() {

        try {

            String insert = "Insert into product(product_id, name, category, description, price) values(?, ?, ?, ?, ?)";
            int result = MyConn.save(insert, productID, name, category, description, price);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Added");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeProduct() {

        try {

            String rmProduct = "Delete from product where product_id = ?";
            int result = MyConn.save(rmProduct, productID);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Deleted");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateProduct() {

        try {

            String update = "update product set name = ?, category= ?, description = ?, price = ? where product_id = ?";
            int result = MyConn.save(update, name, category, description, price, productID);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void setMenu() {

        try {

            String setM = "update product set availability = ? where product_id = ?";
            int result = MyConn.save(setM, availability, productID);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Set as Menu");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void unSetMenu() {

        try {

            String unsetM = "update product set availability = ? where product_id = ?";
            int result = MyConn.save(unsetM, availability, productID);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Unset as Menu");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
