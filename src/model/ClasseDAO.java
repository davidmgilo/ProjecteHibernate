/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author alumne
 */
public class ClasseDAO<T> {

    private Session sesion;
    private Transaction tx;
    
    private Class p;

    public ClasseDAO(Class<T> p, Session sesion) {
        this.p = p;
        this.sesion=sesion;
    }
    
    public long guarda(T objecte) throws HibernateException {
        long id = 0;

        try {
            iniciaOperacio();
            id = Long.parseLong(String.valueOf(sesion.save(objecte)));
            tx.commit();
        } catch (HibernateException he) {
            tractaExcepcio(he);
            throw he;
        }

        return id;
    }

    public void actualitza(T objecte) throws HibernateException {
        try {
            iniciaOperacio();
            sesion.update(objecte);
            tx.commit();
        } catch (HibernateException he) {
            tractaExcepcio(he);
            throw he;
        } 
    }

    public void elimina(T objecte) throws HibernateException {
        try {
            iniciaOperacio();
            sesion.delete(objecte);
            tx.commit();
        } catch (HibernateException he) {
            tractaExcepcio(he);
            throw he;
        } 
    }

    public T obte(int idObjecte) throws HibernateException {
        T objecte = null;
        try {
            iniciaOperacio();
            objecte = (T) sesion.get(p, idObjecte);
            tx.commit();
        } catch (HibernateException he) {
            tractaExcepcio(he);
            throw he;
        }

        return objecte;
    }

    public List<T> obtenLlista() throws HibernateException {
        List<T> llista = null;
        try {
            iniciaOperacio();
            llista = sesion.createQuery("from "+p.getSimpleName()+" ORDER BY 1").list();
            tx.commit();
        } catch (HibernateException he) {
            tractaExcepcio(he);
            throw he;
        }

        return llista;
    }

    private void iniciaOperacio() throws HibernateException {
        tx = sesion.beginTransaction();
    }

    private void tractaExcepcio(HibernateException he) throws HibernateException {
        tx.rollback();
        throw new HibernateException("Error a la capa d'accés a dades", he);
    }
}
