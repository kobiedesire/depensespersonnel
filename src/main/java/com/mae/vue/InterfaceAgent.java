/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mae.vue;

import com.mae.controller.AgentController;
import com.mae.model.Agent;
import com.mae.props.PropsTableau;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;
import com.mae.controller.ImportExcelController;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kobie
 */
public class InterfaceAgent extends javax.swing.JInternalFrame {

    /**
     *
     */
    public InterfaceAgent() {
        initComponents();
        AutoCompleteDecorator.decorate(comboStructure);
        AutoCompleteDecorator.decorate(comboFonction);
        AutoCompleteDecorator.decorate(comboTypeAgent);
        AutoCompleteDecorator.decorate(comboCatAgent);
        AutoCompleteDecorator.decorate(comboEmploiAgent);
        AutoCompleteDecorator.decorate(comboMinistere);
        AutoCompleteDecorator.decorate(comboSexeAg);

    }

    //Fonction pour exécuter le calcul du salaire indicaire mensuel de l'agent ********************************************************************************************************************
    public static void afficherSalaireIndiciaire() {
        AgentController.calculSalIndiciaire();

    }

    //Fonction pour exécuter le calcul des contribution cnss et carfo en fonctio n du type d'gant selectionné
    public static void afficherContribution() {
        AgentController.calculContribution();
    }

    //Fonction pour exécuter le calcul de la somme des indeminite
    public static void afficherSommeIndeminite663() {
        AgentController.calculIndemnite();
    }

    //Methode de mise à jour de la ligne 666
    public static void afficherLigne666() {
        AgentController.miseAJourLigne666();
    }

    //Methode de mise à jour de la ligne 669
    public static void afficherLigne669() {
        AgentController.calculAutreDepenses();
    }

    //Methode de mise à jour de l'incidence mensuelle et annuelle
    public static void afficherIncidenceMensuelleAnnuelle() {
        AgentController.calculIncidenceMensuelleAnnuelle();

    }

    //remplissage du combobox des categories
    public static void listerComboCategorieEchelle() {
        AgentController.listCategorieInCombo();// Executer la méthode de remplissage du combo
    }

    //remplissage du combobox des emplois
    public static void listerComboEmploi() {
        AgentController.listEmploiInCombo();// Executer la méthode de remplissage du combo
    }

    //remplissage du combobox des fonctions
    public static void listerComboFonction() {
        AgentController.listFonctionInCombo();// Executer la méthode de remplissage du combo
    }

    //remplissage du combobox des ministères
    public static void listerComboMinistere() {
        AgentController.listMinistereCombo();// Executer la méthode de remplissage du combo
    }

    //remplissage du combobox des structures
    public static void listerComboStructure() {
        AgentController.listStructureCombo();// Executer la méthode de remplissage du combo
    }

    //Vider les tous les champs   
    public static void reinitChamps() {
        AgentController.viderChamps();
    }

    //Afficher l'id du programme de la structure  
    public static void displayIDProgramme() {
        AgentController.afficherIDProgrammeFromStructure();
    }

    //Fonction pour l'enregistrement d'un agent********************************************************************************************************************
    public static void enregistrerAgent() {
        Double aCARFO, aCNSS;
        // Récuperation des donnéses du formulaire
        //champ de saisie caractere
        String aMatricule = boxMatriculeAg.getText().trim();
        String aNom = boxNomAg.getText().trim().toUpperCase();
        String aPrenom = boxPrenomAg.getText().trim();
        String aDateNaiss = boxDateNaissAg.getText().trim();
        String aDatePriseService = boxDatePriseServiceAg.getText().trim();
        //champs de selection 
        String aSexe = (comboSexeAg.getSelectedItem().toString()).trim();
        String aTypeAgent = (comboTypeAgent.getSelectedItem().toString()).trim();
        String aStructure = (comboStructure.getSelectedItem().toString()).trim();
        String aMinistereOrigine = (comboMinistere.getSelectedItem().toString()).trim();
        String aFonction = (comboFonction.getSelectedItem().toString()).trim();
        String aEmploi = (comboEmploiAgent.getSelectedItem().toString()).trim();
        String aCategorieEchelle = (comboCatAgent.getSelectedItem().toString()).trim();

        if (aMatricule.isBlank() || aNom.isBlank() || aPrenom.isBlank() || aDateNaiss.isBlank() || aDatePriseService.isBlank() || aSexe.isBlank()
                || aTypeAgent.isBlank() || aStructure.isBlank() || aMinistereOrigine.isBlank() || aFonction.isBlank() || aEmploi.isBlank() || aCategorieEchelle.isBlank()
                || boxIndiceSal.getText().isBlank() || boxIndeminiteAstreinte.getText().isBlank() || boxIndeminiteTechnicite.getText().isBlank()
                || boxEchelon.getText().isBlank() || boxIndeminiteLogement.getText().isBlank()
                || idLigne661.getText().isBlank() || idLigne663.getText().isBlank() || idLigne664.getText().isBlank() || idLigne666.getText().isBlank() || idLigne669.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Vérifiez les champs obligatoires ou des lignes budgétaires ne sont pas sélectionnées...");
        } else {
            int aIndice = Integer.parseInt(boxIndiceSal.getText());
            Double aIResidence = Double.valueOf(boxIndResidence.getText());
            Double aIAstreinte = Double.valueOf(boxIndeminiteAstreinte.getText());
            Double aITechnicite = Double.valueOf(boxIndeminiteTechnicite.getText());
            Double aIResponsabilite = Double.valueOf(boxIndeminiteResponsabilite.getText());
            Double aIVestimentaire = Double.valueOf(boxIndeminiteVestimentaire.getText());
            Double aISpecifique = Double.valueOf(boxIndeminiteSpecifique.getText());
            int aEchelon = Integer.parseInt(boxEchelon.getText());
            Double aSalIncidiciaire = Double.valueOf(boxSalaireIndicMensuel.getText());
            Double aILogement = Double.valueOf(boxIndeminiteLogement.getText());
            Double aChargeMilitaire = Double.valueOf(boxChargeMilitaire.getText());

            if (boxContributionCARFO.getText().isBlank()) {
                aCARFO = 0.0;
            } else {
                aCARFO = Double.valueOf(boxContributionCARFO.getText());
            }
            if (boxContributionCNSS.getText().isBlank()) {
                aCNSS = 0.0;
            } else {
                aCNSS = Double.valueOf(boxContributionCNSS.getText());
            }

            //Double aCNSS = Double.valueOf(boxContributionCNSS.getText());
            Double aAllFamil = Double.valueOf(boxAllocationFamiliale.getText());
            Double aAutresI = Double.valueOf(boxAutreIndeminite.getText());

            Double aLigne661 = Double.valueOf(ligne661.getText());
            Double aLigne663 = Double.valueOf(ligne663.getText());
            Double aLigne664 = Double.valueOf(ligne664.getText());
            Double aLigne666 = Double.valueOf(ligne666.getText());
            Double aLigne669 = Double.valueOf(ligne669.getText());

            Double aIncidenceMensuelle = Double.valueOf(boxIncidenceMensuelle.getText());
            Double aIncidenceAnnuelle = Double.valueOf(boxIncidenceAnnuelle.getText());

            int IDL661 = Integer.parseInt(idLigne661.getText());
            int IDL663 = Integer.parseInt(idLigne663.getText());
            int IDL664 = Integer.parseInt(idLigne664.getText());
            int IDL666 = Integer.parseInt(idLigne666.getText());
            int IDL669 = Integer.parseInt(idLigne669.getText());

            Agent agent = new Agent(aMatricule, aNom, aPrenom, aDateNaiss, aSexe, aDatePriseService, aTypeAgent, aStructure, aMinistereOrigine, aFonction, aEmploi, aCategorieEchelle, aEchelon, aIndice, aSalIncidiciaire, aIResidence, aIAstreinte, aITechnicite, aIResponsabilite, aIVestimentaire, aILogement, aISpecifique, aAutresI, aChargeMilitaire, aCARFO, aCNSS, aAllFamil, aLigne661, aLigne663, aLigne664, aLigne666, aLigne669, aIncidenceMensuelle, aIncidenceAnnuelle, IDL661, IDL663, IDL664, IDL666, IDL669);
            AgentController.saveAgent(agent);  // Enregistrez  dans la base de données     
            AgentController.updateLigne661();
            AgentController.updateLigne663();
            AgentController.updateLigne664();
            AgentController.updateLigne666();
            AgentController.updateLigne669();
            reinitChamps();
        }

    }

