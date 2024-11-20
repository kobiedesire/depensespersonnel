/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Budget;
import com.mae.vue.InterfaceBudget;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class BudgetController {

    private static boolean res, yn;
    private static String tab[][];

    /*Enregistrer un budget*/
    private static final String queryInsert = "INSERT INTO budget (exerciceBudget, montantBudget) VALUES (?, ?)";

    public static void saveBudget(Budget budget) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setInt(1, budget.getExerciceB());
            preparedStatement.setLong(2, budget.getMontantB());
           // preparedStatement.executeUpdate();
           int enregistrementValide = preparedStatement.executeUpdate();
            if (enregistrementValide > 0) {
                JOptionPane.showMessageDialog(null, "Excerice budgétaire crée avec succès");
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

    /*Lister tout*/
    private static final String querySelect = "SELECT * FROM budget";
    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][3];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceBudget.tableau_budget.getModel();
            while (InterfaceBudget.tableau_budget.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[3];
                objects[0] = res.getString("idBudget");
                objects[1] = res.getString("exerciceBudget");
                objects[2] = res.getString("montantBudget");
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idBudget");
                tab[k][1] = res.getString("exerciceBudget");
                tab[k][2] = res.getString("montantBudget");
                yn = true;
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
          //  e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur SQL" + e.getMessage());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques" + e.getMessage());
        }
    }
    
    
    // Afficher un budget
    public static int nbreligne, numligne, idBudg;
    private static final String querySelectOneBudget= "SELECT * FROM budget where idBudget = ? ";
    public static void displayBudget() {
        nbreligne = InterfaceBudget.tableau_budget.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceBudget.tableau_budget.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceBudget.exerciceBudg.setText("");
            InterfaceBudget.montantBudg.setText("");
            JOptionPane.showMessageDialog(null, " Sélectionnez un budget");
            //System.out.println(nbreligne);
        } else {
            idBudg = Integer.parseInt(InterfaceBudget.tableau_budget.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneBudget)) {
            preparedStatement.setInt(1, idBudg);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceBudget.exerciceBudg.setText(res.getString("exerciceBudget"));
                InterfaceBudget.montantBudg.setText(res.getString("montantBudget"));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
          //  e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur SQL" + e.getMessage());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques" + e.getMessage());
        }
    }

    //Modifier un budget
   
    public static void updateBudget(Budget budget) {
        idBudg = Integer.parseInt(InterfaceBudget.tableau_budget.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE budget SET exerciceBudget = ? WHERE idBudget = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setInt(1, budget.getExerciceB());           
            preparedStatement.setInt(2, idBudg);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
          //  e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur SQL" + e.getMessage());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques" + e.getMessage());
        }
    }
    
      public static void deleteBudget(Budget budget) {
        idBudg = Integer.parseInt(InterfaceBudget.tableau_budget.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM budget WHERE idBudget = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idBudg);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
          //  e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur SQL" + e.getMessage());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques" + e.getMessage());
        }
    }

}
