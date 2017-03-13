/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entitats.Vaixell;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author alumne
 */
public class Model {
    
    private ArrayList<Vaixell> vaixells = new ArrayList();
    private ClasseDAO vaixell = new ClasseDAO(Vaixell.class);
    
    public Model(){
        actualitzaLlistes();
    }
    
    private void actualitzaLlistes(){
        vaixells = (ArrayList) vaixell.obtenLlista();
    }

    public ArrayList<Vaixell> getVaixells() {
        return vaixells;
    }
    
    public void creaVaixell(String nom, int anys){
        Vaixell vai = new Vaixell(nom,anys);
        try{
            vaixell.guarda(vai);
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    public void modificaVaixell(int id, String nom, int anys){
        Vaixell modificat = null;
        try{
            modificat = (Vaixell) vaixell.obte(id);
            modificat.set2_nom(nom);
            modificat.set3_anys(anys);
            vaixell.actualitza(modificat);    
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    public void eliminaVaixell(int id){
        Vaixell elimina = null;
        try{
            elimina = (Vaixell) vaixell.obte(id);
            vaixell.elimina(elimina);
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }

    private void tractaExcepcio(HibernateException e) {
        System.out.println(e.getMessage());
    }
    
}
