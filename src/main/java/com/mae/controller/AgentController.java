/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Agent;
import com.mae.vue.InterfaceAgent;
import com.mae.vue.InterfaceListeLigne;
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

/**
 *
 * @author hp
 */
public class AgentController {

    private static boolean res, yn;
    private static String tab[][];

    ///calcul du salaire indiciere d'un agent, de l'indeminité de residence et mise à jour de la ligne 661
    public static int pointIndiciare = 2331;

    public static void calculSalIndiciaire() {
        if (InterfaceAgent.boxIndiceSal.getText().trim().isBlank()) {
            InterfaceAgent.boxSalaireIndicMensuel.setText("");
            InterfaceAgent.ligne661.setText("");
            InterfaceAgent.boxIndResidence.setText("");
            //JOptionPane.showMessageDialog(null, "Saisir l'indice");
        } else {
            double indiceS = Integer.parseInt(InterfaceAgent.boxIndiceSal.getText().trim());
            double salIndicaire = (indiceS * pointIndiciare) / 12; //salaire indiciaire mensuel = indice*point /12
            double indeminiteResidence = (salIndicaire * 10) / 100;//calcul de l'indeminité de residence
            double soldeLigne611 = salIndicaire + indeminiteResidence; //calcul du total de la ligne 661
            InterfaceAgent.boxSalaireIndicMensuel.setValue(Math.round(salIndicaire));//affichage du solde indiciaire
            InterfaceAgent.boxIndResidence.setValue(Math.round(indeminiteResidence));//affichage de l'indeminité de residence            
            InterfaceAgent.ligne661.setValue(Math.round(soldeLigne611));

        }
    }

    //calcul de la contribution carfo et cnss et mise à jour de la ligne 664, ce calcul est fonction du type d'agent
    public static double tauxCARFO = 13.5;
    public static double tauxCNSS = 16;

    public static void calculContribution() {
        String typeAgent = InterfaceAgent.comboTypeAgent.getSelectedItem().toString().trim();
        if (typeAgent.isBlank() || InterfaceAgent.boxSalaireIndicMensuel.getText().isBlank()) {
            InterfaceAgent.boxContributionCARFO.setText("");
            InterfaceAgent.boxContributionCNSS.setText("");
        } else {

            double salIndicaire = Integer.parseInt(InterfaceAgent.boxSalaireIndicMensuel.getText());
            switch (typeAgent) {
                case "Fonctionnaire":
                    double contriCARFO = (salIndicaire * tauxCARFO) / 100;
                    InterfaceAgent.boxContributionCARFO.setValue(Math.round(contriCARFO));
                    InterfaceAgent.idLigne664.setValue(Math.round(contriCARFO));
                    InterfaceAgent.boxContributionCNSS.setText("");
                    break;

                case "Contractuel":
                    double contriCNSS = (salIndicaire * tauxCNSS) / 100;
                    InterfaceAgent.boxContributionCNSS.setValue(Math.round(contriCNSS));
                    InterfaceAgent.idLigne664.setValue(Math.round(contriCNSS));
                    InterfaceAgent.boxContributionCARFO.setText("");
                    break;
            }

        }
    }

