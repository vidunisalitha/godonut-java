/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author dinis
 */
public class BulkOrder extends Order {

    private Date dueDate;

    public BulkOrder() {

    }

    public BulkOrder(int Id, String type, Date mDate, Time mTime, String status, Date dDate) {

        super(type, mDate, mTime, status);
        this.dueDate = dDate;

    }
}
