/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mae.vue;

import com.mae.controller.ProfilController;
import com.mae.model.Profil;
import com.mae.props.PropsTableau;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author kobie
 */

public class InterfaceProfil extends javax.swing.JInternalFrame {

    /**
     *
     */
    public InterfaceProfil() {
        initComponents();
        //groupe boutton gestion structure
        ButtonGroup gestStructure = new ButtonGroup();
        gestStructure.add(gest_strucActiv);
        gestStructure.add(gest_strucDesactiv);
        //groupe bpoutton gestion emploi
        ButtonGroup gestEmploi = new ButtonGroup();
        gestEmploi.add(gest_emploiActiv);
        gestEmploi.add(gest_emploiDesactiv);
        //groupe bpoutton gestion agent
        ButtonGroup gestAgent = new ButtonGroup();
        gestAgent.add(gest_agentActiv);
        gestAgent.add(gest_agentDesactiv);
        //groupe bpoutton gestion stattisques
        ButtonGroup gestStat = new ButtonGroup();
        gestStat.add(gest_statActiv);
        gestStat.add(gest_statDesactiv);
        //groupe bpoutton gestion budget
        ButtonGroup gestBudget = new ButtonGroup();
        gestBudget.add(gest_budgetActiv);
        gestBudget.add(gest_budgetDesactiv);
          //groupe bpoutton gestion categorie
        ButtonGroup gestCategorie = new ButtonGroup();
        gestCategorie.add(gest_categorieActiv);
        gestCategorie.add(gest_categorieDesactiv);
          //groupe bpoutton gestion fonction
        ButtonGroup gestFonction = new ButtonGroup();
        gestFonction.add(gest_fonctionActiv);
        gestFonction.add(gest_fonctionDesactiv);
        //groupe bpoutton gestion ministere
        ButtonGroup gestMinistere = new ButtonGroup();
        gestMinistere.add(gest_ministereActiv);
        gestMinistere.add(gest_ministereDesactiv);
          //groupe bpoutton gestion paramAvance
        ButtonGroup gestParamAvance = new ButtonGroup();
        gestParamAvance.add(gest_paramAvanceActiv);
        gestParamAvance.add(gest_paramAvanceDesactiv);      
    }
    
    
    //desactiver/reinitialiser  la selection 
    
    public static void reinitSelection(){
    
     //groupe boutton gestion structure
        ButtonGroup gestStructure = new ButtonGroup();
        gestStructure.add(gest_strucActiv);
        gestStructure.add(gest_strucDesactiv);
        gestStructure.clearSelection();
        //groupe bpoutton gestion emploi
        ButtonGroup gestEmploi = new ButtonGroup();
        gestEmploi.add(gest_emploiActiv);
        gestEmploi.add(gest_emploiDesactiv);
        gestEmploi.clearSelection();
        //groupe bpoutton gestion agent
        ButtonGroup gestAgent = new ButtonGroup();
        gestAgent.add(gest_agentActiv);
        gestAgent.add(gest_agentDesactiv);
        gestAgent.clearSelection();
        //groupe bpoutton gestion stattisques
        ButtonGroup gestStat = new ButtonGroup();
        gestStat.add(gest_statActiv);
        gestStat.add(gest_statDesactiv);
        gestStat.clearSelection();
        //groupe bpoutton gestion budget
        ButtonGroup gestBudget = new ButtonGroup();
        gestBudget.add(gest_budgetActiv);
        gestBudget.add(gest_budgetDesactiv);
        gestBudget.clearSelection();
          //groupe bpoutton gestion categorie
        ButtonGroup gestCategorie = new ButtonGroup();
        gestCategorie.add(gest_categorieActiv);
        gestCategorie.add(gest_categorieDesactiv);
        gestCategorie.clearSelection();
          //groupe bpoutton gestion fonction
        ButtonGroup gestFonction = new ButtonGroup();
        gestFonction.add(gest_fonctionActiv);
        gestFonction.add(gest_fonctionDesactiv);
        gestFonction.clearSelection();
        //groupe bpoutton gestion ministere
        ButtonGroup gestMinistere = new ButtonGroup();
        gestMinistere.add(gest_ministereActiv);
        gestMinistere.add(gest_ministereDesactiv);
        gestMinistere.clearSelection();
          //groupe bpoutton gestion paramAvance
        ButtonGroup gestParamAvance = new ButtonGroup();
        gestParamAvance.add(gest_paramAvanceActiv);
        gestParamAvance.add(gest_paramAvanceDesactiv);   
        gestParamAvance.clearSelection();
    }
    