    //calcul de la somme des indeminités de logement, d'astreinte, de responsabilité, de technicité et vestimentaire et mise à jour de la ligne 663
    public static void calculIndemnite() {
        double indLogement = 0, indAstreinte = 0, indVestimentaire = 0, indReponsabilité = 0, indTechnicite = 0;
        if (InterfaceAgent.boxIndeminiteLogement.getText().isBlank() && InterfaceAgent.boxIndeminiteAstreinte.getText().isBlank() && InterfaceAgent.boxIndeminiteVestimentaire.getText().isBlank()
                && InterfaceAgent.boxIndeminiteResponsabilite.getText().isBlank() && InterfaceAgent.boxIndeminiteTechnicite.getText().isBlank()) {
            InterfaceAgent.ligne663.setText("");
        } else {
            if (InterfaceAgent.boxIndeminiteLogement.getText().isBlank()) {
                indLogement = 0;
            } else {
                indLogement = Integer.parseInt(InterfaceAgent.boxIndeminiteLogement.getText());
            }
            if (InterfaceAgent.boxIndeminiteAstreinte.getText().isBlank()) {
                indAstreinte = 0;
            } else {
                indAstreinte = Integer.parseInt(InterfaceAgent.boxIndeminiteAstreinte.getText());
            }

            if (InterfaceAgent.boxIndeminiteVestimentaire.getText().isBlank()) {
                indVestimentaire = 0;
            } else {
                indVestimentaire = Integer.parseInt(InterfaceAgent.boxIndeminiteVestimentaire.getText());
            }

            if (InterfaceAgent.boxIndeminiteResponsabilite.getText().isBlank()) {
                indReponsabilité = 0;
            } else {
                indReponsabilité = Integer.parseInt(InterfaceAgent.boxIndeminiteResponsabilite.getText());
            }

            if (InterfaceAgent.boxIndeminiteTechnicite.getText().isBlank()) {
                indTechnicite = 0;
            } else {
                indTechnicite = Integer.parseInt(InterfaceAgent.boxIndeminiteTechnicite.getText());
            }
//calcul de la somme des indeminités            
            double sommeIndeminite = indLogement + indAstreinte + indVestimentaire + indReponsabilité + indTechnicite;
            InterfaceAgent.ligne663.setValue(Math.round(sommeIndeminite));//mise a jour de ligne 663

        }

    }

    //mise a jour de laigne 666
    public static void miseAJourLigne666() {
        double alloc;
        if (InterfaceAgent.boxAllocationFamiliale.getText().isBlank()) {
            InterfaceAgent.ligne666.setText("");
        } else {
            alloc = Integer.parseInt(InterfaceAgent.boxAllocationFamiliale.getText());
            InterfaceAgent.ligne666.setValue(Math.round(alloc));//mise a jour de ligne 666
        }
    }

    //calcul de la somme autres dépenses et mise à jour de la ligne 669    
    public static void calculAutreDepenses() {
        double indSpecifique = 0, autreIndemnite = 0, chargeMilitaire = 0;
        if (InterfaceAgent.boxAutreIndeminite.getText().isBlank() && InterfaceAgent.boxChargeMilitaire.getText().isBlank() && InterfaceAgent.boxIndeminiteSpecifique.getText().isBlank()) {
            InterfaceAgent.ligne669.setText("");
        } else {
            if (InterfaceAgent.boxAutreIndeminite.getText().isBlank()) {
                autreIndemnite = 0;
            } else {
                autreIndemnite = Integer.parseInt(InterfaceAgent.boxAutreIndeminite.getText());
            }

            if (InterfaceAgent.boxChargeMilitaire.getText().isBlank()) {
                chargeMilitaire = 0;
            } else {
                chargeMilitaire = Integer.parseInt(InterfaceAgent.boxChargeMilitaire.getText());
            }

            if (InterfaceAgent.boxIndeminiteSpecifique.getText().isBlank()) {
                indSpecifique = 0;
            } else {
                indSpecifique = Integer.parseInt(InterfaceAgent.boxIndeminiteSpecifique.getText());
            }

            //calcul de la somme des indeminités            
            double sommeAutreDepense = autreIndemnite + chargeMilitaire + indSpecifique;
            InterfaceAgent.ligne669.setValue(Math.round(sommeAutreDepense));//mise a jour de ligne 669

        }

    }

