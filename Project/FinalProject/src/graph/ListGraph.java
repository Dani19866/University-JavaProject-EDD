/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import utils.Queue;
import utils.Relations;
import utils.Stack;
import utils.User;
import utils.Utils;

/**
 * The ListGraph class represents a graph using an adjacency list
 * implementation. It supports various operations such as adding and deleting
 * vertices, adding and deleting edges, calculating degrees of vertices,
 * checking graph properties, and performing graph traversal algorithms like BFS
 * and DFS.
 *
 * @author Daniel
 */
public class ListGraph {

    /**
     * Control add/remove edges when graph is addressed or no
     */
    public boolean addressed;
    /**
     * Size max nodes of graph
     */
    public int size;
    /**
     * Number of nodes actives
     */
    public int numNodes;
    /**
     * Matrix of graph
     */
    public List matrix[];

    /**
     * Constructs a ListGraph with the specified addressed flag.
     *
     * @param x the addressed flag indicating whether the graph is directed or
     * undirected
     */
    public ListGraph(boolean x) {
        this.addressed = x;
        this.numNodes = size = 0;
    }

    /**
     * Constructs a ListGraph with the specified addressed flag and size.
     *
     * @param x the addressed flag indicating whether the graph is directed or
     * undirected
     * @param size the maximum number of nodes in the graph
     */
    public ListGraph(boolean x, int size) {
        this.addressed = x;
        this.size = size;
        this.numNodes = 0;
        this.matrix = new List[size];
    }

    /**
     * Adds a vertex to the graph with the specified user information.
     *
     * @param userAdded the User object representing the user to be added as a
     * vertex
     * @return
     */
    public int addVertex(User userAdded) {
        if (numNodes >= size) {
            Utils.errorMaxNodes();
            return -1;
        } else {
            // Verificar si está añadido
            for (int i = 0; i < this.size; i++) {
                if (matrix[i] != null && matrix[i].user.id == userAdded.id && matrix[i].user.user.equals(userAdded.user)) {
                    Utils.errorUserAlreadyExist();
                    return -1;
                }
            }
            // -------------------------------------
            for (int i = 0; i < this.size; i++) {
                if (matrix[i] == null) {
                    matrix[i] = new List(userAdded);
                    numNodes++;
                    return 0;
                }
            }
            // -------------------------------------
            return -1;
        }
    }

    /**
     * Deletes a vertex from the graph with the specified user information.
     *
     * @param userDel the User object representing the user to be deleted from
     * the graph
     * @return
     */
    public int delVertex(User userDel) {
        if (size == 0) {
            Utils.errorEmptyGraph();
            return -1;
        } else {
            boolean verify = true;
            for (int i = 0; i < size; i++) {
                if (matrix[i] != null && matrix[i].user.id == userDel.id && matrix[i].user.user.equals(userDel.user)) {
                    matrix[i] = null;
                    numNodes--;
                    return 0;
                }
            }

            if (verify) {
                Utils.errorUserNotFound();
                return -1;
            }
        }
        return -1;
    }

    /**
     * Adds an edge to the graph with the specified relation information.
     *
     * @param relation the Relations object representing the relation (edge) to
     * be added
     * @return
     */
    public int addEdge(Relations relation) {
        int count = 0;

        // Verify exist of these ID's
        for (int i = 0; i < this.size; i++) {
            if (matrix[i].user.id == relation.userOrigin) {
                count++;
            }
            if (matrix[i].user.id == relation.userDestination) {
                count++;
            }

            if (count == 2) {
                break;
            }
        }

        // If exists these ID's
        if (count == 2) {
            // Search origin user
            for (int i = 0; i < this.size; i++) {
                // -----------------------------------
                if (matrix[i].user.id == relation.userOrigin) {

                    // Search destination user
                    for (int j = 0; j < this.size; j++) {
                        // -----------------------------------
                        if (matrix[j].user.id == relation.userDestination) {
                            // Add in origin, the relation with weight
                            matrix[i].addEdgeInList(matrix[j].user, relation.weight);

                            if (!addressed) {
                                matrix[j].addEdgeInList(matrix[i].user, relation.weight);
                            }
                        }
                        // -----------------------------------
                    }
                }
                // -----------------------------------
            }
            return 0;
        } else {
            Utils.errorSomeUserNotFound();
            return -1;
        }
    }