    //Fonction pour l'enregistrement d'un profil********************************************************************************************************************
                  
              
        public static void enregistrerProfil() {
        // Récuperation des donnéses du formulaire
            String pLibele = libeleProf.getText().trim();
            String structSelect, fonctionSelect, categorieSelect, ministereSelect, agentSelect;
            String statSelect, emploiSelect, budgetSelect, paramAvanceSelect;
            
             //recuperation de l'evenement du bouton de gestion des structures
            if (gest_strucActiv.isSelected()) {
                structSelect = "1";
            } else if (gest_strucDesactiv.isSelected()) {
                structSelect = "0";
            } else {
                structSelect = "";
            }

            ///recuperation de l'evenement du bouton de gestion des fonctions
            if (gest_fonctionActiv.isSelected()) {
                fonctionSelect = "1";
            } else if (gest_fonctionDesactiv.isSelected()) {
                fonctionSelect = "0";
            } else {
                fonctionSelect = "";
            }
            
             ///recuperation de l'evenement du bouton de gestion des emplois
            if (gest_emploiActiv.isSelected()) {
                emploiSelect = "1";
            } else if (gest_emploiDesactiv.isSelected()) {
                emploiSelect = "0";
            } else {
                emploiSelect = "";
            }
            
             ///recuperation de l'evenement du bouton de gestion des categories
            if (gest_categorieActiv.isSelected()) {
                categorieSelect = "1";
            } else if (gest_categorieDesactiv.isSelected()) {
                categorieSelect = "0";
            } else {
                categorieSelect = "";
            }
            
             ///recuperation de l'evenement du bouton de gestion des agents
            if (gest_agentActiv.isSelected()) {
                agentSelect = "1";
            } else if (gest_agentDesactiv.isSelected()) {
                agentSelect = "0";
            } else {
                agentSelect = "";
            }
            
             ///recuperation de l'evenement du bouton de gestion des ministere
            if (gest_ministereActiv.isSelected()) {
                ministereSelect = "1";
            } else if (gest_ministereDesactiv.isSelected()) {
                ministereSelect = "0";
            } else {
                ministereSelect = "";
            }

             ///recuperation de l'evenement du bouton de gestion des statitisques
            if (gest_statActiv.isSelected()) {
                statSelect = "1";
            } else if (gest_statDesactiv.isSelected()) {
                statSelect = "0";
            } else {
                statSelect = "";
            }
            
             ///recuperation de l'evenement du bouton de gestion des budget
            if (gest_budgetActiv.isSelected()) {
                budgetSelect = "1";
            } else if (gest_budgetDesactiv.isSelected()) {
                budgetSelect = "0";
            } else {
                budgetSelect = "";
            }
            
             ///recuperation de l'evenement du bouton de gestion des parametres avancee
            if (gest_paramAvanceActiv.isSelected()) {
                paramAvanceSelect = "1";
            } else if (gest_paramAvanceDesactiv.isSelected()) {
                paramAvanceSelect = "0";
            } else {
                paramAvanceSelect = "";
            }   
     
        if (pLibele.isBlank() || structSelect.isBlank() || fonctionSelect.isBlank() || categorieSelect.isBlank() || ministereSelect.isBlank() || agentSelect.isBlank() || 
                statSelect.isBlank() || emploiSelect.isBlank() || budgetSelect.isBlank() || paramAvanceSelect.isBlank()) {
            JOptionPane.showMessageDialog(null, "Des cahmps sont vides");
        } else {
            Profil profil = new Profil(pLibele, structSelect, categorieSelect, emploiSelect, fonctionSelect, ministereSelect, agentSelect, budgetSelect, statSelect, paramAvanceSelect ); // Créez un objet Interfaceprofil  
            ProfilController.saveProfil(profil);  // Enregistrez  dans la base de données        
            libeleProf.setText("");
           
        }       
        
    }
        
        
       //Modification d'un profil
    private static int rep;