    //mise a jour de l'incidence mensuelle et anneulle
    public static void calculIncidenceMensuelleAnnuelle() {
        double inciMensuelle, inciAnnuelle, montantLigne661, montantLigne663, montantLigne664, montantLigne666, montantLigne669;
        if (InterfaceAgent.ligne661.getText().isBlank() && InterfaceAgent.ligne663.getText().isBlank()
                && InterfaceAgent.idLigne664.getText().isBlank() && InterfaceAgent.ligne666.getText().isBlank() && InterfaceAgent.ligne669.getText().isBlank()) {
            InterfaceAgent.boxIncidenceMensuelle.setText("");
            InterfaceAgent.boxIncidenceAnnuelle.setText("");
        } else {

            if (InterfaceAgent.ligne661.getText().isBlank()) {
                montantLigne661 = 0;
            } else {
                montantLigne661 = Integer.parseInt(InterfaceAgent.ligne661.getText());
            }

            if (InterfaceAgent.ligne663.getText().isBlank()) {
                montantLigne663 = 0;
            } else {
                montantLigne663 = Integer.parseInt(InterfaceAgent.ligne663.getText());
            }

            if (InterfaceAgent.idLigne664.getText().isBlank()) {
                montantLigne664 = 0;
            } else {
                montantLigne664 = Integer.parseInt(InterfaceAgent.idLigne664.getText());
            }

            if (InterfaceAgent.ligne666.getText().isBlank()) {
                montantLigne666 = 0;
            } else {
                montantLigne666 = Integer.parseInt(InterfaceAgent.ligne666.getText());
            }

            if (InterfaceAgent.ligne669.getText().isBlank()) {
                montantLigne669 = 0;
            } else {
                montantLigne669 = Integer.parseInt(InterfaceAgent.ligne669.getText());
            }

            //calcul de la somme des lignes pour obtenir l'incidence mensuelle    
            inciMensuelle = montantLigne661 + montantLigne663 + montantLigne664 + montantLigne666 + montantLigne669;
            InterfaceAgent.boxIncidenceMensuelle.setValue(Math.round(inciMensuelle));//mise a jour de l'incidence mensuelle
            InterfaceAgent.boxIncidenceAnnuelle.setValue(Math.round(inciMensuelle) * 12);//mise a jour de l'incidence annuelle
        }
    }

    //Afficher les categories dans le combo
    private static final String querySelectCategorieEchelle = "SELECT * FROM categorie";

