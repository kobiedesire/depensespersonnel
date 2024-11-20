/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Action;
import com.mae.vue.InterfaceAction;
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
public class ActionController {

    private static boolean res, yn;
    private static String tab[][];

    //afficher les programmes
    private static final String querySelectProgramme = "SELECT * FROM programme";

    public static void listInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectProgramme)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceAction.programmeBug.addItem(res.getString("codeProgramme"));
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
    private static final String querySelectIDProgramme = "SELECT idProgramme FROM programme where codeProgramme = ? ";
    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());

    public static void afficherIDAction() {
        String codePr = InterfaceAction.programmeBug.getSelectedItem().toString();
        if (codePr.contentEquals("Sélectionnez programme budgétaire")) {
            InterfaceAction.idProg.setText("");
        } else {
            //int exercice = Integer.parseInt(exerB);
            // int exercice = Integer.valueOf(exerB);
            // System.out.println(exerB);
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDProgramme)) {
                preparedStatement.setString(1, codePr);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceAction.idProg.setText(res.getString("idProgramme"));
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
    private static final String queryInsert = "INSERT INTO action (idProgramme, codeAction, libeleAction) VALUES (?, ?, ?)";

    public static void saveAction(Action action) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setInt(1, action.getIdP());
            preparedStatement.setString(2, action.getCodeA());
            preparedStatement.setString(3, action.getLibeleA());
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
    private static final String querySelect = "SELECT * FROM action a, programme p where a.idProgramme=p.idProgramme";

    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][5];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceAction.tableau_action.getModel();
            while (InterfaceAction.tableau_action.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[5];
                objects[0] = res.getString("idAction");
                objects[1] = res.getString("idProgramme");
                objects[2] = res.getString("p.codeProgramme");
                objects[3] = res.getString("codeAction");
                objects[4] = res.getString("libeleAction");
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idAction");
                tab[k][1] = res.getString("idProgramme");
                tab[k][2] = res.getString("p.codeProgramme");
                tab[k][3] = res.getString("codeAction");
                tab[k][4] = res.getString("libeleAction");
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
    public static int nbreligne, numligne, idAc;
    private static final String querySelectOneAction = "SELECT * FROM programme p, action a where a.idAction = ? AND p.idProgramme = a.idProgramme ";

    public static void displayAction() {
        nbreligne = InterfaceAction.tableau_action.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceAction.tableau_action.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceAction.programmeBug.setSelectedIndex(0);
            InterfaceAction.codeAct.setText("");
            InterfaceAction.libeleAct.setText("");
            JOptionPane.showMessageDialog(null, " Sélectionnez une programme");
            //System.out.println(nbreligne);
        } else {
            idAc = Integer.parseInt(InterfaceAction.tableau_action.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneAction)) {
            preparedStatement.setInt(1, idAc);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceAction.programmeBug.setSelectedItem(res.getString("p.codeProgramme"));
                InterfaceAction.codeAct.setText(res.getString("a.codeAction"));
                InterfaceAction.libeleAct.setText(res.getString("a.libeleAction"));
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
    public static void updateAction(Action action) {
        idAc = Integer.parseInt(InterfaceAction.tableau_action.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE action SET  idProgramme = ?, codeAction = ?, libeleAction = ? WHERE idAction= ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setInt(1, action.getIdP());
            preparedStatement.setString(2, action.getCodeA());
            preparedStatement.setString(3, action.getLibeleA());
            preparedStatement.setInt(4, idAc);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteAction(Action action) {
        idAc = Integer.parseInt(InterfaceAction.tableau_action.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM action WHERE idAction = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idAc);
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
