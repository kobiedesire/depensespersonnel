/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Paragraphe {

    private int idP, idArt;
    private String codeP;
    private String libeleP;

    public int getIdP() {
        return idP;
    }

    public int getIdArt() {
        return idArt;
    }

    public String getCodeP() {
        return codeP;
    }

    public String getLibeleP() {
        return libeleP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }

    public void setCodeP(String codeP) {
        this.codeP = codeP;
    }

    public void setLibeleP(String libeleP) {
        this.libeleP = libeleP;
    }

    public Paragraphe(int idArt, String codeP, String libeleP) {
        this.idArt = idArt;
        this.codeP = codeP;
        this.libeleP = libeleP;
    }

    public Paragraphe() {
    }

}
