/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Article {

    private int idA, idArt;
    private String codeArt;
    private String libeleArt;

    public int getIdA() {
        return idA;
    }

    public int getIdArt() {
        return idArt;
    }

    public String getCodeArt() {
        return codeArt;
    }

    public String getLibeleArt() {
        return libeleArt;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    public void setIdArt(int idArt) {
        this.idArt = idArt;
    }

    public void setCodeArt(String codeArt) {
        this.codeArt = codeArt;
    }

    public void setLibeleArt(String libeleArt) {
        this.libeleArt = libeleArt;
    }

    public Article(int idA, String codeArt, String libeleArt) {
        this.idA = idA;
        this.codeArt = codeArt;
        this.libeleArt = libeleArt;
    }

    public Article() {
    }
    

}
