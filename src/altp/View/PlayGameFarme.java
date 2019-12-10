/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.View;

import altp.DAO.CauHoiDAO;
import altp.DAO.TaiKhoanDAO;
import altp.HibernateHelper.RanDomHelper;
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
import entity.TaiKhoan;
import jaco.mp3.player.MP3Player;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;

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
    MP3Player mp35050 = ShareHelper.musicPlayer("Audio/music5050.mp3");
    int timeMax;
    int count = 0;
    int count1 = 0;
    int maCauHoi = 1;
    int monney = 0;
    String nameCall = null;
    List<CauHoi> list = null;
    CauHoi cauhoi;
    String dapAn = null;
    MP3Player mp3;
    MP3Player mp3Main;
    MP3Player mp3QuestionA = ShareHelper.musicPlayer("audio/dapAnA.mp3");
    MP3Player mp3QuestionB = ShareHelper.musicPlayer("audio/dapAnB.mp3");
    MP3Player mp3QuestionC = ShareHelper.musicPlayer("audio/dapAnC.mp3");
    MP3Player mp3QuestionD = ShareHelper.musicPlayer("audio/dapAnD.mp3");
    MP3Player mp3FillQuestion = ShareHelper.musicPlayer("audio/audioQuestion.mp3");
    MP3Player mp3HelpCall = ShareHelper.musicPlayer("audio/helpCall.mp3");
    boolean check5050 = true;
    boolean checkQuesion = true;
    boolean checkTuVan = true;
    boolean checkCall = true;
    MainFarme mainFarme;

    public PlayGameFarme(String i, MP3Player mp3, MP3Player mp3Main, MainFarme parent) {
        initComponents();
        setSize(1180, 700);
        setLocationRelativeTo(null);
        showMark();
        showTableQuestion(i);
        setVisible();
        mainFarme = parent;
        this.mp3 = mp3;
        this.mp3Main = mp3Main;
    }

    void setVisible() {
        pnlResult.setVisible(false);
        pnlTroGiupHoi.setVisible(false);
        pnlTroGiupTuVan.setVisible(false);
        lblConsultingTeam.setVisible(false);
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
                            timeMax = i;
                            i = 0;
                        }
                        if (i == 0 && dapAn == null) {
                            if (maCauHoi == 1) {
                                Monney();
                            }
                            pnlResult.setVisible(true);
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

    void setStatusFalse() {
        lblA.setVisible(false);
        lblB.setVisible(false);
        lblC.setVisible(false);
        lblD.setVisible(false);
        lblImagesAnswerA.setVisible(false);
        lblImagesAnswerB.setVisible(false);
        lblImagesAnswerC.setVisible(false);
        lblImagesAnswerD.setVisible(false);
    }

    void setStatusTrue() {
        lblA.setVisible(true);
        lblB.setVisible(true);
        lblC.setVisible(true);
        lblD.setVisible(true);
        lblImagesAnswerA.setVisible(true);
        lblImagesAnswerB.setVisible(true);
        lblImagesAnswerC.setVisible(true);
        lblImagesAnswerD.setVisible(true);
        lblA.setText("");
        lblB.setText("");
        lblC.setText("");
        lblD.setText("");
    }

    void showQuesion(int maCauHoi) {
        cauhoi = CauHoiDAO.layCauHoi(maCauHoi);
        Thread show = new Thread() {
            @Override
            public void run() {
                try {

                    setStatusTrue();
                    lblQuestion.setText(cauhoi.getTenCauHoi().toString());
                    Thread.sleep(2000);
                    lblA.setText(cauhoi.getA().toString());
                    Thread.sleep(500);
                    lblB.setText(cauhoi.getB().toString());
                    Thread.sleep(500);
                    lblC.setText(cauhoi.getC().toString());
                    Thread.sleep(500);
                    lblD.setText(cauhoi.getD().toString());
                    Thread.sleep(500);
                    playTime();
                    mp3FillQuestion.play();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        show.start();
    }

    void playGame(int macauhoi) {
        Thread play = new Thread() {
            @Override
            public void run() {
                try {
                    if (maCauHoi == 1) {
                        Thread.sleep(5000);
                    }
                    if(macauhoi == 6){
                        lblConsultingTeam.setVisible(true);
                    }
                    dapAn = null;
                    showQuesion(macauhoi);
                    if (check5050 == true) {
                        lbl5050Play.setIcon(new ImageIcon(getClass().getResource("/image/5050.png")));
                    } else {
                        lbl5050Play.setIcon(new ImageIcon(getClass().getResource("/image/5050chet.png")));
                    }
                    if (checkQuesion == true) {
                        lblQuesion.setIcon(new ImageIcon(getClass().getResource("/image/question.png")));
                    } else {
                        lblQuesion.setIcon(new ImageIcon(getClass().getResource("/image/questionchet.png")));
                    }
                    if (checkCall == true) {
                        lblCallPlay.setIcon(new ImageIcon(getClass().getResource("/image/call.png")));
                    } else {
                        lblCallPlay.setIcon(new ImageIcon(getClass().getResource("/image/callchet.png")));
                    }
                    if (checkTuVan == true) {
                        lblConsultingTeam.setIcon(new ImageIcon(getClass().getResource("/image/totuvan.png")));
                    } else {
                        lblConsultingTeam.setIcon(new ImageIcon(getClass().getResource("/image/totuvanchet.png")));
                    }

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        play.start();
    }

    void DADung(ImageIcon[] DADung) {
        Thread t2 = new Thread() {
            @Override
            public void run() {
                CauHoi ch = cauhoi;
                for (int i = 1; i < 14; i++) {
                    try {
                        if (ch.getDapAnDung().matches("A")) {
                            if (i % 2 == 0) {
                                lblImagesAnswerA.setIcon(DADung[0]);
                                Thread.sleep(100);
                            } else {
                                lblImagesAnswerA.setIcon(DADung[1]);
                                Thread.sleep(100);
                            }
                        }
                        if (ch.getDapAnDung().matches("B")) {
                            if (i % 2 == 0) {
                                lblImagesAnswerB.setIcon(DADung[0]);
                                Thread.sleep(100);
                            } else {
                                lblImagesAnswerB.setIcon(DADung[1]);
                                Thread.sleep(100);
                            }
                        }
                        if (ch.getDapAnDung().matches("C")) {
                            if (i % 2 == 0) {
                                lblImagesAnswerC.setIcon(DADung[0]);
                                Thread.sleep(100);
                            } else {
                                lblImagesAnswerC.setIcon(DADung[1]);
                                Thread.sleep(100);
                            }
                        }
                        if (ch.getDapAnDung().matches("D")) {
                            if (i % 2 == 0) {
                                lblImagesAnswerD.setIcon(DADung[0]);
                                Thread.sleep(100);
                            } else {
                                lblImagesAnswerD.setIcon(DADung[1]);
                                Thread.sleep(100);
                            }
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
        MP3Player mp3NextQuestion = ShareHelper.musicPlayer("Audio/audioCorrect.mp3");
        mp3NextQuestion.play();
        Thread t1 = new Thread() {
            @Override
            public void run() {
                ImageIcon[] DAdung = new ImageIcon[2];
                DAdung[0] = new ImageIcon(getClass().getResource("/hinh/" + DA + ".png"));
                DAdung[1] = new ImageIcon(getClass().getResource("/hinh/" + DA + "dung.png"));
                DADung(DAdung);
            }
        };
        t1.start();
    }

    void setBackgroungAswer() {
        lblImagesAnswerA.setIcon(new ImageIcon(getClass().getResource("/image/dapanA.png")));
        lblImagesAnswerB.setIcon(new ImageIcon(getClass().getResource("/image/dapanB.png")));
        lblImagesAnswerC.setIcon(new ImageIcon(getClass().getResource("/image/dapanC.png")));
        lblImagesAnswerD.setIcon(new ImageIcon(getClass().getResource("/image/dapanD.png")));
    }

    void Monney() {
        if (maCauHoi == 1) {
            monney = 0;
        }
        if (maCauHoi == 2) {
            monney = monney + 200;
        }
        if (maCauHoi == 3) {
            monney = monney + 200;
        }
        if (maCauHoi == 4) {
            monney = monney + 200;
        }
        if (maCauHoi == 5) {
            monney = monney + 400;
        }
        if (maCauHoi == 6) {
            monney = monney + 1000;
        }
        if (maCauHoi == 7) {
            monney = monney + 1000;
        }
        if (maCauHoi == 8) {
            monney = monney + 3000;
        }
        if (maCauHoi == 9) {
            monney = monney + 4000;
        }
        if (maCauHoi == 10) {
            monney = monney + 4000;
        }
        if (maCauHoi == 11) {
            monney = monney + 8000;
        }
        if (maCauHoi == 12) {
            monney = monney + 8000;
        }
        if (maCauHoi == 13) {
            monney = monney + 10000;
        }
        if (maCauHoi == 14) {
            monney = monney + 20000;
        }
        if (maCauHoi == 15) {
            monney = monney + 25000;
        }
        if (maCauHoi > 16) {
            monney = monney + 75000;
        }
        lblTien.setText("Tiền thưởng :" + monney);
        lblCauHoi.setText("Câu hỏi :" + (maCauHoi - 1));
    }

    void check() {
        CauHoi ch = cauhoi;
        Thread check = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    nhaynhay(ch.getDapAnDung());
                    Thread.sleep(3000);
                    if (ch.getDapAnDung().equals(dapAn)) {
                        maCauHoi++;
                        Monney();
                        setBackgroungAswer();
                        playGame(maCauHoi);
                        playShowMoney();
                    } else {
                        pnlResult.setVisible(true);
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        check.start();
    }

    void help5050() {
        Thread h50 = new Thread() {
            @Override
            public void run() {
                try {
                    mp35050.play();
                    Thread.sleep(2000);
                    CauHoi ch = cauhoi;
                    if (ch.getDapAnDung().equals("A")) {
                        int number = RanDomHelper.ranDomInt(3);
                        if (number == 0) {
                            lblC.setText("");
                            lblD.setText("");
                            lblImagesAnswerC.setVisible(false);
                            lblImagesAnswerD.setVisible(false);
                        }
                        if (number == 1) {
                            lblB.setText("");
                            lblD.setText("");
                            lblImagesAnswerB.setVisible(false);
                            lblImagesAnswerD.setVisible(false);
                        }
                        if (number == 2) {
                            lblB.setText("");
                            lblC.setText("");
                            lblImagesAnswerB.setVisible(false);
                            lblImagesAnswerC.setVisible(false);
                        }
                    }
                    if (ch.getDapAnDung().equals("B")) {
                        int number = RanDomHelper.ranDomInt(3);
                        if (number == 0) {
                            lblC.setText("");
                            lblD.setText("");
                            lblImagesAnswerD.setVisible(false);
                            lblImagesAnswerC.setVisible(false);
                        }
                        if (number == 1) {
                            lblA.setText("");
                            lblD.setText("");
                            lblImagesAnswerA.setVisible(false);
                            lblImagesAnswerD.setVisible(false);
                        }
                        if (number == 2) {
                            lblC.setText("");
                            lblA.setText("");
                            lblImagesAnswerA.setVisible(false);
                            lblImagesAnswerC.setVisible(false);
                        }
                    }
                    if (ch.getDapAnDung().equals("C")) {
                        int number = RanDomHelper.ranDomInt(3);
                        if (number == 0) {
                            lblB.setText("");
                            lblD.setText("");
                            lblImagesAnswerD.setVisible(false);
                            lblImagesAnswerB.setVisible(false);
                        }
                        if (number == 1) {
                            lblA.setText("");
                            lblD.setText("");
                            lblImagesAnswerA.setVisible(false);
                            lblImagesAnswerD.setVisible(false);
                        }
                        if (number == 2) {
                            lblA.setText("");
                            lblB.setText("");
                            lblImagesAnswerA.setVisible(false);
                            lblImagesAnswerB.setVisible(false);
                        }
                    }
                    if (ch.getDapAnDung().equals("D")) {
                        int number = RanDomHelper.ranDomInt(3);
                        if (number == 0) {
                            lblB.setText("");
                            lblC.setText("");
                            lblImagesAnswerB.setVisible(false);
                            lblImagesAnswerC.setVisible(false);
                        }
                        if (number == 1) {
                            lblA.setText("");
                            lblC.setText("");
                            lblImagesAnswerA.setVisible(false);
                            lblImagesAnswerC.setVisible(false);
                        }
                        if (number == 2) {
                            lblA.setText("");
                            lblB.setText("");
                            lblImagesAnswerA.setVisible(false);
                            lblImagesAnswerB.setVisible(false);
                        }
                    }
                } catch (Exception e) {

                }
            }

        };
        h50.start();
    }

    void helpQuesion() {
        MP3Player mp3HelpQuestion = ShareHelper.musicPlayer("Audio/ykienkhangia.mp3");
        mp3HelpQuestion.play();
        Thread help = new Thread() {
            @Override
            public void run() {
                try {
                    CauHoi ch = cauhoi;
                    if (ch.getDapAnDung().equals("A")) {
                        int number = 100;
                        int A = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= A; i++) {
                            pgA.setValue(i);
                            Thread.sleep(30);
                        }
                        number = 100 - A;
                        int B = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= B; i++) {
                            pgB.setValue(i);
                            Thread.sleep(30);
                        }
                        number = number - B;
                        int C = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= C; i++) {
                            pgC.setValue(i);
                            Thread.sleep(30);
                        }
                        number = number - C;
                        int D = number;
                        for (int i = 0; i <= D; i++) {
                            pgD.setValue(i);
                            Thread.sleep(30);
                        }
                    }
                    if (ch.getDapAnDung().equals("B")) {
                        int number = 100;
                        int B = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= B; i++) {
                            pgB.setValue(i);
                            Thread.sleep(50);
                        }
                        number = 100 - B;
                        int A = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= A; i++) {
                            pgA.setValue(i);
                            Thread.sleep(30);
                        }
                        number = number - A;
                        int C = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= C; i++) {
                            pgC.setValue(i);
                            Thread.sleep(30);
                        }
                        number = number - C;
                        int D = number;
                        for (int i = 0; i <= D; i++) {
                            pgD.setValue(i);
                            Thread.sleep(30);
                        }
                    }
                    if (ch.getDapAnDung().equals("C")) {
                        int number = 100;
                        int C = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= C; i++) {
                            pgC.setValue(i);
                            Thread.sleep(30);
                        }
                        number = 100 - C;
                        int B = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= B; i++) {
                            pgB.setValue(i);
                            Thread.sleep(30);
                        }
                        number = number - B;
                        int A = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= A; i++) {
                            pgA.setValue(i);
                            Thread.sleep(30);
                        }
                        number = number - A;
                        int D = number;
                        for (int i = 0; i <= D; i++) {
                            pgD.setValue(i);
                            Thread.sleep(30);
                        }
                    }
                    if (ch.getDapAnDung().equals("D")) {
                        int number = 100;
                        int D = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= D; i++) {
                            pgD.setValue(i);
                            Thread.sleep(30);
                        }
                        number = 100 - D;
                        int B = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= B; i++) {
                            pgB.setValue(i);
                            Thread.sleep(30);
                        }
                        number = number - B;
                        int C = RanDomHelper.ranDomInt(number);
                        for (int i = 0; i <= C; i++) {
                            pgC.setValue(i);
                            Thread.sleep(30);
                        }
                        number = number - C;
                        int A = number;
                        for (int i = 0; i <= A; i++) {
                            pgA.setValue(i);
                            Thread.sleep(30);
                        }
                    }

                } catch (Exception e) {

                }
            }
        };
        help.start();
    }

    void helpTuVan() {
        CauHoi ch = cauhoi;
        lblDapAn1.setText(ch.getDapAnDung());
        lblDapAn2.setText(ch.getDapAnDung());
        lblDapAn3.setText(ch.getDapAnDung());
    }

    void helpCall() {
        try {
            mp3HelpCall.play();
            Thread.sleep(2000);
            CauHoi ch = cauhoi;
            JOptionPane.showMessageDialog(this, "Tôi chắc chắn chọn phương án :" + ch.getDapAnDung());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateUser() {
        if (ShareHelper.USER != null) {
            TaiKhoan taiKhoan = null;
            if (maCauHoi > ShareHelper.USER.getSoCau()) {
                taiKhoan = new TaiKhoan(ShareHelper.USER.getTenDangNhap(), ShareHelper.USER.getMatKhau(), ShareHelper.USER.isVaiTro(), ShareHelper.USER.getThoiGian(), maCauHoi - 1, (ShareHelper.USER.getTien() + monney));
            } else {
                taiKhoan = new TaiKhoan(ShareHelper.USER.getTenDangNhap(), ShareHelper.USER.getMatKhau(), ShareHelper.USER.isVaiTro(), ShareHelper.USER.getThoiGian(), ShareHelper.USER.getSoCau(), (ShareHelper.USER.getTien() + monney));
            }
            TaiKhoanDAO dao = new TaiKhoanDAO();
            dao.update(taiKhoan);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        pnlHome = new javax.swing.JPanel();
        btn50 = new javax.swing.JLabel();
        btnCall = new javax.swing.JLabel();
        btnGround = new javax.swing.JLabel();
        lblMark = new javax.swing.JLabel();
        lblPlay = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();
        pnlPlay = new javax.swing.JPanel();
        pnlTroGiupTuVan = new javax.swing.JPanel();
        lblKhanGia1 = new javax.swing.JLabel();
        lblKhanGia2 = new javax.swing.JLabel();
        lblKhanGia3 = new javax.swing.JLabel();
        lblDapAn1 = new javax.swing.JLabel();
        lblDapAn2 = new javax.swing.JLabel();
        lblDapAn3 = new javax.swing.JLabel();
        lblExitTroGiup1 = new javax.swing.JLabel();
        lblBackgroudTroGiup1 = new javax.swing.JLabel();
        pnlTroGiupHoi = new javax.swing.JPanel();
        lbltextA = new javax.swing.JLabel();
        lbltextB = new javax.swing.JLabel();
        lbltextC = new javax.swing.JLabel();
        lbltextD = new javax.swing.JLabel();
        pgC = new javax.swing.JProgressBar();
        pgB = new javax.swing.JProgressBar();
        pgA = new javax.swing.JProgressBar();
        pgD = new javax.swing.JProgressBar();
        lblExitTroGiup = new javax.swing.JLabel();
        lblBackgroudTroGiup = new javax.swing.JLabel();
        pnlResult = new javax.swing.JPanel();
        lblHome = new javax.swing.JLabel();
        lblShare = new javax.swing.JLabel();
        lblTien = new javax.swing.JLabel();
        lblCauHoi = new javax.swing.JLabel();
        lblImageIcon = new javax.swing.JLabel();
        lblImageIcon1 = new javax.swing.JLabel();
        lblBackgroundTT = new javax.swing.JLabel();
        lblQuestion = new javax.swing.JTextArea();
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
        lbl5050Play = new javax.swing.JLabel();
        lblCallPlay = new javax.swing.JLabel();
        lblQuesion = new javax.swing.JLabel();
        lblBackPlay = new javax.swing.JLabel();
        lblConsultingTeam = new javax.swing.JLabel();
        lblBackgroundPlay = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        pnlMain.setLayout(new java.awt.CardLayout());

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

        pnlMain.add(pnlHome, "card3");

        pnlPlay.setLayout(null);

        pnlTroGiupTuVan.setPreferredSize(new java.awt.Dimension(580, 410));
        pnlTroGiupTuVan.setLayout(null);

        lblKhanGia1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblKhanGia1.setForeground(new java.awt.Color(255, 255, 255));
        lblKhanGia1.setText("Khán Giả 1:");
        pnlTroGiupTuVan.add(lblKhanGia1);
        lblKhanGia1.setBounds(50, 90, 190, 30);

        lblKhanGia2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblKhanGia2.setForeground(new java.awt.Color(255, 255, 255));
        lblKhanGia2.setText("Khán Giả 2:");
        pnlTroGiupTuVan.add(lblKhanGia2);
        lblKhanGia2.setBounds(50, 200, 190, 30);

        lblKhanGia3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblKhanGia3.setForeground(new java.awt.Color(255, 255, 255));
        lblKhanGia3.setText("Khán Giả 3:");
        pnlTroGiupTuVan.add(lblKhanGia3);
        lblKhanGia3.setBounds(50, 290, 190, 30);

        lblDapAn1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDapAn1.setForeground(new java.awt.Color(255, 255, 255));
        lblDapAn1.setText(".");
        pnlTroGiupTuVan.add(lblDapAn1);
        lblDapAn1.setBounds(250, 90, 190, 30);

        lblDapAn2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDapAn2.setForeground(new java.awt.Color(255, 255, 255));
        lblDapAn2.setText(".");
        pnlTroGiupTuVan.add(lblDapAn2);
        lblDapAn2.setBounds(250, 200, 190, 30);

        lblDapAn3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblDapAn3.setForeground(new java.awt.Color(255, 255, 255));
        lblDapAn3.setText(".");
        pnlTroGiupTuVan.add(lblDapAn3);
        lblDapAn3.setBounds(250, 290, 190, 30);

        lblExitTroGiup1.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        lblExitTroGiup1.setForeground(new java.awt.Color(255, 0, 0));
        lblExitTroGiup1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconBack.png"))); // NOI18N
        lblExitTroGiup1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitTroGiup1MouseClicked(evt);
            }
        });
        pnlTroGiupTuVan.add(lblExitTroGiup1);
        lblExitTroGiup1.setBounds(500, 330, 70, 70);

        lblBackgroudTroGiup1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/troGiup.png"))); // NOI18N
        pnlTroGiupTuVan.add(lblBackgroudTroGiup1);
        lblBackgroudTroGiup1.setBounds(0, 0, 580, 420);

        pnlPlay.add(pnlTroGiupTuVan);
        pnlTroGiupTuVan.setBounds(320, 170, 580, 420);

        pnlTroGiupHoi.setPreferredSize(new java.awt.Dimension(580, 410));
        pnlTroGiupHoi.setLayout(null);

        lbltextA.setFont(new java.awt.Font("Mongolian Baiti", 1, 36)); // NOI18N
        lbltextA.setForeground(new java.awt.Color(255, 255, 255));
        lbltextA.setText("A");
        pnlTroGiupHoi.add(lbltextA);
        lbltextA.setBounds(100, 320, 30, 30);

        lbltextB.setFont(new java.awt.Font("Mongolian Baiti", 1, 36)); // NOI18N
        lbltextB.setForeground(new java.awt.Color(255, 255, 255));
        lbltextB.setText("B");
        pnlTroGiupHoi.add(lbltextB);
        lbltextB.setBounds(210, 320, 30, 30);

        lbltextC.setFont(new java.awt.Font("Mongolian Baiti", 1, 36)); // NOI18N
        lbltextC.setForeground(new java.awt.Color(255, 255, 255));
        lbltextC.setText("C");
        pnlTroGiupHoi.add(lbltextC);
        lbltextC.setBounds(330, 320, 30, 30);

        lbltextD.setFont(new java.awt.Font("Mongolian Baiti", 1, 36)); // NOI18N
        lbltextD.setForeground(new java.awt.Color(255, 255, 255));
        lbltextD.setText("D");
        pnlTroGiupHoi.add(lbltextD);
        lbltextD.setBounds(450, 320, 30, 40);

        pgC.setBackground(new java.awt.Color(255, 255, 51));
        pgC.setOrientation(1);
        pgC.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pgC.setOpaque(true);
        pgC.setPreferredSize(new java.awt.Dimension(50, 19));
        pgC.setStringPainted(true);
        pnlTroGiupHoi.add(pgC);
        pgC.setBounds(320, 100, 50, 200);

        pgB.setBackground(new java.awt.Color(255, 255, 51));
        pgB.setOrientation(1);
        pgB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pgB.setOpaque(true);
        pgB.setStringPainted(true);
        pnlTroGiupHoi.add(pgB);
        pgB.setBounds(200, 100, 50, 200);

        pgA.setBackground(new java.awt.Color(255, 153, 51));
        pgA.setOrientation(1);
        pgA.setToolTipText("");
        pgA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pgA.setRequestFocusEnabled(false);
        pgA.setStringPainted(true);
        pnlTroGiupHoi.add(pgA);
        pgA.setBounds(90, 100, 50, 200);

        pgD.setBackground(new java.awt.Color(255, 255, 51));
        pgD.setOrientation(1);
        pgD.setToolTipText("");
        pgD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pgD.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        pgD.setStringPainted(true);
        pnlTroGiupHoi.add(pgD);
        pgD.setBounds(430, 100, 50, 200);

        lblExitTroGiup.setFont(new java.awt.Font("Tahoma", 3, 48)); // NOI18N
        lblExitTroGiup.setForeground(new java.awt.Color(255, 0, 0));
        lblExitTroGiup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconBack.png"))); // NOI18N
        lblExitTroGiup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExitTroGiupMouseClicked(evt);
            }
        });
        pnlTroGiupHoi.add(lblExitTroGiup);
        lblExitTroGiup.setBounds(500, 330, 70, 70);

        lblBackgroudTroGiup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/troGiup.png"))); // NOI18N
        pnlTroGiupHoi.add(lblBackgroudTroGiup);
        lblBackgroudTroGiup.setBounds(0, 0, 580, 420);

        pnlPlay.add(pnlTroGiupHoi);
        pnlTroGiupHoi.setBounds(320, 170, 580, 420);

        pnlResult.setBackground(new Color(0,0,0,0));
        pnlResult.setLayout(null);

        lblHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); // NOI18N
        lblHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHomeMouseClicked(evt);
            }
        });
        pnlResult.add(lblHome);
        lblHome.setBounds(180, 300, 90, 40);

        lblShare.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/share.png"))); // NOI18N
        lblShare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblShareMouseClicked(evt);
            }
        });
        pnlResult.add(lblShare);
        lblShare.setBounds(290, 300, 90, 40);

        lblTien.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTien.setForeground(new java.awt.Color(255, 255, 255));
        lblTien.setText("Tiền : 0");
        pnlResult.add(lblTien);
        lblTien.setBounds(180, 130, 200, 40);

        lblCauHoi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCauHoi.setForeground(new java.awt.Color(255, 255, 255));
        lblCauHoi.setText("Câu hỏi : 0");
        pnlResult.add(lblCauHoi);
        lblCauHoi.setBounds(180, 210, 200, 40);

        lblImageIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconLbl.png"))); // NOI18N
        pnlResult.add(lblImageIcon);
        lblImageIcon.setBounds(170, 120, 220, 60);

        lblImageIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconLbl.png"))); // NOI18N
        pnlResult.add(lblImageIcon1);
        lblImageIcon1.setBounds(170, 200, 220, 60);

        lblBackgroundTT.setBackground(java.awt.Color.white);
        lblBackgroundTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/thanhtich.png"))); // NOI18N
        pnlResult.add(lblBackgroundTT);
        lblBackgroundTT.setBounds(0, 0, 580, 410);

        pnlPlay.add(pnlResult);
        pnlResult.setBounds(320, 170, 580, 410);

        lblQuestion.setEditable(false);
        lblQuestion.setBackground(new java.awt.Color(0, 0, 255));
        lblQuestion.setColumns(20);
        lblQuestion.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        lblQuestion.setForeground(new java.awt.Color(255, 255, 255));
        lblQuestion.setLineWrap(true);
        lblQuestion.setRows(5);
        lblQuestion.setWrapStyleWord(true);
        pnlPlay.add(lblQuestion);
        lblQuestion.setBounds(380, 310, 340, 80);

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
        lblQuestion.setBackground(new Color(0, 0, 0, 0));
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

        lbl5050Play.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/5050.png"))); // NOI18N
        lbl5050Play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl5050PlayMouseClicked(evt);
            }
        });
        pnlPlay.add(lbl5050Play);
        lbl5050Play.setBounds(960, 270, 60, 60);

        lblCallPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/call.png"))); // NOI18N
        lblCallPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCallPlayMouseClicked(evt);
            }
        });
        pnlPlay.add(lblCallPlay);
        lblCallPlay.setBounds(960, 360, 60, 60);

        lblQuesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/question.png"))); // NOI18N
        lblQuesion.setText("jLabel2");
        lblQuesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuesionMouseClicked(evt);
            }
        });
        pnlPlay.add(lblQuesion);
        lblQuesion.setBounds(960, 460, 70, 60);

        lblBackPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconBack.png"))); // NOI18N
        lblBackPlay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackPlayMouseClicked(evt);
            }
        });
        pnlPlay.add(lblBackPlay);
        lblBackPlay.setBounds(1080, 550, 70, 100);

        lblConsultingTeam.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/totuvan.png"))); // NOI18N
        lblConsultingTeam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblConsultingTeamMouseClicked(evt);
            }
        });
        pnlPlay.add(lblConsultingTeam);
        lblConsultingTeam.setBounds(960, 170, 60, 70);

        lblBackgroundPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        lblBackgroundPlay.setText("fa");
        pnlPlay.add(lblBackgroundPlay);
        lblBackgroundPlay.setBounds(0, 0, 1180, 700);

        pnlMain.add(pnlPlay, "card2");

        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPlayMouseClicked
        // TODO add your handling code here:
        mp3SanSang.play();
        mp3.stop();
        pnlHome.setVisible(false);
        pnlPlay.setVisible(true);
        setStatusFalse();
        playGame(maCauHoi);
        check5050 = true;
        checkQuesion = true;
        checkTuVan = true;
    }//GEN-LAST:event_lblPlayMouseClicked

    private void lblImagesAnswerAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagesAnswerAMouseClicked
        // TODO add your handling code here:
        mp3FillQuestion.stop();
        dapAn = "A";
        mp3QuestionA.play();
        lblImagesAnswerA.setIcon(new ImageIcon(getClass().getResource("/hinh/A.png")));
        check();
    }//GEN-LAST:event_lblImagesAnswerAMouseClicked

    private void lblAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAMouseClicked
        // TODO add your handling code here:
        mp3FillQuestion.stop();
        dapAn = "A";
        mp3QuestionA.play();
        lblImagesAnswerA.setIcon(new ImageIcon(getClass().getResource("/hinh/A.png")));
        check();
    }//GEN-LAST:event_lblAMouseClicked

    private void lblImagesAnswerBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagesAnswerBMouseClicked
        // TODO add your handling code here:
        dapAn = "B";
        mp3QuestionB.play();
        mp3FillQuestion.stop();
        lblImagesAnswerB.setIcon(new ImageIcon(getClass().getResource("/hinh/B.png")));
        check();
    }//GEN-LAST:event_lblImagesAnswerBMouseClicked

    private void lblBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBMouseClicked
        // TODO add your handling code here:
        dapAn = "B";
        mp3QuestionB.play();
        mp3FillQuestion.stop();
        lblImagesAnswerB.setIcon(new ImageIcon(getClass().getResource("/hinh/B.png")));
        check();
    }//GEN-LAST:event_lblBMouseClicked

    private void lblImagesAnswerCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagesAnswerCMouseClicked
        // TODO add your handling code here:
        dapAn = "C";
        mp3QuestionC.play();
        mp3FillQuestion.stop();
        lblImagesAnswerC.setIcon(new ImageIcon(getClass().getResource("/hinh/C.png")));
        check();
    }//GEN-LAST:event_lblImagesAnswerCMouseClicked

    private void lblCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCMouseClicked
        // TODO add your handling code here:
        dapAn = "C";
        mp3QuestionC.play();
        mp3FillQuestion.stop();
        lblImagesAnswerC.setIcon(new ImageIcon(getClass().getResource("/hinh/C.png")));
        check();
    }//GEN-LAST:event_lblCMouseClicked

    private void lblImagesAnswerDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImagesAnswerDMouseClicked
        // TODO add your handling code here:
        dapAn = "D";
        mp3FillQuestion.stop();
        mp3QuestionD.play();
        lblImagesAnswerD.setIcon(new ImageIcon(getClass().getResource("/hinh/D.png")));
        check();
    }//GEN-LAST:event_lblImagesAnswerDMouseClicked

    private void lblDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDMouseClicked
        // TODO add your handling code here:
        dapAn = "D";
        mp3QuestionD.play();
        mp3FillQuestion.stop();
        lblImagesAnswerD.setIcon(new ImageIcon(getClass().getResource("/hinh/D.png")));
        check();
    }//GEN-LAST:event_lblDMouseClicked

    private void lbl5050PlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl5050PlayMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this, "Bạn muốn sử đụng trợ giúp 50:50", "Thong Bao", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            help5050();
            check5050 = false;
            lbl5050Play.setIcon(new ImageIcon(getClass().getResource("/image/5050chet.png")));
        }
    }//GEN-LAST:event_lbl5050PlayMouseClicked

    private void lblHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHomeMouseClicked
        // TODO add your handling code here:
        if (ShareHelper.USER != null) {
            updateUser();
            TaiKhoanDAO dao = new TaiKhoanDAO();
            TaiKhoan tk = dao.findByTaiKhoan(ShareHelper.USER.getTenDangNhap());
            mainFarme.showUser(tk.getTien().toString(), tk.getSoCau().toString(), tk.getThoiGian().toString());
            this.setVisible(false);
            mainFarme.setVisible(true);
            pnlResult.setVisible(false);
            maCauHoi = 1;
        } else {
            this.setVisible(false);
            mainFarme.setVisible(true);
            pnlResult.setVisible(false);
            maCauHoi = 1;
        }
    }//GEN-LAST:event_lblHomeMouseClicked

    private void lblExitTroGiupMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitTroGiupMouseClicked
        // TODO add your handling code here:
        pnlTroGiupHoi.setVisible(false);
    }//GEN-LAST:event_lblExitTroGiupMouseClicked

    private void lblQuesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuesionMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this, "Bạn muốn sử đụng trợ giúp hỏi ý kiến khán giả", "Thong Bao", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            pnlTroGiupHoi.setVisible(true);
            helpQuesion();
            checkQuesion = false;
            lblQuesion.setIcon(new ImageIcon(getClass().getResource("/image/questionchet.png")));
        }
    }//GEN-LAST:event_lblQuesionMouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
        MainFarme main = new MainFarme();
        main.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    private void lblCallPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCallPlayMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this, "Bạn muốn sử dụng gọi điện thoại", "Thong Bao", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            mp3FillQuestion.pause();
            helpCall();
            checkCall = false;
            lblCallPlay.setIcon(new ImageIcon(getClass().getResource("/image/callchet.png")));
        }
        mp3FillQuestion.play();
    }//GEN-LAST:event_lblCallPlayMouseClicked

    private void lblExitTroGiup1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExitTroGiup1MouseClicked
        // TODO add your handling code here:
        pnlTroGiupTuVan.setVisible(false);
    }//GEN-LAST:event_lblExitTroGiup1MouseClicked

    private void lblBackPlayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackPlayMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this, "Bạn có muốn dừng cuộc chơi lấy " + monney + " tiền thưởng", "Thong Bao", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            pnlResult.setVisible(true);
        }
    }//GEN-LAST:event_lblBackPlayMouseClicked

    private void lblConsultingTeamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblConsultingTeamMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this, "Bạn muốn sử đụng trợ giúp tư vấn tại chỗ", "Thong Bao", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            pnlTroGiupTuVan.setVisible(true);
            helpTuVan();
            checkTuVan = false;
            lblConsultingTeam.setIcon(new ImageIcon(getClass().getResource("/image/totuvanchet.png")));
        }
    }//GEN-LAST:event_lblConsultingTeamMouseClicked

    private void lblShareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblShareMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_lblShareMouseClicked

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
    private javax.swing.JLabel btnCall;
    private javax.swing.JLabel btnGround;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl5050Play;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblB;
    private javax.swing.JLabel lblBackPlay;
    private javax.swing.JLabel lblBackgroudTroGiup;
    private javax.swing.JLabel lblBackgroudTroGiup1;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblBackgroundPlay;
    private javax.swing.JLabel lblBackgroundTT;
    private javax.swing.JLabel lblC;
    private javax.swing.JLabel lblCallPlay;
    private javax.swing.JLabel lblCauHoi;
    private javax.swing.JLabel lblConsultingTeam;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblDapAn1;
    private javax.swing.JLabel lblDapAn2;
    private javax.swing.JLabel lblDapAn3;
    private javax.swing.JLabel lblExitTroGiup;
    private javax.swing.JLabel lblExitTroGiup1;
    private javax.swing.JLabel lblHome;
    private javax.swing.JLabel lblImageIcon;
    private javax.swing.JLabel lblImageIcon1;
    private javax.swing.JLabel lblImageQuestion;
    private javax.swing.JLabel lblImagesAnswerA;
    private javax.swing.JLabel lblImagesAnswerB;
    private javax.swing.JLabel lblImagesAnswerC;
    private javax.swing.JLabel lblImagesAnswerD;
    private javax.swing.JLabel lblKhanGia1;
    private javax.swing.JLabel lblKhanGia2;
    private javax.swing.JLabel lblKhanGia3;
    private javax.swing.JLabel lblMark;
    private javax.swing.JLabel lblMarkPlay;
    private javax.swing.JLabel lblPlay;
    private javax.swing.JLabel lblQuesion;
    private javax.swing.JTextArea lblQuestion;
    private javax.swing.JLabel lblShare;
    private javax.swing.JLabel lblTien;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lbltextA;
    private javax.swing.JLabel lbltextB;
    private javax.swing.JLabel lbltextC;
    private javax.swing.JLabel lbltextD;
    private javax.swing.JProgressBar pgA;
    private javax.swing.JProgressBar pgB;
    private javax.swing.JProgressBar pgC;
    private javax.swing.JProgressBar pgD;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPlay;
    private javax.swing.JPanel pnlResult;
    private javax.swing.JPanel pnlTroGiupHoi;
    private javax.swing.JPanel pnlTroGiupTuVan;
    // End of variables declaration//GEN-END:variables
}
