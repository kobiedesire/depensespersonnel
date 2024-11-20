/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Ministere;
import com.mae.vue.InterfaceMinistere;
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
public class MinistereController {

    private static boolean res, yn;
    private static String tab[][];  

    /*Enregistrer un Programme*/
    private static final String queryInsert = "INSERT INTO ministere (codeMinistere, libeleMinistere) VALUES (?, ?)";

    public static void saveMinistere(Ministere ministere) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setString(1, ministere.getCodeMin());
            preparedStatement.setString(2, ministere.getLibeleMin());
            
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
    private static final String querySelect = "SELECT * FROM ministere ";

    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][3];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceMinistere.tableau_ministere.getModel();
            while (InterfaceMinistere.tableau_ministere.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[3];
                objects[0] = res.getString("idMinistere");
                objects[1] = res.getString("codeMinistere");  
                objects[2] = res.getString("libeleMinistere");
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idMinistere");
                tab[k][1] = res.getString("codeMinistere"); 
                tab[k][2] = res.getString("libeleMinistere"); 
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
    public static int nbreligne, numligne, idM;
    private static final String querySelectOneMinistere= "SELECT * FROM ministere WHERE idMinistere = ?  ";

    public static void displayMinistere() {
        nbreligne = InterfaceMinistere.tableau_ministere.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceMinistere.tableau_ministere.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
           
            InterfaceMinistere.codeMin.setText("");
            InterfaceMinistere.libeleMin.setText("");
            
            JOptionPane.showMessageDialog(null, " Sélectionnez un emploi");
            //System.out.println(nbreligne);
        } else {
            idM = Integer.parseInt(InterfaceMinistere.tableau_ministere.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneMinistere)) {
            preparedStatement.setInt(1, idM);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
               
                InterfaceMinistere.codeMin.setText(res.getString("codeMinistere"));
                InterfaceMinistere.libeleMin.setText(res.getString("libeleMinistere"));
                
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
    public static void updateMinistere(Ministere ministere) {
        idM = Integer.parseInt(InterfaceMinistere.tableau_ministere.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE ministere SET codeMinistere = ?, libeleMinistere=? WHERE idMinistere= ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setString(1, ministere.getCodeMin()); 
            preparedStatement.setString(2, ministere.getLibeleMin()); 
            preparedStatement.setInt(3, idM);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteMinistere(Ministere ministere) {
        idM = Integer.parseInt(InterfaceMinistere.tableau_ministere.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM ministere WHERE idMinistere = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idM);
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
