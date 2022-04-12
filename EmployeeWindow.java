//Obj Oriented Design Group Project 2022
//Main employee window, can clock in/out or go on break

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeWindow{

    private static void createAndShowGUI(){
        //Gui stuff here
        //clock in/ out button
        //break start/end button
        //should close after showing confirmation of button press
        setTitle("Welcome");
        setSize(500,600);
        setMinimumSize(new Dimension(300,400));
        setDefaultCloseOperation(WindowConstrants.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
               createAndShowGUI();
            }
         });
    }
}