/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
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
 * @author hp
 */
public class InterfaceListeLigne666 extends javax.swing.JDialog {

    /**
     * Creates new form InterfaceListeLigne
     */
    public InterfaceListeLigne666(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    //Lister toutes les agents********************************************************************************************************************
    public static void listerLignes() {
        AgentController.afficherLignesFromProgramme666(); 
    }
    
    //afficher l'id de la ligne dans le formulaire agent
    
     public static void afficherIDLigne666() {
        AgentController.recupIDLigne666(); 
    }
   /* public static void afficherIDLigne661() {
        AgentController.recupIDLigne661(); 
    }

    public static void afficherIDLigne663() {
        AgentController.recupIDLigne663(); 
    }
    public static void afficherIDLigne664() {
        AgentController.recupIDLigne664(); 
    }
   
    public static void afficherIDLigne669() {
        AgentController.recupIDLigne669(); 
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau_Selectligne = new javax.swing.JTable();
        idProgrammeListeLigne666 = new javax.swing.JFormattedTextField();
        btn_ajout666 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Liste des lignes budgétaires");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des lignes budgétaires", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        tableau_Selectligne.setAutoCreateRowSorter(true);
        tableau_Selectligne.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tableau_Selectligne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tableau_Selectligne.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableau_Selectligne.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableau_Selectligne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableau_SelectligneMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableau_Selectligne);
        if (tableau_Selectligne.getColumnModel().getColumnCount() > 0) {
            tableau_Selectligne.getColumnModel().getColumn(0).setMinWidth(0);
            tableau_Selectligne.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableau_Selectligne.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        btn_ajout666.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_ajout666.setForeground(new java.awt.Color(0, 102, 51));
        btn_ajout666.setIcon(new javax.swing.ImageIcon(getClass().getResource("/curseur.png"))); // NOI18N
        btn_ajout666.setText("Sélectionnez la ligne");
        btn_ajout666.setToolTipText("Sélectionnez la ligne");
        btn_ajout666.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 51), 1, true));
        btn_ajout666.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ajout666ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idProgrammeListeLigne666, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ajout666))
                .addContainerGap(1189, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1425, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(idProgrammeListeLigne666, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 405, Short.MAX_VALUE)
                .addComponent(btn_ajout666, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(30, 30, 30)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(84, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableau_SelectligneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableau_SelectligneMouseClicked
        // TODO add your handling code here:
        // afficherParagraphe();
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            afficherIDLigne666();
            this.dispose();
        }
    }//GEN-LAST:event_tableau_SelectligneMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        listerLignes();
    }//GEN-LAST:event_formWindowActivated

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        idProgrammeListeLigne666.setVisible(false);
        JTableHeader header = tableau_Selectligne.getTableHeader();
        header.setDefaultRenderer(new PropsTableau());
    }//GEN-LAST:event_formWindowOpened

    private void btn_ajout666ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ajout666ActionPerformed
        // TODO add your handling code here:
                afficherIDLigne666();
                this.dispose();
    }//GEN-LAST:event_btn_ajout666ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfaceListeLigne666.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfaceListeLigne666.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfaceListeLigne666.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfaceListeLigne666.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                InterfaceListeLigne666 dialog = new InterfaceListeLigne666(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btn_ajout666;
    public static javax.swing.JFormattedTextField idProgrammeListeLigne666;
    public static javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tableau_Selectligne;
    // End of variables declaration//GEN-END:variables
}
