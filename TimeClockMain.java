
//Obj Oriented Design Group Project 2022
//Main starting window for the clock in clock out program

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class TimeClockMain{

    private static void createAndShowGUI(){
        JFrame frame = new JFrame("Time Clock");
        JPanel mainPanel = new JPanel();
        GridLayout mainGridLayout = new GridLayout(3,3);
        mainPanel.setLayout(mainGridLayout);

        //Status String
        JLabel userStatusLabel = new JLabel("Currently Signed Out");
        userStatusLabel.setHorizontalAlignment(JLabel.CENTER);

        //Login Button
        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                EmployeeWindow jf1 = new EmployeeWindow();
                jf1.show();
                userStatusLabel.setText("Currently Logged In");
            }
        });

        //Logout Button
        JButton logoutBtn = new JButton("Log Out");
        logoutBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                userStatusLabel.setText("Currently Signed Out");
                //logout popup
                JOptionPane.showMessageDialog(frame, "You have been successfully logged out",
                                              "Account Status", JOptionPane.WARNING_MESSAGE);
            }
        });

        //password field
        JPasswordField userPassField = new JPasswordField(9);
        userPassField.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            }
        });
        JPanel userPassFieldPanel = new JPanel();
        String userPassFieldTitle = ("Enter Employee ID");
        Border userPassFieldBorder = BorderFactory.createEtchedBorder();
        Border userPassFieldTitleBorder = BorderFactory.
        createTitledBorder(userPassFieldBorder, userPassFieldTitle);
        userPassFieldPanel.setBorder(userPassFieldTitleBorder);
        userPassFieldPanel.add(userPassField);

        //JMenu Bar
        JMenuBar jmb = new JMenuBar();

        JMenu jmTimeClock = new JMenu("Time Clock");
        JMenuItem jmiOpenShiftWindow = new JMenuItem("Open Shift Window");
        jmTimeClock.add(jmiOpenShiftWindow);
        //jmiOpenShiftWindow.setEnabled(false);
        jmiOpenShiftWindow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                EmployeeWindow jf1 = new EmployeeWindow();
                jf1.show();
            }
        });

        JMenu jmManagerTools = new JMenu("Manager Tools");
        JMenuItem jmiOpenManagerWindow = new JMenuItem("Open Manager Window");
        jmManagerTools.add(jmiOpenManagerWindow);
        jmiOpenManagerWindow.setEnabled(true);
        jmiOpenManagerWindow.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                ManagerToolsWindowUI jf2 = new ManagerToolsWindowUI();
                jf2.show();
                
                //ManagerToolsWindow.createAndShowGUI();
            }
        });

        JMenu jmMore = new JMenu("More");
        JMenuItem jmiExit = new JMenuItem("Exit");
        jmiExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int confirm = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to exit the program?", "Exit Program Message Box",
                    JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
        JMenuItem jmiAbout = new JMenuItem("About");
        jmiAbout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(mainPanel, "Created by Taylor Vandenberg, Duc Nguyen, Alex Gomez, Kennedy Janto, and Janista Gitbumrungsin 2022",
                                             "About", JOptionPane.INFORMATION_MESSAGE);
                                    
            }
        });
        jmMore.add(jmiAbout);
        jmMore.add(jmiExit);

        jmb.add(jmTimeClock);
        jmb.add(jmManagerTools);
        jmb.add(jmMore);
        
        //Add items to frame
        mainPanel.add(userStatusLabel);
        mainPanel.add(userPassFieldPanel);
        mainPanel.add(loginBtn);
        mainPanel.add(logoutBtn);

        //frame
        frame.setJMenuBar(jmb);
        frame.setPreferredSize(new Dimension(400, 200));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
               createAndShowGUI();
            }
         });
    }
}
