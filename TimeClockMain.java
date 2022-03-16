//Obj Oriented Design Group Project 2022
//Main starting window for the clock in clock out program

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TimeClockMain{

    private static void createAndShowGUI(){
        //Gui stuff here
        //button press on keypad inputs to password field
        //call method to check password, if password is valid
        //the clock in/out window is shown, else an error message is shown

    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
               createAndShowGUI();
            }
         });
    }
}
