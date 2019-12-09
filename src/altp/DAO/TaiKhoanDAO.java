/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.DAO;

import entity.CauHoi;
import entity.TaiKhoan;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author longn
 */
public class TaiKhoanDAO {

    public static List<TaiKhoan> layTaiKhoan(String name, String pass) {
        try {
            List<TaiKhoan> list = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            String sql = "from TaiKhoan where tenDangNhap = :name and matKhau = :pass";
            session.beginTransaction();
            Query query = session.createQuery(sql);
            query.setParameter("name", name);
            query.setParameter("pass", pass);
            list = query.list();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static List<TaiKhoan> layDsTaiKhoan() {
        try {
            List<TaiKhoan> list = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            String sql = "from TaiKhoan";
            session.beginTransaction();
            Query query = session.createQuery(sql);
            list = query.list();
            session.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public static List<TaiKhoan> layBxhTien(){
        List<TaiKhoan> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from TaiKhoan tk order by tien desc";
        session.beginTransaction();
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }
     public static List<TaiKhoan> layBxhCau(){
        List<TaiKhoan> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from TaiKhoan tk order by soCau desc";
        session.beginTransaction();
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }
    public static TaiKhoan findByTaiKhoan(String tendn) {
        Session session = HibernateUtil.getSessionFactory().openSession();
       
            session.beginTransaction();
            TaiKhoan tk = (TaiKhoan) session.get(TaiKhoan.class, tendn);
            session.close();
            return tk;
       
    }

    public boolean insert(TaiKhoan tk) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            session.save(tk);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }

    }

    public boolean update(TaiKhoan tk) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.update(tk);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(TaiKhoan tk) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.delete(tk);
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
