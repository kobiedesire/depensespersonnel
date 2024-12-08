/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class User {

    private int idU, idP;
    private String nomU, prenomU, userNameU, passwordU;

    public int getIdU() {
        return idU;
    }

    public void setIdU(int idU) {
        this.idU = idU;
    }

    public int getIdP() {
        return idP;
    }

    public void setIdP(int idP) {
        this.idP = idP;
    }

    public String getNomU() {
        return nomU;
    }

    public void setNomU(String nomU) {
        this.nomU = nomU;
    }

    public String getPrenomU() {
        return prenomU;
    }

    public void setPrenomU(String prenomU) {
        this.prenomU = prenomU;
    }

    public String getUserNameU() {
        return userNameU;
    }

    public void setUserNameU(String userNameU) {
        this.userNameU = userNameU;
    }

    public String getPasswordU() {
        return passwordU;
    }

    public void setPasswordU(String passwordU) {
        this.passwordU = passwordU;
    }

    public User(int idP, String nomU, String prenomU, String userNameU, String passwordU) {
        this.idP = idP;
        this.nomU = nomU;
        this.prenomU = prenomU;
        this.userNameU = userNameU;
        this.passwordU = passwordU;
    }

    public User() {
    }

    

}
