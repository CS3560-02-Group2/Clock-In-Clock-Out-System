
//This window will be displayed after selecting an employee in the table from ManagerTools
//upon selecting a shift for the employee you will be able to edit the date and time
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class shiftEditorPopup {
    static void createAndShowGUI(){
        
        JFrame frame = new JFrame("Edit Shifts");
        JPanel mainPanel = new JPanel();

        //Table
        jTable1 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Date", "Begin Shift", "Begin Break", "End Break", "End Shift"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        //mainPanel
        mainPanel.add(jScrollPane1);
        
        //frame
        frame.add(mainPanel);
        frame.setPreferredSize(new Dimension(500, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private static javax.swing.JTable jTable1;
    private static javax.swing.JScrollPane jScrollPane1;
}
