/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Profil {
    private int idR;
    private String libeleR;
    private String permitGestStructure, permitGestCategorie, permitGestEmploi, permitGestFonction, permitGestMinistere, permitGestAgent;
    private String permitGestBudget, permitGestStatistique, permitGestParamAvance;

    public int getIdR() {
        return idR;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getLibeleR() {
        return libeleR;
    }

    public void setLibeleR(String libeleR) {
        this.libeleR = libeleR;
    }

    public String getPermitGestStructure() {
        return permitGestStructure;
    }

    public void setPermitGestStructure(String permitGestStructure) {
        this.permitGestStructure = permitGestStructure;
    }

    public String getPermitGestCategorie() {
        return permitGestCategorie;
    }

    public void setPermitGestCategorie(String permitGestCategorie) {
        this.permitGestCategorie = permitGestCategorie;
    }

    public String getPermitGestEmploi() {
        return permitGestEmploi;
    }

    public void setPermitGestEmploi(String permitGestEmploi) {
        this.permitGestEmploi = permitGestEmploi;
    }

    public String getPermitGestFonction() {
        return permitGestFonction;
    }

    public void setPermitGestFonction(String permitGestFonction) {
        this.permitGestFonction = permitGestFonction;
    }

    public String getPermitGestMinistere() {
        return permitGestMinistere;
    }

    public void setPermitGestMinistere(String permitGestMinistere) {
        this.permitGestMinistere = permitGestMinistere;
    }

    public String getPermitGestAgent() {
        return permitGestAgent;
    }

    public void setPermitGestAgent(String permitGestAgent) {
        this.permitGestAgent = permitGestAgent;
    }

    public String getPermitGestBudget() {
        return permitGestBudget;
    }

    public void setPermitGestBudget(String permitGestBudget) {
        this.permitGestBudget = permitGestBudget;
    }

    public String getPermitGestStatistique() {
        return permitGestStatistique;
    }

    public void setPermitGestStatistique(String permitGestStatistique) {
        this.permitGestStatistique = permitGestStatistique;
    }

    public String getPermitGestParamAvance() {
        return permitGestParamAvance;
    }

    public void setPermitGestParamAvance(String permitGestParamAvance) {
        this.permitGestParamAvance = permitGestParamAvance;
    }

    public Profil(String libeleR, String permitGestStructure, String permitGestCategorie, String permitGestEmploi, String permitGestFonction, String permitGestMinistere, String permitGestAgent, String permitGestBudget, String permitGestStatistique, String permitGestParamAvance) {
        this.libeleR = libeleR;
        this.permitGestStructure = permitGestStructure;
        this.permitGestCategorie = permitGestCategorie;
        this.permitGestEmploi = permitGestEmploi;
        this.permitGestFonction = permitGestFonction;
        this.permitGestMinistere = permitGestMinistere;
        this.permitGestAgent = permitGestAgent;
        this.permitGestBudget = permitGestBudget;
        this.permitGestStatistique = permitGestStatistique;
        this.permitGestParamAvance = permitGestParamAvance;
    }

    public Profil() {
    }

   
    
    
}
