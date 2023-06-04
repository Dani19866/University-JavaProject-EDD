/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graps;

import classes.Relations;
import classes.User;
import linkedList.LinkedList;
import linkedList.Node;
import utils.Utils;

/**
 *
 * @author Daniel
 */
public class MatrixGraph extends Graph {

    // Indica si es dirigido o no.
    private boolean addresed;
    // Tamaño máximo de la tabla.
    private int size;
    // Número de vértices del grafo.
    private int numNodes;
    // Matriz de adyacencias del grafo.
    private int matrix[][];
    // Lista de información de nodos
    private LinkedList<User> nodes = new LinkedList();

    // Ready
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    public MatrixGraph(boolean addresed) {
        this.addresed = addresed;
        this.size = this.numNodes = 0;
    }

    public MatrixGraph(boolean addresed, int numNodes) {
        this.addresed = addresed;
        this.size = numNodes;
        this.numNodes = 0;
        this.matrix = new int[numNodes][numNodes];
    }
    // </editor-fold>

    // Ready
    // <editor-fold defaultstate="collapsed" desc="Search information">
    public String searchUserWithID(int id) {
        String username = null;

        Node<User> users = this.nodes.getHead();
        while (users != null) {
            User user = users.getData();

            if (user.getId() == id) {
                username = user.getUser();
            }

            users = users.getNextNode();
        }

        return username;
    }

    public int searchMatrixUser(User user) {
        int returned = 0;
        Node<User> users = this.nodes.getHead();

        while (users != null) {
            User compareer = users.getData();
            if (compareer.getId() == user.getId()) {
                break;
            }
            returned++;

            users = users.getNextNode();
        }

        return returned;
    }
    // </editor-fold>

    // TODO: deleteVertex()
    // <editor-fold defaultstate="collapsed" desc="Vertex">
    public void addVertex(User user) {
        // 1. Verify max nodes allowed
        if (this.numNodes >= this.size) {
            Utils.error("ERROR! Capacidad máxima de usuarios (nodos) permitidos", false);
        } else {
            if (nodes.searchUser(user)) {
                Utils.error("ERROR! Este usuario (nodo) ya se encuentra añadido", addresed);
            } else {
                this.nodes.addLast(user);
                this.numNodes++;
            }
        }
    }

    public void deleteVertex(User user) {
        if (this.size == 0) {
            Utils.error("ERROR! No se puede eliminar un usuario (nodo) si la lista se encuentra vacía!", false);
        } else if (!this.nodes.searchUser(user)) {
            Utils.error("ERROR! No se puede eliminar un usuario (nodo) si no existe!", false);
        } else {

        }
    }
    // </editor-fold>

    // TODO: deleteEdge()
    // <editor-fold defaultstate="collapsed" desc="Edge">
    public void addEdge(Relations relation) { // a = i || b = j
        User user1 = new User(relation.getUser1(), this.searchUserWithID(relation.getUser1()));
        User user2 = new User(relation.getUser2(), this.searchUserWithID(relation.getUser2()));
        int matrixUserOrigin = searchMatrixUser(user1);
        int matrixUserDestination = searchMatrixUser(user2);

        // Bidireccional
        if (!this.addresed) {
            this.matrix[matrixUserOrigin][matrixUserDestination] = this.matrix[matrixUserDestination][matrixUserOrigin] = relation.getTime();
            System.out.println("Bi");
        } // Direccional
        else {
            this.matrix[matrixUserOrigin][matrixUserDestination] = relation.getTime();
        }

    }

    public void deleteEdge(int a, int b) {
//        // 1. Mark
//        this.matrix[a][b] = false;
//
//        // 2. Mark in addressed graph
//        if (!this.addresed) {
//            this.matrix[b][a] = false;
//        }
    }
    // </editor-fold>

    //-------------------------------------------------
    // TO DO: getExistEdges(), setMaxNodes() 
       // <editor-fold defaultstate="collapsed" desc="Getters">
   public int getGradeIn(int a) {
       // 1. Return value (Value of relations to node)
       int gIn = 0;

       // 2. Loop of size of matrix
       for (int i = 0; i < this.size; i++) {
           // 2.1. If column has value (Is true)
           if (this.matrix[i][a]) {
               gIn++;
           }
       }
       return gIn;
   }

   public int getGradeOut(int a) {
       // 1. Return value (Value of relations to node)
       int gOut = 0;

       // 2. Loop of size of matrix
       for (int j = 0; j < this.size; j++) {
           // 2.1. If row has value (Is true)
           if (this.matrix[a][j]) {
               gOut++;
           }
       }
       return gOut;
   }

   public int getIncidence(int a) {
       if (!this.addresed) {
           return this.getGradeIn(a);
       } else {
           return this.getGradeIn(a) + this.getGradeOut(a);
       }
   }

   @Override
   public int getSize() {
       int tm = 0;
       for (int i = 0; i < this.numNodes; i++) {
           for (int j = 0; j < this.numNodes; j++) {
               if (this.matrix[i][j]) {
                   tm++;
               }
           }
       }
       if (this.addresed) {
           return tm;
       } else {
           return tm / 2;
       }
   }

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

   public boolean getExistEdges(int a, int b) {
       return false;
   }
   // </editor-fold>

    //-------------------------------------------------
    // TO DO: setAddressed()
    // <editor-fold defaultstate="collapsed" desc="Setters">
    public void setAddressed(boolean a) {
        if (this.addresed) {
            // 1. Create a temp matrix
            boolean[][] tempMatrix = new boolean[this.size][this.size];

        } else {
            Utils.error("ERROR! No se puede llevar de un grafo NO dirigido a uno dirigido. Solo de grafos dirigidos a no dirigidos", false);
        }
    }

    @Override
    public void setMaxNodes() {
    }
    // </editor-fold>

    // Ready
    // <editor-fold defaultstate="collapsed" desc="Helpers">
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