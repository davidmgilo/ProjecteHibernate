/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import entitats.Pescador;
import entitats.Port;
import entitats.Vaixell;
import exceptions.CapitaException;
import exceptions.EsCapitaException;
import exceptions.NullException;
import exceptions.PescadorRelacionatException;
import exceptions.PortRelacionatException;
import exceptions.VaixellRelacionatException;
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
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import model.Model;
import vista.TreballenVista;
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
    private int filaselPList = -1;
    private int filaselPort = -1;
    private TreballenVista tv = new TreballenVista();

    public Controlador(Vista v, Model m) {
        this.m = m;
        this.v = v;
        carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
        carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
        carregaTaula(m.getPorts(), v.getPortsTable(), Port.class);
        v.setVisible(true);
        control();
    }

    private void carregaTaula(ArrayList resultSet, JTable table, Class<?> classe) {
        if (classe == Vaixell.class) {
            filasel = -1;
        }
        if (classe == Pescador.class) {
            filaselPesc = -1;
        }
        if (classe == Port.class) {
            filaselPort = -1;
        }

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

        if (classe == Pescador.class) {
            emplenaComboBox(resultSet, v.getCapitansComboBox());
        }

    }

    private void control() {
        v.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                m.finalitza();
                System.exit(0);
            }

        });

        v.getCreaVaixellButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!"".equals(v.getNomVaixellTextField().getText().trim())) {
                    try {
                        m.creaVaixell(
                                v.getNomVaixellTextField().getText().trim(),
                                Integer.valueOf(v.getAnysVaixellTextField().getText().trim()),
                                (Pescador) v.getCapitansComboBox().getSelectedItem()
                        );
                        carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                        netejaVaixells();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(v, "El valor d'anys ha de ser un enter", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(v, "El valor del nom no pot ser buit", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        v.getVaixellTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e); //To change body of generated methods, choose Tools | Templates.
                filasel = v.getVaixellTable().getSelectedRow();
                if (filasel == -1) {
                    netejaVaixells();
                } else {
                    v.getNomVaixellTextField().setText((String) v.getVaixellTable().getValueAt(filasel, 1));
                    v.getAnysVaixellTextField().setText(v.getVaixellTable().getValueAt(filasel, 2).toString());
                    v.getCapitansComboBox().setSelectedItem(
                            v.getVaixellTable().getValueAt(filasel, 3) == null
                            ? null : (Pescador) v.getVaixellTable().getValueAt(filasel, 3));
                }
            }

        });

        v.getModificaVaixellButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (filasel != -1) {
                        if (!"".equals(v.getNomVaixellTextField().getText().trim())) {
                            if(v.getCapitansComboBox().getSelectedItem() == null){
                                m.desassignaVaixell((Pescador) v.getVaixellTable().getValueAt(filasel, 3), Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()));
                            }
                            m.modificaVaixell(
                                    Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()),
                                    v.getNomVaixellTextField().getText().trim(),
                                    Integer.valueOf(v.getAnysVaixellTextField().getText().trim()),
                                    (Pescador) v.getCapitansComboBox().getSelectedItem()
                            );
                            carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                            carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
                            netejaVaixells();
                        } else {
                            JOptionPane.showMessageDialog(v, "El valor del nom no pot ser buit", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre per poder modificar-lo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(v, "El valor d'anys ha de ser un enter", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (CapitaException ex){
                    JOptionPane.showMessageDialog(v, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        v.getEliminaVaixellButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (filasel != -1) {
                        m.eliminaVaixell(Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()));
                        carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                        netejaVaixells();
                    } else {
                        JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre per poder borrar-lo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (VaixellRelacionatException ex) {
                    JOptionPane.showMessageDialog(v, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        v.getViewVaixellButton().addActionListener(new ActionListener() {
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

        v.getjButton1().addActionListener(new ActionListener() {
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

        v.getViewPescadorsButton().addActionListener(new ActionListener() {
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

        v.getExitButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                m.finalitza();
                System.exit(0);
            }
        });

        v.getAssignaCapitaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (v.getCapitansComboBox().getSelectedItem() != null && filasel != -1) {
                        m.assignaCapita(
                                Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()),
                                (Pescador) v.getCapitansComboBox().getSelectedItem()
                        );
                        carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                        carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
                        netejaVaixells();
                    } else {
                        JOptionPane.showMessageDialog(v, "Cal seleccionar un capità vàlid amb un vaixell seleccionat.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (CapitaException ex) {
                    JOptionPane.showMessageDialog(v, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        v.getNoCapitaButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (filasel != -1) {
                        if (v.getVaixellTable().getValueAt(filasel, 3) != null) {
                            m.desassignaVaixell((Pescador) v.getVaixellTable().getValueAt(filasel, 3), Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()));
                            m.assignaCapita(
                                    Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()),
                                    null
                            );
                            carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                            carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
                            netejaVaixells();
                        } else {
                            JOptionPane.showMessageDialog(v, "Aquest vaixell no té capità!", "Error", JOptionPane.ERROR_MESSAGE);
                        }

                    } else {
                        JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (CapitaException ex) {
                }
            }

        });

        v.getCreaPescadorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!"".equals(v.getNomPescadorTextField().getText().trim())) {
                    try {
                        m.creaPescador(
                                v.getNomPescadorTextField().getText().trim(),
                                Integer.valueOf(v.getExperienciaPescadorTextField().getText().trim())
                        );
                        carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
                        netejaPescadors();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(v, "El valor d'experiencia ha de ser un enter", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(v, "El valor del nom no pot ser buit", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        v.getEliminaPescadorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (filaselPesc != -1) {
                        m.eliminaPescador(Integer.valueOf(v.getPescadorsTable().getValueAt(filaselPesc, 0).toString()));
                        carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
                        netejaPescadors();
                    } else {
                        JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre per poder borrar-lo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (PescadorRelacionatException ex) {
                    JOptionPane.showMessageDialog(v, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        v.getPescadorsTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                filaselPesc = v.getPescadorsTable().getSelectedRow();
                if (filaselPesc == -1) {
                    netejaPescadors();
                } else {
                    v.getNomPescadorTextField().setText(v.getPescadorsTable().getValueAt(filaselPesc, 1).toString());
                    v.getExperienciaPescadorTextField().setText(v.getPescadorsTable().getValueAt(filaselPesc, 2).toString());
                }
            }

        });

        v.getModificaPescadorButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (filaselPesc != -1) {
                        if (!"".equals(v.getNomPescadorTextField().getText().trim())) {
                            m.modificaPescador(
                                    Integer.valueOf(v.getPescadorsTable().getValueAt(filaselPesc, 0).toString()),
                                    v.getNomPescadorTextField().getText().trim(),
                                    Integer.valueOf(v.getExperienciaPescadorTextField().getText().trim())
                            );
                            carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
                            netejaPescadors();
                        } else {
                            JOptionPane.showMessageDialog(v, "El valor del nom no pot ser buit", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre per poder modificar-lo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(v, "El valor d'experiencia ha de ser un enter", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }

        });
        
        v.getTreballenButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if(filasel != -1){
                    tv.setLocationRelativeTo(v);
                    v.setVisible(false);
                    tv.setVisible(true);
                    emplenaJList(tv.getPescadorsJList(),(List)v.getVaixellTable().getValueAt(filasel, 4));
                    List llista = m.llistarPescadorsNoAfegits(Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()));
                    emplenaComboBox(llista,tv.getAfegeixPescadorComboBox());
                }else{
                   JOptionPane.showMessageDialog(v, "S'ha de seleccionar un vaixell per poder gestionar-lo.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }

        });
        
        tv.getTornaFromPescadorsButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                v.setLocationRelativeTo(tv);
                tv.setVisible(false);
                v.setVisible(true);
                carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
            }
            
        });
        
        tv.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                v.setLocationRelativeTo(tv);
                tv.setVisible(false);
                v.setVisible(true);
                carregaTaula(m.getVaixells(), v.getVaixellTable(), Vaixell.class);
                carregaTaula(m.getPescadors(), v.getPescadorsTable(), Pescador.class);
            }
            
        });
        
        tv.getAfegeixPescadorButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    m.afegeixTreballadorPescador((Pescador)tv.getAfegeixPescadorComboBox().getSelectedItem(),Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString())); 
                    emplenaJList(tv.getPescadorsJList(),m.getVaixell(Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString())).get5_treballen());
                    emplenaComboBox(new ArrayList(),tv.getAfegeixPescadorComboBox());
                    List llista = m.llistarPescadorsNoAfegits(Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()));
                    emplenaComboBox(llista,tv.getAfegeixPescadorComboBox());
                }catch(NullException ex){
                    JOptionPane.showMessageDialog(v, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });
        
        tv.getPescadorsJList().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                filaselPList = tv.getPescadorsJList().getSelectedIndex();
            }            
        });
        
        tv.getEliminaPescadorListButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (filaselPList != -1){
                    try{
                        m.acomiadaTreballadorPescador(tv.getPescadorsJList().getSelectedValue(),Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()));
                        emplenaJList(tv.getPescadorsJList(),m.getVaixell(Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString())).get5_treballen());
                        emplenaComboBox(new ArrayList(),tv.getAfegeixPescadorComboBox());
                        List llista = m.llistarPescadorsNoAfegits(Integer.valueOf(v.getVaixellTable().getValueAt(filasel, 0).toString()));
                        emplenaComboBox(llista,tv.getAfegeixPescadorComboBox());
                    }catch(EsCapitaException ex){
                        JOptionPane.showMessageDialog(v, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(v, "Selecciona un pescador a acomiadar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        
        v.getViewPortsButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                v.getjPanel1().removeAll();
                v.getjPanel1().repaint();
                v.getjPanel1().revalidate();

                v.getjPanel1().add(v.getPortPanel());
                v.getjPanel1().repaint();
                v.getjPanel1().revalidate();
            }

        });
        
        v.getCreaPortButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!"".equals(v.getNomPortTextField().getText().trim())) {
                    try {
                        m.creaPort(
                                v.getNomPortTextField().getText().trim(), 
                                Integer.valueOf(v.getCapacitatPortTextField().getText().trim())
                        );
                        carregaTaula(m.getPorts(), v.getPortsTable(), Port.class);
                        netejaPorts();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(v, "El valor de capacitat ha de ser un enter", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(v, "El valor del nom no pot ser buit", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        v.getPortsTable().addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                filaselPort = v.getPortsTable().getSelectedRow();
                if (filaselPort == -1){
                    netejaPorts();
                }else {
                    v.getNomPortTextField().setText(v.getPortsTable().getValueAt(filaselPort, 1).toString());
                    v.getCapacitatPortTextField().setText(v.getPortsTable().getValueAt(filaselPort, 2).toString());
                }
            }            
        });
        
        v.getEliminaPortButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (filaselPort != -1) {
                        m.eliminaPort(Integer.valueOf(v.getPortsTable().getValueAt(filaselPort, 0).toString()));
                        carregaTaula(m.getPorts(), v.getPortsTable(), Port.class);
                        netejaPorts();
                    } else {
                        JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre per poder borrar-lo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (PortRelacionatException ex) {
                    JOptionPane.showMessageDialog(v, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        
        v.getModificaPortButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (filaselPort != -1){
                        if (!"".equals(v.getNomPortTextField().getText().trim())){
                            m.modificaPort(
                                    Integer.valueOf(v.getPortsTable().getValueAt(filaselPort, 0).toString()),
                                    v.getNomPortTextField().getText(),
                                    Integer.valueOf(v.getCapacitatPortTextField().getText())
                            );
                            carregaTaula(m.getPorts(), v.getPortsTable(), Port.class);
                            netejaPorts();
                        } else{
                           JOptionPane.showMessageDialog(v, "El valor del nom no pot ser buit", "Error", JOptionPane.ERROR_MESSAGE); 
                        }
                    }else{
                        JOptionPane.showMessageDialog(v, "S'ha de seleccionar un registre per poder modificar-lo.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(v, "El valor de capacitat ha de ser un enter", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        });
        
    }

    private void emplenaComboBox(List result, JComboBox ComboBox) {
        ArrayList resultSet = new ArrayList(result);
        ComboBox.removeAllItems();
        if(result.isEmpty()){
            
        }else{
            ComboBox.addItem(null);
            for (Object m : resultSet) {
                ComboBox.addItem(m);
            }  
        }
        
    }
    
    private void emplenaJList(JList jlist, List list) {
        ArrayList arrayList = new ArrayList(list);
        DefaultListModel lm = new DefaultListModel();
        for (Object o : arrayList){
            lm.addElement(o);
        }
        jlist.setModel(lm);
    }
    
    private void netejaVaixells() {
        v.getNomVaixellTextField().setText("");
        v.getAnysVaixellTextField().setText("");
        v.getCapitansComboBox().setSelectedItem(null);
    }

    private void netejaPescadors() {
        v.getNomPescadorTextField().setText("");
        v.getExperienciaPescadorTextField().setText("");
    }
    
    private void netejaPorts() {
        v.getNomPortTextField().setText("");
        v.getCapacitatPortTextField().setText("");
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
