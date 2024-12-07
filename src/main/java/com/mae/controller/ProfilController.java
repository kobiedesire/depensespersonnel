/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.controller;

import com.mae.bd.connexionBD;
import com.mae.model.Profil;
import com.mae.vue.InterfaceProfil;
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
public class ProfilController {

    private static boolean res, yn;
    private static String tab[][];

    /*Enregistrer un Programme*/
    private static final String queryInsert = "INSERT INTO profil (libeleProfil, permitGestStructure, permitGestCategorie, permitGestEmploi, permitGestFonction, permitGestMinistere, permitGestAgent, permitGestBudget,permitGestStatistique, permitGestParamAvance) VALUES (?,?,?,?,?,?,?,?,?,?)";

    public static void saveProfil(Profil profil) {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryInsert)) {           
            preparedStatement.setString(1, profil.getLibeleR());
            preparedStatement.setString(2, profil.getPermitGestStructure());
            preparedStatement.setString(3, profil.getPermitGestCategorie());
            preparedStatement.setString(4, profil.getPermitGestEmploi());
            preparedStatement.setString(5, profil.getPermitGestFonction());
            preparedStatement.setString(6, profil.getPermitGestMinistere());
            preparedStatement.setString(7, profil.getPermitGestAgent());
            preparedStatement.setString(8, profil.getPermitGestBudget());
            preparedStatement.setString(9, profil.getPermitGestStatistique());
            preparedStatement.setString(10, profil.getPermitGestParamAvance());

            // preparedStatement.executeUpdate();
            int enregistrementValide = preparedStatement.executeUpdate();
            if (enregistrementValide > 0) {
                JOptionPane.showMessageDialog(null, "Enregistrement validé");
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

    /*Lister toutes les Programmes*/
    private static final String querySelect = "SELECT * FROM profil ";
    public static void listAll() {
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelect)) {
            ResultSet res = preparedStatement.executeQuery();
            res.last();
            tab = new String[res.getRow()][2];
            res.beforeFirst();
            yn = false;
            DefaultTableModel tablemodel = (DefaultTableModel) InterfaceProfil.tableau_profil.getModel();
            while (InterfaceProfil.tableau_profil.getRowCount() > 0) {
                tablemodel.removeRow(0);
            }
            for (int k = 0; k < tab.length; k++) {
                res.next();
                Object[] objects = new Object[2];
                objects[0] = res.getString("idProfil");
                objects[1] = res.getString("libeleProfil");                
                tablemodel.addRow(objects);
                tab[k][0] = res.getString("idProfil");
                tab[k][1] = res.getString("libeleProfil");              
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
    public static int nbreligne, numligne, idP;
    private static final String querySelectOneProfil = "SELECT * FROM profil WHERE idProfil = ?  ";

    public static void displayProfil() {
        nbreligne = InterfaceProfil.tableau_profil.getSelectedRowCount();//nombre de ligne selectionnÃ©es
        numligne = InterfaceProfil.tableau_profil.getSelectedRow();//recuperer le le numero de la ligne
        if (nbreligne != 1) {
            InterfaceProfil.libeleProf.setText("");
            InterfaceProfil.reinitSelection();
            JOptionPane.showMessageDialog(null, " Sélectionnez un profil");
            //System.out.println(nbreligne);
        } else {
            idP = Integer.parseInt(InterfaceProfil.tableau_profil.getValueAt(numligne, 0).toString());   //recuperer l'id       
        }
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(querySelectOneProfil)) {
            preparedStatement.setInt(1, idP);
            ResultSet res = preparedStatement.executeQuery();
            if (res.next()) {
                InterfaceProfil.libeleProf.setText(res.getString("libeleProfil"));
                //Selection des valeurs 
                if (res.getString("permitGestStructure").equals("1")) {
                    InterfaceProfil.gest_strucActiv.setSelected(true);
                } else {
                    InterfaceProfil.gest_strucDesactiv.setSelected(true);
                }

                //
                if (res.getString("permitGestCategorie").equals("1")) {
                    InterfaceProfil.gest_categorieActiv.setSelected(true);
                } else {
                    InterfaceProfil.gest_categorieDesactiv.setSelected(true);
                }
                //
                if (res.getString("permitGestEmploi").equals("1")) {
                InterfaceProfil.gest_emploiActiv.setSelected(true);
                } else {
                    InterfaceProfil.gest_emploiDesactiv.setSelected(true);
                }
                //
                if (res.getString("permitGestFonction").equals("1")) {
                    InterfaceProfil.gest_fonctionActiv.setSelected(true);
                } else {
                    InterfaceProfil.gest_fonctionDesactiv.setSelected(true);
                }
                //
                if (res.getString("permitGestMinistere").equals("1")) {
                    InterfaceProfil.gest_ministereActiv.setSelected(true);
                } else {
                    InterfaceProfil.gest_ministereDesactiv.setSelected(true);
                }
                //
                if (res.getString("permitGestAgent").equals("1")) {
                    InterfaceProfil.gest_agentActiv.setSelected(true);
                } else {
                    InterfaceProfil.gest_agentDesactiv.setSelected(true);
                }
                //
                if (res.getString("permitGestBudget").equals("1")) {
                    InterfaceProfil.gest_budgetActiv.setSelected(true);
                } else {
                    InterfaceProfil.gest_budgetDesactiv.setSelected(true);
                }
                 //
                if (res.getString("permitGestStatistique").equals("1")) {
                    InterfaceProfil.gest_statActiv.setSelected(true);
                } else {
                    InterfaceProfil.gest_statDesactiv.setSelected(true);
                }
                 //
                if (res.getString("permitGestParamAvance").equals("1")) {
                    InterfaceProfil.gest_paramAvanceActiv.setSelected(true);
                } else {
                    InterfaceProfil.gest_paramAvanceDesactiv.setSelected(true);
                }

        }
        res.close();
        preparedStatement.close();
        connection.close();
    }
    catch (SQLException e

    
        ) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
    }
    catch (NumberFormatException e

    
        ) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
    }
}
    
    public static void updateProfil(Profil profil) {
        idP = Integer.parseInt(InterfaceProfil.tableau_profil.getValueAt(numligne, 0).toString());   //recuperer l'id 
        String queryUpdate = "UPDATE profil SET  libeleProfil = ?,  permitGestStructure = ?, permitGestCategorie = ?, permitGestEmploi = ?, permitGestFonction = ?, "
                + "permitGestMinistere = ?, permitGestAgent = ?, permitGestBudget = ?,permitGestStatistique = ?, permitGestParamAvance = ? WHERE idProfil = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryUpdate)) {
            preparedStatement.setString(1, profil.getLibeleR());
            preparedStatement.setString(2, profil.getPermitGestStructure());
            preparedStatement.setString(3, profil.getPermitGestCategorie());
            preparedStatement.setString(4, profil.getPermitGestEmploi());
            preparedStatement.setString(5, profil.getPermitGestFonction());
            preparedStatement.setString(6, profil.getPermitGestMinistere());
            preparedStatement.setString(7, profil.getPermitGestAgent());
            preparedStatement.setString(8, profil.getPermitGestBudget());
            preparedStatement.setString(9, profil.getPermitGestStatistique());
            preparedStatement.setString(10, profil.getPermitGestParamAvance());           
            preparedStatement.setInt(11, idP);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Attention aux champs numériques");
        }

    }

//Modifier une Programme
 

    public static void deleteProfil(Profil profil) {
        idP = Integer.parseInt(InterfaceProfil.tableau_profil.getValueAt(numligne, 0).toString());   //recuperer l'id   
        String queryDelete = "DELETE FROM profil WHERE idProfil = ?";
        try (Connection connection = connexionBD.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(queryDelete)) {
            preparedStatement.setInt(1, idP);
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
