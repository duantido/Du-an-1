package entity;
// Generated Nov 24, 2019 1:10:14 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CauHoi generated by hbm2java
 */

public class CauHoi  implements java.io.Serializable {


     private int stt;
     private int maCauHoi;
     private String tenCauHoi;
     private int maChiTietCh;
     private String a;
     private String b;
     private String c;
     private String d;
     private String dapAnDung;

    public CauHoi() {
    }

	
    public CauHoi(int stt, int maCauHoi, int maChiTietCh, String dapAnDung) {
        this.stt = stt;
        this.maCauHoi = maCauHoi;
        this.maChiTietCh = maChiTietCh;
        this.dapAnDung = dapAnDung;
    }
    public CauHoi(int stt, int maCauHoi, String tenCauHoi, int maChiTietCh, String a, String b, String c, String d, String dapAnDung) {
       this.stt = stt;
       this.maCauHoi = maCauHoi;
       this.tenCauHoi = tenCauHoi;
       this.maChiTietCh = maChiTietCh;
       this.a = a;
       this.b = b;
       this.c = c;
       this.d = d;
       this.dapAnDung = dapAnDung;
    }
 
    public int getStt() {
        return this.stt;
    }
    
    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getMaCauHoi() {
        return this.maCauHoi;
    }
    
    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    
    public Serializable getTenCauHoi() {
        return this.tenCauHoi;
    }
    
    public void setTenCauHoi(String tenCauHoi) {
        this.tenCauHoi = tenCauHoi;
    }

    public int getMaChiTietCh() {
        return this.maChiTietCh;
    }
    
    public void setMaChiTietCh(int maChiTietCh) {
        this.maChiTietCh = maChiTietCh;
    }


    public Serializable getA() {
        return this.a;
    }
    
    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return this.b;
    }
    
    public void setB(String b) {
        this.b = b;
    }


    public String getC() {
        return this.c;
    }
    
    public void setC(String c) {
        this.c = c;
    }

    
    public String getD() {
        return this.d;
    }
    
    public void setD(String d) {
        this.d = d;
    }

    
    public String getDapAnDung() {
        return this.dapAnDung;
    }
    
    public void setDapAnDung(String dapAnDung) {
        this.dapAnDung = dapAnDung;
    }




}


