/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Structure {

    private int idS, idP;
    private String codeS, typeS;
    private String libeleS;

    public int getIdS() {
        return idS;
    }

    public String getCodeS() {
        return codeS;
    }

    public String getTypeS() {
        return typeS;
    }

    public String getLibeleS() {
        return libeleS;
    }

    public int getIdP() {
        return idP;
    }
    
    

    public void setIdS(int idS) {
        this.idS = idS;
    }

    public void setCodeS(String codeS) {
        this.codeS = codeS;
    }

    public void setTypeS(String typeS) {
        this.typeS = typeS;
    }

    public void setLibeleS(String libeleS) {
        this.libeleS = libeleS;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    
    public Structure() {
    }

    public Structure(int idP, String codeS, String typeS, String libeleS) {
        this.idP = idP;
        this.codeS = codeS;
        this.typeS = typeS;
        this.libeleS = libeleS;
    }  

}
