/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.vue.InterfaceStatistiqueBudget;
import java.awt.ComponentOrientation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author hp
 */
public class StatBudgetController {

    private static boolean res, yn;
    private static String tab[][];

    /*Lister tous les agents Central + MDCPC*/
    private static final String querySelectAllAgent = "SELECT idAgent, matriculeAgent, nomAgent, prenomAgent, structureAgent, typeAgent,incidenceMensuelle, incidenceAnnuelle  FROM agent ";

    public static void listAllAgent() {
        //String typeA = InterfaceAgent.comboTypeAgent.getSelectedItem().toString();
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAllAgent)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][8];
            InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText(String.valueOf(res.getRow()));
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
            
            while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);
            DecimalFormat df = new DecimalFormat("#,###.00");
            //NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[8];
                objects[0] = res.getString("idAgent");
                objects[1] = res.getString("matriculeAgent");
                objects[2] = res.getString("nomAgent");
                objects[3] = res.getString("prenomAgent");
                objects[4] = res.getString("structureAgent");
                objects[5] = res.getString("typeAgent");
                objects[6] = res.getString("incidenceMensuelle");
                objects[7] = res.getString("incidenceAnnuelle");
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idAgent");
                tab[k][1] = res.getString("matriculeAgent");
                tab[k][2] = res.getString("nomAgent");
                tab[k][3] = res.getString("prenomAgent");
                tab[k][4] = res.getString("structureAgent");
                tab[k][5] = res.getString("typeAgent");
                tab[k][6] = res.getString("incidenceMensuelle");
                tab[k][7] = res.getString("incidenceAnnuelle") ;
                yn = true;
                //System.out.println(res.getString("incidenceAnnuelle"));
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

    // rechercheret afficher un agent par le matricule    
    private static final String querySelectOneAgentByMatricule = "SELECT * FROM agent WHERE matriculeAgent = ? ";

    public static void rechercheAgentByMatricule() {
        String matriculeA = InterfaceStatistiqueBudget.box_rechercheMatricule.getText().trim();
        //numligne = InterfaceAction.tableau_action.getSelectedRow();//recuperer le le numero de la ligne
        if (matriculeA.isBlank()) {
            JOptionPane.showMessageDialog(null, "Saisir un matricule !! ");
            InterfaceStatistiqueBudget.tableau_agent.removeAll();
            InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
            //System.out.println(nbreligne);
        } else {
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneAgentByMatricule)) {
                preparedStatement.setString(1, matriculeA);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    res.last();
                    tab = new String[res.getRow()][8];
                    InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText(String.valueOf(res.getRow()));
                    res.beforeFirst();
                    yn = false;
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                    }
                    for (int k = 0; k < tab.length; k++) {
                        res.next();
                        Object[] objects = new Object[8];
                        objects[0] = res.getString("idAgent");
                        objects[1] = res.getString("matriculeAgent");
                        objects[2] = res.getString("nomAgent");
                        objects[3] = res.getString("prenomAgent");
                        objects[4] = res.getString("structureAgent");
                        objects[5] = res.getString("typeAgent");
                        objects[6] = res.getString("incidenceMensuelle");
                        objects[7] = res.getString("incidenceAnnuelle");
                        tablemodel.addRow(objects);
                        tab[k][0] = res.getString("idAgent");
                        tab[k][1] = res.getString("matriculeAgent");
                        tab[k][2] = res.getString("nomAgent");
                        tab[k][3] = res.getString("prenomAgent");
                        tab[k][4] = res.getString("structureAgent");
                        tab[k][5] = res.getString("typeAgent");
                        tab[k][6] = res.getString("incidenceMensuelle");
                        tab[k][7] = res.getString("incidenceAnnuelle");
                        yn = true;
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Saisir un matricule valide !! ");
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                        InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
                    }
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

    //exporter en excel
    public static void exportExcel() {
        // Créateur du sélecteur de fichier
        JFileChooser selecteurFichier = new JFileChooser();
        selecteurFichier.setDialogTitle("Sélectionner un emplacement");

        int maSelection = selecteurFichier.showSaveDialog(null);
        if (maSelection == JFileChooser.APPROVE_OPTION) {
            try (Workbook workbook = new XSSFWorkbook()) {
                //creation d'une feuille
                Sheet sheet = workbook.createSheet("Données");

                // Écrire les en-têtes
                TableModel model = InterfaceStatistiqueBudget.tableau_agent.getModel();
                Row headerRow = sheet.createRow(0);
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Cell cell = headerRow.createCell(col);
                    cell.setCellValue(model.getColumnName(col));
                }

                // Écrire les données
                for (int row = 0; row < model.getRowCount(); row++) {
                    Row excelRow = sheet.createRow(row + 1);
                    for (int col = 0; col < model.getColumnCount(); col++) {
                        Cell cell = excelRow.createCell(col);
                        Object value = model.getValueAt(row, col);
                        cell.setCellValue(value != null ? value.toString() : "");
                    }
                }

                // Sauvegarder le fichier
                try (FileOutputStream fileOut = new FileOutputStream(selecteurFichier.getSelectedFile() + ".xlsx")) {
                    workbook.write(fileOut);
                }

                JOptionPane.showMessageDialog(null, "Données exportées avec succès !");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Erreur lors de l'exportation : " + e.getMessage());
            }

        }
    }

    //Afficher les categories dans le combo
    private static final String querySelectCategorieEchelle = "SELECT * FROM categorie";

    public static void listCategorieInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectCategorieEchelle)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceStatistiqueBudget.combo_Categorie.addItem(res.getString("codeCategorieEchelle"));
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

    //Afficher les structures dans le combo
    private static final String querySelectStructure = "SELECT codeStructure FROM structure ORDER BY codeStructure ASC";

    public static void listStructureInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectStructure)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceStatistiqueBudget.combo_Structure.addItem(res.getString("codeStructure"));
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

    //Afficher les emplois dans le combo
    private static final String querySelectEmploi = "SELECT codeEmploi FROM emploi ";

    public static void listEmploiInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectEmploi)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceStatistiqueBudget.combo_Emploi.addItem(res.getString("codeEmploi"));
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

    /**
     * *************************FILTRER LES RECHERCHE*****************************************************************************************
     */
