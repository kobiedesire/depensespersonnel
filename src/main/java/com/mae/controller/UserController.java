/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.User;
import com.mae.vue.InterfaceReinitialiserPassword;
import com.mae.vue.InterfaceUser;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class UserController {

    private static boolean res, yn;
    private static String tab[][];

    //afficher les programmes
    private static final String querySelectProfil= "SELECT * FROM profil";

    public static void listInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectProfil)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceUser.profilU.addItem(res.getString("libeleProfil"));
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

    //recuperation de l'id du profil en fonction de la sélection
    private static final String querySelectIDProfil = "SELECT idProfil FROM profil where libeleProfil = ? ";
    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());

    public static void afficherIDProfil() {
        String profil = InterfaceUser.profilU.getSelectedItem().toString().trim();
        if (profil.isBlank()) {
            InterfaceUser.idP.setText("");
        } else {
            //int exercice = Integer.parseInt(exerB);
            // int exercice = Integer.valueOf(exerB);
            // System.out.println(exerB);
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDProfil)) {
                preparedStatement.setString(1, profil);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceUser.idP.setText(res.getString("idProfil"));
                    //System.out.println(res.getString("idBudget"));
                }
                preparedStatement.close();
                res.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
            }
        }
    }

    /*Enregistrer un Programme*/
    private static final String queryInsert = "INSERT INTO user (idProfil, nomUser, prenomUser,userNameUser, passwordUser ) VALUES (?, ?, ?, ?, ?)";

    public static void saveUser(User user) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setInt(1, user.getIdP());
            preparedStatement.setString(2, user.getNomU());
            preparedStatement.setString(3, user.getPrenomU());
            preparedStatement.setString(4, user.getUserNameU());
            preparedStatement.setString(5, user.getPasswordU());
            // preparedStatement.executeUpdate();
            int enregistrementValide = preparedStatement.executeUpdate();
            if (enregistrementValide > 0) {
                JOptionPane.showMessageDialog(null, "Enregistrement validé");
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            //  e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur SQL" + e.getMessage());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques" + e.getMessage());
        }
    }

    /*Lister toutes les Programmes*/
    private static final String querySelect = "SELECT * FROM profil p, user u where p.idProfil = u.idProfil";

    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][6];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceUser.tableau_user.getModel();
            while (InterfaceUser.tableau_user.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[6];
                objects[0] = res.getString("idUser");
                objects[1] = res.getString("u.idProfil");
                objects[2] = res.getString("u.nomUser");
                objects[3] = res.getString("u.prenomUser");
                objects[4] = res.getString("u.userNameUser");
                objects[5] = res.getString("p.libeleProfil");
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idUser");
                tab[k][1] = res.getString("u.idProfil");
                tab[k][2] = res.getString("u.nomUser");
                tab[k][3] = res.getString("u.prenomUser");
                tab[k][4] = res.getString("u.userNameUser");
                 tab[k][5] = res.getString("p.libeleProfil");
                yn = true;
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

    // Afficher un utilisateur
    public static int nbreligne, numligne, idUs;
    private static final String querySelectOneuser = "SELECT * FROM profil p, user u  where u.idUser = ? AND p.idProfil = u.idProfil ";
    public static void displayUser() {
        nbreligne = InterfaceUser.tableau_user.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceUser.tableau_user.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceUser.profilU.setSelectedIndex(0);
            InterfaceUser.nomU.setText("");
            InterfaceUser.prenomU.setText("");
            InterfaceUser.usernameU.setText("");
            InterfaceUser.idU.setText("");
            JOptionPane.showMessageDialog(null, " Sélectionnez un utilisateur");
            //System.out.println(nbreligne);
        } else {
            idUs = Integer.parseInt(InterfaceUser.tableau_user.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneuser)) {
            preparedStatement.setInt(1, idUs);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceUser.profilU.setSelectedItem(res.getString("p.libeleProfil"));
                InterfaceUser.nomU.setText(res.getString("u.nomUser"));
                InterfaceUser.prenomU.setText(res.getString("u.prenomUser"));
                InterfaceUser.usernameU.setText(res.getString("u.userNameUser"));
                InterfaceUser.idU.setText(res.getString("u.idUser"));
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

    //Modifier un utilisateur
    public static void updateUser(User user) {
        idUs = Integer.parseInt(InterfaceUser.tableau_user.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE user SET  idProfil = ?, nomUser = ?, prenomUser = ?, userNameUser = ? WHERE idUser = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setInt(1, user.getIdP());
            preparedStatement.setString(2, user.getNomU());
            preparedStatement.setString(3, user.getPrenomU());
            preparedStatement.setString(4, user.getUserNameU());
            preparedStatement.setInt(5, idUs);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteUser(User user) {
        idUs = Integer.parseInt(InterfaceUser.tableau_user.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM user WHERE idUser = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idUs);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    }
    
    
    
      public static void afficherInterfaceResetPassword() {
        if (InterfaceUser.idU.getText().trim().isBlank()) {
            InterfaceUser.idU.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez un utilisateur.");
        } else {
            int idUse = Integer.parseInt(InterfaceUser.idU.getText());
             System.out.println(idUse);
            InterfaceReinitialiserPassword resetPass = new InterfaceReinitialiserPassword(new javax.swing.JFrame(), true);
            resetPass.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
            resetPass.iduser.setValue(idUse);
            resetPass.setVisible(true);
        }
    }

       public static void updatePasswordUser(User user) {
        idUs = Integer.parseInt(InterfaceReinitialiserPassword.iduser.getText().trim());  //recuperer l'id 
        String queryUpdate = "UPDATE user SET  passwordUser = ? WHERE idUser = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setString(1, user.getPasswordU());            
            preparedStatement.setInt(2, idUs);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

}
