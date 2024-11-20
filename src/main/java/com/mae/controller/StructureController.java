/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Structure;
import com.mae.vue.InterfaceStructure;
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
public class StructureController {
 
    //Charger les programmes dans le combo
    private static final String querySelectCategorieEchelle = "SELECT * FROM programme";

    public static void listProgrammeInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectCategorieEchelle)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceStructure.programmeStruc.addItem(res.getString("codeProgramme"));
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

    public static void afficherIDProgramme() {
        String codePr = InterfaceStructure.programmeStruc.getSelectedItem().toString();
        if (codePr.contentEquals(" ")) {
            InterfaceStructure.idProg.setText("");
        } else {
            //int exercice = Integer.parseInt(exerB);
            // int exercice = Integer.valueOf(exerB);
            // System.out.println(exerB);
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDProgramme)) {
                preparedStatement.setString(1, codePr);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceStructure.idProg.setText(res.getString("idProgramme"));
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

    private static boolean res, yn;
    private static String tab[][];

    /*Enregistrer une structure*/
    private static final String queryInsert = "INSERT INTO structure (idProgramme, codeStructure, typeStructure, libeleStructure) VALUES (?, ?, ?, ?)";
    public static void saveStructure(Structure structure) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setInt(1, structure.getIdP());
            preparedStatement.setString(2, structure.getCodeS());
            preparedStatement.setString(3, structure.getTypeS());
            preparedStatement.setString(4, structure.getLibeleS());
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

    /*Lister toutes les structures*/
    private static final String querySelect = "SELECT * FROM structure s, programme p WHERE s.idProgramme = p.idProgramme ORDER BY p.codeProgramme ASC";

    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
                 
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][5];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStructure.tableau_structure.getModel();
            while (InterfaceStructure.tableau_structure.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[5];
                objects[0] = res.getString("idStructure");
                objects[1] = res.getString("p.codeProgramme");
                objects[2] = res.getString("codeStructure");
                objects[3] = res.getString("typeStructure");
                objects[4] = res.getString("libeleStructure");
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idStructure");
                tab[k][1] = res.getString("p.codeProgramme");
                tab[k][2] = res.getString("codeStructure");
                tab[k][3] = res.getString("typeStructure");
                tab[k][4] = res.getString("libeleStructure");
                yn = true;
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL"+ e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    }

    // Afficher une structure
    public static int nbreligne, numligne, idStruc;
    private static final String querySelectOneStructure = "SELECT * FROM structure s, programme p where idStructure = ? AND s.idProgramme = p.idProgramme";

    public static void displayStructure() {
        nbreligne = InterfaceStructure.tableau_structure.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceStructure.tableau_structure.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceStructure.typeStr.setSelectedIndex(0);
            InterfaceStructure.programmeStruc.setSelectedIndex(0);
            InterfaceStructure.libeleStr.setText("");
            InterfaceStructure.idProg.setText("");
            JOptionPane.showMessageDialog(null, " Sélectionnez une structure");
            //System.out.println(nbreligne);
        } else {
            idStruc = Integer.parseInt(InterfaceStructure.tableau_structure.getValueAt(numligne, 0).toString());   //recuperer l'id     
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneStructure)) {
                preparedStatement.setInt(1, idStruc);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceStructure.typeStr.setSelectedItem(res.getString("typeStructure"));
                    InterfaceStructure.programmeStruc.setSelectedItem(res.getString("p.codeProgramme"));
                    InterfaceStructure.codeStr.setText(res.getString("codeStructure"));
                    InterfaceStructure.libeleStr.setText(res.getString("libeleStructure"));
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

    //Modifier une structure
    public static void updateStructure(Structure structure) {
        idStruc = Integer.parseInt(InterfaceStructure.tableau_structure.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE structure SET  idProgramme = ?, codeStructure = ?, typeStructure = ?, libeleStructure = ? WHERE idStructure = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setInt(1, structure.getIdP());
            preparedStatement.setString(2, structure.getCodeS());           
            preparedStatement.setString(3, structure.getTypeS());
            preparedStatement.setString(4, structure.getLibeleS());
            preparedStatement.setInt(5, idStruc);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

    public static void deleteStructure(Structure structure) {
        idStruc = Integer.parseInt(InterfaceStructure.tableau_structure.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM structure WHERE idStructure = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idStruc);
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
