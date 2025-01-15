/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;
import com.mae.controller.StatAcceuilController;
import com.mae.vue.InterfaceAcceuil;
import com.mae.bd.connexionBD;
import java.sql.*;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.*;

/**
 *
 * @author hp
 */
public class StatAcceuilController {
    //Total des agent du ministère
    private static final String querySelectAgent = "SELECT COUNT(*) AS totalAgent FROM agent";
    public static void totalAgentMin() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAgent)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                //System.out.println(res.getString("totalAgent"));
                InterfaceAcceuil.box_TTAgentMin.setText(res.getString("totalAgent"));            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    }
    
    ///Total des agents à la central
    private static final String querySelectAgentByCentral = "SELECT COUNT(*) AS totalAgentCentral FROM agent a, structure s WHERE a.structureAgent = s.codeStructure AND s.typeStructure = ?";
                                                                                                                            
    public static void totalAgentCentral() {
        String typeS = "Centrale";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAgentByCentral)) {
            preparedStatement.setString(1, typeS);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
               // System.out.println(res.getString("totalAgent"));
                InterfaceAcceuil.box_TTAgentCentral.setText(res.getString("totalAgentCentral"));            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    }
    
       ///Total des agents ambassade,consulat et contratuels 
    private static final String querySelectAgentByMDPC = "SELECT COUNT(*) AS totalAgentMDPC FROM agent a, structure s WHERE a.structureAgent = s.codeStructure AND s.typeStructure IN (?, ?, ?) ";                                                                                                                          
    public static void totalAgentMDPC() {
        String typesAmba = "Ambassade";
        String typesCons = "Consulat";
        String typesMiper = "Mission Permamente";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAgentByMDPC)) {
            preparedStatement.setString(1, typesAmba);
            preparedStatement.setString(2, typesCons);
            preparedStatement.setString(3, typesMiper);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                //System.out.println(res.getString("totalAgent"));
                InterfaceAcceuil.box_TTAgentMDPC.setText(res.getString("totalAgentMDPC"));            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    } 
    
    
    ///Budget Total du Ministere 
    private static final String querySUMMLIGNE = "SELECT SUM(montantLigne) AS totalLigneBudgetaire FROM ligne";

    public static void budgetTotalMin() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySUMMLIGNE)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int totalB = res.getInt("totalLigneBudgetaire") * 12;
                NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);
                //int ttB = formatter.format(totalB)); 
                InterfaceAcceuil.box_BudgetTotalMin.setText(String.valueOf(formatter.format(totalB)) + " " + "FCFA");
                //InterfaceAcceuil.box_BudgetTotalMin.setText(String.valueOf(totalB) + " " + "FCFA");
                //InterfaceAcceuil.box_BudgetTotalMin.setText(res.getString("totalLigneBudgetaire") +" "+ "FCFA");
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
    
        ///Budget Total central
    private static final String queryBudgetAnnuelCentral = "SELECT SUM(incidenceAnnuelle) AS totalBudgetCentral FROM agent a, structure s WHERE  a.structureAgent = s.codeStructure AND s.typeStructure = ?  ";                                                                                                                          
    public static void budgetTotalCentral() {  
        String typeS = "Centrale";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryBudgetAnnuelCentral)) {
            preparedStatement.setString(1, typeS);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                int totalBCentral = res.getInt("totalBudgetCentral");
                NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);
                InterfaceAcceuil.box_TTBudgetCentral.setText(formatter.format(totalBCentral) + " " + "FCFA");
                //InterfaceAcceuil.box_TTBudgetCentral.setText(res.getString("totalBudgetCentral") +" "+ "FCFA");
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
 
    ///Budget Total MDPC
    private static final String queryBudgetAnnuelMDPC = "SELECT SUM(incidenceAnnuelle) AS totalBudgetMDPC FROM agent a, structure s WHERE  a.structureAgent = s.codeStructure AND s.typeStructure IN (?, ?, ?)  ";

    public static void budgetTotalMDPC() {
        String typesAmba = "Ambassade";
        String typesCons = "Consulat";
        String typesMiper = "Mission Permamente";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryBudgetAnnuelMDPC)) {
            preparedStatement.setString(1, typesAmba);
            preparedStatement.setString(2, typesCons);
            preparedStatement.setString(3, typesMiper);
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                  int totalBMDPC = res.getInt("totalBudgetMDPC");
                  NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);
                  InterfaceAcceuil.box_TTBudgetMDPC.setText(formatter.format(totalBMDPC)+ " " + "FCFA");
               // InterfaceAcceuil.box_TTBudgetMDPC.setText(res.getString("totalBudgetMDPC") + " " + "FCFA");
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
}



