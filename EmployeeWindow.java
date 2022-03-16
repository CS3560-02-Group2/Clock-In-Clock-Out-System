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

    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
               createAndShowGUI();
            }
         });
    }
}