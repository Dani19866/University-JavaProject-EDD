/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphproject.GUI;

import graphproject.App.App;
import java.awt.Component;
import java.awt.Dimension;

/**
 *
 * @author Daniel
 */
public class MainGUI extends javax.swing.JFrame {
    private static final App app = new App();
    
    private final Component relativeLocation = null;
    private final String titleUI = "Project EDD - Graphs";
    private final boolean resizableUI = false;
    private final Dimension minimunUI = new Dimension(320, 100);
    private final Dimension maximunUI = new Dimension(320, 100);
    
    private boolean enableButtons = true;
    
    /**
     * Creates new form Main
     * @param appParam
     */
    public MainGUI() {
        initComponents();
        
        // Window config
        this.setLocationRelativeTo(this.relativeLocation);
        this.setTitle(this.titleUI);
        this.setMinimumSize(this.minimunUI);
        this.setMaximumSize(this.maximunUI);
        this.setResizable(this.resizableUI);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        showIslands = new javax.swing.JButton();
        showGraphs = new javax.swing.JButton();
        newGraph = new javax.swing.JButton();
        actualGraph = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showIslands.setBackground(new java.awt.Color(255, 255, 255));
        showIslands.setText("Mostrar islas");
        showIslands.setEnabled(false);
        showIslands.setFocusPainted(false);
        showIslands.setFocusable(false);
        showIslands.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showIslandsActionPerformed(evt);
            }
        });
        jPanel1.add(showIslands, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 320, 50));

        showGraphs.setBackground(new java.awt.Color(255, 255, 255));
        showGraphs.setText("Mostrar grafos");
        showGraphs.setEnabled(false);
        showGraphs.setFocusPainted(false);
        showGraphs.setFocusable(false);
        showGraphs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showGraphsActionPerformed(evt);
            }
        });
        jPanel1.add(showGraphs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 50));

        newGraph.setBackground(new java.awt.Color(255, 255, 255));
        newGraph.setText("Nuevo grafo");
        newGraph.setFocusPainted(false);
        newGraph.setFocusable(false);
        newGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGraphActionPerformed(evt);
            }
        });
        jPanel1.add(newGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 160, 40));

        actualGraph.setBackground(new java.awt.Color(255, 255, 255));
        actualGraph.setText("Actual grafo");
        actualGraph.setFocusPainted(false);
        actualGraph.setFocusable(false);
        actualGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualGraphActionPerformed(evt);
            }
        });
        jPanel1.add(actualGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 160, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Functions">  
    private void showGraphsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showGraphsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showGraphsActionPerformed

    private void showIslandsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showIslandsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_showIslandsActionPerformed

    private void actualGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualGraphActionPerformed
        app.fileReader(false, this);
        app.verifyLines();
        
        this.showGraphs.setEnabled(enableButtons);
        this.showIslands.setEnabled(enableButtons);
    }//GEN-LAST:event_actualGraphActionPerformed

    private void newGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGraphActionPerformed
        app.fileReader(true, this);
        app.verifyLines();
        this.showGraphs.setEnabled(enableButtons);
        this.showIslands.setEnabled(enableButtons);
    }//GEN-LAST:event_newGraphActionPerformed
    //</editor-fold>
    
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton newGraph;
    private javax.swing.JButton showGraphs;
    private javax.swing.JButton showIslands;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
}
