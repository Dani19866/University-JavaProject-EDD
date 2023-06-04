/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import app.App;
import java.awt.Component;

/**
 *
 * @author Daniel
 */
public class MainGUI extends javax.swing.JFrame {
    private static App app;
    
    private final Component relativeLocation = null;
    private final String titleUI = "Project EDD - Graphs";
    private final boolean resizableUI = false;

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form MainGUI
     * @param appParam App Class is indispensable to work
     */
    public MainGUI(App appParam) {
        initComponents();
        
        // App config
        app = appParam;

        // Window config
        this.setLocationRelativeTo(this.relativeLocation);
        this.setTitle(this.titleUI);
        this.setResizable(this.resizableUI);
        this.setVisible(true);
    }
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        graphLayout = new javax.swing.JPanel();
        seeGraphsButton = new javax.swing.JButton();
        graph = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        actualFile = new javax.swing.JMenuItem();
        toolsMenu = new javax.swing.JMenu();
        restartGraph = new javax.swing.JMenuItem();
        initStateGraph = new javax.swing.JMenuItem();

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        graphLayout.setBackground(new java.awt.Color(80, 80, 80));
        graphLayout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        seeGraphsButton.setBackground(new java.awt.Color(255, 255, 255));
        seeGraphsButton.setText("Ver grafos");
        seeGraphsButton.setEnabled(false);
        seeGraphsButton.setFocusPainted(false);
        seeGraphsButton.setFocusable(false);
        seeGraphsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seeGraphsButtonActionPerformed(evt);
            }
        });
        graphLayout.add(seeGraphsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 160, 40));

        graph.setBackground(new java.awt.Color(80, 80, 80));
        graph.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        graphLayout.add(graph, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 430));

        getContentPane().add(graphLayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 430));

        menuBar.setBackground(new java.awt.Color(160, 160, 160));
        menuBar.setBorderPainted(false);

        fileMenu.setBackground(new java.awt.Color(255, 255, 255));
        fileMenu.setText("Archivo");

        newFile.setText("Nuevo archivo");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        fileMenu.add(newFile);

        actualFile.setText("Actual archivo");
        actualFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualFileActionPerformed(evt);
            }
        });
        fileMenu.add(actualFile);

        menuBar.add(fileMenu);

        toolsMenu.setBackground(new java.awt.Color(255, 255, 255));
        toolsMenu.setText("Herramientas");

        restartGraph.setText("Reiniciar grafo");
        toolsMenu.add(restartGraph);

        initStateGraph.setText("Cargar estado inicial");
        toolsMenu.add(initStateGraph);

        menuBar.add(toolsMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Open graphs GUI
     */
    private void seeGraphsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seeGraphsButtonActionPerformed
        app.showGraphs();
    }//GEN-LAST:event_seeGraphsButtonActionPerformed

    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        app.fileAlgorithm(true, this);
        seeGraphsButton.setEnabled(true);
    }//GEN-LAST:event_newFileActionPerformed

    private void actualFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualFileActionPerformed
        app.fileAlgorithm(false, this);
        seeGraphsButton.setEnabled(true);
    }//GEN-LAST:event_actualFileActionPerformed
   // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Main function">
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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainGUI(app).setVisible(true);
        });
    }
    // </editor-fold>  

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actualFile;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPanel graph;
    private javax.swing.JPanel graphLayout;
    private javax.swing.JMenuItem initStateGraph;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem restartGraph;
    private javax.swing.JButton seeGraphsButton;
    private javax.swing.JMenu toolsMenu;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
