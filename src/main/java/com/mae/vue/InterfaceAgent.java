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
                || boxEchelon.getText().isBlank() || boxIndeminiteLogement.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Vérifiez les champs obligatoires...");
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

            Agent agent = new Agent(aMatricule, aNom, aPrenom, aDateNaiss, aSexe, aDatePriseService, aTypeAgent, aStructure, aMinistereOrigine, aFonction, aEmploi, aCategorieEchelle, aEchelon, aIndice, aSalIncidiciaire, aIResidence, aIAstreinte, aITechnicite, aIResponsabilite, aIVestimentaire, aILogement, aISpecifique, aAutresI, aChargeMilitaire, aCARFO, aCNSS, aAllFamil, aLigne661, aLigne663, aLigne664, aLigne666, aLigne669, aIncidenceMensuelle, aIncidenceAnnuelle);
            AgentController.saveAgent(agent);  // Enregistrez  dans la base de données            
            reinitChamps();
        }

    }

    //Lister toutes les agents********************************************************************************************************************
    public static void listerAgent() {
        AgentController.listAll(); // Executer la méthode d'affichage des données  
    }
     //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes********************************************************************************************************************
    public static void afficherListeLigneIdProgramme() {
        AgentController.afficherIdProgrammeListeSelectLigne(); // Executer la méthode d'affichage des données  
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
        jLabel25 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        boxIncidenceMensuelle = new javax.swing.JFormattedTextField();
        boxIncidenceAnnuelle = new javax.swing.JFormattedTextField();
        boxDatePriseServiceAg = new javax.swing.JFormattedTextField();
        boxDateNaissAg = new javax.swing.JFormattedTextField();
        idProg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau_agent = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_nouveau = new javax.swing.JButton();
        btn_enregistrer = new javax.swing.JButton();
        btn_modifier = new javax.swing.JButton();
        btn_supprimer = new javax.swing.JButton();
        btn_rafraichir = new javax.swing.JButton();
        btn_rechercheragent = new javax.swing.JButton();
        rechercheMatricule = new javax.swing.JTextField();
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
        boxIndeminiteLogement = new javax.swing.JTextField();
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
        btn_ligne663 = new javax.swing.JButton();
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

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestion des agents");
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

        panneauForms.setBackground(new java.awt.Color(255, 255, 255));
        panneauForms.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations administratives de l'agent", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        panneauForms.setPreferredSize(new java.awt.Dimension(1600, 396));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Structure :");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Type d'agent : ");

        comboStructure.setEditable(true);
        comboStructure.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboStructure.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));
        comboStructure.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboStructureItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Matricule :");

        boxMatriculeAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Nom :");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Prénom (s) : ");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Sexe : ");

        boxNomAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        boxPrenomAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        comboSexeAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboSexeAg.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Homme", "Femme" }));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Date de naissance : ");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Date.Prise de service : ");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Fonction : ");

        comboFonction.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboFonction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        comboTypeAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboTypeAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Fonctionnaire", "Contractuel" }));
        comboTypeAgent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboTypeAgentItemStateChanged(evt);
            }
        });

        jLabel32.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel32.setText("Ministère d'origine");

        comboMinistere.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboMinistere.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel24.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel24.setText("Emploi :");

        comboEmploiAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboEmploiAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", " " }));

        jLabel25.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel25.setText("Inncidence mensuelle : ");

        jLabel34.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel34.setText("Incidence annuelle : ");

        boxIncidenceMensuelle.setBackground(new java.awt.Color(0, 102, 51));
        boxIncidenceMensuelle.setForeground(new java.awt.Color(255, 255, 255));
        boxIncidenceMensuelle.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIncidenceMensuelle.setEnabled(false);
        boxIncidenceMensuelle.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

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

        boxDatePriseServiceAg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        boxDatePriseServiceAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        boxDateNaissAg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        boxDateNaissAg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout panneauFormsLayout = new javax.swing.GroupLayout(panneauForms);
        panneauForms.setLayout(panneauFormsLayout);
        panneauFormsLayout.setHorizontalGroup(
            panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauFormsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(107, 107, 107)
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxNomAg)
                            .addComponent(boxMatriculeAg)))
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(42, 42, 42)
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxPrenomAg)
                            .addComponent(comboSexeAg, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxDateNaissAg)))
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel2)
                            .addComponent(jLabel32)
                            .addComponent(jLabel1)
                            .addComponent(jLabel13)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel34))
                        .addGap(25, 25, 25)
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboMinistere, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboStructure, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboTypeAgent, javax.swing.GroupLayout.Alignment.TRAILING, 0, 491, Short.MAX_VALUE)
                            .addComponent(comboFonction, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboEmploiAgent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxIncidenceMensuelle)
                            .addComponent(boxIncidenceAnnuelle)
                            .addComponent(boxDatePriseServiceAg)))
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addComponent(idProg, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panneauFormsLayout.setVerticalGroup(
            panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauFormsLayout.createSequentialGroup()
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(boxMatriculeAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxNomAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addGap(12, 12, 12)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxPrenomAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(boxDateNaissAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(comboSexeAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(boxDatePriseServiceAg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboTypeAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboStructure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(comboMinistere, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(comboFonction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(comboEmploiAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(boxIncidenceMensuelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(boxIncidenceAnnuelle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(idProg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panneauFormsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {boxDateNaissAg, boxDatePriseServiceAg, boxMatriculeAg, boxNomAg, boxPrenomAg, comboSexeAg});

        tableau_agent.setAutoCreateRowSorter(true);
        tableau_agent.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tableau_agent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Agent", "Matricule", "Nom", "Prénom", "Structure"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        btn_nouveau.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_nouveau.setForeground(new java.awt.Color(0, 102, 51));
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
        btn_modifier.setText("Modifier");
        btn_modifier.setToolTipText("Modifier");
        btn_modifier.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifierActionPerformed(evt);
            }
        });

        btn_supprimer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_supprimer.setForeground(new java.awt.Color(0, 102, 51));
        btn_supprimer.setText("Supprimer");
        btn_supprimer.setToolTipText("Supprimer");
        btn_supprimer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supprimerActionPerformed(evt);
            }
        });

        btn_rafraichir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_rafraichir.setForeground(new java.awt.Color(0, 102, 51));
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
        btn_rechercheragent.setText("Rechercher un agent");
        btn_rechercheragent.setToolTipText("Rechercher un agent");
        btn_rechercheragent.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_rechercheragent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rechercheragentActionPerformed(evt);
            }
        });

        rechercheMatricule.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_enregistrer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_supprimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rechercheragent, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rechercheMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_enregistrer, btn_modifier, btn_nouveau, btn_rafraichir, btn_supprimer});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(rechercheMatricule, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_nouveau)
                        .addComponent(btn_enregistrer)
                        .addComponent(btn_modifier)
                        .addComponent(btn_supprimer)
                        .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_rechercheragent, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_enregistrer, btn_modifier, btn_nouveau, btn_rafraichir, btn_supprimer});

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Elements de salaire", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel23.setText("Ind.Respons. :");

        jLabel21.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel21.setText("Ind.Technicité : ");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Catégorie/Echelle : ");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Indice Sal. : ");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel19.setText("Ind.Résidence. : ");

        jLabel20.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel20.setText("Ind.Astreintes :");

        comboCatAgent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboCatAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

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

        boxIndResidence.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndResidence.setEnabled(false);
        boxIndResidence.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        boxIndResidence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndResidenceKeyReleased(evt);
            }
        });

        boxIndeminiteAstreinte.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteAstreinte.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndeminiteAstreinte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteAstreinteKeyReleased(evt);
            }
        });

        boxIndeminiteTechnicite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteTechnicite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndeminiteTechnicite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteTechniciteKeyReleased(evt);
            }
        });

        boxIndeminiteResponsabilite.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteResponsabilite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndeminiteResponsabilite.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteResponsabiliteKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Echelon : ");

        boxEchelon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel22.setText("Cont.CARFO : ");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel29.setText("Charge Militaire : ");

        jLabel30.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel30.setText("Alloc.Familiales : ");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Ind. Vest : ");

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

        boxChargeMilitaire.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxChargeMilitaire.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxChargeMilitaire.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxChargeMilitaireKeyReleased(evt);
            }
        });

        boxIndeminiteLogement.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndeminiteLogement.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteLogementKeyReleased(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel26.setText("Ind.Logement :");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Salaire indiciaire : ");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel27.setText("Ind.Spécifique : ");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel28.setText("Autres Ind. : ");

        boxSalaireIndicMensuel.setBackground(new java.awt.Color(204, 0, 0));
        boxSalaireIndicMensuel.setForeground(new java.awt.Color(255, 255, 255));
        boxSalaireIndicMensuel.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxSalaireIndicMensuel.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        boxSalaireIndicMensuel.setEnabled(false);
        boxSalaireIndicMensuel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Récapitulatif des lignes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Traitements et salaires en espèces (Ligne 661) :");

        jLabel31.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel31.setText("Autres dépenses de personnel (Ligne 669) : ");

        jLabel18.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel18.setText("Prestations sociales  (Ligne 666) : ");

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Cotisations sociales (Ligne 664) : ");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText("Primes et indemnités (Ligne 663) : ");

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

        ligne663.setBackground(new java.awt.Color(204, 0, 0));
        ligne663.setForeground(new java.awt.Color(255, 255, 255));
        ligne663.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ligne663.setEnabled(false);
        ligne663.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        ligne664.setBackground(new java.awt.Color(204, 0, 0));
        ligne664.setForeground(new java.awt.Color(255, 255, 255));
        ligne664.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ligne664.setEnabled(false);
        ligne664.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        ligne666.setBackground(new java.awt.Color(204, 0, 0));
        ligne666.setForeground(new java.awt.Color(255, 255, 255));
        ligne666.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ligne666.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        ligne669.setBackground(new java.awt.Color(204, 0, 0));
        ligne669.setForeground(new java.awt.Color(255, 255, 255));
        ligne669.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ligne669.setEnabled(false);
        ligne669.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        btn_SelectLigne661.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_SelectLigne661.setForeground(new java.awt.Color(204, 0, 0));
        btn_SelectLigne661.setText("Sélectionnez une ligne 661");
        btn_SelectLigne661.setToolTipText("Sélectionnez une ligne");
        btn_SelectLigne661.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectLigne661ActionPerformed(evt);
            }
        });

        btn_SelectLigne663.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_SelectLigne663.setForeground(new java.awt.Color(204, 0, 0));
        btn_SelectLigne663.setText("Sélectionnez une ligne 663");
        btn_SelectLigne663.setToolTipText("Sélectionnez une ligne 661");
        btn_SelectLigne663.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectLigne663ActionPerformed(evt);
            }
        });

        btn_ligne663.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_ligne663.setForeground(new java.awt.Color(204, 0, 0));
        btn_ligne663.setText("Sélectionnez une ligne 664");
        btn_ligne663.setToolTipText("Sélectionnez une ligne 664");
        btn_ligne663.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ligne663ActionPerformed(evt);
            }
        });

        btn_SelectLigne666.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_SelectLigne666.setForeground(new java.awt.Color(204, 0, 0));
        btn_SelectLigne666.setText("Sélectionnez une ligne 666");
        btn_SelectLigne666.setToolTipText("Sélectionnez une ligne 666");
        btn_SelectLigne666.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectLigne666ActionPerformed(evt);
            }
        });

        btn_SelectLigne669.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_SelectLigne669.setForeground(new java.awt.Color(204, 0, 0));
        btn_SelectLigne669.setText("Sélectionnez une ligne 669");
        btn_SelectLigne669.setToolTipText("Sélectionnez une ligne 669");
        btn_SelectLigne669.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SelectLigne669ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel17))
                    .addComponent(jLabel18)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_SelectLigne669)
                    .addComponent(btn_SelectLigne666)
                    .addComponent(btn_ligne663)
                    .addComponent(btn_SelectLigne663)
                    .addComponent(btn_SelectLigne661))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ligne664, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ligne663, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ligne661, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ligne666, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ligne669, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idLigne664, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(idLigne661, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idLigne666, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(idLigne663, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(idLigne669, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {idLigne661, idLigne663, idLigne664, idLigne666, idLigne669});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(ligne661, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_SelectLigne661, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idLigne661, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(ligne663, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_SelectLigne663)
                    .addComponent(idLigne663, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(ligne664, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ligne663)
                    .addComponent(idLigne664, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(ligne666, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_SelectLigne666)
                    .addComponent(idLigne666, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(ligne669, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_SelectLigne669)
                    .addComponent(idLigne669, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {idLigne661, idLigne663, idLigne664, idLigne666, idLigne669});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_SelectLigne661, btn_SelectLigne663, btn_SelectLigne666, btn_SelectLigne669, btn_ligne663});

        boxContributionCARFO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxContributionCARFO.setEnabled(false);
        boxContributionCARFO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        boxContributionCNSS.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxContributionCNSS.setEnabled(false);
        boxContributionCNSS.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        boxIndeminiteVestimentaire.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteVestimentaire.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boxIndeminiteVestimentaire.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteVestimentaireKeyReleased(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel33.setText("Cont.CNSS :");

        boxAllocationFamiliale.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxAllocationFamiliale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        boxAllocationFamiliale.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxAllocationFamilialeKeyReleased(evt);
            }
        });

        boxIndeminiteSpecifique.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        boxIndeminiteSpecifique.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        boxIndeminiteSpecifique.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                boxIndeminiteSpecifiqueKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel11)
                            .addComponent(jLabel23)
                            .addComponent(jLabel21)
                            .addComponent(jLabel20)
                            .addComponent(jLabel19)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                    .addComponent(boxAutreIndeminite, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxIndeminiteVestimentaire, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxIndeminiteResponsabilite, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxIndeminiteTechnicite, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxIndeminiteAstreinte, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxIndResidence, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(boxIndiceSal)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboCatAgent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(jLabel22)
                            .addComponent(jLabel29)
                            .addComponent(jLabel10)
                            .addComponent(jLabel33)
                            .addComponent(jLabel14)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                        .addComponent(boxContributionCNSS, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(boxContributionCARFO, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(boxChargeMilitaire, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(boxIndeminiteLogement, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(boxSalaireIndicMensuel, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(boxEchelon, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(boxAllocationFamiliale, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(boxIndeminiteSpecifique, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {boxAutreIndeminite, boxIndResidence, boxIndeminiteAstreinte, boxIndeminiteResponsabilite, boxIndeminiteTechnicite, boxIndeminiteVestimentaire, boxIndiceSal, comboCatAgent});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {boxAllocationFamiliale, boxChargeMilitaire, boxContributionCARFO, boxContributionCNSS, boxEchelon, boxIndeminiteLogement, boxIndeminiteSpecifique, boxSalaireIndicMensuel});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxIndResidence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(boxIndeminiteAstreinte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxIndeminiteTechnicite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(boxIndeminiteResponsabilite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(3, 3, 3))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(boxIndeminiteVestimentaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel33))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxEchelon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(comboCatAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxSalaireIndicMensuel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14)
                            .addComponent(boxIndiceSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(boxIndeminiteLogement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(boxIndeminiteSpecifique, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxChargeMilitaire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxContributionCARFO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boxContributionCNSS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(boxAutreIndeminite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30)
                    .addComponent(boxAllocationFamiliale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {boxAutreIndeminite, boxIndResidence, boxIndeminiteAstreinte, boxIndeminiteResponsabilite, boxIndeminiteTechnicite, boxIndeminiteVestimentaire, boxIndiceSal});

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {boxAllocationFamiliale, boxChargeMilitaire, boxContributionCARFO, boxContributionCNSS, boxEchelon, boxIndeminiteLogement, boxIndeminiteSpecifique, boxSalaireIndicMensuel});

        javax.swing.GroupLayout panneauPrincipalLayout = new javax.swing.GroupLayout(panneauPrincipal);
        panneauPrincipal.setLayout(panneauPrincipalLayout);
        panneauPrincipalLayout.setHorizontalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauPrincipalLayout.createSequentialGroup()
                        .addComponent(panneauForms, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panneauPrincipalLayout.setVerticalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panneauForms, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1563, 750);
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
        //listerStructure();
    }//GEN-LAST:event_btn_rafraichirActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        idProg.setVisible(false);
        //idLigne661.setVisible(false);
        //idLigne663.setVisible(false);
        //idLigne664.setVisible(false);
       // idLigne666.setVisible(false);
        //idLigne669.setVisible(false);
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

    }//GEN-LAST:event_formInternalFrameOpened

    private void tableau_agentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableau_agentMouseClicked
        // TODO add your handling code here:
        // afficherStructure();
    }//GEN-LAST:event_tableau_agentMouseClicked

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
        // TODO add your handling code here:
        /*modifierStructure();
        listerStructure();*/
    }//GEN-LAST:event_btn_modifierActionPerformed

    private void btn_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supprimerActionPerformed
        // TODO add your handling code here:
        /*supprimerStructure();
        listerStructure();*/
    }//GEN-LAST:event_btn_supprimerActionPerformed

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

    private void boxIndeminiteLogementKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_boxIndeminiteLogementKeyReleased
        // TODO add your handling code here:
        afficherSommeIndeminite663();
    }//GEN-LAST:event_boxIndeminiteLogementKeyReleased

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
    }//GEN-LAST:event_btn_rechercheragentActionPerformed

    private void btn_SelectLigne661ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectLigne661ActionPerformed
        // TODO add your handling code here:
        afficherListeLigneIdProgramme();
    }//GEN-LAST:event_btn_SelectLigne661ActionPerformed

    private void comboStructureItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboStructureItemStateChanged
        // TODO add your handling code here:
        displayIDProgramme();
    }//GEN-LAST:event_comboStructureItemStateChanged

    private void btn_SelectLigne663ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectLigne663ActionPerformed
        // TODO add your handling code here:
        afficherListeLigneIdProgramme();
    }//GEN-LAST:event_btn_SelectLigne663ActionPerformed

    private void btn_ligne663ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ligne663ActionPerformed
        // TODO add your handling code here:
        afficherListeLigneIdProgramme();
    }//GEN-LAST:event_btn_ligne663ActionPerformed

    private void btn_SelectLigne666ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectLigne666ActionPerformed
        // TODO add your handling code here:
        afficherListeLigneIdProgramme();
    }//GEN-LAST:event_btn_SelectLigne666ActionPerformed

    private void btn_SelectLigne669ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SelectLigne669ActionPerformed
        // TODO add your handling code here:
        afficherListeLigneIdProgramme();
    }//GEN-LAST:event_btn_SelectLigne669ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JFormattedTextField boxAllocationFamiliale;
    public static javax.swing.JFormattedTextField boxAutreIndeminite;
    public static javax.swing.JFormattedTextField boxChargeMilitaire;
    public static javax.swing.JFormattedTextField boxContributionCARFO;
    public static javax.swing.JFormattedTextField boxContributionCNSS;
    public static javax.swing.JFormattedTextField boxDateNaissAg;
    public static javax.swing.JFormattedTextField boxDatePriseServiceAg;
    public static javax.swing.JTextField boxEchelon;
    public static javax.swing.JFormattedTextField boxIncidenceAnnuelle;
    public static javax.swing.JFormattedTextField boxIncidenceMensuelle;
    public static javax.swing.JFormattedTextField boxIndResidence;
    public static javax.swing.JFormattedTextField boxIndeminiteAstreinte;
    public static javax.swing.JTextField boxIndeminiteLogement;
    public static javax.swing.JFormattedTextField boxIndeminiteResponsabilite;
    public static javax.swing.JFormattedTextField boxIndeminiteSpecifique;
    public static javax.swing.JFormattedTextField boxIndeminiteTechnicite;
    public static javax.swing.JFormattedTextField boxIndeminiteVestimentaire;
    public static javax.swing.JTextField boxIndiceSal;
    public static javax.swing.JTextField boxMatriculeAg;
    public static javax.swing.JTextField boxNomAg;
    public static javax.swing.JTextField boxPrenomAg;
    public static javax.swing.JFormattedTextField boxSalaireIndicMensuel;
    private javax.swing.JButton btn_SelectLigne661;
    private javax.swing.JButton btn_SelectLigne663;
    private javax.swing.JButton btn_SelectLigne666;
    private javax.swing.JButton btn_SelectLigne669;
    private javax.swing.JButton btn_enregistrer;
    private javax.swing.JButton btn_ligne663;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JButton btn_nouveau;
    private javax.swing.JButton btn_rafraichir;
    private javax.swing.JButton btn_rechercheragent;
    private javax.swing.JButton btn_supprimer;
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
