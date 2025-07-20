/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Others;

/**
 *
 * @author dinis
 */
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

public class TableUtils {

    public static void setTableEditableFalse(JTable... tables) {
        for (JTable table : tables) {
            table.setDefaultEditor(Object.class, null);
        }
    }

    public static void addRowDeselectOnDoubleClick(JTable... tables) {
        for (JTable table : tables) {
            table.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getClickCount() == 2) {
                        int row = table.rowAtPoint(e.getPoint());
                        if (row != -1 && table.isRowSelected(row)) {
                            table.getSelectionModel().removeSelectionInterval(row, row);
                        }
                    }
                }
            });
        }
    }
}
