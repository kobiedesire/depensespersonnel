/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mae.vue;

import com.mae.controller.LigneController;
import com.mae.model.Ligne;
import com.mae.props.PropsTableau;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author kobie
 */
public class InterfaceLigne extends javax.swing.JInternalFrame {

    /**
     *
     */
    public InterfaceLigne() {
        initComponents();
        AutoCompleteDecorator.decorate(comboProgramme);
        AutoCompleteDecorator.decorate(comboAction);
        AutoCompleteDecorator.decorate(comboArticle);
        AutoCompleteDecorator.decorate(comboActivite);
        AutoCompleteDecorator.decorate(comboParagraphe);
        AutoCompleteDecorator.decorate(comboChapitre);

    }

    //remplissage du combobox des porgrammes
    public static void listerComboProgramme() {
        LigneController.listInComboProgramme();
    }

    //cacher toutes les boites de ID
    public static void boxInvisible() {
        boxIDProgramme.setVisible(false);
        boxIDActivite.setVisible(false);
        boxIDParagraphe.setVisible(false);
        boxIDAction.setVisible(false);
        boxIDArticle.setVisible(false);
        boxIDChapitre.setVisible(false);
        boxIDLigne.setVisible(false);
    }

    /**
     * *************************************************************************************************************************
     */
    //affichage de l'ID du programme séléctionné
    public static void getIDProgramme() {
        LigneController.afficherIDProgramme();
    }

    //remplissage du combobox des actions en fonction du programme sélectionné
    public static void listerComboAction() {
        LigneController.listInComboAction();
    }

    /**
     * *************************************************************************************************************************
     */
    //affichage de l'ID de l'action  séléctionnée
    public static void getIDAction() {
        LigneController.afficherIDAction();
    }

    //remplissage du combobox des chapitres en fonction de l'action sélectionnée
    public static void listerComboChapitre() {
        LigneController.listInComboChapitre();
    }

    /**
     * *************************************************************************************************************************
     */
    //affichage de l'ID du chapitre  séléctionné
    public static void getIDChapitre() {
        LigneController.afficherIDChapitre();
    }

    //remplissage du combobox des activités  en fonction du chapitre sélectionné
    public static void listerComboActivite() {
        LigneController.listInComboActivite();
    }

    /**
     * *************************************************************************************************************************
     */
    //affichage de l'ID de l'acivité  séléctionnés
    public static void getIDActivite() {
        LigneController.afficherIDActivite();
    }

    //remplissage du combobox des article  en fonction des activités sélectionné
    public static void listerComboArticle() {
        LigneController.listInComboArticle();
    }

    /**
     * *************************************************************************************************************************
     */
    //affichage de l'ID du chapitre  séléctionné
    public static void getIDArticle() {
        LigneController.afficherIDArticle();
    }

    //remplissage du combobox des paragraphes en fonction de l'article sélectionné
    public static void listerComboParagraphe() {
        LigneController.listInComboParagraphe();
    }

    /**
     * *************************************************************************************************************************
     */
    //affichage de l'ID du paragraphe séléctionné
    public static void getIDParagraphe() {
        LigneController.afficherIDParagraphe();
    }

    private static int rep;

