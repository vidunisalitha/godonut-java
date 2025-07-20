/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Others;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

/**
 *
 * @author dinis
 */
public class DateTime {

    public static String showTime() {
        
        Date timeD = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        return sdf.format(timeD);

    }

    public static String showDate() {

        Date d = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        return df.format(d);

    }

}
