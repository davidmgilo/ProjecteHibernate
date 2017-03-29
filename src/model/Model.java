/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entitats.Pescador;
import entitats.Port;
import entitats.Vaixell;
import exceptions.CapitaException;
import exceptions.EsCapitaException;
import exceptions.NullException;
import exceptions.PescadorRelacionatException;
import exceptions.PortRelacionatException;
import exceptions.VaixellRelacionatException;
import java.util.ArrayList;
import java.util.List;
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
    private ArrayList<Port> ports = new ArrayList();
    private ClasseDAO<Port> port = new ClasseDAO<>(Port.class, sesion);
    
    public Model(){
        actualitzaLlistes();
    }
    
    private void actualitzaLlistes(){
        pescadors = (ArrayList) pescador.obtenLlista();
        vaixells = (ArrayList) vaixell.obtenLlista();
        ports = (ArrayList) port.obtenLlista();
        
    }

    public ArrayList<Vaixell> getVaixells() {
        return vaixells;
    }
    
    public ArrayList <Pescador> getPescadors(){
        return pescadors;
    }
    
    public ArrayList <Port> getPorts(){
        return ports;
    }
    
    public void creaVaixell(String nom, int anys, Pescador capita){
        Vaixell vai = new Vaixell(nom,anys);
        try{
            vaixell.guarda(vai);
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    public void modificaVaixell(int id, String nom, int anys, Pescador capità) throws CapitaException{
        Vaixell modificat = null;
        try{
            modificat = (Vaixell) vaixell.obte(id);
            modificat.set2_nom(nom);
            modificat.set3_anys(anys);
            vaixell.actualitza(modificat); 
            if (capità != null){
               assignaCapita(id,capità); 
            }else{
                modificat.set4_capita(capità);
                vaixell.actualitza(modificat);
            }            
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    public void eliminaVaixell(int id) throws VaixellRelacionatException{
        Vaixell elimina = null;
        try{
            elimina = (Vaixell) vaixell.obte(id);
            System.out.println(elimina);
            if(elimina.get4_capita() == null && elimina.get5_treballen().isEmpty() && elimina.get6_circula().isEmpty()){
                vaixell.elimina(elimina);
            }else{
                throw new VaixellRelacionatException();
            }
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    public void assignaCapita (int id, Pescador capità) throws CapitaException{
        Vaixell modificat = null;
        try{
            modificat = (Vaixell) vaixell.obte(id);
            if((capità != null && capità.get4_vaixell() != null) && (capità.get4_vaixell() != modificat)){
                throw new CapitaException();
            }
            
            modificat.set4_capita(capità);
            if(capità != null){
                modificat.add5_treballen(capità);
                capità.set4_vaixell(modificat);
                pescador.actualitza(capità);
            }  
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
    
    public void eliminaPescador(int id) throws PescadorRelacionatException{
        Pescador elimina = null;
        try{
            elimina = (Pescador) pescador.obte(id);
            if(elimina.get4_vaixell() == null){
                pescador.elimina(elimina);
            }else{
                throw new PescadorRelacionatException();
            }
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
    
    public void desassignaVaixell(Pescador p, int id_vaixell){
        Vaixell modificat = null;
        try{
           if(p != null){
              p.set4_vaixell(null);
              pescador.actualitza(p);  
           } 
           modificat = (Vaixell) vaixell.obte(id_vaixell);
           modificat.del5_treballen(p);
           vaixell.actualitza(modificat);
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

    public List llistarPescadorsNoAfegits(int id_vaixell) {
        Vaixell trobat = null;
        List list = new ArrayList();
        try{
            trobat = (Vaixell) vaixell.obte(id_vaixell);
            for (Pescador p : pescadors){
                list.add(p);
            }
            for(Vaixell v: vaixell.obtenLlista()){
                for(Pescador p : v.get5_treballen()){
                    list.remove(p);
                }
            }
        }catch(HibernateException e){
            tractaExcepcio(e);
        }finally{
            return list;
        }        
    }

    public void afegeixTreballadorPescador(Pescador pesc, Integer id_vaixell) throws NullException{
        if(pesc == null){
            throw new NullException();
        }else{
            try{
                Vaixell trobat = (Vaixell) vaixell.obte(id_vaixell);
                trobat.add5_treballen(pesc);
                vaixell.actualitza(trobat);
                pesc.set4_vaixell(trobat);
                pescador.actualitza(pesc);
            }catch(HibernateException e){
                tractaExcepcio(e);
            }
        }
    }
    
    public Vaixell getVaixell(int id){
        return (Vaixell) vaixell.obte(id);
    }

    public void acomiadaTreballadorPescador(Pescador pesc, Integer vaixell_id) throws EsCapitaException{
        try{
            Vaixell trobat = (Vaixell) vaixell.obte(vaixell_id);
            if(trobat.get4_capita() == pesc){
                throw new EsCapitaException();
            }
            trobat.del5_treballen(pesc);
            vaixell.actualitza(trobat);
            pesc.set4_vaixell(null);
            pescador.actualitza(pesc);
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
    }
    
    public void creaPort(String nom, int capacitat){
        Port p = new Port(nom,capacitat);
        try{
            port.guarda(p);
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    public void eliminaPort(int id) throws PortRelacionatException{
        Port elimina = null;
        try{
            elimina = (Port) port.obte(id);
            if(elimina.get4_atraquen().isEmpty()){
                port.elimina(elimina);
            }else{
                throw new PortRelacionatException();
            }
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    public void modificaPort(int id, String nom, int capacitat){
        Port modificat = null;
        try{
            modificat = (Port) port.obte(id);
            modificat.set2_nom(nom);
            modificat.set3_capacitat(capacitat);
            port.actualitza(modificat);    
        }catch(HibernateException e){
            tractaExcepcio(e);
        }
        actualitzaLlistes();
    }
    
    public List llistarPortsDisponibles(int id_vaixell) {
        Vaixell trobat = null;
        List list = new ArrayList();
        try{
            trobat = (Vaixell) vaixell.obte(id_vaixell);
            for (Port p : ports){
                list.add(p);
            }
            for(Port p: trobat.get6_circula()){
                list.remove(p);
            }
        }catch(HibernateException e){
            tractaExcepcio(e);
        }finally{
            return list;
        }        
    }
}
