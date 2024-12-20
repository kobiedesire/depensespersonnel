/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mae.vue;

import com.mae.controller.StatAgentController;
import com.mae.controller.StatExportPDFController;
import com.mae.props.PropsTableau;
import java.awt.event.KeyEvent;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author kobie
 */
public class InterfaceStatistiqueAgent extends javax.swing.JInternalFrame {

    /**
     *
     */
    public InterfaceStatistiqueAgent() {
        initComponents();
       /* AutoCompleteDecorator.decorate(comboStructure);
        AutoCompleteDecorator.decorate(comboFonction);
        AutoCompleteDecorator.decorate(comboTypeAgent);
        AutoCompleteDecorator.decorate(comboCatAgent);
        AutoCompleteDecorator.decorate(comboEmploiAgent);
        AutoCompleteDecorator.decorate(comboMinistere);
        AutoCompleteDecorator.decorate(comboSexeAg);*/

    }

   
    
    //Lister toutes les agents********************************************************************************************************************
    public static void listerAgent() {
        StatAgentController.listAllAgent(); // Executer la méthode d'affichage des données  
    }

    //afficher un agent
    public static void displayOneAgent() {
        StatAgentController.rechercheAgentByMatricule();
    }

    //exportExcel   
    public static void exporterExcel() {
        StatAgentController.exportExcel();
    }

    //exportPDF
    public static void exporterPDF() {
        StatExportPDFController.exportPDF();
    }

    //afficher les catégories dans le combobox
    public static void afficherCategorieCombo() {
        StatAgentController.listCategorieInCombo();
    }

    //afficher les structure dans le combobox
    public static void afficherStructureCombo() {
        StatAgentController.listStructureInCombo();
    }
   

    //afficher les emploi dans le combobox
    public static void afficherEmploiCombo() {
        StatAgentController.listEmploiInCombo();
    }

    //lister les agents par sexe
    public static void listerAgentBySexe() {
        StatAgentController.rechercheAgentBySexe();
    }

    //lister les agents par categorie
    public static void listerAgentByCategorie() {
        StatAgentController.rechercheAgentByCategorie();
    }
    
     //lister les agents par structure
    public static void listerAgentByStructure() {
        StatAgentController.rechercheAgentByStructure();
    }
    
     //lister les agents par type d'agent
    public static void listerAgentByTypeAgent() {
        StatAgentController.rechercheAgentByTypeAgent();
    }
    
     //lister les agents par emploi
    public static void listerAgentByEmploi() {
        StatAgentController.rechercheAgentByEmploi();
    }
    
    
    
    
    
    
    
    
    

        //Fonction pour l'enregistrement d'un agent********************************************************************************************************************
    /*

    //Lister toutes les agents********************************************************************************************************************
    public static void listerAgent() {
        StatAgentController.listAll(); // Executer la méthode d'affichage des données  
    }

    

    //afficher les informations d'un agents dans les champs
    public static void displayOneAgenntToUpdateOrDelete() {
        StatAgentController.displayAgentInBox();

    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 661********************************************************************************************************************
    public static void afficherListeLigne661IdProgramme() {
        StatAgentController.afficherIdProgrammeListeSelectLigne661(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 663********************************************************************************************************************
    public static void afficherListeLigne663IdProgramme() {
        StatAgentController.afficherIdProgrammeListeSelectLigne663(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 664********************************************************************************************************************
    public static void afficherListeLigne664IdProgramme() {
        StatAgentController.afficherIdProgrammeListeSelectLigne664(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 666********************************************************************************************************************
    public static void afficherListeLigne666IdProgramme() {
        StatAgentController.afficherIdProgrammeListeSelectLigne666(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 669********************************************************************************************************************
    public static void afficherListeLigne669IdProgramme() {
        StatAgentController.afficherIdProgrammeListeSelectLigne669(); // Executer la méthode d'affichage des données  
    }

   

   */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneauPrincipal = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btn_rechercheragent = new javax.swing.JButton();
        box_rechercheMatricule = new javax.swing.JTextField();
        combo_Sexe = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        combo_Categorie = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        combo_Structure = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        combo_TypeAgent = new javax.swing.JComboBox<>();
        combo_Emploi = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau_agent = new javax.swing.JTable();
        btn_rechercheragent1 = new javax.swing.JButton();
        btn_rechercheragent2 = new javax.swing.JButton();
        btn_rafraichir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Statistiques des agents");
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Critères de recherche", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

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

