/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import entitats.Pescador;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author alumne
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    public Vista() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonPanel = new javax.swing.JPanel();
        viewVaixellButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();
        viewPescadorsButton = new javax.swing.JButton();
        viewPortsButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        vaixellPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaixellTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomVaixellTextField = new javax.swing.JTextField();
        anysVaixellTextField = new javax.swing.JTextField();
        creaVaixellButton = new javax.swing.JButton();
        eliminaVaixellButton = new javax.swing.JButton();
        modificaVaixellButton = new javax.swing.JButton();
        assignaCapitaButton = new javax.swing.JButton();
        capitansComboBox = new javax.swing.JComboBox<>();
        noCapitaButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        treballenButton = new javax.swing.JButton();
        circulenButton = new javax.swing.JButton();
        pescadorPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pescadorsTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nomPescadorTextField = new javax.swing.JTextField();
        experienciaPescadorTextField = new javax.swing.JTextField();
        creaPescadorButton = new javax.swing.JButton();
        eliminaPescadorButton = new javax.swing.JButton();
        modificaPescadorButton = new javax.swing.JButton();
        portPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        portsTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nomPortTextField = new javax.swing.JTextField();
        capacitatPortTextField = new javax.swing.JTextField();
        creaPortButton = new javax.swing.JButton();
        eliminaPortButton = new javax.swing.JButton();
        modificaPortButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        buttonPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        buttonPanel.setMaximumSize(new java.awt.Dimension(104, 330));

        viewVaixellButton.setText("Vaixell");

        jButton1.setText("Welcome");

        exitButton.setText("Sortir");

        viewPescadorsButton.setText("Pescador");

        viewPortsButton.setText("Ports");

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(viewPescadorsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(viewVaixellButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(viewPortsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addComponent(jButton1)
                .addGap(34, 34, 34)
                .addComponent(viewVaixellButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(viewPescadorsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(viewPortsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(exitButton))
        );

        jPanel1.setLayout(new java.awt.CardLayout());

        jLabel3.setFont(new java.awt.Font("Nimbus Roman No9 L", 3, 48)); // NOI18N
        jLabel3.setText("Welcome");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(229, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(79, 79, 79))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel3)
                .addContainerGap(447, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, "card3");

        vaixellTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        vaixellTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(vaixellTable);

        jLabel1.setText("Nom:");

        jLabel2.setText("Anys:");

        creaVaixellButton.setText("Crea");

        eliminaVaixellButton.setText("Elimina");

        modificaVaixellButton.setText("Modifica");

        assignaCapitaButton.setText("Assigna capità");

        noCapitaButton.setText("Desassigna capità");

        jLabel4.setText("Capità:");

        treballenButton.setText("Gestiona treballadors");

        circulenButton.setText("Gestiona Ports");

        javax.swing.GroupLayout vaixellPanelLayout = new javax.swing.GroupLayout(vaixellPanel);
        vaixellPanel.setLayout(vaixellPanelLayout);
        vaixellPanelLayout.setHorizontalGroup(
            vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vaixellPanelLayout.createSequentialGroup()
                .addGroup(vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(vaixellPanelLayout.createSequentialGroup()
                        .addGap(0, 32, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, vaixellPanelLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vaixellPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(nomVaixellTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(vaixellPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)
                                    .addComponent(anysVaixellTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(vaixellPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(capitansComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(noCapitaButton, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(creaVaixellButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminaVaixellButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modificaVaixellButton, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(assignaCapitaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(27, 27, 27))
            .addGroup(vaixellPanelLayout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(treballenButton, javax.swing.GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
                    .addComponent(circulenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        vaixellPanelLayout.setVerticalGroup(
            vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vaixellPanelLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vaixellPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(creaVaixellButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminaVaixellButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(modificaVaixellButton))
                    .addGroup(vaixellPanelLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomVaixellTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(anysVaixellTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addGap(18, 18, 18)
                .addGroup(vaixellPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(assignaCapitaButton)
                    .addComponent(capitansComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(noCapitaButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(circulenButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(treballenButton)
                .addContainerGap())
        );

        jPanel1.add(vaixellPanel, "card2");

        pescadorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        pescadorsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(pescadorsTable);

        jLabel5.setText("Nom:");

        jLabel6.setText("Experiència:");

        creaPescadorButton.setText("Crea");

        eliminaPescadorButton.setText("Elimina");

        modificaPescadorButton.setText("Modifica");

        javax.swing.GroupLayout pescadorPanelLayout = new javax.swing.GroupLayout(pescadorPanel);
        pescadorPanel.setLayout(pescadorPanelLayout);
        pescadorPanelLayout.setHorizontalGroup(
            pescadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pescadorPanelLayout.createSequentialGroup()
                .addGroup(pescadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pescadorPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pescadorPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(pescadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(pescadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomPescadorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(experienciaPescadorTextField))
                        .addGap(34, 34, 34)
                        .addGroup(pescadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modificaPescadorButton, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(creaPescadorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminaPescadorButton, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        pescadorPanelLayout.setVerticalGroup(
            pescadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pescadorPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(pescadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(nomPescadorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creaPescadorButton))
                .addGap(18, 18, 18)
                .addGroup(pescadorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(experienciaPescadorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminaPescadorButton))
                .addGap(18, 18, 18)
                .addComponent(modificaPescadorButton)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        jPanel1.add(pescadorPanel, "card3");

        portsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        portsTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(portsTable);

        jLabel7.setText("Nom:");

        jLabel8.setText("Capacitat:");

        creaPortButton.setText("Crea");

        eliminaPortButton.setText("Elimina");

        modificaPortButton.setText("Modifica");

        javax.swing.GroupLayout portPanelLayout = new javax.swing.GroupLayout(portPanel);
        portPanel.setLayout(portPanelLayout);
        portPanelLayout.setHorizontalGroup(
            portPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(portPanelLayout.createSequentialGroup()
                .addGroup(portPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(portPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(portPanelLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(portPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(portPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nomPortTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(capacitatPortTextField))
                        .addGap(34, 34, 34)
                        .addGroup(portPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(modificaPortButton, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(creaPortButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(eliminaPortButton, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        portPanelLayout.setVerticalGroup(
            portPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(portPanelLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addGroup(portPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(nomPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(creaPortButton))
                .addGap(18, 18, 18)
                .addGroup(portPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(capacitatPortTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminaPortButton))
                .addGap(18, 18, 18)
                .addComponent(modificaPortButton)
                .addContainerGap(203, Short.MAX_VALUE))
        );

        jPanel1.add(portPanel, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField anysVaixellTextField;
    private javax.swing.JButton assignaCapitaButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JTextField capacitatPortTextField;
    private javax.swing.JComboBox<Pescador> capitansComboBox;
    private javax.swing.JButton circulenButton;
    private javax.swing.JButton creaPescadorButton;
    private javax.swing.JButton creaPortButton;
    private javax.swing.JButton creaVaixellButton;
    private javax.swing.JButton eliminaPescadorButton;
    private javax.swing.JButton eliminaPortButton;
    private javax.swing.JButton eliminaVaixellButton;
    private javax.swing.JButton exitButton;
    private javax.swing.JTextField experienciaPescadorTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton modificaPescadorButton;
    private javax.swing.JButton modificaPortButton;
    private javax.swing.JButton modificaVaixellButton;
    private javax.swing.JButton noCapitaButton;
    private javax.swing.JTextField nomPescadorTextField;
    private javax.swing.JTextField nomPortTextField;
    private javax.swing.JTextField nomVaixellTextField;
    private javax.swing.JPanel pescadorPanel;
    private javax.swing.JTable pescadorsTable;
    private javax.swing.JPanel portPanel;
    private javax.swing.JTable portsTable;
    private javax.swing.JButton treballenButton;
    private javax.swing.JPanel vaixellPanel;
    private javax.swing.JTable vaixellTable;
    private javax.swing.JButton viewPescadorsButton;
    private javax.swing.JButton viewPortsButton;
    private javax.swing.JButton viewVaixellButton;
    // End of variables declaration//GEN-END:variables

    public JTextField getAnysVaixellTextField() {
        return anysVaixellTextField;
    }

    public JButton getCreaVaixellButton() {
        return creaVaixellButton;
    }

    public JButton getEliminaVaixellButton() {
        return eliminaVaixellButton;
    }

    public JButton getModificaVaixellButton() {
        return modificaVaixellButton;
    }

    public JTextField getNomVaixellTextField() {
        return nomVaixellTextField;
    }

    public JTable getVaixellTable() {
        return vaixellTable;
    }

    public JPanel getVaixellPanel() {
        return vaixellPanel;
    }

    public JButton getViewVaixellButton() {
        return viewVaixellButton;
    }

    public JPanel getWelcomePanel() {
        return jPanel2;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JButton getjButton1() {
        return jButton1;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JPanel getPescadorPanel() {
        return pescadorPanel;
    }

    public JTable getPescadorsTable() {
        return pescadorsTable;
    }

    public JButton getViewPescadorsButton() {
        return viewPescadorsButton;
    }

    public JButton getAssignaCapitaButton() {
        return assignaCapitaButton;
    }

    public JComboBox<Pescador> getCapitansComboBox() {
        return capitansComboBox;
    }

    public JButton getNoCapitaButton() {
        return noCapitaButton;
    }

    public JButton getCreaPescadorButton() {
        return creaPescadorButton;
    }

    public JButton getEliminaPescadorButton() {
        return eliminaPescadorButton;
    }

    public JTextField getExperienciaPescadorTextField() {
        return experienciaPescadorTextField;
    }

    public JButton getModificaPescadorButton() {
        return modificaPescadorButton;
    }

    public JTextField getNomPescadorTextField() {
        return nomPescadorTextField;
    }

    public JButton getTreballenButton() {
        return treballenButton;
    }

    public JTextField getCapacitatPortTextField() {
        return capacitatPortTextField;
    }

    public JButton getCreaPortButton() {
        return creaPortButton;
    }

    public JButton getEliminaPortButton() {
        return eliminaPortButton;
    }

    public JButton getModificaPortButton() {
        return modificaPortButton;
    }

    public JTextField getNomPortTextField() {
        return nomPortTextField;
    }

    public JTable getPortsTable() {
        return portsTable;
    }

    public JButton getViewPortsButton() {
        return viewPortsButton;
    }

    public JPanel getPortPanel() {
        return portPanel;
    }

    public JButton getCirculenButton() {
        return circulenButton;
    }
    
}
