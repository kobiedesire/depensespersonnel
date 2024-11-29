/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mae.vue;

import com.mae.controller.StructureController;
import com.mae.model.Structure;
import com.mae.props.PropsTableau;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author kobie
 */
public class InterfaceStructure extends javax.swing.JInternalFrame {

    /**
     * 
     */
    public InterfaceStructure() {
        initComponents();
        AutoCompleteDecorator.decorate(typeStr);
        AutoCompleteDecorator.decorate(programmeStruc);

    }
    
    //remplissage du combobox des categories
    public static void listerComboProgramme() {
        StructureController.listProgrammeInCombo();// Executer la méthode de remplissage du combo
    }
    
    //Afficher l'id du programme dans le champs de texte'
     public static void getIDProgramme() {
        StructureController.afficherIDProgramme(); // Executer la méthode recuperation de l'Id de l'action
    }
    private static int rep;

    // private static String mNom, mDescription;
    //Fonction pour l'enregistrement d'une structure********************************************************************************************************************
    public static void enregistrerStructure() throws ParseException {
        // Récuperation des donnéses du formulaire

        String sCode = codeStr.getText().trim();        
        String sType = (typeStr.getSelectedItem().toString()).trim();
        String sLibele = libeleStr.getText().trim();

        if (idProg.getText().isBlank() || sCode.isBlank() || sType.isBlank() || sLibele.isBlank() || coefficientStruc.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Des cahmps sont vides");
        } else {
            int pID = Integer.parseInt(idProg.getText());   
            String coeffSaisie = coefficientStruc.getText().replace(",", ".");
            BigDecimal sCoefficient = new BigDecimal(coeffSaisie);     
            Structure structure = new Structure(pID, sCode, sType, sLibele, sCoefficient); // Créez un objet InterfaceStructure     
            StructureController.saveStructure(structure);  // Enregistrez  dans la base de données            
            typeStr.setSelectedIndex(0);
            programmeStruc.setSelectedIndex(0);
            codeStr.setText("");
            libeleStr.setText("");
            coefficientStruc.setText("");
        }
            
    }

    //Lister toutes les structures********************************************************************************************************************
    public static void listerStructure() {
        StructureController.listAll(); // Executer la méthode d'affichage des données  
    }

    //Fonction pour afficher ********************************************************************************************************************
    public static void afficherStructure() {
        StructureController.displayStructure();// Executer la méthode d'affichage des données        
    }

    //Modifier une structure********************************************************************************************************************
    public static void modifierStructure() throws ParseException {
        // Récuperation des donnéses du formulaire
        String sCode = codeStr.getText().trim();
        String sType = (typeStr.getSelectedItem().toString()).trim();
        String sLibele = libeleStr.getText().trim();
        if (idProg.getText().isBlank() || sCode.isBlank() || sType.isBlank() || sLibele.isBlank() || coefficientStruc.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Des cahmps sont vides");
        } else {
            int pID = Integer.parseInt(idProg.getText());
              String coeffSaisie = coefficientStruc.getText().replace(",", ".");
            BigDecimal sCoefficient = new BigDecimal(coeffSaisie);          
            rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment modifier cette structure?", "Modification d'une structure", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                Structure structure = new Structure(pID, sCode, sType, sLibele, sCoefficient);
                StructureController.updateStructure(structure); // Executer la méthode de modification dans la base de données
                JOptionPane.showMessageDialog(null, "Modification validée");
                typeStr.setSelectedIndex(0);
                programmeStruc.setSelectedIndex(0);
                codeStr.setText("");
                libeleStr.setText("");
                idProg.setText("");
                coefficientStruc.setText("");
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
            programmeStruc.setSelectedIndex(0);
            codeStr.setText("");
            libeleStr.setText("");
            idProg.setText("");
             coefficientStruc.setText("");
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
        libeleStr = new javax.swing.JTextField();
        typeStr = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        codeStr = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        programmeStruc = new javax.swing.JComboBox<>();
        idProg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        coefficientStruc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau_structure = new javax.swing.JTable();
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
        setTitle("Gestion des structures");
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
        panneauForms.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations de la structure", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Type Structure :");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Libélé Structure :");

        libeleStr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        typeStr.setEditable(true);
        typeStr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        typeStr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Mission permamente", "Centrale", "Ambassade", "Consulat" }));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Code Structure : ");

