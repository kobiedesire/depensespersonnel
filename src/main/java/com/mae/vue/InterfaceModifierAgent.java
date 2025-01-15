/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mae.vue;

import com.mae.controller.AgentModifController;
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
public class InterfaceModifierAgent extends javax.swing.JInternalFrame {

    /**
     *
     */
    public InterfaceModifierAgent() {
        initComponents();
        AutoCompleteDecorator.decorate(comboStructure);
        AutoCompleteDecorator.decorate(comboFonction);
        AutoCompleteDecorator.decorate(comboTypeAgent);
        AutoCompleteDecorator.decorate(comboCatAgent);
        AutoCompleteDecorator.decorate(comboEmploiAgent);
        AutoCompleteDecorator.decorate(comboMinistere);
        AutoCompleteDecorator.decorate(comboSexeAg);

    }  
 
   
    //remplissage du combobox des categories
    public static void listerComboCategorieEchelle() {
        AgentModifController.listCategorieInCombo();// Executer la méthode de remplissage du combo
    }

    //remplissage du combobox des emplois
    public static void listerComboEmploi() {
        AgentModifController.listEmploiInCombo();// Executer la méthode de remplissage du combo
    }

    //remplissage du combobox des fonctions
    public static void listerComboFonction() {
        AgentModifController.listFonctionInCombo();// Executer la méthode de remplissage du combo
    }

    //remplissage du combobox des ministères
    public static void listerComboMinistere() {
        AgentModifController.listMinistereCombo();// Executer la méthode de remplissage du combo
    }

    //remplissage du combobox des structures
    public static void listerComboStructure() {
        AgentModifController.listStructureCombo();// Executer la méthode de remplissage du combo
    }

    //Vider les tous les champs   
    public static void reinitChamps() {
        AgentModifController.viderChamps();
    }
    
     //afficher les informations d'un agents dans les champs
    public static void displayOneAgent() {
        AgentModifController.displayAgentInBox();

    }
    
     //afficher les informations d'un agents dans les champs
    public static void imprimerAgent() {
       // AgentModifController.imprimerFicheAgent();
          AgentModifController. printScreen();

    }
    
    
    
    private static int rep;

