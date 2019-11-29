/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.HibernateHelper;

import java.util.Random;

/**
 *
 * @author longn
 */
public class RanDomHelper {
    public static int ranDomInt(int so){
        Random rd = new Random();
        int number = rd.nextInt(so);
        return number;
    }
    public static boolean ranDomBoolean(){
        Random rd = new Random();
        boolean bl = rd.nextBoolean();
        return bl;
    }
}
