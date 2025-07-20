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
public class SupplierPurchase {

    private int expenseId;
    private int itemId;
    private int supplierId;
    private String invoiceNumber;
    private double discount;

    public SupplierPurchase() {

    }

    public SupplierPurchase(int expenseId, int itemId, int supplierId, String invoiceNumber, double discount) {

        this.expenseId = expenseId;
        this.itemId = itemId;
        this.supplierId = supplierId;
        this.invoiceNumber = invoiceNumber;
        this.discount = discount;

    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public int getItemId() {
        return itemId;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public double getDiscount() {
        return discount;
    }

    public void addSupplierPurchase() {

        try {

            String insert = "Insert into supplier_purchase (expense_id, item_id, supplier_id, invoice_number, discount) values (?, ?, ?, ?, ?)";
            int result = MyConn.save(insert, expenseId, itemId, supplierId, invoiceNumber, discount);

            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully Added");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet viewSupplierPurchase(String selectedColumns, String joinClause, String whereClause, Object... params) {
        ResultSet rs = null;
        try {
            String search = "Select " + selectedColumns + " from supplier_purchase as sp";
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
