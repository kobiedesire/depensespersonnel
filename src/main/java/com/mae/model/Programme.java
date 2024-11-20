/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Programme {
    private int idP, idB;
    private String codeP;
    private String libeleP;

    public int getIdP() {
        return idP;
    }

    public int getIdB() {
        return idB;
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

    public void setIdB(int idB) {
        this.idB = idB;
    }

    public void setCodeP(String codeP) {
        this.codeP = codeP;
    }

    public void setLibeleP(String libeleP) {
        this.libeleP = libeleP;
    }

    public Programme(int idB, String codeP, String libeleP) {
        this.idB = idB;
        this.codeP = codeP;
        this.libeleP = libeleP;
    }

    public Programme() {
    }
        
}
