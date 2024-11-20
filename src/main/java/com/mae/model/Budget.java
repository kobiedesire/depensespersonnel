/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mae.model;

/**
 *
 * @author hp
 */
public class Budget {
    
    private int idB;
    private int exerciceB;
    private long montantB;

    public int getIdB() {
        return idB;
    }

    public int getExerciceB() {
        return exerciceB;
    }

    public long getMontantB() {
        return montantB;
    }

    public void setIdB(int idB) {
        this.idB = idB;
    }

    public void setExerciceB(int exerciceB) {
        this.exerciceB = exerciceB;
    }

    public void setMontantB(long montantB) {
        this.montantB = montantB;
    }

    public Budget(int exerciceB, long montantB) {
        this.exerciceB = exerciceB;
        this.montantB = montantB;
    }

    public Budget(int exerciceB) {
        this.exerciceB = exerciceB;
    }
    
    

    public Budget() {
    }       
    
}
