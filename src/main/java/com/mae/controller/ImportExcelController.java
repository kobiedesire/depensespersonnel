/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.ImportExcel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author hp
 */
public class ImportExcelController {
    ///importer un fichier excel pour les agents

    private static final String queryInsertExcelDATA = "INSERT INTO agent (matriculeAgent, nomAgent, prenomAgent, dateNaissanceAgent, sexeAgent, datePriseServiceAgent, typeAgent, structureAgent, ministereOrigineAgent, fonctionAgent, emploiAgent, categorieEchelleAgent, echelonAgent, \n"
            + "indiceAgent, salaireIndiciaireAgent, indeminiteResidence, indeminiteAstreinte, indeminiteTechnicite, indeminiteResponsabilite, indeminiteVestimentaire, indeminiteLogement, indeminiteSpecifique, autreIndeminite, chargeMilitaire, \n"
            + "contributionCARFO, contributionCNSS, allocationFamiliale, montantLigne661, montantLigne663, montantLigne664, montantLigne666, montantLigne669, incidenceMensuelle, incidenceAnnuelle) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


    public static void importFichierExcelAgent() {
        // Ouvrir JFileChooser pour sélectionner le fichier Excel
        JFileChooser selecteurFichier = new JFileChooser();
        selecteurFichier.setDialogTitle("Sélectionner un fichier Excel");
        selecteurFichier.setFileFilter(new FileNameExtensionFilter("Fichiers excel", "xlsx"));
               // setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
        int maSelection = selecteurFichier.showOpenDialog(null);
        if (maSelection == JFileChooser.APPROVE_OPTION) {
            File fichierExcel = selecteurFichier.getSelectedFile();
            String cheminFichier = fichierExcel.getAbsolutePath();
            try (FileInputStream fis = new FileInputStream(cheminFichier); Workbook workbook = new XSSFWorkbook(fis)) {
                Sheet sheet = workbook.getSheetAt(0); // Première feuille Excel
                try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsertExcelDATA)) {
                    // Parcourir les lignes de l'Excel
                    for (Row row : sheet) {
                        if (row.getRowNum() == 1) { // Sauter la première ligne - les entêtes
                            continue;
                        }
                        String matricule = row.getCell(0).getStringCellValue();
                        String nom = row.getCell(1).getStringCellValue();
                        String prenom = row.getCell(2).getStringCellValue();                        
                        String datenaissance = row.getCell(3).getStringCellValue();
                        String sexe = row.getCell(4).getStringCellValue();
                        String datepriseservice = row.getCell(5).getStringCellValue();                        
                        String typeagent = row.getCell(6).getStringCellValue();
                        String structure = row.getCell(7).getStringCellValue();
                        String minisorigine = row.getCell(8).getStringCellValue();                        
                        String fonction = row.getCell(9).getStringCellValue();
                        String emploi = row.getCell(10).getStringCellValue();
                        
                        String categorieechelle = row.getCell(11).getStringCellValue();   
                        
                        double echelon = row.getCell(12).getNumericCellValue();  
                        double indice = row.getCell(13).getNumericCellValue();
                        
                        double salaireindiciaire = row.getCell(14).getNumericCellValue();
                        double indemniteresidence = row.getCell(15).getNumericCellValue();
                        double indemniteastreinte = row.getCell(16).getNumericCellValue();
                        double indemnitetechnicite = row.getCell(17).getNumericCellValue();
                        double indemniteresponsabilite = row.getCell(18).getNumericCellValue();
                        double indemnitevestimentaire = row.getCell(19).getNumericCellValue();                       
                        double indemniteloggement = row.getCell(20).getNumericCellValue();
                        double indemnitespecifique = row.getCell(21).getNumericCellValue();
                        double autreindemnite = row.getCell(22).getNumericCellValue();                       
                        double chargemilitaire = row.getCell(23).getNumericCellValue();
                        double carfo = row.getCell(24).getNumericCellValue();
                        double cnss = row.getCell(25).getNumericCellValue();                     
                        double allocationfamiliale = row.getCell(26).getNumericCellValue();
                        double ligne661 = row.getCell(27).getNumericCellValue();
                        double ligne663 = row.getCell(28).getNumericCellValue();
                        double ligne664 = row.getCell(29).getNumericCellValue();
                        double ligne666 = row.getCell(30).getNumericCellValue();
                        double ligne669 = row.getCell(31).getNumericCellValue();
                        double incidencemensuelle = row.getCell(32).getNumericCellValue();
                        double incidenceannuelle = row.getCell(33).getNumericCellValue(); 
                        
                        
                        
                       /* int echelon = Integer.parseInt(row.getCell(12).getStringCellValue());                        
                        int indice = Integer.parseInt(row.getCell(13).getStringCellValue());
                        
                        double echelon = row.getCell(12).getNumericCellValue();  
                        double indice = row.getCell(13).getNumericCellValue();
                        
                        double salaireindiciaire = Double.parseDouble(row.getCell(14).getStringCellValue());
                        double indemniteresidence = Double.parseDouble(row.getCell(15).getStringCellValue());
                        double indemniteastreinte = Double.parseDouble(row.getCell(16).getStringCellValue());
                        double indemnitetechnicite = Double.parseDouble(row.getCell(17).getStringCellValue());
                        double indemniteresponsabilite = Double.parseDouble(row.getCell(18).getStringCellValue());
                        double indemnitevestimentaire = Double.parseDouble(row.getCell(19).getStringCellValue());                        
                        double indemniteloggement = Double.parseDouble(row.getCell(20).getStringCellValue());
                        double indemnitespecifique = Double.parseDouble(row.getCell(21).getStringCellValue());
                        double autreindemnite = Double.parseDouble(row.getCell(22).getStringCellValue());                        
                        double chargemilitaire = Double.parseDouble(row.getCell(23).getStringCellValue());
                        double carfo = Double.parseDouble(row.getCell(24).getStringCellValue());
                        double cnss = Double.parseDouble(row.getCell(25).getStringCellValue());                        
                        double allocationfamiliale = Double.parseDouble(row.getCell(26).getStringCellValue());
                        double ligne661 = Double.parseDouble(row.getCell(27).getStringCellValue());
                        double ligne663 = Double.parseDouble(row.getCell(28).getStringCellValue());
                        double ligne664 = Double.parseDouble(row.getCell(29).getStringCellValue());
                        double ligne666 = Double.parseDouble(row.getCell(30).getStringCellValue());
                        double ligne669 = Double.parseDouble(row.getCell(31).getStringCellValue());
                        double incidencemensuelle = Double.parseDouble(row.getCell(32).getStringCellValue());
                        double incidenceannuelle = Double.parseDouble(row.getCell(33).getStringCellValue());  */                     
                        
                        // Insérer les données dans la base
                        preparedStatement.setString(1, matricule);
                        preparedStatement.setString(2, nom);
                        preparedStatement.setString(3, prenom);
                        preparedStatement.setString(4, datenaissance);
                        preparedStatement.setString(5, sexe);
                        preparedStatement.setString(6, datepriseservice);
                        preparedStatement.setString(7, typeagent);
                        preparedStatement.setString(8, structure);
                        preparedStatement.setString(9, minisorigine);
                        preparedStatement.setString(10, fonction);
                        preparedStatement.setString(11, emploi);
                        preparedStatement.setString(12, categorieechelle);
                        
                        preparedStatement.setDouble(13, echelon);
                        preparedStatement.setDouble(14, indice);
                        preparedStatement.setDouble(15, salaireindiciaire);
                        preparedStatement.setDouble(16, indemniteresidence);
                        preparedStatement.setDouble(17, indemniteastreinte);
                        preparedStatement.setDouble(18, indemnitetechnicite);
                        preparedStatement.setDouble(19, indemniteresponsabilite);
                        preparedStatement.setDouble(20, indemnitevestimentaire);
                        preparedStatement.setDouble(21, indemniteloggement);
                        preparedStatement.setDouble(22, indemnitespecifique);
                        preparedStatement.setDouble(23, autreindemnite);
                        preparedStatement.setDouble(24, chargemilitaire);
                        preparedStatement.setDouble(25, carfo);
                        preparedStatement.setDouble(26, cnss);
                        preparedStatement.setDouble(27, allocationfamiliale);
                        preparedStatement.setDouble(28, ligne661);
                        preparedStatement.setDouble(29, ligne663);
                        preparedStatement.setDouble(30, ligne664);
                        preparedStatement.setDouble(31, ligne666);
                        preparedStatement.setDouble(32, ligne669);
                        preparedStatement.setDouble(33, incidencemensuelle);
                        preparedStatement.setDouble(34, incidenceannuelle);

                        preparedStatement.addBatch(); // Ajout à un batch pour exécution groupée                       
                    }
                    // Exécuter le batch
                    preparedStatement.executeBatch();
                    System.out.println("Données insérées avec succès !");
                    JOptionPane.showMessageDialog(null, "Importation terminée !! ");
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    //  e.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Erreur SQL" + e.getMessage());

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Attention aux champs numériques" + e.getMessage());
                }
            } catch (IOException e) {
                //System.out.println("Erreur lors de la lecture du fichier Excel : " + e.getMessage());
                  JOptionPane.showMessageDialog(null,"Erreur lors de la lecture du fichier Excel : " + e.getMessage());
            } catch (Exception e) {
                //System.out.println("Erreur : " + e.getMessage());
                 JOptionPane.showMessageDialog(null,"Erreur : " + e.getMessage());
            }
        } else {
            //System.out.println("Aucun fichier sélectionné.");
            JOptionPane.showMessageDialog(null, "Aucun fichier sélectionné.");
        }
    }
}
