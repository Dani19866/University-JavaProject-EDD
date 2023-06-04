/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import graphs.matrix.MatrixGraph;
import java.awt.Graphics;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class MatrixGUI extends javax.swing.JFrame {

    private static MatrixGraph graph;

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form MatrixGUI
     *
     * @param graphParam
     */
    public MatrixGUI(MatrixGraph graphParam) {
        initComponents();

        // Window config
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Graph class
        graph = graphParam;
        
        this.nodesAlgorithm();
    }
    // </editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalLayout = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        principalLayout.setBackground(new java.awt.Color(255, 255, 255));
        principalLayout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(principalLayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1170, 530));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MatrixGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrixGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrixGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrixGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MatrixGUI(graph).setVisible(true);
        });
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel principalLayout;
    // End of variables declaration//GEN-END:variables
    //</editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Automatic algorithms">
    private void nodesAlgorithm(){
        for (int i = 0; i < graph.numNodes; i++) {
            
        }
    }
    //</editor-fold>
}
