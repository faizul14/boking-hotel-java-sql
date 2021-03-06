/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import datakamar.DataKamar;
import datatamu.DataTamu;
//import datatamu.DataTamu;
import javax.swing.JOptionPane;
import login.datalogin;
import login.login;
import login.logininterface;
import login.logininterfaceimpl;
import riwayat.Riwayat;
import user.UserForm;
import user.UserForm1;

/**
 *
 * @author HP
 */
public class Menu extends javax.swing.JFrame {
    
    private logininterface va = new logininterfaceimpl();

    /**
     * Creates new form Login
     */
    public Menu() {
//        initComponents();
        if (datalogin.session == false) {
//            this.dispose();
            new login().setVisible(true);
            return;
        } else {
            initComponents();
            admin.setText("User: " + datalogin.NAMA);
        }
        
    }
    
    public void logout() {
        int conf = JOptionPane.showConfirmDialog(rootPane, "Yakin untuk Logout?", "Logout?",
                JOptionPane.YES_NO_OPTION);
        if (conf == JOptionPane.YES_OPTION) {
            va.logout();
            this.dispose();
            new login().setVisible(true);
        }
        
    }

//    private void session() {
//        if (datalogin.session == false) {
//            this.dispose();
//            new login().setVisible(true);
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        admin = new javax.swing.JLabel();
        btnuser = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btntamu = new javax.swing.JButton();
        btndatakamar = new javax.swing.JButton();
        btnriwayat = new javax.swing.JButton();
        btnlogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(163, 149, 149));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        admin.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        admin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        admin.setText("User : ");

        btnuser.setBackground(new java.awt.Color(0, 102, 102));
        btnuser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnuser.setForeground(new java.awt.Color(255, 255, 255));
        btnuser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/User-Group-icon.png"))); // NOI18N
        btnuser.setText("USER");
        btnuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuserActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Admin-icon.png"))); // NOI18N

        btntamu.setBackground(new java.awt.Color(0, 102, 102));
        btntamu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntamu.setForeground(new java.awt.Color(255, 255, 255));
        btntamu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_profile_48px.png"))); // NOI18N
        btntamu.setText("DATA TAMU");
        btntamu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntamuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btntamu, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnuser, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addComponent(admin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(admin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addComponent(btnuser, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btntamu)
                .addContainerGap(114, Short.MAX_VALUE))
        );

        btndatakamar.setBackground(new java.awt.Color(0, 102, 102));
        btndatakamar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btndatakamar.setForeground(new java.awt.Color(255, 255, 255));
        btndatakamar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_room_48px.png"))); // NOI18N
        btndatakamar.setText("DATA KAMAR");
        btndatakamar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatakamarActionPerformed(evt);
            }
        });

        btnriwayat.setBackground(new java.awt.Color(0, 102, 102));
        btnriwayat.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnriwayat.setForeground(new java.awt.Color(255, 255, 255));
        btnriwayat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icon-note.png"))); // NOI18N
        btnriwayat.setText("RIWAYAT");
        btnriwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnriwayatActionPerformed(evt);
            }
        });

        btnlogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/user-logout.png"))); // NOI18N
        btnlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnriwayat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btndatakamar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(101, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btnlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(btndatakamar)
                .addGap(30, 30, 30)
                .addComponent(btnriwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlogoutActionPerformed
        logout();
    }//GEN-LAST:event_btnlogoutActionPerformed

    private void btnuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuserActionPerformed
        new UserForm1().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnuserActionPerformed

    private void btndatakamarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatakamarActionPerformed
        new DataKamar().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btndatakamarActionPerformed

    private void btntamuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntamuActionPerformed
        new DataTamu().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btntamuActionPerformed

    private void btnriwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnriwayatActionPerformed
        new Riwayat().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btnriwayatActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel admin;
    private javax.swing.JButton btndatakamar;
    private javax.swing.JButton btnlogout;
    private javax.swing.JButton btnriwayat;
    private javax.swing.JButton btntamu;
    private javax.swing.JButton btnuser;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
