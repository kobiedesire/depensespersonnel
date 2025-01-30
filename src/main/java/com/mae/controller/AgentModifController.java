/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.itextpdf.io.font.constants.StandardFonts;
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

import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.table.TableModel;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Cell;
import com.mae.controller.PiedDePageController;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.kernel.events.IEventHandler;
import com.itextpdf.kernel.events.Event;
import com.itextpdf.kernel.events.PdfDocumentEvent;
import com.itextpdf.layout.element.Paragraph;

import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.mae.vue.InterfaceElementsDeSalaire;

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
    
     //afficher les données de salaires dans une nouvelles fenetre
    public static void afficherInterfaceElementDeSalaire() {
         String matA = (InterfaceModifierAgent.rechercheMatricule.getText().trim());
        if (matA.isBlank()) {
          //  InterfaceModifierAgent.rechercheMatricule.setText("");
            JOptionPane.showMessageDialog(null, "Saisir le matricule de l'agent.");
        } else {
           // String matA = (InterfaceModifierAgent.rechercheMatricule.getText());
            // System.out.println(idP);
             // Ajout de la table dans un JScrollPane
        JScrollPane scrollPane = new JScrollPane(InterfaceElementsDeSalaire.tableau_elementSalaire);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
            InterfaceElementsDeSalaire iAfficheSalaire = new InterfaceElementsDeSalaire(new javax.swing.JFrame(), true);
            iAfficheSalaire.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
            iAfficheSalaire.matriculeAgent.setText(matA);
            iAfficheSalaire.add(scrollPane, BorderLayout.CENTER);
            iAfficheSalaire.setVisible(true);

        }
    }
    
    
     private static boolean res, yn;
    private static String tab[][];
    //Selectionner toutes les element de salaire d'un agent en fonction de son matricule    
    private static final String querySelectSalaire = "SELECT * FROM agent WHERE matriculeAgent = ?";

    public static void afficherElementDeSalaire() {
        String matAgent = InterfaceElementsDeSalaire.matriculeAgent.getText();
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectSalaire)) {
            preparedStatement.setString(1, matAgent);
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][16];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceElementsDeSalaire.tableau_elementSalaire.getModel();
            while (InterfaceElementsDeSalaire.tableau_elementSalaire.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }

            for (String[] tab1 : tab) {
                res.next();
                Object[] objects = new Object[16];
                objects[0] = res.getString("idAgent");
                objects[1] = res.getString("matriculeAgent");
                objects[2] = res.getString("indiceAgent");
                objects[3] = res.getString("salaireIndiciaireAgent");
                objects[4] = res.getString("indemniteResidence");
                objects[5] = res.getString("indemniteAstreinte");
                objects[6] = res.getString("indemniteTechnicite");
                objects[7] = res.getString("indemniteResponsabilite");
                objects[8] = res.getString("indemniteVestimentaire");
                objects[9] = res.getString("indemniteLogement");
                objects[10] = res.getString("indemniteSpecifique");
                objects[11] = res.getString("autreIndemnite");
                objects[12] = res.getString("chargeMilitaire");
                objects[13] = res.getString("contributionCARFO");
                objects[14] = res.getString("contributionCNSS");
                objects[15] = res.getString("allocationFamiliale");                
                
                tablemodel.addRow(objects);
                tab1[0] = res.getString("idAgent");
                tab1[1] = res.getString("matriculeAgent");
                tab1[2] = res.getString("indiceAgent");
                tab1[3] = res.getString("salaireIndiciaireAgent");
                tab1[4] = res.getString("indemniteResidence");
                tab1[5] = res.getString("indemniteAstreinte");
                tab1[6] = res.getString("indemniteTechnicite");
                tab1[7] = res.getString("indemniteResponsabilite");
                tab1[8] = res.getString("indemniteVestimentaire");
                tab1[9] = res.getString("indemniteLogement");
                tab1[10] = res.getString("indemniteSpecifique");
                tab1[11] = res.getString("autreIndemnite");
                tab1[12] = res.getString("chargeMilitaire");
                tab1[13] = res.getString("contributionCARFO");
                tab1[14] = res.getString("contributionCNSS");
                tab1[15] = res.getString("allocationFamiliale");
                
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
    
    
   /*  private static final String querySelectOneAgentToPrint = "SELECT * FROM agent where matriculeAgent = ? ";
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
              /* res.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
            }        
        
        }

        }*/
  
    
    
    /*public class DataFetcher {
        public static ResultSet fetchData() throws Exception {
            //Connection conn = DatabaseConnection.getConnection();
            String query = "SELECT * FROM agent where matriculeAgent = ?";
            String matriculeA = InterfaceModifierAgent.rechercheMatricule.getText().trim();
            if (matriculeA.isBlank()) {
                JOptionPane.showMessageDialog(null, "Saisir un matricule !! ");
                viderChamps();
            } else {
                try (Connection connection = connexionBD.getConnection(); 
                     PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setString(1, matriculeA);
                    //ResultSet res = preparedStatement.executeQuery();
                    return preparedStatement.executeQuery();
                    //  res.close();
                    //preparedStatement.close();
                    // connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                } 
            }
           // return null;
        }
    } */
    
       public static void printFicheAgent() {           
           // Créateur du sélecteur de fichier
           JFileChooser selecteurFichier = new JFileChooser();
           selecteurFichier.setDialogTitle("Sélectionner un emplacement");
           int maSelection = selecteurFichier.showSaveDialog(null);

           if (maSelection == JFileChooser.APPROVE_OPTION) {
               String query = "SELECT * FROM agent where matriculeAgent = ?";
               String matriculeA = InterfaceModifierAgent.rechercheMatricule.getText().trim();
               if (matriculeA.isBlank()) {
                   JOptionPane.showMessageDialog(null, "Saisir un matricule !! ");
                   viderChamps();
               } else {
                   
                   try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                       preparedStatement.setString(1, matriculeA);
                       ResultSet res = preparedStatement.executeQuery();
                       // return preparedStatement.executeQuery();
                       // Chemin du fichier PDF à créer
                       //String dest = "Fiche Agent.pdf";
                       String chemin = selecteurFichier.getSelectedFile().getAbsolutePath() + ".pdf";
                       PdfWriter writer = new PdfWriter(chemin);
                       PdfDocument pdf = new PdfDocument(writer);
                       pdf.setDefaultPageSize(com.itextpdf.kernel.geom.PageSize.A4.rotate());
                       Document document = new Document(pdf);
                       
                       /*******************EN TETE********************/
                       // gestion du timbre
                       float[] largeurtableau = {600, 400};
                       PdfFont policeEntete = PdfFontFactory.createFont(StandardFonts.COURIER_BOLD);

                       Table tableEntete = new Table(largeurtableau); // Largeur des colonnes (proportionnelle)
                       tableEntete.setAutoLayout(); // Ajuster la largeur du tableau au document
                       tableEntete.setTextAlignment(TextAlignment.CENTER);
                       tableEntete.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);

                       tableEntete.addCell(new Cell().add(new Paragraph("MINISTERE DES AFFAIRES ETRANGERES, DE LA COOPERATION REGIONALE ET DES BURKINABE DE L'EXTERIEUR")).setBorder(Border.NO_BORDER)).setFont(policeEntete);
                       tableEntete.addCell(new Cell().add(new Paragraph("BURKINA FASO")).setBorder(Border.NO_BORDER)).setFont(policeEntete);

                       tableEntete.addCell(new Cell().add(new Paragraph("***********")).setBorder(Border.NO_BORDER)).setFont(policeEntete);
                       tableEntete.addCell(new Cell().add(new Paragraph("***********")).setBorder(Border.NO_BORDER)).setFont(policeEntete);

                       tableEntete.addCell(new Cell().add(new Paragraph("SECRETARIAT GENERAL")).setBorder(Border.NO_BORDER)).setFont(policeEntete);
                       tableEntete.addCell(new Cell().add(new Paragraph("La patrie ou la mort, nous vaincrons !!")).setBorder(Border.NO_BORDER)).setFont(policeEntete);

                       tableEntete.addCell(new Cell().add(new Paragraph("***********")).setBorder(Border.NO_BORDER)).setFont(policeEntete);
                       tableEntete.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER)).setFont(policeEntete);

                       tableEntete.addCell(new Cell().add(new Paragraph("DIRECTION DES RESSOURCES HUMAINES")).setBorder(Border.NO_BORDER)).setFont(policeEntete);
                       tableEntete.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER)).setFont(policeEntete);
                       document.add(tableEntete);

                       //ajout d'interligne
                       Paragraph interligne = new Paragraph("")
                               .setMultipliedLeading(2.5f); // Interligne de 2.5x

                       // Ajout d'un titre
                       Paragraph title = new Paragraph("FICHE AGENT")
                               .setFont(policeEntete)
                               .setFontSize(16)
                               .setTextAlignment(TextAlignment.CENTER)
                               .setUnderline()
                               .setFontColor(ColorConstants.BLACK);

                       //  .setTextAlignment(TextAlignment.CENTER);
                       document.add(title);
                       
                       /*******************DONNEES ********************************/

                       // Ajouter un titre au PDF
                     //  document.add(new Paragraph("Fiche agent").setBold().setFontSize(15));

                       // Récupérer les données depuis MySQL
                       // ResultSet resultSet = DataFetcher.fetchData();
                       // Créer un tableau pour afficher les données
                       Table table = new Table(new float[]{150, 850}); // Colonnes ajustables
                       PdfFont police = PdfFontFactory.createFont(StandardFonts.COURIER_BOLD);
                       table.setAutoLayout(); // Ajuster la largeur du tableau au document
                       table.setTextAlignment(TextAlignment.LEFT);
                       table.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);

                       if (res.next()) {
                           table.addCell(new Cell().add(new Paragraph("MATRICULE : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("matriculeAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("CATEGORIE/ECHELLE : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("categorieEchelleAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("ECHELON : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("echelonAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("NOM : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("nomAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("PRENOM (S) : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("prenomAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("DATE.NAISSANCE: ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("dateNaissanceAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("SEXE : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("sexeAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("DATE.PRISE/SERVICE: ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("datePriseServiceAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("STRUCTURE : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("structureAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("MINISTERE/ORIGINE : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("ministereOrigineAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("FONCTION : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("fonctionAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("EMPLOI : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("emploiAgent"))).setBorder(Border.NO_BORDER).setFont(police));

                           table.addCell(new Cell().add(new Paragraph("TYPE/AGENT : ")).setBorder(Border.NO_BORDER).setFont(police));
                           table.addCell(new Cell().add(new Paragraph(res.getString("typeAgent"))).setBorder(Border.NO_BORDER).setFont(police));
                       }

                       // Ajouter le tableau au document
                       document.add(table);

                       // Fermer le document
                       document.close();
                       JOptionPane.showMessageDialog(null, "Document généré avec succès ! ");
                       // System.out.println("Fiche généré avec succès !");

                       res.close();
                       preparedStatement.close();
                       connection.close();
                   } catch (SQLException e) {
                       JOptionPane.showMessageDialog(null, "Erreur SQL");
                   } catch (Exception e) {
                       e.printStackTrace();
                   }
               }
           }

        
        
       /* try {
            // Chemin du fichier PDF à créer
            String dest = "Fiche Agent.pdf";
            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Ajouter un titre au PDF
            document.add(new Paragraph("Fiche agent").setBold().setFontSize(15));

            // Récupérer les données depuis MySQL
            ResultSet resultSet = DataFetcher.fetchData();

            // Créer un tableau pour afficher les données
            Table table = new Table(new float[]{500, 500}); // Colonnes ajustables
            //PdfFont police = PdfFontFactory.createFont(StandardFonts.COURIER_BOLD);
            table.setAutoLayout(); // Ajuster la largeur du tableau au document
            table.setTextAlignment(TextAlignment.CENTER);
            table.setBorder(com.itextpdf.layout.borders.Border.NO_BORDER);

            if (resultSet.next()) {
                table.addCell(new Cell().add(new Paragraph("MATRICULE : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("matriculeAgent"));

                table.addCell(new Cell().add(new Paragraph("CATEGORIE/ECHELLE : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("categorieEchelleAgent"));

                table.addCell(new Cell().add(new Paragraph("ECHELON : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("echelonAgent"));

                table.addCell(new Cell().add(new Paragraph("NOM : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("nomAgent"));

                table.addCell(new Cell().add(new Paragraph("PRENOM (S) : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("prenomAgent"));

                table.addCell(new Cell().add(new Paragraph("DATE.NAISSANCE: ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("dateNaissanceAgent"));

                table.addCell(new Cell().add(new Paragraph("SEXE : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("sexeAgent"));

                table.addCell(new Cell().add(new Paragraph("DATE.PRISE/SERVICE: ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("datePriseServiceAgent"));

                table.addCell(new Cell().add(new Paragraph("STRUCTURE : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("structureAgent"));

                table.addCell(new Cell().add(new Paragraph("MINISTERE/ORIGINE : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("ministereOrigineAgent"));

                table.addCell(new Cell().add(new Paragraph("FONCTION : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("fonctionAgent"));

                table.addCell(new Cell().add(new Paragraph("EMPLOI : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("emploiAgent"));

                table.addCell(new Cell().add(new Paragraph("TYPE/AGENT : ")).setBorder(Border.NO_BORDER));
                table.addCell(resultSet.getString("typeAgent"));        
            }
 
            // Ajouter le tableau au document
            document.add(table);

            // Fermer le document
            document.close();

            System.out.println("Fiche généré avec succès !");
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

} 




    
    
    
    
