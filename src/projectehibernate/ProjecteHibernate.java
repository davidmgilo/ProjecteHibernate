/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectehibernate;

import controlador.Controlador;
import entitats.Pescador;
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
//        Session sesion = HibernateUtil.getSessionFactory().openSession();
//           ClasseDAO vaixellsDAO = new ClasseDAO(Vaixell.class,sesion);
//        ClasseDAO pescadorsDAO = new ClasseDAO(Pescador.class,sesion);
//        Vaixell contacteRecuperat = null;
//        long idAEliminar = 0;
//        long idAEliminarPescador = 0;
//
////Creem tres instàncies de Contacte 
//        Vaixell contacte1 = new Vaixell("Vaixell 1", 8);
//        Vaixell contacte2 = new Vaixell("Vaixell 2", 7);
//        Vaixell contacte3 = new Vaixell("Vaixell 3", 4);
//        Vaixell contacte4 = new Vaixell("Vaixell 4", 5);
//        Pescador cap1 = new Pescador("Cap 1", 4);
//        Pescador cap2 = new Pescador("Cap 2", 3);
//        Pescador cap3 = new Pescador("Cap 3", 2);
//        Pescador cap4 = new Pescador("Cap 4", 1);
//        contacte1.set4_capita(cap1);
//        contacte2.set4_capita(cap2);
//        contacte3.set4_capita(cap3);
//
////Guardem les tres instàncies, i copiem l'id del contacte1 per usar-lo posteriorment 
//        pescadorsDAO.guarda(cap1);
//        pescadorsDAO.guarda(cap2);
//        pescadorsDAO.guarda(cap3);
//        idAEliminarPescador = pescadorsDAO.guarda(cap4);
//        
//        idAEliminar = vaixellsDAO.guarda(contacte1);
//        vaixellsDAO.guarda(contacte2);
//        vaixellsDAO.guarda(contacte3);
//        vaixellsDAO.guarda(contacte4);
//
////Modifiquem el contacte 2 i l'actualitzem 
//        contacte2.set2_nom("Nou Vaixell 2");
//        contacte2.set4_capita(null);
//        vaixellsDAO.actualitza(contacte2);
//        cap2.set2_nom("Nou capità");
//        pescadorsDAO.actualitza(cap2);
//
////Recuperem el contacte1 de la base de dades 
//        contacteRecuperat = (Vaixell) vaixellsDAO.obte(Integer.valueOf(String.valueOf(idAEliminar)));
//        System.out.println("Recuperem a " + contacteRecuperat.get2_nom());
//        System.out.println("Amb capità: " + contacteRecuperat.get4_capita());
//        
//        Pescador pescadorRecuperat = (Pescador) pescadorsDAO.obte(Integer.valueOf(String.valueOf(idAEliminarPescador)));
//        System.out.println("Recuperem a " + pescadorRecuperat.get2_nom());
//
////Eliminem al contacteRecuperat (que és el contacte3) 
//        vaixellsDAO.elimina(contacteRecuperat);
//        pescadorsDAO.elimina(pescadorRecuperat);
//
////Obtenim la llista de contactes que queden a la base de dades i la mostrem 
//        List<Vaixell> llistaContactes = vaixellsDAO.obtenLlista();
//        System.out.println("Hi ha " + llistaContactes.size() + " contactes a la base de dades.");
//
//        for (Vaixell c : llistaContactes) {
//            System.out.println("-> " + c.get2_nom());
//            System.out.println("-> " + c.get4_capita());
//        }
//       
//        sesion.close();
//        System.exit(0);
//    }
    
    
}
