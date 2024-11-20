/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.CategorieEchelle;
import com.mae.vue.InterfaceCategorieEchelle;
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
public class CategorieEchelleController {

    private static boolean res, yn;
    private static String tab[][];
   
    /*Enregistrer un Programme*/
    private static final String queryInsert = "INSERT INTO categorie ( codeCategorieEchelle) VALUES (?)";

    public static void saveCategorieEchelle(CategorieEchelle categorieechelle) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
           
            preparedStatement.setString(1, categorieechelle.getCodeCatEch());
            
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
    private static final String querySelect = "SELECT * FROM categorie ";

    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][2];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceCategorieEchelle.tableau_categorie.getModel();
            while (InterfaceCategorieEchelle.tableau_categorie.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[2];
                objects[0] = res.getString("idCategorieEchelle");
                objects[1] = res.getString("codeCategorieEchelle");                
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idCategorieEchelle");
                tab[k][1] = res.getString("codeCategorieEchelle");              
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
    public static int nbreligne, numligne, idC;
    private static final String querySelectOneCategorie = "SELECT * FROM categorie WHERE idCategorieEchelle = ?  ";

    public static void displayCategorieEchelle() {
        nbreligne = InterfaceCategorieEchelle.tableau_categorie.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceCategorieEchelle.tableau_categorie.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
           
            InterfaceCategorieEchelle.codeCateEch.setText("");
            
            JOptionPane.showMessageDialog(null, " Sélectionnez une catégorie");
            //System.out.println(nbreligne);
        } else {
            idC = Integer.parseInt(InterfaceCategorieEchelle.tableau_categorie.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneCategorie)) {
            preparedStatement.setInt(1, idC);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
               
                InterfaceCategorieEchelle.codeCateEch.setText(res.getString("codeCategorieEchelle"));
                
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
    public static void updateCategorieEchelle(CategorieEchelle categorieechelle) {
        idC = Integer.parseInt(InterfaceCategorieEchelle.tableau_categorie.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE categorie SET  codeCategorieEchelle = ? WHERE idCategorieEchelle= ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setString(1, categorieechelle.getCodeCatEch());            
            preparedStatement.setInt(2, idC);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteCategorieEchelle(CategorieEchelle categorieechelle) {
        idC = Integer.parseInt(InterfaceCategorieEchelle.tableau_categorie.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM categorie WHERE idCategorieEchelle = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idC);
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