    public static void modifierProfil() {
        String structSelect, fonctionSelect, categorieSelect, ministereSelect, agentSelect;
        String statSelect, emploiSelect, budgetSelect, paramAvanceSelect;
        // Récuperation des donnéses du formulaire
        String pLibele = libeleProf.getText().trim();
        //recuperation de l'evenement du bouton de gestion des structures
        if (gest_strucActiv.isSelected()) {
            structSelect = "1";
        } else if (gest_strucDesactiv.isSelected()) {
            structSelect = "0";
        } else {
            structSelect = "";
        }

        ///recuperation de l'evenement du bouton de gestion des fonctions
        if (gest_fonctionActiv.isSelected()) {
            fonctionSelect = "1";
        } else if (gest_fonctionDesactiv.isSelected()) {
            fonctionSelect = "0";
        } else {
            fonctionSelect = "";
        }

        ///recuperation de l'evenement du bouton de gestion des emplois
        if (gest_emploiActiv.isSelected()) {
            emploiSelect = "1";
        } else if (gest_emploiDesactiv.isSelected()) {
            emploiSelect = "0";
        } else {
            emploiSelect = "";
        }

        ///recuperation de l'evenement du bouton de gestion des categories
        if (gest_categorieActiv.isSelected()) {
            categorieSelect = "1";
        } else if (gest_categorieDesactiv.isSelected()) {
            categorieSelect = "0";
        } else {
            categorieSelect = "";
        }

        ///recuperation de l'evenement du bouton de gestion des agents
        if (gest_agentActiv.isSelected()) {
            agentSelect = "1";
        } else if (gest_agentDesactiv.isSelected()) {
            agentSelect = "0";
        } else {
            agentSelect = "";
        }

        ///recuperation de l'evenement du bouton de gestion des ministere
        if (gest_ministereActiv.isSelected()) {
            ministereSelect = "1";
        } else if (gest_ministereDesactiv.isSelected()) {
            ministereSelect = "0";
        } else {
            ministereSelect = "";
        }

        ///recuperation de l'evenement du bouton de gestion des statitisques
        if (gest_statActiv.isSelected()) {
            statSelect = "1";
        } else if (gest_statDesactiv.isSelected()) {
            statSelect = "0";
        } else {
            statSelect = "";
        }

        ///recuperation de l'evenement du bouton de gestion des budget
        if (gest_budgetActiv.isSelected()) {
            budgetSelect = "1";
        } else if (gest_budgetDesactiv.isSelected()) {
            budgetSelect = "0";
        } else {
            budgetSelect = "";
        }

        ///recuperation de l'evenement du bouton de gestion des parametres avancee
        if (gest_paramAvanceActiv.isSelected()) {
            paramAvanceSelect = "1";
        } else if (gest_paramAvanceDesactiv.isSelected()) {
            paramAvanceSelect = "0";
        } else {
            paramAvanceSelect = "";
        }
        
        
        if (pLibele.isBlank() || structSelect.isBlank() || fonctionSelect.isBlank() || categorieSelect.isBlank() || ministereSelect.isBlank() || agentSelect.isBlank()
                || statSelect.isBlank() || emploiSelect.isBlank() || budgetSelect.isBlank() || paramAvanceSelect.isBlank()) {
            JOptionPane.showMessageDialog(null, "Des cahmps sont vides");
        } else {

            rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment modifier ce profil?", "Modification d'un profil", JOptionPane.YES_NO_OPTION);
            if (rep == JOptionPane.YES_OPTION) {
                Profil profil = new Profil(pLibele, structSelect, categorieSelect, emploiSelect, fonctionSelect, ministereSelect, agentSelect, budgetSelect, statSelect, paramAvanceSelect); // Créez un objet Interfaceprofil  
                ProfilController.updateProfil(profil); // Executer la méthode de modification dans la base de données
                JOptionPane.showMessageDialog(null, "Modification validée");
                libeleProf.setText("");
            }
        }
    }
  
    //Supprimer une structure********************************************************************************************************************
    public static void supprimerProfil() {
        rep = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer ce profil?", "Suppression d'un profil", JOptionPane.YES_NO_OPTION);
        if (rep == JOptionPane.YES_OPTION) {
            Profil profil = new Profil();
            ProfilController.deleteProfil(profil);// Executer la méthode de suppression des données    
            JOptionPane.showMessageDialog(null, "Profil supprimé");
            libeleProf.setText("");
        }
    }
    
    //Lister toutes les Profil********************************************************************************************************************
    public static void listerProfil() {
        ProfilController.listAll(); // Executer la méthode d'affichage des données  
    }

