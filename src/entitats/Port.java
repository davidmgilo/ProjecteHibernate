/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import java.util.ArrayList;

/**
 *
 * @author alumne
 */
public class Port {
    private int id;
    private String nom;
    private int capacitat;
       
    private ArrayList<Vaixell> atraquen = new ArrayList<>();

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

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public ArrayList<Vaixell> getAtraquen() {
        return atraquen;
    }

    public void addAtraquen(Vaixell vaixell) {
        this.atraquen.add(vaixell);
    }
    
    
}
