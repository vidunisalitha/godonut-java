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
public class Salary {

    private int expenseId;
    private String userId;
    private double bonus;
    private double deductions;

    public Salary() {
        
    }

    public Salary(int expenseId, String userId, double bonus, double deductions) {
        
        this.expenseId = expenseId;
        this.userId = userId;
        this.bonus = bonus;
        this.deductions = deductions;
        
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public String getUserId() {
        return userId;
    }

    public double getBonus() {
        return bonus;
    }

    public double getDeductions() {
        return deductions;
    }

    public void addSalary() {
        
        try {
            
            String sal = "Insert into salary (expense_id, user_id, bonus, deductions) values (?, ?, ?, ?)";
            int result = MyConn.save(sal, expenseId, userId, bonus, deductions);
            
            if (result == 1) {
                JOptionPane.showMessageDialog(null, "Successfully adde the salary");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    public ResultSet viewSalary(String selectedColumns, String joinClause, String whereClause, Object... params) {
        ResultSet rs = null;
        try {
            String search = "Select " + selectedColumns + " from salary as s";
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
    
    public void updateSalary(){
    
        try {
            
            String upSal = "update salary set bonus  = ?, deductions = ? where expense_id = ?";
            int result =  MyConn.save(upSal, bonus, deductions, expenseId);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
