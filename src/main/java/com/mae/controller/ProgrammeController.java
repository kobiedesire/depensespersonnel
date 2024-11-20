/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Programme;
import com.mae.vue.InterfaceProgramme;
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
public class ProgrammeController {

    private static boolean res, yn;
    private static String tab[][];
    
    //afficher les budget
    private static final String querySelectBudget = "SELECT * FROM budget";
    public static void listInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectBudget)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceProgramme.exerciceBu.addItem(res.getString("exerciceBudget"));
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
    
    //recuperation de l'id du budget en fonction de la sélection
    private static final String querySelectIDBudget = "SELECT idBudget FROM budget where exerciceBudget = ? ";   
   // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDBudegt() {
         String exerB = InterfaceProgramme.exerciceBu.getSelectedItem().toString();
        if (exerB.contentEquals("Sélectionnez exercice budgétaire")) {
            InterfaceProgramme.idBud.setText("");
        } else {
            //int exercice = Integer.parseInt(exerB);
           // int exercice = Integer.valueOf(exerB);
           // System.out.println(exerB);
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDBudget)) {
            preparedStatement.setString(1, exerB);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceProgramme.idBud.setText(res.getString("idBudget"));
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
    private static final String queryInsert = "INSERT INTO programme (idBudget, codeProgramme, libeleProgramme) VALUES (?, ?, ?)";

    public static void saveProgramme(Programme programme) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setInt(1, programme.getIdB());
            preparedStatement.setString(2, programme.getCodeP());
            preparedStatement.setString(3, programme.getLibeleP());
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
    private static final String querySelect = "SELECT * FROM programme p, budget b where b.idBudget=p.idBudget";
    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][5];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceProgramme.tableau_programme.getModel();
            while (InterfaceProgramme.tableau_programme.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[5];
                objects[0] = res.getString("idProgramme");
                objects[1] = res.getString("idBudget");
                objects[2] = res.getString("b.exerciceBudget");
                objects[3] = res.getString("codeProgramme");
                objects[4] = res.getString("libeleProgramme");
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idProgramme");
                tab[k][1] = res.getString("idBudget");
                tab[k][2] = res.getString("b.exerciceBudget");
                tab[k][3] = res.getString("codeProgramme");
                tab[k][4] = res.getString("libeleProgramme");
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
    public static int nbreligne, numligne, idProg;
    private static final String querySelectOneStructure = "SELECT * FROM programme p, budget b where p.idProgramme = ? AND p.idBudget = b.idBudget ";

    public static void displayProgramme() {
        nbreligne = InterfaceProgramme.tableau_programme.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceProgramme.tableau_programme.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceProgramme.exerciceBu.setSelectedIndex(0);
             InterfaceProgramme.codePr.setText("");
            InterfaceProgramme.libelePr.setText("");
            JOptionPane.showMessageDialog(null, " Sélectionnez une programme");
            //System.out.println(nbreligne);
        } else {
            idProg = Integer.parseInt(InterfaceProgramme.tableau_programme.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneStructure)) {
            preparedStatement.setInt(1, idProg);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceProgramme.exerciceBu.setSelectedItem(res.getString("b.exerciceBudget"));
                InterfaceProgramme.codePr.setText(res.getString("p.codeProgramme"));
                InterfaceProgramme.libelePr.setText(res.getString("p.libeleProgramme"));
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
    public static void updateProgramme(Programme programme) {
        idProg = Integer.parseInt(InterfaceProgramme.tableau_programme.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE programme SET  idBudget = ?, codeProgramme = ?, libeleProgramme = ? WHERE idProgramme = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setInt(1, programme.getIdB());
            preparedStatement.setString(2, programme.getCodeP());
            preparedStatement.setString(3, programme.getLibeleP());
            preparedStatement.setInt(4, idProg);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteProgramme(Programme Programme) {
        idProg = Integer.parseInt(InterfaceProgramme.tableau_programme.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM programme WHERE idProgramme = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idProg);
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
