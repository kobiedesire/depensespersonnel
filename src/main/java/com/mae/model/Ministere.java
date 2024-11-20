/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Ministere {

    private int idMin;
    private String codeMin, libeleMin;

    public int getIdMin() {
        return idMin;
    }

    public String getCodeMin() {
        return codeMin;
    }

    public String getLibeleMin() {
        return libeleMin;
    }

    public void setIdMin(int idMin) {
        this.idMin = idMin;
    }

    public void setCodeMin(String codeMin) {
        this.codeMin = codeMin;
    }

    public void setLibeleMin(String libeleMin) {
        this.libeleMin = libeleMin;
    }

    public Ministere(String codeMin, String libeleMin) {
        this.codeMin = codeMin;
        this.libeleMin = libeleMin;
    }

    public Ministere() {
    }

}
