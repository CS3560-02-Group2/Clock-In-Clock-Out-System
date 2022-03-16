//Obj Oriented Design Group Project 2022
//Main starting window for the Manager

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class ManagerWindow{

    private static void createAndShowGUI(){
        //Gui stuff here
        //buttons to clock in, out, and go on break
        //extra button to access manager tools window, should auto close for all buttons after
        //confirmation besides the manager tools button

    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
               createAndShowGUI();
            }
         });
    }
}