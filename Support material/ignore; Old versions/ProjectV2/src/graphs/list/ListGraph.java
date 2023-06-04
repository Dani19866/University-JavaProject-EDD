/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphs.list;

import user.User;
import utils.Utils;

/**
 *
 * @author Daniel
 */
public class ListGraph {

    public boolean addressed;                              // Indica si es dirigido o no.
    public int size;                                       // Tamaño máximo de la tabla.
    public int numNodes;                                   // Número de vértices del grafo.
    public List matrix[];                                  // Matriz de adyacencias del grafo.

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructs a ListGraph object with the specified addressed value.
     *
     * @param x The addressed value to set.
     */
    public ListGraph(boolean x) {
        this.addressed = x;
        this.numNodes = size = 0;
    }

    /**
     * Constructs a ListGraph object with the specified addressed value and
     * size.
     *
     * @param x The addressed value to set.
     * @param size The size of the graph.
     */
    public ListGraph(boolean x, int size) {
        this.addressed = x;
        this.size = size;
        this.numNodes = 0;
        this.matrix = new List[size];
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Vertex functions">
    public void addVertex(User userAdded) {
        if (numNodes >= size) {
            System.out.println(numNodes + " | " + size);
            Utils.error("ERROR! Se ha alcanzado el número máximo de nodos (usuarios)", false);
        } else {
            for (int i = 0; i < this.size; i++) {
                if (matrix[i] == null) {
                    matrix[i] = new List(userAdded);
                    numNodes++;
                    break;
                }
            }
        }
    }

    public void delVertex(User userDel) {
        if (size == 0) {
            Utils.error("ERROR! No se puede eliminar este usuario ya que no existen usuarios en el grafo", false);
        } else {
            for (int i = 0; i < size; i++) {
                if (matrix[i] != null && matrix[i].user.id == userDel.id) {
                    matrix[i] = null;
                    numNodes--;
                    break;
                }
            }
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Edges functions">
    /**
     * Adds an edge between two users in the adjacency matrix.
     *
     * @param userOrigin The origin user.
     * @param userDestination The destination user.
     * @param weight The weight of the edge.
     */
    public void addEdge(User userOrigin, User userDestination, int weight) {
        int count = 0;
        for (int i = 0; i < this.size; i++) {
            if (matrix[i].user.id == userOrigin.id) {
                count++;
            }
            if (matrix[i].user.id == userDestination.id) {
                count++;
            }
        }

        if (count == 2) {
            for (int i = 0; i < this.size; i++) {
                if (matrix[i].user.id == userOrigin.id) {
                    matrix[i].addEdge(userDestination, weight);

                    if (!addressed) {
                        for (int j = 0; j < size; j++) {
                            if (matrix[j].user.id == userDestination.id) {
                                matrix[j].addEdge(userOrigin, weight);
                            }
                        }
                    }
                }
            }
        } else {
            Utils.error("ERROR! Usuario no encontrado!", false);
        }
    }

    /**
     * Deletes an edge between two users in the adjacency matrix.
     *
     * @param userOrigin The origin user.
     * @param userDestination The destination user.
     */
    public void delEdge(User userOrigin, User userDestination) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (matrix[i].user.id == userOrigin.id) {
                count++;
            }
            if (matrix[i].user.id == userDestination.id) {
                count++;
            }
        }

        if (count == 2) {
            for (int i = 0; i < size; i++) {
                if (matrix[i].user.id == userOrigin.id) {
                    matrix[i].delEdge(userDestination);

                    if (!addressed) {
                        for (int j = 0; j < size; j++) {
                            if (matrix[j].user.id == userDestination.id) {
                                matrix[j].delEdge(userOrigin);
                            }
                        }
                    }
                }
            }
        } else {
            Utils.error("ERROR! Usuario no encontrado!", false);
        }
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    /**
     * Returns the grade (in-degree) of a given node in the graph, indicating
     * the number of incoming edges.
     *
     * @param id The ID of the node.
     * @return The grade (in-degree) of the node.
     */
    public int getGradeIn(int id) {
        int gIn = 0;

        for (int i = 0; i < this.size; i++) {
            if (matrix[i] != null) {
                ListNodeGraph aux = matrix[i].chain;

                while (aux != null) {
                    if (aux.key == id) {
                        gIn++;
                    }
                    aux = aux.next;
                }
            }
        }

        return gIn;
    }

    /**
     * Returns the grade (out-degree) of a given node in the graph, indicating
     * the number of outgoing edges.
     *
     * @param id The ID of the node.
     * @return The grade (out-degree) of the node.
     */
    public int getGradeOut(int id) {
        int gOut = 0;

        for (int i = 0; i < this.size; i++) {
            if (matrix[i].user.id == id) {
                ListNodeGraph aux = matrix[i].chain;

                while (aux != null) {
                    gOut++;
                    aux = aux.next;
                }
            }
        }

        return gOut;
    }

    /**
     * Returns the incidence of a given node in the graph, indicating the sum of
     * in-degree and out-degree.
     *
     * @param x The ID of the node.
     * @return The incidence of the node.
     */
    public int getIncidence(int x) {
        if (!addressed) {
            return this.getGradeIn(x);
        } else {
            return this.getGradeIn(x) + this.getGradeOut(x);
        }
    }

    /**
     * Returns the size of the graph, indicating the number of edges.
     *
     * @return The size of the graph.
     */
    public int getSize() {
        int tm = 0;

        for (int i = 0; i < this.numNodes; i++) {
            if (matrix[i] != null) {
                ListNodeGraph aux = matrix[i].chain;

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
     * Checks if the graph is addressed or undirected.
     *
     * @return True if the graph is addressed (directed), False if it is
     * undirected.
     */
    public boolean isAddressed() {
        boolean dir = true;

        for (int i = 0; i < this.numNodes; i++) {
            if (matrix[i] != null) {
                ListNodeGraph aux = matrix[i].chain;

                while (aux != null) {
                    int idUserDestination = aux.key;

                    for (int j = 0; j < 10; j++) {
                        if (matrix[j].user.id == idUserDestination) {
                            ListNodeGraph auxTwo = matrix[j].chain;
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
     * Checks if there is an edge between the given origin and destination nodes
     * in the graph.
     *
     * @param origin The ID of the origin node.
     * @param destination The ID of the destination node.
     * @return True if an edge exists between the origin and destination nodes,
     * False otherwise.
     */
    public boolean getExistEdges(int origin, int destination) {
        boolean exists = false;

        for (int i = 0; i < numNodes; i++) {
            if (matrix[i].user.id == origin) {
                ListNodeGraph aux = matrix[i].chain;
                boolean verify = false;

                while (aux != null) {
                    if (aux.key == destination) {
                        verify = true;
                    }
                    aux = aux.next;
                }

                if (verify) {
                    exists = true;
                }
            }
        }

        return exists;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Setters">
    /**
     * Sets the maximum number of nodes in the graph to the specified value.
     *
     * @param x The new maximum number of nodes.
     */
    public void setMaxNodes(int x) {
        if (x <= size) {
            Utils.error("ERROR! El nuevo tamaño máximo debe ser mayor al tamaño actual", false);
        } else {
            List[] newMatrix = new List[x];
            System.arraycopy(matrix, 0, newMatrix, 0, size);

            this.size = x;
            this.matrix = newMatrix;
        }
    }

    /**
     * Sets the addressed value of the graph.
     *
     * @param x The new addressed value.
     */
    public void setAddressed(boolean x) {
        addressed = x;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Helpers">
    /**
     * Displays information about the graph, including the number of vertices,
     * maximum allowed size, and the connections between nodes.
     */
    public void helperShowGraph() {
        System.out.println("InfoGraph: Vértices (" + numNodes + ") " + "Máximo permitido (" + size + ")");
        for (int i = 0; i < this.size; i++) {
            if (matrix[i] != null) {
                String username = matrix[i].user.user;
                int id = matrix[i].user.id;
                System.out.println("NodoInfo: Nombre (" + username + ") ID (" + id + ")");

                ListNodeGraph nodes = matrix[i].chain;
                while (nodes != null) {
                    int key = nodes.key;
                    int weight = nodes.weight;

                    System.out.println("        Apunta: " + key + ". Peso: " + weight);
                    nodes = nodes.next;
                }
            }
        }
    }
    // </editor-fold>
}
