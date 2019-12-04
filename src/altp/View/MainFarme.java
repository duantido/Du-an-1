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
    MP3Player mp3CauHoi = ShareHelper.musicPlayer("Audio/mocCauHoi.wav");

    public MainFarme() {
        initComponents();
        setSize(1180, 700);
        setLocationRelativeTo(null);
        setVisibleMain();
        mp3Main.play();
    }

    public void setting() {
        pnlMain.setVisible(false);
        pnlSetting.setVisible(true);
    }

    void setVisibleMain() {
        pnlMain.setVisible(true);
        pnlBxh.setVisible(false);
        pnlLogin.setVisible(false);
        pnlAccount.setVisible(false);
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
        pnlLogin = new javax.swing.JPanel();
        txtUserLogin = new javax.swing.JTextField();
        lblLoginUser = new javax.swing.JLabel();
        lblLoginPassword = new javax.swing.JLabel();
        txtPasswordLogin = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnLoginAccout = new javax.swing.JButton();
        lblBackLogin = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblBackgroundLoginn = new javax.swing.JLabel();
        pnlAccount = new javax.swing.JPanel();
        lblTitleDangKi = new javax.swing.JLabel();
        lblBackDangKi = new javax.swing.JLabel();
        btnAccout = new javax.swing.JButton();
        txtPassLogin = new javax.swing.JTextField();
        lblAccoutPassword = new javax.swing.JLabel();
        lblLoginAccout = new javax.swing.JLabel();
        txtPasswordAccount = new javax.swing.JPasswordField();
        lblBackgroundAccout = new javax.swing.JLabel();
        pnlBxh = new javax.swing.JPanel();
        lblDongBXH = new javax.swing.JLabel();
        lblBxh1 = new javax.swing.JLabel();
        lblBXH = new javax.swing.JLabel();
        lblHightMoney = new javax.swing.JLabel();
        lblHightSentences = new javax.swing.JLabel();
        lbltotalSentences = new javax.swing.JLabel();
        lblPlay = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblBackgroundMain = new javax.swing.JLabel();
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
        setTitle("AI LÀ TRIỆU PHÚ ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

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

        pnlLogin.setBackground(new java.awt.Color(0, 0, 0,0));
        pnlLogin.setPreferredSize(new java.awt.Dimension(500, 500));
        pnlLogin.setLayout(null);

        txtUserLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(txtUserLogin);
        txtUserLogin.setBounds(220, 180, 310, 40);

        lblLoginUser.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoginUser.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginUser.setText("Tài khoản");
        pnlLogin.add(lblLoginUser);
        lblLoginUser.setBounds(100, 180, 100, 40);

        lblLoginPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoginPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginPassword.setText("Mật khẩu");
        pnlLogin.add(lblLoginPassword);
        lblLoginPassword.setBounds(100, 250, 100, 30);
        pnlLogin.add(txtPasswordLogin);
        txtPasswordLogin.setBounds(220, 250, 310, 40);

        btnLogin.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnLogin.setText("Đăng Nhập");
        pnlLogin.add(btnLogin);
        btnLogin.setBounds(240, 310, 130, 50);

        btnLoginAccout.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnLoginAccout.setText("Đăng kí");
        btnLoginAccout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginAccoutActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLoginAccout);
        btnLoginAccout.setBounds(390, 310, 110, 50);

        lblBackLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconBack.png"))); // NOI18N
        lblBackLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackLoginMouseClicked(evt);
            }
        });
        pnlLogin.add(lblBackLogin);
        lblBackLogin.setBounds(600, 420, 70, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logologin1.png"))); // NOI18N
        pnlLogin.add(jLabel2);
        jLabel2.setBounds(280, 110, 200, 50);

        lblBackgroundLoginn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginBoxBg.png"))); // NOI18N
        pnlLogin.add(lblBackgroundLoginn);
        lblBackgroundLoginn.setBounds(0, 0, 720, 500);

        pnlMain.add(pnlLogin);
        pnlLogin.setBounds(250, 110, 720, 500);

        pnlAccount.setBackground(new java.awt.Color(0,0,0,0));
        pnlAccount.setPreferredSize(new java.awt.Dimension(705, 507));
        pnlAccount.setLayout(null);

        lblTitleDangKi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logoDangki.png"))); // NOI18N
        pnlAccount.add(lblTitleDangKi);
        lblTitleDangKi.setBounds(280, 110, 200, 50);

        lblBackDangKi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconBack.png"))); // NOI18N
        lblBackDangKi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackDangKiMouseClicked(evt);
            }
        });
        pnlAccount.add(lblBackDangKi);
        lblBackDangKi.setBounds(600, 420, 70, 60);

        btnAccout.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        btnAccout.setText("Đăng kí");
        btnAccout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccoutActionPerformed(evt);
            }
        });
        pnlAccount.add(btnAccout);
        btnAccout.setBounds(310, 320, 120, 40);

        txtPassLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPassLoginActionPerformed(evt);
            }
        });
        pnlAccount.add(txtPassLogin);
        txtPassLogin.setBounds(220, 180, 310, 40);

        lblAccoutPassword.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblAccoutPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblAccoutPassword.setText("Mật khẩu");
        pnlAccount.add(lblAccoutPassword);
        lblAccoutPassword.setBounds(100, 250, 100, 30);

        lblLoginAccout.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblLoginAccout.setForeground(new java.awt.Color(255, 255, 255));
        lblLoginAccout.setText("Tài khoản");
        pnlAccount.add(lblLoginAccout);
        lblLoginAccout.setBounds(100, 180, 100, 40);
        pnlAccount.add(txtPasswordAccount);
        txtPasswordAccount.setBounds(220, 250, 310, 40);

        lblBackgroundAccout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginBoxBg.png"))); // NOI18N
        pnlAccount.add(lblBackgroundAccout);
        lblBackgroundAccout.setBounds(0, 0, 700, 500);

        pnlMain.add(pnlAccount);
        pnlAccount.setBounds(255, 110, 710, 500);

        pnlBxh.setLayout(null);

        lblDongBXH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDongBXHMouseClicked(evt);
            }
        });
        pnlBxh.add(lblDongBXH);
        lblDongBXH.setBounds(60, 550, 270, 40);

        lblBxh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bxh1.png"))); // NOI18N
        pnlBxh.add(lblBxh1);
        lblBxh1.setBounds(0, 0, 390, 600);

        pnlMain.add(pnlBxh);
        pnlBxh.setBounds(440, 70, 390, 600);

        lblBXH.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bxh.png"))); // NOI18N
        lblBXH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBXHMouseClicked(evt);
            }
        });
        pnlMain.add(lblBXH);
        lblBXH.setBounds(70, 550, 117, 94);

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
        lblHightSentences.setBounds(830, 30, 150, 36);

        lbltotalSentences.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltotalSentences.setForeground(new java.awt.Color(255, 255, 255));
        lbltotalSentences.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tongcau.png"))); // NOI18N
        lbltotalSentences.setText("Tổng số câu");
        pnlMain.add(lbltotalSentences);
        lbltotalSentences.setBounds(1000, 30, 140, 36);

        lblPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/play.png"))); // NOI18N
        lblPlay.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                lblPlayAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        lblPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPlayMouseClicked(evt);
            }
        });
        pnlMain.add(lblPlay);
        lblPlay.setBounds(390, 530, 388, 99);

        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logologin1.png"))); // NOI18N
        lblLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLoginMouseClicked(evt);
            }
        });
        pnlMain.add(lblLogin);
        lblLogin.setBounds(50, 40, 190, 60);

        lblBackgroundMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackgroundMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        pnlMain.add(lblBackgroundMain);
        lblBackgroundMain.setBounds(0, 0, 1180, 700);

        pnlHome.add(pnlMain, "card2");

        pnlSetting.setPreferredSize(new java.awt.Dimension(500, 500));
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
        new PlayGameFarme(i, mp3CauHoi).setVisible(true);
    }//GEN-LAST:event_lblPlayMouseClicked

    private void lblBXHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBXHMouseClicked
        // TODO add your handling code here:
        pnlBxh.setVisible(true);
        lblLogin.setVisible(false);
    }//GEN-LAST:event_lblBXHMouseClicked

    private void lblOptionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOptionMouseClicked
        // TODO add your handling code here:
        setting();
    }//GEN-LAST:event_lblOptionMouseClicked

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

    private void lblLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLoginMouseClicked
        // TODO add your handling code here:
        pnlLogin.setVisible(true);
        lblBXH.setVisible(false);
    }//GEN-LAST:event_lblLoginMouseClicked

    private void lblPlayAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_lblPlayAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_lblPlayAncestorAdded

    private void lblDongBXHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDongBXHMouseClicked
        // TODO add your handling code here:
        pnlBxh.setVisible(false);
        lblLogin.setVisible(true);
    }//GEN-LAST:event_lblDongBXHMouseClicked

    private void txtUserLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserLoginActionPerformed

    private void lblBackLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackLoginMouseClicked
        // TODO add your handling code here:
        pnlLogin.setVisible(false);
        lblBXH.setVisible(true);
    }//GEN-LAST:event_lblBackLoginMouseClicked

    private void lblBackDangKiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackDangKiMouseClicked
        // TODO add your handling code here:
        pnlAccount.setVisible(false);
        pnlLogin.setVisible(true);
    }//GEN-LAST:event_lblBackDangKiMouseClicked

    private void txtPassLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPassLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPassLoginActionPerformed

    private void btnAccoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccoutActionPerformed
        // TODO add your handling code here:
        pnlAccount.setVisible(false);
        pnlLogin.setVisible(true);
    }//GEN-LAST:event_btnAccoutActionPerformed

    private void btnLoginAccoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginAccoutActionPerformed
        // TODO add your handling code here:
        pnlAccount.setVisible(true);
        pnlLogin.setVisible(false);
    }//GEN-LAST:event_btnLoginAccoutActionPerformed

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
    private javax.swing.JButton btnAccout;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLoginAccout;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblAccoutPassword;
    private javax.swing.JLabel lblBXH;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblBackDangKi;
    private javax.swing.JLabel lblBackLogin;
    private javax.swing.JLabel lblBackgroundAccout;
    private javax.swing.JLabel lblBackgroundLoginn;
    private javax.swing.JLabel lblBackgroundMain;
    private javax.swing.JLabel lblBackgroundMain1;
    private javax.swing.JLabel lblBxh1;
    private javax.swing.JLabel lblDongBXH;
    private javax.swing.JLabel lblHightMoney;
    private javax.swing.JLabel lblHightSentences;
    private javax.swing.JLabel lblIconBackground1;
    private javax.swing.JLabel lblIconBackground2;
    private javax.swing.JLabel lblIconBackground3;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLoginAccout;
    private javax.swing.JLabel lblLoginPassword;
    private javax.swing.JLabel lblLoginUser;
    private javax.swing.JLabel lblOption;
    private javax.swing.JLabel lblPlay;
    private javax.swing.JLabel lblTitleDangKi;
    private javax.swing.JLabel lbltotalSentences;
    private javax.swing.JPanel pnlAccount;
    private javax.swing.JPanel pnlBxh;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSetting;
    private javax.swing.JTextField txtPassLogin;
    private javax.swing.JPasswordField txtPasswordAccount;
    private javax.swing.JPasswordField txtPasswordLogin;
    private javax.swing.JTextField txtUserLogin;
    // End of variables declaration//GEN-END:variables
}
