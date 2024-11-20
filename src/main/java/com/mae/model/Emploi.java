/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Emploi {
    private int idEmpl;
    private String codeEmpl, libleEmpl;

    public int getIdEmpl() {
        return idEmpl;
    }

    public String getCodeEmpl() {
        return codeEmpl;
    }

    public String getLibleEmpl() {
        return libleEmpl;
    }

    public void setIdEmpl(int idEmpl) {
        this.idEmpl = idEmpl;
    }

    public void setCodeEmpl(String codeEmpl) {
        this.codeEmpl = codeEmpl;
    }

    public void setLibleEmpl(String libleEmpl) {
        this.libleEmpl = libleEmpl;
    }

    public Emploi(String codeEmpl, String libleEmpl) {
        this.codeEmpl = codeEmpl;
        this.libleEmpl = libleEmpl;
    }

    public Emploi() {
    }
    
    
    
}
