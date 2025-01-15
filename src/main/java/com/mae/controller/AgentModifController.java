/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Agent;
import com.mae.vue.InterfaceModifierAgent;
import com.mae.vue.InterfaceListeLigne661;
import com.mae.vue.InterfaceListeLigne663;
import com.mae.vue.InterfaceListeLigne664;
import com.mae.vue.InterfaceListeLigne666;
import com.mae.vue.InterfaceListeLigne669;
import com.mae.vue.InterfaceListeLigne669;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.print.*;
import java.sql.*;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class AgentModifController {

    

    //Afficher les categories dans le combo
    private static final String querySelectCategorieEchelle = "SELECT * FROM categorie";

    public static void listCategorieInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectCategorieEchelle)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceModifierAgent.comboCatAgent.addItem(res.getString("codeCategorieEchelle"));
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
    private static final String querySelectEmploi = "SELECT * FROM emploi";

    public static void listEmploiInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectEmploi)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceModifierAgent.comboEmploiAgent.addItem(res.getString("codeEmploi"));
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

    //Afficher les FONCTION dans le combo
    private static final String querySelectFonction = "SELECT * FROM fonction";

    public static void listFonctionInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectFonction)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceModifierAgent.comboFonction.addItem(res.getString("libeleFonction"));
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

    //Afficher les ministères  dans le combo
    private static final String querySelectMinistere = "SELECT * FROM ministere";

    public static void listMinistereCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectMinistere)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceModifierAgent.comboMinistere.addItem(res.getString("codeMinistere"));
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

    //Afficher les structures  dans le combo
    private static final String querySelectStructure = "SELECT * FROM structure";

    public static void listStructureCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectStructure)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceModifierAgent.comboStructure.addItem(res.getString("codeStructure"));
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

    // vider les champs
    public static void viderChamps() {
        InterfaceModifierAgent.boxIDAgent.setText("");
        InterfaceModifierAgent.boxMatriculeAg.setText("");
        InterfaceModifierAgent.boxNomAg.setText("");
        InterfaceModifierAgent.boxPrenomAg.setText("");
        InterfaceModifierAgent.boxDateNaissAg.setText("");
        InterfaceModifierAgent.boxDatePriseServiceAg.setText("");       
        InterfaceModifierAgent.boxEchelon.setText("");        
        InterfaceModifierAgent.comboSexeAg.setSelectedIndex(0);
        InterfaceModifierAgent.comboTypeAgent.setSelectedIndex(0);
        InterfaceModifierAgent.comboStructure.setSelectedIndex(0);
        InterfaceModifierAgent.comboMinistere.setSelectedIndex(0);
        InterfaceModifierAgent.comboFonction.setSelectedIndex(0);
        InterfaceModifierAgent.comboEmploiAgent.setSelectedIndex(0);
        InterfaceModifierAgent.comboCatAgent.setSelectedIndex(0);
        InterfaceModifierAgent.idProg.setText("");     
    }

    
     
     //Modifier un agent
    public static void updateAgent(Agent agent) {
        idAg = Integer.parseInt(InterfaceModifierAgent.boxIDAgent.getText());   //recuperer l'id 
        String queryUpdate = " UPDATE agent SET  matriculeAgent = ?, nomAgent = ?, prenomAgent = ?, dateNaissanceAgent = ?, sexeAgent = ?, datePriseServiceAgent = ?, ministereOrigineAgent = ?, fonctionAgent = ?, emploiAgent = ?, categorieEchelleAgent = ?, echelonAgent = ? WHERE idAgent = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
           preparedStatement.setString(1, agent.getMatriculeA());
            preparedStatement.setString(2, agent.getNomA());
            preparedStatement.setString(3, agent.getPrenomA());
            preparedStatement.setString(4, agent.getDateNaissanceA());
            preparedStatement.setString(5, agent.getSexeA());
            preparedStatement.setString(6, agent.getDatePriseServiceA());
          //  preparedStatement.setString(7, agent.getTypeA());
          //  preparedStatement.setString(8, agent.getStructureA());
            preparedStatement.setString(7, agent.getMinistereOrigineA());
            preparedStatement.setString(8, agent.getFonctionA());
            preparedStatement.setString(9, agent.getEmploiA());
            preparedStatement.setString(10, agent.getCategorieEchelleA());
            preparedStatement.setInt(11, agent.getEchelonA());   
            preparedStatement.setInt(12, idAg);                         
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }
    
    
  
    
  
    
    
    
    // rechercher et afficher un agent
    //public static int nbreligne, numligne, idAc;
   /* private static final String querySelectOneAgentByMatricule = "SELECT * FROM agent WHERE matriculeAgent = ? ";
    public static void rechercheAgentByMatricule() {
    String matriculeA = InterfaceModifierAgent.rechercheMatricule.getText().trim();
    //numligne = InterfaceAction.tableau_action.getSelectedRow();//recuperer le le numero de la ligne
    if (matriculeA.isBlank()) {
        JOptionPane.showMessageDialog(null, "Saisir un matricule !! ");
        InterfaceModifierAgent.tableau_agent.removeAll();
        //System.out.println(nbreligne);
    } else {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneAgentByMatricule)) {
            preparedStatement.setString(1, matriculeA);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                res.last();
            tab = new String[res.getRow()][5];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceModifierAgent.tableau_agent.getModel();
            while (InterfaceModifierAgent.tableau_agent.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[5];
                objects[0] = res.getString("idAgent");
                objects[1] = res.getString("matriculeAgent");
                objects[2] = res.getString("nomAgent");
                objects[3] = res.getString("prenomAgent");
                objects[4] = res.getString("structureAgent");
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idAgent");
                tab[k][1] = res.getString("matriculeAgent");
                tab[k][2] = res.getString("nomAgent");
                tab[k][3] = res.getString("prenomAgent");
                tab[k][4] = res.getString("structureAgent");
                yn = true;
            }
            } else {
                JOptionPane.showMessageDialog(null, "Saisir un matricule valide !! ");
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
}*/
    
    // Afficher une Programme
    public static int  idAg;
    private static final String querySelectOneAgentToDisplay = "SELECT * FROM agent where matriculeAgent = ? ";

    public static void displayAgentInBox() {
        String matriculeA = InterfaceModifierAgent.rechercheMatricule.getText().trim();
        if (matriculeA.isBlank()) {
            JOptionPane.showMessageDialog(null, "Saisir un matricule !! ");
            viderChamps();
           
        } else {         
       
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneAgentToDisplay)) {
                preparedStatement.setString(1, matriculeA);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceModifierAgent.boxIDAgent.setText(res.getString("idAgent"));
                    InterfaceModifierAgent.boxMatriculeAg.setText(res.getString("matriculeAgent"));
                    InterfaceModifierAgent.boxNomAg.setText(res.getString("nomAgent"));
                    InterfaceModifierAgent.boxPrenomAg.setText(res.getString("prenomAgent"));
                    InterfaceModifierAgent.boxDateNaissAg.setText(res.getString("dateNaissanceAgent"));
                    InterfaceModifierAgent.comboSexeAg.setSelectedItem(res.getString("sexeAgent"));
                    InterfaceModifierAgent.boxDatePriseServiceAg.setText(res.getString("datePriseServiceAgent"));
                    InterfaceModifierAgent.comboStructure.setSelectedItem(res.getString("structureAgent"));
                    InterfaceModifierAgent.comboMinistere.setSelectedItem(res.getString("ministereOrigineAgent"));
                    InterfaceModifierAgent.comboFonction.setSelectedItem(res.getString("fonctionAgent"));
                    InterfaceModifierAgent.comboEmploiAgent.setSelectedItem(res.getString("emploiAgent"));
                    InterfaceModifierAgent.comboCatAgent.setSelectedItem(res.getString("categorieEchelleAgent"));
                    InterfaceModifierAgent.comboTypeAgent.setSelectedItem(res.getString("typeAgent"));
                    InterfaceModifierAgent.boxEchelon.setText(res.getString("echelonAgent"));

                } else {
                    JOptionPane.showMessageDialog(null, "Saisir un matricule valide !! ");
                    viderChamps();
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
    
    
     private static final String querySelectOneAgentToPrint = "SELECT * FROM agent where matriculeAgent = ? ";

    public static void imprimerFicheAgent() {
        String matriculeA = InterfaceModifierAgent.rechercheMatricule.getText().trim();
        if (matriculeA.isBlank()) {
            JOptionPane.showMessageDialog(null, "Saisir un matricule !! ");
            viderChamps();

        } else {
             try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneAgentToDisplay)) {
                preparedStatement.setString(1, matriculeA);
                ResultSet res = preparedStatement.executeQuery();
              //  if (res.next()) {
                    // Configuration de l'interface Swing
                    JFrame frame = new JFrame("Aperçu pour impression");
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
                    frame.setSize(600, 400);
           
                    // Modèle pour la JTable
                    DefaultTableModel tableModel = new DefaultTableModel();
                    tableModel.addColumn("Matricule");
                    tableModel.addColumn("Catégorie/Echelle");
                    tableModel.addColumn("Echelon");
                    tableModel.addColumn("Nom");
                    tableModel.addColumn("Prénom");
                    tableModel.addColumn("Date de naissance");
                    tableModel.addColumn("Sexe");
                    tableModel.addColumn("Date de prise de service");
                    tableModel.addColumn("Structure actuelle");
                    tableModel.addColumn("Ministère d'origine");
                    tableModel.addColumn("Fonction");
                    tableModel.addColumn("Emploi");
                    tableModel.addColumn("Type d'agent");
                    
                    // Ajouter les données au modèle
                    while (res.next()) {
                      //  int id = res.getInt("id");
                        String matricule = res.getString("matriculeAgent");
                        String categorie = res.getString("categorieEchelleAgent");
                        String echelon = res.getString("echelonAgent");
                        String nom = res.getString("nomAgent");
                        String prenom = res.getString("prenomAgent");
                        String datenaissance = res.getString("dateNaissanceAgent");
                        String sexe = res.getString("sexeAgent");
                        String datepriseservice = res.getString("datePriseServiceAgent");
                        String structure = res.getString("structureAgent");
                        String minorigine = res.getString("ministereOrigineAgent");
                        String fonction = res.getString("fonctionAgent");
                        String emploi = res.getString("emploiAgent");
                        String typeagent = res.getString("typeAgent");
                                                
                        tableModel.addRow(new Object[]{matricule, categorie, echelon, nom, prenom, datenaissance, sexe, datepriseservice, structure, minorigine, fonction,emploi,typeagent });
                    }
     
                    // Créer une JTable avec le modèle
                    JTable table = new JTable(tableModel);
                    JScrollPane scrollPane = new JScrollPane(table);

                    // Bouton pour imprimer
                    JButton printButton = new JButton("Imprimer");
                    printButton.addActionListener(e -> {
                        // Imprimer la JTable
                        boolean complete = false;
                        try {
                            complete = table.print(JTable.PrintMode.FIT_WIDTH,
                                    new MessageFormat("FICHE AGENT"),
                                    new MessageFormat("Page {0}"));
                        } catch (PrinterException ex) {
                            Logger.getLogger(AgentModifController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        if (complete) {
                            JOptionPane.showMessageDialog(frame, "Impression réussie !");
                        } else {
                            JOptionPane.showMessageDialog(frame, "Impression annulée !");
                        }
                    });

                    // Ajouter les composants à la fenêtre
                    frame.setLayout(new BorderLayout());
                    frame.add(scrollPane, BorderLayout.CENTER);
                    frame.add(printButton, BorderLayout.SOUTH);

                    // Afficher la fenêtre
                    frame.setVisible(true);


                    
                    
                    
                   /* InterfaceModifierAgent.boxIDAgent.setText(res.getString("idAgent"));
                    InterfaceModifierAgent.boxMatriculeAg.setText(res.getString("matriculeAgent"));
                    InterfaceModifierAgent.boxNomAg.setText(res.getString("nomAgent"));
                    InterfaceModifierAgent.boxPrenomAg.setText(res.getString("prenomAgent"));
                    InterfaceModifierAgent.boxDateNaissAg.setText(res.getString("dateNaissanceAgent"));
                    InterfaceModifierAgent.comboSexeAg.setSelectedItem(res.getString("sexeAgent"));
                    InterfaceModifierAgent.boxDatePriseServiceAg.setText(res.getString("datePriseServiceAgent"));
                    InterfaceModifierAgent.comboStructure.setSelectedItem(res.getString("structureAgent"));
                    InterfaceModifierAgent.comboMinistere.setSelectedItem(res.getString("ministereOrigineAgent"));
                    InterfaceModifierAgent.comboFonction.setSelectedItem(res.getString("fonctionAgent"));
                    InterfaceModifierAgent.comboEmploiAgent.setSelectedItem(res.getString("emploiAgent"));
                    InterfaceModifierAgent.comboCatAgent.setSelectedItem(res.getString("categorieEchelleAgent"));
                    InterfaceModifierAgent.comboTypeAgent.setSelectedItem(res.getString("typeAgent"));
                    InterfaceModifierAgent.boxEchelon.setText(res.getString("echelonAgent"));*/

              //  } else {
                    //JOptionPane.showMessageDialog(null, "Saisir un matricule valide !! ");
                   // viderChamps();
               // }
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
    
    
    
      public static void print(){
      
      

        JButton printButton = new JButton("Imprimer l'écran");
        printButton.addActionListener(e -> printScreen());
        
        
        
        
      }
    
    
    public static void printScreen() {
        try {
            // Capturer l'écran entier
            Robot robot = new Robot();
            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenCapture = robot.createScreenCapture(screenRect);

            // Imprimer la capture d'écran
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable((graphics, pageFormat, pageIndex) -> {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2d = (Graphics2D) graphics;
                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                g2d.drawImage(screenCapture, 0, 0, null);
                return Printable.PAGE_EXISTS;
            });

            if (job.printDialog()) {
                job.print();
            }
        } catch (AWTException | PrinterException ex) {
            ex.printStackTrace();
        }
    }
    
    
    
    
    
    
    
    

}
    
    
    
    
