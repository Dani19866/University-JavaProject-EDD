/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;
import user.Relations;
import user.User;

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
            String message = desc;
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        } else {
            String message = desc;
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Information">
    public static void information(String message) {
        JOptionPane.showMessageDialog(null, message, "Información", JOptionPane.INFORMATION_MESSAGE);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Selection">
    public static String Popup(String[] options) {
        int seleccion = JOptionPane.showOptionDialog(null, "Por favor, seleccione una opción", "Selección de tipo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);

        // Validar la selección del usuario
        if (seleccion == JOptionPane.CLOSED_OPTION) {
            return "";
        } else {
            String opcionSeleccionada = options[seleccion];
            return opcionSeleccionada;
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Popup">
    public static User requestUser() {
        try {
            // Solicitar ID al usuario
            String idInput = JOptionPane.showInputDialog("Ingrese el ID:");
            int id = Integer.parseInt(idInput);

            // Solicitar nombre de usuario al usuario
            String username = JOptionPane.showInputDialog("Ingrese el nombre de usuario:");

            User user = new User(id, username);
            return user;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número entero.");
            return null;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: Se canceló el ingreso de datos.");
            return null;
        }
    }

    public static Relations requestRelation() {
        try {
            // Solicitar ID de origen al usuario
            String sourceIdInput = JOptionPane.showInputDialog("Ingrese el ID de origen:");
            int sourceId = Integer.parseInt(sourceIdInput);

            // Solicitar ID de destino al usuario
            String destinationIdInput = JOptionPane.showInputDialog("Ingrese el ID de destino:");
            int destinationId = Integer.parseInt(destinationIdInput);

            // Solicitar peso al usuario
            String weightInput = JOptionPane.showInputDialog("Ingrese el peso:");
            int weight = Integer.parseInt(weightInput);

            Relations relation = new Relations(sourceId, destinationId, weight);
            return relation;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Los valores deben ser números enteros.");
            return null;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: Se canceló el ingreso de datos.");
            return null;
        }
    }

    public static int[] request2Id() {
        try {
            // Solicitar ID de origen al usuario
            String sourceIdInput = JOptionPane.showInputDialog("Ingrese el ID de origen:");
            int sourceId = Integer.parseInt(sourceIdInput);

            // Solicitar ID de destino al usuario
            String destinationIdInput = JOptionPane.showInputDialog("Ingrese el ID de destino:");
            int destinationId = Integer.parseInt(destinationIdInput);

            int[] values = {sourceId, destinationId};
            
            return values;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Los valores deben ser números enteros.");
            return null;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: Se canceló el ingreso de datos.");
            return null;
        }
    }
    
    public static int requestId(){
        try {
            // Solicitar ID al usuario
            String idInput = JOptionPane.showInputDialog("Ingrese el ID del nodo (usuario):");
            int id = Integer.parseInt(idInput);

            return id;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El valor debe ser un número entero.");
            return -1;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: Se canceló el ingreso de datos.");
            return -1;
        }
    }
    
    public static int requestNodes() {
        try {
            // Solicitar ID al usuario
            String idInput = JOptionPane.showInputDialog("Ingrese el número máximo de nodos:");
            int nodes = Integer.parseInt(idInput);

            return nodes;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El valor debe ser un número entero.");
            return -1;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: Se canceló el ingreso de datos.");
            return -1;
        }
    }
// </editor-fold>
}
