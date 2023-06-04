/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.matrix;

import linkedList.LinkedList;
import user.Relations;
import user.User;
import utils.Utils;

/**
 * Represents a matrix-based graph.
 * This class provides functionality for creating and manipulating a graph using an adjacency matrix.
 * It supports adding vertices and edges, setting the maximum number of nodes, and managing graph properties.
 *
 * @author Daniel
 */
public class MatrixGraph {

    public boolean addressed;                               // Indica si es dirigido o no.
    public int size;                                       // Tamaño máximo de la tabla.
    public int numNodes;                                   // Número de vértices del grafo.
    public int matrix[][];                                 // Matriz de adyacencias del grafo.
    public LinkedList<User> nodes = new LinkedList();      // Lista de información de nodos

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Build a matrix graph
     *
     * @param addresed True to create a addressed graph
     */
    public MatrixGraph(boolean addresed) {
        this.addressed = addresed;
        this.size = this.numNodes = 0;
    }

    /**
     * Build a matrix graph
     *
     * @param addresed True to create a addressed graph
     * @param numNodes Number max of nodes allowed and create a matrix with it
     */
    public MatrixGraph(boolean addresed, int numNodes) {
        this.addressed = addresed;
        this.size = numNodes;
        this.numNodes = 0;
        this.matrix = new int[numNodes][numNodes];
    }
    // </editor-fold>

    // Vertex: Add, delete
    // <editor-fold defaultstate="collapsed" desc="Vertex functions">
    /**
     * Add vertex (node) to graph
     *
     * @param user User to add (User class: ID and username)
     */
    public void addVertex(User user) {
        if (this.numNodes >= this.size) {
            Utils.error("ERROR! Capacidad máxima de usuarios (nodos) permitidos", false);
        } else {
            if (nodes.searchUser(user)) {
                Utils.error("ERROR! Este usuario (nodo) ya se encuentra añadido", false);
            } else {
                this.nodes.addLast(user);
                this.numNodes++;
            }
        }
    }

    /**
     * Delete vertex (node) to graph
     *
     * @param user User to delete (User class: ID and username)
     */
    public void delVertex(User user) {
        int index = nodes.searchIndex(user);
        if (index != -1) {
            nodes.delete(index);
            numNodes--;

            // Eliminar conexiones del vértice eliminado en la matriz de adyacencia
            for (int i = 0; i < size; i++) {
                matrix[index][i] = 0; // Eliminar aristas de salida
                matrix[i][index] = 0; // Eliminar aristas de entrada
            }
        } else {
            Utils.error("ERROR! No se encontró el usuario (nodo) especificado", false);
        }
    }
    // </editor-fold>

    // Edges: Add, delete
    // <editor-fold defaultstate="collapsed" desc="Edges functions">
    /**
     * Add edge to graph
     *
     * @param relation Relation to add (Relation Class: ID 1, ID 2, weight)
     */
    public void addEdge(Relations relation) { // a = i || b = j
        User userOrigin = new User(relation.userOrigin, nodes.searchUserWithID(relation.userOrigin));
        User userDestination = new User(relation.userDestination, nodes.searchUserWithID(relation.userDestination));
        int userMatrixOrigin = nodes.searchIndex(userOrigin);
        int userMatrixDestinacion = nodes.searchIndex(userDestination);

        // Bidireccional
        if (!this.addressed) {
            this.matrix[userMatrixOrigin][userMatrixDestinacion] = this.matrix[userMatrixDestinacion][userMatrixOrigin] = relation.weight;
        } // Direccional
        else {
            this.matrix[userMatrixOrigin][userMatrixDestinacion] = relation.weight;
        }
    }

    /**
     * Delete edge to graph
     *
     * @param origin Know what origin node is to del connection
     * @param destination Know what destination node is to del connection
     */
    public void delEdge(int origin, int destination) {
        User userOrigin = new User(origin, nodes.searchUserWithID(origin));
        int indexOrigin = nodes.searchIndex(userOrigin);
        User userDestination = new User(destination, nodes.searchUserWithID(destination));
        int indexDestination = nodes.searchIndex(userDestination);

        if (indexOrigin != -1 && indexDestination != -1) {
            matrix[indexOrigin][indexDestination] = 0;

            if (!addressed) {
                matrix[indexDestination][indexOrigin] = 0;
            }
        } else {
            Utils.error("ERROR! No se encontró el origen o destino especificado", false);
        }
    }
    // </editor-fold>

