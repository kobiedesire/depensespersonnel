/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mae.deper;
import javax.swing.ImageIcon;
import com.mae.vue.InterfaceConnexion;
import javax.swing.JFrame;

/**
 *
 * @author hp
 */
public class Deper {

    public static void main(String[] args) {
         //System.out.println("Hello World!");
        InterfaceConnexion ic = new InterfaceConnexion();
        ic.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
        ic.setVisible(true);
        //ic.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
