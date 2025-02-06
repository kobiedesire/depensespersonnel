/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import com.mae.vue.InterfaceConnexion;
import com.mae.vue.InterfaceAcceuil;

/**
 *
 * @author kobie
 */
public class connexionBD {

    // private static final String URL = "jdbc:mysql://192.168.100.252:3306/base_depensespersonnel";
    // private static final String USER = "dsi";
    // private static final String PASSWORD = "mae@1960";
    private static String URL = "null";
    private static String USER = "null";
    private static String PASSWORD = "null";

    /**
     * Établit une connexion à la base de données MySQL.
     *
     * @return Connection objet représentant la connexion à la base de données
     * @throws SQLException si une erreur survient lors de la connexion
     */
    /* public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Connexion établie avec succès !");
            }
        } catch (SQLException e) {
            {
                JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
            }
        }

    }*/
    public static Connection getConnection() throws SQLException {
        Properties properties = new Properties();
        Connection connection = null;
        try {
            int exBdugetaire = Integer.parseInt(InterfaceConnexion.exercice.getSelectedItem().toString());
            switch (exBdugetaire) {
                case 2025:
                    // Charger le fichier de configuration
                    FileInputStream fis = new FileInputStream("2025config.properties");
                    properties.load(fis);
                    
                    break;

                case 2026:
                    JOptionPane.showMessageDialog(null, "Connexion à la base de données impossible ou base de données inexistante");
                    break;

                case 2027:
                    JOptionPane.showMessageDialog(null, "Connexion à la base de données impossible ou base de données inexistante");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Connexion à la base de données impossible ou base de données inexistante");
                    break;
            }
            // Charger le fichier de configuration
            //  FileInputStream fis = new FileInputStream("2025config.properties");
            //properties.load(fis);

            // Récupérer les informations
            String host = properties.getProperty("db.host");
            String port = properties.getProperty("db.port");
            String dbName = properties.getProperty("db.name");
            USER = properties.getProperty("db.user");
            PASSWORD = properties.getProperty("db.password");

            // Construire l'URL de connexion
            URL = "jdbc:mysql://" + host + ":" + port + "/" + dbName + "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=Europe/Paris";

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la lecture du fichier de configuration : " + e.getMessage());
            //System.err.println("Erreur lors de la lecture du fichier de configuration : " + e.getMessage());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données : " + e.getMessage());
            // System.err.println("Erreur de connexion à la base de données : " + e.getMessage());
        }

        //return DriverManager.getConnection(URL, USER, PASSWORD);
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Connexion établie avec succès !");
            }
        } catch (SQLException e) {
            {
                JOptionPane.showMessageDialog(null, "Erreur de connexion à la base de données");
            }
        }
    }
}