    // private static String mNom, mDescription;
    //Fonction pour l'enregistrement d'une ligne********************************************************************************************************************
    public static void enregistrerLigne() {
        // Récuperation des donnéses du formulaire
        String lCode = codeLigne.getText().trim();
        long lmontant = 0;

        if (lCode.isBlank() || boxIDProgramme.getText().isBlank() || boxIDAction.getText().isBlank() || boxIDArticle.getText().isBlank() || boxIDActivite.getText().isBlank() || boxIDChapitre.getText().isBlank() || boxIDParagraphe.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Champs obligatoires");
        } else {
            int lProgramme = Integer.parseInt(boxIDProgramme.getText());
            int lChapitre = Integer.parseInt(boxIDChapitre.getText());
            int lAction = Integer.parseInt(boxIDAction.getText());
            int lActivite = Integer.parseInt(boxIDActivite.getText());
            int lArticle = Integer.parseInt(boxIDArticle.getText());
            int lParagraphe = Integer.parseInt(boxIDParagraphe.getText());
            Ligne ligne = new Ligne(lCode, lProgramme, lAction, lChapitre, lActivite, lArticle, lParagraphe, lmontant); // Créez un objet InterfaceStructure     
            LigneController.saveLigne(ligne);  // Enregistrez  dans la base de données            
            codeLigne.setText("");
            boxIDProgramme.setText("");
            boxIDAction.setText("");
            boxIDArticle.setText("");
            boxIDActivite.setText("");
            boxIDChapitre.setText("");
            boxIDParagraphe.setText("");
            montantLigne.setText("");
            comboProgramme.setSelectedIndex(0);
        }

    }

    //Lister toutes les Programme********************************************************************************************************************
    public static void listerLigne() {
        LigneController.listAll(); // Executer la méthode d'affichage des données  
    }

