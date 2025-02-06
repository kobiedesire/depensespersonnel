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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author hp
 */
public class ConnexionController {

    private static final String querySelectUser = "SELECT * FROM user u, profil p  WHERE u.userNameUser = ? AND p.idProfil = u.idProfil ";

    public static void connexionUser() {
        String pseudo = InterfaceConnexion.login.getText().trim();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        char[] uPass = InterfaceConnexion.password.getPassword();
        String uPassword = new String(uPass);
        String pass = encoder.encode(uPassword);
        int anneB = Integer.parseInt(InterfaceConnexion.exercice.getSelectedItem().toString());
        //  boolean matches = encoder.matches(uPassword, pass);
       // System.out.println(pass);
        // System.out.println(matches);
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectUser)) {
            preparedStatement.setString(1, pseudo);
            // preparedStatement.setString(2, pass);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                String passBD = res.getString("passwordUser");
                boolean matches = encoder.matches(uPassword, passBD);
                //System.out.println(matches);
                
                if (matches == true) {
                    MenuPrincipal m = new MenuPrincipal();
                    m.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
                    m.setVisible(true);
                    m.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    MenuPrincipal.userConnected.setText(res.getString("u.nomUser") + " " + res.getString("u.prenomUser") + " " + "est connecté");
                    
                   // MenuPrincipal.profilID.setText(res.getString("u.idProfil"));
                    //traitement sur les boutons à activer et à désactiver
                    int btnStructure = Integer.parseInt(res.getString("p.permitGestStructure"));
                    if(btnStructure == 0){ MenuPrincipal.menu_structure.setVisible(false);}
                    //
                    int btnCatEchelle = Integer.parseInt(res.getString("p.permitGestCategorie"));
                    if(btnCatEchelle == 0){ MenuPrincipal.menu_catechelle.setVisible(false);}
                    //
                    int btnEmploi = Integer.parseInt(res.getString("p.permitGestEmploi"));
                    if(btnEmploi == 0){ MenuPrincipal.menu_emploi.setVisible(false);}
                    //
                    int btnFocntion = Integer.parseInt(res.getString("p.permitGestFonction"));
                    if(btnFocntion == 0){ MenuPrincipal.menu_fonction.setVisible(false);}
                    //
                    int btnMinistere = Integer.parseInt(res.getString("p.permitGestMinistere"));
                    if(btnMinistere == 0){ MenuPrincipal.menu_ministere.setVisible(false);}
                    //
                    int btnAgent = Integer.parseInt(res.getString("p.permitGestAgent"));
                    if(btnAgent == 0){ MenuPrincipal.menu_agent.setVisible(false);}
                    //
                    int btnBudget = Integer.parseInt(res.getString("p.permitGestBudget"));
                    if(btnBudget == 0){ MenuPrincipal.menu_budget.setVisible(false);}
                    //
                    int btnStatistique= Integer.parseInt(res.getString("p.permitGestStatistique"));
                    if(btnStatistique == 0){ MenuPrincipal.menu__stattistiques.setVisible(false);}
                    //
                    int btnParamAvance= Integer.parseInt(res.getString("p.permitGestParamAvance"));
                    if(btnParamAvance == 0){ MenuPrincipal.menu_paramavance.setVisible(false);}  
                    
                    
                    MenuPrincipal.textExBudgetaire.setText("ANNEE BUDGETAIRE : " +anneB);
                } else {
                    JOptionPane.showMessageDialog(null, "Erreur mot de passe");
                    // JOptionPane.showMessageDialog(null, "Erreur nom d'utilisateur ou mot de passe");
                    InterfaceConnexion ic = new InterfaceConnexion();
                    ic.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
                    ic.setVisible(true);
                }

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
            JOptionPane.showMessageDialog(null, "Erreur SQL (Verifiez les paramètres de connexion à la base de données)" + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    }
}
