/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author nguyen
 */
class timeAndDate {
    int day, month, year;
    int second, minute,hour;
}
public class EmployeeWindow extends javax.swing.JFrame {

    // Initialize variables
    timeAndDate beginShift = new timeAndDate();
    timeAndDate beginBreak = new timeAndDate();
    timeAndDate endBreak = new timeAndDate();
    timeAndDate endShift = new timeAndDate();
    //timeAndDate[] tAd = {beginShift, beginBreak, endBreak, endShift};
    GregorianCalendar gc = new GregorianCalendar();
    /**
     * Creates new form NewJFrame
     */
    public EmployeeWindow() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        beginBreakButton = new javax.swing.JButton();
        endBreakButton = new javax.swing.JButton();
        endShiftButton = new javax.swing.JButton();
        beginShiftButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logOutButton = new javax.swing.JButton();
        showTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        beginBreakButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        beginBreakButton.setText("Begin Break");
        beginBreakButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginBreakButtonActionPerformed(evt);
            }
        });

        endBreakButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        endBreakButton.setText("End Break");
        endBreakButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endBreakButtonActionPerformed(evt);
            }
        });

        endShiftButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        endShiftButton.setText("End Shift");
        endShiftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endShiftButtonActionPerformed(evt);
            }
        });

        beginShiftButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        beginShiftButton.setText("Begin Shift");
        beginShiftButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginShiftButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Thank You For");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Coming To Work");

        logOutButton.setForeground(new java.awt.Color(204, 0, 51));
        logOutButton.setText("Log Out");
        logOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logOutButtonActionPerformed(evt);
            }
        });

        showTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        showTime.setText("Time Will Show Here");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(showTime, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(188, 188, 188)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(endBreakButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(beginShiftButton, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(beginBreakButton, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                            .addComponent(endShiftButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beginShiftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beginBreakButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(endBreakButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endShiftButton, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(showTime, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(logOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        pack();
    }// </editor-fold>                        

    private void beginShiftButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        beginShift.day=gc.get(Calendar.DAY_OF_MONTH);
        beginShift.month=gc.get(Calendar.MONTH);
        beginShift.year=gc.get(Calendar.YEAR);
        beginShift.second=gc.get(Calendar.SECOND);
        beginShift.minute=gc.get(Calendar.MINUTE);
        beginShift.hour=gc.get(Calendar.HOUR);
        showTime.setText((beginShift.month+1)+"/"+beginShift.day+"/"+beginShift.year+" "+beginShift.hour+":"+beginShift.minute+":"+beginShift.second);
    }                                                

    private void endShiftButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        endShift.day=gc.get(Calendar.DAY_OF_MONTH);
        endShift.month=gc.get(Calendar.MONTH);
        endShift.year=gc.get(Calendar.YEAR);
        endShift.second=gc.get(Calendar.SECOND);
        endShift.minute=gc.get(Calendar.MINUTE);
        endShift.hour=gc.get(Calendar.HOUR);
        showTime.setText((endShift.month+1)+"/"+endShift.day+"/"+endShift.year+" "+endShift.hour+":"+endShift.minute+":"+endShift.second);
    }                                              

    private void logOutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        dispose();
    }                                            

    private void beginBreakButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        beginBreak.day=gc.get(Calendar.DAY_OF_MONTH);
        beginBreak.month=gc.get(Calendar.MONTH);
        beginBreak.year=gc.get(Calendar.YEAR);
        beginBreak.second=gc.get(Calendar.SECOND);
        beginBreak.minute=gc.get(Calendar.MINUTE);
        beginBreak.hour=gc.get(Calendar.HOUR);
        showTime.setText((beginBreak.month+1)+"/"+beginBreak.day+"/"+beginBreak.year+" "+beginBreak.hour+":"+beginBreak.minute+":"+beginBreak.second);
    }                                                

    private void endBreakButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        endBreak.day=gc.get(Calendar.DAY_OF_MONTH);
        endBreak.month=gc.get(Calendar.MONTH);
        endBreak.year=gc.get(Calendar.YEAR);
        endBreak.second=gc.get(Calendar.SECOND);
        endBreak.minute=gc.get(Calendar.MINUTE);
        endBreak.hour=gc.get(Calendar.HOUR);
        showTime.setText((endBreak.month+1)+"/"+endBreak.day+"/"+endBreak.year+" "+endBreak.hour+":"+endBreak.minute+":"+endBreak.second);
    }                                              
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton beginBreakButton;
    private javax.swing.JButton beginShiftButton;
    private javax.swing.JButton endBreakButton;
    private javax.swing.JButton endShiftButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logOutButton;
    private javax.swing.JLabel showTime;
    // End of variables declaration                   
}
