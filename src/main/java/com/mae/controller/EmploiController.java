/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Emploi;
import com.mae.vue.InterfaceEmploi;
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
public class EmploiController {

    private static boolean res, yn;
    private static String tab[][];

    /*Enregistrer un Programme*/
    private static final String queryInsert = "INSERT INTO emploi (codeEmploi, libeleEmploi) VALUES (?, ?)";
    public static void saveEmploi(Emploi emploi) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setString(1, emploi.getCodeEmpl());
            preparedStatement.setString(2, emploi.getLibleEmpl());
            
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

    /*Lister tous les emplois*/
    private static final String querySelect = "SELECT * FROM emploi ";
    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][3];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceEmploi.tableau_emploi.getModel();
            while (InterfaceEmploi.tableau_emploi.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[3];
                objects[0] = res.getString("idEmploi");
                objects[1] = res.getString("codeEmploi");  
                objects[2] = res.getString("libeleEmploi");
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idEmploi");
                tab[k][1] = res.getString("codeEmploi"); 
                tab[k][2] = res.getString("libeleEmploi"); 
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

    // Afficher une Programme
    public static int nbreligne, numligne, idE;
    private static final String querySelectOneEmploi = "SELECT * FROM emploi WHERE idEmploi = ?  ";

    public static void displayEmploi() {
        nbreligne = InterfaceEmploi.tableau_emploi.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceEmploi.tableau_emploi.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
           
            InterfaceEmploi.codeEmpl.setText("");
            InterfaceEmploi.libeleEmpl.setText("");
            
            JOptionPane.showMessageDialog(null, " Sélectionnez un emploi");
            //System.out.println(nbreligne);
        } else {
            idE = Integer.parseInt(InterfaceEmploi.tableau_emploi.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneEmploi)) {
            preparedStatement.setInt(1, idE);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
               
                InterfaceEmploi.codeEmpl.setText(res.getString("codeEmploi"));
                InterfaceEmploi.libeleEmpl.setText(res.getString("libeleEmploi"));
                
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

    //Modifier une Programme
    public static void updateEmploi(Emploi emploi) {
        idE = Integer.parseInt(InterfaceEmploi.tableau_emploi.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE emploi SET  codeEmploi = ?, libeleEmploi=? WHERE idEmploi= ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setString(1, emploi.getCodeEmpl()); 
            preparedStatement.setString(2, emploi.getLibleEmpl()); 
            preparedStatement.setInt(3, idE);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteEmploi(Emploi emploi) {
        idE = Integer.parseInt(InterfaceEmploi.tableau_emploi.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM emploi WHERE idEmploi = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idE);
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
