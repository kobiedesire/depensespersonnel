/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mae.vue;

import com.mae.controller.ActiviteController;
import com.mae.model.Activite;
import com.mae.props.PropsTableau;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author kobie
 */
public class InterfaceActivite extends javax.swing.JInternalFrame {

    /**
     *
     */
    public InterfaceActivite() {
        initComponents();
        AutoCompleteDecorator.decorate(chapitreBug);

    }
    private static int rep;

    // private static String mNom, mDescription;
    //Fonction pour l'enregistrement d'une Programme********************************************************************************************************************
    public static void enregistrerActivite() {
        // Récuperation des donnéses du formulaire
        String aCode = codeActivite.getText().trim();
        //int pidBudget = Integer.parseInt(idBud.getText());
        String aLibele = libeleActivite.getText().trim();

        if (aCode.isBlank() || idChap.getText().isBlank() || aLibele.isBlank()) {
            JOptionPane.showMessageDialog(null, "Des cahmps sont vides");
        } else {
            int pBudget = Integer.parseInt(idChap.getText());
            Activite activite = new Activite(pBudget, aCode, aLibele); // Créez un objet InterfaceStructure     
            ActiviteController.saveActivite(activite);  // Enregistrez  dans la base de données            
            chapitreBug.setSelectedIndex(0);
            idChap.setText("");
            codeActivite.setText("");
            libeleActivite.setText("");
        }

    }

    //Lister toutes les Programme********************************************************************************************************************
    public static void listerActivite() {
        ActiviteController.listAll(); // Executer la méthode d'affichage des données  
    }

    //remplissage du combobox
    public static void listerComboChapitre() {
        ActiviteController.listInCombo(); // Executer la méthode de remplissage du combo
    }

    public static void getIDChapitre() {
        ActiviteController.afficherIDChapitre(); // Executer la méthode recuperation de l'Id de l'action
    }

    //Fonction pour afficher ********************************************************************************************************************
    public static void afficherActivite() {
        ActiviteController.displayActivite();// Executer la méthode d'affichage des données        
    }

