/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel
 */
public class Utils {
    static public void error(String desc, boolean fatal) {
        String title = "Error";

        if (fatal) {
            String message = "ERROR FATAL: " + desc;
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            String message = "ERROR: " + desc;
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        }
    }
}
