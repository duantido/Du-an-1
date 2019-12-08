/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.View;

import altp.DAO.TaiKhoanDAO;
import entity.TaiKhoan;
import java.util.List;

/**
 *
 * @author longn
 */
public class NewClass {
    public static void main(String[] args) {
        List<TaiKhoan> list = TaiKhoanDAO.layBxhCau();
        
    }
}
