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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author alumne
 */
@Entity
@Table(name = "vaixells")
public class Vaixell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int _1_id;
    @Column(name="nom")
    private String _2_nom;
    @Column(name = "anys_veterania")
    private int _3_anys;
    
    @OneToOne(optional=true)
    @JoinColumn(name = "capita")
    private Pescador _4_capita;
    
    @OneToMany(mappedBy="_4_vaixell") 
    private List<Pescador> _5_treballen = new ArrayList<>();
    
    @Transient
    private ArrayList<Port> _6_circula = new ArrayList<>();

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

    public int get3_anys() {
        return _3_anys;
    }

    public void set3_anys(int anys) {
        this._3_anys = anys;
    }

    public Pescador get4_capita() {
        return _4_capita;
    }

    public void set4_capita(Pescador capita) {
        this._4_capita = capita;
    }

    public List<Pescador> get5_treballen() {
        return _5_treballen;
    }

    public void add5_treballen(Pescador pescador) {
        if(!this._5_treballen.contains(pescador)) this._5_treballen.add(pescador);
    }
    
    public void del5_treballen(Pescador pescador) {
        this._5_treballen.remove(pescador);
    }

    public ArrayList<Port> get6_circula() {
        return _6_circula;
    }

    public void addCircula(Port port) {
        this._6_circula.add(port);
    }

    public Vaixell() {
    }

    public Vaixell(String nom, int anys) {
        this._2_nom = nom;
        this._3_anys = anys;
    }

    @Override
    public String toString() {
        return _2_nom;
    }
       
}
