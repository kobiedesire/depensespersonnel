/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.vue.InterfaceConsulterBudget;
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
public class ConsulterBudgetController {

    private static boolean res, yn;
    private static String tab[][];

    /*Lister tous les agents Central + MDCPC*/
    private static final String querySelectAllAgent = "SELECT *  FROM agent ";

    public static void listAllAgent() {
        //String typeA = InterfaceAgent.comboTypeAgent.getSelectedItem().toString();
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAllAgent)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][30];
            InterfaceConsulterBudget.statBudgetNombreEnreg.setText(String.valueOf(res.getRow()));
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceConsulterBudget.tableau_agent.getModel();
            
            while (InterfaceConsulterBudget.tableau_agent.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);
            DecimalFormat df = new DecimalFormat("#,###.00");
            //NumberFormat formatter = NumberFormat.getInstance(Locale.FRANCE);
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[30];
                objects[0] = res.getString("idAgent");
                objects[1] = res.getString("matriculeAgent");
                objects[2] = res.getString("nomAgent");
                objects[3] = res.getString("prenomAgent");
                objects[4] = res.getString("dateNaissanceAgent");
                objects[5] = res.getString("sexeAgent");
                objects[6] = res.getString("datePriseServiceAgent");
                objects[7] = res.getString("typeAgent");
                objects[8] = res.getString("structureAgent");
                objects[9] = res.getString("ministereOrigineAgent");
                objects[10] = res.getString("fonctionAgent");
                objects[11] = res.getString("emploiAgent");
                objects[12] = res.getString("categorieEchelleAgent");
                objects[13] = res.getString("echelonAgent");
                objects[14] = res.getString("indiceAgent");
                objects[15] = res.getString("salaireIndiciaireAgent");
                objects[16] = res.getString("indeminiteResidence");
                objects[17] = res.getString("indeminiteAstreinte");
                objects[18] = res.getString("indeminiteTechnicite");
                objects[19] = res.getString("indeminiteResponsabilite");
                objects[20] = res.getString("indeminiteVestimentaire");
                objects[21] = res.getString("indeminiteLogement");
                objects[22] = res.getString("indeminiteSpecifique");
                objects[23] = res.getString("autreIndeminite");
                objects[24] = res.getString("chargeMilitaire");
                objects[25] = res.getString("contributionCARFO");
                objects[26] = res.getString("contributionCNSS");
                objects[27] = res.getString("allocationFamiliale");
                objects[28] = res.getString("incidenceMensuelle");
                objects[29] = res.getString("incidenceAnnuelle");
                
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idAgent");
                tab[k][1] = res.getString("matriculeAgent");
                tab[k][2] = res.getString("nomAgent");
                tab[k][3] = res.getString("prenomAgent");
                tab[k][4] = res.getString("dateNaissanceAgent");
                tab[k][5] = res.getString("sexeAgent");
                tab[k][6] = res.getString("datePriseServiceAgent");
                tab[k][7] = res.getString("typeAgent");
                tab[k][8] = res.getString("structureAgent");
                tab[k][9] = res.getString("ministereOrigineAgent");
                tab[k][10] = res.getString("fonctionAgent");
                tab[k][11] = res.getString("emploiAgent");
                tab[k][12] = res.getString("categorieEchelleAgent");
                tab[k][13] = res.getString("echelonAgent");
                tab[k][14] = res.getString("indiceAgent");
                tab[k][15] = res.getString("salaireIndiciaireAgent");
                tab[k][16] = res.getString("indeminiteResidence");
                tab[k][17] = res.getString("indeminiteAstreinte");
                tab[k][18] = res.getString("indeminiteTechnicite");
                tab[k][19] = res.getString("indeminiteResponsabilite");
                tab[k][20] = res.getString("indeminiteVestimentaire");
                tab[k][21] = res.getString("indeminiteLogement");
                tab[k][22] = res.getString("indeminiteSpecifique");
                tab[k][23] = res.getString("autreIndeminite");
                tab[k][24] = res.getString("chargeMilitaire");
                tab[k][25] = res.getString("contributionCARFO");
                tab[k][26] = res.getString("contributionCNSS");
                tab[k][27] = res.getString("allocationFamiliale");
                tab[k][28] = res.getString("incidenceMensuelle");
                tab[k][29] = res.getString("incidenceAnnuelle") ;
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

   

    //exporter en excel
    public static void exportExcel() {
        // Créateur du sélecteur de fichier
        JFileChooser selecteurFichier = new JFileChooser();
        selecteurFichier.setDialogTitle("Sélectionner un emplacement");

        int maSelection = selecteurFichier.showSaveDialog(null);
        if (maSelection == JFileChooser.APPROVE_OPTION) {
            try (Workbook workbook = new XSSFWorkbook()) {
                //creation d'une feuille
                Sheet sheet = workbook.createSheet("Budget détaillé");

                // Écrire les en-têtes
                TableModel model = InterfaceConsulterBudget.tableau_agent.getModel();
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
    
    

    
    ///sommes des incidences
    public static void calculBudgetMensuelAnnuel() {
        //int nombreLignes = InterfaceStatistiqueBudget.tableau_agent.getRowCount();
        double budgetMensuel = 0;
        double budgetAnnuel = 0;
        DefaultTableModel tablemodel = (DefaultTableModel) InterfaceConsulterBudget.tableau_agent.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER); // Centrer horizontalement
        InterfaceConsulterBudget.tableau_total.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        InterfaceConsulterBudget.tableau_total.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);

        int nombreLignes = InterfaceConsulterBudget.tableau_agent.getRowCount();

        for (int i = 0; i < nombreLignes; i++) {
            Object valueInM = InterfaceConsulterBudget.tableau_agent.getValueAt(i, 28); // Colonne d'index 6
            Object valueInA = InterfaceConsulterBudget.tableau_agent.getValueAt(i, 29); // Colonne d'index 7

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
        DefaultTableModel tablemodel2 = (DefaultTableModel) InterfaceConsulterBudget.tableau_total.getModel();
        InterfaceConsulterBudget.tableau_total.setValueAt(formatter.format(budgetMensuel), 0, 0);
        InterfaceConsulterBudget.tableau_total.setValueAt(formatter.format(budgetAnnuel), 0, 1);
       // System.out.println(budgetMensuel);

    }

}
