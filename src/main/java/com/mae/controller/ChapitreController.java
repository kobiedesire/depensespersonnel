/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Chapitre;
import com.mae.vue.InterfaceChapitre;
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
public class ChapitreController {

    private static boolean res, yn;
    private static String tab[][];

    //afficher les programmes
    private static final String querySelectAction = "SELECT * FROM action";

    public static void listInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAction)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceChapitre.actionBug.addItem(res.getString("codeAction"));
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
    private static final String querySelectIDAction = "SELECT idAction FROM action where codeAction = ? ";
    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDAction() {
        String codeAct = InterfaceChapitre.actionBug.getSelectedItem().toString();
        if (codeAct.contentEquals("Sélectionnez une action")) {
            InterfaceChapitre.idAc.setText("");
        } else {
            //int exercice = Integer.parseInt(exerB);
            // int exercice = Integer.valueOf(exerB);
            // System.out.println(exerB);
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDAction)) {
                preparedStatement.setString(1, codeAct);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceChapitre.idAc.setText(res.getString("idAction"));
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
    private static final String queryInsert = "INSERT INTO chapitre(idAction, codeChapitre, libeleChapitre) VALUES (?, ?, ?)";
    public static void saveChapitre(Chapitre chapitre) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setInt(1, chapitre.getIdA());
            preparedStatement.setString(2, chapitre.getCodeC());
            preparedStatement.setString(3, chapitre.getLibeleC());
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
    private static final String querySelect = "SELECT * FROM action a, chapitre c where a.idAction=c.idAction";
    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][5];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceChapitre.tableau_chapitre.getModel();
            while (InterfaceChapitre.tableau_chapitre.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (String[] tab1 : tab) {
                res.next();
                Object[] objects = new Object[5];
                objects[0] = res.getString("idChapitre");
                objects[1] = res.getString("idAction");
                objects[2] = res.getString("a.codeAction");
                objects[3] = res.getString("codeChapitre");
                objects[4] = res.getString("libeleChapitre");
                tablemodel.addRow(objects);
                tab1[0] = res.getString("idChapitre");
                tab1[1] = res.getString("idAction");
                tab1[2] = res.getString("a.codeAction");
                tab1[3] = res.getString("codeChapitre");
                tab1[4] = res.getString("libeleChapitre");
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
    public static int nbreligne, numligne, idCha;
    private static final String querySelectOneChapitre = "SELECT * FROM chapitre c, action a where c.idChapitre = ? AND a.idAction = c.idAction ";

    public static void displayChapitre() {
        nbreligne = InterfaceChapitre.tableau_chapitre.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceChapitre.tableau_chapitre.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceChapitre.actionBug.setSelectedIndex(0);
            InterfaceChapitre.codeChap.setText("");
            InterfaceChapitre.libeleChap.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez une action");
            //System.out.println(nbreligne);
        } else {
            idCha = Integer.parseInt(InterfaceChapitre.tableau_chapitre.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneChapitre)) {
            preparedStatement.setInt(1, idCha);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceChapitre.actionBug.setSelectedItem(res.getString("a.codeAction"));
                InterfaceChapitre.codeChap.setText(res.getString("c.codeChapitre"));
                InterfaceChapitre.libeleChap.setText(res.getString("c.libeleChapitre"));
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
    public static void updateChapitre(Chapitre chapitre) {
        idCha = Integer.parseInt(InterfaceChapitre.tableau_chapitre.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE chapitre SET  idAction = ?, codeChapitre = ?, libeleChapitre = ? WHERE idChapitre = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setInt(1, chapitre.getIdA());
            preparedStatement.setString(2, chapitre.getCodeC());
            preparedStatement.setString(3, chapitre.getLibeleC());
            preparedStatement.setInt(4, idCha);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteChapitre(Chapitre chapitre) {
        idCha = Integer.parseInt(InterfaceChapitre.tableau_chapitre.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM chapitre WHERE idChapitre = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idCha);
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
