/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Agent;
import com.mae.vue.InterfaceAgent;
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
import java.math.BigDecimal;

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
            String coeffSaisie = InterfaceAgent.coefficientStruc.getText().replace(",", ".");
            double aCoefficient = Double.parseDouble(coeffSaisie);            
            
            double salIndicaire = ((indiceS * pointIndiciare) / 12) * aCoefficient ; //salaire indiciaire mensuel = (indice*point /12) * coefficient de correction
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
                    InterfaceAgent.ligne664.setValue(Math.round(contriCARFO));
                    InterfaceAgent.boxContributionCNSS.setText("");
                    break;

                case "Contractuel":
                    double contriCNSS = (salIndicaire * tauxCNSS) / 100;
                    InterfaceAgent.boxContributionCNSS.setValue(Math.round(contriCNSS));
                    InterfaceAgent.ligne664.setValue(Math.round(contriCNSS));
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
            
            String coeffSaisie = InterfaceAgent.coefficientStruc.getText().replace(",", ".");
            double aCoefficient = Double.parseDouble(coeffSaisie); 
//calcul de la somme des indeminités            
            double sommeIndeminite = (indLogement) + (indAstreinte) + (indVestimentaire*aCoefficient) + (indReponsabilité) + (indTechnicite);
            InterfaceAgent.ligne663.setValue(Math.round(sommeIndeminite));//mise a jour de ligne 663

        }

    }

    //mise a jour de laigne 666
    public static void miseAJourLigne666() {
        double alloc;
        if (InterfaceAgent.boxAllocationFamiliale.getText().isBlank() || InterfaceAgent.coefficientStruc.getText().isBlank()) {
            InterfaceAgent.ligne666.setText("");
            InterfaceAgent.coefficientStruc.setText("");
        } else {
            String coeffSaisie = InterfaceAgent.coefficientStruc.getText().replace(",", ".");
            double aCoefficient = Double.parseDouble(coeffSaisie);    
            alloc = Integer.parseInt(InterfaceAgent.boxAllocationFamiliale.getText()) * aCoefficient;
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
            String coeffSaisie = InterfaceAgent.coefficientStruc.getText().replace(",", ".");
            double aCoefficient = Double.parseDouble(coeffSaisie);    
            //calcul de la somme des indeminités            
            double sommeAutreDepense = (autreIndemnite) + (chargeMilitaire * aCoefficient) + (indSpecifique);
            InterfaceAgent.ligne669.setValue(Math.round(sommeAutreDepense));//mise a jour de ligne 669

        }

    }

    //mise a jour de l'incidence mensuelle et anneulle
    public static void calculIncidenceMensuelleAnnuelle() {
        double inciMensuelle, inciAnnuelle, montantLigne661, montantLigne663, montantLigne664, montantLigne666, montantLigne669;
        if (InterfaceAgent.ligne661.getText().isBlank() && InterfaceAgent.ligne663.getText().isBlank()
                && InterfaceAgent.ligne664.getText().isBlank() && InterfaceAgent.ligne666.getText().isBlank() && InterfaceAgent.ligne669.getText().isBlank()) {
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

            if (InterfaceAgent.ligne664.getText().isBlank()) {
                montantLigne664 = 0;
            } else {
                montantLigne664 = Integer.parseInt(InterfaceAgent.ligne664.getText());
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
        InterfaceAgent.boxIDAgent.setText("");
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
        InterfaceAgent.ligne664.setText("");
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

        InterfaceAgent.idProg.setText("");
        InterfaceAgent.ligne661.setBackground(new java.awt.Color(204, 0, 0));
        InterfaceAgent.ligne663.setBackground(new java.awt.Color(204, 0, 0));
        InterfaceAgent.ligne664.setBackground(new java.awt.Color(204, 0, 0));
        InterfaceAgent.ligne666.setBackground(new java.awt.Color(204, 0, 0));
        InterfaceAgent.ligne669.setBackground(new java.awt.Color(204, 0, 0));

        InterfaceAgent.idLigne661.setText("");
        InterfaceAgent.idLigne663.setText("");
        InterfaceAgent.idLigne664.setText("");
        InterfaceAgent.idLigne666.setText("");
        InterfaceAgent.idLigne669.setText("");

    }

    //recuperation de l'id du programme et l'afficher en fonction de la selection de la structure  
    private static final String querySelectIDProgrammeFromStructure = "SELECT idProgramme, coefficientStructure FROM structure  where codeStructure = ? ";

    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDProgrammeFromStructure() {
        String codeProg = InterfaceAgent.comboStructure.getSelectedItem().toString();
        if (codeProg.contentEquals(" ")) {
            InterfaceAgent.idProg.setText("");
            InterfaceAgent.coefficientStruc.setText("");
            InterfaceAgent.ligne661.setBackground(new java.awt.Color(204, 0, 0));
            InterfaceAgent.ligne663.setBackground(new java.awt.Color(204, 0, 0));
            InterfaceAgent.ligne664.setBackground(new java.awt.Color(204, 0, 0));
            InterfaceAgent.ligne666.setBackground(new java.awt.Color(204, 0, 0));
            InterfaceAgent.ligne669.setBackground(new java.awt.Color(204, 0, 0));

            InterfaceAgent.idLigne661.setText("");
            InterfaceAgent.idLigne663.setText("");
            InterfaceAgent.idLigne664.setText("");
            InterfaceAgent.idLigne666.setText("");
            InterfaceAgent.idLigne669.setText("");

        } else {

            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDProgrammeFromStructure)) {
                preparedStatement.setString(1, codeProg);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceAgent.idProg.setText(res.getString("idProgramme"));
                    InterfaceAgent.coefficientStruc.setText(String.format("%.1f", res.getDouble("coefficientStructure")));                  
                    InterfaceAgent.ligne661.setBackground(new java.awt.Color(204, 0, 0));
                    InterfaceAgent.ligne663.setBackground(new java.awt.Color(204, 0, 0));
                    InterfaceAgent.ligne664.setBackground(new java.awt.Color(204, 0, 0));
                    InterfaceAgent.ligne666.setBackground(new java.awt.Color(204, 0, 0));
                    InterfaceAgent.ligne669.setBackground(new java.awt.Color(204, 0, 0));

                    InterfaceAgent.idLigne661.setText("");
                    InterfaceAgent.idLigne663.setText("");
                    InterfaceAgent.idLigne664.setText("");
                    InterfaceAgent.idLigne666.setText("");
                    InterfaceAgent.idLigne669.setText("");
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

    //afficher l'id du programme dans l'interface de la liste des lignes correspondantes au 661
    public static void afficherIdProgrammeListeSelectLigne661() {
        if (InterfaceAgent.idProg.getText().trim().isBlank()) {
            InterfaceAgent.idProg.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez la structure pour ouvrir la liste des lignes.");
        } else {
            int idP = Integer.parseInt(InterfaceAgent.idProg.getText());
            // System.out.println(idP);
            InterfaceListeLigne661 listeLigne661 = new InterfaceListeLigne661(new javax.swing.JFrame(), true);
            listeLigne661.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
            listeLigne661.idProgrammeListeLigne661.setValue(idP);
            listeLigne661.setVisible(true);

        }
    }

    //afficher l'id du programme dans l'interface de la liste des lignes correspondantes au 663
    public static void afficherIdProgrammeListeSelectLigne663() {
        if (InterfaceAgent.idProg.getText().trim().isBlank()) {
            InterfaceAgent.idProg.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez la structure pour ouvrir la liste des lignes.");
        } else {
            int idP = Integer.parseInt(InterfaceAgent.idProg.getText());
            // System.out.println(idP);
            InterfaceListeLigne663 listeLigne663 = new InterfaceListeLigne663(new javax.swing.JFrame(), true);
            listeLigne663.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
            listeLigne663.idProgrammeListeLigne663.setValue(idP);
            listeLigne663.setVisible(true);
        }
    }

    //afficher l'id du programme dans l'interface de la liste des lignes correspondantes au 664
    public static void afficherIdProgrammeListeSelectLigne664() {
        if (InterfaceAgent.idProg.getText().trim().isBlank()) {
            InterfaceAgent.idProg.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez la structure pour ouvrir la liste des lignes.");
        } else {
            int idP = Integer.parseInt(InterfaceAgent.idProg.getText());
            // System.out.println(idP);
            InterfaceListeLigne664 listeLigne664 = new InterfaceListeLigne664(new javax.swing.JFrame(), true);
            listeLigne664.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
            listeLigne664.idProgrammeListeLigne664.setValue(idP);
            listeLigne664.setVisible(true);

        }
    }

    //afficher l'id du programme dans l'interface de la liste des lignes correspondantes au 6666
    public static void afficherIdProgrammeListeSelectLigne666() {
        if (InterfaceAgent.idProg.getText().trim().isBlank()) {
            InterfaceAgent.idProg.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez la structure pour ouvrir la liste des lignes.");
        } else {
            int idP = Integer.parseInt(InterfaceAgent.idProg.getText());
            // System.out.println(idP);
            InterfaceListeLigne666 listeLigne666 = new InterfaceListeLigne666(new javax.swing.JFrame(), true);
            listeLigne666.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
            listeLigne666.idProgrammeListeLigne666.setValue(idP);
            listeLigne666.setVisible(true);

        }
    }

    //afficher l'id du programme dans l'interface de la liste des lignes correspondantes au 669
    public static void afficherIdProgrammeListeSelectLigne669() {
        if (InterfaceAgent.idProg.getText().trim().isBlank()) {
            InterfaceAgent.idProg.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez la structure pour ouvrir la liste des lignes.");
        } else {
            int idP = Integer.parseInt(InterfaceAgent.idProg.getText());
            // System.out.println(idP);
            InterfaceListeLigne669 listeLigne669 = new InterfaceListeLigne669(new javax.swing.JFrame(), true);
            listeLigne669.setIconImage(new ImageIcon("C:/deper/src/main/resources/iconapp.png").getImage());
            listeLigne669.idProgrammeListeLigne669.setValue(idP);
            listeLigne669.setVisible(true);

        }
    }

    //Selectionner toutes les lignes contenu dans un programme en fonction de la structure choisie    
    private static final String querySelectLigne661 = "SELECT * FROM ligne l, programme p, action a, chapitre c, activite act, article ar, paragraphe para WHERE "
            + " l.idProgramme = ? AND l.idProgramme = p.idProgramme AND l.idAction = a.idAction AND l.idChapitre = c.idChapitre AND l.idActivite = act.idActivite AND l.idArticle = ar.idArticle AND l.idParagraphe = para.idParagraphe AND para.codeParagraphe LIKE '661%'";

    public static void afficherLignesFromProgramme661() {
        int idp = Integer.parseInt(InterfaceListeLigne661.idProgrammeListeLigne661.getText());
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectLigne661)) {
            preparedStatement.setInt(1, idp);
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][9];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceListeLigne661.tableau_Selectligne.getModel();
            while (InterfaceListeLigne661.tableau_Selectligne.getRowCount() > 0) {
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
    /**
     * **************************************************Afficher la liste pour
     * les 663***********************************************************************************************
     */
    //Selectionner toutes les lignes contenu dans un programme en fonction de la structure choisie    
    private static final String querySelectLigne663 = "SELECT * FROM ligne l, programme p, action a, chapitre c, activite act, article ar, paragraphe para WHERE "
            + " l.idProgramme = ? AND l.idProgramme = p.idProgramme AND l.idAction = a.idAction AND l.idChapitre = c.idChapitre AND l.idActivite = act.idActivite AND l.idArticle = ar.idArticle AND l.idParagraphe = para.idParagraphe AND para.codeParagraphe LIKE '663%' ";

    public static void afficherLignesFromProgramme663() {
        int idp = Integer.parseInt(InterfaceListeLigne663.idProgrammeListeLigne663.getText());
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectLigne663)) {
            preparedStatement.setInt(1, idp);
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][9];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceListeLigne663.tableau_Selectligne.getModel();
            while (InterfaceListeLigne663.tableau_Selectligne.getRowCount() > 0) {
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

    /**
     * **************************************************Afficher la liste pour
     * les 664***********************************************************************************************
     */
    //Selectionner toutes les lignes contenu dans un programme en fonction de la structure choisie    
    private static final String querySelectLigne664 = "SELECT * FROM ligne l, programme p, action a, chapitre c, activite act, article ar, paragraphe para WHERE "
            + " l.idProgramme = ? AND l.idProgramme = p.idProgramme AND l.idAction = a.idAction AND l.idChapitre = c.idChapitre AND l.idActivite = act.idActivite AND l.idArticle = ar.idArticle AND l.idParagraphe = para.idParagraphe AND para.codeParagraphe LIKE '664%' ";

    public static void afficherLignesFromProgramme664() {
        int idp = Integer.parseInt(InterfaceListeLigne664.idProgrammeListeLigne664.getText());
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectLigne664)) {
            preparedStatement.setInt(1, idp);
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][9];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceListeLigne664.tableau_Selectligne.getModel();
            while (InterfaceListeLigne664.tableau_Selectligne.getRowCount() > 0) {
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

    /**
     * **************************************************Afficher la liste pour
     * les 666***********************************************************************************************
     */
    //Selectionner toutes les lignes contenu dans un programme en fonction de la structure choisie    
    private static final String querySelectLigne666 = "SELECT * FROM ligne l, programme p, action a, chapitre c, activite act, article ar, paragraphe para WHERE "
            + " l.idProgramme = ? AND l.idProgramme = p.idProgramme AND l.idAction = a.idAction AND l.idChapitre = c.idChapitre AND l.idActivite = act.idActivite AND l.idArticle = ar.idArticle AND l.idParagraphe = para.idParagraphe AND para.codeParagraphe LIKE '666%' ";

    public static void afficherLignesFromProgramme666() {
        int idp = Integer.parseInt(InterfaceListeLigne666.idProgrammeListeLigne666.getText());
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectLigne666)) {
            preparedStatement.setInt(1, idp);
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][9];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceListeLigne666.tableau_Selectligne.getModel();
            while (InterfaceListeLigne666.tableau_Selectligne.getRowCount() > 0) {
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

    /**
     * **************************************************Afficher la liste pour
     * les 669***********************************************************************************************
     */
    //Selectionner toutes les lignes contenu dans un programme en fonction de la structure choisie    
    private static final String querySelectLigne669 = "SELECT * FROM ligne l, programme p, action a, chapitre c, activite act, article ar, paragraphe para WHERE "
            + " l.idProgramme = ? AND l.idProgramme = p.idProgramme AND l.idAction = a.idAction AND l.idChapitre = c.idChapitre AND l.idActivite = act.idActivite AND l.idArticle = ar.idArticle AND l.idParagraphe = para.idParagraphe AND para.codeParagraphe LIKE '669%'";

    public static void afficherLignesFromProgramme669() {
        int idp = Integer.parseInt(InterfaceListeLigne669.idProgrammeListeLigne669.getText());
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectLigne669)) {
            preparedStatement.setInt(1, idp);
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][9];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceListeLigne669.tableau_Selectligne.getModel();
            while (InterfaceListeLigne669.tableau_Selectligne.getRowCount() > 0) {
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

    // Recuperation de l'id de la ligne selectionnée 661
    public static int nbreligne, numligne;
    private static final String querySelectOneLigne = "SELECT * FROM ligne WHERE idLigne = ? ";

    public static void recupIDLigne661() {
        nbreligne = InterfaceListeLigne661.tableau_Selectligne.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceListeLigne661.tableau_Selectligne.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            // InterfaceListeLigne661.codeArticle.setText("");            
            JOptionPane.showMessageDialog(null, "Sélectionnez une ligne");
            //System.out.println(nbreligne);
        } else {
            int idL = Integer.parseInt(InterfaceListeLigne661.tableau_Selectligne.getValueAt(numligne, 0).toString());   //recuperer l'id de la ligne 
            InterfaceAgent.ligne661.setBackground(new java.awt.Color(0, 102, 51));
            InterfaceAgent.idLigne661.setText(String.valueOf(idL));
        }
        /* try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneLigne)) {
            preparedStatement.setInt(1, idL);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceAgent.ligne661.setBackground(new java.awt.Color(0, 102, 51));
                InterfaceAgent.idLigne661.setText(res.getString("idLigne"));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }*/
    }

    public static void recupIDLigne663() {
        nbreligne = InterfaceListeLigne663.tableau_Selectligne.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceListeLigne663.tableau_Selectligne.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            // InterfaceListeLigne661.codeArticle.setText("");            
            JOptionPane.showMessageDialog(null, "Sélectionnez une ligne");
            //System.out.println(nbreligne);
        } else {
            int idL = Integer.parseInt(InterfaceListeLigne663.tableau_Selectligne.getValueAt(numligne, 0).toString());   //recuperer l'id de la ligne    
            InterfaceAgent.ligne663.setBackground(new java.awt.Color(0, 102, 51));
            InterfaceAgent.idLigne663.setText(String.valueOf(idL));
        }
        /*try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneLigne)) {
            preparedStatement.setInt(1, idL);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceAgent.ligne663.setBackground(new java.awt.Color(0, 102, 51));
                InterfaceAgent.idLigne663.setText(res.getString("idLigne"));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }*/
    }

    public static void recupIDLigne664() {
        nbreligne = InterfaceListeLigne664.tableau_Selectligne.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceListeLigne664.tableau_Selectligne.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            // InterfaceListeLigne661.codeArticle.setText("");            
            JOptionPane.showMessageDialog(null, "Sélectionnez une ligne");
            //System.out.println(nbreligne);
        } else {
            int idL = Integer.parseInt(InterfaceListeLigne664.tableau_Selectligne.getValueAt(numligne, 0).toString());   //recuperer l'id de la ligne 
            InterfaceAgent.ligne664.setBackground(new java.awt.Color(0, 102, 51));
            InterfaceAgent.idLigne664.setText(String.valueOf(idL));
        }
        /*try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneLigne)) {
            preparedStatement.setInt(1, idL);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceAgent.ligne664.setBackground(new java.awt.Color(0, 102, 51));
                InterfaceAgent.idLigne664.setText(res.getString("idLigne"));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }*/
    }

    public static void recupIDLigne666() {
        nbreligne = InterfaceListeLigne666.tableau_Selectligne.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceListeLigne666.tableau_Selectligne.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            // InterfaceListeLigne661.codeArticle.setText("");            
            JOptionPane.showMessageDialog(null, "Sélectionnez une ligne");
            //System.out.println(nbreligne);
        } else {
            int idL = Integer.parseInt(InterfaceListeLigne666.tableau_Selectligne.getValueAt(numligne, 0).toString());   //recuperer l'id de la ligne  
            InterfaceAgent.ligne666.setBackground(new java.awt.Color(0, 102, 51));
            InterfaceAgent.idLigne666.setText(String.valueOf(idL));

        }
        /*try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneLigne)) {
            preparedStatement.setInt(1, idL);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceAgent.ligne666.setBackground(new java.awt.Color(0, 102, 51));
                InterfaceAgent.idLigne666.setText(res.getString("idLigne"));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }*/
    }

    public static void recupIDLigne669() {
        nbreligne = InterfaceListeLigne669.tableau_Selectligne.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceListeLigne669.tableau_Selectligne.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            // InterfaceListeLigne661.codeArticle.setText("");            
            JOptionPane.showMessageDialog(null, "Sélectionnez une ligne");
            //System.out.println(nbreligne);
        } else {
            int idL = Integer.parseInt(InterfaceListeLigne669.tableau_Selectligne.getValueAt(numligne, 0).toString());   //recuperer l'id de la ligne
            InterfaceAgent.ligne669.setBackground(new java.awt.Color(0, 102, 51));
            InterfaceAgent.idLigne669.setText(String.valueOf(idL));
        }
        /*try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneLigne)) {
            preparedStatement.setInt(1, idL);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceAgent.ligne669.setBackground(new java.awt.Color(0, 102, 51));
                InterfaceAgent.idLigne669.setText(res.getString("idLigne"));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }*/
    }

    //Enregistrer un agent
    private static final String queryInsert = "INSERT INTO agent (matriculeAgent, nomAgent, prenomAgent, dateNaissanceAgent, sexeAgent, datePriseServiceAgent, typeAgent, structureAgent, ministereOrigineAgent, fonctionAgent, emploiAgent, categorieEchelleAgent, echelonAgent, \n"
            + "indiceAgent, salaireIndiciaireAgent, indeminiteResidence, indeminiteAstreinte, indeminiteTechnicite, indeminiteResponsabilite, indeminiteVestimentaire, indeminiteLogement, indeminiteSpecifique, autreIndeminite, chargeMilitaire, \n"
            + "contributionCARFO, contributionCNSS, allocationFamiliale, montantLigne661, montantLigne663, montantLigne664, montantLigne666, montantLigne669, incidenceMensuelle, incidenceAnnuelle, idLigne661, idLigne663, idLigne664, idLigne666, idLigne669) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
            preparedStatement.setInt(35, agent.getIdL661());
            preparedStatement.setInt(36, agent.getIdL663());
            preparedStatement.setInt(37, agent.getIdL664());
            preparedStatement.setInt(38, agent.getIdL666());
            preparedStatement.setInt(39, agent.getIdL669());

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
    
     
     //Modifier un agent
    public static void updateAgent(Agent agent) {
        idAg = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());   //recuperer l'id 
        String queryUpdate = """
                             UPDATE agent SET  matriculeAgent = ?, nomAgent = ?, prenomAgent = ?, dateNaissanceAgent = ?, sexeAgent = ?, datePriseServiceAgent = ?, typeAgent = ?, structureAgent = ?, ministereOrigineAgent = ?, fonctionAgent = ?, emploiAgent = ?, categorieEchelleAgent = ?, echelonAgent = ?, 
                             indiceAgent = ?, salaireIndiciaireAgent = ?, indeminiteResidence = ?, indeminiteAstreinte = ?, indeminiteTechnicite = ?, indeminiteResponsabilite = ?, indeminiteVestimentaire = ?, indeminiteLogement = ?, indeminiteSpecifique = ?, autreIndeminite = ?, chargeMilitaire = ?, 
                             contributionCARFO = ?, contributionCNSS = ?, allocationFamiliale = ?, montantLigne661 = ?, montantLigne663 = ?, montantLigne664 = ?, montantLigne666 = ?, montantLigne669 = ?, incidenceMensuelle = ?, incidenceAnnuelle = ?, idLigne661 = ?, idLigne663 = ?, idLigne664 = ?, idLigne666 = ?, idLigne669 = ? WHERE idAgent = ?""";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
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
            preparedStatement.setInt(35, agent.getIdL661());
            preparedStatement.setInt(36, agent.getIdL663());
            preparedStatement.setInt(37, agent.getIdL664());
            preparedStatement.setInt(38, agent.getIdL666());
            preparedStatement.setInt(39, agent.getIdL669());
            preparedStatement.setInt(40, idAg);                   
            
            
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
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
  /*  private static final String querySelectLigne = "SELECT * FROM ligne WHERE idLigne IN (?, ?, ?, ?, ?)";

    public static void updateLigne() {
        //recuperation des valeur id des lignes
        int LigneID661 = Integer.parseInt(InterfaceAgent.idLigne661.getText());
        int LigneID663 = Integer.parseInt(InterfaceAgent.idLigne663.getText());
        int LigneID664 = Integer.parseInt(InterfaceAgent.idLigne664.getText());
        int LigneID666 = Integer.parseInt(InterfaceAgent.idLigne666.getText());
        int LigneID669 = Integer.parseInt(InterfaceAgent.idLigne669.getText());

        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectLigne)) {
            preparedStatement.setInt(1, LigneID661);
            preparedStatement.setInt(2, LigneID663);
            preparedStatement.setInt(3, LigneID664);
            preparedStatement.setInt(4, LigneID666);
            preparedStatement.setInt(5, LigneID669);
            ResultSet res = preparedStatement.executeQuery();
            System.out.println(res.getInt("montantLigne"));
            // if (res.next()) {
            for (int k = 0; k < 5; k++) {
                res.next();
                switch (k) {
                    case 0 -> {
                        int valeurLigne661 = res.getInt("montantLigne") + Integer.parseInt(InterfaceAgent.ligne661.getText());
                        int valeurFinalLigne661 = valeurLigne661 + Integer.parseInt(InterfaceAgent.ligne661.getText());
                        String queryUpdateMontant661 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                        try (PreparedStatement preparedStatement661 = connection.prepareStatement(queryUpdateMontant661)) {
                            preparedStatement661.setInt(1, valeurFinalLigne661);                            
                            preparedStatement661.setInt(2, LigneID661);
                            preparedStatement661.executeUpdate();
                            preparedStatement661.close();
                           // connection.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                        }
                    }
                    case 1 -> {
                        int valeurLigne663 = res.getInt("montantLigne") + Integer.parseInt(InterfaceAgent.ligne663.getText());
                        int valeurFinalLigne663 = valeurLigne663 + Integer.parseInt(InterfaceAgent.ligne663.getText());
                        String queryUpdateMontant663 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                        try (PreparedStatement preparedStatement663 = connection.prepareStatement(queryUpdateMontant663)) {
                            preparedStatement663.setInt(1, valeurFinalLigne663);
                            preparedStatement663.setInt(4, LigneID663);
                            preparedStatement663.executeUpdate();
                            preparedStatement663.close();
                            // connection.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                        }
                    }

                    case 2 -> {
                        int valeurLigne664 = res.getInt("montantLigne") + Integer.parseInt(InterfaceAgent.ligne664.getText());
                        int valeurFinalLigne664 = valeurLigne664 + Integer.parseInt(InterfaceAgent.ligne666.getText());
                        String queryUpdateMontant664 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                        try (PreparedStatement preparedStatement664 = connection.prepareStatement(queryUpdateMontant664)) {
                            preparedStatement664.setInt(1, valeurFinalLigne664);
                            preparedStatement664.setInt(2, LigneID664);
                            preparedStatement664.executeUpdate();
                            preparedStatement664.close();
                            // connection.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                        }
                    }
                    case 3 -> {
                        int valeurLigne666 = res.getInt("montantLigne") + Integer.parseInt(InterfaceAgent.ligne666.getText());
                         String queryUpdateMontant666 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                        try (PreparedStatement preparedStatement666 = connection.prepareStatement(queryUpdateMontant666)) {
                            preparedStatement666.setInt(1, valeurLigne666);
                            preparedStatement666.setInt(2, LigneID666);
                            preparedStatement666.executeUpdate();
                            preparedStatement666.close();
                            // connection.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                        }
                    }
                    case 4 -> {
                        int valeurLigne669 = res.getInt("montantLigne") + Integer.parseInt(InterfaceAgent.ligne669.getText());
                        int valeurFinalLigne669 = valeurLigne669 + Integer.parseInt(InterfaceAgent.ligne669.getText());
                         String queryUpdateMontant669 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                        try (PreparedStatement preparedStatement669 = connection.prepareStatement(queryUpdateMontant669)) {
                            preparedStatement669.setInt(1, valeurFinalLigne669);
                            preparedStatement669.setInt(2, LigneID669);
                            preparedStatement669.executeUpdate();
                            preparedStatement669.close();
                            // connection.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                        }
                    }
                    default -> {//ne rien faire par defaut
                    }
                }

                //   String queryUpdate = "UPDATE ligne SET codeMinistere = ?, libeleMinistere=? WHERE idMinistere= ?";
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
    
    //Mise a jour du montant de la ligne 661
    private static final String querySelectionLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
    public static void updateLigne661() {
       // if (InterfaceAgent.idLigne661.getText().isBlank()) {
          //  JOptionPane.showMessageDialog(null, "Sélectionnez la ligne 661 correspondante");

       // } else {
            int LigneID661 = Integer.parseInt(InterfaceAgent.idLigne661.getText());
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne661)) {
                preparedStatement.setInt(1, LigneID661);
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        int valeurLigne661 = res.getInt("montantLigne");
                        int valeurFinalLigne661 = valeurLigne661 + Integer.parseInt(InterfaceAgent.ligne661.getText());
                        String queryUpdateMontant661 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                        try (PreparedStatement preparedStatement661 = connection.prepareStatement(queryUpdateMontant661)) {
                            preparedStatement661.setInt(1, valeurFinalLigne661);
                            preparedStatement661.setInt(2, LigneID661);
                            preparedStatement661.executeUpdate();
                            preparedStatement661.close();
                            // connection.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
      //  }

    }

    //Mise a jour du montant de la ligne 663
    private static final String querySelectionLigne663 = "SELECT * FROM ligne WHERE idLigne = ?";

    public static void updateLigne663() {
       // if (InterfaceAgent.idLigne663.getText().isBlank()) {
          //  JOptionPane.showMessageDialog(null, "Sélectionnez la ligne 663 correspondante");

      //  } else {
            int LigneID663 = Integer.parseInt(InterfaceAgent.idLigne663.getText());
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne663)) {
                preparedStatement.setInt(1, LigneID663);
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        int valeurLigne663 = res.getInt("montantLigne");
                        int valeurFinalLigne663 = valeurLigne663 + Integer.parseInt(InterfaceAgent.ligne663.getText());
                        String queryUpdateMontant663 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                        try (PreparedStatement preparedStatement663 = connection.prepareStatement(queryUpdateMontant663)) {
                            preparedStatement663.setInt(1, valeurFinalLigne663);
                            preparedStatement663.setInt(2, LigneID663);
                            preparedStatement663.executeUpdate();
                            preparedStatement663.close();
                            // connection.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
      //  }
    }

    //Mise a jour du montant de la ligne 664
    private static final String querySelectionLigne664 = "SELECT * FROM ligne WHERE idLigne = ?";

    public static void updateLigne664() {
       // if (InterfaceAgent.idLigne664.getText().isBlank()) {
       //     JOptionPane.showMessageDialog(null, "Sélectionnez la ligne 664 correspondante");

     //   } else {
            int LigneID664 = Integer.parseInt(InterfaceAgent.idLigne664.getText());
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne664)) {
                preparedStatement.setInt(1, LigneID664);
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        int valeurLigne664 = res.getInt("montantLigne");
                        int valeurFinalLigne664 = valeurLigne664 + Integer.parseInt(InterfaceAgent.ligne664.getText());
                        String queryUpdateMontant664 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                        try (PreparedStatement preparedStatement664 = connection.prepareStatement(queryUpdateMontant664)) {
                            preparedStatement664.setInt(1, valeurFinalLigne664);
                            preparedStatement664.setInt(2, LigneID664);
                            preparedStatement664.executeUpdate();
                            preparedStatement664.close();
                            // connection.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
      //  }
    }

    //Mise a jour du montant de la ligne 666
    private static final String querySelectionLigne666 = "SELECT * FROM ligne WHERE idLigne = ?";

    public static void updateLigne666() {
       // if (InterfaceAgent.idLigne666.getText().isBlank()) {
        //    JOptionPane.showMessageDialog(null, "Sélectionnez la ligne 666 correspondante");

       // } else {
            int LigneID666 = Integer.parseInt(InterfaceAgent.idLigne666.getText());
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne666)) {
                preparedStatement.setInt(1, LigneID666);
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        int valeurLigne666 = res.getInt("montantLigne");
                        int valeurFinalLigne666 = valeurLigne666 + Integer.parseInt(InterfaceAgent.ligne666.getText());
                        String queryUpdateMontant666 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                        try (PreparedStatement preparedStatement666 = connection.prepareStatement(queryUpdateMontant666)) {
                            preparedStatement666.setInt(1, valeurFinalLigne666);
                            preparedStatement666.setInt(2, LigneID666);
                            preparedStatement666.executeUpdate();
                            preparedStatement666.close();
                            // connection.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
       //// }
//
    }
//Mise a jour du montant de la ligne 669
    private static final String querySelectionLigne669 = "SELECT * FROM ligne WHERE idLigne = ?";

    public static void updateLigne669() {
        //if (InterfaceAgent.idLigne669.getText().isBlank()) {
       //     JOptionPane.showMessageDialog(null, "Sélectionnez la ligne 669 correspondante");

      //  } else {
            int LigneID669 = Integer.parseInt(InterfaceAgent.idLigne669.getText());
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne669)) {
                preparedStatement.setInt(1, LigneID669);
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        int valeurLigne669 = res.getInt("montantLigne");
                        int valeurFinalLigne669 = valeurLigne669 + Integer.parseInt(InterfaceAgent.ligne669.getText());
                        String queryUpdateMontant669 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                        try (PreparedStatement preparedStatement669 = connection.prepareStatement(queryUpdateMontant669)) {
                            preparedStatement669.setInt(1, valeurFinalLigne669);
                            preparedStatement669.setInt(2, LigneID669);
                            preparedStatement669.executeUpdate();
                            preparedStatement669.close();
                            // connection.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
        //}

    }
    
    
      //Mise a jour du montant de la ligne 661 lors de la mise à jours de l'agent
    private static final String querySelectionLigne661Update = "SELECT * FROM ligne WHERE idLigne = ?";
    private static final String querySelectionValActuelLigne661Agent = "SELECT montantLigne661 agent WHERE idAgent = ? ";
    public static void updateLigne661ForUpdate() {      
            int LigneID661 = Integer.parseInt(InterfaceAgent.idLigne661.getText());///id de la ligne budgetaire
            int idA = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());//id de l'agent
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne661Update)) {
                preparedStatement.setInt(1, LigneID661);                
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        try (PreparedStatement preparedStatementLA = connection.prepareStatement(querySelectionValActuelLigne661Agent)) {
                            preparedStatementLA.setInt(1, idA);
                            ResultSet resLA = preparedStatementLA.executeQuery();
                            if (resLA.next()) {                               
                              
                                    int valeurActuelLigneAgent = resLA.getInt("montantLigne661");//valeur actuelle de la ligne 661 de l'agent
                                    int valeurLigne661 = res.getInt("montantLigne"); //valeur de ligne 661 du programme de l'agent contenu dans la base 
                                    int valeurFinalLigne661 = (Integer.parseInt(InterfaceAgent.ligne661.getText()) - valeurLigne661) + valeurActuelLigneAgent;//valeur actuelle de la ligne budg - valeur actuel de la ligne de lagent + nouvelle de la ligne saisis dans le form
                                    String queryUpdateMontant661 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                                    try (PreparedStatement preparedStatement661 = connection.prepareStatement(queryUpdateMontant661)) {
                                        preparedStatement661.setInt(1, valeurFinalLigne661);
                                        preparedStatement661.setInt(2, LigneID661);
                                        preparedStatement661.executeUpdate();
                                        preparedStatement661.close();
                                        // connection.close();
                                    } catch (SQLException e) {
                                        JOptionPane.showMessageDialog(null, "Erreur SQL");
                                    }                                                             
                            }  
                             preparedStatementLA.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }    
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
    }
    
    //Mise a jour du montant de la ligne 663 lors de la mise à jours de l'agent
    private static final String querySelectionLigne663Update = "SELECT * FROM ligne WHERE idLigne = ?";
    private static final String querySelectionValActuelLigne663Agent = "SELECT montantLigne663 FROM agent WHERE idAgent = ?";
    public static void updateLigne663ForUpdate() {      
            int LigneID663 = Integer.parseInt(InterfaceAgent.idLigne663.getText());///id de la ligne budgetaire
            int idA = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());//id de l'agent
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne663Update)) {
                preparedStatement.setInt(1, LigneID663);                
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        try (PreparedStatement preparedStatementLA = connection.prepareStatement(querySelectionValActuelLigne663Agent)) {
                            preparedStatementLA.setInt(1, idA);
                            ResultSet resLA = preparedStatementLA.executeQuery();
                            if (resLA.next()) {
                                int valeurActuelLigneAgent = resLA.getInt("montantLigne663");//valeur actuelle de la ligne 663 de l'agent
                                int valeurLigne663 = res.getInt("montantLigne"); //valeur de ligne 663 du programme de l'agent contenu dans la base 
                                int valeurFinalLigne663 = (Integer.parseInt(InterfaceAgent.ligne663.getText()) - valeurLigne663) + valeurActuelLigneAgent  ;//valeur actuelle de la ligne budg - valeur actuel de la ligne de lagent + nouvelle de la ligne saisis dans le form
                                String queryUpdateMontant663 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                                try (PreparedStatement preparedStatement663 = connection.prepareStatement(queryUpdateMontant663)) {
                                    preparedStatement663.setInt(1, valeurFinalLigne663);
                                    preparedStatement663.setInt(2, LigneID663);
                                    preparedStatement663.executeUpdate();
                                    preparedStatement663.close();
                                    // connection.close();
                                } catch (SQLException e) {
                                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                                }
                            }  
                             preparedStatementLA.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }     
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }      //  }
    }

    //Mise a jour du montant de la ligne 664 lors de la mise à jours de l'agent
    private static final String querySelectionLigne664Update = "SELECT * FROM ligne WHERE idLigne = ?";
    private static final String querySelectionValActuelLigne664Agent = "SELECT montantLigne664 FROM agent WHERE idAgent = ?";
    public static void updateLigne664ForUpdate() {      
            int LigneID664 = Integer.parseInt(InterfaceAgent.idLigne664.getText());///id de la ligne budgetaire
            int idA = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());//id de l'agent
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne664Update)) {
                preparedStatement.setInt(1, LigneID664);                
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        try (PreparedStatement preparedStatementLA = connection.prepareStatement(querySelectionValActuelLigne664Agent)) {
                            preparedStatementLA.setInt(1, idA);
                            ResultSet resLA = preparedStatementLA.executeQuery();
                            if (resLA.next()) {
                                int valeurActuelLigneAgent = resLA.getInt("montantLigne664");//valeur actuelle de la ligne 663 de l'agent
                                int valeurLigne664 = res.getInt("montantLigne"); //valeur de ligne 663 du programme de l'agent contenu dans la base 
                                int valeurFinalLigne664 = (Integer.parseInt(InterfaceAgent.ligne664.getText()) - valeurLigne664) + valeurActuelLigneAgent  ;//valeur actuelle de la ligne budg - valeur actuel de la ligne de lagent + nouvelle de la ligne saisis dans le form
                                String queryUpdateMontant664 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                                try (PreparedStatement preparedStatement664 = connection.prepareStatement(queryUpdateMontant664)) {
                                    preparedStatement664.setInt(1, valeurFinalLigne664);
                                    preparedStatement664.setInt(2, LigneID664);
                                    preparedStatement664.executeUpdate();
                                    preparedStatement664.close();
                                    // connection.close();
                                } catch (SQLException e) {
                                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                                }
                            }  
                             preparedStatementLA.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }     
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }      //  }
    }
    
    //Mise a jour du montant de la ligne 666 lors de la mise à jours de l'agent
    private static final String querySelectionLigne666Update = "SELECT * FROM ligne WHERE idLigne = ?";
    private static final String querySelectionValActuelLigne666Agent = "SELECT montantLigne666 FROM agent WHERE idAgent = ?";
    public static void updateLigne666ForUpdate() {      
            int LigneID666 = Integer.parseInt(InterfaceAgent.idLigne666.getText());///id de la ligne budgetaire
            int idA = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());//id de l'agent
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne666Update)) {
                preparedStatement.setInt(1, LigneID666);                
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        try (PreparedStatement preparedStatementLA = connection.prepareStatement(querySelectionValActuelLigne666Agent)) {
                            preparedStatementLA.setInt(1, idA);
                            ResultSet resLA = preparedStatementLA.executeQuery();
                            if (resLA.next()) {
                                int valeurActuelLigneAgent = resLA.getInt("montantLigne666");//valeur actuelle de la ligne 666 de l'agent
                                int valeurLigne666 = res.getInt("montantLigne"); //valeur de ligne 663 du programme de l'agent contenu dans la base 
                                int valeurFinalLigne666 = (Integer.parseInt(InterfaceAgent.ligne666.getText()) - valeurLigne666) + valeurActuelLigneAgent  ;//valeur actuelle de la ligne budg - valeur actuel de la ligne de lagent + nouvelle de la ligne saisis dans le form
                                String queryUpdateMontant666 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                                try (PreparedStatement preparedStatement666 = connection.prepareStatement(queryUpdateMontant666)) {
                                    preparedStatement666.setInt(1, valeurFinalLigne666);
                                    preparedStatement666.setInt(2, LigneID666);
                                    preparedStatement666.executeUpdate();
                                    preparedStatement666.close();
                                    // connection.close();
                                } catch (SQLException e) {
                                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                                }
                            }  
                             preparedStatementLA.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }     
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }      //  }
    }
    
    //Mise a jour du montant de la ligne 669 lors de la mise à jours de l'agent
    private static final String querySelectionLigne669Update = "SELECT * FROM ligne WHERE idLigne = ?";
    private static final String querySelectionValActuelLigne669Agent = "SELECT montantLigne669 FROM agent WHERE idAgent = ?";
    public static void updateLigne669ForUpdate() {      
            int LigneID669 = Integer.parseInt(InterfaceAgent.idLigne669.getText());///id de la ligne budgetaire
            int idA = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());//id de l'agent
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne666Update)) {
                preparedStatement.setInt(1, LigneID669);                
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        try (PreparedStatement preparedStatementLA = connection.prepareStatement(querySelectionValActuelLigne669Agent)) {
                            preparedStatementLA.setInt(1, idA);
                            ResultSet resLA = preparedStatementLA.executeQuery();
                            if (resLA.next()) {
                                int valeurActuelLigneAgent = resLA.getInt("montantLigne669");//valeur actuelle de la ligne 669 de l'agent
                                int valeurLigne669 = res.getInt("montantLigne"); //valeur de ligne 663 du programme de l'agent contenu dans la base 
                                int valeurFinalLigne669 = (Integer.parseInt(InterfaceAgent.ligne669.getText()) - valeurLigne669) + valeurActuelLigneAgent  ;//valeur actuelle de la ligne budg - valeur actuel de la ligne de lagent + nouvelle de la ligne saisis dans le form
                                String queryUpdateMontant669 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                                try (PreparedStatement preparedStatement669 = connection.prepareStatement(queryUpdateMontant669)) {
                                    preparedStatement669.setInt(1, valeurFinalLigne669);
                                    preparedStatement669.setInt(2, LigneID669);
                                    preparedStatement669.executeUpdate();
                                    preparedStatement669.close();
                                    // connection.close();
                                } catch (SQLException e) {
                                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                                }
                            }  
                             preparedStatementLA.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }     
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }      //  }
    }
    
    /***************************************MISE A JOUR DE LIGNE AVANT SUPPRESSION D'UN AGENT********************************************************/
        
     
    ///Soustraction et mise à jour de la ligne661 budgétaire de l'agent avant suppression de l'agent
    private static final String querySelectionLigne661Delete = "SELECT * FROM ligne WHERE idLigne = ?";
    private static final String querySelectionValActuelLigne661AgentDelete  = "SELECT montantLigne661 from agent WHERE idAgent = ? ";
    public static void updateLigne661ForDelete() {      
            int LigneID661 = Integer.parseInt(InterfaceAgent.idLigne661.getText());///id de la ligne budgetaire
            int idA = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());//id de l'agent
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne661Delete)) {
                preparedStatement.setInt(1, LigneID661);                
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        try (PreparedStatement preparedStatementLA = connection.prepareStatement(querySelectionValActuelLigne661AgentDelete)) {
                            preparedStatementLA.setInt(1, idA);
                            ResultSet resLA = preparedStatementLA.executeQuery();
                            if (resLA.next()) {                                                            
                                    int valeurActuelLigneAgent = resLA.getInt("montantLigne661");//valeur actuelle de la ligne 661 de l'agent
                                    int valeurLigne661 = res.getInt("montantLigne"); //valeur de ligne 661 du programme de l'agent contenu dans la base 
                                    int valeurFinalLigne661 = valeurLigne661 - valeurActuelLigneAgent;                                   
                                                                      
                                    String queryUpdateMontant661 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                                    try (PreparedStatement preparedStatement661 = connection.prepareStatement(queryUpdateMontant661)) {
                                        preparedStatement661.setInt(1, valeurFinalLigne661);
                                        preparedStatement661.setInt(2, LigneID661);
                                        preparedStatement661.executeUpdate();
                                        preparedStatement661.close();
                                        // connection.close();
                                    } catch (SQLException e) {
                                        JOptionPane.showMessageDialog(null, "Erreur SQL");
                                    }                                                             
                            }  
                             preparedStatementLA.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }    
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
    }
       
  ///Soustraction et mise à jour de la ligne 663 budgétaire de l'agent avant suppression de l'agent
    private static final String querySelectionLigne663Delete = "SELECT * FROM ligne WHERE idLigne = ?";
    private static final String querySelectionValActuelLigne663AgentDelete  = "SELECT montantLigne663 FROM agent WHERE idAgent = ? ";
    public static void updateLigne663ForDelete() {      
            int LigneID663 = Integer.parseInt(InterfaceAgent.idLigne663.getText());///id de la ligne budgetaire
            int idA = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());//id de l'agent
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne663Delete)) {
                preparedStatement.setInt(1, LigneID663);                
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        try (PreparedStatement preparedStatementLA = connection.prepareStatement(querySelectionValActuelLigne663AgentDelete)) {
                            preparedStatementLA.setInt(1, idA);
                            ResultSet resLA = preparedStatementLA.executeQuery();
                            if (resLA.next()) {                               
                              
                                    int valeurActuelLigneAgent = resLA.getInt("montantLigne663");//valeur actuelle de la ligne 661 de l'agent
                                    int valeurLigne663 = res.getInt("montantLigne"); //valeur de ligne 661 du programme de l'agent contenu dans la base 
                                    int valeurFinalLigne663 = valeurLigne663 - valeurActuelLigneAgent;                                   
                                                                      
                                    String queryUpdateMontant663 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                                    try (PreparedStatement preparedStatement663 = connection.prepareStatement(queryUpdateMontant663)) {
                                        preparedStatement663.setInt(1, valeurFinalLigne663);
                                        preparedStatement663.setInt(2, LigneID663);
                                        preparedStatement663.executeUpdate();
                                        preparedStatement663.close();
                                        // connection.close();
                                    } catch (SQLException e) {
                                        JOptionPane.showMessageDialog(null, "Erreur SQL");
                                    }                                                             
                            }  
                             preparedStatementLA.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }    
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
    }
    
    
      ///Soustraction et mise à jour de la ligne 664 budgétaire de l'agent avant suppression de l'agent
    private static final String querySelectionLigne664Delete = "SELECT * FROM ligne WHERE idLigne = ?";
    private static final String querySelectionValActuelLigne664AgentDelete  = "SELECT montantLigne664 FROM agent WHERE idAgent = ? ";
    public static void updateLigne664ForDelete() {      
            int LigneID664 = Integer.parseInt(InterfaceAgent.idLigne664.getText());///id de la ligne budgetaire
            int idA = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());//id de l'agent
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne664Delete)) {
                preparedStatement.setInt(1, LigneID664);                
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        try (PreparedStatement preparedStatementLA = connection.prepareStatement(querySelectionValActuelLigne664AgentDelete)) {
                            preparedStatementLA.setInt(1, idA);
                            ResultSet resLA = preparedStatementLA.executeQuery();
                            if (resLA.next()) {                               
                              
                                    int valeurActuelLigneAgent = resLA.getInt("montantLigne664");//valeur actuelle de la ligne 661 de l'agent
                                    int valeurLigne664 = res.getInt("montantLigne"); //valeur de ligne 661 du programme de l'agent contenu dans la base 
                                    int valeurFinalLigne664 = valeurLigne664 - valeurActuelLigneAgent;                                   
                                                                      
                                    String queryUpdateMontant664 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                                    try (PreparedStatement preparedStatement664 = connection.prepareStatement(queryUpdateMontant664)) {
                                        preparedStatement664.setInt(1, valeurFinalLigne664);
                                        preparedStatement664.setInt(2, LigneID664);
                                        preparedStatement664.executeUpdate();
                                        preparedStatement664.close();
                                        // connection.close();
                                    } catch (SQLException e) {
                                        JOptionPane.showMessageDialog(null, "Erreur SQL");
                                    }                                                             
                            }  
                             preparedStatementLA.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }    
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
    }

    
      ///Soustraction et mise à jour de la ligne 666 budgétaire de l'agent avant suppression de l'agent
    private static final String querySelectionLigne666Delete = "SELECT * FROM ligne WHERE idLigne = ?";
    private static final String querySelectionValActuelLigne666AgentDelete  = "SELECT montantLigne666 FROM agent WHERE idAgent = ? ";
    public static void updateLigne666ForDelete() {      
            int LigneID666 = Integer.parseInt(InterfaceAgent.idLigne666.getText());///id de la ligne budgetaire
            int idA = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());//id de l'agent
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne666Delete)) {
                preparedStatement.setInt(1, LigneID666);                
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        try (PreparedStatement preparedStatementLA = connection.prepareStatement(querySelectionValActuelLigne666AgentDelete)) {
                            preparedStatementLA.setInt(1, idA);
                            ResultSet resLA = preparedStatementLA.executeQuery();
                            if (resLA.next()) {                               
                              
                                    int valeurActuelLigneAgent = resLA.getInt("montantLigne666");//valeur actuelle de la ligne 661 de l'agent
                                    int valeurLigne666 = res.getInt("montantLigne"); //valeur de ligne 661 du programme de l'agent contenu dans la base 
                                    int valeurFinalLigne666 = valeurLigne666 - valeurActuelLigneAgent;                                 
                                                                      
                                    String queryUpdateMontant666 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                                    try (PreparedStatement preparedStatement666 = connection.prepareStatement(queryUpdateMontant666)) {
                                        preparedStatement666.setInt(1, valeurFinalLigne666);
                                        preparedStatement666.setInt(2, LigneID666);
                                        preparedStatement666.executeUpdate();
                                        preparedStatement666.close();
                                        // connection.close();
                                    } catch (SQLException e) {
                                        JOptionPane.showMessageDialog(null, "Erreur SQL");
                                    }                                                             
                            }  
                             preparedStatementLA.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }    
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
    }
    
      ///Soustraction et mise à jour de la ligne 669 budgétaire de l'agent avant suppression de l'agent
    private static final String querySelectionLigne669Delete = "SELECT * FROM ligne WHERE idLigne = ?";
    private static final String querySelectionValActuelLigne669AgentDelete  = "SELECT montantLigne669 FROM agent WHERE idAgent = ? ";
    public static void updateLigne669ForDelete() {      
            int LigneID669 = Integer.parseInt(InterfaceAgent.idLigne669.getText());///id de la ligne budgetaire
            int idA = Integer.parseInt(InterfaceAgent.boxIDAgent.getText());//id de l'agent
            //  String querySelectLigne661 = "SELECT * FROM ligne WHERE idLigne = ?";
            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectionLigne669Delete)) {
                preparedStatement.setInt(1, LigneID669);                
                try (ResultSet res = preparedStatement.executeQuery()) {
                    if (res.next()) {
                        try (PreparedStatement preparedStatementLA = connection.prepareStatement(querySelectionValActuelLigne669AgentDelete)) {
                            preparedStatementLA.setInt(1, idA);
                            ResultSet resLA = preparedStatementLA.executeQuery();
                            if (resLA.next()) {                               
                              
                                    int valeurActuelLigneAgent = resLA.getInt("montantLigne669");//valeur actuelle de la ligne 661 de l'agent
                                    int valeurLigne669 = res.getInt("montantLigne"); //valeur de ligne 661 du programme de l'agent contenu dans la base 
                                    int valeurFinalLigne669 = valeurLigne669 - valeurActuelLigneAgent;                                   
                                                                      
                                    String queryUpdateMontant669 = "UPDATE ligne SET montantLigne = ?  WHERE idLigne = ? ";
                                    try (PreparedStatement preparedStatement669 = connection.prepareStatement(queryUpdateMontant669)) {
                                        preparedStatement669.setInt(1, valeurFinalLigne669);
                                        preparedStatement669.setInt(2, LigneID669);
                                        preparedStatement669.executeUpdate();
                                        preparedStatement669.close();
                                        // connection.close();
                                    } catch (SQLException e) {
                                        JOptionPane.showMessageDialog(null, "Erreur SQL");
                                    }                                                             
                            }  
                             preparedStatementLA.close();
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Erreur SQL");
                        }    
                    }
                }
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    




    
    //Suppression d'un agent
      public static void deleteAgent(Agent agent) {
        int idAge = Integer.parseInt(InterfaceAgent.tableau_agent.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM agent WHERE idAgent = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idAge);
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
    private static final String querySelectOneAgentByMatricule = "SELECT * FROM agent WHERE matriculeAgent = ? ";
    public static void rechercheAgentByMatricule() {
    String matriculeA = InterfaceAgent.rechercheMatricule.getText().trim();
    //numligne = InterfaceAction.tableau_action.getSelectedRow();//recuperer le le numero de la ligne
    if (matriculeA.isBlank()) {
        JOptionPane.showMessageDialog(null, "Saisir un matricule !! ");
        InterfaceAgent.tableau_agent.removeAll();
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
}
    
    // Afficher une Programme
    public static int  idAg;
    private static final String querySelectOneAgentToDisplay = "SELECT * FROM agent where idAgent = ? ";

    public static void displayAgentInBox() {
        nbreligne = InterfaceAgent.tableau_agent.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceAgent.tableau_agent.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceAgent.reinitChamps();            
            JOptionPane.showMessageDialog(null, " Sélectionnez un agent");
            //System.out.println(nbreligne);
        } else {
            idAg = Integer.parseInt(InterfaceAgent.tableau_agent.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneAgentToDisplay)) {
            preparedStatement.setInt(1, idAg);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                
                InterfaceAgent.boxIDAgent.setText(res.getString("idAgent"));
                InterfaceAgent.boxMatriculeAg.setText(res.getString("matriculeAgent"));
                InterfaceAgent.boxNomAg.setText(res.getString("nomAgent"));
                InterfaceAgent.boxPrenomAg.setText(res.getString("prenomAgent"));                
                InterfaceAgent.boxDateNaissAg.setText(res.getString("dateNaissanceAgent"));
                
                InterfaceAgent.comboSexeAg.setSelectedItem(res.getString("sexeAgent"));
                InterfaceAgent.boxDatePriseServiceAg.setText(res.getString("datePriseServiceAgent"));
                InterfaceAgent.comboStructure.setSelectedItem(res.getString("structureAgent"));
                InterfaceAgent.comboMinistere.setSelectedItem(res.getString("ministereOrigineAgent"));
                
                InterfaceAgent.comboFonction.setSelectedItem(res.getString("fonctionAgent"));
                InterfaceAgent.comboEmploiAgent.setSelectedItem(res.getString("emploiAgent"));
                InterfaceAgent.comboCatAgent.setSelectedItem(res.getString("categorieEchelleAgent")); 
                InterfaceAgent.comboTypeAgent.setSelectedItem(res.getString("typeAgent"));     
                
                InterfaceAgent.boxEchelon.setText(res.getString("echelonAgent"));                
                InterfaceAgent.boxIndiceSal.setText(res.getString("indiceAgent"));
                
                InterfaceAgent.boxSalaireIndicMensuel.setValue((res.getDouble("salaireIndiciaireAgent")));            
                
                InterfaceAgent.boxIndResidence.setValue(res.getDouble("indeminiteResidence"));
                InterfaceAgent.boxIndeminiteAstreinte.setValue(res.getDouble("indeminiteAstreinte"));
                InterfaceAgent.boxIndeminiteTechnicite.setValue(res.getDouble("indeminiteTechnicite"));
                InterfaceAgent.boxIndeminiteResponsabilite.setValue(res.getDouble("indeminiteResponsabilite"));
                InterfaceAgent.boxIndeminiteVestimentaire.setValue(res.getDouble("indeminiteVestimentaire"));                
                
               // InterfaceAgent.boxIndeminiteLogement1.setText(res.getString("indeminiteLogement"));
                InterfaceAgent.boxIndeminiteLogement.setValue(res.getDouble("indeminiteLogement"));
                InterfaceAgent.boxIndeminiteSpecifique.setValue(res.getDouble("indeminiteSpecifique"));
                InterfaceAgent.boxAutreIndeminite.setValue(res.getDouble("autreIndeminite"));
                InterfaceAgent.boxChargeMilitaire.setValue(res.getDouble("chargeMilitaire"));
                InterfaceAgent.boxContributionCARFO.setValue(res.getDouble("contributionCARFO"));
                InterfaceAgent.boxContributionCNSS.setValue(res.getDouble("contributionCNSS"));
                
                InterfaceAgent.boxAllocationFamiliale.setValue(res.getDouble("allocationFamiliale"));
                InterfaceAgent.ligne661.setValue(res.getDouble("montantLigne661"));
                InterfaceAgent.ligne663.setValue(res.getDouble("montantLigne663"));
                InterfaceAgent.ligne664.setValue(res.getDouble("montantLigne664"));
                InterfaceAgent.ligne666.setValue(res.getDouble("montantLigne666"));
                InterfaceAgent.ligne669.setValue(res.getDouble("montantLigne669"));
                InterfaceAgent.boxIncidenceMensuelle.setValue(res.getDouble("incidenceMensuelle"));
                InterfaceAgent.boxIncidenceAnnuelle.setValue(res.getDouble("incidenceAnnuelle")); 
                
                InterfaceAgent.idLigne661.setText(res.getString("idLigne661"));
                InterfaceAgent.ligne661.setBackground(new java.awt.Color(0, 102, 51));
                InterfaceAgent.idLigne663.setText(res.getString("idLigne663"));
                InterfaceAgent.ligne663.setBackground(new java.awt.Color(0, 102, 51));
                InterfaceAgent.idLigne664.setText(res.getString("idLigne664"));
                InterfaceAgent.ligne664.setBackground(new java.awt.Color(0, 102, 51));
                InterfaceAgent.idLigne666.setText(res.getString("idLigne666"));
                InterfaceAgent.ligne666.setBackground(new java.awt.Color(0, 102, 51));
                InterfaceAgent.idLigne669.setText(res.getString("idLigne669"));
                InterfaceAgent.ligne669.setBackground(new java.awt.Color(0, 102, 51));
                            
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
    
    
    
    
