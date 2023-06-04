/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import graph.ListGraph;
import gui.MainGUI;
import javax.swing.JFrame;
import linkedlist.LinkedList;
import linkedlist.Node;
import utils.FileManager;
import utils.Relations;
import utils.User;
import utils.Utils;

/**
 * The App class represents the main application class. It manages the GUI, file
 * operations, and graph creation.
 *
 * @author Daniel
 */
public class App {

    /**
     * The title of the GUI.
     */
    private String titleGUI;
    /**
     * The linked list of lines. Use: Helper of creation usersList and
     * relationsList
     */
    public LinkedList<String> lines;
    /**
     * The linked list of users.
     */
    public LinkedList<User> usersList;
    /**
     * The linked list of relations.
     */
    public LinkedList<Relations> relationsList;
    /**
     * The file manager used for file operations.
     */
    private FileManager fm = new FileManager();

    /**
     * Constructs an instance of the App class with the specified GUI title.
     * Initializes the linked lists and graph, and performs file operations.
     *
     * @param titleGUI the title of the GUI
     */
    public App(String titleGUI) {

        this.titleGUI = titleGUI;
        this.lines = new LinkedList();
        this.usersList = new LinkedList();
        this.relationsList = new LinkedList();
    }

    /**
     * Starts the application by displaying the GUI.
     */
    public void start() {
        this.gui();
    }

    /**
     * Displays the main GUI.
     */
    public void gui() {
        MainGUI gui = new MainGUI(titleGUI, this);
    }

    /**
     * Reset all actual linkedList and graph to create new Import data of actual
     * database or import new file graph (TXT)
     *
     * @param newGraph { true: To load TXT file to create new graph, false: Load
     * database file }
     * @param gui Father class of JFrame
     * @return {-1: Error in process, 0: OK}
     */
    public int fileAlgorithm(boolean newGraph, JFrame gui) {
        this.lines = new LinkedList();
        this.usersList = new LinkedList();
        this.relationsList = new LinkedList();
        // ----------------------
        fm.changeAppareanceOfJFileChoose();
        fm.exists();
        int verification;
        // ----------------------
        if (newGraph) {
            // Select file
            String pathFile = fm.pathFile(gui);
            if (pathFile == null) {
                return -1;
            }

            // Rewrite database
            verification = fm.rewriter(pathFile);
            if (verification == -1) {
                return -1;
            }
        }
        // ----------------------
        verification = fm.fileWork(this);
        if (verification == -1) {
            return -1;
        }
        // ----------------------
        verification = fm.linesWork(this);
        if (verification == -1) {
            return -1;
        }
        // ----------------------
        Utils.information("Los usuarios fueron cargados en minúsculas!");
        Utils.information("Todos los usuarios fueron transformados a nodos. Pueden haber subgrupos de nodos en un mismo grafo llamados así grafos dentro de un grafo principal");
        // ----------------------
        return 0;
    }

    /**
     * Creates and returns a ListGraph object based on the current state of the
     * ListGraph instance.
     *
     * @return a new ListGraph object representing the current graph
     */
    public ListGraph getGraph() {
        ListGraph graph = new ListGraph(true, usersList.size);
        // --------------------------------
        Node<User> users = usersList.pFirst;
        while (users != null) {
            User user = users.data;
            graph.addVertex(user);
            users = users.next;
        }
        // --------------------------------
        Node<Relations> relations = relationsList.pFirst;
        while (relations != null) {
            Relations relation = relations.data;
            graph.addEdge(relation);
            relations = relations.next;
        }
        // --------------------------------
        return graph;
    }

    /**
     * Deletes the data stored in the file.
     */
    public void deleteFileData() {
        fm.deleteFileData();
    }

    /**
     * Saves the provided lines of data to the file.
     *
     * @param lines the lines of data to be saved
     */
    public void saveData(LinkedList<String> lines) {
        fm.saveChanges(lines);
    }
    
}
