/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.bd;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author kobie
 */
public class connexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/base_depensespersonnel";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    /**
     * Établit une connexion à la base de données MySQL.
     * 
     * @return Connection objet représentant la connexion à la base de données
     * @throws SQLException si une erreur survient lors de la connexion
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Connexion établie avec succès !");
            }
        } catch (SQLException e) {
            {
       JOptionPane.showMessageDialog(null,"Erreur de connexion à la base de données");        
     }      
        }
        
    }
    }
