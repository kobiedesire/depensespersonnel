/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class CategorieEchelle {
    private int idCatEch;
    private String codeCatEch;

    public int getIdCatEch() {
        return idCatEch;
    }

    public String getCodeCatEch() {
        return codeCatEch;
    }

    public void setIdCatEch(int idCatEch) {
        this.idCatEch = idCatEch;
    }

    public void setCodeCatEch(String codeCatEch) {
        this.codeCatEch = codeCatEch;
    }

    public CategorieEchelle(String codeCatEch) {
        this.codeCatEch = codeCatEch;
    }

    public CategorieEchelle() {
    }
    
    
    
}
