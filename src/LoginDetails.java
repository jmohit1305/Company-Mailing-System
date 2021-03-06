
import java.awt.HeadlessException;
import java.sql.*;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jmohi
 */
public class LoginDetails extends javax.swing.JFrame {

    /**
     * Creates new form LoginDetails
     */
    public LoginDetails() {
        initComponents();
    }

    public static String loggedInUserID;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        user = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pass = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        signin = new javax.swing.JButton();
        exitButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(254, 191, 99));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Login Page");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 0, 360, 110);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\jmohi\\Desktop\\mail.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 180, 120);

        jPanel2.setBackground(new java.awt.Color(0, 106, 113));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 106, 113));
        jPanel3.setLayout(null);

        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });
        jPanel3.add(user);
        user.setBounds(200, 10, 220, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Username");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(0, 0, 150, 60);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(40, 40, 440, 60);

        jPanel4.setBackground(new java.awt.Color(0, 106, 113));
        jPanel4.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Password");
        jLabel4.setMaximumSize(new java.awt.Dimension(108, 29));
        jLabel4.setMinimumSize(new java.awt.Dimension(108, 29));
        jLabel4.setPreferredSize(new java.awt.Dimension(108, 29));
        jPanel4.add(jLabel4);
        jLabel4.setBounds(0, 0, 150, 60);

        pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passActionPerformed(evt);
            }
        });
        jPanel4.add(pass);
        pass.setBounds(200, 10, 220, 40);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(40, 120, 440, 60);

        jPanel5.setBackground(new java.awt.Color(0, 106, 113));
        jPanel5.setLayout(null);

        signin.setText("Sign In");
        signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signinActionPerformed(evt);
            }
        });
        jPanel5.add(signin);
        signin.setBounds(20, 0, 150, 40);

        exitButton1.setText("Register");
        exitButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(exitButton1);
        exitButton1.setBounds(220, 0, 150, 40);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(70, 240, 390, 50);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 504, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userActionPerformed

    private void passActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passActionPerformed

    private void signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signinActionPerformed
        // TODO add your handling code here:
        try {

            //Establishing conn
            Connection conn = dbConnection.connect();

            PreparedStatement stmt;
            stmt = conn.prepareStatement("select  * from register where username= ?  and password= ? ");
            loggedInUserID = user.getText();
            stmt.setString(1, loggedInUserID);
            stmt.setString(2, pass.getText());

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Login Successfull");
                this.dispose();
                new mainFrame().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect Credentials");
                user.setText("");
                pass.setText("");
                user.grabFocus();
            }
            rs.close();

        } catch (HeadlessException | SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }//GEN-LAST:event_signinActionPerformed

    private void exitButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButton1ActionPerformed

        this.dispose();
        new AdminLogin().setVisible(true);

    }//GEN-LAST:event_exitButton1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new LoginDetails().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    javax.swing.JPasswordField pass;
    private javax.swing.JButton signin;
    protected static javax.swing.JTextField user;
    // End of variables declaration//GEN-END:variables
}
