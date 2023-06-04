/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import app.App;
import graph.List;
import graph.ListGraph;
import graph.ListNode;
import java.awt.Color;
import javax.swing.JComponent;
import linkedlist.LinkedList;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swingViewer.ViewPanel;
import org.graphstream.ui.view.View;
import org.graphstream.ui.view.Viewer;
import utils.Relations;
import utils.User;
import utils.Utils;

/**
 * The main GUI class for the application.
 *
 * This class represents the main graphical user interface for the application.
 * It provides various functionalities for interacting with the graph data
 * structure. The GUI allows users to load and save files, perform statistical
 * analysis on the graph, add and delete nodes, add and delete relations, and
 * perform advanced operations like breadth-first search (BFS), depth-first
 * search (DFS), and bridge identification.
 *
 * The GUI is created using Swing components and follows the
 * Model-View-Controller (MVC) design pattern. The GUI communicates with the
 * underlying `App` class to perform the necessary operations on the graph.
 *
 * @author Daniel
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Title of main gui
     */
    private static String title;
    /**
     * Instance of app. It has all functions of software to work properly
     */
    private static App app;
    /**
     * Instance of ListGraph
     */
    private ListGraph graph;

    /**
     * Size max of nodes in graph This be actualized constantly
     */
    public int sizeGraph;
    /**
     * Number of nodes in graph This be actualized constantly
     */
    public int numNodes;
    /**
     * All connections (relations) of graph This be actualized constantly
     */
    public int allConections;
    /**
     * Title of child gui
     */
    public String titleToChild;

    /**
     * Viewer component to view Graph of GraphStream lib 
     */
    private Viewer viewer;
    /**
     * Viewer component to insert in JPanel (principalLayout) 
     */
    private ViewPanel viewPanel;

    // <editor-fold defaultstate="collapsed" desc="Constructor">       
    /**
     * Creates a new MainGUI instance.
     *
     * @param titleParam the title of the GUI
     * @param appParam the application instance
     */
    public MainGUI(String titleParam, App appParam) {
        initComponents();
        title = titleParam;
        app = appParam;
        titleToChild = titleParam;

        // Config window
        this.setVisible(true);
        this.setTitle(title);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
    // </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principalLayout = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        loadFile = new javax.swing.JMenuItem();
        filemenusep = new javax.swing.JPopupMenu.Separator();
        delFile = new javax.swing.JMenuItem();
        filemenusep2 = new javax.swing.JPopupMenu.Separator();
        saveChanges = new javax.swing.JMenuItem();
        stadisticsMenu = new javax.swing.JMenu();
        generalStadistic = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        gradeInStadistic = new javax.swing.JMenuItem();
        gradeOutStadistic = new javax.swing.JMenuItem();
        gradeIncidenceStadistic = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        addressedStadistic = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        existsRelationsStadistic = new javax.swing.JMenuItem();
        nodesMenu = new javax.swing.JMenu();
        addNode = new javax.swing.JMenuItem();
        delNode = new javax.swing.JMenuItem();
        relationsMenu = new javax.swing.JMenu();
        addRelation = new javax.swing.JMenuItem();
        delRelation = new javax.swing.JMenuItem();
        advancedMenu = new javax.swing.JMenu();
        bfsAdvance = new javax.swing.JMenuItem();
        dfsAdvance = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        bridgeIdentificationAdvance = new javax.swing.JMenuItem();
        configGraphMenu = new javax.swing.JMenu();
        allowAddressed = new javax.swing.JMenuItem();
        disableAddressed = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        setMaxNodes = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        principalLayout.setBackground(new java.awt.Color(51, 51, 51));
        principalLayout.setLayout(new java.awt.BorderLayout());
        getContentPane().add(principalLayout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 580));

        menuBar.setBackground(new java.awt.Color(255, 255, 255));

        fileMenu.setBackground(new java.awt.Color(255, 255, 255));
        fileMenu.setText("FILE");

        newFile.setBackground(new java.awt.Color(255, 255, 255));
        newFile.setText("Load new file");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        fileMenu.add(newFile);

        loadFile.setBackground(new java.awt.Color(255, 255, 255));
        loadFile.setText("Load actual file");
        loadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadFileActionPerformed(evt);
            }
        });
        fileMenu.add(loadFile);
        fileMenu.add(filemenusep);

        delFile.setBackground(new java.awt.Color(255, 255, 255));
        delFile.setText("Delete file");
        delFile.setEnabled(false);
        delFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delFileActionPerformed(evt);
            }
        });
        fileMenu.add(delFile);
        fileMenu.add(filemenusep2);

        saveChanges.setBackground(new java.awt.Color(255, 255, 255));
        saveChanges.setText("Save changes");
        saveChanges.setEnabled(false);
        saveChanges.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveChangesActionPerformed(evt);
            }
        });
        fileMenu.add(saveChanges);

        menuBar.add(fileMenu);

        stadisticsMenu.setText("STADISTICS");
        stadisticsMenu.setEnabled(false);

        generalStadistic.setText("General stadistics");
        generalStadistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generalStadisticActionPerformed(evt);
            }
        });
        stadisticsMenu.add(generalStadistic);
        stadisticsMenu.add(jSeparator5);

        gradeInStadistic.setText("Grade in node");
        gradeInStadistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeInStadisticActionPerformed(evt);
            }
        });
        stadisticsMenu.add(gradeInStadistic);

        gradeOutStadistic.setText("Grade out node");
        gradeOutStadistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeOutStadisticActionPerformed(evt);
            }
        });
        stadisticsMenu.add(gradeOutStadistic);

        gradeIncidenceStadistic.setText("Grade incidence");
        gradeIncidenceStadistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradeIncidenceStadisticActionPerformed(evt);
            }
        });
        stadisticsMenu.add(gradeIncidenceStadistic);
        stadisticsMenu.add(jSeparator4);

        addressedStadistic.setText("Get addressed");
        addressedStadistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressedStadisticActionPerformed(evt);
            }
        });
        stadisticsMenu.add(addressedStadistic);
        stadisticsMenu.add(jSeparator3);

        existsRelationsStadistic.setText("Get exists relations");
        existsRelationsStadistic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existsRelationsStadisticActionPerformed(evt);
            }
        });
        stadisticsMenu.add(existsRelationsStadistic);

        menuBar.add(stadisticsMenu);

        nodesMenu.setBackground(new java.awt.Color(255, 255, 255));
        nodesMenu.setText("NODES");
        nodesMenu.setEnabled(false);

        addNode.setText("Add node");
        addNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNodeActionPerformed(evt);
            }
        });
        nodesMenu.add(addNode);

        delNode.setText("Delete node");
        delNode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delNodeActionPerformed(evt);
            }
        });
        nodesMenu.add(delNode);

        menuBar.add(nodesMenu);

        relationsMenu.setText("RELATIONS");
        relationsMenu.setEnabled(false);

        addRelation.setText("Add relation");
        addRelation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRelationActionPerformed(evt);
            }
        });
        relationsMenu.add(addRelation);

        delRelation.setText("Delete relation");
        delRelation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delRelationActionPerformed(evt);
            }
        });
        relationsMenu.add(delRelation);

        menuBar.add(relationsMenu);

        advancedMenu.setText("ADVANCED");
        advancedMenu.setEnabled(false);

        bfsAdvance.setText("BFS");
        bfsAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bfsAdvanceActionPerformed(evt);
            }
        });
        advancedMenu.add(bfsAdvance);

        dfsAdvance.setText("DFS");
        dfsAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dfsAdvanceActionPerformed(evt);
            }
        });
        advancedMenu.add(dfsAdvance);
        advancedMenu.add(jSeparator2);

        bridgeIdentificationAdvance.setText("Bridge identification");
        bridgeIdentificationAdvance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bridgeIdentificationAdvanceActionPerformed(evt);
            }
        });
        advancedMenu.add(bridgeIdentificationAdvance);

        menuBar.add(advancedMenu);

        configGraphMenu.setText("GRAPH CONFIGURATION");
        configGraphMenu.setEnabled(false);

        allowAddressed.setText("Allow addressed");
        allowAddressed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allowAddressedActionPerformed(evt);
            }
        });
        configGraphMenu.add(allowAddressed);

        disableAddressed.setText("Disable addressed");
        disableAddressed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disableAddressedActionPerformed(evt);
            }
        });
        configGraphMenu.add(disableAddressed);
        configGraphMenu.add(jSeparator1);

        setMaxNodes.setText("Set max nodes");
        setMaxNodes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setMaxNodesActionPerformed(evt);
            }
        });
        configGraphMenu.add(setMaxNodes);

        menuBar.add(configGraphMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Events"> 
    /**
     * Create a graph with new file imported with JFileChooser After, update
     * variables than save stadistics
     */
    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        int verf = app.fileAlgorithm(true, this);
        if (verf == 0) {
            this.graph = app.getGraph();
            this.visualGraph();
            this.viewPanel.repaint();

            // Disallow
            loadFile.setEnabled(false);

            // Allow
            delFile.setEnabled(true);
            saveChanges.setEnabled(true);
            stadisticsMenu.setEnabled(true);
            nodesMenu.setEnabled(true);
            relationsMenu.setEnabled(true);
            advancedMenu.setEnabled(true);
            configGraphMenu.setEnabled(true);
        }
    }//GEN-LAST:event_newFileActionPerformed

    /**
     * Load graph saved in file txt database After, update variables than save
     * stadistics
     */
    private void loadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadFileActionPerformed
        int verf = app.fileAlgorithm(false, this);
        if (verf == 0) {
            this.graph = app.getGraph();
            this.visualGraph();
            this.viewPanel.repaint();

            // Disallow
            loadFile.setEnabled(false);

            // Allow
            delFile.setEnabled(true);
            saveChanges.setEnabled(true);
            stadisticsMenu.setEnabled(true);
            nodesMenu.setEnabled(true);
            relationsMenu.setEnabled(true);
            advancedMenu.setEnabled(true);
            configGraphMenu.setEnabled(true);
        }
    }//GEN-LAST:event_loadFileActionPerformed

    /**
     * Delete data in file database Disallow all buttons except Load new/actual
     * file
     */
    private void delFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delFileActionPerformed
        app.deleteFileData();
        // Allow
        loadFile.setEnabled(true);

        // Disallow
        delFile.setEnabled(false);
        saveChanges.setEnabled(false);
        stadisticsMenu.setEnabled(false);
        nodesMenu.setEnabled(false);
        relationsMenu.setEnabled(false);
        advancedMenu.setEnabled(false);
        configGraphMenu.setEnabled(false);
    }//GEN-LAST:event_delFileActionPerformed

    /**
     * Save changes of graph in database file
     */
    private void saveChangesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveChangesActionPerformed
        LinkedList<String> lines = new LinkedList();
        // Get Usuarios
        lines.addLast("Usuarios");
        List[] users = graph.matrix;
        for (List user : users) {
            if (user != null) {
                User userAdded = user.user;
                String line = userAdded.id + ", @" + userAdded.user;
                lines.addLast(line);
            }
        }

        // Get Relaciones
        lines.addLast("Relaciones");
        List[] userRelations = graph.matrix;
        for (List user : userRelations) {
            if (user != null) {
                ListNode relations = user.chain;
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

        // Save changes
        app.saveData(lines);
    }//GEN-LAST:event_saveChangesActionPerformed

    /**
     * Open external gui of general stadistics of graph
     */
    private void generalStadisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generalStadisticActionPerformed
        if (!graph.addressed) {
            Utils.information("El grafo está en modo 'NO DIRIGIDO'. Las relaciones se pueden acortar a x/2");
        }
        this.update();
        Stadistics gs = new Stadistics(this);
    }//GEN-LAST:event_generalStadisticActionPerformed

    /**
     * Calculate grade into of node
     *
     * This function request a ID of node (user) to search in the algorithm
     *
     * Display the result if all is OK
     */
    private void gradeInStadisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeInStadisticActionPerformed
        int id = Utils.requestId();
        if (id != -1) {
            int grade = graph.getGradeIn(id);
            if (grade != -1) {
                Utils.information("El usuario tiene " + grade + " conexiones entrandes");
            }
        }
    }//GEN-LAST:event_gradeInStadisticActionPerformed

    /**
     * Calculate grade out of node
     *
     * This function request a ID of node (user) to search in the algorithm
     *
     * Display the result if all is OK
     */
    private void gradeOutStadisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeOutStadisticActionPerformed
        int id = Utils.requestId();
        if (id != -1) {
            int grade = graph.getGradeOut(id);
            if (grade != -1) {
                Utils.information("El usuario tiene " + grade + " conexiones salientes");
            }
        }
    }//GEN-LAST:event_gradeOutStadisticActionPerformed

    /**
     * Calculate incidence of node
     *
     * This function request a ID of node (user) to search in the algorithm
     *
     * Display the result if all is OK
     */
    private void gradeIncidenceStadisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradeIncidenceStadisticActionPerformed
        int id = Utils.requestId();
        if (id != -1) {
            int grade = graph.getIncidence(id);
            if (grade != -1) {
                Utils.information("El usuario tiene " + grade + " conexiones");
            }
        }
    }//GEN-LAST:event_gradeIncidenceStadisticActionPerformed

    /**
     * Display information depends of the algorithm applicated to verify if
     * graph is addressed or no
     */
    private void addressedStadisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressedStadisticActionPerformed
        if (graph.isAddressed()) {
            Utils.information("El grafo es dirigido!");
        } else {
            Utils.information("El grafo no es dirigido!");
        }
    }//GEN-LAST:event_addressedStadisticActionPerformed

    /**
     * Verify existence of relations of origin node and to destination node
     *
     * This function request a ID of origin and destination
     */
    private void existsRelationsStadisticActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_existsRelationsStadisticActionPerformed
        int[] ids = Utils.requestIds();
        if (ids != null) {
            int verf = graph.getExistEdges(ids[0], ids[1]);

            if (verf != -1) {
                Utils.information("El enlace existe!");
            }
        }
    }//GEN-LAST:event_existsRelationsStadisticActionPerformed

    /**
     * Add node into graph
     *
     * This verify if introducing the new username, this apply with the rules
     * This verify if new User no is used in graph
     */
    private void addNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNodeActionPerformed
        User user = Utils.createUserNode();
        if (user != null) {
            int verf = graph.addVertex(user);

            if (verf != -1) {
                Utils.succesfullyUserAdded(user.user);
                this.visualGraph();
                this.viewPanel.repaint();
            }
        }
    }//GEN-LAST:event_addNodeActionPerformed

    /**
     * Delete node of graph
     */
    private void delNodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delNodeActionPerformed
        int userId = Utils.requestId();
        User user = graph.search(userId);
        if (user != null) {
            int verf = graph.delVertex(user);

            if (verf != -1) {
                Utils.succesfullyUserDelete(user.user);
                this.visualGraph();
            }
        }
    }//GEN-LAST:event_delNodeActionPerformed

    /**
     * Add relation into a graph This function request a ID of origin and
     * destination and weight of relation
     */
    private void addRelationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRelationActionPerformed
        Relations relation = Utils.createRelation();
        if (relation != null) {
            int verf = graph.addEdge(relation);

            if (verf != -1) {
                Utils.succesfullyRelationAdded(relation.userOrigin, relation.userDestination, relation.weight);
                this.visualGraph();
            }
        }
    }//GEN-LAST:event_addRelationActionPerformed

    /**
     * Delete relation of graph
     *
     * This function request an ID of origin and destination to delete the
     * relation
     */
    private void delRelationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delRelationActionPerformed
        int[] ids = Utils.requestIds();
        if (ids != null) {
            int verf = graph.delEdge(ids[0], ids[1]);

            if (verf != -1) {
                Utils.succesfullyRelationDelete(ids[0], ids[1]);
                this.visualGraph();
            }
        }
    }//GEN-LAST:event_delRelationActionPerformed

    /**
     * Allow addressed of graph
     */
    private void allowAddressedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allowAddressedActionPerformed
        Utils.information("El grafo ahora se encuentra 'DIRIGIDO'. Desde ahora las relaciones serán unidireccional");
        graph.setAddressed(true);
    }//GEN-LAST:event_allowAddressedActionPerformed

    /**
     * Disallow addressed of graph
     *
     * This convert relation into a bidirectional relations
     *
     * The result of size of graph can be modified
     */
    private void disableAddressedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disableAddressedActionPerformed
        Utils.information("El grafo ahora se encuentra 'NO DIRIGIDO'. Desde ahora las relaciones serán bidireccionales");
        graph.setAddressed(false);
    }//GEN-LAST:event_disableAddressedActionPerformed

    /**
     * Modified max nodes allowed of graph
     */
    private void setMaxNodesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setMaxNodesActionPerformed
        int nodes = Utils.requestNodes();

        if (nodes != -1) {
            int verf = graph.setMaxNodes(nodes);

            if (verf != -1) {
                Utils.succesfullyMaxNodesChange(nodes);
            }
        }
    }//GEN-LAST:event_setMaxNodesActionPerformed

    /**
     * BFS operation to view how nodes had
     */
    private void bfsAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bfsAdvanceActionPerformed
        int userId = Utils.requestId();
        int values = graph.bfs(userId);

        if (values != -1) {
            Utils.information("El recorrido BFS desde el nodo " + userId + " es de " + values + ". Esto incluye el nodo elegido");
        }
    }//GEN-LAST:event_bfsAdvanceActionPerformed

    /**
     * DFS operation to view how nodes had
     */
    private void dfsAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dfsAdvanceActionPerformed
        int userId = Utils.requestId();
        int values = graph.dfs(userId);

        if (values != -1) {
            Utils.information("El recorrido DFS desde el nodo " + userId + " es de " + values + ". Esto incluye el nodo elegido");
        }
    }//GEN-LAST:event_dfsAdvanceActionPerformed

    /**
     * Identify who is the node of connection of 2 islands (graphs)
     */
    private void bridgeIdentificationAdvanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bridgeIdentificationAdvanceActionPerformed
        String result = graph.bridgeIdentification();

        if (result != null) {
            Utils.information(result);
        }
    }//GEN-LAST:event_bridgeIdentificationAdvanceActionPerformed
    // </editor-fold>   

    // <editor-fold defaultstate="collapsed" desc="Functions"> 
    /**
     * Update data of graph into a general stadistics
     */
    private void update() {
        sizeGraph = graph.size;
        numNodes = graph.numNodes;
        allConections = graph.getSize();
    }

    /**
     * Create a visual graph
     * The visual graph is created with help of GraphStream lib
     * The material has multiples helpers to work and create a graph
     * 
     * This function is called all when the origin graph has been changed
     */
    private void visualGraph() {
        Graph visualGraph = this.visualGraphHelper();
        String styleSheet
                = "edge {"
                + "	size: 1px;"
                + "	fill-color: #CCCCCC;"
                + "	fill-mode: dyn-plain;"
                + "}"
                + "node {"
                + "	size: 6px;"
                + "	fill-color: #990000;"
                + "     text-color: #FFD700;"
                + "}"
                + "graph {"
                + "     fill-color: #333333;"
                + "}";
        
        // Configs
        System.setProperty("org.graphstream.ui", "swing");
        visualGraph.setAttribute("ui.stylesheet", styleSheet);
        visualGraph.setAttribute("ui.quality");
        visualGraph.setAttribute("ui.antialias");

        // ----------------------------------------------------
        this.viewer = new Viewer(visualGraph, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        this.viewPanel = viewer.addDefaultView(false);
        viewer.enableAutoLayout();

        // Add to JPanel: principalLayout
        principalLayout.removeAll();
        principalLayout.add(viewPanel);
        this.pack();
    }

    /**
     * Its helper of visualGraph()
     * 
     * Can create a Graph Class of GraphStream lib
     */
    private Graph visualGraphHelper() {
        Graph visualGraph = new SingleGraph("|||");

        // Adding nodes
        for (List user : graph.matrix) {
            if (user != null) {
                int id = user.user.id;

                try {
                    visualGraph.addNode(String.valueOf(id));
                } catch (IdAlreadyInUseException e) {
                    System.out.println("ERROR ADDING NODES: " + id + " is already used!");
                    return null;
                }
            }
        }

        // ----------------------------------------
        // Configure weight of relations
        // BetweennessCentrality bcb = new BetweennessCentrality();
        // bcb.setWeightAttributeName("weight");
        // ----------------------------------------
        
        // Adding edges
        for (List user : graph.matrix) {
            if (user != null) {
                ListNode edges = user.chain;
                int origin = user.user.id;

                while (edges != null) {
                    int destination = edges.key;
                    int weight = edges.weight;
                    String values = String.valueOf(origin) + String.valueOf(destination);
                    // -----------------------
                    try {
                        // Add relation
                        visualGraph.addEdge(values, String.valueOf(origin), String.valueOf(destination), graph.addressed);

                        // Add weight
                        Node originNode = visualGraph.getNode(String.valueOf(origin));
                        Node destinationNode = visualGraph.getNode(String.valueOf(destination));

                        // ----------------------------------------
                        // bcb.setWeight(originNode, destinationNode, weight);
                        // ----------------------------------------
                    } catch (EdgeRejectedException e) {
                        System.out.println("Error in creation of visual graph. Reject: " + e.getMessage());
                    } catch (ElementNotFoundException e) {
                        System.out.println("Error in creation of visual graph. Not found: " + e.getMessage());
                    } catch (IdAlreadyInUseException e) {
                        System.out.println("Error in creation of visual graph. Already use: " + e.getMessage());
                    }
                    // -----------------------
                    edges = edges.next;
                }
            }
        }

        // ----------------------------------------
        // Init weight
        // bcb.init(visualGraph);
        // bcb.compute();
        // ----------------------------------------
        // Write label
        for (Node node : visualGraph) {
            node.setAttribute("ui.label", node.getId());
        }

        return visualGraph;
    }
    // </editor-fold>    

    // <editor-fold defaultstate="collapsed" desc="Main function">  
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
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainGUI(title, app).setVisible(true);
        });
    }
    // </editor-fold>       

    // <editor-fold defaultstate="collapsed" desc="Variables declaration">   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem addNode;
    private javax.swing.JMenuItem addRelation;
    private javax.swing.JMenuItem addressedStadistic;
    private javax.swing.JMenu advancedMenu;
    private javax.swing.JMenuItem allowAddressed;
    private javax.swing.JMenuItem bfsAdvance;
    private javax.swing.JMenuItem bridgeIdentificationAdvance;
    private javax.swing.JMenu configGraphMenu;
    private javax.swing.JMenuItem delFile;
    private javax.swing.JMenuItem delNode;
    private javax.swing.JMenuItem delRelation;
    private javax.swing.JMenuItem dfsAdvance;
    private javax.swing.JMenuItem disableAddressed;
    private javax.swing.JMenuItem existsRelationsStadistic;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPopupMenu.Separator filemenusep;
    private javax.swing.JPopupMenu.Separator filemenusep2;
    private javax.swing.JMenuItem generalStadistic;
    private javax.swing.JMenuItem gradeInStadistic;
    private javax.swing.JMenuItem gradeIncidenceStadistic;
    private javax.swing.JMenuItem gradeOutStadistic;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenuItem loadFile;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenu nodesMenu;
    private javax.swing.JPanel principalLayout;
    private javax.swing.JMenu relationsMenu;
    private javax.swing.JMenuItem saveChanges;
    private javax.swing.JMenuItem setMaxNodes;
    private javax.swing.JMenu stadisticsMenu;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>       
}
