/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Article;
import com.mae.vue.InterfaceArticle;
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
public class ArticleController {

    private static boolean res, yn;
    private static String tab[][];

    //afficher les programmes
    private static final String querySelectActivite = "SELECT * FROM activite";

    public static void listInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectActivite)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceArticle.activiteBug.addItem(res.getString("codeActivite"));
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

    //recuperation de l'id du programme en fonction de la sélection
    private static final String querySelectIDActivite = "SELECT idActivite FROM activite where codeActivite = ? ";
    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDActivite() {
        String codeAct = InterfaceArticle.activiteBug.getSelectedItem().toString();
        if (codeAct.contentEquals("Sélectionnez une activité")) {
            InterfaceArticle.idActivi.setText("");
        } else {
            //int exercice = Integer.parseInt(exerB);
            // int exercice = Integer.valueOf(exerB);
            // System.out.println(exerB);
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDActivite)) {
                preparedStatement.setString(1, codeAct);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceArticle.idActivi.setText(res.getString("idActivite"));
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
    private static final String queryInsert = "INSERT INTO article (idActivite, codeArticle, libeleArticle) VALUES (?, ?, ?)";
    public static void saveArticle(Article article) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setInt(1, article.getIdA());
            preparedStatement.setString(2, article.getCodeArt());
            preparedStatement.setString(3, article.getLibeleArt());
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
    private static final String querySelect = "SELECT * FROM article a, activite c WHERE a.idActivite = c.idActivite";
    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][5];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceArticle.tableau_article.getModel();
            while (InterfaceArticle.tableau_article.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (String[] tab1 : tab) {
                res.next();
                Object[] objects = new Object[5];
                objects[0] = res.getString("idArticle");
                objects[1] = res.getString("idActivite");
                objects[2] = res.getString("c.codeActivite");
                objects[3] = res.getString("codeArticle");
                objects[4] = res.getString("libeleArticle");
                tablemodel.addRow(objects);
                tab1[0] = res.getString("idArticle");
                tab1[1] = res.getString("idActivite");
                tab1[2] = res.getString("c.codeActivite");
                tab1[3] = res.getString("codeArticle");
                tab1[4] = res.getString("libeleArticle");
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
    public static int nbreligne, numligne, idArti;
    private static final String querySelectOneArticle = "SELECT * FROM article c , activite a where c.idArticle = ? AND a.idActivite = c.idActivite ";

    public static void displayArticle() {
        nbreligne = InterfaceArticle.tableau_article.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceArticle.tableau_article.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceArticle.activiteBug.setSelectedIndex(0);
            InterfaceArticle.codeArticle.setText("");
            InterfaceArticle.libeleArticle.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez un article");
            //System.out.println(nbreligne);
        } else {
            idArti = Integer.parseInt(InterfaceArticle.tableau_article.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneArticle)) {
            preparedStatement.setInt(1, idArti);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceArticle.activiteBug.setSelectedItem(res.getString("a.codeActivite"));
                InterfaceArticle.codeArticle.setText(res.getString("c.codeArticle"));
                InterfaceArticle.libeleArticle.setText(res.getString("c.libeleArticle"));
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
    public static void updateArticle(Article article) {
        idArti = Integer.parseInt(InterfaceArticle.tableau_article.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE article SET  idActivite = ?, codeArticle= ?, libeleArticle = ? WHERE idArticle = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setInt(1, article.getIdA());
            preparedStatement.setString(2, article.getCodeArt());
            preparedStatement.setString(3, article.getLibeleArt());
            preparedStatement.setInt(4, idArti);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteArticle(Article article) {
        idArti = Integer.parseInt(InterfaceArticle.tableau_article.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM article WHERE idArticle = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idArti);
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
