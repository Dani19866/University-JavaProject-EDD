/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import app.App;
import graph.list.List;
import graph.list.ListGraph;
import graph.list.ListNodeGraph;
import graph.matrix.MatrixGraph;
import gui.utils.GeneralStadistics;
import linkedList.LinkedList;
import linkedList.Node;
import user.Relations;
import user.User;
import utils.Utils;

/**
 *
 * @author Daniel
 */
public class GUI extends javax.swing.JFrame {

    private static String title;
    private static App app;

    // 1: matrixGraph | 2: listGraph
    private int selection;
    private MatrixGraph matrixGraph;
    private ListGraph listGraph;

    public int sizeGraph;
    public int numNodes;
    public int allConections;

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Creates new form GUI
     *
     * @param title Title of program
     * @param app App class to work
     */
    public GUI(String title, App app) {
        initComponents();
        GUI.title = title;
        this.app = app;

        // Window config
        this.setTitle(title);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        listGraphSelected.setVisible(false);
        matrixGraphSelected.setVisible(false);
    }
    // </editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        graphLayout = new javax.swing.JPanel();
        listGraphSelected = new javax.swing.JLabel();
        matrixGraphSelected = new javax.swing.JLabel();
        noSelectedGraph = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        actualFile = new javax.swing.JMenuItem();
        deleteFile = new javax.swing.JMenuItem();
        saveChanges = new javax.swing.JMenuItem();
        graphMenu = new javax.swing.JMenu();
        generalStadistics = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        bfsStadistic = new javax.swing.JMenuItem();
        dfsStadistic = new javax.swing.JMenuItem();
        bridgeIdentification = new javax.swing.JMenuItem();
        gradeIn = new javax.swing.JMenuItem();
        gradeOut = new javax.swing.JMenuItem();
        gradeIncidence = new javax.swing.JMenuItem();
        getAddressed = new javax.swing.JMenuItem();
        getExistsRelations = new javax.swing.JMenuItem();
        addNode = new javax.swing.JMenuItem();
        deleteNode = new javax.swing.JMenuItem();
        addRelation = new javax.swing.JMenuItem();
        deleteRelation = new javax.swing.JMenuItem();
        graphConfiguration = new javax.swing.JMenu();
        trueAddressed = new javax.swing.JMenuItem();
        falseAddressed = new javax.swing.JMenuItem();
        maxNodes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        graphLayout.setBackground(new java.awt.Color(80, 80, 80));
        graphLayout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listGraphSelected.setForeground(new java.awt.Color(255, 255, 255));
        listGraphSelected.setText("Grafo: Lista");
        graphLayout.add(listGraphSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 410, 70, 20));

        matrixGraphSelected.setForeground(new java.awt.Color(255, 255, 255));
        matrixGraphSelected.setText("Grafo: Matriz");
        graphLayout.add(matrixGraphSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 410, 80, 20));

        noSelectedGraph.setForeground(new java.awt.Color(255, 255, 255));
        noSelectedGraph.setText("Grafo: No seleccionado");
        graphLayout.add(noSelectedGraph, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 140, 20));

        getContentPane().add(graphLayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 440));

        menuBar.setBackground(new java.awt.Color(214, 213, 213));
        menuBar.setBorderPainted(false);

        fileMenu.setBackground(new java.awt.Color(255, 255, 255));
        fileMenu.setText("FILES");
        fileMenu.setFocusable(false);

        newFile.setBackground(new java.awt.Color(255, 255, 255));
        newFile.setText("New file");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        fileMenu.add(newFile);

        actualFile.setBackground(new java.awt.Color(255, 255, 255));
        actualFile.setText("Actual file");
        actualFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualFileActionPerformed(evt);
            }
        });
        fileMenu.add(actualFile);

        deleteFile.setBackground(new java.awt.Color(255, 255, 255));
        deleteFile.setText("Delete file data");
        deleteFile.setEnabled(false);
        deleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFileActionPerformed(evt);
            }
        });
        fileMenu.add(deleteFile);

        saveChanges.setText("Save changes");
        saveChanges.setEnabled(false);
        saveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesActionPerformed(evt);
            }
        });
        fileMenu.add(saveChanges);

        menuBar.add(fileMenu);

        graphMenu.setBackground(new java.awt.Color(255, 255, 255));
        graphMenu.setText("GRAPH OPTIONS");
        graphMenu.setEnabled(false);
        graphMenu.setFocusable(false);

        generalStadistics.setBackground(new java.awt.Color(255, 255, 255));
        generalStadistics.setText("General stadistics");
        generalStadistics.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalStadisticsActionPerformed(evt);
            }
        });
        graphMenu.add(generalStadistics);

        jMenu1.setBackground(new java.awt.Color(255, 255, 255));
        jMenu1.setText("Avanced stadistics");
        jMenu1.setFocusable(false);

        bfsStadistic.setBackground(new java.awt.Color(255, 255, 255));
        bfsStadistic.setText("BFS");
        bfsStadistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfsStadisticActionPerformed(evt);
            }
        });
        jMenu1.add(bfsStadistic);

        dfsStadistic.setBackground(new java.awt.Color(255, 255, 255));
        dfsStadistic.setText("DFS");
        dfsStadistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dfsStadisticActionPerformed(evt);
            }
        });
        jMenu1.add(dfsStadistic);

        bridgeIdentification.setBackground(new java.awt.Color(255, 255, 255));
        bridgeIdentification.setText("Bridge identification");
        bridgeIdentification.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bridgeIdentificationActionPerformed(evt);
            }
        });
        jMenu1.add(bridgeIdentification);

        gradeIn.setBackground(new java.awt.Color(255, 255, 255));
        gradeIn.setText("Grade in node");
        gradeIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeInActionPerformed(evt);
            }
        });
        jMenu1.add(gradeIn);

        gradeOut.setBackground(new java.awt.Color(255, 255, 255));
        gradeOut.setText("Grade out node");
        gradeOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeOutActionPerformed(evt);
            }
        });
        jMenu1.add(gradeOut);

        gradeIncidence.setText("Grade incidence");
        gradeIncidence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeIncidenceActionPerformed(evt);
            }
        });
        jMenu1.add(gradeIncidence);

        getAddressed.setBackground(new java.awt.Color(255, 255, 255));
        getAddressed.setText("Get addressed");
        getAddressed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getAddressedActionPerformed(evt);
            }
        });
        jMenu1.add(getAddressed);

        getExistsRelations.setBackground(new java.awt.Color(255, 255, 255));
        getExistsRelations.setText("Get exists relations");
        getExistsRelations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getExistsRelationsActionPerformed(evt);
            }
        });
        jMenu1.add(getExistsRelations);

        graphMenu.add(jMenu1);

        addNode.setBackground(new java.awt.Color(255, 255, 255));
        addNode.setText("Add node");
        addNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNodeActionPerformed(evt);
            }
        });
        graphMenu.add(addNode);

        deleteNode.setBackground(new java.awt.Color(255, 255, 255));
        deleteNode.setText("Delete node");
        deleteNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteNodeActionPerformed(evt);
            }
        });
        graphMenu.add(deleteNode);

        addRelation.setBackground(new java.awt.Color(255, 255, 255));
        addRelation.setText("Add relation");
        addRelation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRelationActionPerformed(evt);
            }
        });
        graphMenu.add(addRelation);

        deleteRelation.setBackground(new java.awt.Color(255, 255, 255));
        deleteRelation.setText("Delete relation");
        deleteRelation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteRelationActionPerformed(evt);
            }
        });
        graphMenu.add(deleteRelation);

        graphConfiguration.setBackground(new java.awt.Color(255, 255, 255));
        graphConfiguration.setText("Graph configuration");
        graphConfiguration.setFocusable(false);

        trueAddressed.setBackground(new java.awt.Color(255, 255, 255));
        trueAddressed.setText("True addressed");
        trueAddressed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trueAddressedActionPerformed(evt);
            }
        });
        graphConfiguration.add(trueAddressed);

        falseAddressed.setBackground(new java.awt.Color(255, 255, 255));
        falseAddressed.setText("False addressed");
        falseAddressed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                falseAddressedActionPerformed(evt);
            }
        });
        graphConfiguration.add(falseAddressed);

        maxNodes.setBackground(new java.awt.Color(255, 255, 255));
        maxNodes.setText("Max nodes");
        maxNodes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxNodesActionPerformed(evt);
            }
        });
        graphConfiguration.add(maxNodes);

        graphMenu.add(graphConfiguration);

        menuBar.add(graphMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Events">
    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        int codeFile = app.fileAlgorithm(true, this);

        if (codeFile == 0) {
            int codeGraph = this.graphAlgorithm();

            if (codeGraph == 0) {
                graphMenu.setEnabled(true);
                actualFile.setEnabled(false);
                deleteFile.setEnabled(true);
                saveChanges.setEnabled(true);
            }
        }
    }//GEN-LAST:event_newFileActionPerformed

    private void actualFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualFileActionPerformed
        int codeFile = app.fileAlgorithm(false, this);

        if (codeFile == 0) {
            int codeGraph = this.graphAlgorithm();

            if (codeGraph == 0) {
                graphMenu.setEnabled(true);
                actualFile.setEnabled(false);
                deleteFile.setEnabled(true);
                saveChanges.setEnabled(true);
            }
        }
    }//GEN-LAST:event_actualFileActionPerformed

    private void generalStadisticsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalStadisticsActionPerformed
        GeneralStadistics gs = new GeneralStadistics(this);
    }//GEN-LAST:event_generalStadisticsActionPerformed

    private void addNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNodeActionPerformed
        // Matrix
        if (selection == 1) {
            User user = Utils.requestUser();
            if (user != null) {
                matrixGraph.addVertex(user);
                this.updateChanges();
            }
        } // List
        else {
            User user = Utils.requestUser();
            if (user != null) {
                listGraph.addVertex(user);
                this.updateChanges();
            }
        }
    }//GEN-LAST:event_addNodeActionPerformed

    private void deleteNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteNodeActionPerformed
        // Matrix
        if (selection == 1) {
            User user = Utils.requestUser();
            if (user != null) {
                matrixGraph.delVertex(user);
                this.updateChanges();
            }
        } // List
        else {
            User user = Utils.requestUser();
            if (user != null) {
                listGraph.delVertex(user);
                this.updateChanges();
            }
        }
    }//GEN-LAST:event_deleteNodeActionPerformed

    private void addRelationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRelationActionPerformed
        // Matrix
        if (selection == 1) {
            Relations relation = Utils.requestRelation();
            if (relation != null) {
                matrixGraph.addEdge(relation);
                this.updateChanges();
            }
        } // List
        else {
            Relations relation = Utils.requestRelation();
            if (relation != null) {
                listGraph.addEdge(relation);
                this.updateChanges();
            }
        }
    }//GEN-LAST:event_addRelationActionPerformed

    private void deleteRelationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteRelationActionPerformed
        // Matrix
        if (selection == 1) {
            int[] ids = Utils.request2Id();
            if (ids != null) {
                matrixGraph.delEdge(ids[0], ids[1]);
                this.updateChanges();
            }
        } // List
        else {
            int[] ids = Utils.request2Id();
            if (ids != null) {
                listGraph.delEdge(ids[0], ids[1]);
                this.updateChanges();
            }
        }
    }//GEN-LAST:event_deleteRelationActionPerformed

    private void trueAddressedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trueAddressedActionPerformed
        // Matrix
        if (selection == 1) {
            Utils.information("El grafo ahora se encuentra 'DIRIGIDO'. Desde ahora las relaciones serán bidirrecionales");
            matrixGraph.setAddressed(true);
        } // List
        else {
            Utils.information("El grafo ahora se encuentra 'DIRIGIDO'. Desde ahora las relaciones serán bidirrecionales");
            listGraph.setAddressed(true);
        }
    }//GEN-LAST:event_trueAddressedActionPerformed

    private void falseAddressedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_falseAddressedActionPerformed
        // Matrix
        if (selection == 1) {
            Utils.information("El grafo ahora se encuentra 'NO DIRIGIDO'");
            matrixGraph.setAddressed(false);
        } // List
        else {
            Utils.information("El grafo ahora se encuentra 'NO DIRIGIDO'");
            listGraph.setAddressed(false);
        }
    }//GEN-LAST:event_falseAddressedActionPerformed

    private void maxNodesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxNodesActionPerformed
        // Matrix
        if (selection == 1) {
            int nodes = Utils.requestNodes();
            if (nodes != -1) {
                matrixGraph.setMaxNodes(nodes);
                this.updateChanges();
            }
        } // List
        else {
            int nodes = Utils.requestNodes();
            if (nodes != -1) {
                listGraph.setMaxNodes(nodes);
                this.updateChanges();
            }
        }
    }//GEN-LAST:event_maxNodesActionPerformed

    private void getExistsRelationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getExistsRelationsActionPerformed
        // Matrix
        if (selection == 1) {
            int[] ids = Utils.request2Id();
            if (ids != null) {
                matrixGraph.getExistEdges(ids[0], ids[1]);
            }
        } // List
        else {
            int[] ids = Utils.request2Id();
            if (ids != null) {
                listGraph.getExistEdges(ids[0], ids[1]);
            }
        }
    }//GEN-LAST:event_getExistsRelationsActionPerformed

    private void getAddressedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getAddressedActionPerformed
        // Matrix
        if (selection == 1) {
            if (matrixGraph.isAddresed()) {
                Utils.information("El grafo es dirigido!");
            } else {
                Utils.information("El grafo no es dirigido!");
            }
        } // List
        else {
            if (listGraph.isAddressed()) {
                Utils.information("El grafo es dirigido!");
            } else {
                Utils.information("El grafo no es dirigido!");
            }
        }
    }//GEN-LAST:event_getAddressedActionPerformed

    private void gradeInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeInActionPerformed
        // Matrix
        if (selection == 1) {
            int id = Utils.requestId();
            if (id != -1) {
                int grade = matrixGraph.getGradeIn(id);
                if (grade != -1) {
                    Utils.information("El usuario tiene " + grade + " relaciones");
                }
            }
        } // List
        else {
            int id = Utils.requestId();
            if (id != -1) {
                int grade = listGraph.getGradeIn(id);
                if (grade != -1) {
                    Utils.information("El usuario tiene " + grade + " relaciones");
                }
            }
        }
    }//GEN-LAST:event_gradeInActionPerformed

    private void gradeOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeOutActionPerformed
        // Matrix
        if (selection == 1) {
            int id = Utils.requestId();
            if (id != -1) {
                int grade = matrixGraph.getGradeOut(id);
                if (grade != -1) {
                    Utils.information("El usuario tiene " + grade + " relaciones");
                }
            }
        } // List
        else {
            int id = Utils.requestId();
            if (id != -1) {
                int grade = listGraph.getGradeOut(id);
                if (grade != -1) {
                    Utils.information("El usuario tiene " + grade + " relaciones");
                }
            }
        }
    }//GEN-LAST:event_gradeOutActionPerformed

    private void gradeIncidenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeIncidenceActionPerformed
        // Matrix
        if (selection == 1) {
            int id = Utils.requestId();
            if (id != -1) {
                int grade = matrixGraph.getIncidence(id);
                if (grade != -2) {
                    Utils.information("El usuario tiene " + grade + " relaciones");
                }
            }
        } // List
        else {
            int id = Utils.requestId();
            if (id != -1) {
                int grade = listGraph.getIncidence(id);
                if (grade != -2) {
                    Utils.information("El usuario tiene " + grade + " relaciones");
                }
            }
        }
    }//GEN-LAST:event_gradeIncidenceActionPerformed

    private void bfsStadisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfsStadisticActionPerformed
        // Matrix: 121 == 6
        if (selection == 1) {
            Utils.information("Información sobre BFS... Esta función recorre los nodos desde el nodo usuario solicitado a través de su ID");
            int userID = Utils.requestId();
            int values = matrixGraph.bfs(userID);

            if (values != -1) {
                Utils.information("El recorrido BFS desde el nodo " + userID + " es de " + values + ". Esto incluye el nodo elegido");
            }

        } // List
        else {
            Utils.information("Información sobre BFS... Esta función recorre los nodos desde el nodo usuario solicitado a través de su ID");
            int userID = Utils.requestId();
            int values = listGraph.bfs(userID);

            if (values != -1) {
                Utils.information("El recorrido BFS desde el nodo " + userID + " es de " + values + ". Esto incluye el nodo elegido");
            }
        }
    }//GEN-LAST:event_bfsStadisticActionPerformed

    private void dfsStadisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dfsStadisticActionPerformed
        // Matrix
        if (selection == 1) {
            Utils.information("Información sobre DFS... Esta función recorre los nodos desde el nodo usuario solicitado a través de su ID");
            int userID = Utils.requestId();
            int values = matrixGraph.dfs(userID);

            if (values != -1) {
                Utils.information("El recorrido DFS desde el nodo " + userID + " es de " + values + ". Esto incluye el nodo elegido");
            }

        } // List
        else {
            Utils.information("Información sobre DFS... Esta función recorre los nodos desde el nodo usuario solicitado a través de su ID");
            int userID = Utils.requestId();
            int values = listGraph.dfs(userID);

            if (values != -1) {
                Utils.information("El recorrido DFS desde el nodo " + userID + " es de " + values + ". Esto incluye el nodo elegido");
            }
        }
    }//GEN-LAST:event_dfsStadisticActionPerformed

    private void saveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesActionPerformed
        if (selection == 1) {
            // matrixGraph;
            LinkedList<String> lines = new LinkedList();

            // Get Usuarios
            lines.addLast("Usuarios");
            Node<User> users = matrixGraph.nodes.getHead();
            while (users != null) { // 121, @Pepe_Gónzales
                int id = users.getData().id;
                String username = users.getData().user;
                String line = id + ", @" + username;
                lines.addLast(line);
                users = users.getNextNode();
            }

            // Get Relaciones
            lines.addLast("Relaciones");
            int[][] copyMatrix = matrixGraph.matrix; // 365, 758, 9
            for (int i = 0; i < copyMatrix.length; i++) {
                for (int j = 0; j < copyMatrix.length; j++) {
                    if (copyMatrix[i][j] != 0) {
                        System.out.println(i + "|" + j);
                        int sourceId = matrixGraph.nodes.searchUserWithSource(i).id;
                        int destinationId = matrixGraph.nodes.searchUserWithSource(j).id;
                        int weight = copyMatrix[i][j];

                        if (sourceId != -1 && destinationId != -1) {
                            String line = sourceId + ", " + destinationId + ", " + weight;
                            lines.addLast(line);
                        }
                    }
                }
            }

            // Save
            app.saveChanges(lines);
        } // List
        else {
            // listGraph;
            LinkedList<String> lines = new LinkedList();

            // Get Usuarios
            lines.addLast("Usuarios");
            List[] users = listGraph.matrix;
            for (List user : users) {
                if (user != null) {
                    User userAdded = user.user;
                    String line = userAdded.id + ", @" + userAdded.user;
                    lines.addLast(line);
                }
            }

            // Get Relaciones
            lines.addLast("Relaciones");
            List[] userRelations = listGraph.matrix;
            for (List user : userRelations) {
                if (user != null) {
                    ListNodeGraph relations = user.chain;
                    while (relations != null) {
                        int sourceId = user.user.id;
                        int destinationId = relations.key;
                        int weight = relations.weight;
                        String line = sourceId + ", " + destinationId + ", " + weight;
                        lines.addLast(line);
                        relations = relations.next;
                    }
                }
            }

            // Save
            app.saveChanges(lines);
        }


    }//GEN-LAST:event_saveChangesActionPerformed

    private void deleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFileActionPerformed
        graphMenu.setEnabled(false);
        deleteFile.setEnabled(false);
        saveChanges.setEnabled(false);
        actualFile.setEnabled(true);
        app.deleteFileData();
    }//GEN-LAST:event_deleteFileActionPerformed

    private void bridgeIdentificationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bridgeIdentificationActionPerformed
        // Matrix
        if (selection == 1) {
            String result = matrixGraph.bridgeIdentification();
            
            if (result != null){
                Utils.information(result);
            }
        } // List
        else {
            String result = listGraph.bridgeIdentification();
            
            if (result != null){
                Utils.information(result);
            }
        }
    }//GEN-LAST:event_bridgeIdentificationActionPerformed
    // </editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="Graphs">
    private int graphAlgorithm() {
        String[] options = {"Matriz", "Lista"};
        String select = Utils.Popup(options);

        if (null == select) {
            Utils.error("ERROR! No se seleccionó ninguna opción", false);
            return -1;
        } else {
            switch (select) {
                case "Matriz":
                    this.matrixGraph();
                    matrixGraphSelected.setVisible(true);
                    noSelectedGraph.setVisible(false);
                    return 0;
                case "Lista":
                    this.listGraph();
                    listGraphSelected.setVisible(true);
                    noSelectedGraph.setVisible(false);
                    return 0;
                default:
                    Utils.error("ERROR! No se seleccionó ninguna opción", false);
                    return -1;
            }
        }
    }

    private void matrixGraph() {
        matrixGraph = app.getMatrixGraph();
        matrixGraph.info = true;
        sizeGraph = matrixGraph.size;
        numNodes = matrixGraph.numNodes;
        allConections = matrixGraph.getSize();
        selection = 1;
    }

    private void listGraph() {
        listGraph = app.getListGraph();
        listGraph.info = true;

        sizeGraph = listGraph.size;
        numNodes = listGraph.numNodes;
        allConections = listGraph.getSize();
        selection = 2;
    }

    private void updateChanges() {
        if (selection == 1) {
            sizeGraph = matrixGraph.size;
            numNodes = matrixGraph.numNodes;
            allConections = matrixGraph.getSize();
        } else {
            sizeGraph = listGraph.size;
            numNodes = listGraph.numNodes;
            allConections = listGraph.getSize();
        }
    }
    // </editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="Main function">
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUI(title, app).setVisible(true);
        });
    }
    // </editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actualFile;
    private javax.swing.JMenuItem addNode;
    private javax.swing.JMenuItem addRelation;
    private javax.swing.JMenuItem bfsStadistic;
    private javax.swing.JMenuItem bridgeIdentification;
    private javax.swing.JMenuItem deleteFile;
    private javax.swing.JMenuItem deleteNode;
    private javax.swing.JMenuItem deleteRelation;
    private javax.swing.JMenuItem dfsStadistic;
    private javax.swing.JMenuItem falseAddressed;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuItem generalStadistics;
    private javax.swing.JMenuItem getAddressed;
    private javax.swing.JMenuItem getExistsRelations;
    private javax.swing.JMenuItem gradeIn;
    private javax.swing.JMenuItem gradeIncidence;
    private javax.swing.JMenuItem gradeOut;
    private javax.swing.JMenu graphConfiguration;
    private javax.swing.JPanel graphLayout;
    private javax.swing.JMenu graphMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JLabel listGraphSelected;
    private javax.swing.JLabel matrixGraphSelected;
    private javax.swing.JMenuItem maxNodes;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JLabel noSelectedGraph;
    private javax.swing.JMenuItem saveChanges;
    private javax.swing.JMenuItem trueAddressed;
    // End of variables declaration//GEN-END:variables
    // </editor-fold> 
}
