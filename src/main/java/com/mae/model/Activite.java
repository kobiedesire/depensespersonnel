/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Activite {

    private int idC, idA;
    private String codeA;
    private String libeleA;

    public int getIdC() {
        return idC;
    }

    public int getIdA() {
        return idA;
    }

    public String getCodeA() {
        return codeA;
    }

    public String getLibeleA() {
        return libeleA;
    }

    public void setIdC(int idC) {
        this.idC = idC;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public void setCodeA(String codeA) {
        this.codeA = codeA;
    }

    public void setLibeleA(String libeleA) {
        this.libeleA = libeleA;
    }

    public Activite() {
    }

    public Activite(int idC, String codeA, String libeleA) {
        this.idC = idC;
        this.codeA = codeA;
        this.libeleA = libeleA;
    }

}
