/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Paragraphe;
import com.mae.vue.InterfaceParagraphe;
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
public class ParagrapheController {

    private static boolean res, yn;
    private static String tab[][];

    //afficher les programmes
    private static final String querySelectArticle = "SELECT * FROM article";

    public static void listInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectArticle)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceParagraphe.articleBug.addItem(res.getString("codeArticle"));
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
    private static final String querySelectIDArticle = "SELECT idArticle FROM article where codeArticle = ? ";
    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDArticle() {
        String codeAct = InterfaceParagraphe.articleBug.getSelectedItem().toString();
        if (codeAct.contentEquals("Sélectionnez un chapitre")) {
            InterfaceParagraphe.idArti.setText("");
        } else {
            //int exercice = Integer.parseInt(exerB);
            // int exercice = Integer.valueOf(exerB);
            // System.out.println(exerB);
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDArticle)) {
                preparedStatement.setString(1, codeAct);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceParagraphe.idArti.setText(res.getString("idArticle"));
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
    private static final String queryInsert = "INSERT INTO paragraphe(idArticle, codeParagraphe, libeleParagraphe) VALUES (?, ?, ?)";
    public static void saveParagraphe(Paragraphe paragraphe) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setInt(1, paragraphe.getIdArt());
            preparedStatement.setString(2, paragraphe.getCodeP());
            preparedStatement.setString(3, paragraphe.getLibeleP());
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
    private static final String querySelect = "SELECT * FROM article a, paragraphe p WHERE a.idArticle = p.idArticle";
    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][5];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceParagraphe.tableau_paragraphe.getModel();
            while (InterfaceParagraphe.tableau_paragraphe.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (String[] tab1 : tab) {
                res.next();
                Object[] objects = new Object[5];
                objects[0] = res.getString("idParagraphe");
                objects[1] = res.getString("idArticle");
                objects[2] = res.getString("a.codeArticle");
                objects[3] = res.getString("codeParagraphe");
                objects[4] = res.getString("libeleParagraphe");
                tablemodel.addRow(objects);
                tab1[0] = res.getString("idParagraphe");
                tab1[1] = res.getString("idArticle");
                tab1[2] = res.getString("a.codeArticle");
                tab1[3] = res.getString("codeParagraphe");
                tab1[4] = res.getString("libeleParagraphe");
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
    private static final String querySelectOneParagraphe = "SELECT * FROM article a , paragraphe p where p.idParagraphe = ? AND a.idArticle = p.idArticle ";

    public static void displayParagraphe() {
        nbreligne = InterfaceParagraphe.tableau_paragraphe.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceParagraphe.tableau_paragraphe.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceParagraphe.articleBug.setSelectedIndex(0);
            InterfaceParagraphe.codeParagraphe.setText("");
            InterfaceParagraphe.libeleParagraphe.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez un article");
            //System.out.println(nbreligne);
        } else {
            idArti = Integer.parseInt(InterfaceParagraphe.tableau_paragraphe.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneParagraphe)) {
            preparedStatement.setInt(1, idArti);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceParagraphe.articleBug.setSelectedItem(res.getString("a.codeArticle"));
                InterfaceParagraphe.codeParagraphe.setText(res.getString("p.codeParagraphe"));
                InterfaceParagraphe.libeleParagraphe.setText(res.getString("p.libeleParagraphe"));
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
    public static void updateParagraphe(Paragraphe paragraphe) {
        idArti = Integer.parseInt(InterfaceParagraphe.tableau_paragraphe.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE paragraphe SET  idArticle = ?, codeParagraphe= ?, libeleParagraphe = ? WHERE idParagraphe = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setInt(1, paragraphe.getIdArt());
            preparedStatement.setString(2, paragraphe.getCodeP());
            preparedStatement.setString(3, paragraphe.getLibeleP());
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

    public static void deleteParagraphe(Paragraphe paragraphe) {
        idArti = Integer.parseInt(InterfaceParagraphe.tableau_paragraphe.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM paragraphe WHERE idParagraphe = ?";
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
