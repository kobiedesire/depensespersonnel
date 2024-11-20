/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Activite;
import com.mae.vue.InterfaceActivite;
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
public class ActiviteController {

    private static boolean res, yn;
    private static String tab[][];

    //afficher les programmes
    private static final String querySelectChapitre = "SELECT * FROM chapitre";

    public static void listInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectChapitre)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceActivite.chapitreBug.addItem(res.getString("codeChapitre"));
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
    private static final String querySelectIDChapitre = "SELECT idChapitre FROM chapitre where codeChapitre = ? ";
    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDChapitre() {
        String codeAct = InterfaceActivite.chapitreBug.getSelectedItem().toString();
        if (codeAct.contentEquals("Sélectionnez un chapitre")) {
            InterfaceActivite.idChap.setText("");
        } else {
            //int exercice = Integer.parseInt(exerB);
            // int exercice = Integer.valueOf(exerB);
            // System.out.println(exerB);
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDChapitre)) {
                preparedStatement.setString(1, codeAct);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceActivite.idChap.setText(res.getString("idChapitre"));
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
    private static final String queryInsert = "INSERT INTO activite (idChapitre, codeActivite, libeleActivite) VALUES (?, ?, ?)";
    public static void saveActivite(Activite activite) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setInt(1, activite.getIdC());
            preparedStatement.setString(2, activite.getCodeA());
            preparedStatement.setString(3, activite.getLibeleA());
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
    private static final String querySelect = "SELECT * FROM activite a, chapitre c WHERE a.idChapitre = c.idChapitre";
    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][5];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceActivite.tableau_activite.getModel();
            while (InterfaceActivite.tableau_activite.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (String[] tab1 : tab) {
                res.next();
                Object[] objects = new Object[5];
                objects[0] = res.getString("idActivite");
                objects[1] = res.getString("idChapitre");
                objects[2] = res.getString("c.codeChapitre");
                objects[3] = res.getString("codeActivite");
                objects[4] = res.getString("libeleActivite");
                tablemodel.addRow(objects);
                tab1[0] = res.getString("idActivite");
                tab1[1] = res.getString("idChapitre");
                tab1[2] = res.getString("c.codeChapitre");
                tab1[3] = res.getString("codeActivite");
                tab1[4] = res.getString("libeleActivite");
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
    public static int nbreligne, numligne, idActi;
    private static final String querySelectOneActivite = "SELECT * FROM chapitre c , activite a where a.idActivite = ? AND a.idChapitre = c.idChapitre ";

    public static void displayActivite() {
        nbreligne = InterfaceActivite.tableau_activite.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceActivite.tableau_activite.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceActivite.chapitreBug.setSelectedIndex(0);
            InterfaceActivite.codeActivite.setText("");
            InterfaceActivite.libeleActivite.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez une activité");
            //System.out.println(nbreligne);
        } else {
            idActi = Integer.parseInt(InterfaceActivite.tableau_activite.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneActivite)) {
            preparedStatement.setInt(1, idActi);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceActivite.chapitreBug.setSelectedItem(res.getString("c.codeChapitre"));
                InterfaceActivite.codeActivite.setText(res.getString("a.codeActivite"));
                InterfaceActivite.libeleActivite.setText(res.getString("a.libeleActivite"));
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
    public static void updateActivite(Activite activite) {
        idActi = Integer.parseInt(InterfaceActivite.tableau_activite.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE activite SET  idChapitre = ?, codeActivite = ?, libeleActivite = ? WHERE idActivite = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setInt(1, activite.getIdC());
            preparedStatement.setString(2, activite.getCodeA());
            preparedStatement.setString(3, activite.getLibeleA());
            preparedStatement.setInt(4, idActi);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteActivite(Activite activite) {
        idActi = Integer.parseInt(InterfaceActivite.tableau_activite.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM activite WHERE idActivite = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idActi);
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
