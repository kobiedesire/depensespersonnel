/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Fonction;
import com.mae.vue.InterfaceFonction;
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
public class FonctionController {

    private static boolean res, yn;
    private static String tab[][];

    /*Enregistrer un Programme*/
    private static final String queryInsert = "INSERT INTO fonction (libeleFonction) VALUES (?)";

    public static void saveFonction(Fonction fonction) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
           
            preparedStatement.setString(1, fonction.getLibeleFonc());
            
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
    private static final String querySelect = "SELECT * FROM fonction ";

    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][2];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceFonction.tableau_fonction.getModel();
            while (InterfaceFonction.tableau_fonction.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[2];
                objects[0] = res.getString("idFonction");
                objects[1] = res.getString("libeleFonction");                
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idFonction");
                tab[k][1] = res.getString("libeleFonction");              
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
    public static int nbreligne, numligne, idF;
    private static final String querySelectOneFonction = "SELECT * FROM fonction WHERE idFonction = ?  ";

    public static void displayFonction() {
        nbreligne = InterfaceFonction.tableau_fonction.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceFonction.tableau_fonction.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
           
            InterfaceFonction.libeleFonct.setText("");
            
            JOptionPane.showMessageDialog(null, " Sélectionnez une fonction");
            //System.out.println(nbreligne);
        } else {
            idF = Integer.parseInt(InterfaceFonction.tableau_fonction.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneFonction)) {
            preparedStatement.setInt(1, idF);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
               
                InterfaceFonction.libeleFonct.setText(res.getString("libeleFonction"));
                
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
    public static void updateFonction(Fonction fonction) {
        idF = Integer.parseInt(InterfaceFonction.tableau_fonction.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE fonction SET  libeleFonction = ? WHERE idFonction= ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setString(1, fonction.getLibeleFonc());            
            preparedStatement.setInt(2, idF);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteFonction(Fonction fonction) {
        idF = Integer.parseInt(InterfaceFonction.tableau_fonction.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM fonction WHERE idFonction = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idF);
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
