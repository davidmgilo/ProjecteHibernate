/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

/**
 *
 * @author alumne
 */
public class Pescador { 
    private int id;
    private String nom;
    private int experiencia;
    
    private Vaixell vaixell;

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public Vaixell getVaixell() {
        return vaixell;
    }

    public void setVaixell(Vaixell vaixell) {
        this.vaixell = vaixell;
    }
    
    
    
}
