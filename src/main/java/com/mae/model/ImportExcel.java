/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class ImportExcel {
    private int idA ;
    private String matriculeA, nomA, prenomA;
    
   

    public ImportExcel() {
    }

    public int getIdA() {
        return idA;
    }

    public String getMatriculeA() {
        return matriculeA;
    }

    public String getNomA() {
        return nomA;
    }

    public String getPrenomA() {
        return prenomA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public void setMatriculeA(String matriculeA) {
        this.matriculeA = matriculeA;
    }

    public void setNomA(String nomA) {
        this.nomA = nomA;
    }

    public void setPrenomA(String prenomA) {
        this.prenomA = prenomA;
    }

    public ImportExcel(String matriculeA, String nomA, String prenomA) {
        this.matriculeA = matriculeA;
        this.nomA = nomA;
        this.prenomA = prenomA;
    }
       
}