    //Supprimer une structure********************************************************************************************************************
    public static void supprimerLigne() {
        rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cete ligne budgétaire?", "Suppression d'une ligne budgétaire", JOptionPane.YES_NO_OPTION);
        if (rep == JOptionPane.YES_OPTION) {
            Ligne ligne = new Ligne();
            LigneController.deleteLigne(ligne);// Executer la méthode de suppression des données    
            JOptionPane.showMessageDialog(null, "Ligne supprimée");

        }

        /* 
    //Fonction pour afficher ********************************************************************************************************************
    public static void afficherParagraphe() {
        ParagrapheController.displayParagraphe();// Executer la méthode d'affichage des données        
    }

    //Modifier une structure********************************************************************************************************************
    public static void modifierParagraphe() {
        // Récuperation des donnéses du formulaire
        String aCode = codeParagraphe.getText().trim();
        String aLibele = libeleParagraphe.getText().trim();
        if (aCode.isBlank() || idArti.getText().isBlank() || aLibele.isBlank()) {
            JOptionPane.showMessageDialog(null, "Des cahmps sont vides");
        } else {
            int pBudget = Integer.parseInt(idArti.getText());
            rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment modifier ce paragraphe?", "Modification d'un paragraphe", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                Paragraphe paragraphe = new Paragraphe(pBudget, aCode, aLibele);
                ParagrapheController.updateParagraphe(paragraphe); // Executer la méthode de modification dans la base de données
                JOptionPane.showMessageDialog(null, "Modification validée");
                articleBug.setSelectedIndex(0);
                idArti.setText("");
                codeParagraphe.setText("");
                libeleParagraphe.setText("");
            }
        }

    }

   
    }*/}
        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneauPrincipal = new javax.swing.JPanel();
        panneauForms = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        montantLigne = new javax.swing.JTextField();
        comboProgramme = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        codeLigne = new javax.swing.JTextField();
        boxIDLigne = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboChapitre = new javax.swing.JComboBox<>();
        comboAction = new javax.swing.JComboBox<>();
        comboActivite = new javax.swing.JComboBox<>();
        comboArticle = new javax.swing.JComboBox<>();
        comboParagraphe = new javax.swing.JComboBox<>();
        boxIDProgramme = new javax.swing.JTextField();
        boxIDAction = new javax.swing.JTextField();
        boxIDChapitre = new javax.swing.JTextField();
        boxIDActivite = new javax.swing.JTextField();
        boxIDArticle = new javax.swing.JTextField();
        boxIDParagraphe = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau_ligne = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_nouveau = new javax.swing.JButton();
        btn_enregistrer = new javax.swing.JButton();
        btn_modifier = new javax.swing.JButton();
        btn_supprimer = new javax.swing.JButton();
        btn_rafraichir = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestion des lignes budgétaires");
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
        panneauForms.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ensemble d'éléments constitutifs d'une ligne budgétaire", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Programme Budg.");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Montant de la ligne : ");

        montantLigne.setBackground(new java.awt.Color(204, 0, 0));
        montantLigne.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        montantLigne.setForeground(new java.awt.Color(255, 255, 255));
        montantLigne.setEnabled(false);

        comboProgramme.setEditable(true);
        comboProgramme.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboProgramme.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboProgramme.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboProgrammeItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Code Ligne : ");

        codeLigne.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Article : ");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Action : ");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Chapitre : ");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Activité : ");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Paragraphe : ");

        comboChapitre.setEditable(true);
        comboChapitre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboChapitre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboChapitre.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboChapitreItemStateChanged(evt);
            }
        });

        comboAction.setEditable(true);
        comboAction.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboAction.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboAction.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboActionItemStateChanged(evt);
            }
        });

        comboActivite.setEditable(true);
        comboActivite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboActivite.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboActivite.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboActiviteItemStateChanged(evt);
            }
        });

        comboArticle.setEditable(true);
        comboArticle.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboArticle.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboArticle.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboArticleItemStateChanged(evt);
            }
        });

        comboParagraphe.setEditable(true);
        comboParagraphe.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        comboParagraphe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        comboParagraphe.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboParagrapheItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout panneauFormsLayout = new javax.swing.GroupLayout(panneauForms);
        panneauForms.setLayout(panneauFormsLayout);
        panneauFormsLayout.setHorizontalGroup(
            panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauFormsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codeLigne))
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(5, 5, 5)
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboChapitre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(comboAction, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(comboProgramme, javax.swing.GroupLayout.Alignment.LEADING, 0, 580, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(boxIDChapitre, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(boxIDProgramme, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boxIDAction, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauFormsLayout.createSequentialGroup()
                                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboActivite, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboArticle, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauFormsLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboParagraphe, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addComponent(boxIDLigne, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(montantLigne, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boxIDActivite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxIDArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxIDParagraphe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
        );
        panneauFormsLayout.setVerticalGroup(
            panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauFormsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(codeLigne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(boxIDLigne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(montantLigne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboProgramme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(comboActivite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxIDProgramme, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxIDActivite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(comboArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxIDArticle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(comboAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boxIDAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboChapitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(comboParagraphe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(boxIDChapitre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxIDParagraphe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        tableau_ligne.setAutoCreateRowSorter(true);
        tableau_ligne.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tableau_ligne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Ligne", "Code Ligne", "Code Programme", "Code Action", "Code Chapitre", "Code Activité", "Code Article", "Code Paragraphe", "Montant total de la ligne"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableau_ligne.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableau_ligne.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableau_ligne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableau_ligneMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableau_ligne);
        if (tableau_ligne.getColumnModel().getColumnCount() > 0) {
            tableau_ligne.getColumnModel().getColumn(0).setMinWidth(0);
            tableau_ligne.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableau_ligne.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

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
        btn_enregistrer.setText("Ajouter");
        btn_enregistrer.setToolTipText("Ajouter");
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
        btn_modifier.setEnabled(false);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_enregistrer)
                    .addComponent(btn_modifier)
                    .addComponent(btn_supprimer)
                    .addComponent(btn_nouveau, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_enregistrer, btn_modifier, btn_nouveau, btn_rafraichir, btn_supprimer});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btn_nouveau)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_enregistrer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modifier)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_supprimer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_enregistrer, btn_modifier, btn_nouveau, btn_rafraichir, btn_supprimer});

        javax.swing.GroupLayout panneauPrincipalLayout = new javax.swing.GroupLayout(panneauPrincipal);
        panneauPrincipal.setLayout(panneauPrincipalLayout);
        panneauPrincipalLayout.setHorizontalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panneauForms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panneauPrincipalLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        panneauPrincipalLayout.setVerticalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panneauForms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        setBounds(0, 0, 1563, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nouveauActionPerformed
        // TODO add your handling code here:
        comboProgramme.setSelectedIndex(0);
        boxIDLigne.setText("");
        codeLigne.setText("");
        montantLigne.setText("");
    }//GEN-LAST:event_btn_nouveauActionPerformed

    private void btn_enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enregistrerActionPerformed
        enregistrerLigne();
        listerLigne();
    }//GEN-LAST:event_btn_enregistrerActionPerformed

    private void btn_rafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rafraichirActionPerformed
        // TODO add your handling code here:
        listerLigne();
    }//GEN-LAST:event_btn_rafraichirActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        listerLigne();
        boxInvisible();
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        //listerProgramme();
        //listerComboArticle();
        listerComboProgramme();
        JTableHeader header = tableau_ligne.getTableHeader();
        header.setDefaultRenderer(new PropsTableau());
    }//GEN-LAST:event_formInternalFrameOpened

    private void tableau_ligneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableau_ligneMouseClicked
        // TODO add your handling code here:
        // afficherParagraphe();
    }//GEN-LAST:event_tableau_ligneMouseClicked

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
        // TODO add your handling code here:
        //modifierParagraphe();
        // listerParagraphe();
    }//GEN-LAST:event_btn_modifierActionPerformed

    private void btn_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supprimerActionPerformed
        // TODO add your handling code here:
        supprimerLigne();
        listerLigne();
    }//GEN-LAST:event_btn_supprimerActionPerformed

    private void comboProgrammeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboProgrammeItemStateChanged
        // TODO add your handling code here:
        getIDProgramme();
        listerComboAction();
    }//GEN-LAST:event_comboProgrammeItemStateChanged

    private void comboChapitreItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboChapitreItemStateChanged
        // TODO add your handling code here:
        getIDChapitre();
        listerComboActivite();
    }//GEN-LAST:event_comboChapitreItemStateChanged

    private void comboActionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboActionItemStateChanged
        // TODO add your handling code here:
        getIDAction();
        listerComboChapitre();
    }//GEN-LAST:event_comboActionItemStateChanged

    private void comboActiviteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboActiviteItemStateChanged
        // TODO add your handling code here:
        getIDActivite();
        listerComboArticle();
    }//GEN-LAST:event_comboActiviteItemStateChanged

    private void comboArticleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboArticleItemStateChanged
        // TODO add your handling code here:
        getIDArticle();
        listerComboParagraphe();
    }//GEN-LAST:event_comboArticleItemStateChanged

    private void comboParagrapheItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboParagrapheItemStateChanged
        // TODO add your handling code here:
        getIDParagraphe();
    }//GEN-LAST:event_comboParagrapheItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField boxIDAction;
    public static javax.swing.JTextField boxIDActivite;
    public static javax.swing.JTextField boxIDArticle;
    public static javax.swing.JTextField boxIDChapitre;
    public static javax.swing.JTextField boxIDLigne;
    public static javax.swing.JTextField boxIDParagraphe;
    public static javax.swing.JTextField boxIDProgramme;
    private javax.swing.JButton btn_enregistrer;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JButton btn_nouveau;
    private javax.swing.JButton btn_rafraichir;
    private javax.swing.JButton btn_supprimer;
    public static javax.swing.JTextField codeLigne;
    public static javax.swing.JComboBox<String> comboAction;
    public static javax.swing.JComboBox<String> comboActivite;
    public static javax.swing.JComboBox<String> comboArticle;
    public static javax.swing.JComboBox<String> comboChapitre;
    public static javax.swing.JComboBox<String> comboParagraphe;
    public static javax.swing.JComboBox<String> comboProgramme;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField montantLigne;
    public static javax.swing.JPanel panneauForms;
    public static javax.swing.JPanel panneauPrincipal;
    public static javax.swing.JTable tableau_ligne;
    // End of variables declaration//GEN-END:variables
}