    // Get: Grade in/ot, incidence, size, exist edges
    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Get grades in of node (how nodes aim to node)
     *
     * @param x ID user to know
     * @return Values of nodes aim to it
     */
    public int getGradeIn(int x) {
        // 1. Return value (Value of relations to node)
        int gIn = 0;
        User user = new User(x, nodes.searchUserWithID(x));
        int indexUser = nodes.searchIndex(user);

        // 2. Loop of size of matrix
        for (int i = 0; i < this.size; i++) {
            // 2.1. If column has value (Is true)
            if (this.matrix[i][indexUser] != 0) {
                gIn++;
            }
        }
        return gIn;
    }

    /**
     * Get grades out of node (how nodes aim to node)
     *
     * @param x ID user to know
     * @return Values of nodes aim to it
     */
    public int getGradeOut(int x) {
        // 1. Return value (Value of relations to node)
        int gOut = 0;
        User user = new User(x, nodes.searchUserWithID(x));
        int indexUser = nodes.searchIndex(user);

        // 2. Loop of size of matrix
        for (int j = 0; j < this.size; j++) {
            // 2.1. If row has value (Is true)
            if (this.matrix[indexUser][j] != 0) {
                gOut++;
            }
        }
        return gOut;
    }

    /**
     * Return incidence of node
     *
     * @param x ID of user
     * @return Values of incidence
     */
    public int getIncidence(int x) {
        if (!this.addressed) {
            return this.getGradeIn(x);
        } else {
            return this.getGradeIn(x) + this.getGradeOut(x);
        }
    }

    /**
     * Size of graph
     *
     * @return Size of graph
     */
    public int getSize() {
        int tm = 0;
        for (int i = 0; i < this.numNodes; i++) {
            for (int j = 0; j < this.numNodes; j++) {
                if (this.matrix[i][j] != 0) {
                    tm++;
                }
            }
        }
        if (this.addressed) {
            return tm;
        } else {
            return tm / 2;
        }
    }

    /**
     * Know is addressed (without principal variables of class)
     *
     * @return true if is addressed
     */
    public boolean isAddresed() {
        boolean dir = true;
        for (int i = 0; i < this.numNodes; i++) {
            for (int j = 0; j < this.numNodes; j++) {
                if (this.matrix[i][j] != this.matrix[j][i]) {
                    dir = false;
                }
            }
        }
        return dir;
    }

    /**
     * Checks if there exists an edge between the given origin and destination
     * vertices.
     *
     * @param origin The identifier of the origin vertex.
     * @param destination The identifier of the destination vertex.
     * @return true if an edge exists between the origin and destination
     * vertices, false otherwise.
     */
    public boolean getExistEdges(int origin, int destination) {
        User userOrigin = new User(origin, nodes.searchUserWithID(origin));
        int indexOrigin = nodes.searchIndex(userOrigin);
        User userDestination = new User(destination, nodes.searchUserWithID(destination));
        int indexDestination = nodes.searchIndex(userDestination);

        return matrix[indexOrigin][indexDestination] != 0;
    }
    // </editor-fold>

    // Set: Max nodes, addressed
    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Sets the maximum number of nodes in the graph to the specified value.
     *
     * @param x The new maximum number of nodes.
     * @throws IllegalArgumentException if the new maximum size is not greater
     * than the current size.
     */
    public void setMaxNodes(int x) {
        if (x <= size) {
            Utils.error("ERROR! El nuevo tamaño máximo debe ser mayor al tamaño actual", false);
        } else {
            int[][] newMatrix = new int[x][x];
            for (int i = 0; i < size; i++) {
                // System.arraycopy(matrixVieja, desdeDondeEmpiezaACopiar, desdeDondeEmpiezaAPegar, elementosACopiar)
                System.arraycopy(matrix[i], 0, newMatrix[i], 0, size);
            }
            matrix = newMatrix;
            size = x;
        }
    }

    /**
     * Sets the addressed property of the graph.
     *
     * @param x true if the graph is addressed (directed), false if it is
     * unaddressed (undirected).
     */
    public void setAddressed(boolean x) {
        addressed = x;
    }
    // </editor-fold>

    // Helpers: Show table
    // <editor-fold defaultstate="collapsed" desc="Helpers">
    /**
     * Prints the adjacency matrix representation of the graph. This method
     * displays the matrix elements representing the edges between vertices. It
     * is useful for visualizing the connectivity of the graph.
     */
    public void helperShowTable() {
        System.out.println("La matriz contiene " + this.numNodes + " vértices: \n");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    // </editor-fold>
}
