/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mae.vue;

import com.mae.controller.StatAgentProgrammeController;
import com.mae.controller.StatAgentExportPDFByProgrammeController;
import com.mae.props.PropsTableau;
import java.awt.event.KeyEvent;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author kobie
 */
public class InterfaceStatistiqueAgentProgramme extends javax.swing.JInternalFrame {

    /**
     *
     */
    public InterfaceStatistiqueAgentProgramme() {
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
        StatAgentProgrammeController.listAllAgent(); // Executer la méthode d'affichage des données  
    }

    //afficher un agent
    public static void displayOneAgent() {
        StatAgentProgrammeController.rechercheAgentByMatriculeEtprogramme();
    }

    //exportExcel   
    public static void exporterExcel() {
        StatAgentProgrammeController.exportExcel();
    }

    //exportPDF
    public static void exporterPDF() {
        StatAgentExportPDFByProgrammeController.exportPDF();
    }

    //afficher les catégories dans le combobox
    public static void afficherCategorieCombo() {
        StatAgentProgrammeController.listCategorieInCombo();
    }

    //afficher les structure dans le combobox
    public static void afficherStructureCombo() {
        StatAgentProgrammeController.listStructureInCombo();
    }
   
     //afficher les programme dans le combobox
    public static void afficherProgrammeCombo() {
        StatAgentProgrammeController.listProgrammeInCombo();
    }

    //afficher les emploi dans le combobox
    public static void afficherEmploiCombo() {
        StatAgentProgrammeController.listEmploiInCombo();
    }

    //lister les agents par sexe et par programme
    public static void listerAgentBySexe() {
        StatAgentProgrammeController.rechercheAgentBySexeEtProgramme();
    }

    //lister les agents par categorie
    public static void listerAgentByCategorie() {
        StatAgentProgrammeController.rechercheAgentByCategorieEtProgramme();
    }
    
     //lister les agents par structure
    //public static void listerAgentByStructure() {
    //    StatAgentProgrammeController.rechercheAgentByStructure();
   // }
    
     //lister les agents par type d'agent
    public static void listerAgentByTypeAgent() {
        StatAgentProgrammeController.rechercheAgentByTypeAgent();
    }
    
     //lister les agents par emploi
    public static void listerAgentByEmploi() {
        StatAgentProgrammeController.rechercheAgentByEmploi();
    }
    
    //lister les agents par emploi
    public static void listerAgentByProgramme() {
        StatAgentProgrammeController.rechercheAgentByProgramme();
    }
   
    
    
    
    
    
    
    

