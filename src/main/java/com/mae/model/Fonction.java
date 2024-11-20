/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Fonction {
     private int idFonc;
    private String libeleFonc;

    public int getIdFonc() {
        return idFonc;
    }

    public String getLibeleFonc() {
        return libeleFonc;
    }

    public void setIdFonc(int idFonc) {
        this.idFonc = idFonc;
    }

    public void setLibeleFonc(String libeleFonc) {
        this.libeleFonc = libeleFonc;
    }

    public Fonction(String libeleFonc) {
        this.libeleFonc = libeleFonc;
    }

    public Fonction() {
    }
    
    
    
}
