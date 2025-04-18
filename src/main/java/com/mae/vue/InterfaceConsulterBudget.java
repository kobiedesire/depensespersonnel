/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mae.vue;

import com.mae.controller.ConsulterBudgetController;
import com.mae.controller.StatBudgetExportPDFController;
import com.mae.controller.StatExportPDFController;
import com.mae.props.PropsTableau;
import com.mae.props.PropsTableauStatBudget;
import java.awt.event.KeyEvent;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTable;

/**
 *
 * @author kobie
 */
    public class InterfaceConsulterBudget extends javax.swing.JInternalFrame {

    /**
     *
     */
    public InterfaceConsulterBudget() {
        initComponents();
       
    }

   
    
    //Lister toutes les agents********************************************************************************************************************
    public static void listerAgent() {
        ConsulterBudgetController.listAllAgent(); // Executer la méthode d'affichage des données  
        ConsulterBudgetController.calculBudgetMensuelAnnuel();
    }


    //exportExcel   
    public static void exporterExcel() {
        ConsulterBudgetController.exportExcel();
    }
    
    
    

    //exportPDF
   // public static void exporterPDF() {
    //    ConsulterBudgetController.exportPDF();
   // }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneauPrincipal = new javax.swing.JPanel();
        btn_rechercheragent2 = new javax.swing.JButton();
        btn_rafraichir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableau_total = new javax.swing.JTable();
        statBudgetNombreEnreg = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau_listeCompleteAgent = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consultation du budget détaillé");
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

        tableau_total.setBackground(new java.awt.Color(204, 0, 51));
        tableau_total.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        tableau_total.setForeground(new java.awt.Color(255, 255, 255));
        tableau_total.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "TOTAL BUDGET MENSUEL", "TOTAL BUDGET ANNUEL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableau_total.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableau_total.setGridColor(new java.awt.Color(255, 255, 255));
        tableau_total.setRowHeight(50);
        tableau_total.setSelectionBackground(new java.awt.Color(204, 0, 51));
        tableau_total.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(tableau_total);
        if (tableau_total.getColumnModel().getColumnCount() > 0) {
            tableau_total.getColumnModel().getColumn(0).setResizable(false);
            tableau_total.getColumnModel().getColumn(1).setResizable(false);
        }

        statBudgetNombreEnreg.setBackground(new java.awt.Color(0, 0, 204));
        statBudgetNombreEnreg.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        statBudgetNombreEnreg.setForeground(new java.awt.Color(255, 255, 255));
        statBudgetNombreEnreg.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statBudgetNombreEnreg.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        statBudgetNombreEnreg.setEnabled(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 204));
        jLabel5.setText("Total Lignes Trouvées : ");

        javax.swing.GroupLayout panneauPrincipalLayout = new javax.swing.GroupLayout(panneauPrincipal);
        panneauPrincipal.setLayout(panneauPrincipalLayout);
        panneauPrincipalLayout.setHorizontalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauPrincipalLayout.createSequentialGroup()
                        .addGap(1247, 1247, 1247)
                        .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_rechercheragent2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addComponent(jScrollPane2)
                    .addGroup(panneauPrincipalLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statBudgetNombreEnreg, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panneauPrincipalLayout.setVerticalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statBudgetNombreEnreg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_rechercheragent2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_rafraichir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jScrollPane3.setBackground(new java.awt.Color(204, 204, 255));

        tableau_listeCompleteAgent.setAutoCreateRowSorter(true);
        tableau_listeCompleteAgent.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tableau_listeCompleteAgent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Agent", "Matricule", "Nom", "Prénom", "DateNai.", "Sexe", "DatePriseServ.", "TypeAgent", "Structure", "Minist.Ori.", "Fonction", "Emploi", "Cat/Echelle", "Echélon", "Indice", "Salaire Ind.", "Ind.Résidence", "Ind.Astreinte", "Ind.Technicité", "Ind.Respons.", "Ind.Vest.", "Ind.Logement", "Ind.Spéc.", "AutresInd.", "ChareMil.", "CARFO", "CNSS", "Alloc.Fam", "Inc.Mensuelle", "IncidenceAnnuelle"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableau_listeCompleteAgent.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableau_listeCompleteAgent.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableau_listeCompleteAgent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableau_listeCompleteAgentMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableau_listeCompleteAgent);
        if (tableau_listeCompleteAgent.getColumnModel().getColumnCount() > 0) {
            tableau_listeCompleteAgent.getColumnModel().getColumn(0).setMinWidth(0);
            tableau_listeCompleteAgent.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableau_listeCompleteAgent.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jScrollPane3.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panneauPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panneauPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBounds(0, 0, 1631, 780);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        listerAgent();
        JTableHeader header = tableau_listeCompleteAgent.getTableHeader();
        header.setDefaultRenderer(new PropsTableau());
        
        JTableHeader header2 = tableau_total.getTableHeader();
        header2.setDefaultRenderer(new PropsTableauStatBudget());
        tableau_listeCompleteAgent.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        
         

    }//GEN-LAST:event_formInternalFrameOpened

    private void tableau_listeCompleteAgentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableau_listeCompleteAgentMouseClicked
        // TODO add your handling code here:
      //  displayOneAgenntToUpdateOrDelete();

    }//GEN-LAST:event_tableau_listeCompleteAgentMouseClicked

    private void btn_rafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rafraichirActionPerformed
        // TODO add your handling code here:
        listerAgent();
    }//GEN-LAST:event_btn_rafraichirActionPerformed

    private void btn_rechercheragent2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rechercheragent2ActionPerformed
        // TODO add your handling code here:
        exporterExcel();
    }//GEN-LAST:event_btn_rechercheragent2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_rafraichir;
    private javax.swing.JButton btn_rechercheragent2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JPanel panneauPrincipal;
    public static javax.swing.JTextField statBudgetNombreEnreg;
    public static javax.swing.JTable tableau_listeCompleteAgent;
    public static javax.swing.JTable tableau_total;
    // End of variables declaration//GEN-END:variables
}