// Effectif des agents par sexe    
    private static final String querySelectAllAgentBySexe = "SELECT * FROM agent WHERE sexeAgent = ? ";

    public static void rechercheAgentBySexe() {
        InterfaceStatistiqueBudget.combo_Structure.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Categorie.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Emploi.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_TypeAgent.setSelectedIndex(0);
        String sexeA = InterfaceStatistiqueBudget.combo_Sexe.getSelectedItem().toString();
        //numligne = InterfaceAction.tableau_action.getSelectedRow();//recuperer le le numero de la ligne
        if (sexeA.equals(" ")) {
            //JOptionPane.showMessageDialog(null, "Selectionnez le sexe des agent !! ");
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
            while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                tablemodel.removeRow(0);
                InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
            }

        } else {
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAllAgentBySexe)) {
                preparedStatement.setString(1, sexeA);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    res.last();
                    tab = new String[res.getRow()][8];
                    InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText(String.valueOf(res.getRow()));
                    res.beforeFirst();
                    yn = false;
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                    }
                    for (int k = 0; k < tab.length; k++) {
                        res.next();
                        Object[] objects = new Object[8];
                        objects[0] = res.getString("idAgent");
                        objects[1] = res.getString("matriculeAgent");
                        objects[2] = res.getString("nomAgent");
                        objects[3] = res.getString("prenomAgent");
                        objects[4] = res.getString("structureAgent");
                        objects[5] = res.getString("typeAgent");
                        objects[6] = res.getString("incidenceMensuelle");
                        objects[7] = res.getString("incidenceAnnuelle");
                        tablemodel.addRow(objects);
                        tab[k][0] = res.getString("idAgent");
                        tab[k][1] = res.getString("matriculeAgent");
                        tab[k][2] = res.getString("nomAgent");
                        tab[k][3] = res.getString("prenomAgent");
                        tab[k][4] = res.getString("structureAgent");
                        tab[k][5] = res.getString("typeAgent");
                        tab[k][6] = res.getString("incidenceMensuelle");
                        tab[k][7] = res.getString("incidenceAnnuelle");
                        yn = true;
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Saisir un matricule valide !! ");
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                        InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
                    }
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

    // Effectif des agents par caetgorie    
    private static final String querySelectAllAgentByCategorie = "SELECT * FROM agent WHERE categorieEchelleAgent = ? ";

    public static void rechercheAgentByCategorie() {
        InterfaceStatistiqueBudget.combo_Structure.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Sexe.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Emploi.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_TypeAgent.setSelectedIndex(0);
        String catA = InterfaceStatistiqueBudget.combo_Categorie.getSelectedItem().toString();
        //numligne = InterfaceAction.tableau_action.getSelectedRow();//recuperer le le numero de la ligne
        if (catA.equals(" ")) {
            //JOptionPane.showMessageDialog(null, "Selectionnez le sexe des agent !! ");
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
            while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                tablemodel.removeRow(0);
                 InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
            }

        } else {
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAllAgentByCategorie)) {
                preparedStatement.setString(1, catA);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    res.last();
                    tab = new String[res.getRow()][8];
                    InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText(String.valueOf(res.getRow()));
                    res.beforeFirst();
                    yn = false;
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                    }
                    for (int k = 0; k < tab.length; k++) {
                        res.next();
                        Object[] objects = new Object[8];
                        objects[0] = res.getString("idAgent");
                        objects[1] = res.getString("matriculeAgent");
                        objects[2] = res.getString("nomAgent");
                        objects[3] = res.getString("prenomAgent");
                        objects[4] = res.getString("structureAgent");
                        objects[5] = res.getString("typeAgent");
                        objects[6] = res.getString("incidenceMensuelle");
                        objects[7] = res.getString("incidenceAnnuelle");
                        tablemodel.addRow(objects);
                        tab[k][0] = res.getString("idAgent");
                        tab[k][1] = res.getString("matriculeAgent");
                        tab[k][2] = res.getString("nomAgent");
                        tab[k][3] = res.getString("prenomAgent");
                        tab[k][4] = res.getString("structureAgent");
                        tab[k][5] = res.getString("typeAgent");
                        tab[k][6] = res.getString("incidenceMensuelle");
                        tab[k][7] = res.getString("incidenceAnnuelle");
                        yn = true;
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Saisir un matricule valide !! ");
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                         InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
                    }
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

    // Effectif des agents par structure    
    private static final String querySelectAllAgentByStructure = "SELECT * FROM agent WHERE structureAgent = ? ";

    public static void rechercheAgentByStructure() {
        InterfaceStatistiqueBudget.combo_Categorie.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Sexe.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Emploi.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_TypeAgent.setSelectedIndex(0);
        String strucA = InterfaceStatistiqueBudget.combo_Structure.getSelectedItem().toString();
        //numligne = InterfaceAction.tableau_action.getSelectedRow();//recuperer le le numero de la ligne
        if (strucA.equals(" ")) {
            //JOptionPane.showMessageDialog(null, "Selectionnez le sexe des agent !! ");
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
            while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                tablemodel.removeRow(0);
                 InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
            }

        } else {
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAllAgentByStructure)) {
                preparedStatement.setString(1, strucA);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    res.last();
                    tab = new String[res.getRow()][8];
                    InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText(String.valueOf(res.getRow()));
                    res.beforeFirst();
                    yn = false;
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                    }
                    for (int k = 0; k < tab.length; k++) {
                        res.next();
                        Object[] objects = new Object[8];
                        objects[0] = res.getString("idAgent");
                        objects[1] = res.getString("matriculeAgent");
                        objects[2] = res.getString("nomAgent");
                        objects[3] = res.getString("prenomAgent");
                        objects[4] = res.getString("structureAgent");
                        objects[5] = res.getString("typeAgent");
                        objects[6] = res.getString("incidenceMensuelle");
                        objects[7] = res.getString("incidenceAnnuelle");
                        tablemodel.addRow(objects);
                        tab[k][0] = res.getString("idAgent");
                        tab[k][1] = res.getString("matriculeAgent");
                        tab[k][2] = res.getString("nomAgent");
                        tab[k][3] = res.getString("prenomAgent");
                        tab[k][4] = res.getString("structureAgent");
                        tab[k][5] = res.getString("typeAgent");
                        tab[k][6] = res.getString("incidenceMensuelle");
                        tab[k][7] = res.getString("incidenceAnnuelle");
                        yn = true;
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Saisir un matricule valide !! ");
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                         InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
                    }
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

    // Effectif des agents par type d'agent    
    private static final String querySelectAllAgentByTypeAgent = "SELECT * FROM agent WHERE typeAgent = ?";

    public static void rechercheAgentByTypeAgent() {
        InterfaceStatistiqueBudget.combo_Structure.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Sexe.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Emploi.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Categorie.setSelectedIndex(0);
        String strucA = InterfaceStatistiqueBudget.combo_TypeAgent.getSelectedItem().toString();
        //numligne = InterfaceAction.tableau_action.getSelectedRow();//recuperer le le numero de la ligne
        if (strucA.equals(" ")) {
            //JOptionPane.showMessageDialog(null, "Selectionnez le sexe des agent !! ");
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
            while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                tablemodel.removeRow(0);
                 InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
            }

        } else {
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAllAgentByTypeAgent)) {
                preparedStatement.setString(1, strucA);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    res.last();
                    tab = new String[res.getRow()][8];
                    InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText(String.valueOf(res.getRow()));
                    res.beforeFirst();
                    yn = false;
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                    }
                    for (int k = 0; k < tab.length; k++) {
                        res.next();
                        Object[] objects = new Object[8];
                        objects[0] = res.getString("idAgent");
                        objects[1] = res.getString("matriculeAgent");
                        objects[2] = res.getString("nomAgent");
                        objects[3] = res.getString("prenomAgent");
                        objects[4] = res.getString("structureAgent");
                        objects[5] = res.getString("typeAgent");
                        objects[6] = res.getString("incidenceMensuelle");
                        objects[7] = res.getString("incidenceAnnuelle");
                        tablemodel.addRow(objects);
                        tab[k][0] = res.getString("idAgent");
                        tab[k][1] = res.getString("matriculeAgent");
                        tab[k][2] = res.getString("nomAgent");
                        tab[k][3] = res.getString("prenomAgent");
                        tab[k][4] = res.getString("structureAgent");
                        tab[k][5] = res.getString("typeAgent");
                        tab[k][6] = res.getString("incidenceMensuelle");
                        tab[k][7] = res.getString("incidenceAnnuelle");
                        yn = true;
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Saisir un matricule valide !! ");
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                         InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
                    }
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

    // Effectif des agents par emploi    
    private static final String querySelectAllAgentByEmploi = "SELECT * FROM agent WHERE emploiAgent = ?";

    public static void rechercheAgentByEmploi() {
        InterfaceStatistiqueBudget.combo_Structure.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Sexe.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_TypeAgent.setSelectedIndex(0);
        InterfaceStatistiqueBudget.combo_Categorie.setSelectedIndex(0);
        String emplA = InterfaceStatistiqueBudget.combo_Emploi.getSelectedItem().toString();
        //numligne = InterfaceAction.tableau_action.getSelectedRow();//recuperer le le numero de la ligne
        if (emplA.equals(" ")) {
            //JOptionPane.showMessageDialog(null, "Selectionnez le sexe des agent !! ");
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
            while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                tablemodel.removeRow(0);
                 InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
            }

        } else {
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAllAgentByEmploi)) {
                preparedStatement.setString(1, emplA);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    res.last();
                    tab = new String[res.getRow()][8];
                    InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText(String.valueOf(res.getRow()));
                    res.beforeFirst();
                    yn = false;
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                    }
                    for (int k = 0; k < tab.length; k++) {
                        res.next();
                        Object[] objects = new Object[8];
                        objects[0] = res.getString("idAgent");
                        objects[1] = res.getString("matriculeAgent");
                        objects[2] = res.getString("nomAgent");
                        objects[3] = res.getString("prenomAgent");
                        objects[4] = res.getString("structureAgent");
                        objects[5] = res.getString("typeAgent");
                        objects[6] = res.getString("incidenceMensuelle");
                        objects[7] = res.getString("incidenceAnnuelle");
                        tablemodel.addRow(objects);
                        tab[k][0] = res.getString("idAgent");
                        tab[k][1] = res.getString("matriculeAgent");
                        tab[k][2] = res.getString("nomAgent");
                        tab[k][3] = res.getString("prenomAgent");
                        tab[k][4] = res.getString("structureAgent");
                        tab[k][5] = res.getString("typeAgent");
                        tab[k][6] = res.getString("incidenceMensuelle");
                        tab[k][7] = res.getString("incidenceAnnuelle");
                        yn = true;
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "Saisir un matricule valide !! ");
                    DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
                    while (InterfaceStatistiqueBudget.tableau_agent.getRowCount() > 0) {
                        tablemodel.removeRow(0);
                         InterfaceStatistiqueBudget.statBudgetNombreEnreg.setText("0");
                    }
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
    
    ///sommes des incidences
    public static void calculBudgetMensuelAnnuel() {
        //int nombreLignes = InterfaceStatistiqueBudget.tableau_agent.getRowCount();
        double budgetMensuel = 0;
        double budgetAnnuel = 0;
        DefaultTableModel tablemodel = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_agent.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Centrer horizontalement
        InterfaceStatistiqueBudget.tableau_total.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        InterfaceStatistiqueBudget.tableau_total.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        int nombreLignes = InterfaceStatistiqueBudget.tableau_agent.getRowCount();

        for (int i = 0; i < nombreLignes; i++) {
            Object valueInM = InterfaceStatistiqueBudget.tableau_agent.getValueAt(i, 6); // Colonne d'index 6
            Object valueInA = InterfaceStatistiqueBudget.tableau_agent.getValueAt(i, 7); // Colonne d'index 7

            if (valueInM instanceof Number || valueInA instanceof Number ) {
                budgetMensuel += ((Number) valueInM).doubleValue();
                budgetAnnuel += ((Number) valueInA).doubleValue();
                
            } else {
                try {
                    budgetMensuel += Double.parseDouble(valueInM.toString());
                    budgetAnnuel += Double.parseDouble(valueInA.toString());
                } catch (NumberFormatException e) {
                    // Gestion des valeurs non numériques (facultatif)
                    System.err.println("Valeur non numérique ignorée : " + valueInM);
                     System.err.println("Valeur non numérique ignorée : " + valueInA);
                }

            }

            
            
//            budgetMensuel += (double) InterfaceStatistiqueBudget.tableau_agent.getValueAt(i, 6);
            //budgetAnnuel += (float) InterfaceStatistiqueBudget.tableau_agent.getValueAt(i, 7);
        }
      //  DecimalFormat df = new DecimalFormat("#.###");
        NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);
        DefaultTableModel tablemodel2 = (DefaultTableModel) InterfaceStatistiqueBudget.tableau_total.getModel();
        InterfaceStatistiqueBudget.tableau_total.setValueAt(formatter.format(budgetMensuel), 0, 0);
        InterfaceStatistiqueBudget.tableau_total.setValueAt(formatter.format(budgetAnnuel), 0, 1);
       // System.out.println(budgetMensuel);

    }

}
