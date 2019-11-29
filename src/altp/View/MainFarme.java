/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.View;

import altp.HibernateHelper.ShareHelper;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import altp.view.*;
import jaco.mp3.player.MP3Player;
import java.io.File;

/**
 *
 * @author ADMIN
 */
public class MainFarme extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1ư
     */
    String i = "0";
    MP3Player mp3Main = ShareHelper.musicPlayer("Audio/audioMain.wav");
    MP3Player mp3CauHoi = ShareHelper.musicPlayer("Audio/mocCauHoi.mp3");
     
    public MainFarme() {
        initComponents();
        setSize(1180, 700);
        setLocationRelativeTo(null);
        pnlMain.setVisible(true);
        pnlBXH.setVisible(false);
        mp3Main.play();
    }

    public void setting() {
        pnlMain.setVisible(false);
        pnlSetting.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is alway^s
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlHome = new javax.swing.JPanel();
        pnlMain = new javax.swing.JPanel();
        lblOption = new javax.swing.JLabel();
        lblBXH = new javax.swing.JLabel();
        lblHightMoney = new javax.swing.JLabel();
        lblHightSentences = new javax.swing.JLabel();
        lbltotalSentences = new javax.swing.JLabel();
        lblPlay = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        lblBackgroundMain = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        txtPassWord = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        btnAccount = new javax.swing.JButton();
        btnLoginMain = new javax.swing.JButton();
        lblBackgroundLogin = new javax.swing.JLabel();
        pnlAccount = new javax.swing.JPanel();
        txtPassAccount = new javax.swing.JTextField();
        txtUserAccount = new javax.swing.JTextField();
        btnAccount1 = new javax.swing.JButton();
        btnLoginAcount = new javax.swing.JButton();
        lblBackgroundAccount = new javax.swing.JLabel();
        pnlBXH = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGridView = new javax.swing.JTable();
        pnlSetting = new javax.swing.JPanel();
        lblIconBackground3 = new javax.swing.JLabel();
        IconBackground2 = new javax.swing.JLabel();
        lblIconBackground1 = new javax.swing.JLabel();
        lblIconBackground2 = new javax.swing.JLabel();
        IconBackground1 = new javax.swing.JLabel();
        IconBackground3 = new javax.swing.JLabel();
        lblBack = new javax.swing.JLabel();
        lblBackgroundMain1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlHome.setLayout(new java.awt.CardLayout());

        pnlMain.setLayout(null);

        lblOption.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/option.png"))); // NOI18N
        lblOption.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOptionMouseClicked(evt);
            }
        });
        pnlMain.add(lblOption);
        lblOption.setBounds(1080, 590, 60, 60);

        lblBXH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bxh.png"))); // NOI18N
        lblBXH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBXHMouseClicked(evt);
            }
        });
        pnlMain.add(lblBXH);
        lblBXH.setBounds(50, 540, 117, 94);

        lblHightMoney.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHightMoney.setForeground(new java.awt.Color(255, 255, 255));
        lblHightMoney.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tongtien.png"))); // NOI18N
        lblHightMoney.setText("Tổng số tiền");
        pnlMain.add(lblHightMoney);
        lblHightMoney.setBounds(660, 30, 140, 36);

        lblHightSentences.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblHightSentences.setForeground(new java.awt.Color(255, 255, 255));
        lblHightSentences.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/top.png"))); // NOI18N
        lblHightSentences.setText("Câu cao nhất");
        pnlMain.add(lblHightSentences);
        lblHightSentences.setBounds(820, 30, 150, 36);

        lbltotalSentences.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltotalSentences.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalSentences.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tongcau.png"))); // NOI18N
        lbltotalSentences.setText("Tổng số câu");
        pnlMain.add(lbltotalSentences);
        lbltotalSentences.setBounds(1000, 30, 140, 36);

        lblPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/play.png"))); // NOI18N
        lblPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPlayMouseClicked(evt);
            }
        });
        pnlMain.add(lblPlay);
        lblPlay.setBounds(390, 530, 388, 99);

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/login.jpg"))); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlMain.add(btnLogin);
        btnLogin.setBounds(40, 30, 80, 40);

        lblBackgroundMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        pnlMain.add(lblBackgroundMain);
        lblBackgroundMain.setBounds(0, 0, 1180, 700);

        pnlHome.add(pnlMain, "card2");

        pnlLogin.setLayout(null);

        txtPassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassWordActionPerformed(evt);
            }
        });
        pnlLogin.add(txtPassWord);
        txtPassWord.setBounds(320, 480, 370, 40);
        pnlLogin.add(txtUser);
        txtUser.setBounds(320, 400, 370, 40);

        btnAccount.setText("Đăng ký");
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });
        pnlLogin.add(btnAccount);
        btnAccount.setBounds(500, 540, 130, 50);

        btnLoginMain.setText("Đăng nhập");
        pnlLogin.add(btnLoginMain);
        btnLoginMain.setBounds(330, 540, 130, 50);

        lblBackgroundLogin.setBackground(new java.awt.Color(255, 255, 255));
        lblBackgroundLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dangnhap.png"))); // NOI18N
        pnlLogin.add(lblBackgroundLogin);
        lblBackgroundLogin.setBounds(-570, 0, 1750, 700);

        pnlHome.add(pnlLogin, "card4");

        pnlAccount.setLayout(null);
        pnlAccount.add(txtPassAccount);
        txtPassAccount.setBounds(290, 470, 370, 40);
        pnlAccount.add(txtUserAccount);
        txtUserAccount.setBounds(290, 400, 370, 40);

        btnAccount1.setText("Đăng ký");
        btnAccount1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccount1ActionPerformed(evt);
            }
        });
        pnlAccount.add(btnAccount1);
        btnAccount1.setBounds(460, 550, 130, 50);

        btnLoginAcount.setText("Đăng nhập");
        btnLoginAcount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginAcountActionPerformed(evt);
            }
        });
        pnlAccount.add(btnLoginAcount);
        btnLoginAcount.setBounds(300, 550, 130, 50);

        lblBackgroundAccount.setBackground(new java.awt.Color(255, 255, 255));
        lblBackgroundAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dangky.png"))); // NOI18N
        pnlAccount.add(lblBackgroundAccount);
        lblBackgroundAccount.setBounds(-590, 0, 1770, 700);

        pnlHome.add(pnlAccount, "card4");

        pnlBXH.setLayout(new java.awt.BorderLayout());

        tblGridView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Top Đại Gia", "Top Kỉ Lục Gia", "Top Tri Thức Gia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblGridView);

        pnlBXH.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlHome.add(pnlBXH, "card3");

        pnlSetting.setLayout(null);

        lblIconBackground3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIconBackground3.setForeground(new java.awt.Color(255, 255, 255));
        lblIconBackground3.setText("Đổi Nền 3");
        pnlSetting.add(lblIconBackground3);
        lblIconBackground3.setBounds(70, 360, 70, 30);

        IconBackground2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconBackground2.png"))); // NOI18N
        IconBackground2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconBackground2MouseClicked(evt);
            }
        });
        pnlSetting.add(IconBackground2);
        IconBackground2.setBounds(190, 220, 150, 80);

        lblIconBackground1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIconBackground1.setForeground(new java.awt.Color(255, 255, 255));
        lblIconBackground1.setText("Đổi Nền 1");
        pnlSetting.add(lblIconBackground1);
        lblIconBackground1.setBounds(60, 120, 80, 30);

        lblIconBackground2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIconBackground2.setForeground(new java.awt.Color(255, 255, 255));
        lblIconBackground2.setText("Đổi Nền 2");
        pnlSetting.add(lblIconBackground2);
        lblIconBackground2.setBounds(60, 240, 70, 30);

        IconBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconBackground1.png"))); // NOI18N
        IconBackground1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconBackground1MouseClicked(evt);
            }
        });
        pnlSetting.add(IconBackground1);
        IconBackground1.setBounds(190, 100, 150, 80);

        IconBackground3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconBackground3.png"))); // NOI18N
        IconBackground3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IconBackground3MouseClicked(evt);
            }
        });
        pnlSetting.add(IconBackground3);
        IconBackground3.setBounds(190, 340, 150, 80);

        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconBack.png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });
        pnlSetting.add(lblBack);
        lblBack.setBounds(40, 570, 70, 70);

        lblBackgroundMain1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        pnlSetting.add(lblBackgroundMain1);
        lblBackgroundMain1.setBounds(0, 0, 1400, 700);

        pnlHome.add(pnlSetting, "card6");

        getContentPane().add(pnlHome, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlayMouseClicked
        // TODO add your handling code here:
        mp3Main.stop();
        mp3CauHoi.play();
        new PlayGameFarme(i).setVisible(true);
    }//GEN-LAST:event_lblPlayMouseClicked

    private void lblBXHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBXHMouseClicked
        // TODO add your handling code here:
        pnlMain.setVisible(false);
        pnlBXH.setVisible(true);
    }//GEN-LAST:event_lblBXHMouseClicked

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        pnlMain.setVisible(false);
        pnlLogin.setVisible(true);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        // TODO add your handling code here:
        pnlLogin.setVisible(false);
        pnlAccount.setVisible(true);
    }//GEN-LAST:event_btnAccountActionPerformed

    private void lblOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionMouseClicked
        // TODO add your handling code here:
        setting();
    }//GEN-LAST:event_lblOptionMouseClicked

    private void txtPassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassWordActionPerformed

    private void btnAccount1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccount1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAccount1ActionPerformed

    private void IconBackground1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconBackground1MouseClicked
        // TODO add your handling code here:
        lblBackgroundMain.setIcon(new ImageIcon(getClass().getResource("/image/background.jpg")));
        lblBackgroundMain1.setIcon(new ImageIcon(getClass().getResource("/image/background.jpg")));
        i = "1";
    }//GEN-LAST:event_IconBackground1MouseClicked

    private void IconBackground2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconBackground2MouseClicked
        // TODO add your handling code here:
        lblBackgroundMain.setIcon(new ImageIcon(getClass().getResource("/image/background2.jpg")));
        lblBackgroundMain1.setIcon(new ImageIcon(getClass().getResource("/image/background2.jpg")));
        i = "2";
    }//GEN-LAST:event_IconBackground2MouseClicked

    private void IconBackground3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IconBackground3MouseClicked
        // TODO add your handling code here:
        lblBackgroundMain.setIcon(new ImageIcon(getClass().getResource("/image/background3.jpg")));
        lblBackgroundMain1.setIcon(new ImageIcon(getClass().getResource("/image/background3.jpg")));
        i = "3";
    }//GEN-LAST:event_IconBackground3MouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        // TODO add your handling code here:
        pnlSetting.setVisible(false);
    }//GEN-LAST:event_lblBackMouseClicked

    private void btnLoginAcountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginAcountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLoginAcountActionPerformed

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
            java.util.logging.Logger.getLogger(MainFarme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFarme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFarme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFarme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFarme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IconBackground1;
    private javax.swing.JLabel IconBackground2;
    private javax.swing.JLabel IconBackground3;
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnAccount1;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLoginAcount;
    private javax.swing.JButton btnLoginMain;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBXH;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblBackgroundAccount;
    private javax.swing.JLabel lblBackgroundLogin;
    private javax.swing.JLabel lblBackgroundMain;
    private javax.swing.JLabel lblBackgroundMain1;
    private javax.swing.JLabel lblHightMoney;
    private javax.swing.JLabel lblHightSentences;
    private javax.swing.JLabel lblIconBackground1;
    private javax.swing.JLabel lblIconBackground2;
    private javax.swing.JLabel lblIconBackground3;
    private javax.swing.JLabel lblOption;
    private javax.swing.JLabel lblPlay;
    private javax.swing.JLabel lbltotalSentences;
    private javax.swing.JPanel pnlAccount;
    private javax.swing.JPanel pnlBXH;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSetting;
    private javax.swing.JTable tblGridView;
    private javax.swing.JTextField txtPassAccount;
    private javax.swing.JTextField txtPassWord;
    private javax.swing.JTextField txtUser;
    private javax.swing.JTextField txtUserAccount;
    // End of variables declaration//GEN-END:variables
}
