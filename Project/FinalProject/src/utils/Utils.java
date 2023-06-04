/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javax.swing.JOptionPane;

/**
 * Utility class with helper methods for displaying messages and interacting
 * with the user.
 *
 * @author Daniel
 */
public class Utils {

    /**
     * Displays an error message dialog with the specified message.
     *
     * @param message The error message to display.
     */
    public static void error(String message) {
        JOptionPane.showMessageDialog(null, "ERROR! " + message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays an error message dialog indicating that the user was not found.
     */
    public static void errorUserNotFound() {
        JOptionPane.showMessageDialog(null, "ERROR! El usuario no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays an error message dialog indicating that the maximum number of
     * nodes has been reached.
     */
    public static void errorMaxNodes() {
        JOptionPane.showMessageDialog(null, "ERROR! Se ha alcanzado el número máximo de nodos permitidos", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays an error message dialog indicating that the graph is empty and
     * users cannot be deleted.
     */
    public static void errorEmptyGraph() {
        JOptionPane.showMessageDialog(null, "ERROR! No se puede eliminar usuarios ya que el grafo se encuentra vacío", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays an error message indicating empty relations for a node.
     */
    public static void errorEmptyRelation() {
        JOptionPane.showMessageDialog(null, "ERROR! Este nodo no tiene relaciones", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays an error message dialog indicating that one of the users entered
     * does not exist.
     */
    public static void errorSomeUserNotFound() {
        JOptionPane.showMessageDialog(null, "ERROR! Uno de los usuarios introducidos no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays an error message for an existing user.
     */
    public static void errorUserAlreadyExist() {
        JOptionPane.showMessageDialog(null, "ERROR! El usuario ya existe", "ERROR", JOptionPane.ERROR_MESSAGE);

    }

    /**
     * Displays an error message dialog indicating that the new size must be
     * greater than the current size.
     */
    public static void errorSettingMaxNodes() {
        JOptionPane.showMessageDialog(null, "ERROR! El nuevo tamaño debe ser mayor al tamaño actual", "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Displays a success message dialog indicating that a user has been
     * successfully added.
     *
     * @param user The name of the user that was added.
     */
    public static void succesfullyUserAdded(String user) {
        JOptionPane.showMessageDialog(null, "El usuario " + user + " se ha añadido correctamente!", "SUCCESFULLY", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays a success message dialog indicating that a user has been
     * successfully deleted.
     *
     * @param user The name of the user that was deleted.
     */
    public static void succesfullyUserDelete(String user) {
        JOptionPane.showMessageDialog(null, "El usuario " + user + " se ha eliminado correctamente!", "SUCCESFULLY", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays a success message dialog indicating that a relation has been
     * successfully added.
     *
     * @param userOrigin
     * @param userDestination
     * @param weight
     * @param user The name of the user the relation was added to.
     */
    public static void succesfullyRelationAdded(int userOrigin, int userDestination, int weight) {
        JOptionPane.showMessageDialog(null, "El nodo " + userOrigin + " ha sido enlazado a " + userDestination + " con un peso de " + weight + "!", "SUCCESFULLY", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays a success message dialog indicating that a relation has been
     * successfully deleted.
     *
     * @param userOrigin User origin of relation
     * @param userDestinatión User destination of relation
     */
    public static void succesfullyRelationDelete(int userOrigin, int userDestinatión) {
        JOptionPane.showMessageDialog(null, "El nodo " + userOrigin + " ha sido desenlazado de " + userDestinatión + "!", "SUCCESFULLY", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays a success message dialog indicating that a max nodes of graph has
     * been changed to the param passed
     * 
     * @param x Numbers of nodes
     */
    public static void succesfullyMaxNodesChange(int x) {
        JOptionPane.showMessageDialog(null, "El valor máximo de nodos se ha cambiado a " + x, "SUCCESFULLY", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Displays an information message dialog with the specified message.
     *
     * @param message The information message to display.
     */
    public static void information(String message) {
        JOptionPane.showMessageDialog(null, message, "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Prompts the user to enter the maximum number of nodes and returns the
     * entered value.
     *
     * @return The maximum number of nodes entered by the user, or -1 if the
     * input is invalid or canceled.
     */
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

    /**
     * Prompts the user to create a user node by entering the ID and username,
     * and returns the created User object.
     *
     * @return The created User object, or null if the input is invalid or
     * canceled.
     */
    public static User createUserNode() {
        try {
            // Solicitar ID al usuario
            String idInput = JOptionPane.showInputDialog("Ingrese el ID:");
            int id = Integer.parseInt(idInput);

            // Solicitar nombre de usuario al usuario
            String usernameA = JOptionPane.showInputDialog("Ingrese el nombre de usuario (Sin espacios entre letras):");

            // Filtrar y limpiar
            usernameA = usernameA.strip();
            String[] usernameB = usernameA.split(" ");

            // Verificar
            if (usernameB.length > 1) {
                Utils.error("Usuario no válido! No se permiten espacios entre letras");
                return null;
            }

            // ------------------------
            // VERIFICAR DISPONIBILIDAD
            // ------------------------
            // ----------------------------------
            User user = new User(id, usernameB[0]);
            return user;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: El ID debe ser un número entero.");
            return null;
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Error: Se canceló el ingreso de datos.");
            return null;
        }
    }

    /**
     * Prompts the user to create a relation by entering the source ID,
     * destination ID, and weight, and returns the created Relations object.
     *
     * @return The created Relations object, or null if the input is invalid or
     * canceled.
     */
    public static Relations createRelation() {
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

    /**
     * Prompts the user to enter the source and destination IDs, and returns the
     * entered values as an array.
     *
     * @return An array containing the source and destination IDs entered by the
     * user, or null if the input is invalid or canceled.
     */
    public static int[] requestIds() {
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

    /**
     * Prompts the user to enter a single ID and returns the entered value.
     *
     * @return The ID entered by the user, or -1 if the input is invalid or
     * canceled.
     */
    public static int requestId() {
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
}
