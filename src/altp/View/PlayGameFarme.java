/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.View;

import altp.DAO.CauHoiDAO;
import altp.HibernateHelper.ShareHelper;
import entity.CauHoi;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import altp.view.*;
import jaco.mp3.player.MP3Player;
import java.awt.Color;

/**
 *
 * @author ADMIN
 */
public class PlayGameFarme extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame1ư
     */
    String[] questionImages = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "00"};
    String[] questionImages1 = {"05", "10", "15", "00"};
    MP3Player mp3SanSang = ShareHelper.musicPlayer("Audio/sanSang.mp3");

    int count = 0;
    int count1 = 0;
    int maCauHoi = 1;
    List<CauHoi> list = null;
    String dapAn = null;
    String dung = null;

    public PlayGameFarme(String i) {
        initComponents();
        setSize(1180, 700);
        setLocationRelativeTo(null);
        showMark();
        showTableQuestion(i);
        lblQuestion.setBackground(new Color(0, 0, 0, 64));
    }

    void playShowMoney() {
        lblMarkPlay.setIcon(new ImageIcon(getClass().getResource("/hinh/" + (maCauHoi - 1) + ".png")));

    }

    public void showTableQuestion(String i) {
        if (i == "1") {
            lblBackground.setIcon(new ImageIcon(getClass().getResource("/image/background.jpg")));
            lblBackgroundPlay.setIcon(new ImageIcon(getClass().getResource("/image/background.jpg")));
        }
        if (i == "2") {
            lblBackground.setIcon(new ImageIcon(getClass().getResource("/image/background2.jpg")));
            lblBackgroundPlay.setIcon(new ImageIcon(getClass().getResource("/image/background2.jpg")));
        }
        if (i == "3") {
            lblBackground.setIcon(new ImageIcon(getClass().getResource("/image/background3.jpg")));
            lblBackgroundPlay.setIcon(new ImageIcon(getClass().getResource("/image/background3.jpg")));
        }
    }

    public void showMark() {
        btn50.setVisible(false);
        btnCall.setVisible(false);
        btnGround.setVisible(false);
        Thread t1 = new Thread() {
            @Override
            public void run() {
                ImageIcon[] iconList = new ImageIcon[17];
                for (int i = 0; i < iconList.length; i++) {
                    iconList[i] = new ImageIcon(getClass().getResource("/image/" + questionImages[i] + ".png"));
                    if (count < questionImages.length) {
                        try {
                            lblMark.setIcon(iconList[count]);
                            count++;
                            Thread.sleep(300);
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
                ImageIcon[] iconList1 = new ImageIcon[4];
                for (int i = 0; i < questionImages1.length; i++) {
                    iconList1[i] = new ImageIcon(getClass().getResource("/image/" + questionImages1[i] + ".png"));
                    if (count1 < questionImages1.length) {
                        try {
                            lblMark.setIcon(iconList1[count1]);
                            count1++;
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
                try {
                    btn50.setVisible(true);
                    Thread.sleep(1000);
                    btnCall.setVisible(true);
                    Thread.sleep(1000);
                    btnGround.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        t1.start();
    }

    void playTime() {
        Thread time = new Thread() {
            @Override
            public void run() {
                int count = 30;
                for (int i = count; i >= 0; i--) {
                    try {
                        lblTime.setText(i + "");
                        Thread.sleep(1000);
                        if (dapAn != null) {
                            i = 0;
                        }
                        if (i == 0 && dapAn == null) {
                            JOptionPane.showMessageDialog(null, "Ban da het gio");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        time.start();
    }

    void showQuesion(int maCauHoi) {
        list = CauHoiDAO.layCauHoi(maCauHoi);
        for (CauHoi ch : list) {
            lblQuestion.setText(ch.getTenCauHoi().toString());
            lblA.setText(ch.getA().toString());
            lblB.setText(ch.getB().toString());
            lblC.setText(ch.getC().toString());
            lblD.setText(ch.getD().toString());
        }
       
    }

    void playGame(int macauhoi) {
        Thread play = new Thread() {
            @Override
            public void run() {
                try {
                    dapAn = null;
                    Thread.sleep(3000);
                    playTime();
                    showQuesion(macauhoi);

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        play.start();
    }

    void Adung(ImageIcon[] DAdung) {
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 50; i++) {
                    try {
                        if (i % 2 == 0) {
                            lblImagesAnswerA.setIcon(DAdung[0]);
                            Thread.sleep(100);
                        } else {
                            lblImagesAnswerA.setIcon(DAdung[1]);
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

        };
        t2.start();
    }

    void Bdung(ImageIcon[] DAdung) {
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 50; i++) {
                    try {
                        if (i % 2 == 0) {
                            lblImagesAnswerB.setIcon(DAdung[0]);
                            Thread.sleep(100);
                        } else {
                            lblImagesAnswerB.setIcon(DAdung[1]);
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

        };
        t2.start();
    }

    void Cdung(ImageIcon[] DAdung) {
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 50; i++) {
                    try {
                        if (i % 2 == 0) {
                            lblImagesAnswerC.setIcon(DAdung[0]);
                            Thread.sleep(100);
                        } else {
                            lblImagesAnswerC.setIcon(DAdung[1]);
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

        };
        t2.start();
    }

    void Ddung(ImageIcon[] DAdung) {
        Thread t2 = new Thread() {
            @Override
            public void run() {
                for (int i = 1; i < 50; i++) {
                    try {
                        if (i % 2 == 0) {
                            lblImagesAnswerD.setIcon(DAdung[0]);
                            Thread.sleep(100);
                        } else {
                            lblImagesAnswerD.setIcon(DAdung[1]);
                            Thread.sleep(100);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }

        };
        t2.start();
    }

    void nhaynhay(String DA) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                ImageIcon[] DAdung = new ImageIcon[2];
                DAdung[0] = new ImageIcon(getClass().getResource("/hinh/" + DA + ".png"));
                DAdung[1] = new ImageIcon(getClass().getResource("/hinh/" + DA + "dung.png"));
                if (DA == "A") {
                    Adung(DAdung);
                } else if (DA == "B") {
                    Bdung(DAdung);
                } else if (DA == "C") {
                    Cdung(DAdung);
                } else if (DA == "D") {
                    Ddung(DAdung);
                }

            }
        };
        t1.start();
    }

    void check() {
        CauHoi ch = list.get(0);

        Thread check = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    nhaynhay(dapAn);
                    System.out.println(ch.getDapAnDung());
                    if (ch.getDapAnDung().equals(dapAn)) {
                        JOptionPane.showMessageDialog(null, "dung" + ch.getDapAnDung());
                        maCauHoi++;
                        playGame(maCauHoi);
                        playShowMoney();
                    } else {
                        JOptionPane.showMessageDialog(null, "sai" + ch.getDapAnDung());
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        };
        check.start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        btn50 = new javax.swing.JLabel();
        btnCall = new javax.swing.JLabel();
        btnGround = new javax.swing.JLabel();
        lblMark = new javax.swing.JLabel();
        lblPlay = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        pnlPlay = new javax.swing.JPanel();
        btn50Play = new javax.swing.JLabel();
        btnCallPlay = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JTextArea();
        btnGroundPlay = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        lblMarkPlay = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        lblB = new javax.swing.JLabel();
        lblC = new javax.swing.JLabel();
        lblD = new javax.swing.JLabel();
        lblImageQuestion = new javax.swing.JLabel();
        lblImagesAnswerA = new javax.swing.JLabel();
        lblImagesAnswerB = new javax.swing.JLabel();
        lblImagesAnswerC = new javax.swing.JLabel();
        lblImagesAnswerD = new javax.swing.JLabel();
        lblBackgroundPlay = new javax.swing.JLabel();

        jButton7.setText("C");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.CardLayout());

        pnlHome.setLayout(null);

        btn50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/5050.png"))); // NOI18N
        pnlHome.add(btn50);
        btn50.setBounds(1020, 230, 60, 60);

        btnCall.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/call.png"))); // NOI18N
        pnlHome.add(btnCall);
        btnCall.setBounds(1020, 330, 60, 60);

        btnGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/question.png"))); // NOI18N
        pnlHome.add(btnGround);
        btnGround.setBounds(1020, 430, 60, 70);

        lblMark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/00.png"))); // NOI18N
        pnlHome.add(lblMark);
        lblMark.setBounds(30, 60, 270, 530);

        lblPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sansang.png"))); // NOI18N
        lblPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPlayMouseClicked(evt);
            }
        });
        pnlHome.add(lblPlay);
        lblPlay.setBounds(440, 490, 288, 71);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        pnlHome.add(lblBackground);
        lblBackground.setBounds(0, 0, 1180, 700);

        jPanel1.add(pnlHome, "card3");

        pnlPlay.setLayout(null);

        btn50Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/5050.png"))); // NOI18N
        btn50Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn50PlayMouseClicked(evt);
            }
        });
        pnlPlay.add(btn50Play);
        btn50Play.setBounds(960, 230, 60, 60);

        btnCallPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/call.png"))); // NOI18N
        pnlPlay.add(btnCallPlay);
        btnCallPlay.setBounds(960, 330, 60, 60);

        lblQuestion.setEditable(false);
        lblQuestion.setBackground(new java.awt.Color(0, 0, 255));
        lblQuestion.setColumns(20);
        lblQuestion.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblQuestion.setForeground(new java.awt.Color(255, 255, 255));
        lblQuestion.setLineWrap(true);
        lblQuestion.setRows(5);
        pnlPlay.add(lblQuestion);
        lblQuestion.setBounds(380, 310, 340, 80);

        btnGroundPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/question.png"))); // NOI18N
        pnlPlay.add(btnGroundPlay);
        btnGroundPlay.setBounds(960, 430, 60, 70);

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        pnlPlay.add(lblTime);
        lblTime.setBounds(750, 370, 50, 30);

        lblMarkPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/00.png"))); // NOI18N
        pnlPlay.add(lblMarkPlay);
        lblMarkPlay.setBounds(30, 50, 270, 550);

        lblA.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblA.setForeground(new java.awt.Color(255, 204, 51));
        lblA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAMouseClicked(evt);
            }
        });
        pnlPlay.add(lblA);
        lblA.setBounds(370, 470, 160, 30);

        lblB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblB.setForeground(new java.awt.Color(255, 204, 0));
        lblB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBMouseClicked(evt);
            }
        });
        pnlPlay.add(lblB);
        lblB.setBounds(650, 470, 160, 30);

        lblC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblC.setForeground(new java.awt.Color(255, 204, 0));
        lblC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCMouseClicked(evt);
            }
        });
        pnlPlay.add(lblC);
        lblC.setBounds(370, 560, 160, 30);

        lblD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblD.setForeground(new java.awt.Color(255, 204, 0));
        lblD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDMouseClicked(evt);
            }
        });
        pnlPlay.add(lblD);
        lblD.setBounds(650, 560, 160, 30);

        lblImageQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/cauhoi.png"))); // NOI18N
        lblImageQuestion.setText("addddddddddđ");
        pnlPlay.add(lblImageQuestion);
        lblImageQuestion.setBounds(360, 280, 450, 140);

        lblImagesAnswerA.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dapanA.png"))); // NOI18N
        lblImagesAnswerA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagesAnswerAMouseClicked(evt);
            }
        });
        pnlPlay.add(lblImagesAnswerA);
        lblImagesAnswerA.setBounds(330, 460, 220, 50);

        lblImagesAnswerB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dapanB.png"))); // NOI18N
        lblImagesAnswerB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagesAnswerBMouseClicked(evt);
            }
        });
        pnlPlay.add(lblImagesAnswerB);
        lblImagesAnswerB.setBounds(610, 460, 220, 50);

        lblImagesAnswerC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dapanC.png"))); // NOI18N
        lblImagesAnswerC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagesAnswerCMouseClicked(evt);
            }
        });
        pnlPlay.add(lblImagesAnswerC);
        lblImagesAnswerC.setBounds(330, 550, 220, 50);

        lblImagesAnswerD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dapanD.png"))); // NOI18N
        lblImagesAnswerD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImagesAnswerDMouseClicked(evt);
            }
        });
        pnlPlay.add(lblImagesAnswerD);
        lblImagesAnswerD.setBounds(610, 540, 230, 60);

        lblBackgroundPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        lblBackgroundPlay.setText("fa");
        pnlPlay.add(lblBackgroundPlay);
        lblBackgroundPlay.setBounds(0, 0, 1180, 700);

        jPanel1.add(pnlPlay, "card2");

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void lblPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlayMouseClicked
        // TODO add your handling code here:

        MainFarme farme = new MainFarme();
        farme.mp3CauHoi.stop();
        mp3SanSang.play();
        farme.mp3Main.stop();
        pnlHome.setVisible(false);
        pnlPlay.setVisible(true);
        playGame(maCauHoi);
    }//GEN-LAST:event_lblPlayMouseClicked

    private void lblImagesAnswerAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagesAnswerAMouseClicked
        // TODO add your handling code here:
        dapAn = "A";
         CauHoi ch = list.get(0);
        dung = ch.getDapAnDung();
        lblImagesAnswerA.setIcon(new ImageIcon(getClass().getResource("/hinh/A.png")));
        check();
    }//GEN-LAST:event_lblImagesAnswerAMouseClicked

    private void lblAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAMouseClicked
        // TODO add your handling code here:
        dapAn = "A";
         CauHoi ch = list.get(0);
        dung = ch.getDapAnDung();
        lblImagesAnswerA.setIcon(new ImageIcon(getClass().getResource("/hinh/A.png")));
        check();
    }//GEN-LAST:event_lblAMouseClicked

    private void lblImagesAnswerBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagesAnswerBMouseClicked
        // TODO add your handling code here:
        dapAn = "B";
         CauHoi ch = list.get(0);
        dung = ch.getDapAnDung();
        lblImagesAnswerB.setIcon(new ImageIcon(getClass().getResource("/hinh/B.png")));
        check();
    }//GEN-LAST:event_lblImagesAnswerBMouseClicked

    private void lblBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBMouseClicked
        // TODO add your handling code here:
        dapAn = "B";
         CauHoi ch = list.get(0);
        dung = ch.getDapAnDung();
        lblImagesAnswerB.setIcon(new ImageIcon(getClass().getResource("/hinh/B.png")));
        check();
    }//GEN-LAST:event_lblBMouseClicked

    private void lblImagesAnswerCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagesAnswerCMouseClicked
        // TODO add your handling code here:
        dapAn = "C";
         CauHoi ch = list.get(0);
        dung = ch.getDapAnDung();
        lblImagesAnswerC.setIcon(new ImageIcon(getClass().getResource("/hinh/C.png")));
        check();
    }//GEN-LAST:event_lblImagesAnswerCMouseClicked

    private void lblCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCMouseClicked
        // TODO add your handling code here:
        dapAn = "C";
         CauHoi ch = list.get(0);
        dung = ch.getDapAnDung();
        lblImagesAnswerC.setIcon(new ImageIcon(getClass().getResource("/hinh/C.png")));
        check();
    }//GEN-LAST:event_lblCMouseClicked

    private void lblImagesAnswerDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagesAnswerDMouseClicked
        // TODO add your handling code here:
        dapAn = "D";
         CauHoi ch = list.get(0);
        dung = ch.getDapAnDung();
        lblImagesAnswerD.setIcon(new ImageIcon(getClass().getResource("/hinh/D.png")));
        check();
    }//GEN-LAST:event_lblImagesAnswerDMouseClicked

    private void lblDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDMouseClicked
        // TODO add your handling code here:
        dapAn = "D";
         CauHoi ch = list.get(0);
        dung = ch.getDapAnDung();
        lblImagesAnswerD.setIcon(new ImageIcon(getClass().getResource("/hinh/D.png")));
        check();
    }//GEN-LAST:event_lblDMouseClicked

    private void btn50PlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn50PlayMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btn50PlayMouseClicked

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PlayGameFarme.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PlayGameFarme.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PlayGameFarme.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PlayGameFarme.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PlayGameFarme().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btn50;
    private javax.swing.JLabel btn50Play;
    private javax.swing.JLabel btnCall;
    private javax.swing.JLabel btnCallPlay;
    private javax.swing.JLabel btnGround;
    private javax.swing.JLabel btnGroundPlay;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBackgroundPlay;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblImageQuestion;
    private javax.swing.JLabel lblImagesAnswerA;
    private javax.swing.JLabel lblImagesAnswerB;
    private javax.swing.JLabel lblImagesAnswerC;
    private javax.swing.JLabel lblImagesAnswerD;
    private javax.swing.JLabel lblMark;
    private javax.swing.JLabel lblMarkPlay;
    private javax.swing.JLabel lblPlay;
    private javax.swing.JTextArea lblQuestion;
    private javax.swing.JLabel lblTime;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlPlay;
    // End of variables declaration//GEN-END:variables
}
