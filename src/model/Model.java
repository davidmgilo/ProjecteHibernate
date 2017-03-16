/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entitats.Pescador;
import entitats.Vaixell;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author alumne
 */
public class Model {
    
    private static Session sesion = HibernateUtil.getSessionFactory().openSession();
    private ArrayList<Vaixell> vaixells = new ArrayList();
    private ClasseDAO<Vaixell> vaixell = new ClasseDAO<>(Vaixell.class, sesion);
    private ArrayList<Pescador> pescadors = new ArrayList();
    private ClasseDAO<Pescador> pescador = new ClasseDAO<>(Pescador.class, sesion);
    
    public Model(){
        actualitzaLlistes();
    }
    
    private void actualitzaLlistes(){
        pescadors = (ArrayList) pescador.obtenLlista();
        vaixells = (ArrayList) vaixell.obtenLlista();
        
//        for (int i=0;i<vaixells.size();i++){
//            for (int j = 0; j < pescadors.size(); j++) {
//                if(vaixells.get(i).get4_capita() != null){
//                    if(vaixells.get(i).get4_capita().get1_id()==pescadors.get(j).get1_id()){
//                        vaixells.get(i).set4_capita(pescadors.get(j));
//                    }
//                } 
//            }
//        }
    }

    public ArrayList<Vaixell> getVaixells() {
        return vaixells;
    }
    
    public ArrayList <Pescador> getPescadors(){
        return pescadors;
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
    
    public void modificaVaixell(int id, String nom, int anys, Pescador capità){
        Vaixell modificat = null;
        try{
            modificat = (Vaixell) vaixell.obte(id);
            modificat.set2_nom(nom);
            modificat.set3_anys(anys);
            modificat.set4_capita(capità);
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
    
    public void assignaCapita (int id, Pescador capità){
        Vaixell modificat = null;
        try{
            modificat = (Vaixell) vaixell.obte(id);
            modificat.set4_capita(capità);
            vaixell.actualitza(modificat);    
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }

    public void creaPescador(String nom, int anys){
        Pescador p = new Pescador(nom,anys);
        try{
            pescador.guarda(p);
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    public void eliminaPescador(int id){
        Pescador elimina = null;
        try{
            elimina = (Pescador) pescador.obte(id);
            pescador.elimina(elimina);
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    public void modificaPescador(int id, String nom, int anys){
        Pescador modificat = null;
        try{
            modificat = (Pescador) pescador.obte(id);
            modificat.set2_nom(nom);
            modificat.set3_experiencia(anys);
            pescador.actualitza(modificat);    
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    
    private void tractaExcepcio(HibernateException e) {
        System.out.println(e.getMessage());
    }
    
    public void finalitza(){
        try {
            sesion.close();
        }catch(HibernateException e){
            tractaExcepcio(e);
        }        
    }
    
}