    //Fonction pour la modification d'un agent********************************************************************************************************************
    private static int rep;

    public static void modifierAgent() {
        Double aCARFO, aCNSS;
        // Récuperation des donnéses du formulaire
        //champ de saisie caractere
        String aMatricule = boxMatriculeAg.getText().trim();
        String aNom = boxNomAg.getText().trim().toUpperCase();
        String aPrenom = boxPrenomAg.getText().trim();
        String aDateNaiss = boxDateNaissAg.getText().trim();
        String aDatePriseService = boxDatePriseServiceAg.getText().trim();
        //champs de selection 
        String aSexe = (comboSexeAg.getSelectedItem().toString()).trim();
        String aTypeAgent = (comboTypeAgent.getSelectedItem().toString()).trim();
        String aStructure = (comboStructure.getSelectedItem().toString()).trim();
        String aMinistereOrigine = (comboMinistere.getSelectedItem().toString()).trim();
        String aFonction = (comboFonction.getSelectedItem().toString()).trim();
        String aEmploi = (comboEmploiAgent.getSelectedItem().toString()).trim();
        String aCategorieEchelle = (comboCatAgent.getSelectedItem().toString()).trim();

        if (aMatricule.isBlank() || aNom.isBlank() || aPrenom.isBlank() || aDateNaiss.isBlank() || aDatePriseService.isBlank() || aSexe.isBlank()
                || aTypeAgent.isBlank() || aStructure.isBlank() || aMinistereOrigine.isBlank() || aFonction.isBlank() || aEmploi.isBlank() || aCategorieEchelle.isBlank()
                || boxIndiceSal.getText().isBlank() || boxIndeminiteAstreinte.getText().isBlank() || boxIndeminiteTechnicite.getText().isBlank()
                || boxEchelon.getText().isBlank() || boxIndeminiteLogement.getText().isBlank()
                || idLigne661.getText().isBlank() || idLigne663.getText().isBlank() || idLigne664.getText().isBlank() || idLigne666.getText().isBlank() || idLigne669.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Vérifiez les champs obligatoires ou des lignes budgétaires ne sont pas sélectionnées...");
        } else {
            int aIndice = Integer.parseInt(boxIndiceSal.getText());
            Double aIResidence = Double.valueOf(boxIndResidence.getText());
            Double aIAstreinte = Double.valueOf(boxIndeminiteAstreinte.getText());
            Double aITechnicite = Double.valueOf(boxIndeminiteTechnicite.getText());
            Double aIResponsabilite = Double.valueOf(boxIndeminiteResponsabilite.getText());
            Double aIVestimentaire = Double.valueOf(boxIndeminiteVestimentaire.getText());
            Double aISpecifique = Double.valueOf(boxIndeminiteSpecifique.getText());
            int aEchelon = Integer.parseInt(boxEchelon.getText());
            Double aSalIncidiciaire = Double.valueOf(boxSalaireIndicMensuel.getText());
            Double aILogement = Double.valueOf(boxIndeminiteLogement.getText());
            Double aChargeMilitaire = Double.valueOf(boxChargeMilitaire.getText());

            if (boxContributionCARFO.getText().isBlank()) {
                aCARFO = 0.0;
            } else {
                aCARFO = Double.valueOf(boxContributionCARFO.getText());
            }
            if (boxContributionCNSS.getText().isBlank()) {
                aCNSS = 0.0;
            } else {
                aCNSS = Double.valueOf(boxContributionCNSS.getText());
            }

            //Double aCNSS = Double.valueOf(boxContributionCNSS.getText());
            Double aAllFamil = Double.valueOf(boxAllocationFamiliale.getText());
            Double aAutresI = Double.valueOf(boxAutreIndeminite.getText());

            Double aLigne661 = Double.valueOf(ligne661.getText());
            Double aLigne663 = Double.valueOf(ligne663.getText());
            Double aLigne664 = Double.valueOf(ligne664.getText());
            Double aLigne666 = Double.valueOf(ligne666.getText());
            Double aLigne669 = Double.valueOf(ligne669.getText());

            Double aIncidenceMensuelle = Double.valueOf(boxIncidenceMensuelle.getText());
            Double aIncidenceAnnuelle = Double.valueOf(boxIncidenceAnnuelle.getText());

            int IDL661 = Integer.parseInt(idLigne661.getText());
            int IDL663 = Integer.parseInt(idLigne663.getText());
            int IDL664 = Integer.parseInt(idLigne664.getText());
            int IDL666 = Integer.parseInt(idLigne666.getText());
            int IDL669 = Integer.parseInt(idLigne669.getText());

            rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment modifier cet agent?", "Modification d'un agent", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                Agent agent = new Agent(aMatricule, aNom, aPrenom, aDateNaiss, aSexe, aDatePriseService, aTypeAgent, aStructure, aMinistereOrigine, aFonction, aEmploi, aCategorieEchelle, aEchelon, aIndice, aSalIncidiciaire, aIResidence, aIAstreinte, aITechnicite, aIResponsabilite, aIVestimentaire, aILogement, aISpecifique, aAutresI, aChargeMilitaire, aCARFO, aCNSS, aAllFamil, aLigne661, aLigne663, aLigne664, aLigne666, aLigne669, aIncidenceMensuelle, aIncidenceAnnuelle, IDL661, IDL663, IDL664, IDL666, IDL669);

                AgentController.updateLigne661ForUpdate();
                AgentController.updateLigne663ForUpdate();
                AgentController.updateLigne664ForUpdate();
                AgentController.updateLigne666ForUpdate();
                AgentController.updateLigne669ForUpdate();
                AgentController.updateAgent(agent);  // Enregistrez  dans la base de données     

                // AgentController.updateLigne663();
                //AgentController.updateLigne664();
                // AgentController.updateLigne666();
                //AgentController.updateLigne669();
                reinitChamps();
                JOptionPane.showMessageDialog(null, "Modification validée");
            }
        }

    }

    //Supprimer un agent********************************************************************************************************************
    public static void supprimerAgent() {
        rep = JOptionPane.showConfirmDialog(null, " !!! Voulez-vous vraiment supprimer cet agent?", "Suppression d'un agent", JOptionPane.YES_NO_OPTION);
        if (rep == JOptionPane.YES_OPTION) {
            Agent agent = new Agent();
            AgentController.updateLigne661ForDelete();
            AgentController.updateLigne663ForDelete();
            AgentController.updateLigne664ForDelete();
            AgentController.updateLigne666ForDelete();
            AgentController.updateLigne669ForDelete();
            AgentController.deleteAgent(agent);// Executer la méthode de suppression des données    
            JOptionPane.showMessageDialog(null, "L'agent a été supprimé avec succès.");
            reinitChamps();
        }
    }

    public static void retraitDeLignes() {
        Double aCARFO, aCNSS;
        // Récuperation des donnéses du formulaire
        //champ de saisie caractere
        String aMatricule = boxMatriculeAg.getText().trim();
        String aNom = boxNomAg.getText().trim().toUpperCase();
        String aPrenom = boxPrenomAg.getText().trim();
        String aDateNaiss = boxDateNaissAg.getText().trim();
        String aDatePriseService = boxDatePriseServiceAg.getText().trim();
        //champs de selection 
        String aSexe = (comboSexeAg.getSelectedItem().toString()).trim();
        String aTypeAgent = (comboTypeAgent.getSelectedItem().toString()).trim();
        String aStructure = (comboStructure.getSelectedItem().toString()).trim();
        String aMinistereOrigine = (comboMinistere.getSelectedItem().toString()).trim();
        String aFonction = (comboFonction.getSelectedItem().toString()).trim();
        String aEmploi = (comboEmploiAgent.getSelectedItem().toString()).trim();
        String aCategorieEchelle = (comboCatAgent.getSelectedItem().toString()).trim();

        if (aMatricule.isBlank() || aNom.isBlank() || aPrenom.isBlank() || aDateNaiss.isBlank() || aDatePriseService.isBlank() || aSexe.isBlank()
                || aTypeAgent.isBlank() || aStructure.isBlank() || aMinistereOrigine.isBlank() || aFonction.isBlank() || aEmploi.isBlank() || aCategorieEchelle.isBlank()
                || boxIndiceSal.getText().isBlank() || boxIndeminiteAstreinte.getText().isBlank() || boxIndeminiteTechnicite.getText().isBlank()
                || boxEchelon.getText().isBlank() || boxIndeminiteLogement.getText().isBlank()
                || idLigne661.getText().isBlank() || idLigne663.getText().isBlank() || idLigne664.getText().isBlank() || idLigne666.getText().isBlank() || idLigne669.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Vérifiez les champs obligatoires ou des lignes budgétaires ne sont pas sélectionnées...");
        } else {
            int aIndice = Integer.parseInt(boxIndiceSal.getText());
            Double aIResidence = Double.valueOf(boxIndResidence.getText());
            Double aIAstreinte = Double.valueOf(boxIndeminiteAstreinte.getText());
            Double aITechnicite = Double.valueOf(boxIndeminiteTechnicite.getText());
            Double aIResponsabilite = Double.valueOf(boxIndeminiteResponsabilite.getText());
            Double aIVestimentaire = Double.valueOf(boxIndeminiteVestimentaire.getText());
            Double aISpecifique = Double.valueOf(boxIndeminiteSpecifique.getText());
            int aEchelon = Integer.parseInt(boxEchelon.getText());
            Double aSalIncidiciaire = Double.valueOf(boxSalaireIndicMensuel.getText());
            Double aILogement = Double.valueOf(boxIndeminiteLogement.getText());
            Double aChargeMilitaire = Double.valueOf(boxChargeMilitaire.getText());

            if (boxContributionCARFO.getText().isBlank()) {
                aCARFO = 0.0;
            } else {
                aCARFO = Double.valueOf(boxContributionCARFO.getText());
            }
            if (boxContributionCNSS.getText().isBlank()) {
                aCNSS = 0.0;
            } else {
                aCNSS = Double.valueOf(boxContributionCNSS.getText());
            }

            //Double aCNSS = Double.valueOf(boxContributionCNSS.getText());
            Double aAllFamil = Double.valueOf(boxAllocationFamiliale.getText());
            Double aAutresI = Double.valueOf(boxAutreIndeminite.getText());

            Double aLigne661 = Double.valueOf(ligne661.getText());
            Double aLigne663 = Double.valueOf(ligne663.getText());
            Double aLigne664 = Double.valueOf(ligne664.getText());
            Double aLigne666 = Double.valueOf(ligne666.getText());
            Double aLigne669 = Double.valueOf(ligne669.getText());

            Double aIncidenceMensuelle = Double.valueOf(boxIncidenceMensuelle.getText());
            Double aIncidenceAnnuelle = Double.valueOf(boxIncidenceAnnuelle.getText());

            int IDL661 = Integer.parseInt(idLigne661.getText());
            int IDL663 = Integer.parseInt(idLigne663.getText());
            int IDL664 = Integer.parseInt(idLigne664.getText());
            int IDL666 = Integer.parseInt(idLigne666.getText());
            int IDL669 = Integer.parseInt(idLigne669.getText());

            rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment retirer les lignes de cet agent de son programme budgétaire?", "Retrait de lignes d'un agent", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                Agent agent = new Agent(aMatricule, aNom, aPrenom, aDateNaiss, aSexe, aDatePriseService, aTypeAgent, aStructure, aMinistereOrigine, aFonction, aEmploi, aCategorieEchelle, aEchelon, aIndice, aSalIncidiciaire, aIResidence, aIAstreinte, aITechnicite, aIResponsabilite, aIVestimentaire, aILogement, aISpecifique, aAutresI, aChargeMilitaire, aCARFO, aCNSS, aAllFamil, aLigne661, aLigne663, aLigne664, aLigne666, aLigne669, aIncidenceMensuelle, aIncidenceAnnuelle, IDL661, IDL663, IDL664, IDL666, IDL669);

                AgentController.updateLigne661ForDelete();
                AgentController.updateLigne663ForDelete();
                AgentController.updateLigne664ForDelete();
                AgentController.updateLigne666ForDelete();
                AgentController.updateLigne669ForDelete();
                AgentController.updateAgent(agent);  // mise à jours de l'agent  dans la base de données   
                reinitChamps();
                JOptionPane.showMessageDialog(null, "Les lignes budgétaires de cet agent ont été retirées de son programme !");
            }
        }

    }

    //reacffecter un agent
    public static void reaffecterAgent() {
        Double aCARFO, aCNSS;
        // Récuperation des donnéses du formulaire
        //champ de saisie caractere
        String aMatricule = boxMatriculeAg.getText().trim();
        String aNom = boxNomAg.getText().trim().toUpperCase();
        String aPrenom = boxPrenomAg.getText().trim();
        String aDateNaiss = boxDateNaissAg.getText().trim();
        String aDatePriseService = boxDatePriseServiceAg.getText().trim();
        //champs de selection 
        String aSexe = (comboSexeAg.getSelectedItem().toString()).trim();
        String aTypeAgent = (comboTypeAgent.getSelectedItem().toString()).trim();
        String aStructure = (comboStructure.getSelectedItem().toString()).trim();
        String aMinistereOrigine = (comboMinistere.getSelectedItem().toString()).trim();
        String aFonction = (comboFonction.getSelectedItem().toString()).trim();
        String aEmploi = (comboEmploiAgent.getSelectedItem().toString()).trim();
        String aCategorieEchelle = (comboCatAgent.getSelectedItem().toString()).trim();

        if (aMatricule.isBlank() || aNom.isBlank() || aPrenom.isBlank() || aDateNaiss.isBlank() || aDatePriseService.isBlank() || aSexe.isBlank()
                || aTypeAgent.isBlank() || aStructure.isBlank() || aMinistereOrigine.isBlank() || aFonction.isBlank() || aEmploi.isBlank() || aCategorieEchelle.isBlank()
                || boxIndiceSal.getText().isBlank() || boxIndeminiteAstreinte.getText().isBlank() || boxIndeminiteTechnicite.getText().isBlank()
                || boxEchelon.getText().isBlank() || boxIndeminiteLogement.getText().isBlank()
                || idLigne661.getText().isBlank() || idLigne663.getText().isBlank() || idLigne664.getText().isBlank() || idLigne666.getText().isBlank() || idLigne669.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Vérifiez les champs obligatoires ou des lignes budgétaires ne sont pas sélectionnées...");
        } else {
            int aIndice = Integer.parseInt(boxIndiceSal.getText());
            Double aIResidence = Double.valueOf(boxIndResidence.getText());
            Double aIAstreinte = Double.valueOf(boxIndeminiteAstreinte.getText());
            Double aITechnicite = Double.valueOf(boxIndeminiteTechnicite.getText());
            Double aIResponsabilite = Double.valueOf(boxIndeminiteResponsabilite.getText());
            Double aIVestimentaire = Double.valueOf(boxIndeminiteVestimentaire.getText());
            Double aISpecifique = Double.valueOf(boxIndeminiteSpecifique.getText());
            int aEchelon = Integer.parseInt(boxEchelon.getText());
            Double aSalIncidiciaire = Double.valueOf(boxSalaireIndicMensuel.getText());
            Double aILogement = Double.valueOf(boxIndeminiteLogement.getText());
            Double aChargeMilitaire = Double.valueOf(boxChargeMilitaire.getText());

            if (boxContributionCARFO.getText().isBlank()) {
                aCARFO = 0.0;
            } else {
                aCARFO = Double.valueOf(boxContributionCARFO.getText());
            }
            if (boxContributionCNSS.getText().isBlank()) {
                aCNSS = 0.0;
            } else {
                aCNSS = Double.valueOf(boxContributionCNSS.getText());
            }

            //Double aCNSS = Double.valueOf(boxContributionCNSS.getText());
            Double aAllFamil = Double.valueOf(boxAllocationFamiliale.getText());
            Double aAutresI = Double.valueOf(boxAutreIndeminite.getText());

            Double aLigne661 = Double.valueOf(ligne661.getText());
            Double aLigne663 = Double.valueOf(ligne663.getText());
            Double aLigne664 = Double.valueOf(ligne664.getText());
            Double aLigne666 = Double.valueOf(ligne666.getText());
            Double aLigne669 = Double.valueOf(ligne669.getText());

            Double aIncidenceMensuelle = Double.valueOf(boxIncidenceMensuelle.getText());
            Double aIncidenceAnnuelle = Double.valueOf(boxIncidenceAnnuelle.getText());

            int IDL661 = Integer.parseInt(idLigne661.getText());
            int IDL663 = Integer.parseInt(idLigne663.getText());
            int IDL664 = Integer.parseInt(idLigne664.getText());
            int IDL666 = Integer.parseInt(idLigne666.getText());
            int IDL669 = Integer.parseInt(idLigne669.getText());

            rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment réaffecter cet agent dans un autre programme budgétaire?", "Réaffectation d'un agent", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                Agent agent = new Agent(aMatricule, aNom, aPrenom, aDateNaiss, aSexe, aDatePriseService, aTypeAgent, aStructure, aMinistereOrigine, aFonction, aEmploi, aCategorieEchelle, aEchelon, aIndice, aSalIncidiciaire, aIResidence, aIAstreinte, aITechnicite, aIResponsabilite, aIVestimentaire, aILogement, aISpecifique, aAutresI, aChargeMilitaire, aCARFO, aCNSS, aAllFamil, aLigne661, aLigne663, aLigne664, aLigne666, aLigne669, aIncidenceMensuelle, aIncidenceAnnuelle, IDL661, IDL663, IDL664, IDL666, IDL669);

                AgentController.updateAgent(agent);  // Enregistrez  dans la base de données    
                AgentController.updateLigne661();
                AgentController.updateLigne663();
                AgentController.updateLigne664();
                AgentController.updateLigne666();
                AgentController.updateLigne669();

                reinitChamps();
                JOptionPane.showMessageDialog(null, "Réaffectation effectuée avec succès !");

            }
        }
    }

    //Lister toutes les agents********************************************************************************************************************
    public static void listerAgent() {
        AgentController.listAll(); // Executer la méthode d'affichage des données  
    }

    //afficher un agent
    public static void displayOneAgent() {
        AgentController.rechercheAgentByMatricule();
    }

    //afficher les informations d'un agents dans les champs
    public static void displayOneAgenntToUpdateOrDelete() {
        AgentController.displayAgentInBox();

    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 661********************************************************************************************************************
    public static void afficherListeLigne661IdProgramme() {
        AgentController.afficherIdProgrammeListeSelectLigne661(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 663********************************************************************************************************************
    public static void afficherListeLigne663IdProgramme() {
        AgentController.afficherIdProgrammeListeSelectLigne663(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 664********************************************************************************************************************
    public static void afficherListeLigne664IdProgramme() {
        AgentController.afficherIdProgrammeListeSelectLigne664(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 666********************************************************************************************************************
    public static void afficherListeLigne666IdProgramme() {
        AgentController.afficherIdProgrammeListeSelectLigne666(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 669********************************************************************************************************************
    public static void afficherListeLigne669IdProgramme() {
        AgentController.afficherIdProgrammeListeSelectLigne669(); // Executer la méthode d'affichage des données  
    }

    /* private static int rep;

    

    

    //Fonction pour afficher ********************************************************************************************************************
    public static void afficherStructure() {
        StructureController.displayStructure();// Executer la méthode d'affichage des données        
    }

    //Modifier une structure********************************************************************************************************************
    public static void modifierStructure() {
        // Récuperation des donnéses du formulaire
        String sCode = codeStr.getText().trim();
        String sType = (typeStr.getSelectedItem().toString()).trim();
        String sLibele = libeleStr.getText().trim();
        if (sCode.isBlank() || sType.isBlank() || sLibele.isBlank()) {
            JOptionPane.showMessageDialog(null, "Des cahmps sont vides");
        } else {

            rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment modifier cette structure?", "Modification d'une structure", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                Structure structure = new Structure(sCode, sType, sLibele);
                StructureController.updateStructure(structure); // Executer la méthode de modification dans la base de données
                JOptionPane.showMessageDialog(null, "Modification validée");
                typeStr.setSelectedIndex(0);
                codeStr.setText("");
                libeleStr.setText("");
            }
        }

    }

    //Supprimer une structure********************************************************************************************************************
    public static void supprimerStructure() {
        rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cette structure?", "Suppression d'une structure", JOptionPane.YES_NO_OPTION);
        if (rep == JOptionPane.YES_OPTION) {
            Structure structure = new Structure();
            StructureController.deleteStructure(structure);// Executer la méthode de suppression des données    
            JOptionPane.showMessageDialog(null, "Structure supprimée");
            typeStr.setSelectedIndex(0);
            codeStr.setText("");
            libeleStr.setText("");
        }
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneauPrincipal = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau_agent = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        comboCatAgent = new javax.swing.JComboBox<>();
        boxIndiceSal = new javax.swing.JTextField();
        boxIndResidence = new javax.swing.JFormattedTextField();
        boxIndeminiteAstreinte = new javax.swing.JFormattedTextField();
        boxIndeminiteTechnicite = new javax.swing.JFormattedTextField();
        boxIndeminiteResponsabilite = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        boxEchelon = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        boxAutreIndeminite = new javax.swing.JFormattedTextField();
        boxChargeMilitaire = new javax.swing.JFormattedTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        boxSalaireIndicMensuel = new javax.swing.JFormattedTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        ligne661 = new javax.swing.JFormattedTextField();
        ligne663 = new javax.swing.JFormattedTextField();
        ligne664 = new javax.swing.JFormattedTextField();
        ligne666 = new javax.swing.JFormattedTextField();
        ligne669 = new javax.swing.JFormattedTextField();
        btn_SelectLigne661 = new javax.swing.JButton();
        btn_SelectLigne663 = new javax.swing.JButton();
        btn_SelectLigne664 = new javax.swing.JButton();
        btn_SelectLigne666 = new javax.swing.JButton();
        btn_SelectLigne669 = new javax.swing.JButton();
        idLigne661 = new javax.swing.JTextField();
        idLigne663 = new javax.swing.JTextField();
        idLigne664 = new javax.swing.JTextField();
        idLigne666 = new javax.swing.JTextField();
        idLigne669 = new javax.swing.JTextField();
        boxContributionCARFO = new javax.swing.JFormattedTextField();
        boxContributionCNSS = new javax.swing.JFormattedTextField();
        boxIndeminiteVestimentaire = new javax.swing.JFormattedTextField();
        jLabel33 = new javax.swing.JLabel();
        boxAllocationFamiliale = new javax.swing.JFormattedTextField();
        boxIndeminiteSpecifique = new javax.swing.JFormattedTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_nouveau = new javax.swing.JButton();
        btn_enregistrer = new javax.swing.JButton();
        btn_modifier = new javax.swing.JButton();
        btn_rafraichir = new javax.swing.JButton();
        btn_rechercheragent = new javax.swing.JButton();
        rechercheMatricule = new javax.swing.JTextField();
        btn_supprimer = new javax.swing.JButton();
        btn_retirerligne = new javax.swing.JButton();
        btn_affecternewprogramme = new javax.swing.JButton();
        boxIndeminiteLogement = new javax.swing.JFormattedTextField();
        panneauForms = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comboStructure = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        boxMatriculeAg = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        boxNomAg = new javax.swing.JTextField();
        boxPrenomAg = new javax.swing.JTextField();
        comboSexeAg = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        comboFonction = new javax.swing.JComboBox<>();
        comboTypeAgent = new javax.swing.JComboBox<>();
        jLabel32 = new javax.swing.JLabel();
        comboMinistere = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        comboEmploiAgent = new javax.swing.JComboBox<>();
        boxDatePriseServiceAg = new javax.swing.JFormattedTextField();
        boxDateNaissAg = new javax.swing.JFormattedTextField();
        idProg = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        boxIncidenceMensuelle = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        boxIncidenceAnnuelle = new javax.swing.JFormattedTextField();
        boxIDAgent = new javax.swing.JTextField();
        coefficientStruc = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestion des agents fonctionnaires");
        setFrameIcon(null);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameActivated(evt);
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        panneauPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        panneauPrincipal.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        tableau_agent.setAutoCreateRowSorter(true);
        tableau_agent.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tableau_agent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Agent", "Matricule", "Nom", "Prénom", "Structure", "Type d'agent"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableau_agent.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableau_agent.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableau_agent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableau_agentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableau_agent);
        if (tableau_agent.getColumnModel().getColumnCount() > 0) {
            tableau_agent.getColumnModel().getColumn(0).setMinWidth(0);
            tableau_agent.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableau_agent.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elements de salaire", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Ind.Respons. :");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 89, -1, -1));

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Ind.Technicité : ");
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 94, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Catégorie/Echelle : ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 25, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Indice Sal. : ");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 23, -1, -1));

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Ind.Résidence. : ");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 23, -1, -1));

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Ind.Astreintes :");
        jPanel2.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 57, -1, -1));

        comboCatAgent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCatAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel2.add(comboCatAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 19, 180, -1));

        boxIndiceSal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndiceSal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                boxIndiceSalKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndiceSalKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                boxIndiceSalKeyTyped(evt);
            }
        });
        jPanel2.add(boxIndiceSal, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 19, 180, 26));

        boxIndResidence.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndResidence.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boxIndResidence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndResidenceKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                boxIndResidenceKeyTyped(evt);
            }
        });
        jPanel2.add(boxIndResidence, new org.netbeans.lib.awtextra.AbsoluteConstraints(1432, 19, 180, 26));

        boxIndeminiteAstreinte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteAstreinte.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndeminiteAstreinte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteAstreinteKeyReleased(evt);
            }
        });
        jPanel2.add(boxIndeminiteAstreinte, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 51, 180, 26));

        boxIndeminiteTechnicite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteTechnicite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndeminiteTechnicite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteTechniciteKeyReleased(evt);
            }
        });
        jPanel2.add(boxIndeminiteTechnicite, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 85, 180, 26));

        boxIndeminiteResponsabilite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteResponsabilite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndeminiteResponsabilite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteResponsabiliteKeyReleased(evt);
            }
        });
        jPanel2.add(boxIndeminiteResponsabilite, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 85, 180, 26));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Echelon : ");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 25, -1, -1));

        boxEchelon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel2.add(boxEchelon, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 19, 180, 26));

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Cont.CARFO : ");
        jPanel2.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1012, 57, -1, -1));

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("Charge Militaire : ");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 126, -1, -1));

        jLabel30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel30.setText("Alloc.Familiales : ");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1012, 91, -1, -1));

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Ind. Vest : ");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(702, 57, 77, -1));

        boxAutreIndeminite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxAutreIndeminite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxAutreIndeminite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxAutreIndeminiteActionPerformed(evt);
            }
        });
        boxAutreIndeminite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxAutreIndeminiteKeyReleased(evt);
            }
        });
        jPanel2.add(boxAutreIndeminite, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 117, 180, 26));

        boxChargeMilitaire.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxChargeMilitaire.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxChargeMilitaire.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxChargeMilitaireKeyReleased(evt);
            }
        });
        jPanel2.add(boxChargeMilitaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 117, 180, 26));

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Ind.Logement :");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 62, -1, -1));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Salaire indiciaire : ");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(1012, 23, -1, -1));

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("Ind.Spécifique : ");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 89, -1, -1));

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setText("Autres Ind. : ");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 121, -1, -1));

        boxSalaireIndicMensuel.setBackground(new java.awt.Color(204, 0, 0));
        boxSalaireIndicMensuel.setForeground(new java.awt.Color(255, 255, 255));
        boxSalaireIndicMensuel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxSalaireIndicMensuel.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        boxSalaireIndicMensuel.setEnabled(false);
        boxSalaireIndicMensuel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel2.add(boxSalaireIndicMensuel, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 19, 180, 26));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Récapitulatif des lignes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Traitements et salaires en espèces (Ligne 661) :");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 31, -1, -1));

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setText("Autres dépenses de personnel (Ligne 669) : ");
        jPanel3.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 101, -1, -1));

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Prestations sociales  (Ligne 666) : ");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 66, -1, -1));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Cotisations sociales (Ligne 664) : ");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 66, -1, -1));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Primes et indemnités (Ligne 663) : ");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(804, 31, -1, -1));

        ligne661.setBackground(new java.awt.Color(204, 0, 0));
        ligne661.setForeground(new java.awt.Color(255, 255, 255));
        ligne661.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ligne661.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        ligne661.setEnabled(false);
        ligne661.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ligne661.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                ligne661InputMethodTextChanged(evt);
            }
        });
        ligne661.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ligne661KeyReleased(evt);
            }
        });
        jPanel3.add(ligne661, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 25, 176, 29));

        ligne663.setBackground(new java.awt.Color(204, 0, 0));
        ligne663.setForeground(new java.awt.Color(255, 255, 255));
        ligne663.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ligne663.setEnabled(false);
        ligne663.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ligne663.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ligne663ActionPerformed(evt);
            }
        });
        jPanel3.add(ligne663, new org.netbeans.lib.awtextra.AbsoluteConstraints(1236, 25, 255, 29));

        ligne664.setBackground(new java.awt.Color(204, 0, 0));
        ligne664.setForeground(new java.awt.Color(255, 255, 255));
        ligne664.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ligne664.setEnabled(false);
        ligne664.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(ligne664, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 60, 176, 29));

        ligne666.setBackground(new java.awt.Color(204, 0, 0));
        ligne666.setForeground(new java.awt.Color(255, 255, 255));
        ligne666.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ligne666.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(ligne666, new org.netbeans.lib.awtextra.AbsoluteConstraints(1235, 60, 256, 29));

        ligne669.setBackground(new java.awt.Color(204, 0, 0));
        ligne669.setForeground(new java.awt.Color(255, 255, 255));
        ligne669.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ligne669.setEnabled(false);
        ligne669.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jPanel3.add(ligne669, new org.netbeans.lib.awtextra.AbsoluteConstraints(523, 95, 176, 29));

        btn_SelectLigne661.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_SelectLigne661.setForeground(new java.awt.Color(204, 0, 0));
        btn_SelectLigne661.setText("Sélectionnez une ligne 661");
        btn_SelectLigne661.setToolTipText("Sélectionnez une ligne");
        btn_SelectLigne661.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectLigne661ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_SelectLigne661, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 25, -1, 29));

        btn_SelectLigne663.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_SelectLigne663.setForeground(new java.awt.Color(204, 0, 0));
        btn_SelectLigne663.setText("Sélectionnez une ligne 663");
        btn_SelectLigne663.setToolTipText("Sélectionnez une ligne 661");
        btn_SelectLigne663.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectLigne663ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_SelectLigne663, new org.netbeans.lib.awtextra.AbsoluteConstraints(1030, 25, -1, 29));

        btn_SelectLigne664.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_SelectLigne664.setForeground(new java.awt.Color(204, 0, 0));
        btn_SelectLigne664.setText("Sélectionnez une ligne 664");
        btn_SelectLigne664.setToolTipText("Sélectionnez une ligne 664");
        btn_SelectLigne664.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectLigne664ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_SelectLigne664, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 60, -1, 29));

        btn_SelectLigne666.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_SelectLigne666.setForeground(new java.awt.Color(204, 0, 0));
        btn_SelectLigne666.setText("Sélectionnez une ligne 666");
        btn_SelectLigne666.setToolTipText("Sélectionnez une ligne 666");
        btn_SelectLigne666.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectLigne666ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_SelectLigne666, new org.netbeans.lib.awtextra.AbsoluteConstraints(1029, 60, -1, 29));

        btn_SelectLigne669.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_SelectLigne669.setForeground(new java.awt.Color(204, 0, 0));
        btn_SelectLigne669.setText("Sélectionnez une ligne 669");
        btn_SelectLigne669.setToolTipText("Sélectionnez une ligne 669");
        btn_SelectLigne669.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectLigne669ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_SelectLigne669, new org.netbeans.lib.awtextra.AbsoluteConstraints(317, 95, -1, 29));
        jPanel3.add(idLigne661, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 28, 93, -1));
        jPanel3.add(idLigne663, new org.netbeans.lib.awtextra.AbsoluteConstraints(1497, 28, 93, -1));
        jPanel3.add(idLigne664, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 63, 93, -1));
        jPanel3.add(idLigne666, new org.netbeans.lib.awtextra.AbsoluteConstraints(1497, 63, 93, -1));
        jPanel3.add(idLigne669, new org.netbeans.lib.awtextra.AbsoluteConstraints(705, 98, 93, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 149, 1601, 140));

        boxContributionCARFO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxContributionCARFO.setEnabled(false);
        boxContributionCARFO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(boxContributionCARFO, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 51, 180, -1));

        boxContributionCNSS.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxContributionCNSS.setEnabled(false);
        boxContributionCNSS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel2.add(boxContributionCNSS, new org.netbeans.lib.awtextra.AbsoluteConstraints(1432, 51, 180, -1));

        boxIndeminiteVestimentaire.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteVestimentaire.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boxIndeminiteVestimentaire.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteVestimentaireKeyReleased(evt);
            }
        });
        jPanel2.add(boxIndeminiteVestimentaire, new org.netbeans.lib.awtextra.AbsoluteConstraints(799, 51, 180, -1));

        jLabel33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel33.setText("Cont.CNSS :");
        jPanel2.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 57, -1, -1));

        boxAllocationFamiliale.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxAllocationFamiliale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boxAllocationFamiliale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxAllocationFamilialeKeyReleased(evt);
            }
        });
        jPanel2.add(boxAllocationFamiliale, new org.netbeans.lib.awtextra.AbsoluteConstraints(1134, 85, 180, -1));

        boxIndeminiteSpecifique.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteSpecifique.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndeminiteSpecifique.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteSpecifiqueKeyReleased(evt);
            }
        });
        jPanel2.add(boxIndeminiteSpecifique, new org.netbeans.lib.awtextra.AbsoluteConstraints(491, 85, 180, 26));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        btn_nouveau.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_nouveau.setForeground(new java.awt.Color(0, 102, 51));
        btn_nouveau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_nouveau.png"))); // NOI18N
        btn_nouveau.setText("Nouveau");
        btn_nouveau.setToolTipText("Nouveau");
        btn_nouveau.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_nouveau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nouveauActionPerformed(evt);
            }
        });

        btn_enregistrer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_enregistrer.setForeground(new java.awt.Color(0, 102, 51));
        btn_enregistrer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_enregistrer.png"))); // NOI18N
        btn_enregistrer.setText("Enregistrer");
        btn_enregistrer.setToolTipText("Enregistrer");
        btn_enregistrer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_enregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enregistrerActionPerformed(evt);
            }
        });

        btn_modifier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_modifier.setForeground(new java.awt.Color(0, 102, 51));
        btn_modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_modifier.png"))); // NOI18N
        btn_modifier.setText("Modifier");
        btn_modifier.setToolTipText("Modifier");
        btn_modifier.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierActionPerformed(evt);
            }
        });

        btn_rafraichir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_rafraichir.setForeground(new java.awt.Color(0, 102, 51));
        btn_rafraichir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_actualiser.png"))); // NOI18N
        btn_rafraichir.setText("Rafraîchir la liste");
        btn_rafraichir.setToolTipText("Rafraîchir la liste");
        btn_rafraichir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_rafraichir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rafraichirActionPerformed(evt);
            }
        });

        btn_rechercheragent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_rechercheragent.setForeground(new java.awt.Color(0, 102, 51));
        btn_rechercheragent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/chercher.png"))); // NOI18N
        btn_rechercheragent.setText("Rechercher un agent");
        btn_rechercheragent.setToolTipText("Rechercher un agent");
        btn_rechercheragent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_rechercheragent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rechercheragentActionPerformed(evt);
            }
        });

        rechercheMatricule.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rechercheMatricule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rechercheMatriculeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rechercheMatriculeKeyTyped(evt);
            }
        });

        btn_supprimer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_supprimer.setForeground(new java.awt.Color(0, 102, 51));
        btn_supprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_supprimer.png"))); // NOI18N
        btn_supprimer.setText("Supprimer");
        btn_supprimer.setToolTipText("Supprimer");
        btn_supprimer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supprimerActionPerformed(evt);
            }
        });

        btn_retirerligne.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_retirerligne.setForeground(new java.awt.Color(0, 102, 51));
        btn_retirerligne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_retrait.png"))); // NOI18N
        btn_retirerligne.setText("Rétirer les lignes ");
        btn_retirerligne.setToolTipText("Rétirer les lignes ");
        btn_retirerligne.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_retirerligne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_retirerligneActionPerformed(evt);
            }
        });

        btn_affecternewprogramme.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_affecternewprogramme.setForeground(new java.awt.Color(0, 102, 51));
        btn_affecternewprogramme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_reaffecter.png"))); // NOI18N
        btn_affecternewprogramme.setText("Réaffecter nouv. prog");
        btn_affecternewprogramme.setToolTipText("Réaffecter nouv. prog");
        btn_affecternewprogramme.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_affecternewprogramme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_affecternewprogrammeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btn_nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btn_enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btn_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(btn_supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_retirerligne, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_affecternewprogramme, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rechercheragent, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rechercheMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_enregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_rechercheragent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rechercheMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_retirerligne, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_affecternewprogramme, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 300, 1613, 90));

        boxIndeminiteLogement.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteLogement.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndeminiteLogement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteLogementKeyReleased(evt);
            }
        });
        jPanel2.add(boxIndeminiteLogement, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 50, 180, 30));

        javax.swing.GroupLayout panneauPrincipalLayout = new javax.swing.GroupLayout(panneauPrincipal);
        panneauPrincipal.setLayout(panneauPrincipalLayout);
        panneauPrincipalLayout.setHorizontalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauPrincipalLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        panneauPrincipalLayout.setVerticalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        panneauForms.setBackground(new java.awt.Color(255, 255, 255));
        panneauForms.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations administratives de l'agent", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panneauForms.setPreferredSize(new java.awt.Dimension(1600, 396));
        panneauForms.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Structure :");
        panneauForms.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1069, 127, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Type d'agent : ");
        panneauForms.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 92, -1, -1));

        comboStructure.setEditable(true);
        comboStructure.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboStructure.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        comboStructure.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStructureItemStateChanged(evt);
            }
        });
        panneauForms.add(comboStructure, new org.netbeans.lib.awtextra.AbsoluteConstraints(1205, 124, 299, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Matricule :");
        panneauForms.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 31, -1, -1));

        boxMatriculeAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxMatriculeAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 25, 179, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Nom :");
        panneauForms.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 60, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Prénom (s) : ");
        panneauForms.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 57, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Sexe : ");
        panneauForms.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 92, -1, -1));

        boxNomAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxNomAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 54, 387, -1));

        boxPrenomAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxPrenomAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 54, 386, -1));

        comboSexeAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboSexeAg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Homme", "Femme" }));
        panneauForms.add(comboSexeAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 89, 387, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Date de naissance : ");
        panneauForms.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1069, 57, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Date.Prise de service : ");
        panneauForms.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 127, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Fonction : ");
        panneauForms.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 127, -1, -1));

        comboFonction.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboFonction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        panneauForms.add(comboFonction, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 124, 386, -1));

        comboTypeAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboTypeAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Fonctionnaire" }));
        comboTypeAgent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTypeAgentItemStateChanged(evt);
            }
        });
        panneauForms.add(comboTypeAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 89, 386, -1));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setText("Ministère d'origine");
        panneauForms.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 162, -1, -1));

        comboMinistere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboMinistere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        panneauForms.add(comboMinistere, new org.netbeans.lib.awtextra.AbsoluteConstraints(184, 159, 386, -1));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Emploi :");
        panneauForms.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1069, 92, -1, -1));

        comboEmploiAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboEmploiAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        panneauForms.add(comboEmploiAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1205, 89, 299, -1));

        boxDatePriseServiceAg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        boxDatePriseServiceAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxDatePriseServiceAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 124, 387, -1));

        boxDateNaissAg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        boxDateNaissAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxDateNaissAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(1205, 54, 299, -1));
        panneauForms.add(idProg, new org.netbeans.lib.awtextra.AbsoluteConstraints(374, 25, 80, -1));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Inncidence mensuelle : ");
        panneauForms.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 28, -1, -1));

        boxIncidenceMensuelle.setBackground(new java.awt.Color(0, 102, 51));
        boxIncidenceMensuelle.setForeground(new java.awt.Color(255, 255, 255));
        boxIncidenceMensuelle.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIncidenceMensuelle.setEnabled(false);
        boxIncidenceMensuelle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        panneauForms.add(boxIncidenceMensuelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 25, 333, -1));

        jLabel34.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel34.setText("Incidence annuelle : ");
        panneauForms.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1069, 28, -1, -1));

        boxIncidenceAnnuelle.setBackground(new java.awt.Color(0, 102, 51));
        boxIncidenceAnnuelle.setForeground(new java.awt.Color(255, 255, 255));
        boxIncidenceAnnuelle.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIncidenceAnnuelle.setEnabled(false);
        boxIncidenceAnnuelle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boxIncidenceAnnuelle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxIncidenceAnnuelleActionPerformed(evt);
            }
        });
        panneauForms.add(boxIncidenceAnnuelle, new org.netbeans.lib.awtextra.AbsoluteConstraints(1205, 25, 299, -1));
        panneauForms.add(boxIDAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, 90, -1));
        panneauForms.add(coefficientStruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1510, 130, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panneauForms, javax.swing.GroupLayout.PREFERRED_SIZE, 1623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panneauForms, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1631, 774);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nouveauActionPerformed
        // TODO add your handling code here:
        reinitChamps();
    }//GEN-LAST:event_btn_nouveauActionPerformed

    private void btn_enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enregistrerActionPerformed
        enregistrerAgent();
        listerAgent();
    }//GEN-LAST:event_btn_enregistrerActionPerformed

    private void btn_rafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rafraichirActionPerformed
        // TODO add your handling code here:
        listerAgent();
    }//GEN-LAST:event_btn_rafraichirActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        coefficientStruc.setVisible(false);
        idProg.setVisible(false);
        idLigne661.setVisible(false);
        idLigne663.setVisible(false);
        idLigne664.setVisible(false);
        idLigne666.setVisible(false);
        idLigne669.setVisible(false);
        boxIDAgent.setVisible(false);
        listerComboCategorieEchelle();
        listerComboEmploi();
        listerComboFonction();
        listerComboMinistere();
        listerComboStructure();
       
        //gestion de la mise à jour en temps réelle des champs de l'incidence mensuelle et annuelle
        InterfaceAgent.ligne661.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceAgent.ligne663.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceAgent.ligne664.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceAgent.ligne666.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceAgent.ligne669.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });

        //ajout d'un placeholder sur le champs matricule pour la recherche
        rechercheMatricule.setText("Saisir le numéro matricule...");
        rechercheMatricule.setForeground(Color.GRAY);
        rechercheMatricule.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (rechercheMatricule.getText().equals("Saisir le numéro matricule...")) {
                    rechercheMatricule.setText("");
                    rechercheMatricule.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (rechercheMatricule.getText().isEmpty()) {
                    rechercheMatricule.setText("Saisir le numéro matricule...");
                    rechercheMatricule.setForeground(Color.GRAY);
                }
            }
        });

    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        listerAgent();
        JTableHeader header = tableau_agent.getTableHeader();
        header.setDefaultRenderer(new PropsTableau());
       /*     //gestion de la mise à jour en temps réelle des champs de l'incidence mensuelle et annuelle
        InterfaceAgent.ligne661.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceAgent.ligne663.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceAgent.ligne664.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceAgent.ligne666.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceAgent.ligne669.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });*/

    }//GEN-LAST:event_formInternalFrameOpened

    private void tableau_agentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableau_agentMouseClicked
        // TODO add your handling code here:
        displayOneAgenntToUpdateOrDelete();

    }//GEN-LAST:event_tableau_agentMouseClicked

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
        // TODO add your handling code here:
        modifierAgent();
        listerAgent();

    }//GEN-LAST:event_btn_modifierActionPerformed

    private void boxIndiceSalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndiceSalKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            afficherSalaireIndiciaire();
        }
    }//GEN-LAST:event_boxIndiceSalKeyPressed

    private void boxAutreIndeminiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxAutreIndeminiteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxAutreIndeminiteActionPerformed

    private void boxIndiceSalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndiceSalKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_boxIndiceSalKeyTyped

    private void boxIndiceSalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndiceSalKeyReleased
        // TODO add your handling code here:
        afficherSalaireIndiciaire();
        afficherContribution();
    }//GEN-LAST:event_boxIndiceSalKeyReleased

    private void boxIndResidenceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndResidenceKeyReleased
        // TODO add your handling code here:

    }//GEN-LAST:event_boxIndResidenceKeyReleased

    private void comboTypeAgentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTypeAgentItemStateChanged
        // TODO add your handling code here:
        afficherContribution();

    }//GEN-LAST:event_comboTypeAgentItemStateChanged

    private void boxIndeminiteAstreinteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndeminiteAstreinteKeyReleased
        // TODO add your handling code here:
        afficherSommeIndeminite663();
    }//GEN-LAST:event_boxIndeminiteAstreinteKeyReleased

    private void boxIndeminiteTechniciteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndeminiteTechniciteKeyReleased
        // TODO add your handling code here:
        afficherSommeIndeminite663();
    }//GEN-LAST:event_boxIndeminiteTechniciteKeyReleased

    private void boxIndeminiteResponsabiliteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndeminiteResponsabiliteKeyReleased
        // TODO add your handling code here:
        afficherSommeIndeminite663();
    }//GEN-LAST:event_boxIndeminiteResponsabiliteKeyReleased

    private void boxIndeminiteVestimentaireKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndeminiteVestimentaireKeyReleased
        // TODO add your handling code here:
        afficherSommeIndeminite663();
    }//GEN-LAST:event_boxIndeminiteVestimentaireKeyReleased

    private void boxAllocationFamilialeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxAllocationFamilialeKeyReleased
        // TODO add your handling code here:
        afficherLigne666();
    }//GEN-LAST:event_boxAllocationFamilialeKeyReleased

    private void boxAutreIndeminiteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxAutreIndeminiteKeyReleased
        // TODO add your handling code here:
        afficherLigne669();
    }//GEN-LAST:event_boxAutreIndeminiteKeyReleased

    private void boxChargeMilitaireKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxChargeMilitaireKeyReleased
        // TODO add your handling code here:
        afficherLigne669();

    }//GEN-LAST:event_boxChargeMilitaireKeyReleased

    private void boxIndeminiteSpecifiqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndeminiteSpecifiqueKeyReleased
        // TODO add your handling code here:
        afficherLigne669();

    }//GEN-LAST:event_boxIndeminiteSpecifiqueKeyReleased

    private void boxIncidenceAnnuelleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxIncidenceAnnuelleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxIncidenceAnnuelleActionPerformed

    private void ligne661KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ligne661KeyReleased
        // TODO add your handling code here:
        afficherIncidenceMensuelleAnnuelle();
    }//GEN-LAST:event_ligne661KeyReleased

    private void ligne661InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_ligne661InputMethodTextChanged
        // TODO add your handling code here:

    }//GEN-LAST:event_ligne661InputMethodTextChanged

    private void btn_rechercheragentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rechercheragentActionPerformed
        // TODO add your handling code here:
        displayOneAgent();
    }//GEN-LAST:event_btn_rechercheragentActionPerformed

    private void btn_SelectLigne661ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectLigne661ActionPerformed
        // TODO add your handling code here:
        afficherListeLigne661IdProgramme();
    }//GEN-LAST:event_btn_SelectLigne661ActionPerformed

    private void comboStructureItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStructureItemStateChanged
        // TODO add your handling code here:
        displayIDProgramme();
    }//GEN-LAST:event_comboStructureItemStateChanged

    private void btn_SelectLigne663ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectLigne663ActionPerformed
        // TODO add your handling code here:
        afficherListeLigne663IdProgramme();
    }//GEN-LAST:event_btn_SelectLigne663ActionPerformed

    private void btn_SelectLigne664ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectLigne664ActionPerformed
        // TODO add your handling code here:
        afficherListeLigne664IdProgramme();
    }//GEN-LAST:event_btn_SelectLigne664ActionPerformed

    private void btn_SelectLigne666ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectLigne666ActionPerformed
        // TODO add your handling code here:
        afficherListeLigne666IdProgramme();
    }//GEN-LAST:event_btn_SelectLigne666ActionPerformed

    private void btn_SelectLigne669ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectLigne669ActionPerformed
        // TODO add your handling code here:
        afficherListeLigne669IdProgramme();
    }//GEN-LAST:event_btn_SelectLigne669ActionPerformed

    private void ligne663ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ligne663ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ligne663ActionPerformed

    private void rechercheMatriculeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheMatriculeKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_rechercheMatriculeKeyTyped

    private void rechercheMatriculeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheMatriculeKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            displayOneAgent();
        }
    }//GEN-LAST:event_rechercheMatriculeKeyReleased

    private void btn_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supprimerActionPerformed
        // TODO add your handling code here:
        supprimerAgent();
        listerAgent();
    }//GEN-LAST:event_btn_supprimerActionPerformed

    private void boxIndeminiteLogementKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndeminiteLogementKeyReleased
        // TODO add your handling code here:
        afficherSommeIndeminite663();
    }//GEN-LAST:event_boxIndeminiteLogementKeyReleased

    private void btn_retirerligneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_retirerligneActionPerformed
        // TODO add your handling code here:
        retraitDeLignes();
    }//GEN-LAST:event_btn_retirerligneActionPerformed

    private void btn_affecternewprogrammeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_affecternewprogrammeActionPerformed
        // TODO add your handling code here:
        reaffecterAgent();
    }//GEN-LAST:event_btn_affecternewprogrammeActionPerformed

    private void boxIndResidenceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndResidenceKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_boxIndResidenceKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JFormattedTextField boxAllocationFamiliale;
    public static javax.swing.JFormattedTextField boxAutreIndeminite;
    public static javax.swing.JFormattedTextField boxChargeMilitaire;
    public static javax.swing.JFormattedTextField boxContributionCARFO;
    public static javax.swing.JFormattedTextField boxContributionCNSS;
    public static javax.swing.JFormattedTextField boxDateNaissAg;
    public static javax.swing.JFormattedTextField boxDatePriseServiceAg;
    public static javax.swing.JTextField boxEchelon;
    public static javax.swing.JTextField boxIDAgent;
    public static javax.swing.JFormattedTextField boxIncidenceAnnuelle;
    public static javax.swing.JFormattedTextField boxIncidenceMensuelle;
    public static javax.swing.JFormattedTextField boxIndResidence;
    public static javax.swing.JFormattedTextField boxIndeminiteAstreinte;
    public static javax.swing.JFormattedTextField boxIndeminiteLogement;
    public static javax.swing.JFormattedTextField boxIndeminiteResponsabilite;
    public static javax.swing.JFormattedTextField boxIndeminiteSpecifique;
    public static javax.swing.JFormattedTextField boxIndeminiteTechnicite;
    public static javax.swing.JFormattedTextField boxIndeminiteVestimentaire;
    public static javax.swing.JTextField boxIndiceSal;
    public static javax.swing.JTextField boxMatriculeAg;
    public static javax.swing.JTextField boxNomAg;
    public static javax.swing.JTextField boxPrenomAg;
    public static javax.swing.JFormattedTextField boxSalaireIndicMensuel;
    public static javax.swing.JButton btn_SelectLigne661;
    public static javax.swing.JButton btn_SelectLigne663;
    public static javax.swing.JButton btn_SelectLigne664;
    public static javax.swing.JButton btn_SelectLigne666;
    public static javax.swing.JButton btn_SelectLigne669;
    private javax.swing.JButton btn_affecternewprogramme;
    private javax.swing.JButton btn_enregistrer;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JButton btn_nouveau;
    private javax.swing.JButton btn_rafraichir;
    private javax.swing.JButton btn_rechercheragent;
    private javax.swing.JButton btn_retirerligne;
    private javax.swing.JButton btn_supprimer;
    public static javax.swing.JTextField coefficientStruc;
    public static javax.swing.JComboBox<String> comboCatAgent;
    public static javax.swing.JComboBox<String> comboEmploiAgent;
    public static javax.swing.JComboBox<String> comboFonction;
    public static javax.swing.JComboBox<String> comboMinistere;
    public static javax.swing.JComboBox<String> comboSexeAg;
    public static javax.swing.JComboBox<String> comboStructure;
    public static javax.swing.JComboBox<String> comboTypeAgent;
    public static javax.swing.JTextField idLigne661;
    public static javax.swing.JTextField idLigne663;
    public static javax.swing.JTextField idLigne664;
    public static javax.swing.JTextField idLigne666;
    public static javax.swing.JTextField idLigne669;
    public static javax.swing.JTextField idProg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JFormattedTextField ligne661;
    public static javax.swing.JFormattedTextField ligne663;
    public static javax.swing.JFormattedTextField ligne664;
    public static javax.swing.JFormattedTextField ligne666;
    public static javax.swing.JFormattedTextField ligne669;
    public static javax.swing.JPanel panneauForms;
    public static javax.swing.JPanel panneauPrincipal;
    public static javax.swing.JTextField rechercheMatricule;
    public static javax.swing.JTable tableau_agent;
    // End of variables declaration//GEN-END:variables
}
