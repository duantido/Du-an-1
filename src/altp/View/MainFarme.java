/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.View;

import altp.DAO.CauHoiDAO;
import altp.DAO.TaiKhoanDAO;
import altp.DAO.UserDao;
import altp.HibernateHelper.ShareHelper;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import altp.view.*;
import entity.CauHoi;
import entity.TaiKhoan;
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;

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
    PlayGameFarme mainPlay;

    public MainFarme() {
        initComponents();
        setSize(1180, 700);
        setLocationRelativeTo(null);
        mainPlay = new PlayGameFarme(i, mp3CauHoi, mp3Main, this);
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
        pnlInsertDatabase.setVisible(false);
    }

    void showUser(String tien, String cau, String thoigian) {
        lblLogin.setVisible(false);
        lblDangXuat.setVisible(true);
        lblTongTien.setText(tien);
        lblCaoCaoNhat.setText(cau);

    }

    void login() {
        String name = txtUserLogin.getText();
        String password = txtPasswordLogin.getText();
        try {
            List<TaiKhoan> list = TaiKhoanDAO.layTaiKhoan(name, password);
            TaiKhoan taiKhoan = list.get(0);
            if (taiKhoan.getTenDangNhap().equals(name) && taiKhoan.getMatKhau().equals(password)) {
                ShareHelper.USER = taiKhoan;
                if (ShareHelper.USER != null && ShareHelper.USER.isVaiTro() == false) {
                    showUser(ShareHelper.USER.getTien().toString(), ShareHelper.USER.getSoCau().toString(), ShareHelper.USER.getThoiGian().toString());
                    pnlLogin.setVisible(false);
                    lblBXH.setVisible(true);
                }
                if (ShareHelper.USER != null && ShareHelper.USER.isVaiTro() == true) {
                    pnlInsertDatabase.setVisible(true);
                    fillTableQuestion();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thông tin đăng nhập không chính xác!");
        }
    }

    void fillTableQuestion() {
        DefaultTableModel model = (DefaultTableModel) TblGriView.getModel();
        model.setRowCount(0);
        try {
            List<CauHoi> lst = CauHoiDAO.fillCauHoi();
            for (CauHoi ch : lst) {
                Object[] row = {
                    ch.getStt(),
                    ch.getMaCauHoi(),
                    ch.getTenCauHoi(),
                    ch.getMaChiTietCh(),
                    ch.getA(),
                    ch.getB(),
                    ch.getC(),
                    ch.getD(),
                    ch.getDapAnDung()
                };
                model.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void updateTable() {
        try {
            for (int i = 0; i < TblGriView.getRowCount(); i++) {
            Integer stt = (Integer) TblGriView.getValueAt(i, 0);
            Integer maCauHoi = (Integer) TblGriView.getValueAt(i, 1);
            String tenCauHoi = (String) TblGriView.getValueAt(i, 2);
            Integer maChiTietCH = (Integer) TblGriView.getValueAt(i, 3);
            String A = (String) TblGriView.getValueAt(i, 4);
            String B = (String) TblGriView.getValueAt(i, 5);
            String C = (String) TblGriView.getValueAt(i, 6);
            String D = (String) TblGriView.getValueAt(i, 7);
            String dapAnDung = (String) TblGriView.getValueAt(i, 8);
            Boolean isDelete = (Boolean) TblGriView.getValueAt(i, 9);
            if (isDelete) {
                CauHoi cauHoi = new CauHoi(stt, maCauHoi, maChiTietCH, dapAnDung);
                CauHoiDAO.delete(cauHoi);
                fillTableQuestion();
                JOptionPane.showMessageDialog(this, "Delete thanh cong !");
            } else {
                CauHoi cauHoi = new CauHoi(stt, maCauHoi, tenCauHoi, maChiTietCH, A, B, C, D, dapAnDung);
                CauHoiDAO.update(cauHoi);
                fillTableQuestion();
            }
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Hãy tích vào câu hỏi muốn thay đổi");
        }
        
    }

    void deleteAllQuestion() {
        for (int i = 0; i < TblGriView.getRowCount(); i++) {
            Integer stt = (Integer) TblGriView.getValueAt(i, 0);
            Integer maCauHoi = (Integer) TblGriView.getValueAt(i, 1);
            String tenCauHoi = (String) TblGriView.getValueAt(i, 2);
            Integer maChiTietCH = (Integer) TblGriView.getValueAt(i, 3);
            String A = (String) TblGriView.getValueAt(i, 4);
            String B = (String) TblGriView.getValueAt(i, 5);
            String C = (String) TblGriView.getValueAt(i, 6);
            String D = (String) TblGriView.getValueAt(i, 7);
            String dapAnDung = (String) TblGriView.getValueAt(i, 8);
            CauHoi cauHoi = new CauHoi(stt, maCauHoi, tenCauHoi, maChiTietCH, A, B, C, D, dapAnDung);
            CauHoiDAO.delete(cauHoi);
        }
        fillTableQuestion();
        JOptionPane.showMessageDialog(this, "Delete thanh cong !");
    }

    void importFileExel() {
        try {
            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                FileInputStream fileInputStream = new FileInputStream(file);
                try (HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream)) {
                    HSSFSheet dataSheet = workbook.getSheetAt(0);
                    Iterator<Row> iterator = dataSheet.iterator();
                    Row firstRow = iterator.next();
                    while (iterator.hasNext()) {
                        Row currentRow = iterator.next();
                        CauHoi user = new CauHoi();
                        try {
                            user.setMaCauHoi(Integer.parseInt(currentRow.getCell(1).getStringCellValue()));
                        } catch (Exception ex) {
                            String mach = String.valueOf(Math.round(currentRow.getCell(1).getNumericCellValue()));
                            user.setMaCauHoi(Integer.parseInt(mach));
                        }
                        user.setTenCauHoi(currentRow.getCell(2).getStringCellValue());
                        try {
                            user.setMaChiTietCh(Integer.parseInt(currentRow.getCell(3).getStringCellValue()));
                        } catch (Exception ex) {
                            String mactch = String.valueOf(Math.round(currentRow.getCell(3).getNumericCellValue()));
                            user.setMaChiTietCh(Integer.parseInt(mactch));
                        }
                        user.setA(currentRow.getCell(4).getStringCellValue());
                        user.setB(currentRow.getCell(5).getStringCellValue());
                        user.setC(currentRow.getCell(6).getStringCellValue());
                        user.setD(currentRow.getCell(7).getStringCellValue());
                        user.setDapAnDung(currentRow.getCell(8).getStringCellValue());

                        UserDao use = new CauHoiDAO();
                        use.add(user);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                JOptionPane.showMessageDialog(this, "Thêm thành công !");
                fillTableQuestion();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void logoff() {
        ShareHelper.logoff();
        lblTongTien.setText("");
        lblCaoCaoNhat.setText("");

    }

    void Account() {
        String name = txtNameAccout.getText();
        String password = new String(txtPasswordAccount.getPassword());
        List<TaiKhoan> list = TaiKhoanDAO.layDsTaiKhoan();
        boolean checkTenDangNhap = true;
        for (TaiKhoan tk : list) {
            if (password.equals(tk.getTenDangNhap())) {
                checkTenDangNhap = false;
            }
        }
        if (checkTenDangNhap == true) {
            try {
                TaiKhoan taiKhoan = new TaiKhoan(name, password, false, 0, 0, 0);
                TaiKhoanDAO dao = new TaiKhoanDAO();
                dao.insert(taiKhoan);
                JOptionPane.showMessageDialog(this, "Đăng kí thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Dang ki that bai");
            }
        }else{
            JOptionPane.showMessageDialog(this, "Tên đăng nhập đã tồn tại");
            checkTenDangNhap=true;
        }

    }

    void showBxhTheoTien() {
        List<TaiKhoan> list = TaiKhoanDAO.layBxhTien();
        if (list.get(0) != null) {
            lblname1.setText(list.get(0).getTenDangNhap());
            lbltien1.setText(list.get(0).getTien().toString());
            lblcau1.setText(list.get(0).getSoCau().toString());
        }
        if (list.get(1) != null) {
            lblname2.setText(list.get(1).getTenDangNhap());
            lbltien2.setText(list.get(1).getTien().toString());
            lblcau2.setText(list.get(1).getSoCau().toString());
        }
        if (list.get(2) != null) {
            lblname3.setText(list.get(2).getTenDangNhap());
            lbltien3.setText(list.get(2).getTien().toString());
            lblcau3.setText(list.get(2).getSoCau().toString());
        }
        if (list.get(3) != null) {
            lblname4.setText(list.get(3).getTenDangNhap());
            lbltien4.setText(list.get(3).getTien().toString());
            lblcau4.setText(list.get(3).getSoCau().toString());
        }
        if (list.get(4) != null) {
            lblname5.setText(list.get(4).getTenDangNhap());
            lbltien5.setText(list.get(4).getTien().toString());
            lblcau5.setText(list.get(4).getSoCau().toString());
        }
    }

    void showBxhTheoCau() {
        List<TaiKhoan> list = TaiKhoanDAO.layBxhCau();

        if (list.get(0) != null) {
            lblname1.setText(list.get(0).getTenDangNhap());
            lbltien1.setText(list.get(0).getTien().toString());
            lblcau1.setText(list.get(0).getSoCau().toString());
        }
        if (list.get(1) != null) {
            lblname2.setText(list.get(1).getTenDangNhap());
            lbltien2.setText(list.get(1).getTien().toString());
            lblcau2.setText(list.get(1).getSoCau().toString());
        }
        if (list.get(2) != null) {
            lblname3.setText(list.get(2).getTenDangNhap());
            lbltien3.setText(list.get(2).getTien().toString());
            lblcau3.setText(list.get(2).getSoCau().toString());
        }
        if (list.get(3) != null) {
            lblname4.setText(list.get(3).getTenDangNhap());
            lbltien4.setText(list.get(3).getTien().toString());
            lblcau4.setText(list.get(3).getSoCau().toString());
        }
        if (list.get(4) != null) {
            lblname5.setText(list.get(4).getTenDangNhap());
            lbltien5.setText(list.get(4).getTien().toString());
            lblcau5.setText(list.get(4).getSoCau().toString());
        }
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
        lblTongTien = new javax.swing.JLabel();
        lblCaoCaoNhat = new javax.swing.JLabel();
        lblOption = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        txtUserLogin = new javax.swing.JTextField();
        lblLoginUser = new javax.swing.JLabel();
        lblLoginPassword = new javax.swing.JLabel();
        txtPasswordLogin = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnLoginAccout = new javax.swing.JButton();
        lblBackLogin = new javax.swing.JLabel();
        lblIconDangNhap = new javax.swing.JLabel();
        lblBackgroundLoginn = new javax.swing.JLabel();
        pnlInsertDatabase = new javax.swing.JPanel();
        lblTitleThongKe = new javax.swing.JLabel();
        btnImportFileExel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblGriView = new javax.swing.JTable();
        btnUpdate = new javax.swing.JButton();
        btnDeleteAll = new javax.swing.JButton();
        lblBackInsertData = new javax.swing.JLabel();
        pnlAccount = new javax.swing.JPanel();
        lblTitleDangKi = new javax.swing.JLabel();
        lblBackDangKi = new javax.swing.JLabel();
        btnAccout = new javax.swing.JButton();
        txtNameAccout = new javax.swing.JTextField();
        lblAccoutPassword = new javax.swing.JLabel();
        lblLoginAccout = new javax.swing.JLabel();
        txtPasswordAccount = new javax.swing.JPasswordField();
        lblBackgroundAccout = new javax.swing.JLabel();
        pnlBxh = new javax.swing.JPanel();
        lblname1 = new javax.swing.JLabel();
        lblname2 = new javax.swing.JLabel();
        lblname3 = new javax.swing.JLabel();
        lblname4 = new javax.swing.JLabel();
        lblname5 = new javax.swing.JLabel();
        lbltien1 = new javax.swing.JLabel();
        lbltien2 = new javax.swing.JLabel();
        lbltien3 = new javax.swing.JLabel();
        lbltien4 = new javax.swing.JLabel();
        lbltien5 = new javax.swing.JLabel();
        lblcau1 = new javax.swing.JLabel();
        lblcau2 = new javax.swing.JLabel();
        lblcau3 = new javax.swing.JLabel();
        lblcau4 = new javax.swing.JLabel();
        lblcau5 = new javax.swing.JLabel();
        lblTopCau = new javax.swing.JLabel();
        lblTopTien = new javax.swing.JLabel();
        lblBxh1 = new javax.swing.JLabel();
        lblDongBXH = new javax.swing.JLabel();
        lblBXH = new javax.swing.JLabel();
        lblHightMoney = new javax.swing.JLabel();
        lblHightSentences = new javax.swing.JLabel();
        lblPlay = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        lblDangXuat = new javax.swing.JLabel();
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
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        pnlHome.setLayout(new java.awt.CardLayout());

        pnlMain.setLayout(null);

        lblTongTien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTongTien.setForeground(new java.awt.Color(255, 255, 255));
        pnlMain.add(lblTongTien);
        lblTongTien.setBounds(540, 50, 80, 20);

        lblCaoCaoNhat.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblCaoCaoNhat.setForeground(new java.awt.Color(255, 255, 255));
        pnlMain.add(lblCaoCaoNhat);
        lblCaoCaoNhat.setBounds(750, 50, 60, 20);

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
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
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

        lblIconDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logologin1.png"))); // NOI18N
        pnlLogin.add(lblIconDangNhap);
        lblIconDangNhap.setBounds(280, 110, 200, 50);

        lblBackgroundLoginn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/loginBoxBg.png"))); // NOI18N
        pnlLogin.add(lblBackgroundLoginn);
        lblBackgroundLoginn.setBounds(0, 0, 720, 500);

        pnlMain.add(pnlLogin);
        pnlLogin.setBounds(250, 110, 720, 500);

        pnlInsertDatabase.setLayout(null);

        lblTitleThongKe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitleThongKe.setText("Thống kê câu hỏi ");
        pnlInsertDatabase.add(lblTitleThongKe);
        lblTitleThongKe.setBounds(50, 30, 140, 20);

        btnImportFileExel.setText("Import File Exel");
        btnImportFileExel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportFileExelActionPerformed(evt);
            }
        });
        pnlInsertDatabase.add(btnImportFileExel);
        btnImportFileExel.setBounds(250, 20, 150, 30);

        TblGriView.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Ma cau hoi", "Ten cau hoi", "Ma CT Cau Hoi", "A", "B", "C", "D", "Dap An Dung", "Xóa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TblGriView);
        if (TblGriView.getColumnModel().getColumnCount() > 0) {
            TblGriView.getColumnModel().getColumn(0).setResizable(false);
        }

        pnlInsertDatabase.add(jScrollPane1);
        jScrollPane1.setBounds(10, 60, 1040, 420);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        pnlInsertDatabase.add(btnUpdate);
        btnUpdate.setBounds(420, 20, 130, 30);

        btnDeleteAll.setText("DeleteAllQuestion");
        btnDeleteAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAllActionPerformed(evt);
            }
        });
        pnlInsertDatabase.add(btnDeleteAll);
        btnDeleteAll.setBounds(580, 20, 130, 30);

        lblBackInsertData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblBackInsertData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/iconBack.png"))); // NOI18N
        lblBackInsertData.setText("Đăng xuất");
        lblBackInsertData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackInsertDataMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblBackInsertDataMouseEntered(evt);
            }
        });
        pnlInsertDatabase.add(lblBackInsertData);
        lblBackInsertData.setBounds(20, 490, 170, 60);

        pnlMain.add(pnlInsertDatabase);
        pnlInsertDatabase.setBounds(30, 40, 1070, 560);

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

        txtNameAccout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameAccoutActionPerformed(evt);
            }
        });
        pnlAccount.add(txtNameAccout);
        txtNameAccout.setBounds(220, 180, 310, 40);

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

        lblname1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblname1.setForeground(new java.awt.Color(255, 255, 255));
        lblname1.setText("long");
        pnlBxh.add(lblname1);
        lblname1.setBounds(80, 130, 100, 30);

        lblname2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblname2.setForeground(new java.awt.Color(255, 255, 255));
        lblname2.setText("long");
        pnlBxh.add(lblname2);
        lblname2.setBounds(80, 160, 100, 30);

        lblname3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblname3.setForeground(new java.awt.Color(255, 255, 255));
        lblname3.setText("long");
        pnlBxh.add(lblname3);
        lblname3.setBounds(80, 190, 100, 40);

        lblname4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblname4.setForeground(new java.awt.Color(255, 255, 255));
        lblname4.setText("long");
        pnlBxh.add(lblname4);
        lblname4.setBounds(80, 230, 100, 30);

        lblname5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblname5.setForeground(new java.awt.Color(255, 255, 255));
        lblname5.setText("long");
        pnlBxh.add(lblname5);
        lblname5.setBounds(80, 260, 110, 30);

        lbltien1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbltien1.setForeground(new java.awt.Color(255, 255, 255));
        lbltien1.setText("long");
        pnlBxh.add(lbltien1);
        lbltien1.setBounds(240, 130, 90, 30);

        lbltien2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbltien2.setForeground(new java.awt.Color(255, 255, 255));
        lbltien2.setText("long");
        pnlBxh.add(lbltien2);
        lbltien2.setBounds(240, 160, 90, 30);

        lbltien3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbltien3.setForeground(new java.awt.Color(255, 255, 255));
        lbltien3.setText("long");
        pnlBxh.add(lbltien3);
        lbltien3.setBounds(240, 190, 90, 30);

        lbltien4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbltien4.setForeground(new java.awt.Color(255, 255, 255));
        lbltien4.setText("long");
        pnlBxh.add(lbltien4);
        lbltien4.setBounds(240, 230, 90, 30);

        lbltien5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbltien5.setForeground(new java.awt.Color(255, 255, 255));
        lbltien5.setText("long");
        pnlBxh.add(lbltien5);
        lbltien5.setBounds(240, 260, 80, 30);

        lblcau1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblcau1.setForeground(new java.awt.Color(255, 255, 255));
        lblcau1.setText("long");
        pnlBxh.add(lblcau1);
        lblcau1.setBounds(350, 130, 34, 30);

        lblcau2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblcau2.setForeground(new java.awt.Color(255, 255, 255));
        lblcau2.setText("long");
        pnlBxh.add(lblcau2);
        lblcau2.setBounds(350, 160, 34, 30);

        lblcau3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblcau3.setForeground(new java.awt.Color(255, 255, 255));
        lblcau3.setText("long");
        pnlBxh.add(lblcau3);
        lblcau3.setBounds(350, 190, 34, 30);

        lblcau4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblcau4.setForeground(new java.awt.Color(255, 255, 255));
        lblcau4.setText("long");
        pnlBxh.add(lblcau4);
        lblcau4.setBounds(350, 230, 34, 30);

        lblcau5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblcau5.setForeground(new java.awt.Color(255, 255, 255));
        lblcau5.setText("long");
        pnlBxh.add(lblcau5);
        lblcau5.setBounds(350, 260, 34, 30);

        lblTopCau.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblTopCau.setForeground(new java.awt.Color(255, 255, 255));
        lblTopCau.setText("Top Trả Lời");
        lblTopCau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTopCauMouseClicked(evt);
            }
        });
        pnlBxh.add(lblTopCau);
        lblTopCau.setBounds(260, 460, 120, 22);

        lblTopTien.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lblTopTien.setForeground(new java.awt.Color(255, 255, 255));
        lblTopTien.setText("Top Đại Gia");
        lblTopTien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTopTienMouseClicked(evt);
            }
        });
        pnlBxh.add(lblTopTien);
        lblTopTien.setBounds(10, 460, 120, 22);

        lblBxh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/bxh1.png"))); // NOI18N
        pnlBxh.add(lblBxh1);
        lblBxh1.setBounds(0, 0, 390, 600);

        lblDongBXH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDongBXHMouseClicked(evt);
            }
        });
        pnlBxh.add(lblDongBXH);
        lblDongBXH.setBounds(60, 550, 270, 40);

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

        lblHightMoney.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHightMoney.setForeground(new java.awt.Color(255, 255, 255));
        lblHightMoney.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/tongtien.png"))); // NOI18N
        lblHightMoney.setText("Tổng số tiền");
        pnlMain.add(lblHightMoney);
        lblHightMoney.setBounds(490, 20, 140, 36);

        lblHightSentences.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblHightSentences.setForeground(new java.awt.Color(255, 255, 255));
        lblHightSentences.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/top.png"))); // NOI18N
        lblHightSentences.setText("Câu cao nhất");
        pnlMain.add(lblHightSentences);
        lblHightSentences.setBounds(700, 20, 150, 36);

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

        lblDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dangxuat.png"))); // NOI18N
        lblDangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDangXuatMouseClicked(evt);
            }
        });
        pnlMain.add(lblDangXuat);
        lblDangXuat.setBounds(50, 50, 200, 40);

        lblBackgroundMain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackgroundMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        pnlMain.add(lblBackgroundMain);
        lblBackgroundMain.setBounds(0, 0, 1170, 700);

        pnlHome.add(pnlMain, "card2");

        pnlSetting.setPreferredSize(new java.awt.Dimension(500, 500));
        pnlSetting.setLayout(null);

        lblIconBackground3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIconBackground3.setForeground(new java.awt.Color(255, 255, 255));
        lblIconBackground3.setText("Background 3");
        pnlSetting.add(lblIconBackground3);
        lblIconBackground3.setBounds(60, 360, 110, 30);

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
        lblIconBackground1.setText("Background 1");
        pnlSetting.add(lblIconBackground1);
        lblIconBackground1.setBounds(60, 120, 110, 40);

        lblIconBackground2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblIconBackground2.setForeground(new java.awt.Color(255, 255, 255));
        lblIconBackground2.setText("Background 2");
        pnlSetting.add(lblIconBackground2);
        lblIconBackground2.setBounds(60, 240, 110, 40);

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
        lblBack.setBounds(1090, 560, 70, 70);

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
        new PlayGameFarme(i, mp3CauHoi, mp3Main, this).setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_lblPlayMouseClicked

    private void lblBXHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBXHMouseClicked
        // TODO add your handling code here:
        pnlBxh.setVisible(true);
        lblLogin.setVisible(false);
        showBxhTheoTien();
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
        lblname1.setText("");
        lblname2.setText("");
        lblname3.setText("");
        lblname4.setText("");
        lblname5.setText("");
        lbltien1.setText("");
        lbltien2.setText("");
        lbltien3.setText("");
        lbltien4.setText("");
        lbltien5.setText("");
        lblcau1.setText("");
        lblcau2.setText("");
        lblcau3.setText("");
        lblcau4.setText("");
        lblcau5.setText("");
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

    private void txtNameAccoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameAccoutActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameAccoutActionPerformed

    private void btnAccoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccoutActionPerformed
        // TODO add your handling code here:
        Account();
        pnlAccount.setVisible(false);
        pnlLogin.setVisible(true);
    }//GEN-LAST:event_btnAccoutActionPerformed

    private void btnLoginAccoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginAccoutActionPerformed
        // TODO add your handling code here:
        pnlAccount.setVisible(true);
        pnlLogin.setVisible(false);
    }//GEN-LAST:event_btnLoginAccoutActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        login();
        lblDangXuat.setVisible(true);
        lblLogin.setVisible(false);
    }//GEN-LAST:event_btnLoginActionPerformed

    private void lblDangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDangXuatMouseClicked
        // TODO add your handling code here:
        logoff();
        lblDangXuat.setVisible(false);
        lblLogin.setVisible(true);
    }//GEN-LAST:event_lblDangXuatMouseClicked

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this, "Game Đang Hay Bạn Có Muốn Thoát", "Thong Bao", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowStateChanged

    private void lblTopTienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTopTienMouseClicked
        // TODO add your handling code here:
        showBxhTheoTien();
    }//GEN-LAST:event_lblTopTienMouseClicked

    private void lblTopCauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTopCauMouseClicked
        // TODO add your handling code here:
        showBxhTheoCau();
    }//GEN-LAST:event_lblTopCauMouseClicked

    private void lblBackInsertDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackInsertDataMouseClicked
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(this, "Bạn thật sự muốn thoát", "Thong Bao", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            logoff();
            if (ShareHelper.USER == null) {
                lblLogin.setVisible(true);
                lblDangXuat.setVisible(false);
            }
            pnlInsertDatabase.setVisible(false);
        }
    }//GEN-LAST:event_lblBackInsertDataMouseClicked

    private void btnImportFileExelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportFileExelActionPerformed
        // TODO add your handling code here:
        importFileExel();
    }//GEN-LAST:event_btnImportFileExelActionPerformed

    private void lblBackInsertDataMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackInsertDataMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblBackInsertDataMouseEntered

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        updateTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAllActionPerformed
        // TODO add your handling code here:
        deleteAllQuestion();
    }//GEN-LAST:event_btnDeleteAllActionPerformed

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
    private javax.swing.JTable TblGriView;
    private javax.swing.JButton btnAccout;
    private javax.swing.JButton btnDeleteAll;
    private javax.swing.JButton btnImportFileExel;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLoginAccout;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAccoutPassword;
    private javax.swing.JLabel lblBXH;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblBackDangKi;
    private javax.swing.JLabel lblBackInsertData;
    private javax.swing.JLabel lblBackLogin;
    private javax.swing.JLabel lblBackgroundAccout;
    private javax.swing.JLabel lblBackgroundLoginn;
    private javax.swing.JLabel lblBackgroundMain;
    private javax.swing.JLabel lblBackgroundMain1;
    private javax.swing.JLabel lblBxh1;
    public javax.swing.JLabel lblCaoCaoNhat;
    private javax.swing.JLabel lblDangXuat;
    private javax.swing.JLabel lblDongBXH;
    private javax.swing.JLabel lblHightMoney;
    private javax.swing.JLabel lblHightSentences;
    private javax.swing.JLabel lblIconBackground1;
    private javax.swing.JLabel lblIconBackground2;
    private javax.swing.JLabel lblIconBackground3;
    private javax.swing.JLabel lblIconDangNhap;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblLoginAccout;
    private javax.swing.JLabel lblLoginPassword;
    private javax.swing.JLabel lblLoginUser;
    private javax.swing.JLabel lblOption;
    private javax.swing.JLabel lblPlay;
    private javax.swing.JLabel lblTitleDangKi;
    private javax.swing.JLabel lblTitleThongKe;
    public javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTopCau;
    private javax.swing.JLabel lblTopTien;
    private javax.swing.JLabel lblcau1;
    private javax.swing.JLabel lblcau2;
    private javax.swing.JLabel lblcau3;
    private javax.swing.JLabel lblcau4;
    private javax.swing.JLabel lblcau5;
    private javax.swing.JLabel lblname1;
    private javax.swing.JLabel lblname2;
    private javax.swing.JLabel lblname3;
    private javax.swing.JLabel lblname4;
    private javax.swing.JLabel lblname5;
    private javax.swing.JLabel lbltien1;
    private javax.swing.JLabel lbltien2;
    private javax.swing.JLabel lbltien3;
    private javax.swing.JLabel lbltien4;
    private javax.swing.JLabel lbltien5;
    private javax.swing.JPanel pnlAccount;
    private javax.swing.JPanel pnlBxh;
    private javax.swing.JPanel pnlHome;
    private javax.swing.JPanel pnlInsertDatabase;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlSetting;
    private javax.swing.JTextField txtNameAccout;
    private javax.swing.JPasswordField txtPasswordAccount;
    private javax.swing.JPasswordField txtPasswordLogin;
    private javax.swing.JTextField txtUserLogin;
    // End of variables declaration//GEN-END:variables
}