    /**
     * Deletes an edge from the graph between the specified origin and
     * destination users.
     *
     * @param userOrigin the ID of the origin user
     * @param userDestination the ID of the destination user
     * @return
     */
    public int delEdge(int userOrigin, int userDestination) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (matrix[i].user.id == userOrigin) {
                count++;
            }
            if (matrix[i].user.id == userDestination) {
                count++;
            }
        }

        if (count == 2) {
            for (int i = 0; i < size; i++) {
                if (matrix[i].user.id == userOrigin) {
                    // Get user class & del relation
                    User userOriginClass = matrix[i].user;
                    User userDestinationClass;
                    matrix[i].delEdgeInList(userDestination);

                    // Del relation if graph is bidireccional
                    if (!addressed) {
                        for (int j = 0; j < size; j++) {
                            if (matrix[j].user.id == userDestination) {
                                matrix[j].delEdgeInList(userOrigin);
                            }
                        }
                    }

                    // Show...
                    for (int j = 0; j < size; j++) {
                        if (matrix[j].user.id == userDestination) {
                            userDestinationClass = matrix[j].user;
                        }
                    }

                }
            }
            return 0;
        } else {
            Utils.errorSomeUserNotFound();
            return -1;
        }
    }

    /**
     * Calculates the in-degree of a vertex with the specified ID.
     *
     * @param id the ID of the vertex
     * @return the in-degree of the vertex
     */
    public int getGradeIn(int id) {
        int gIn = 0;
        // Buscar usuario...
        boolean verify = false;
        for (int i = 0; i < this.numNodes; i++) {
            if (matrix[i].user.id == id) {
                verify = true;
            }
        }

        if (verify) {
            for (int i = 0; i < this.size; i++) {

                if (matrix[i] != null) {
                    ListNode aux = matrix[i].chain;

                    while (aux != null) {
                        if (aux.key == id) {
                            gIn++;
                        }
                        aux = aux.next;
                    }
                }
            }
            return gIn;

        } else {
            Utils.errorUserNotFound();
            return -1;
        }
    }

    /**
     * Calculates the out-degree of a vertex with the specified ID.
     *
     * @param id the ID of the vertex
     * @return the out-degree of the vertex
     */
    public int getGradeOut(int id) {
        int gOut = 0;
        // Buscar usuario...
        boolean verify = false;
        for (int i = 0; i < this.numNodes; i++) {
            if (matrix[i].user.id == id) {
                verify = true;
            }
        }

        if (verify) {
            for (int i = 0; i < this.size; i++) {
                if (matrix[i].user.id == id) {
                    ListNode aux = matrix[i].chain;

                    while (aux != null) {
                        gOut++;
                        aux = aux.next;
                    }
                }
            }

            return gOut;
        } else {
            Utils.errorUserNotFound();
            return -1;
        }
    }

    /**
     * Calculates the incidence of a vertex with the specified ID.
     *
     * @param x the ID of the vertex
     * @return the incidence of the vertex
     */
    public int getIncidence(int x) {
        if (!addressed) {
            return this.getGradeIn(x);
        } else {
            return this.getGradeIn(x) + this.getGradeOut(x);
        }
    }

    /**
     * Gets the size of the graph, which is the total number of edges in the
     * graph.
     *
     * @return the size of the graph
     */
    public int getSize() {
        int tm = 0;

        for (int i = 0; i < this.numNodes; i++) {
            if (matrix[i] != null) {
                ListNode aux = matrix[i].chain;

                while (aux != null) {
                    tm++;
                    aux = aux.next;
                }

            }
        }

        if (addressed) {
            return tm;
        } else {
            return tm / 2;
        }
    }

    /**
     * Checks if the graph is directed or undirected.
     *
     * @return true if the graph is directed, false if it is undirected
     */
    public boolean isAddressed() {
        boolean dir = true;

        for (int i = 0; i < this.numNodes; i++) {
            if (matrix[i] != null) {
                ListNode aux = matrix[i].chain;

                while (aux != null) {
                    int idUserDestination = aux.key;

                    for (int j = 0; j < 10; j++) {
                        if (matrix[j].user.id == idUserDestination) {
                            ListNode auxTwo = matrix[j].chain;
                            boolean verify = false;

                            while (auxTwo != null) {
                                if (auxTwo.key == aux.key) {
                                    verify = true;
                                }

                                auxTwo = auxTwo.next;
                            }

                            if (!verify) {
                                dir = false;
                            }
                        }
                    }

                    aux = aux.next;
                }
            }
        }

        return dir;
    }

    /**
     * Checks if an edge exists between the specified origin and destination
     * users and displays its weight.
     *
     * @param origin the ID of the origin user
     * @param destination the ID of the destination user
     * @return
     */
    public int getExistEdges(int origin, int destination) {
        for (int i = 0; i < numNodes; i++) {
            // Encontró el usuario origen
            if (matrix[i].user.id == origin) {
                // Lista de nodos del usuario origen
                ListNode aux = matrix[i].chain;
                boolean verify = false;

                // Busca en la lista, el usuario destino
                while (aux != null) {
                    // Si lo encontró, marca verify
                    if (aux.key == destination) {
                        return 0;
                    }
                    aux = aux.next;
                }

                // Si lo encontró
                if (!verify) {
                    Utils.information("El enlace no existe!");
                    return -1;
                }
            }
        }
        Utils.errorSomeUserNotFound();
        return -1;
    }

    /**
     * Sets the maximum number of nodes in the graph.
     *
     * @param x the maximum number of nodes
     * @return
     */
    public int setMaxNodes(int x) {
        if (x <= size) {
            Utils.errorSettingMaxNodes();
            return -1;
        } else {
            List[] newMatrix = new List[x];
            System.arraycopy(matrix, 0, newMatrix, 0, size);
            this.size = x;
            this.matrix = newMatrix;
            return 0;
        }
    }

    /**
     * Changes the addressing mode of the graph.
     *
     * @param x true for directed graph, false for undirected graph
     */
    public void setAddressed(boolean x) {
        addressed = x;
    }

    /**
     * Performs a breadth-first search (BFS) traversal starting from the
     * specified vertex.
     *
     * @param id the ID of the vertex to start the BFS traversal from
     * @return the number of nodes visited during the BFS traversal
     */
    public int bfs(int id) {
        boolean usuarioExiste = false;

        // Buscar usuario
        for (int i = 0; i < this.numNodes; i++) {
            if (matrix[i].user.id == id) {
                usuarioExiste = true;
            }
        }

        if (usuarioExiste) {
            int values = 0;
            // ----------------------------
            {
                boolean[] visitado = new boolean[size];
                Queue<Integer> cola = new Queue<>();
                int index;
                for (int i = 0; i < this.numNodes; i++) {
                    if (matrix[i].user.id == id) {
                        index = i;
                        cola.enqueue(i);
                        visitado[i] = true;
                    }
                }

                while (!cola.isEmpty()) {
                    int nodo = cola.dequeue();
                    values++;

                    // Recorrer los vecinos del nodo actual
                    ListNode aux = matrix[nodo].chain;
                    while (aux != null) {
                        int vecino = aux.key;
                        int indexVecino = 0;
                        // -----------------------
                        for (int i = 0; i < this.numNodes; i++) {
                            if (matrix[i].user.id == vecino) {
                                indexVecino = i;
                            }
                        }
                        // -----------------------
                        if (!visitado[indexVecino]) {
                            cola.enqueue(indexVecino);
                            visitado[indexVecino] = true;
                        }
                        aux = aux.next;
                    }
                }
            }
            // ----------------------------
            return values;
        } else {
            Utils.errorUserNotFound();
            return -1;
        }
    }

    /**
     * Performs a depth-first search (DFS) traversal starting from the specified
     * vertex.
     *
     * @param id the ID of the vertex to start the DFS traversal from
     * @return the number of nodes visited during the DFS traversal
     */
    public int dfs(int id) {
        int values = 0;
        boolean userExists = false;

        // Search user
        for (int i = 0; i < this.numNodes; i++) {
            if (matrix[i].user.id == id) {
                userExists = true;
            }
        }

        // Existe el usuario
        if (userExists) {
            // ----------------------------
            boolean[] visitado = new boolean[size];
            Stack<Integer> pila = new Stack<>(numNodes);
            int index = 0;
            for (int i = 0; i < this.numNodes; i++) {
                if (matrix[i].user.id == id) {
                    index = i;
                    pila.push(i);
                    visitado[i] = true;
                }
            }

            int nodosVisitados = 0;
            while (!pila.isEmpty()) {
                int nodo = pila.pop();
                nodosVisitados++;

                ListNode aux = matrix[nodo].chain;
                while (aux != null) {
                    int vecino = aux.key;
                    int indexVecino = 0;
                    // -----------------------
                    for (int i = 0; i < this.numNodes; i++) {
                        if (matrix[i].user.id == vecino) {
                            indexVecino = i;
                        }
                    }
                    // -----------------------
                    if (!visitado[indexVecino]) {
                        pila.push(indexVecino);
                        visitado[indexVecino] = true;
                    }
                    aux = aux.next;
                }
            }
            return nodosVisitados;
        } else {
            Utils.errorUserNotFound();
            return -1;
        }
    }

    /**
     * Identifies bridges in the graph and returns a string indicating that the
     * function is not available.
     *
     * @return a string indicating that the function is not available
     */
    public String bridgeIdentification() {
        String line;
        line = "Esta función no está disponible en estos momentos.";
        return line;
    }

    /**
     * Displays information about the graph, including the vertices and their
     * connections.
     */
    public void helperShowGraph() {
        System.out.println("InfoGraph: Vértices (" + numNodes + ") " + "Máximo permitido (" + size + ")");
        for (int i = 0; i < this.size; i++) {
            if (matrix[i] != null) {
                String username = matrix[i].user.user;
                int id = matrix[i].user.id;
                System.out.println("NodoInfo: Nombre (" + username + ") ID (" + id + ")");

                ListNode nodes = matrix[i].chain;
                while (nodes != null) {
                    int key = nodes.key;
                    int weight = nodes.weight;

                    System.out.println("        Apunta: " + key + ". Peso: " + weight);
                    nodes = nodes.next;
                }
            }
        }
    }

    /**
     * Search in nodes, the information of it
     * 
     * @param userId ID of node
     * @return User of these userID
     */
    public User search(int userId) {
        for (int i = 0; i < this.size; i++) {
            if (matrix[i] != null && matrix[i].user.id == userId) {
                return matrix[i].user;
            }
        }
        Utils.errorUserNotFound();
        return null;
    }
}
