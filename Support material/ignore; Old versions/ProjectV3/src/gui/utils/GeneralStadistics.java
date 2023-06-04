/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.utils;

import gui.GUI;
import javax.swing.JFrame;

/**
 *
 * @author Daniel
 */
public class GeneralStadistics extends javax.swing.JFrame {
    
    private static GUI father;
    
    /** Creates new form GeneralStadistics
     * @param father JFrame father
     */
    public GeneralStadistics(GUI father) {
        initComponents();
        this.father = father;
        
        // Window config
        this.setTitle("General stadistics");
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(father);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Window stadistics
        nodesData.setText(String.valueOf(father.numNodes));
        relationsData.setText(String.valueOf(father.allConections));
        sizemaxData.setText(String.valueOf(father.sizeGraph));
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalLayout = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        sizeMax = new javax.swing.JLabel();
        relations = new javax.swing.JLabel();
        relationsData = new javax.swing.JLabel();
        nodes = new javax.swing.JLabel();
        nodesData = new javax.swing.JLabel();
        sizemaxData = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        principalLayout.setBackground(new java.awt.Color(80, 80, 80));
        principalLayout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setLabelFor(title);
        title.setText("GENERAL STADISTICS OF GRAPH");
        title.setToolTipText("");
        title.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        principalLayout.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 280, 25));

        sizeMax.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sizeMax.setForeground(new java.awt.Color(255, 255, 255));
        sizeMax.setText("Size max");
        principalLayout.add(sizeMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 70, 20));

        relations.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        relations.setForeground(new java.awt.Color(255, 255, 255));
        relations.setText("Relations");
        principalLayout.add(relations, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 70, 20));

        relationsData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        relationsData.setForeground(new java.awt.Color(255, 255, 255));
        principalLayout.add(relationsData, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 40, 20));

        nodes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nodes.setForeground(new java.awt.Color(255, 255, 255));
        nodes.setText("Nodes");
        principalLayout.add(nodes, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 70, 20));

        nodesData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        nodesData.setForeground(new java.awt.Color(255, 255, 255));
        principalLayout.add(nodesData, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, 40, 20));

        sizemaxData.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        sizemaxData.setForeground(new java.awt.Color(255, 255, 255));
        principalLayout.add(sizemaxData, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 40, 20));

        getContentPane().add(principalLayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 170));

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
            java.util.logging.Logger.getLogger(GeneralStadistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneralStadistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneralStadistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneralStadistics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GeneralStadistics(father).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nodes;
    private javax.swing.JLabel nodesData;
    private javax.swing.JPanel principalLayout;
    private javax.swing.JLabel relations;
    private javax.swing.JLabel relationsData;
    private javax.swing.JLabel sizeMax;
    private javax.swing.JLabel sizemaxData;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables

}
