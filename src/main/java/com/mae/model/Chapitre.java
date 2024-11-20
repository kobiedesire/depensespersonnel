/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Chapitre {

    private int idC, idA;
    private String codeC;
    private String libeleC;

    public int getIdC() {
        return idC;
    }

    public int getIdA() {
        return idA;
    }

    public String getCodeC() {
        return codeC;
    }

    public String getLibeleC() {
        return libeleC;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public void setCodeC(String codeC) {
        this.codeC = codeC;
    }

    public void setLibeleC(String libeleC) {
        this.libeleC = libeleC;
    }

    public Chapitre(int idA, String codeC, String libeleC) {
        this.idA = idA;
        this.codeC = codeC;
        this.libeleC = libeleC;
    }

    public Chapitre() {
    }

}
