/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.DAO;

import altp.HibernateHelper.RanDomHelper;
import entity.CauHoi;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import org.hibernate.Query;

import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author longn
 */
public class CauHoiDAO extends JDBCConnection implements UserDao {

    public static List<CauHoi> fillCauHoi() {
        List<CauHoi> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM CauHoi";
        Query query = session.createQuery(hql);
        list = query.list();
        session.close();
        return list;
    }
    public static CauHoi layCauHoi(int mach) {
        List<CauHoi> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from CauHoi where maCauHoi = :mach";
        session.beginTransaction();
        Query query = session.createQuery(sql);
        query.setParameter("mach", mach);
        list = query.list();
        int random = RanDomHelper.ranDomInt(list.size());
        CauHoi ch = list.get(random);
        return ch;
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

    @Override
    public List<CauHoi> select() {
        return null;
    }
    
    @Override
    public void add(CauHoi user) {
        String sql = "INSERT INTO CauHoi(MaCauHoi,TenCauHoi,MaChiTietCH,A,B,C,D,DapAnDung) VALUES(?,?,?,?,?,?,?,?)";
        Connection conn = super.getJDBCConnection();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, user.getMaCauHoi());
            preparedStatement.setString(2, user.getTenCauHoi() + "");
            preparedStatement.setInt(3, user.getMaChiTietCh());
            preparedStatement.setString(4, user.getA() + "");
            preparedStatement.setString(5, user.getB());
            preparedStatement.setString(6, user.getC());
            preparedStatement.setString(7, user.getD());
            preparedStatement.setString(8, user.getDapAnDung());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