     //Fonction pour afficher ********************************************************************************************************************
    public static void afficherProfil() {
        ProfilController.displayProfil();// Executer la méthode d'affichage des données        
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
        jLabel3 = new javax.swing.JLabel();
        libeleProf = new javax.swing.JTextField();
        idCatE = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        gest_strucActiv = new javax.swing.JRadioButton();
        gest_strucDesactiv = new javax.swing.JRadioButton();
        gest_emploiActiv = new javax.swing.JRadioButton();
        gest_emploiDesactiv = new javax.swing.JRadioButton();
        gest_categorieActiv = new javax.swing.JRadioButton();
        gest_categorieDesactiv = new javax.swing.JRadioButton();
        gest_agentActiv = new javax.swing.JRadioButton();
        gest_agentDesactiv = new javax.swing.JRadioButton();
        gest_statActiv = new javax.swing.JRadioButton();
        gest_statDesactiv = new javax.swing.JRadioButton();
        gest_budgetActiv = new javax.swing.JRadioButton();
        gest_budgetDesactiv = new javax.swing.JRadioButton();
        gest_fonctionActiv = new javax.swing.JRadioButton();
        gest_fonctionDesactiv = new javax.swing.JRadioButton();
        gest_ministereActiv = new javax.swing.JRadioButton();
        gest_ministereDesactiv = new javax.swing.JRadioButton();
        gest_paramAvanceActiv = new javax.swing.JRadioButton();
        gest_paramAvanceDesactiv = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableau_profil = new javax.swing.JTable();
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
        setTitle("Gestion des profils uilisateurs");
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
        panneauForms.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informations sur le profil utilisateur", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Libélé du profil :");