        //Fonction pour l'enregistrement d'un agent********************************************************************************************************************
    /*

    //Lister toutes les agents********************************************************************************************************************
    public static void listerAgent() {
        StatAgentProgrammeController.listAll(); // Executer la méthode d'affichage des données  
    }

    

    //afficher les informations d'un agents dans les champs
    public static void displayOneAgenntToUpdateOrDelete() {
        StatAgentProgrammeController.displayAgentInBox();

    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 661********************************************************************************************************************
    public static void afficherListeLigne661IdProgramme() {
        StatAgentProgrammeController.afficherIdProgrammeListeSelectLigne661(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 663********************************************************************************************************************
    public static void afficherListeLigne663IdProgramme() {
        StatAgentProgrammeController.afficherIdProgrammeListeSelectLigne663(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 664********************************************************************************************************************
    public static void afficherListeLigne664IdProgramme() {
        StatAgentProgrammeController.afficherIdProgrammeListeSelectLigne664(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 666********************************************************************************************************************
    public static void afficherListeLigne666IdProgramme() {
        StatAgentProgrammeController.afficherIdProgrammeListeSelectLigne666(); // Executer la méthode d'affichage des données  
    }

    //Afficher lel'id du programme de la structure dans le tableau de la liste des lignes 669********************************************************************************************************************
    public static void afficherListeLigne669IdProgramme() {
        StatAgentProgrammeController.afficherIdProgrammeListeSelectLigne669(); // Executer la méthode d'affichage des données  
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
        tableau_agentprogramme = new javax.swing.JTable();
        btn_rechercheragent1 = new javax.swing.JButton();
        btn_rechercheragent2 = new javax.swing.JButton();
        btn_rafraichir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        statNombreEnreg = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        combo_programme = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Statistiques des les agents basés sur le programme");
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
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paramètre 2", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(btn_rechercheragent, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 25, 170, -1));

        box_rechercheMatricule.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        box_rechercheMatricule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                box_rechercheMatriculeKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                box_rechercheMatriculeKeyTyped(evt);
            }
        });
        jPanel1.add(box_rechercheMatricule, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 26, 182, 26));

        combo_Sexe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Sexe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Homme", "Femme" }));
        combo_Sexe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_SexeItemStateChanged(evt);
            }
        });
        jPanel1.add(combo_Sexe, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 64, 182, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Par matricule :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Par sexe :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 67, -1, -1));

        combo_Categorie.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Categorie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        combo_Categorie.setToolTipText("");
        combo_Categorie.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_CategorieItemStateChanged(evt);
            }
        });
        jPanel1.add(combo_Categorie, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 64, 56, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Par Catégorie : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 67, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Par structure : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 30, -1, -1));

        combo_Structure.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Structure.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        combo_Structure.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_StructureItemStateChanged(evt);
            }
        });
        jPanel1.add(combo_Structure, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 27, 221, -1));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Par type d'agents :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(913, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Par emplois : ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(552, 67, -1, -1));

        combo_TypeAgent.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_TypeAgent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Fonctionnaire", "Contractuel", "Militaire" }));
        combo_TypeAgent.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_TypeAgentItemStateChanged(evt);
            }
        });
        jPanel1.add(combo_TypeAgent, new org.netbeans.lib.awtextra.AbsoluteConstraints(1048, 27, 221, -1));

        combo_Emploi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_Emploi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        combo_Emploi.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_EmploiItemStateChanged(evt);
            }
        });
        jPanel1.add(combo_Emploi, new org.netbeans.lib.awtextra.AbsoluteConstraints(677, 64, 221, -1));

        tableau_agentprogramme.setAutoCreateRowSorter(true);
        tableau_agentprogramme.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tableau_agentprogramme.setModel(new javax.swing.table.DefaultTableModel(
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
        tableau_agentprogramme.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableau_agentprogramme.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableau_agentprogramme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableau_agentprogrammeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableau_agentprogramme);
        if (tableau_agentprogramme.getColumnModel().getColumnCount() > 0) {
            tableau_agentprogramme.getColumnModel().getColumn(0).setMinWidth(0);
            tableau_agentprogramme.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableau_agentprogramme.getColumnModel().getColumn(0).setMaxWidth(0);
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

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Total Agents trouvés : ");

        statNombreEnreg.setBackground(new java.awt.Color(0, 0, 204));
        statNombreEnreg.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        statNombreEnreg.setForeground(new java.awt.Color(255, 255, 255));
        statNombreEnreg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statNombreEnreg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Paramètre 1", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        combo_programme.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        combo_programme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        combo_programme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_programmeItemStateChanged(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Programme");

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Rechercher");
        jButton1.setToolTipText("Rechercher");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(37, 37, 37)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(combo_programme, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(861, 861, 861))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(combo_programme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        javax.swing.GroupLayout panneauPrincipalLayout = new javax.swing.GroupLayout(panneauPrincipal);
        panneauPrincipal.setLayout(panneauPrincipalLayout);
        panneauPrincipalLayout.setHorizontalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1274, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jScrollPane1)
                    .addGroup(panneauPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statNombreEnreg, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_rechercheragent1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_rechercheragent2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))))
        );
        panneauPrincipalLayout.setVerticalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(statNombreEnreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_rechercheragent1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_rechercheragent2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
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

        setBounds(0, 0, 1631, 798);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        afficherCategorieCombo();
        afficherStructureCombo();
        afficherEmploiCombo();
        afficherProgrammeCombo();
        
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
        JTableHeader header = tableau_agentprogramme.getTableHeader();
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

    private void tableau_agentprogrammeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableau_agentprogrammeMouseClicked
        // TODO add your handling code here:
      //  displayOneAgenntToUpdateOrDelete();

    }//GEN-LAST:event_tableau_agentprogrammeMouseClicked

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
      //  listerAgentByStructure();
    }//GEN-LAST:event_combo_StructureItemStateChanged

    private void combo_TypeAgentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_TypeAgentItemStateChanged
        // TODO add your handling code here:
        listerAgentByTypeAgent();
    }//GEN-LAST:event_combo_TypeAgentItemStateChanged

    private void combo_EmploiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_EmploiItemStateChanged
        // TODO add your handling code here:
         listerAgentByEmploi();
    }//GEN-LAST:event_combo_EmploiItemStateChanged

    private void combo_programmeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_programmeItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_programmeItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        listerAgentByProgramme();
    }//GEN-LAST:event_jButton1ActionPerformed


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
    public static javax.swing.JComboBox<String> combo_programme;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JPanel panneauPrincipal;
    public static javax.swing.JTextField statNombreEnreg;
    public static javax.swing.JTable tableau_agentprogramme;
    // End of variables declaration//GEN-END:variables
}