    public static void modifierAgent() {
       
        // Récuperation des donnéses du formulaire
        //champ de saisie caractere
        String aMatricule = boxMatriculeAg.getText().trim();
        String aNom = boxNomAg.getText().trim().toUpperCase();
        String aPrenom = boxPrenomAg.getText().trim();
        String aDateNaiss = boxDateNaissAg.getText().trim();
        String aDatePriseService = boxDatePriseServiceAg.getText().trim();
        //champs de selection 
        String aSexe = (comboSexeAg.getSelectedItem().toString()).trim();
        //String aTypeAgent = (comboTypeAgent.getSelectedItem().toString()).trim();
        //String aStructure = (comboStructure.getSelectedItem().toString()).trim();
        String aMinistereOrigine = (comboMinistere.getSelectedItem().toString()).trim();
        String aFonction = (comboFonction.getSelectedItem().toString()).trim();
        String aEmploi = (comboEmploiAgent.getSelectedItem().toString()).trim();
        String aCategorieEchelle = (comboCatAgent.getSelectedItem().toString()).trim();

        if (aMatricule.isBlank() || aNom.isBlank() || aPrenom.isBlank() || aDateNaiss.isBlank() || aDatePriseService.isBlank() || aSexe.isBlank()
                 || aMinistereOrigine.isBlank() || aFonction.isBlank() || aEmploi.isBlank() || aCategorieEchelle.isBlank() || boxEchelon.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Vérifiez les champs obligatoires ou des lignes budgétaires ne sont pas sélectionnées...");
        } else {            
            int aEchelon = Integer.parseInt(boxEchelon.getText());           
            rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment modifier cet agent?", "Modification d'un agent", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                Agent agent = new Agent(aMatricule, aNom, aPrenom, aDateNaiss, aSexe, aDatePriseService, aMinistereOrigine, aFonction, aEmploi, aCategorieEchelle, aEchelon);
               
                AgentModifController.updateAgent(agent);  // Enregistrez  dans la base de données                
                reinitChamps();
                JOptionPane.showMessageDialog(null, "Modification validée");
            }
        }

    }
    
    
    
    

    //Afficher l'id du programme de la structure  
   /* public static void displayIDProgramme() {
        AgentModifController.afficherIDProgrammeFromStructure();
    }*/

    //Fonction pour l'enregistrement d'un agent********************************************************************************************************************
   /* public static void enregistrerAgent() {
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
            AgentModifController.saveAgent(agent);  // Enregistrez  dans la base de données     
            AgentModifController.updateLigne661();
            AgentModifController.updateLigne663();
            AgentModifController.updateLigne664();
            AgentModifController.updateLigne666();
            AgentModifController.updateLigne669();
            reinitChamps();
        }

    }*/

    //Fonction pour la modification d'un agent********************************************************************************************************************
   /* */

    //Supprimer un agent********************************************************************************************************************
   /* public static void supprimerAgent() {
        rep = JOptionPane.showConfirmDialog(null, " !!! Voulez-vous vraiment supprimer cet agent?", "Suppression d'un agent", JOptionPane.YES_NO_OPTION);
        if (rep == JOptionPane.YES_OPTION) {
            Agent agent = new Agent();
            AgentModifController.updateLigne661ForDelete();
            AgentModifController.updateLigne663ForDelete();
            AgentModifController.updateLigne664ForDelete();
            AgentModifController.updateLigne666ForDelete();
            AgentModifController.updateLigne669ForDelete();
            AgentModifController.deleteAgent(agent);// Executer la méthode de suppression des données    
            JOptionPane.showMessageDialog(null, "L'agent a été supprimé avec succès.");
            reinitChamps();
        }
    }*/

  /*  public static void retraitDeLignes() {
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

                AgentModifController.updateLigne661ForDelete();
                AgentModifController.updateLigne663ForDelete();
                AgentModifController.updateLigne664ForDelete();
                AgentModifController.updateLigne666ForDelete();
                AgentModifController.updateLigne669ForDelete();
                AgentModifController.updateAgent(agent);  // mise à jours de l'agent  dans la base de données   
                reinitChamps();
                JOptionPane.showMessageDialog(null, "Les lignes budgétaires de cet agent ont été retirées de son programme !");
            }
        }

    }*/

    //reacffecter un agent
   /* public static void reaffecterAgent() {
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

                AgentModifController.updateAgent(agent);  // Enregistrez  dans la base de données    
                AgentModifController.updateLigne661();
                AgentModifController.updateLigne663();
                AgentModifController.updateLigne664();
                AgentModifController.updateLigne666();
                AgentModifController.updateLigne669();

                reinitChamps();
                JOptionPane.showMessageDialog(null, "Réaffectation effectuée avec succès !");

            }
        }
    }*/

    //Lister toutes les agents********************************************************************************************************************
   /* public static void listerAgent() {
        AgentModifController.listAll(); // Executer la méthode d'affichage des données  
    }

    //afficher un agent
    public static void displayOneAgent() {
        AgentModifController.rechercheAgentByMatricule();
    }

   

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 661********************************************************************************************************************
    public static void afficherListeLigne661IdProgramme() {
        AgentModifController.afficherIdProgrammeListeSelectLigne661(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 663********************************************************************************************************************
    public static void afficherListeLigne663IdProgramme() {
        AgentModifController.afficherIdProgrammeListeSelectLigne663(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 664********************************************************************************************************************
    public static void afficherListeLigne664IdProgramme() {
        AgentModifController.afficherIdProgrammeListeSelectLigne664(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 666********************************************************************************************************************
    public static void afficherListeLigne666IdProgramme() {
        AgentModifController.afficherIdProgrammeListeSelectLigne666(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 669********************************************************************************************************************
    public static void afficherListeLigne669IdProgramme() {
        AgentModifController.afficherIdProgrammeListeSelectLigne669(); // Executer la méthode d'affichage des données  
    }*/

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

    }*/

    //Supprimer une structure********************************************************************************************************************
   /* public static void supprimerStructure() {
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
        boxIDAgent = new javax.swing.JTextField();
        coefficientStruc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        comboCatAgent = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        boxEchelon = new javax.swing.JTextField();
        btn_rechercheragent = new javax.swing.JButton();
        rechercheMatricule = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_nouveau = new javax.swing.JButton();
        btn_modifier = new javax.swing.JButton();
        btn_modifier1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Mise à jour de la situation administrative d'un agent");
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

        panneauPrincipal.setBackground(new java.awt.Color(51, 153, 0));
        panneauPrincipal.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        javax.swing.GroupLayout panneauPrincipalLayout = new javax.swing.GroupLayout(panneauPrincipal);
        panneauPrincipal.setLayout(panneauPrincipalLayout);
        panneauPrincipalLayout.setHorizontalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1212, Short.MAX_VALUE)
        );
        panneauPrincipalLayout.setVerticalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        panneauForms.setBackground(new java.awt.Color(255, 255, 255));
        panneauForms.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations administratives de l'agent", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panneauForms.setPreferredSize(new java.awt.Dimension(1600, 396));
        panneauForms.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Structure :");
        panneauForms.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 284, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Type d'agent : ");
        panneauForms.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 241, -1, -1));

        comboStructure.setEditable(true);
        comboStructure.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboStructure.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        comboStructure.setEnabled(false);
        comboStructure.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStructureItemStateChanged(evt);
            }
        });
        panneauForms.add(comboStructure, new org.netbeans.lib.awtextra.AbsoluteConstraints(675, 280, 442, 26));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Matricule :");
        panneauForms.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 89, 73, 27));

        boxMatriculeAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxMatriculeAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 89, 461, 27));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Nom :");
        panneauForms.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 141, -1, -1));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Prénom (s) : ");
        panneauForms.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 192, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Sexe : ");
        panneauForms.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 284, -1, -1));

        boxNomAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxNomAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 142, 490, 27));

        boxPrenomAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxPrenomAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 187, 452, 27));

        comboSexeAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboSexeAg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Homme", "Femme" }));
        panneauForms.add(comboSexeAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 281, 491, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Date de naissance : ");
        panneauForms.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Date.Prise de service : ");
        panneauForms.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 336, -1, -1));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Fonction : ");
        panneauForms.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 192, -1, -1));

        comboFonction.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboFonction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        panneauForms.add(comboFonction, new org.netbeans.lib.awtextra.AbsoluteConstraints(676, 187, 441, 26));

        comboTypeAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboTypeAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        comboTypeAgent.setEnabled(false);
        comboTypeAgent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTypeAgentItemStateChanged(evt);
            }
        });
        panneauForms.add(comboTypeAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(704, 236, 413, 26));

        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setText("Ministère d'origine");
        panneauForms.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 392, -1, -1));

        comboMinistere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboMinistere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        panneauForms.add(comboMinistere, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 387, 387, 27));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Emploi :");
        panneauForms.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 336, -1, -1));

        comboEmploiAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboEmploiAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        panneauForms.add(comboEmploiAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(671, 331, 446, 26));

        boxDatePriseServiceAg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        boxDatePriseServiceAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxDatePriseServiceAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 331, 387, 27));

        boxDateNaissAg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        boxDateNaissAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxDateNaissAg, new org.netbeans.lib.awtextra.AbsoluteConstraints(173, 235, 387, 27));
        panneauForms.add(idProg, new org.netbeans.lib.awtextra.AbsoluteConstraints(774, 34, 80, -1));
        panneauForms.add(boxIDAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 34, 90, -1));
        panneauForms.add(coefficientStruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(872, 34, -1, -1));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Catégorie/Echelle : ");
        panneauForms.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 147, -1, -1));

        comboCatAgent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCatAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        panneauForms.add(comboCatAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(733, 141, 384, -1));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Echelon : ");
        panneauForms.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(603, 94, -1, -1));

        boxEchelon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        panneauForms.add(boxEchelon, new org.netbeans.lib.awtextra.AbsoluteConstraints(672, 89, 445, 27));

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
        panneauForms.add(btn_rechercheragent, new org.netbeans.lib.awtextra.AbsoluteConstraints(203, 25, 170, 31));

        rechercheMatricule.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rechercheMatricule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                rechercheMatriculeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rechercheMatriculeKeyTyped(evt);
            }
        });
        panneauForms.add(rechercheMatricule, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 25, 165, 31));

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

        btn_modifier1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_modifier1.setForeground(new java.awt.Color(0, 102, 51));
        btn_modifier1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imprimante.png"))); // NOI18N
        btn_modifier1.setText("Imprimer fiche agent");
        btn_modifier1.setToolTipText("Imprimer fiche agent");
        btn_modifier1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_modifier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifier1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btn_nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_modifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_modifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panneauForms, javax.swing.GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panneauForms, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1218, 603);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nouveauActionPerformed
        // TODO add your handling code here:
        reinitChamps();
    }//GEN-LAST:event_btn_nouveauActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        coefficientStruc.setVisible(false);
        idProg.setVisible(false);
       // idLigne661.setVisible(false);
       // idLigne663.setVisible(false);
       // idLigne664.setVisible(false);
       // idLigne666.setVisible(false);
       // idLigne669.setVisible(false);
        boxIDAgent.setVisible(false);
        listerComboCategorieEchelle();
        listerComboEmploi();
        listerComboFonction();
        listerComboMinistere();
        listerComboStructure();
        
       
        //gestion de la mise à jour en temps réelle des champs de l'incidence mensuelle et annuelle
        /*InterfaceModifierAgent.ligne661.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceModifierAgent.ligne663.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceModifierAgent.ligne664.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceModifierAgent.ligne666.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceModifierAgent.ligne669.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceModifierAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });*/

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
       // listerAgent();
       // JTableHeader header = tableau_agent.getTableHeader();
       // header.setDefaultRenderer(new PropsTableau());
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

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
        // TODO add your handling code here:
        modifierAgent();
       // listerAgent();

    }//GEN-LAST:event_btn_modifierActionPerformed

    private void comboTypeAgentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboTypeAgentItemStateChanged
        // TODO add your handling code here:
        //afficherContribution();
        // afficherSalaireIndiciaire();

    }//GEN-LAST:event_comboTypeAgentItemStateChanged

    private void btn_rechercheragentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rechercheragentActionPerformed
        // TODO add your handling code here:
        displayOneAgent();
    }//GEN-LAST:event_btn_rechercheragentActionPerformed

    private void comboStructureItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStructureItemStateChanged
        // TODO add your handling code here:
       // displayIDProgramme();
    }//GEN-LAST:event_comboStructureItemStateChanged

    private void rechercheMatriculeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheMatriculeKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_rechercheMatriculeKeyTyped

    private void rechercheMatriculeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rechercheMatriculeKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            displayOneAgent();
        }
    }//GEN-LAST:event_rechercheMatriculeKeyReleased

    private void btn_modifier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifier1ActionPerformed
        // TODO add your handling code here:
        imprimerAgent();
    }//GEN-LAST:event_btn_modifier1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JFormattedTextField boxDateNaissAg;
    public static javax.swing.JFormattedTextField boxDatePriseServiceAg;
    public static javax.swing.JTextField boxEchelon;
    public static javax.swing.JTextField boxIDAgent;
    public static javax.swing.JTextField boxMatriculeAg;
    public static javax.swing.JTextField boxNomAg;
    public static javax.swing.JTextField boxPrenomAg;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JButton btn_modifier1;
    private javax.swing.JButton btn_nouveau;
    private javax.swing.JButton btn_rechercheragent;
    public static javax.swing.JTextField coefficientStruc;
    public static javax.swing.JComboBox<String> comboCatAgent;
    public static javax.swing.JComboBox<String> comboEmploiAgent;
    public static javax.swing.JComboBox<String> comboFonction;
    public static javax.swing.JComboBox<String> comboMinistere;
    public static javax.swing.JComboBox<String> comboSexeAg;
    public static javax.swing.JComboBox<String> comboStructure;
    public static javax.swing.JComboBox<String> comboTypeAgent;
    public static javax.swing.JTextField idProg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JPanel panneauForms;
    public static javax.swing.JPanel panneauPrincipal;
    public static javax.swing.JTextField rechercheMatricule;
    // End of variables declaration//GEN-END:variables
}
