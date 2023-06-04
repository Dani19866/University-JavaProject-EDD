/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;

/**
 * Class of utilities to keep clean and readable the code
 *
 * @author Daniel
 */
public class Utils {

    // <editor-fold defaultstate="collapsed" desc="Errors">
    /**
     * Function to appears popup window to warn of errors of user
     *
     * @param desc Description of error
     * @param fatal True to close program (for fatal error)
     */
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
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Selection">
    public static String Popup(String[] options){
        int seleccion = JOptionPane.showOptionDialog(null, "Por favor, seleccione una opción", "Selección de tipo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

        // Validar la selección del usuario
        if (seleccion == JOptionPane.CLOSED_OPTION) {
            Utils.error("ERROR! Opción no válida, por favor seleccione una opción de nuevo, cerrando programa...", true);
            return "";
        } else {
            String opcionSeleccionada = options[seleccion];
            return opcionSeleccionada;
        }
    }
    // </editor-fold>
}