        codeStr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Programme budgétaire : ");

        programmeStruc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        programmeStruc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        programmeStruc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                programmeStrucItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Coefficient de correction : ");

        coefficientStruc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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
                    .addComponent(typeStr, 0, 250, Short.MAX_VALUE)
                    .addComponent(codeStr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addComponent(programmeStruc, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coefficientStruc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idProg, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(libeleStr, javax.swing.GroupLayout.PREFERRED_SIZE, 965, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        panneauFormsLayout.setVerticalGroup(
            panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauFormsLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(codeStr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(libeleStr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(typeStr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(programmeStruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(idProg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(coefficientStruc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        tableau_structure.setAutoCreateRowSorter(true);
        tableau_structure.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tableau_structure.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Structure", "Code Programme", "Code Structure", "Type de structure", "Libélé Structure", "Coefficient de correction"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableau_structure.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableau_structure.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableau_structure.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableau_structureMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableau_structure);
        if (tableau_structure.getColumnModel().getColumnCount() > 0) {
            tableau_structure.getColumnModel().getColumn(0).setMinWidth(0);
            tableau_structure.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableau_structure.getColumnModel().getColumn(0).setMaxWidth(0);
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
        typeStr.setSelectedIndex(0);
         programmeStruc.setSelectedIndex(0);
        codeStr.setText("");
        libeleStr.setText("");
        coefficientStruc.setText("");
    }//GEN-LAST:event_btn_nouveauActionPerformed

    private void btn_enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enregistrerActionPerformed
        try {
            enregistrerStructure();
        } catch (ParseException ex) {
            Logger.getLogger(InterfaceStructure.class.getName()).log(Level.SEVERE, null, ex);
        }
        listerStructure();
    }//GEN-LAST:event_btn_enregistrerActionPerformed

    private void btn_rafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rafraichirActionPerformed
        // TODO add your handling code here:
        listerStructure();
        
    }//GEN-LAST:event_btn_rafraichirActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        listerComboProgramme();
        idProg.setVisible(false);
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        listerStructure();
        JTableHeader header = tableau_structure.getTableHeader();
        header.setDefaultRenderer(new PropsTableau());
    }//GEN-LAST:event_formInternalFrameOpened

    private void tableau_structureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableau_structureMouseClicked
        // TODO add your handling code here:
        afficherStructure();
    }//GEN-LAST:event_tableau_structureMouseClicked

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
        try {
            // TODO add your handling code here:
            modifierStructure();
        } catch (ParseException ex) {
            Logger.getLogger(InterfaceStructure.class.getName()).log(Level.SEVERE, null, ex);
        }
        listerStructure();
    }//GEN-LAST:event_btn_modifierActionPerformed

    private void btn_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supprimerActionPerformed
        // TODO add your handling code here:
        supprimerStructure();
        listerStructure();
    }//GEN-LAST:event_btn_supprimerActionPerformed

    private void programmeStrucItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_programmeStrucItemStateChanged
        // TODO add your handling code here:
        getIDProgramme();
    }//GEN-LAST:event_programmeStrucItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_enregistrer;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JButton btn_nouveau;
    private javax.swing.JButton btn_rafraichir;
    private javax.swing.JButton btn_supprimer;
    public static javax.swing.JTextField codeStr;
    public static javax.swing.JTextField coefficientStruc;
    public static javax.swing.JTextField idProg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField libeleStr;
    public static javax.swing.JPanel panneauForms;
    public static javax.swing.JPanel panneauPrincipal;
    public static javax.swing.JComboBox<String> programmeStruc;
    public static javax.swing.JTable tableau_structure;
    public static javax.swing.JComboBox<String> typeStr;
    // End of variables declaration//GEN-END:variables
}
