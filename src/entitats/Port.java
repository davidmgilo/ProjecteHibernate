/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitats;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author alumne
 */
@Entity
@Table(name = "ports")
public class Port {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int _1_id;
    @Column(name="nom")
    private String _2_nom;
    @Column(name="capacitat")
    private int _3_capacitat;
    
    @ManyToMany(mappedBy="_6_circula")
    private List<Vaixell> _4_atraquen = new ArrayList<>();

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

    public int get3_capacitat() {
        return _3_capacitat;
    }

    public void set3_capacitat(int capacitat) {
        this._3_capacitat = capacitat;
    }

    public List<Vaixell> get4_atraquen() {
        return _4_atraquen;
    }

    public void add4_atraquen(Vaixell vaixell) {
        this._4_atraquen.add(vaixell);
    }

    public Port() {
    }

    public Port(String _2_nom, int _3_capacitat) {
        this._2_nom = _2_nom;
        this._3_capacitat = _3_capacitat;
    }

    @Override
    public String toString() {
        return _2_nom;
    }
    
}