    public static void listCategorieInCombo() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectCategorieEchelle)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceAgent.comboCatAgent.addItem(res.getString("codeCategorieEchelle"));
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
                InterfaceAgent.comboEmploiAgent.addItem(res.getString("codeEmploi"));
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
                InterfaceAgent.comboFonction.addItem(res.getString("libeleFonction"));
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
                InterfaceAgent.comboMinistere.addItem(res.getString("codeMinistere"));
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
                InterfaceAgent.comboStructure.addItem(res.getString("codeStructure"));
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
        InterfaceAgent.boxMatriculeAg.setText("");
        InterfaceAgent.boxNomAg.setText("");
        InterfaceAgent.boxPrenomAg.setText("");
        InterfaceAgent.boxDateNaissAg.setText("");
        InterfaceAgent.boxDatePriseServiceAg.setText("");

        InterfaceAgent.boxIndiceSal.setText("");
        InterfaceAgent.boxIndResidence.setText("");
        InterfaceAgent.boxIndeminiteAstreinte.setText("");
        InterfaceAgent.boxIndeminiteTechnicite.setText("");
        InterfaceAgent.boxIndeminiteResponsabilite.setText("");
        InterfaceAgent.boxIndeminiteVestimentaire.setText("");
        InterfaceAgent.boxAutreIndeminite.setText("");
        InterfaceAgent.boxEchelon.setText("");
        InterfaceAgent.boxSalaireIndicMensuel.setText("");
        InterfaceAgent.boxIndeminiteLogement.setText("");
        InterfaceAgent.boxIndeminiteSpecifique.setText("");
        InterfaceAgent.boxChargeMilitaire.setText("");
        InterfaceAgent.boxContributionCARFO.setText("");
        InterfaceAgent.boxContributionCNSS.setText("");
        InterfaceAgent.boxAllocationFamiliale.setText("");

        InterfaceAgent.ligne661.setText("");
        InterfaceAgent.ligne663.setText("");
        InterfaceAgent.idLigne664.setText("");
        InterfaceAgent.ligne666.setText("");
        InterfaceAgent.ligne669.setText("");

        InterfaceAgent.boxIncidenceMensuelle.setText("");
        InterfaceAgent.boxIncidenceAnnuelle.setText("");

        InterfaceAgent.comboSexeAg.setSelectedIndex(0);
        InterfaceAgent.comboTypeAgent.setSelectedIndex(0);
        InterfaceAgent.comboStructure.setSelectedIndex(0);
        InterfaceAgent.comboMinistere.setSelectedIndex(0);
        InterfaceAgent.comboFonction.setSelectedIndex(0);
        InterfaceAgent.comboEmploiAgent.setSelectedIndex(0);

        InterfaceAgent.comboCatAgent.setSelectedIndex(0);

    }

    //recuperation de l'id du programme et l'afficher en fonction de la selection de la structure  
    private static final String querySelectIDProgrammeFromStructure = "SELECT idProgramme FROM structure  where codeStructure = ? ";

    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDProgrammeFromStructure() {
        String codeProg = InterfaceAgent.comboStructure.getSelectedItem().toString();
        if (codeProg.contentEquals(" ")) {
            InterfaceAgent.idProg.setText("");
        } else {

            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDProgrammeFromStructure)) {
                preparedStatement.setString(1, codeProg);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceAgent.idProg.setText(res.getString("idProgramme"));
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

    //afficher l'id du programme dans l'interface de la liste des lignes
    public static void afficherIdProgrammeListeSelectLigne() {
        if (InterfaceAgent.idProg.getText().trim().isBlank()) {
            InterfaceAgent.idProg.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez la structure pour ouvrir la liste des lignes.");
        } else {
            int idP = Integer.parseInt(InterfaceAgent.idProg.getText());
           // System.out.println(idP);
            InterfaceListeLigne listeLigne = new InterfaceListeLigne(new javax.swing.JFrame(), true);
            listeLigne.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
            listeLigne.idProgrammeListeLigne.setValue(idP);
            listeLigne.setVisible(true);

        }
    }
    
    //Selectionner toutes les lignes contenu dans un programme en fonction de la structure choisie    
    private static final String querySelectLigne661 = "SELECT * FROM ligne l, programme p, action a, chapitre c, activite act, article ar, paragraphe para WHERE "
             + " l.idProgramme = ? AND l.idProgramme = p.idProgramme AND l.idAction = a.idAction AND l.idChapitre = c.idChapitre AND l.idActivite = act.idActivite AND l.idArticle = ar.idArticle AND l.idParagraphe = para.idParagraphe ";
    //private static final String querySelectLigne661 = "SELECT * FROM ligne WHERE idProgramme = ?";
    //+ " l.idProgramme = ? ";
    public static void afficherLignesFromProgramme() {
        int idp = Integer.parseInt(InterfaceListeLigne.idProgrammeListeLigne.getText());
         try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectLigne661)) {
            preparedStatement.setInt(1, idp);
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][9];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceListeLigne.tableau_Selectligne.getModel();
            while (InterfaceListeLigne.tableau_Selectligne.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (String[] tab1 : tab) {
                res.next();
                Object[] objects = new Object[9];
                objects[0] = res.getString("l.idLigne");
                objects[1] = res.getString("l.codeLigne");
                objects[2] = res.getString("p.codeProgramme");
                objects[3] = res.getString("a.codeAction");
                objects[4] = res.getString("c.codeChapitre");
                objects[5] = res.getString("act.codeActivite");
                objects[6] = res.getString("ar.codeArticle");
                objects[7] = res.getString("para.codeParagraphe");
                objects[8] = res.getString("montantLigne");
                tablemodel.addRow(objects);
                tab1[0] = res.getString("l.idLigne");
                tab1[1] = res.getString("l.codeLigne");
                tab1[2] = res.getString("p.codeProgramme");
                tab1[3] = res.getString("a.codeAction");
                tab1[4] = res.getString("c.codeChapitre");
                tab1[5] = res.getString("act.codeActivite");
                tab1[6] = res.getString("ar.codeArticle");
                tab1[7] = res.getString("para.codeParagraphe");
                tab1[8] = res.getString("montantLigne");
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

    
    
    
                
           /* try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectLigne661)) {
                // preparedStatement.setInt(1, idP);
                
                //listeLigne.idProgrammeListeLigne.setValue(idP);  
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                   
                }
                res.last();
                tab = new String[res.getRow()][9];
                res.beforeFirst();
                yn = false;
                DefaultTableModel tablemodel = (DefaultTableModel) InterfaceListeLigne.tableau_Selectligne.getModel();
                while (InterfaceListeLigne.tableau_Selectligne.getRowCount() > 0) {
                    tablemodel.removeRow(0);
                }

                for (int k = 0; k < tab.length; k++) {
                    res.next();
                   // tablemodel.addRow();
                    /*tablemodel.setValueAt(res.getString("idLigne"), k, 0);
                    tablemodel.setValueAt(res.getString("codeLigne"), k, 1);
                    tablemodel.setValueAt(res.getString("idProgramme"), k, 2);
                    tablemodel.setValueAt(res.getString("idAction"), k, 3);
                    tablemodel.setValueAt(res.getString("idChapitre"), k, 4);
                    tablemodel.setValueAt(res.getString("idActivite"), k, 5);
                    tablemodel.setValueAt(res.getString("idArticle"), k, 6);
                    tablemodel.setValueAt(res.getString("idParagraphe"), k, 7);
                    tablemodel.setValueAt(res.getString("montantLigne"), k, 8);*/
                         
                    
                    
                    
                    /*Object[] objects = new Object[9];
                    objects[0] = res.getString("l.idLigne");
                    objects[1] = res.getString("l.codeLigne");
                    objects[2] = res.getString("p.codeProgramme");
                    objects[3] = res.getString("a.codeAction");
                    objects[4] = res.getString("c.codeChapitre");
                    objects[5] = res.getString("act.codeActivite");
                    objects[6] = res.getString("ar.codeArticle");
                    objects[7] = res.getString("para.codeParagraphe");
                    objects[8] = res.getString("montantLigne");
                    tablemodel.addRow(objects);
                    tab1[0] = res.getString("l.idLigne");
                    tab1[1] = res.getString("l.codeLigne");
                    tab1[2] = res.getString("p.codeProgramme");
                    tab1[3] = res.getString("a.codeAction");
                    tab1[4] = res.getString("c.codeChapitre");
                    tab1[5] = res.getString("act.codeActivite");
                    tab1[6] = res.getString("ar.codeArticle");
                    tab1[7] = res.getString("para.codeParagraphe");
                    tab1[8] = res.getString("montantLigne");*/                    
                    
                   /* Object[] objects = new Object[9];
                    objects[0] = res.getString("idLigne");
                    objects[1] = res.getString("codeLigne");
                    objects[2] = res.getString("idProgramme");
                    objects[3] = res.getString("idAction");
                    objects[4] = res.getString("idChapitre");
                    objects[5] = res.getString("idActivite");
                    objects[6] = res.getString("idArticle");
                    objects[7] = res.getString("idParagraphe");
                    objects[8] = res.getString("montantLigne");
                    tablemodel.addRow(objects);
                    tab[k][0] = res.getString("idLigne");
                    tab[k][1] = res.getString("codeLigne");
                    tab[k][2] = res.getString("idProgramme");
                    tab[k][3] = res.getString("idAction");
                    tab[k][4] = res.getString("idChapitre");
                    tab[k][5] = res.getString("idActivite");
                    tab[k][6] = res.getString("idArticle");
                    tab[k][7] = res.getString("idParagraphe");
                    tab[k][8] = res.getString("montantLigne");
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
    }*/

    //Enregistrer un agent
    private static final String queryInsert = "INSERT INTO agent (matriculeAgent, nomAgent, prenomAgent, dateNaissanceAgent, sexeAgent, datePriseServiceAgent, typeAgent, structureAgent, ministereOrigineAgent, fonctionAgent, emploiAgent, categorieEchelleAgent, echelonAgent, \n"
            + "indiceAgent, salaireIndiciaireAgent, indeminiteResidence, indeminiteAstreinte, indeminiteTechnicite, indeminiteResponsabilite, indeminiteVestimentaire, indeminiteLogement, indeminiteSpecifique, autreIndeminite, chargeMilitaire, \n"
            + "contributionCARFO, contributionCNSS, allocationFamiliale, montantLigne661, montantLigne663, montantLigne664, montantLigne666, montantLigne669, incidenceMensuelle, incidenceAnnuelle) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public static void saveAgent(Agent agent) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setString(1, agent.getMatriculeA());
            preparedStatement.setString(2, agent.getNomA());
            preparedStatement.setString(3, agent.getPrenomA());
            preparedStatement.setString(4, agent.getDateNaissanceA());
            preparedStatement.setString(5, agent.getSexeA());

            preparedStatement.setString(6, agent.getDatePriseServiceA());
            preparedStatement.setString(7, agent.getTypeA());
            preparedStatement.setString(8, agent.getStructureA());
            preparedStatement.setString(9, agent.getMinistereOrigineA());
            preparedStatement.setString(10, agent.getFonctionA());
            preparedStatement.setString(11, agent.getEmploiA());

            preparedStatement.setString(12, agent.getCategorieEchelleA());
            preparedStatement.setInt(13, agent.getEchelonA());
            preparedStatement.setInt(14, agent.getIndiceA());
            preparedStatement.setDouble(15, agent.getSalaireIndiciaireA());
            preparedStatement.setDouble(16, agent.getIndeminiteResidence());
            preparedStatement.setDouble(17, agent.getIndeminiteAstreinte());
            preparedStatement.setDouble(18, agent.getIndeminiteTechnicite());
            preparedStatement.setDouble(19, agent.getIndeminiteResponsabilite());
            preparedStatement.setDouble(20, agent.getIndeminiteVestimentaire());
            preparedStatement.setDouble(21, agent.getIndeminiteLogement());
            preparedStatement.setDouble(22, agent.getIndeminiteSpecifique());
            preparedStatement.setDouble(23, agent.getAutreIndeminite());
            preparedStatement.setDouble(24, agent.getChargeMilitaire());
            preparedStatement.setDouble(25, agent.getContributionCARFO());
            preparedStatement.setDouble(26, agent.getContributionCNSS());
            preparedStatement.setDouble(27, agent.getAllocationFamiliale());

            preparedStatement.setDouble(28, agent.getMontant661());
            preparedStatement.setDouble(29, agent.getMontant663());
            preparedStatement.setDouble(30, agent.getMontant664());
            preparedStatement.setDouble(31, agent.getMontant666());
            preparedStatement.setDouble(32, agent.getMontant669());

            preparedStatement.setDouble(33, agent.getIncidenceM());
            preparedStatement.setDouble(34, agent.getIncidenceA());

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

    /*Lister tous les agents*/
    private static final String querySelect = "SELECT idAgent, matriculeAgent, nomAgent, prenomAgent, structureAgent FROM agent ";

    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][5];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceAgent.tableau_agent.getModel();
            while (InterfaceAgent.tableau_agent.getRowCount() > 0) {
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
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    }

    //Mise a jour de des lignes
    private static final String querySelectStructureAgent = "SELECT * FROM  structure s, agent a WHERE a.structureAgent = ? AND a.structureAgent =  s.codeStructure ";
    public static void updateLigne() {
        String selectStructure = InterfaceAgent.comboStructure.getSelectedItem().toString();
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectStructureAgent)) {
            preparedStatement.setString(1, selectStructure);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                int idP = res.getInt("s.idProgramme");
                String queryUpdate = "UPDATE ligne SET codeMinistere = ?, libeleMinistere=? WHERE idMinistere= ?";
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
