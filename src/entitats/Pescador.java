/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author alumne
 */
@Entity
@Table(name = "pescadors")
public class Pescador { 
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int _1_id;
    @Column(name="nom")
    private String _2_nom;
    @Column(name="experiencia")
    private int _3_experiencia;
    
    @Transient
    private Vaixell _4_vaixell;

    public int get1_id() {
        return _1_id;
    }

    private void set1_id(int id) {
        this._1_id = id;
    }

    public String get2_nom() {
        return _2_nom;
    }

    public void set2_nom(String nom) {
        this._2_nom = nom;
    }

    public int get3_experiencia() {
        return _3_experiencia;
    }

    public void set3_experiencia(int experiencia) {
        this._3_experiencia = experiencia;
    }

    public Vaixell get4_vaixell() {
        return _4_vaixell;
    }

    public void set4_vaixell(Vaixell vaixell) {
        this._4_vaixell = vaixell;
    }
    
    
    
}
