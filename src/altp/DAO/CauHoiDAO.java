/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.DAO;

import altp.HibernateHelper.RanDomHelper;
import entity.CauHoi;
import java.sql.Array;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author longn
 */
public class CauHoiDAO {
    public static long soCau(int mach){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select count(*) from CauHoi where maCauHoi = :mach";
        session.beginTransaction();
        Query query = session.createQuery(sql);
        query.setParameter("mach", mach);
        long soCau = (long) query.uniqueResult();
        return soCau;
       
    }
    public static List<CauHoi> layCauHoi(int mach) {
        List<CauHoi> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();

        String sql = "from CauHoi where maCauHoi = :mach and maChiTietCh = :machitietch";
        session.beginTransaction();
        int socau = (int) CauHoiDAO.soCau(mach);
        int machitietch = RanDomHelper.ranDomInt(socau);
        Query query = session.createQuery(sql);
        query.setParameter("mach", mach);
        query.setParameter("machitietch", machitietch);
        list = query.list();
        session.close();
        return list;

    }
    
    
    
    public static boolean insert(CauHoi ch) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(ch);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }

    }

    public static boolean update(CauHoi ch) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.update(ch);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    public static boolean delete(CauHoi ch) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.delete(ch);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

}
