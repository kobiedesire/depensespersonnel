/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.vue.InterfaceConnexion;
import com.mae.vue.MenuPrincipal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author hp
 */
public class ConnexionController {
    
    private static final String querySelectUser = "SELECT * FROM user  WHERE userNameUser = ? AND passwordUser = ? ";
    public static void connexionUser(){
        String pseudo = InterfaceConnexion.login.getText().trim();
        String pass = InterfaceConnexion.password.getPassword().toString();
        System.out.println(pass);
    try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectUser)) {
            preparedStatement.setString(1, pseudo);
            preparedStatement.setString(2, pass);
            ResultSet res = preparedStatement.executeQuery();
         if (res.next()) {
            MenuPrincipal m = new MenuPrincipal();
            m.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
            m.setVisible(true);
            m.setExtendedState(JFrame.MAXIMIZED_BOTH);
        } else {
            JOptionPane.showMessageDialog(null, "Erreur nom d'utilisateur ou mot de passe");
            InterfaceConnexion ic = new InterfaceConnexion();
            ic.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
            ic.setVisible(true);

        }
        res.close();
        preparedStatement.close();
        connection.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    
    }
    
        
}