        libeleProf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Permissions/Gestion Structures :");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Permissions/Gestion Emploi : ");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Permissions/Gestion CatégorieEchelon : ");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Permissions/Gestion Fonction  : ");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Permissions/Gestion Ministere : ");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Permissions/Gestion Agent : ");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Permissions/Gestion ParamAvancee : ");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Permissions/Gestion Statistiques : ");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Permissions/Gestion Budget : ");

        gest_strucActiv.setBackground(new java.awt.Color(0, 153, 0));
        gest_strucActiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_strucActiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_strucActiv.setText("Activer");

        gest_strucDesactiv.setBackground(new java.awt.Color(204, 0, 0));
        gest_strucDesactiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_strucDesactiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_strucDesactiv.setText("Désactiver");
        gest_strucDesactiv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        gest_emploiActiv.setBackground(new java.awt.Color(0, 153, 0));
        gest_emploiActiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_emploiActiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_emploiActiv.setText("Activer");

        gest_emploiDesactiv.setBackground(new java.awt.Color(204, 0, 0));
        gest_emploiDesactiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_emploiDesactiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_emploiDesactiv.setText("Désactiver");
        gest_emploiDesactiv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        gest_categorieActiv.setBackground(new java.awt.Color(0, 153, 0));
        gest_categorieActiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_categorieActiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_categorieActiv.setText("Activer");

        gest_categorieDesactiv.setBackground(new java.awt.Color(204, 0, 0));
        gest_categorieDesactiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_categorieDesactiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_categorieDesactiv.setText("Désactiver");
        gest_categorieDesactiv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        gest_agentActiv.setBackground(new java.awt.Color(0, 153, 0));
        gest_agentActiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_agentActiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_agentActiv.setText("Activer");

        gest_agentDesactiv.setBackground(new java.awt.Color(204, 0, 0));
        gest_agentDesactiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_agentDesactiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_agentDesactiv.setText("Désactiver");
        gest_agentDesactiv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        gest_statActiv.setBackground(new java.awt.Color(0, 153, 0));
        gest_statActiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_statActiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_statActiv.setText("Activer");

        gest_statDesactiv.setBackground(new java.awt.Color(204, 0, 0));
        gest_statDesactiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_statDesactiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_statDesactiv.setText("Désactiver");
        gest_statDesactiv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        gest_budgetActiv.setBackground(new java.awt.Color(0, 153, 0));
        gest_budgetActiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_budgetActiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_budgetActiv.setText("Activer");

        gest_budgetDesactiv.setBackground(new java.awt.Color(204, 0, 0));
        gest_budgetDesactiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_budgetDesactiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_budgetDesactiv.setText("Désactiver");
        gest_budgetDesactiv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        gest_fonctionActiv.setBackground(new java.awt.Color(0, 153, 0));
        gest_fonctionActiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_fonctionActiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_fonctionActiv.setText("Activer");

        gest_fonctionDesactiv.setBackground(new java.awt.Color(204, 0, 0));
        gest_fonctionDesactiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_fonctionDesactiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_fonctionDesactiv.setText("Désactiver");
        gest_fonctionDesactiv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        gest_ministereActiv.setBackground(new java.awt.Color(0, 153, 0));
        gest_ministereActiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_ministereActiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_ministereActiv.setText("Activer");

        gest_ministereDesactiv.setBackground(new java.awt.Color(204, 0, 0));
        gest_ministereDesactiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_ministereDesactiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_ministereDesactiv.setText("Désactiver");
        gest_ministereDesactiv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        gest_paramAvanceActiv.setBackground(new java.awt.Color(0, 153, 0));
        gest_paramAvanceActiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_paramAvanceActiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_paramAvanceActiv.setText("Activer");

        gest_paramAvanceDesactiv.setBackground(new java.awt.Color(204, 0, 0));
        gest_paramAvanceDesactiv.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        gest_paramAvanceDesactiv.setForeground(new java.awt.Color(255, 255, 255));
        gest_paramAvanceDesactiv.setText("Désactiver");
        gest_paramAvanceDesactiv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        javax.swing.GroupLayout panneauFormsLayout = new javax.swing.GroupLayout(panneauForms);
        panneauForms.setLayout(panneauFormsLayout);
        panneauFormsLayout.setHorizontalGroup(
            panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauFormsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(libeleProf, javax.swing.GroupLayout.PREFERRED_SIZE, 1202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(idCatE, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panneauFormsLayout.createSequentialGroup()
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panneauFormsLayout.createSequentialGroup()
                                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(panneauFormsLayout.createSequentialGroup()
                                        .addComponent(gest_strucActiv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gest_strucDesactiv))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauFormsLayout.createSequentialGroup()
                                        .addComponent(gest_emploiActiv, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gest_emploiDesactiv))))
                            .addGroup(panneauFormsLayout.createSequentialGroup()
                                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panneauFormsLayout.createSequentialGroup()
                                        .addComponent(gest_statActiv, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gest_statDesactiv))
                                    .addGroup(panneauFormsLayout.createSequentialGroup()
                                        .addComponent(gest_agentActiv, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gest_agentDesactiv))
                                    .addGroup(panneauFormsLayout.createSequentialGroup()
                                        .addComponent(gest_budgetActiv, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(gest_budgetDesactiv)))))
                        .addGap(72, 72, 72)
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panneauFormsLayout.createSequentialGroup()
                                .addComponent(gest_paramAvanceActiv, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gest_paramAvanceDesactiv))
                            .addGroup(panneauFormsLayout.createSequentialGroup()
                                .addComponent(gest_ministereActiv, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gest_ministereDesactiv))
                            .addGroup(panneauFormsLayout.createSequentialGroup()
                                .addComponent(gest_fonctionActiv, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gest_fonctionDesactiv))
                            .addGroup(panneauFormsLayout.createSequentialGroup()
                                .addComponent(gest_categorieActiv, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(gest_categorieDesactiv))))
                    .addComponent(jLabel10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panneauFormsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gest_categorieActiv, gest_categorieDesactiv, gest_fonctionActiv, gest_fonctionDesactiv, gest_ministereActiv, gest_ministereDesactiv, gest_paramAvanceActiv, gest_paramAvanceDesactiv});

        panneauFormsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {gest_agentActiv, gest_agentDesactiv, gest_budgetActiv, gest_budgetDesactiv, gest_emploiActiv, gest_emploiDesactiv, gest_statActiv, gest_statDesactiv, gest_strucActiv, gest_strucDesactiv});

        panneauFormsLayout.setVerticalGroup(
            panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panneauFormsLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(libeleProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idCatE))
                .addGap(18, 18, 18)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(gest_strucActiv)
                    .addComponent(gest_strucDesactiv)
                    .addComponent(gest_categorieDesactiv)
                    .addComponent(gest_categorieActiv))
                .addGap(18, 18, 18)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gest_fonctionDesactiv)
                        .addComponent(gest_fonctionActiv))
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(gest_emploiDesactiv)
                        .addComponent(gest_emploiActiv)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gest_ministereDesactiv)
                        .addComponent(gest_ministereActiv))
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)
                        .addComponent(gest_agentDesactiv)
                        .addComponent(gest_agentActiv)))
                .addGap(18, 18, 18)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gest_paramAvanceDesactiv)
                        .addComponent(gest_paramAvanceActiv))
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(gest_statDesactiv)
                        .addComponent(gest_statActiv)))
                .addGap(18, 18, 18)
                .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addGroup(panneauFormsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(gest_budgetDesactiv)
                        .addComponent(gest_budgetActiv)))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        panneauFormsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gest_agentActiv, gest_agentDesactiv, gest_budgetActiv, gest_budgetDesactiv, gest_emploiActiv, gest_emploiDesactiv, gest_statActiv, gest_statDesactiv, gest_strucActiv, gest_strucDesactiv});

        panneauFormsLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {gest_categorieActiv, gest_categorieDesactiv, gest_fonctionActiv, gest_fonctionDesactiv, gest_ministereActiv, gest_ministereDesactiv, gest_paramAvanceActiv, gest_paramAvanceDesactiv});

        tableau_profil.setAutoCreateRowSorter(true);
        tableau_profil.setFont(new java.awt.Font("Liberation Sans", 0, 16)); // NOI18N
        tableau_profil.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Profil", "Libélé Profil"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableau_profil.setSelectionBackground(new java.awt.Color(255, 153, 0));
        tableau_profil.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableau_profil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableau_profilMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableau_profil);
        if (tableau_profil.getColumnModel().getColumnCount() > 0) {
            tableau_profil.getColumnModel().getColumn(0).setMinWidth(0);
            tableau_profil.getColumnModel().getColumn(0).setPreferredWidth(0);
            tableau_profil.getColumnModel().getColumn(0).setMaxWidth(0);
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
                .addContainerGap(75, Short.MAX_VALUE))
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
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1306, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panneauPrincipalLayout.setVerticalGroup(
            panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panneauPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panneauForms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(panneauPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        libeleProf.setText("");
        reinitSelection();
    }//GEN-LAST:event_btn_nouveauActionPerformed

    private void btn_enregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_enregistrerActionPerformed
        enregistrerProfil();
        reinitSelection();
        listerProfil();
    }//GEN-LAST:event_btn_enregistrerActionPerformed

    private void btn_rafraichirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_rafraichirActionPerformed
        // TODO add your handling code here:
        listerProfil();
    }//GEN-LAST:event_btn_rafraichirActionPerformed

    private void formInternalFrameActivated(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameActivated
        // TODO add your handling code here:
        listerProfil();
        idCatE.setVisible(false);
    }//GEN-LAST:event_formInternalFrameActivated

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:

        JTableHeader header = tableau_profil.getTableHeader();
        header.setDefaultRenderer(new PropsTableau());
    }//GEN-LAST:event_formInternalFrameOpened

    private void tableau_profilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableau_profilMouseClicked
        // TODO add your handling code here:
        afficherProfil();
    }//GEN-LAST:event_tableau_profilMouseClicked

    private void btn_modifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modifierActionPerformed
        // TODO add your handling code here:
        modifierProfil();
        reinitSelection();
        listerProfil();
    }//GEN-LAST:event_btn_modifierActionPerformed

    private void btn_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_supprimerActionPerformed
        // TODO add your handling code here:
         supprimerProfil();
        reinitSelection();
        listerProfil();
    }//GEN-LAST:event_btn_supprimerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_enregistrer;
    private javax.swing.JButton btn_modifier;
    private javax.swing.JButton btn_nouveau;
    private javax.swing.JButton btn_rafraichir;
    private javax.swing.JButton btn_supprimer;
    public static javax.swing.JRadioButton gest_agentActiv;
    public static javax.swing.JRadioButton gest_agentDesactiv;
    public static javax.swing.JRadioButton gest_budgetActiv;
    public static javax.swing.JRadioButton gest_budgetDesactiv;
    public static javax.swing.JRadioButton gest_categorieActiv;
    public static javax.swing.JRadioButton gest_categorieDesactiv;
    public static javax.swing.JRadioButton gest_emploiActiv;
    public static javax.swing.JRadioButton gest_emploiDesactiv;
    public static javax.swing.JRadioButton gest_fonctionActiv;
    public static javax.swing.JRadioButton gest_fonctionDesactiv;
    public static javax.swing.JRadioButton gest_ministereActiv;
    public static javax.swing.JRadioButton gest_ministereDesactiv;
    public static javax.swing.JRadioButton gest_paramAvanceActiv;
    public static javax.swing.JRadioButton gest_paramAvanceDesactiv;
    public static javax.swing.JRadioButton gest_statActiv;
    public static javax.swing.JRadioButton gest_statDesactiv;
    public static javax.swing.JRadioButton gest_strucActiv;
    public static javax.swing.JRadioButton gest_strucDesactiv;
    public static javax.swing.JTextField idCatE;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField libeleProf;
    public static javax.swing.JPanel panneauForms;
    public static javax.swing.JPanel panneauPrincipal;
    public static javax.swing.JTable tableau_profil;
    // End of variables declaration//GEN-END:variables
}
