/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entitats.Pescador;
import entitats.Vaixell;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Model;
import vista.Vista;

/**
 *
 * @author alumne
 */
public class Controlador {
    private Vista v;
    private Model m;
    private int filasel = -1;
    private int filaselPesc = -1;
    
    public Controlador(Vista v, Model m){
        this.m = m;
        this.v = v;
        carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
        carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
        v.setVisible(true);
        control();
    }
    
    private void carregaTaula(ArrayList resultSet, JTable table, Class<?> classe) {
        if(classe == Vaixell.class) filasel = -1;
        if(classe == Pescador.class) filaselPesc = -1;

        Vector columnNames = new Vector();
        Vector data = new Vector();
        DefaultTableModel model;

        //Anotem el nº de camps de la classe
        Field[] camps = classe.getDeclaredFields();
        //Ordenem els camps alfabèticament
        Arrays.sort(camps, new OrdenarCampClasseAlfabeticament());
        int ncamps = camps.length;
        //Recorrem els camps de la classe i posem els seus noms com a columnes de la taula
        //Com hem hagut de posar _numero_ davant el nom dels camps, mostrem el nom a partir de la 4ª lletra 
        for (Field f : camps) {
            columnNames.addElement(f.getName().substring(3));
        }
        //Si hi ha algun element a l'arraylist omplim la taula
        if (resultSet.size() != 0) {

            //Guardem els descriptors de mètode que ens interessen (els getters)
            Vector<Method> methods = new Vector(resultSet.size());
            try {

                PropertyDescriptor[] descriptors = Introspector.getBeanInfo(classe).getPropertyDescriptors();
                Arrays.sort(descriptors, new OrdenarMetodeClasseAlfabeticament());
                for (PropertyDescriptor pD : descriptors) {
                    Method m = pD.getReadMethod();
                    if (m != null & !m.getName().equals("getClass")) {
                        methods.addElement(m);
                    }
                }

            } catch (IntrospectionException ex) {
                Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (Object m : resultSet) {
                Vector row = new Vector(ncamps);

                for (Method mD : methods) {
                    try {
                        row.addElement(mD.invoke(m));
                    } catch (IllegalAccessException ex) {
                        Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IllegalArgumentException ex) {
                        Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (InvocationTargetException ex) {
                        Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                
                data.addElement(row);
            }
        }

        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };
   
        table.setModel(model);

        TableColumn column;
        for (int i = 0; i < table.getColumnCount(); i++) {
            column = table.getColumnModel().getColumn(i);
            column.setMaxWidth(250);
        }
        
        if(classe == Vaixell.class){
            //Amagar la columna amb la referència a les relacions
            table.getColumnModel().removeColumn(table.getColumnModel().getColumn(5));
            table.getColumnModel().removeColumn(table.getColumnModel().getColumn(4));
//            table.getColumnModel().removeColumn(table.getColumnModel().getColumn(3));
        }
        
        if(classe == Pescador.class){
            table.getColumnModel().removeColumn(table.getColumnModel().getColumn(3));
            emplenaComboBox(resultSet, v.getCapitansComboBox());
        }
        
    }

    private void control() {
        v.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                m.finalitza();
                System.exit(0);
            }
            
        });
        
        v.getCreaVaixellButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                   m.creaVaixell(
                       v.getNomVaixellTextField().getText(), 
                       Integer.valueOf(v.getAnysVaixellTextField().getText()),
                       (Pescador) v.getCapitansComboBox().getSelectedItem()
                   );
                   carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                   netejaVaixells();
               }catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(v, "El valor d'anys ha de ser un enter","Error",JOptionPane.ERROR_MESSAGE);
               }
                 
            }
            
        });
        
        v.getVaixellTable().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                filasel = v.getVaixellTable().getSelectedRow();
                if(filasel == -1){
                    netejaVaixells();
                }else{
                    v.getNomVaixellTextField().setText((String)v.getVaixellTable().getValueAt(filasel, 1));
                    v.getAnysVaixellTextField().setText(v.getVaixellTable().getValueAt(filasel, 2).toString());
                    v.getCapitansComboBox().setSelectedItem(
                            v.getVaixellTable().getValueAt(filasel, 3) == null ?
                                    null : (Pescador)v.getVaixellTable().getValueAt(filasel, 3));
                }
            }
            
        });
                
        v.getModificaVaixellButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               try{
                   if(filasel != -1){
                        m.modificaVaixell(
                           Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()), 
                           v.getNomVaixellTextField().getText(), 
                           Integer.valueOf(v.getAnysVaixellTextField().getText()),
                           (Pescador) v.getCapitansComboBox().getSelectedItem()       
                        );
                        carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                        netejaVaixells();
                   } 
                   else 
                        JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre per poder modificar-lo.","Error",JOptionPane.ERROR_MESSAGE);
               }catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(v, "El valor d'anys ha de ser un enter","Error",JOptionPane.ERROR_MESSAGE);
               }
            }
            
        });
        
        v.getEliminaVaixellButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filasel != -1){
                    m.eliminaVaixell(Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()));
                    carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                    netejaVaixells();
                } 
                else 
                   JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre per poder borrar-lo.","Error",JOptionPane.ERROR_MESSAGE);
            }
            
        });
        
        v.getViewVaixellButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                v.getjPanel1().removeAll();
                v.getjPanel1().repaint();
                v.getjPanel1().revalidate();
                
                v.getjPanel1().add(v.getVaixellPanel());
                v.getjPanel1().repaint();
                v.getjPanel1().revalidate();
            }
            
        });
        
        v.getjButton1().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                v.getjPanel1().removeAll();
                v.getjPanel1().repaint();
                v.getjPanel1().revalidate();
                
                v.getjPanel1().add(v.getWelcomePanel());
                v.getjPanel1().repaint();
                v.getjPanel1().revalidate();
            }
            
        });
        
        v.getViewPescadorsButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                v.getjPanel1().removeAll();
                v.getjPanel1().repaint();
                v.getjPanel1().revalidate();
                
                v.getjPanel1().add(v.getPescadorPanel());
                v.getjPanel1().repaint();
                v.getjPanel1().revalidate();
            }
            
        });
        
        v.getExitButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                m.finalitza();
                System.exit(0);
            } 
        });
        
        v.getAssignaCapitaButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(v.getCapitansComboBox().getSelectedItem() != null && filasel != -1){
                    m.assignaCapita(
                            Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()), 
                           (Pescador) v.getCapitansComboBox().getSelectedItem() 
                    );
                    carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                    netejaVaixells();
                }else{
                    JOptionPane.showMessageDialog(v, "Cal seleccionar un capità vàlid amb un vaixell seleccionat.","Error",JOptionPane.ERROR_MESSAGE);
                }
            }
                
        });
        
        v.getNoCapitaButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filasel != -1){
                    m.assignaCapita(
                            Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()), 
                           null 
                    );
                    carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                    netejaVaixells();
                }else {
                    JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre.","Error",JOptionPane.ERROR_MESSAGE);
                }
                
                
            }
            
        });
        
        v.getCreaPescadorButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   m.creaPescador(
                           v.getNomPescadorTextField().getText(), 
                           Integer.valueOf(v.getExperienciaPescadorTextField().getText())
                   );
                   carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
                   netejaPescadors();
               }catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(v, "El valor d'experiencia ha de ser un enter","Error",JOptionPane.ERROR_MESSAGE);
               }
            }
            
        });
        
        v.getEliminaPescadorButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filaselPesc != -1){
                    m.eliminaPescador(Integer.valueOf(v.getPescadorsTable().getValueAt(filaselPesc, 0).toString()));
                    carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
                    netejaPescadors();
                } 
                else 
                   JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre per poder borrar-lo.","Error",JOptionPane.ERROR_MESSAGE);
            }
            
        });
        
        v.getPescadorsTable().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                filaselPesc = v.getPescadorsTable().getSelectedRow();
                if(filaselPesc == -1){
                    netejaPescadors();
                }else{
                    v.getNomPescadorTextField().setText(v.getPescadorsTable().getValueAt(filaselPesc, 1).toString());
                    v.getExperienciaPescadorTextField().setText(v.getPescadorsTable().getValueAt(filaselPesc, 2).toString());
                }
            }
            
        });
        
        v.getModificaPescadorButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                   if(filaselPesc != -1){
                        m.modificaPescador(
                               Integer.valueOf(v.getPescadorsTable().getValueAt(filaselPesc, 0).toString()), 
                               v.getNomPescadorTextField().getText(), 
                           Integer.valueOf(v.getExperienciaPescadorTextField().getText())
                        );
                        carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
                        netejaPescadors();
                   } 
                   else 
                        JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre per poder modificar-lo.","Error",JOptionPane.ERROR_MESSAGE);
               }catch(NumberFormatException ex){
                   JOptionPane.showMessageDialog(v, "El valor d'experiencia ha de ser un enter","Error",JOptionPane.ERROR_MESSAGE);
               }
            }
            
        });
    }

    private void emplenaComboBox(ArrayList resultSet, JComboBox<Pescador> ComboBox) {
        ComboBox.removeAllItems();
        ComboBox.addItem(null);
        for (Object m : resultSet){
            ComboBox.addItem((Pescador)m);
        }
    }
    
    private void netejaVaixells(){
        v.getNomVaixellTextField().setText("");
        v.getAnysVaixellTextField().setText("");
        v.getCapitansComboBox().setSelectedItem(null);
    }
    
    private void netejaPescadors(){
        v.getNomPescadorTextField().setText("");
        v.getExperienciaPescadorTextField().setText("");
    }
   
    // Classe "niada" (nested class, clase anidada) usada per ordenar els camps de les classes alfabèticament
    public static class OrdenarCampClasseAlfabeticament implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            return (int) (((Field) o1).getName().compareToIgnoreCase(((Field) o2).getName()));
        }
    }

    // Classe "niada" (nested class, clase anidada) usada per ordenar els mètodes de les classes alfabèticament
    public static class OrdenarMetodeClasseAlfabeticament implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {

            Method mo1 = ((PropertyDescriptor) o1).getReadMethod();
            Method mo2 = ((PropertyDescriptor) o2).getReadMethod();

            if (mo1 != null && mo2 != null) {
                return (int) mo1.getName().compareToIgnoreCase(mo2.getName());
            }
            if (mo1 == null) {
                return -1;
            } else {
                return 1;
            }
        }
    }
    
}
