/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package altp.HibernateHelper;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import jaco.mp3.player.MP3Player;
import java.io.File;
import javax.swing.ImageIcon;

/**
 *
 * @author longn
 */
public class ShareHelper {

    public static ImageIcon readLogo(String fileName) {
        File path = new File("/image/", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
    public static MP3Player musicPlayer(String path){
        MP3Player mp3player = new MP3Player(new File(path));
        return mp3player;
    }
}
