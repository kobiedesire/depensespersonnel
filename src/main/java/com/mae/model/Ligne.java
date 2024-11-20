/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Ligne {

    private int idL, idProg, idAct, idChap, idActivi, idArti, idPara;
    private Long montant;
    private String codeLigne;

    public String getCodeLigne() {
        return codeLigne;
    }

    
    
    public int getIdL() {
        return idL;
    }

    public int getIdProg() {
        return idProg;
    }

    public int getIdAct() {
        return idAct;
    }

    public int getIdChap() {
        return idChap;
    }

    public int getIdActivi() {
        return idActivi;
    }

    public int getIdArti() {
        return idArti;
    }

    public int getIdPara() {
        return idPara;
    }

    public Long getMontant() {
        return montant;
    }

    public void setCodeLigne(String codeLigne) {
        this.codeLigne = codeLigne;
    }

    
    
    public void setIdL(int idL) {
        this.idL = idL;
    }

    public void setIdProg(int idProg) {
        this.idProg = idProg;
    }

    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }

    public void setIdChap(int idChap) {
        this.idChap = idChap;
    }

    public void setIdActivi(int idActivi) {
        this.idActivi = idActivi;
    }

    public void setIdArti(int idArti) {
        this.idArti = idArti;
    }

    public void setIdPara(int idPara) {
        this.idPara = idPara;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public Ligne(String codeLigne, int idProg, int idAct, int idChap, int idActivi, int idArti, int idPara, Long montant) {
        this.codeLigne = codeLigne;
        this.idProg = idProg;
        this.idAct = idAct;
        this.idChap = idChap;
        this.idActivi = idActivi;
        this.idArti = idArti;
        this.idPara = idPara;
        this.montant = montant;
    }

    public Ligne() {
    }

}
