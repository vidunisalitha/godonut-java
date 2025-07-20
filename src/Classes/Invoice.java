/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author dinis
 */
public class Invoice {

    private int invoiceID;
    private double amount;
    private double serviceCharge;
    private double discount;
    private double tax;
    private double total;

    public Invoice() {

    }

    public Invoice(int invoiceID, double amount, double serviceCharge, double discount, double tax, double total) {

        this.invoiceID = invoiceID;
        this.amount = amount;
        this.serviceCharge = serviceCharge;
        this.discount = discount;
        this.tax = tax;
        this.total = total;

    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setServiceCharge(double serviceCharge) {
        this.serviceCharge = serviceCharge;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public double getAmount() {
        return amount;
    }

    public double getServiceCharge() {
        return serviceCharge;
    }

    public double getDiscount() {
        return discount;
    }

    public double getTax() {
        return tax;
    }

    public double getTotal() {
        return total;
    }

    public void calculateTotal() {

    }

}
