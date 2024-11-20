/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Ligne;
import com.mae.vue.InterfaceLigne;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class LigneController {

    private static boolean res, yn;
    private static String tab[][];

    //Charger la liste des programmes
    private static final String querySelectProgramme = "SELECT * FROM programme";

    public static void listInComboProgramme() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectProgramme)) {
            ResultSet res = preparedStatement.executeQuery();
            while (res.next()) {
                InterfaceLigne.comboProgramme.addItem(res.getString("codeProgramme"));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    }
    /**
     * ****************************************************************************************************************************************************************************************
     */
    //recuperation de l'id du programme selectionné et l'afficher  
    private static final String querySelectIDProgramme = "SELECT idProgramme FROM programme where codeProgramme = ? ";

    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDProgramme() {
        String codeProg = InterfaceLigne.comboProgramme.getSelectedItem().toString();
        if (codeProg.contentEquals(" ")) {
            InterfaceLigne.boxIDProgramme.setText("");
        } else {

            try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDProgramme)) {
                preparedStatement.setString(1, codeProg);
                ResultSet res = preparedStatement.executeQuery();
                if (res.next()) {
                    InterfaceLigne.boxIDProgramme.setText(res.getString("idProgramme"));
                    //System.out.println(res.getString("idBudget"));
                }
                preparedStatement.close();
                res.close();
                connection.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erreur SQL");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
            }
        }
    }

    //Remplir le combo de la liste des action en fonction du programme selectionné    
    private static final String querySelectAction = "SELECT codeAction FROM action  WHERE idProgramme = ?";
    public static int idP;

    public static void listInComboAction() {

        String codeProg = InterfaceLigne.comboProgramme.getSelectedItem().toString();
        if (codeProg.contentEquals(" ")) {
            InterfaceLigne.comboAction.removeAllItems();
            InterfaceLigne.comboAction.addItem(" ");

        } else {
            String idp = InterfaceLigne.boxIDProgramme.getText();
            if (idp.isBlank()) {
                //InterfaceLigne.comboAction.setSelectedIndex(0);
                InterfaceLigne.comboAction.removeAllItems();
                InterfaceLigne.comboAction.addItem(" ");

            } else {
                InterfaceLigne.comboAction.removeAllItems();
                idP = Integer.parseInt(InterfaceLigne.boxIDProgramme.getText());
                try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectAction)) {
                    preparedStatement.setInt(1, idP);
                    ResultSet res1 = preparedStatement.executeQuery();
                    InterfaceLigne.comboAction.addItem(" ");
                    while (res1.next()) {
                        InterfaceLigne.comboAction.addItem(res1.getString("codeAction"));
                        //System.out.println(res1.getString("codeAction"));
                    }
                    res1.close();
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                }

            }

        }
    }

    /**
     * ****************************************************************************************************************************************************************************************
     */
    //recuperation de l'id de l'action  selectionnée et l'afficher  
    private static final String querySelectIDAction = "SELECT idAction FROM action where codeAction = ? ";

    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDAction() {
        Object selectedItem = InterfaceLigne.comboAction.getSelectedItem();
        if (selectedItem != null) {
            // String selectedValue = selectedItem.toString();
            //System.out.println("Valeur sélectionnée : " + selectedValue);
            String codeAct = InterfaceLigne.comboAction.getSelectedItem().toString();
            if (codeAct.contentEquals(" ")) {
                InterfaceLigne.boxIDAction.setText("");
            } else {

                try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDAction)) {
                    preparedStatement.setString(1, codeAct);
                    ResultSet res = preparedStatement.executeQuery();
                    if (res.next()) {
                        InterfaceLigne.boxIDAction.setText(res.getString("idAction"));
                        //System.out.println(res.getString("idBudget"));
                    }
                    preparedStatement.close();
                    res.close();
                    connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                }
            }
        }

    }

    //Remplir le combo de la liste des chapitres en fonction de l'action sélectionnée     
    private static final String querySelectChapitre = "SELECT codeChapitre FROM chapitre  WHERE idAction = ?";
    public static int idChap;

    public static void listInComboChapitre() {
        Object selectedItem = InterfaceLigne.comboAction.getSelectedItem();
        if (selectedItem != null) {
            String codeProg = InterfaceLigne.comboAction.getSelectedItem().toString();
            if (codeProg.contentEquals(" ")) {
                InterfaceLigne.comboChapitre.removeAllItems();
                InterfaceLigne.comboChapitre.addItem(" ");

            } else {
                String idp = InterfaceLigne.boxIDAction.getText();
                if (idp.isBlank()) {
                    //InterfaceLigne.comboAction.setSelectedIndex(0);
                    InterfaceLigne.comboChapitre.removeAllItems();
                    InterfaceLigne.comboChapitre.addItem(" ");

                } else {
                    InterfaceLigne.comboChapitre.removeAllItems();
                    idChap = Integer.parseInt(InterfaceLigne.boxIDAction.getText());
                    try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectChapitre)) {
                        preparedStatement.setInt(1, idChap);
                        ResultSet res1 = preparedStatement.executeQuery();
                        InterfaceLigne.comboChapitre.addItem(" ");
                        while (res1.next()) {
                            InterfaceLigne.comboChapitre.addItem(res1.getString("codeChapitre"));
                            //System.out.println(res1.getString("codeAction"));
                        }
                        res1.close();
                        preparedStatement.close();
                        connection.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Erreur SQL");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                    }

                }

            }
        }
    }

    /**
     * ****************************************************************************************************************************************************************************************
     */
    //recuperation de l'id du chapitre selectionnée et l'afficher  
    private static final String querySelectIDChapitre = "SELECT idChapitre FROM chapitre where codeChapitre = ? ";

    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDChapitre() {
        Object selectedItem = InterfaceLigne.comboChapitre.getSelectedItem();
        if (selectedItem != null) {
            // String selectedValue = selectedItem.toString();
            //System.out.println("Valeur sélectionnée : " + selectedValue);
            String codeAct = InterfaceLigne.comboChapitre.getSelectedItem().toString();
            if (codeAct.contentEquals(" ")) {
                InterfaceLigne.boxIDChapitre.setText("");
            } else {

                try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDChapitre)) {
                    preparedStatement.setString(1, codeAct);
                    ResultSet res = preparedStatement.executeQuery();
                    if (res.next()) {
                        InterfaceLigne.boxIDChapitre.setText(res.getString("idChapitre"));
                        //System.out.println(res.getString("idBudget"));
                    }
                    preparedStatement.close();
                    res.close();
                    connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                }
            }
        }

    }

    //Remplir le combo de la liste des activités en fonction du chapitre sélectionné   
    private static final String querySelectActivite = "SELECT codeActivite FROM activite  WHERE idChapitre = ?";
    public static int idActiv;

    public static void listInComboActivite() {
        Object selectedItem = InterfaceLigne.comboChapitre.getSelectedItem();
        if (selectedItem != null) {
            String codeProg = InterfaceLigne.comboChapitre.getSelectedItem().toString();
            if (codeProg.contentEquals(" ")) {
                InterfaceLigne.comboActivite.removeAllItems();
                InterfaceLigne.comboActivite.addItem(" ");

            } else {
                String idp = InterfaceLigne.boxIDChapitre.getText();
                if (idp.isBlank()) {
                    //InterfaceLigne.comboAction.setSelectedIndex(0);
                    InterfaceLigne.comboActivite.removeAllItems();
                    InterfaceLigne.comboActivite.addItem(" ");

                } else {
                    InterfaceLigne.comboActivite.removeAllItems();
                    idActiv = Integer.parseInt(InterfaceLigne.boxIDChapitre.getText());
                    try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectActivite)) {
                        preparedStatement.setInt(1, idActiv);
                        ResultSet res1 = preparedStatement.executeQuery();
                        InterfaceLigne.comboActivite.addItem(" ");
                        while (res1.next()) {
                            InterfaceLigne.comboActivite.addItem(res1.getString("codeActivite"));
                            //System.out.println(res1.getString("codeAction"));
                        }
                        res1.close();
                        preparedStatement.close();
                        connection.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Erreur SQL");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                    }

                }

            }
        }
    }

    /**
     * ****************************************************************************************************************************************************************************************
     */
    //recuperation de l'id de l'activité selectionnée et l'afficher  
    private static final String querySelectIDActivite = "SELECT idActivite FROM activite where codeActivite = ? ";

    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDActivite() {
        Object selectedItem = InterfaceLigne.comboActivite.getSelectedItem();
        if (selectedItem != null) {
            // String selectedValue = selectedItem.toString();
            //System.out.println("Valeur sélectionnée : " + selectedValue);
            String codeAct = InterfaceLigne.comboActivite.getSelectedItem().toString();
            if (codeAct.contentEquals(" ")) {
                InterfaceLigne.boxIDActivite.setText("");
            } else {

                try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDActivite)) {
                    preparedStatement.setString(1, codeAct);
                    ResultSet res = preparedStatement.executeQuery();
                    if (res.next()) {
                        InterfaceLigne.boxIDActivite.setText(res.getString("idActivite"));
                        //System.out.println(res.getString("idBudget"));
                    }
                    preparedStatement.close();
                    res.close();
                    connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                }
            }
        }

    }

    //Remplir le combo de la liste des articles en fonction de l'activite sélectionnée 
    private static final String querySelectArticle = "SELECT codeArticle  FROM article  WHERE idActivite  = ?";
    public static int idArti;

    public static void listInComboArticle() {
        Object selectedItem = InterfaceLigne.comboActivite.getSelectedItem();
        if (selectedItem != null) {
            String codeProg = InterfaceLigne.comboActivite.getSelectedItem().toString();
            if (codeProg.contentEquals(" ")) {
                InterfaceLigne.comboArticle.removeAllItems();
                InterfaceLigne.comboArticle.addItem(" ");

            } else {
                String idp = InterfaceLigne.boxIDActivite.getText();
                if (idp.isBlank()) {
                    //InterfaceLigne.comboAction.setSelectedIndex(0);
                    InterfaceLigne.comboArticle.removeAllItems();
                    InterfaceLigne.comboArticle.addItem(" ");

                } else {
                    InterfaceLigne.comboArticle.removeAllItems();
                    idArti = Integer.parseInt(InterfaceLigne.boxIDActivite.getText());
                    try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectArticle)) {
                        preparedStatement.setInt(1, idArti);
                        ResultSet res1 = preparedStatement.executeQuery();
                        InterfaceLigne.comboArticle.addItem(" ");
                        while (res1.next()) {
                            InterfaceLigne.comboArticle.addItem(res1.getString("codeArticle"));
                            //System.out.println(res1.getString("codeAction"));
                        }
                        res1.close();
                        preparedStatement.close();
                        connection.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Erreur SQL");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                    }

                }

            }
        }
    }
    
    /**
     * ****************************************************************************************************************************************************************************************
     */
    //recuperation de l'id de l'artcile selectionnée et l'afficher  
    private static final String querySelectIDArticle = "SELECT idArticle FROM article where codeArticle = ? ";

    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDArticle() {
        Object selectedItem = InterfaceLigne.comboArticle.getSelectedItem();
        if (selectedItem != null) {
            // String selectedValue = selectedItem.toString();
            //System.out.println("Valeur sélectionnée : " + selectedValue);
            String codeAct = InterfaceLigne.comboArticle.getSelectedItem().toString();
            if (codeAct.contentEquals(" ")) {
                InterfaceLigne.boxIDArticle.setText("");
            } else {

                try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDArticle)) {
                    preparedStatement.setString(1, codeAct);
                    ResultSet res = preparedStatement.executeQuery();
                    if (res.next()) {
                        InterfaceLigne.boxIDArticle.setText(res.getString("idArticle"));
                        //System.out.println(res.getString("idBudget"));
                    }
                    preparedStatement.close();
                    res.close();
                    connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                }
            }
        }

    }

    //Remplir le combo de la liste des paragraphes en fonction de l'article sélectionnée 
    private static final String querySelectParagraphe = "SELECT codeParagraphe  FROM paragraphe WHERE idArticle  = ?";
    public static int idPara;

    public static void listInComboParagraphe() {
        Object selectedItem = InterfaceLigne.comboActivite.getSelectedItem();
        if (selectedItem != null) {
            String codeProg = InterfaceLigne.comboActivite.getSelectedItem().toString();
            if (codeProg.contentEquals(" ")) {
                InterfaceLigne.comboParagraphe.removeAllItems();
                InterfaceLigne.comboParagraphe.addItem(" ");

            } else {
                String idp = InterfaceLigne.boxIDArticle.getText();
                if (idp.isBlank()) {
                    //InterfaceLigne.comboAction.setSelectedIndex(0);
                    InterfaceLigne.comboParagraphe.removeAllItems();
                    InterfaceLigne.comboParagraphe.addItem(" ");

                } else {
                    InterfaceLigne.comboParagraphe.removeAllItems();
                    idPara = Integer.parseInt(InterfaceLigne.boxIDArticle.getText());
                    try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectParagraphe)) {
                        preparedStatement.setInt(1, idPara);
                        ResultSet res1 = preparedStatement.executeQuery();
                        InterfaceLigne.comboParagraphe.addItem(" ");
                        while (res1.next()) {
                            InterfaceLigne.comboParagraphe.addItem(res1.getString("codeParagraphe"));
                            //System.out.println(res1.getString("codeAction"));
                        }
                        res1.close();
                        preparedStatement.close();
                        connection.close();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Erreur SQL");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                    }

                }

            }
        }
    }
    
    
    
  /**
     * ****************************************************************************************************************************************************************************************
     */
    //recuperation de l'id de du paragraphe selectionnée et l'afficher  
    private static final String querySelectIDParagraphe = "SELECT idParagraphe FROM paragraphe where codeParagraphe = ? ";

    // public static int exercice = Integer.parseInt(InterfaceProgramme.exerciceBu.getSelectedItem().toString());
    public static void afficherIDParagraphe() {
        Object selectedItem = InterfaceLigne.comboParagraphe.getSelectedItem();
        if (selectedItem != null) {
            
            String codeAct = InterfaceLigne.comboParagraphe.getSelectedItem().toString();
            if (codeAct.contentEquals(" ")) {
                InterfaceLigne.boxIDParagraphe.setText("");
            } else {

                try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectIDParagraphe)) {
                    preparedStatement.setString(1, codeAct);
                    ResultSet res = preparedStatement.executeQuery();
                    if (res.next()) {
                        InterfaceLigne.boxIDParagraphe.setText(res.getString("idParagraphe"));
                       
                    }
                    preparedStatement.close();
                    res.close();
                    connection.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "Erreur SQL");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
                }
            }
        }

    }   
    

    /*Enregistrer une ligne budgétaire*/
    private static final String queryInsert = "INSERT INTO ligne(codeLigne, idProgramme, idAction , idChapitre, idActivite, idArticle, idParagraphe, montantLigne) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    public static void saveLigne(Ligne ligne) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {
            preparedStatement.setString(1, ligne.getCodeLigne());
            preparedStatement.setInt(2, ligne.getIdProg());
            preparedStatement.setInt(3, ligne.getIdAct());
            preparedStatement.setInt(4, ligne.getIdChap());
            preparedStatement.setInt(5, ligne.getIdActivi());
            preparedStatement.setInt(6, ligne.getIdArti());
            preparedStatement.setInt(7, ligne.getIdPara());
            preparedStatement.setLong(8, ligne.getMontant());
            // preparedStatement.executeUpdate();
            int enregistrementValide = preparedStatement.executeUpdate();
            if (enregistrementValide > 0) {
                JOptionPane.showMessageDialog(null, "Ajout de ligne réussie");
                preparedStatement.close();
                connection.close();
            }

        } catch (SQLException e) {
            //  e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erreur SQL" + e.getMessage());

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques" + e.getMessage());
        }
    }

    /*Lister toutes les lignes*/
 /*private static final String querySelect = "SELECT * FROM ligne l, programme p, action a, chapitre c, activite act, article ar, paragraphe para WHERE "
         + "l.idProgramme = p.idProgramme AND l.idAction = a.idAction AND l.idChapitre = c.idChapitre AND l.idActivite = act.idActivite AND l.idArticle = ar.idArticle"
         + "AND l.idParagraphe = para.idParagraphe";*/
    private static final String querySelect = "SELECT * FROM ligne l, programme p, action a, chapitre c, activite act, article ar, paragraphe para WHERE "
         + "l.idProgramme = p.idProgramme AND l.idAction = a.idAction AND l.idChapitre = c.idChapitre AND l.idActivite = act.idActivite AND l.idArticle = ar.idArticle AND l.idParagraphe = para.idParagraphe";
    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][9];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceLigne.tableau_ligne.getModel();
            while (InterfaceLigne.tableau_ligne.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (String[] tab1 : tab) {
                res.next();
                Object[] objects = new Object[9];
                objects[0] = res.getString("l.idLigne");
                objects[1] = res.getString("l.codeLigne");
                objects[2] = res.getString("p.codeProgramme");
                objects[3] = res.getString("a.codeAction");
               objects[4] = res.getString("c.codeChapitre");
                objects[5] = res.getString("act.codeActivite");
                objects[6] = res.getString("ar.codeArticle");
                objects[7] = res.getString("para.codeParagraphe");
                objects[8] = res.getString("montantLigne");

                tablemodel.addRow(objects);
                tab1[0] = res.getString("l.idLigne");
                tab1[1] = res.getString("l.codeLigne");
                tab1[2] = res.getString("p.codeProgramme");
                tab1[3] = res.getString("a.codeAction");
                tab1[4] = res.getString("c.codeChapitre");
                tab1[5] = res.getString("act.codeActivite");
                tab1[6] = res.getString("ar.codeArticle");
                tab1[7] = res.getString("para.codeParagraphe");
                tab1[8] = res.getString("montantLigne");
                yn = true;
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    }

    // Afficher une Programme
    /* public static int nbreligne, numligne, idArti;
    private static final String querySelectOneParagraphe = "SELECT * FROM article a , paragraphe p where p.idParagraphe = ? AND a.idArticle = p.idArticle ";

    public static void displayParagraphe() {
        nbreligne = InterfaceParagraphe.tableau_paragraphe.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceParagraphe.tableau_paragraphe.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceParagraphe.articleBug.setSelectedIndex(0);
            InterfaceParagraphe.codeParagraphe.setText("");
            InterfaceParagraphe.libeleParagraphe.setText("");
            JOptionPane.showMessageDialog(null, "Sélectionnez un article");
            //System.out.println(nbreligne);
        } else {
            idArti = Integer.parseInt(InterfaceParagraphe.tableau_paragraphe.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneParagraphe)) {
            preparedStatement.setInt(1, idArti);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceParagraphe.articleBug.setSelectedItem(res.getString("a.codeArticle"));
                InterfaceParagraphe.codeParagraphe.setText(res.getString("p.codeParagraphe"));
                InterfaceParagraphe.libeleParagraphe.setText(res.getString("p.libeleParagraphe"));
            }
            res.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    }

    //Modifier une Programme
    public static void updateParagraphe(Paragraphe paragraphe) {
        idArti = Integer.parseInt(InterfaceParagraphe.tableau_paragraphe.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE paragraphe SET  idArticle = ?, codeParagraphe= ?, libeleParagraphe = ? WHERE idParagraphe = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setInt(1, paragraphe.getIdArt());
            preparedStatement.setString(2, paragraphe.getCodeP());
            preparedStatement.setString(3, paragraphe.getLibeleP());
            preparedStatement.setInt(4, idArti);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }*/
 public static int idLig,numligne, nbreligne  ;
 
    public static void deleteLigne(Ligne ligne) {
        nbreligne = InterfaceLigne.tableau_ligne.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceLigne.tableau_ligne.getSelectedRow();//recuperer le le numero de la ligne
        idLig = Integer.parseInt(InterfaceLigne.tableau_ligne.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM ligne WHERE idLigne = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idLig);
            preparedStatement.executeUpdate();           
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }
    }
     
}
