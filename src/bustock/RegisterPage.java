/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bustock;

import bustock.manager.SQLManager;
import javax.swing.JOptionPane;

/**
 *
 * @author bz199
 */
public class RegisterPage extends javax.swing.JFrame {

    /**
     * Creates new form LoginPage
     */

    public RegisterPage() {
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
        jLayeredPane1 = new javax.swing.JLayeredPane();
        usernameInput = new javax.swing.JTextField();
        passwordInput = new javax.swing.JPasswordField();
        ConfrimInput = new javax.swing.JPasswordField();
        emailInput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        extEmail = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        extUser = new javax.swing.JLabel();
        btnConfirm = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        extPassword = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        extCpassword = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLayeredPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameInput.setBorder(null);
        jLayeredPane1.add(usernameInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 81, 234, 20));

        passwordInput.setBorder(null);
        jLayeredPane1.add(passwordInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 147, 234, 20));

        ConfrimInput.setBorder(null);
        jLayeredPane1.add(ConfrimInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 217, 234, 20));

        emailInput.setBorder(null);
        jLayeredPane1.add(emailInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 287, 234, 20));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(101, 99, 255));
        jLabel3.setText("Register");
        jLayeredPane1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, -10, -1, 40));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(157, 151, 255));
        jLabel1.setText("User *");
        jLayeredPane1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        extEmail.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        extEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bustock/Image/textf.png"))); // NOI18N
        extEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLayeredPane1.add(extEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, 55));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(157, 151, 255));
        jLabel2.setText("Email *");
        jLayeredPane1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        extUser.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        extUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bustock/Image/textf.png"))); // NOI18N
        extUser.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLayeredPane1.add(extUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        btnConfirm.setBackground(new java.awt.Color(252, 252, 252));
        btnConfirm.setForeground(new java.awt.Color(252, 252, 252));
        btnConfirm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bustock/Image/Confirm.png"))); // NOI18N
        btnConfirm.setToolTipText("");
        btnConfirm.setBorder(null);
        btnConfirm.setBorderPainted(false);
        btnConfirm.setDefaultCapable(false);
        btnConfirm.setFocusPainted(false);
        btnConfirm.setVerifyInputWhenFocusTarget(false);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });
        jLayeredPane1.add(btnConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 270, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(157, 151, 255));
        jLabel6.setText("Password *");
        jLayeredPane1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        extPassword.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        extPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bustock/Image/textf.png"))); // NOI18N
        extPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLayeredPane1.add(extPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, 55));

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(157, 151, 255));
        btnBack.setText("Back");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackMouseClicked(evt);
            }
        });
        jLayeredPane1.add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, -1));

        extCpassword.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        extCpassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bustock/Image/textf.png"))); // NOI18N
        extCpassword.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLayeredPane1.add(extCpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, 55));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(157, 151, 255));
        jLabel9.setText("Confirm Password *");
        jLayeredPane1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmActionPerformed
        String[] data = {
            usernameInput.getText(),
            String.valueOf(passwordInput.getPassword()),
            String.valueOf(ConfrimInput.getPassword()),
            emailInput.getText()
        };
        for (String s:data )
        {
            if (s.isEmpty())
            {
                JOptionPane.showMessageDialog(null, "Please fill data!", "Register", JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        if (data[1].equals(data[2]))
        {
            var Username = data[0];
            var Password = data[1];
            var Email = data[3];
            if (!SQLManager.usernameExist(Username))
            {
                if (!SQLManager.emailExist(Email))
                {
                    SQLManager.userRegister(Username, Password, Email);
                    backToLogin();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Email '" + Email + "' already in use!", "Register", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username '" + Username + "' already in use!", "Register", JOptionPane.ERROR_MESSAGE);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Password or confirm password not match!", "Register", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnConfirmActionPerformed

    private void btnBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseClicked
        backToLogin();
    }//GEN-LAST:event_btnBackMouseClicked
   
    private void backToLogin()
    {
        setVisible(false);
        java.awt.EventQueue.invokeLater(() -> 
        {
            new LoginPage().setVisible(true);
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfrimInput;
    private javax.swing.JLabel btnBack;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JTextField emailInput;
    private javax.swing.JLabel extCpassword;
    private javax.swing.JLabel extEmail;
    private javax.swing.JLabel extPassword;
    private javax.swing.JLabel extUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField passwordInput;
    private javax.swing.JTextField usernameInput;
    // End of variables declaration//GEN-END:variables
}