    //Modifier une structure********************************************************************************************************************
    public static void modifierActivite() {
        // Récuperation des donnéses du formulaire
        String aCode = codeActivite.getText().trim();
        String aLibele = libeleActivite.getText().trim();
        if (aCode.isBlank() || idChap.getText().isBlank() || aLibele.isBlank()) {
            JOptionPane.showMessageDialog(null, "Des cahmps sont vides");
        } else {
            int pBudget = Integer.parseInt(idChap.getText());
            rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment modifier cete Activite?", "Modification d'une Activite", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                Activite activite = new Activite(pBudget, aCode, aLibele);
                ActiviteController.updateActivite(activite); // Executer la méthode de modification dans la base de données
                JOptionPane.showMessageDialog(null, "Modification validée");
                chapitreBug.setSelectedIndex(0);
                idChap.setText("");
                codeActivite.setText("");
                libeleActivite.setText("");
            }
        }

    }

    //Supprimer une structure********************************************************************************************************************
    public static void supprimerActivite() {
        rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer cette Activite?", "Suppression d'une Activite", JOptionPane.YES_NO_OPTION);
        if (rep == JOptionPane.YES_OPTION) {
            Activite activite = new Activite();
            ActiviteController.deleteActivite(activite);// Executer la méthode de suppression des données    
            JOptionPane.showMessageDialog(null, "Activite supprimée");
            chapitreBug.setSelectedIndex(0);
            idChap.setText("");
            codeActivite.setText("");
            libeleActivite.setText("");
        }
    }

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
        libeleActivite = new javax.swing.JTextField();
        chapitreBug = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        codeActivite = new javax.swing.JTextField();
        idChap = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau_activite = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btn_nouveau = new javax.swing.JButton();
        btn_enregistrer = new javax.swing.JButton();
        btn_modifier = new javax.swing.JButton();
        btn_supprimer = new javax.swing.JButton();
        btn_rafraichir = new javax.swing.JButton();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        panneauPrincipal1 = new javax.swing.JPanel();
        panneauForms1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        libeleActivite1 = new javax.swing.JTextField();
        chapitreBug1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        codeActivite1 = new javax.swing.JTextField();
        idChap1 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableau_activite1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btn_nouveau1 = new javax.swing.JButton();
        btn_enregistrer1 = new javax.swing.JButton();
        btn_modifier1 = new javax.swing.JButton();
        btn_supprimer1 = new javax.swing.JButton();
        btn_rafraichir1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Gestion des activités");
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
        panneauForms.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations de l'activité", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Chapitre");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Libélé Activité :");

        libeleActivite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        chapitreBug.setEditable(true);
        chapitreBug.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chapitreBug.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sélectionnez un chapitre" }));
        chapitreBug.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chapitreBugItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Code Activite : ");

        codeActivite.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout panneauFormsLayout = new javax.swing.GroupLayout(panneauForms);
        panneauForms.setLayout(panneauFormsLayout);
        panneauFormsLayout.setHorizontalGroup(
            panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauFormsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chapitreBug, 0, 250, Short.MAX_VALUE)
                    .addComponent(codeActivite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idChap))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(libeleActivite, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panneauFormsLayout.setVerticalGroup(
            panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauFormsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idChap)
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(codeActivite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(libeleActivite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chapitreBug, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        tableau_activite.setAutoCreateRowSorter(true);
        tableau_activite.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tableau_activite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Activite", "ID Chapitre", "Code Chapitre", "Code Activite", "Libélé Activite"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableau_activite.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableau_activite.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableau_activite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableau_activiteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableau_activite);
        if (tableau_activite.getColumnModel().getColumnCount() > 0) {
            tableau_activite.getColumnModel().getColumn(0).setMinWidth(0);
            tableau_activite.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableau_activite.getColumnModel().getColumn(0).setMaxWidth(0);
            tableau_activite.getColumnModel().getColumn(1).setMinWidth(0);
            tableau_activite.getColumnModel().getColumn(1).setPreferredWidth(0);
            tableau_activite.getColumnModel().getColumn(1).setMaxWidth(0);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE))
                .addContainerGap())
        );

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 255));
        jInternalFrame1.setBorder(null);
        jInternalFrame1.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jInternalFrame1.setIconifiable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setFrameIcon(null);
        jInternalFrame1.addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
                jInternalFrame1formInternalFrameActivated(evt);
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
                jInternalFrame1formInternalFrameOpened(evt);
            }
        });

        panneauPrincipal1.setBackground(new java.awt.Color(255, 255, 255));
        panneauPrincipal1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        panneauForms1.setBackground(new java.awt.Color(255, 255, 255));
        panneauForms1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations de l'activité", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Chapitre");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Libélé Activité :");

        libeleActivite1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        chapitreBug1.setEditable(true);
        chapitreBug1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chapitreBug1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sélectionnez un chapitre" }));
        chapitreBug1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chapitreBug1ItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Code Activite : ");

        codeActivite1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout panneauForms1Layout = new javax.swing.GroupLayout(panneauForms1);
        panneauForms1.setLayout(panneauForms1Layout);
        panneauForms1Layout.setHorizontalGroup(
            panneauForms1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauForms1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauForms1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauForms1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(chapitreBug1, 0, 250, Short.MAX_VALUE)
                    .addComponent(codeActivite1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauForms1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(idChap1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(libeleActivite1, javax.swing.GroupLayout.PREFERRED_SIZE, 1019, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panneauForms1Layout.setVerticalGroup(
            panneauForms1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauForms1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panneauForms1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idChap1)
                    .addGroup(panneauForms1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(codeActivite1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauForms1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(libeleActivite1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chapitreBug1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        tableau_activite1.setAutoCreateRowSorter(true);
        tableau_activite1.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tableau_activite1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Activite", "ID Chapitre", "Code Chapitre", "Code Activite", "Libélé Activite"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableau_activite1.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableau_activite1.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableau_activite1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableau_activite1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableau_activite1);
        if (tableau_activite1.getColumnModel().getColumnCount() > 0) {
            tableau_activite1.getColumnModel().getColumn(0).setMinWidth(0);
            tableau_activite1.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableau_activite1.getColumnModel().getColumn(0).setMaxWidth(0);
            tableau_activite1.getColumnModel().getColumn(1).setMinWidth(0);
            tableau_activite1.getColumnModel().getColumn(1).setPreferredWidth(0);
            tableau_activite1.getColumnModel().getColumn(1).setMaxWidth(0);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actions", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        btn_nouveau1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_nouveau1.setForeground(new java.awt.Color(0, 102, 51));
        btn_nouveau1.setText("Nouveau");
        btn_nouveau1.setToolTipText("Nouveau");
        btn_nouveau1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_nouveau1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nouveau1ActionPerformed(evt);
            }
        });

        btn_enregistrer1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_enregistrer1.setForeground(new java.awt.Color(0, 102, 51));
        btn_enregistrer1.setText("Enregistrer");
        btn_enregistrer1.setToolTipText("Enregistrer");
        btn_enregistrer1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_enregistrer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_enregistrer1ActionPerformed(evt);
            }
        });

        btn_modifier1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_modifier1.setForeground(new java.awt.Color(0, 102, 51));
        btn_modifier1.setText("Modifier");
        btn_modifier1.setToolTipText("Modifier");
        btn_modifier1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_modifier1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modifier1ActionPerformed(evt);
            }
        });

        btn_supprimer1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_supprimer1.setForeground(new java.awt.Color(0, 102, 51));
        btn_supprimer1.setText("Supprimer");
        btn_supprimer1.setToolTipText("Supprimer");
        btn_supprimer1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_supprimer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_supprimer1ActionPerformed(evt);
            }
        });

        btn_rafraichir1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_rafraichir1.setForeground(new java.awt.Color(0, 102, 51));
        btn_rafraichir1.setText("Rafraîchir la liste");
        btn_rafraichir1.setToolTipText("Rafraîchir la liste");
        btn_rafraichir1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_rafraichir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_rafraichir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_enregistrer1)
                    .addComponent(btn_modifier1)
                    .addComponent(btn_supprimer1)
                    .addComponent(btn_nouveau1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rafraichir1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(btn_nouveau1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_enregistrer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_modifier1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_supprimer1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_rafraichir1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panneauPrincipal1Layout = new javax.swing.GroupLayout(panneauPrincipal1);
        panneauPrincipal1.setLayout(panneauPrincipal1Layout);
        panneauPrincipal1Layout.setHorizontalGroup(
            panneauPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipal1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panneauForms1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panneauPrincipal1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
        );
        panneauPrincipal1Layout.setVerticalGroup(
            panneauPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipal1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panneauForms1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addComponent(panneauPrincipal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panneauPrincipal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        setBounds(0, 0, 1563, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_nouveauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nouveauActionPerformed
        // TODO add your handling code here:
        chapitreBug.setSelectedIndex(0);
        idChap.setText("");
        codeActivite.setText("");
        libeleActivite.setText("");
    }//GEN-LAST:event_btn_nouveauActionPerformed

    private void btn_enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enregistrerActionPerformed
        enregistrerActivite();
        listerActivite();
    }//GEN-LAST:event_btn_enregistrerActionPerformed

    private void btn_rafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rafraichirActionPerformed
        // TODO add your handling code here:
        listerActivite();
    }//GEN-LAST:event_btn_rafraichirActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        listerActivite();
        idChap.setVisible(false);
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        //listerProgramme();
        listerComboChapitre();
        JTableHeader header = tableau_activite.getTableHeader();
        header.setDefaultRenderer(new PropsTableau());
    }//GEN-LAST:event_formInternalFrameOpened

    private void tableau_activiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableau_activiteMouseClicked
        // TODO add your handling code here:
        afficherActivite();
    }//GEN-LAST:event_tableau_activiteMouseClicked

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
        // TODO add your handling code here:
        modifierActivite();
        listerActivite();
    }//GEN-LAST:event_btn_modifierActionPerformed

    private void btn_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supprimerActionPerformed
        // TODO add your handling code here:
        supprimerActivite();
        listerActivite();
    }//GEN-LAST:event_btn_supprimerActionPerformed

    private void chapitreBugItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chapitreBugItemStateChanged
        // TODO add your handling code here:
        getIDChapitre();
    }//GEN-LAST:event_chapitreBugItemStateChanged

    private void chapitreBug1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chapitreBug1ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_chapitreBug1ItemStateChanged

    private void tableau_activite1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableau_activite1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tableau_activite1MouseClicked

    private void btn_nouveau1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nouveau1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nouveau1ActionPerformed

    private void btn_enregistrer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enregistrer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_enregistrer1ActionPerformed

    private void btn_modifier1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifier1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_modifier1ActionPerformed

    private void btn_supprimer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supprimer1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_supprimer1ActionPerformed

    private void btn_rafraichir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rafraichir1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_rafraichir1ActionPerformed

    private void jInternalFrame1formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_jInternalFrame1formInternalFrameActivated
        // TODO add your handling code here:
    }//GEN-LAST:event_jInternalFrame1formInternalFrameActivated

    private void jInternalFrame1formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_jInternalFrame1formInternalFrameOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_jInternalFrame1formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_enregistrer;
    private javax.swing.JButton btn_enregistrer1;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JButton btn_modifier1;
    private javax.swing.JButton btn_nouveau;
    private javax.swing.JButton btn_nouveau1;
    private javax.swing.JButton btn_rafraichir;
    private javax.swing.JButton btn_rafraichir1;
    private javax.swing.JButton btn_supprimer;
    private javax.swing.JButton btn_supprimer1;
    public static javax.swing.JComboBox<String> chapitreBug;
    public static javax.swing.JComboBox<String> chapitreBug1;
    public static javax.swing.JTextField codeActivite;
    public static javax.swing.JTextField codeActivite1;
    public static javax.swing.JTextField idChap;
    public static javax.swing.JTextField idChap1;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField libeleActivite;
    public static javax.swing.JTextField libeleActivite1;
    public static javax.swing.JPanel panneauForms;
    public static javax.swing.JPanel panneauForms1;
    public static javax.swing.JPanel panneauPrincipal;
    public static javax.swing.JPanel panneauPrincipal1;
    public static javax.swing.JTable tableau_activite;
    public static javax.swing.JTable tableau_activite1;
    // End of variables declaration//GEN-END:variables
}