        box_rechercheMatricule.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        box_rechercheMatricule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                box_rechercheMatriculeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                box_rechercheMatriculeKeyTyped(evt);
            }
        });

        combo_Sexe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Homme", "Femme" }));
        combo_Sexe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_SexeItemStateChanged(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Par matricule :");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Par sexe :");

        combo_Categorie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Categorie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        combo_Categorie.setToolTipText("");
        combo_Categorie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_CategorieItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Par Catégorie : ");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Par structure : ");

        combo_Structure.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Structure.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        combo_Structure.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_StructureItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Par type d'agents :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Par emplois : ");

        combo_TypeAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_TypeAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Fonctionnaire", "Contractuel" }));
        combo_TypeAgent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_TypeAgentItemStateChanged(evt);
            }
        });

        combo_Emploi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Emploi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        combo_Emploi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_EmploiItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(combo_Sexe, 0, 182, Short.MAX_VALUE)
                    .addComponent(box_rechercheMatricule))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_rechercheragent, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combo_Categorie, 0, 1, Short.MAX_VALUE)))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(21, 21, 21)
                        .addComponent(combo_Structure, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combo_Emploi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(15, 15, 15)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_TypeAgent, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(353, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {combo_Emploi, combo_Structure, combo_TypeAgent});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(box_rechercheMatricule, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rechercheragent)
                    .addComponent(jLabel4)
                    .addComponent(combo_Structure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(combo_TypeAgent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(combo_Sexe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(combo_Categorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(combo_Emploi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {combo_Emploi, combo_Structure, combo_TypeAgent});

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

        btn_rechercheragent1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_rechercheragent1.setForeground(new java.awt.Color(255, 0, 0));
        btn_rechercheragent1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/export_pdf.png"))); // NOI18N
        btn_rechercheragent1.setText("Exporter en PDF");
        btn_rechercheragent1.setToolTipText("Exporter en PDF");
        btn_rechercheragent1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        btn_rechercheragent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rechercheragent1ActionPerformed(evt);
            }
        });

        btn_rechercheragent2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_rechercheragent2.setForeground(new java.awt.Color(0, 102, 51));
        btn_rechercheragent2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/export_exel.png"))); // NOI18N
        btn_rechercheragent2.setText("Exporter en EXCEL");
        btn_rechercheragent2.setToolTipText("Exporter en EXCEL");
        btn_rechercheragent2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_rechercheragent2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rechercheragent2ActionPerformed(evt);
            }
        });

        btn_rafraichir.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_rafraichir.setForeground(new java.awt.Color(51, 153, 255));
        btn_rafraichir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn_actualiser.png"))); // NOI18N
        btn_rafraichir.setText("Rafraîchir la liste");
        btn_rafraichir.setToolTipText("Rafraîchir la liste");
        btn_rafraichir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 153, 255), 1, true));
        btn_rafraichir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rafraichirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panneauPrincipalLayout = new javax.swing.GroupLayout(panneauPrincipal);
        panneauPrincipal.setLayout(panneauPrincipalLayout);
        panneauPrincipalLayout.setHorizontalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1))
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rechercheragent1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_rechercheragent2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panneauPrincipalLayout.setVerticalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_rechercheragent1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rechercheragent2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 1631, 787);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        afficherCategorieCombo();
        afficherStructureCombo();
        afficherEmploiCombo();
        
        /**coefficientStruc.setVisible(false);
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
        InterfaceStatistiqueAgent.ligne661.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceStatistiqueAgent.ligne663.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceStatistiqueAgent.ligne664.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceStatistiqueAgent.ligne666.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });
        InterfaceStatistiqueAgent.ligne669.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                InterfaceStatistiqueAgent.afficherIncidenceMensuelleAnnuelle();
            }
        });*/

        //ajout d'un placeholder sur le champs matricule pour la recherche
        box_rechercheMatricule.setText("Saisir le numéro matricule...");
        box_rechercheMatricule.setForeground(Color.GRAY);
        box_rechercheMatricule.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (box_rechercheMatricule.getText().equals("Saisir le numéro matricule...")) {
                    box_rechercheMatricule.setText("");
                    box_rechercheMatricule.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (box_rechercheMatricule.getText().isEmpty()) {
                    box_rechercheMatricule.setText("Saisir le numéro matricule...");
                    box_rechercheMatricule.setForeground(Color.GRAY);
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
      //  displayOneAgenntToUpdateOrDelete();

    }//GEN-LAST:event_tableau_agentMouseClicked

    private void box_rechercheMatriculeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_box_rechercheMatriculeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_box_rechercheMatriculeKeyTyped

    private void box_rechercheMatriculeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_box_rechercheMatriculeKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            displayOneAgent();
        }
    }//GEN-LAST:event_box_rechercheMatriculeKeyReleased

    private void btn_rechercheragentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rechercheragentActionPerformed
        // TODO add your handling code here:
        displayOneAgent();
    }//GEN-LAST:event_btn_rechercheragentActionPerformed

    private void btn_rafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rafraichirActionPerformed
        // TODO add your handling code here:
        listerAgent();
    }//GEN-LAST:event_btn_rafraichirActionPerformed

    private void btn_rechercheragent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rechercheragent1ActionPerformed
        // TODO add your handling code here:
        exporterPDF();
    }//GEN-LAST:event_btn_rechercheragent1ActionPerformed

    private void btn_rechercheragent2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rechercheragent2ActionPerformed
        // TODO add your handling code here:
        exporterExcel();
    }//GEN-LAST:event_btn_rechercheragent2ActionPerformed

    private void combo_SexeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_SexeItemStateChanged
        // TODO add your handling code here:
        listerAgentBySexe();
    }//GEN-LAST:event_combo_SexeItemStateChanged

    private void combo_CategorieItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_CategorieItemStateChanged
        // TODO add your handling code here:
        listerAgentByCategorie();
    }//GEN-LAST:event_combo_CategorieItemStateChanged

    private void combo_StructureItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_StructureItemStateChanged
        // TODO add your handling code here:
        listerAgentByStructure();
    }//GEN-LAST:event_combo_StructureItemStateChanged

    private void combo_TypeAgentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_TypeAgentItemStateChanged
        // TODO add your handling code here:
        listerAgentByTypeAgent();
    }//GEN-LAST:event_combo_TypeAgentItemStateChanged

    private void combo_EmploiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_EmploiItemStateChanged
        // TODO add your handling code here:
         listerAgentByEmploi();
    }//GEN-LAST:event_combo_EmploiItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField box_rechercheMatricule;
    private javax.swing.JButton btn_rafraichir;
    private javax.swing.JButton btn_rechercheragent;
    private javax.swing.JButton btn_rechercheragent1;
    private javax.swing.JButton btn_rechercheragent2;
    public static javax.swing.JComboBox<String> combo_Categorie;
    public static javax.swing.JComboBox<String> combo_Emploi;
    public static javax.swing.JComboBox<String> combo_Sexe;
    public static javax.swing.JComboBox<String> combo_Structure;
    public static javax.swing.JComboBox<String> combo_TypeAgent;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JPanel panneauPrincipal;
    public static javax.swing.JTable tableau_agent;
    // End of variables declaration//GEN-END:variables
}
