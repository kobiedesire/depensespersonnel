/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Action {
    private int idA, idP;
    private String codeA;
    private String libeleA;

    public int getIdA() {
        return idA;
    }

    public int getIdP() {
        return idP;
    }

    public String getCodeA() {
        return codeA;
    }

    public String getLibeleA() {
        return libeleA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public void setCodeA(String codeA) {
        this.codeA = codeA;
    }

    public void setLibeleA(String libeleA) {
        this.libeleA = libeleA;
    }

    public Action(int idP, String codeA, String libeleA) {
        this.idP = idP;
        this.codeA = codeA;
        this.libeleA = libeleA;
    }

    public Action() {
    }
    
    
    
    
    
}
