
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jmohi
 */
public class AdminLogin extends javax.swing.JFrame {

    /**
     * Creates new form AdminLogin
     */
    public AdminLogin() {
        initComponents();
    }

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
        adminUsername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        adminPassword = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        adminLoginButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(254, 191, 99));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin Login Page");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 0, 330, 110);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\jmohi\\Desktop\\mail.png")); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 180, 120);

        jPanel2.setBackground(new java.awt.Color(0, 106, 113));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 106, 113));
        jPanel3.setLayout(null);

        adminUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminUsernameActionPerformed(evt);
            }
        });
        jPanel3.add(adminUsername);
        adminUsername.setBounds(200, 10, 220, 40);

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

        adminPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminPasswordActionPerformed(evt);
            }
        });
        jPanel4.add(adminPassword);
        adminPassword.setBounds(200, 10, 220, 40);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(40, 120, 440, 60);

        jPanel5.setBackground(new java.awt.Color(0, 106, 113));
        jPanel5.setLayout(null);

        adminLoginButton.setText("LOGIN");
        adminLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLoginButtonActionPerformed(evt);
            }
        });
        jPanel5.add(adminLoginButton);
        adminLoginButton.setBounds(80, 0, 170, 50);

        jPanel2.add(jPanel5);
        jPanel5.setBounds(100, 240, 350, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 368, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void adminUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminUsernameActionPerformed

    private void adminPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminPasswordActionPerformed

    private void adminLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLoginButtonActionPerformed

        try {

            //<editor-fold defaultstate="collapsed" desc=" Database Connection ">
            Connection conn = dbConnection.connect();
            //</editor-fold>

            //<editor-fold defaultstate="collapsed" desc="Prepared Statement">
            // Prepared Statement of validation
            PreparedStatement stmt = conn.prepareStatement("select  * from registeradmin where id= ?  and password= ? and emp_type = ?");
            stmt.setLong(1, Long.parseLong(adminUsername.getText()));
            stmt.setString(2, adminPassword.getText());
            stmt.setString(3, "Admin");
            ResultSet rs = stmt.executeQuery();
            //</editor-fold>
            
            //<editor-fold defaultstate="collapsed" desc="Login">

            if (rs.next()) {
                //JOptionPane.showMessageDialog(null, "Login Successfull");
                new Admin().setVisible(true);
                this.setVisible(false);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Incorrect Credentials");
                adminUsername.setText("");
                adminPassword.setText("");
            }
//</editor-fold>
        } catch (HeadlessException | SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }


    }//GEN-LAST:event_adminLoginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AdminLogin().setVisible(false);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminLoginButton;
    javax.swing.JPasswordField adminPassword;
    protected static javax.swing.JTextField adminUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables
}
