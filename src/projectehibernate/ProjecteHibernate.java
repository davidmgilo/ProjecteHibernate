/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectehibernate;

import controlador.Controlador;
import entitats.Vaixell;
import java.util.List;
import model.ClasseDAO;
import model.Model;
import vista.Vista;

/**
 *
 * @author alumne
 */
public class ProjecteHibernate {

    static Model model = new Model();
    static Vista vista = new Vista();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        // TODO code application logic here
        new Controlador(vista,model);
    }

    //        ClasseDAO contactesDAO = new ClasseDAO(Vaixell.class);
//        Vaixell contacteRecuperat = null;
//        long idAEliminar = 0;
//
//        System.out.println((Vaixell.class).newInstance().getClass().getSimpleName());
////Creem tres instàncies de Contacte 
//        Vaixell contacte1 = new Vaixell("Vaixell 1", 8);
//        Vaixell contacte2 = new Vaixell("Vaixell 2", 7);
//        Vaixell contacte3 = new Vaixell("Vaixell 3", 4);
//
////Guardem les tres instàncies, i copiem l'id del contacte1 per usar-lo posteriorment 
//        idAEliminar = contactesDAO.guarda(contacte1);
//        contactesDAO.guarda(contacte2);
//        contactesDAO.guarda(contacte3);
//
////Modifiquem el contacte 2 i l'actualitzem 
//        contacte2.setNom("Nou Vaixell 2");
//        contactesDAO.actualitza(contacte2);
//
////Recuperem el contacte1 de la base de dades 
//        contacteRecuperat = (Vaixell) contactesDAO.obte(Integer.valueOf(String.valueOf(idAEliminar)));
//        System.out.println("Recuperem a " + contacteRecuperat.getNom());
//
////Eliminem al contacteRecuperat (que és el contacte3) 
//        contactesDAO.elimina(contacteRecuperat);
//
////Obtenim la llista de contactes que queden a la base de dades i la mostrem 
//        List<Vaixell> llistaContactes = contactesDAO.obtenLlista();
//        System.out.println("Hi ha " + llistaContactes.size() + " contactes a la base de dades.");
//
//        for (Vaixell c : llistaContactes) {
//            System.out.println("-> " + c.getNom());
//        }
//
//        System.exit(0);
    
    
}
