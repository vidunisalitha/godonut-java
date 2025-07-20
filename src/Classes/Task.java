/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import Others.MyConn;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.Date;

/**
 *
 * @author dinis
 */
public class Task {

    private int taskId;
    private String description;
    private LocalDate dueDate;
    private String status;

    public Task() {

    }

    public Task(int id, String description, LocalDate dDate, String status) {

        this.taskId = id;
        this.description = description;
        this.dueDate = dDate;
        this.status = status;

    }

    public void setTaskId(int id) {
        this.taskId = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(LocalDate dDate) {
        this.dueDate = dDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public ResultSet viewTask(String selectedColumns, String joinClause, String whereClause, Object... params) {
        ResultSet rs = null;
        try {
            String search = "Select " + selectedColumns + " from Task as t";
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

    public void addTask(String userId) {

        try {

            String insertTask = "Insert into task (description, due_date, status, user_id) values (?, ?, ?, ?)";
            int rows = MyConn.save(insertTask, description, dueDate, status, userId);

            if (rows >= 1) {
                JOptionPane.showMessageDialog(null, "Task addedd sucessfully");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void removeTask() {

        try {

            String rmTask = "Delete from task where task_id = ?";
            int rows = MyConn.save(rmTask, taskId);

            if (rows >= 1) {
                JOptionPane.showMessageDialog(null, "Task Removed");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateTask(String userId) {

        try {

            String upTask = "Update task set description = ?, due_date = ?, status = ?, user_id = ? where task_id = ?";
            int rows = MyConn.save(upTask, description, dueDate, status, userId, taskId);

            if (rows >= 1) {
                JOptionPane.showMessageDialog(null, "Task Updated");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void markCompletion() {

        try {

            String markCompletion = "Update task set status = ? where task_id = ?";
            int rows = MyConn.save(markCompletion, status, taskId);

            if (rows == 1) {
                JOptionPane.showMessageDialog(null, "Mark as completed");
            } else {
                JOptionPane.showMessageDialog(null, "Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ResultSet viewOverDueTask(Date curuntDate, String uId) {
        ResultSet rs = null;
        try {

            String getOverdueTasks = "Select * from task as t inner join  user as u on u.user_id = t.user_id where t.due_date < ? and t.status = ? and t.user_id = ?";
            rs = MyConn.search(getOverdueTasks, curuntDate, "Pending", uId);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

}
