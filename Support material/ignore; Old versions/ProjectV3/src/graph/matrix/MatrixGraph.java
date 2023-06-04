/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.matrix;

import linkedList.LinkedList;
import user.Relations;
import user.User;
import utils.Queue;
import utils.Utils;

/**
 * Represents a matrix-based graph. This class provides functionality for
 * creating and manipulating a graph using an adjacency matrix. It supports
 * adding vertices and edges, setting the maximum number of nodes, and managing
 * graph properties.
 *
 * @author Daniel
 */
public class MatrixGraph {

    public boolean addressed;                               // Indica si es dirigido o no.
    public int size;                                       // Tamaño máximo de la tabla.
    public int numNodes;                                   // Número de vértices del grafo.
    public int matrix[][];                                 // Matriz de adyacencias del grafo.
    public LinkedList<User> nodes = new LinkedList();      // Lista de información de nodos
    public boolean info = false;

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
                if (info) {
                    Utils.information("El usuario " + user.user + " ha sido añadido!");
                }
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
            // Mover las filas y columnas para cubrir el hueco en la matriz
            for (int i = index; i < numNodes; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[j][i] = matrix[j][i + 1]; // Mover las filas hacia arriba
                }
            }
            for (int i = index; i < numNodes; i++) {
                for (int j = 0; j < size; j++) {
                    matrix[i][j] = matrix[i + 1][j]; // Mover las columnas hacia la izquierda
                }
            }

            Utils.information("El usuario " + user.user + " ha sido eliminado!");

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

        if (userOrigin.user == null || userDestination.user == null) {
            Utils.error("ERROR! Uno de los usuarios introducidos no existe", false);
        } else {
            int userMatrixOrigin = nodes.searchIndex(userOrigin);
            int userMatrixDestinacion = nodes.searchIndex(userDestination);

            // Bidireccional
            if (!this.addressed) {
                this.matrix[userMatrixOrigin][userMatrixDestinacion] = this.matrix[userMatrixDestinacion][userMatrixOrigin] = relation.weight;
            } // Direccional
            else {
                
                this.matrix[userMatrixOrigin][userMatrixDestinacion] = relation.weight;
            }

            if (info) {
                Utils.information("La relación ha sido añadida!");
            }
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

        // Usuarios no existe
        if (userOrigin == null || userDestination == null) {
            Utils.error("ERROR! Uno de los usuarios introducidos no existe", false);
        } else {
            // Usuarios con enlace
            if (matrix[indexOrigin][indexDestination] != 0) {
                matrix[indexOrigin][indexDestination] = 0;

                if (!addressed) {
                    matrix[indexDestination][indexOrigin] = 0;
                }

                Utils.information("El usuario " + userOrigin.user + " ha sido desenlazado de " + userDestination.user);
            } else {
                Utils.error("ERROR! Estos usuarios no tienen enlaces", false);
            }

        }

    }
    // </editor-fold>

    // Get: Grade in/out, incidence, size, exist edges
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

        // Si el usuario existe
        if (user.user != null) {
            int indexUser = nodes.searchIndex(user);
            for (int i = 0; i < this.size; i++) {
                if (this.matrix[i][indexUser] != 0) {
                    gIn++;
                }
            }
            return gIn;
        } // No existe usuario
        else {
            Utils.error("ERROR! El usuario no existe", false);
            return -1;
        }

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

        if (user.user != null) {
            int indexUser = nodes.searchIndex(user);
            for (int j = 0; j < this.size; j++) {
                if (this.matrix[indexUser][j] != 0) {
                    gOut++;
                }
            }
            return gOut;
        } else {
            Utils.error("ERROR! El usuario no existe", false);
            return -1;
        }

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
    public void getExistEdges(int origin, int destination) {
        User userOrigin = new User(origin, nodes.searchUserWithID(origin));
        int indexOrigin = nodes.searchIndex(userOrigin);
        User userDestination = new User(destination, nodes.searchUserWithID(destination));
        int indexDestination = nodes.searchIndex(userDestination);

        if (userOrigin.user != null && userDestination != null) {
            if (matrix[indexOrigin][indexDestination] != 0) {
                Utils.information("El enlace existe! El peso es " + matrix[indexOrigin][indexDestination]);
            } else {
                Utils.information("El enlace no existe!");
            }
//            return matrix[indexOrigin][indexDestination] != 0;
        } else {
            Utils.error("ERROR! Uno de los usuarios no existe", false);
        }
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

            Utils.information("El valor máximo de nodos se ha cambiado a " + x);
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

    // Algorithms: BFS, DFS, Bridge identification, reset path (for bfs)
    // <editor-fold defaultstate="collapsed" desc="Algorithms">
    public int bfs(int id) {
        //-----------------------------------------------------------------
        // Verificar si el vértice con el ID dado existe en el grafo
        User user = new User(id, nodes.searchUserWithID(id));
        int index = nodes.searchIndex(user);
        if (index == -1) {
            Utils.error("ERROR! El usuario con el ID especificado no existe", false);
            return -1;
        }
        //--------------------------------------
        // Marcar todos los nodos como no visitados
        boolean[] visited = new boolean[numNodes];

        // Crear una cola para el recorrido BFS
        Queue<Integer> queue = new Queue<>();

        // Marcar el nodo actual como visitado y encolarlo
        visited[index] = true;
        queue.enqueue(index);

        // Imprimir el recorrido BFS
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {

            // Desencolar un vértice de la cola y mostrarlo
            int nodeIndex = queue.dequeue();
            User currentNode = nodes.searchUserWithSource(nodeIndex);
            sb.append(currentNode.user).append(" ");

            // Obtener todos los nodos adyacentes al nodo actual y encolarlos si no han sido visitados
            for (int i = 0; i < numNodes; i++) {
                if (matrix[nodeIndex][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.enqueue(i);
                }
            }
        }

        // Retornar la cantidad de nodos visitados en el recorrido BFS
        int count = 0;
        for (boolean v : visited) {
            if (v) {
                count++;
            }
        }
        return count;
        // -------------------------------------
    }

    public int dfs(int id) {
        // Verificar si el vértice con el ID dado existe en el grafo
        User user = new User(id, nodes.searchUserWithID(id));
        int index = nodes.searchIndex(user);
        if (index == -1) {
            Utils.error("ERROR! El usuario con el ID especificado no existe", false);
            return -1;
        }

        // Marcar todos los nodos como no visitados
        boolean[] visited = new boolean[numNodes];

        // Realizar el recorrido DFS y obtener el resultado
        StringBuilder sb = new StringBuilder();
        int count = dfsHelper(index, visited, sb);

        // Retornar la cantidad de nodos visitados en el recorrido DFS
        return count;
    }

    private int dfsHelper(int nodeIndex, boolean[] visited, StringBuilder sb) {
        // Marcar el nodo actual como visitado
        visited[nodeIndex] = true;

        // Agregar el nodo actual al recorrido
        User currentNode = nodes.searchUserWithSource(nodeIndex);
        sb.append(currentNode.user).append(" ");

        // Inicializar el contador de nodos visitados
        int count = 1;

        // Obtener todos los nodos adyacentes al nodo actual y realizar el recorrido DFS en ellos
        for (int i = 0; i < numNodes; i++) {
            if (matrix[nodeIndex][i] != 0 && !visited[i]) {
                count += dfsHelper(i, visited, sb);
            }
        }

        // Retornar la cantidad de nodos visitados en el recorrido DFS
        return count;
    }

    public String bridgeIdentification() {
        String line;
        line = "Esta función no está disponible en estos momentos.";
        return line;
    }
    // </editor-fold>
}
