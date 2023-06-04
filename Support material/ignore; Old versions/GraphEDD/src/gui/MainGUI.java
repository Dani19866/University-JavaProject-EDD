/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import app.App;
import java.awt.Component;
import java.awt.Dimension;

/**
 *
 * @author Daniel
 */
public class MainGUI extends javax.swing.JFrame {

    // App object
    private static final App app = new App();
    // Windows config
    private final Component relativeLocation = null;
    private final String titleUI = "Project EDD - Graphs";
    private final boolean resizableUI = false;
    private final Dimension minimunUI = new Dimension(261, 250);
    private final Dimension maximunUI = new Dimension(261, 250);
    // To manage buttons
    private final boolean enableButtons = true;
    // <editor-fold defaultstate="collapsed" desc="Funciones solo HABILITADAS en desarrollo">
    private final boolean automaticActualGraph = true;
    // </editor-fold>  

    public MainGUI() {
        initComponents();

        // Window config
        this.setLocationRelativeTo(this.relativeLocation);
        this.setTitle(this.titleUI);
        this.setMinimumSize(this.minimunUI);
        this.setMaximumSize(this.maximunUI);
        this.setResizable(this.resizableUI);
        
        // Automatic 
        if (this.automaticActualGraph) this.actualGraphActionPerformed(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalLayout = new javax.swing.JPanel();
        showInfoGraphs = new javax.swing.JButton();
        showGraphs = new javax.swing.JButton();
        newGraph = new javax.swing.JButton();
        actualGraph = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        principalLayout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showInfoGraphs.setBackground(new java.awt.Color(255, 255, 255));
        showInfoGraphs.setText("Mostar información de grafos (Islas)");
        showInfoGraphs.setEnabled(false);
        showInfoGraphs.setFocusPainted(false);
        showInfoGraphs.setFocusable(false);
        showInfoGraphs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInfoGraphsActionPerformed(evt);
            }
        });
        principalLayout.add(showInfoGraphs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 260, 40));

        showGraphs.setBackground(new java.awt.Color(255, 255, 255));
        showGraphs.setText("Mostrar grafos (Islas)");
        showGraphs.setEnabled(false);
        showGraphs.setFocusPainted(false);
        showGraphs.setFocusable(false);
        showGraphs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGraphsActionPerformed(evt);
            }
        });
        principalLayout.add(showGraphs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 40));

        newGraph.setBackground(new java.awt.Color(255, 255, 255));
        newGraph.setText("Nuevo grafo");
        newGraph.setFocusPainted(false);
        newGraph.setFocusable(false);
        newGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGraphActionPerformed(evt);
            }
        });
        principalLayout.add(newGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 130, 30));

        actualGraph.setBackground(new java.awt.Color(255, 255, 255));
        actualGraph.setText("Actual grafo");
        actualGraph.setFocusPainted(false);
        actualGraph.setFocusable(false);
        actualGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualGraphActionPerformed(evt);
            }
        });
        principalLayout.add(actualGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Functions">
    private void showGraphsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGraphsActionPerformed
        app.showGraphs();
    }//GEN-LAST:event_showGraphsActionPerformed

    private void showInfoGraphsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInfoGraphsActionPerformed
        app.showInfoGraphs();
    }//GEN-LAST:event_showInfoGraphsActionPerformed

    private void actualGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualGraphActionPerformed
        app.fileReader(false, this);
        app.verifyLines();
        app.tests();

        this.showGraphs.setEnabled(enableButtons);
        this.showInfoGraphs.setEnabled(enableButtons);
    }//GEN-LAST:event_actualGraphActionPerformed

    private void newGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGraphActionPerformed
        app.fileReader(true, this);
        app.verifyLines();

        this.showGraphs.setEnabled(enableButtons);
        this.showInfoGraphs.setEnabled(enableButtons);
    }//GEN-LAST:event_newGraphActionPerformed
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
            new MainGUI().setVisible(true);
        });
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualGraph;
    private javax.swing.JButton newGraph;
    private javax.swing.JPanel principalLayout;
    private javax.swing.JButton showGraphs;
    private javax.swing.JButton showInfoGraphs;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
