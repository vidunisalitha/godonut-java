/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Others;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dinis
 */
public class MyConn {

    static Connection c;

    public static void getMyConn() throws Exception {

        // creating sql drivers with database
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Link of the mysql database 
        // Running in locally - localhost portnumber - 3306
        // databse name CafeManagementSystem
        String url = "jdbc:mysql://localhost:3306/cafemanagementsystem";

        c = DriverManager.getConnection(url, "root", "Pass@123");
        c.setAutoCommit(false);
    }

    // This will handle insert, update, delete queries
    public static int save(String sql, Object... params) throws Exception {
        if (c == null) {
            getMyConn();
        }
        try (PreparedStatement pstm = c.prepareStatement(sql)) {
            setParameters(pstm, params);
            int ret = pstm.executeUpdate();
            c.commit();
            
            return ret;
        } catch (Exception e) {
            c.rollback();
            e.printStackTrace();
        }
        
        return 0;
    }

    // This will handle search query
    public static ResultSet search(String sql, Object... params) throws Exception {
        if (c == null) {
            getMyConn();
        }
        PreparedStatement pstmt = c.prepareStatement(sql);
        setParameters(pstmt, params);
        return pstmt.executeQuery();

    }

    public static void setParameters(PreparedStatement pstm, Object... params) throws SQLException {
        for (int i = 0; i < params.length; i++) {
            pstm.setObject(i + 1, params[i]);
        }
    }

}
