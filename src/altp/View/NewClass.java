/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.View;

import altp.DAO.CauHoiDAO;
import altp.HibernateHelper.RanDomHelper;
import entity.CauHoi;
import java.util.List;

/**
 *
 * @author longn
 */
public class NewClass {
    public static void main(String[] args) {
        List<CauHoi> list = CauHoiDAO.layCauHoi(1);
        CauHoi ch = list.get(0);
        System.out.println(ch.getA());
        String A = ch.getA().toString();
        int i = 3;
        if (A != "A") {
            A = "A";
        }
        if (A.equals(ch.getDapAnDung())) {
            RanDomHelper.ranDomInt(i);
            if (i == 1) {

            }
        }
    }
}
