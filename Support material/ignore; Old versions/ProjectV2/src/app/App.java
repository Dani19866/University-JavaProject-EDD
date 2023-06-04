/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import graphs.list.ListGraph;
import graphs.matrix.MatrixGraph;
import gui.MainGUI;
import gui.MatrixGUI;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import linkedList.LinkedList;
import linkedList.Node;
import user.Relations;
import user.User;
import utils.Utils;

/**
 * This class represents an application that manages lines of TXT files to
 * manages users, and relations to create graphs.
 *
 * @author Daniel
 */
public class App {

    public LinkedList<String> lines;
    public LinkedList<User> usersList;
    public LinkedList<Relations> relationsList;

    private String nameFile = "graph.txt";
    private String absolutePath = System.getProperty("user.dir") + File.separator + "src\\App" + File.separator + nameFile;

    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor for the App class. Initializes the lines, usersList, and
     * relationsList.
     */
    public App() {
        this.lines = new LinkedList();
        this.usersList = new LinkedList();
        this.relationsList = new LinkedList();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Start function">
    /**
     * Starts the application showing GUI.
     */
    public void start() {
        this.showMainGUI();
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="GUI's">
    /**
     * Shows the main graphical user interface (GUI).
     */
    private void showMainGUI() {
        MainGUI gui = new MainGUI(this);
    }

    /**
     * Shows the available options for displaying graphs.
     */
    public void showGraphs() {
        String[] options = {"Matriz", "Lista"};
        String selection = Utils.Popup(options);

        if ("Matriz".equals(selection)) {
            MatrixGraph graph = this.getMatrixGraph();
            MatrixGUI gui = new MatrixGUI(graph);
        }

        if ("Lista".equals(selection)) {
            ListGraph graph = this.getListGraph();
        }
    }

    /**
     * Displays information about the graphs.
     * @param selection 1 is to view data with matrix passed | selection 2 is with list
     */
    public void showInfoGraphs(int selection) {
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Graphs">
    /**
     * Retrieves a matrix graph representation based on the users and relations
     * lists.
     *
     * @return A MatrixGraph object representing the graph.
     */
    public MatrixGraph getMatrixGraph() {
        MatrixGraph graph = new MatrixGraph(true, usersList.getSize());
        // --------------------------------
        Node<User> users = usersList.getHead();
        while (users != null) {
            User user = users.getData();
            graph.addVertex(user);
            users = users.getNextNode();
        }
        // --------------------------------
        Node<Relations> relations = relationsList.getHead();
        while (relations != null) {
            Relations relation = relations.getData();
            graph.addEdge(relation);
            relations = relations.getNextNode();
        }
        // --------------------------------
        return graph;
    }

    /**
     * Retrieves a list graph representation.
     *
     * @return A ListGraph object representing the graph.
     */
    public ListGraph getListGraph() {
        ListGraph graph = new ListGraph(true, usersList.getSize());
        // --------------------------------
        Node<User> users = usersList.getHead();
        while (users != null){
            User user = users.getData();
            // ==================================
            graph.addVertex(user);
            // ==================================
            users = users.getNextNode();
        }
        // --------------------------------
        Node<Relations> relations = relationsList.getHead();
        while (relations != null){
            Relations relation = relations.getData();
            User userOrigin = new User(relation.userOrigin, usersList.searchUserWithID(relation.userOrigin));
            User userDestination = new User(relation.userDestination, usersList.searchUserWithID(relation.userDestination));
            
            graph.addEdge(userOrigin, userDestination, relation.weight);
            relations = relations.getNextNode();
        }
        // --------------------------------
        return graph;
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="File manager">
    /**
     * Performs the file algorithm to read and process the file.
     *
     * @param newGraph Indicates whether to use a new file or the existing file.
     * @param mainGUI The main JFrame object.
     */
    public void fileAlgorithm(boolean newGraph, JFrame mainGUI) {
        // 1. Firts: Verify exist file
        this.fileExists();

        // 2. Second: Work with param to use a new graph or actual graph. Next is to create work with new graph
        if (newGraph) {
            this.fileChangeAppareanceOfJFileChoose();
            String pathFile = this.fileGetPathFile(mainGUI);
            this.fileRewriter(pathFile);
            this.fileWork();
        } else {
            this.fileWork();
        }

        // 3. Work wiih lines linkedList to add in user and relations linkedList
        this.linesWork();
    }

    /**
     * Checks if the file exists and creates if it doesn't exist
     */
    private void fileExists() {
        File file = new File(absolutePath);

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("El archivo se ha creado exitosamente.");
                } else {
                    System.out.println("No se pudo crear el archivo.");
                }
            } catch (IOException e) {
                System.out.println("Error al crear el archivo: " + e.getMessage());
            }
        }
    }

    /**
     * Changes the appearance of the JFileChooser
     */
    private void fileChangeAppareanceOfJFileChoose() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }

    /**
     * Opens a file chooser to select a text file (TXT).
     *
     * @param mainGUI The main JFrame object.
     * @return The absolute path of the selected file.
     */
    private String fileGetPathFile(JFrame mainGUI) {
        // 1. JFileChooser
        JFileChooser fc = new JFileChooser();

        // JFileChooser: Title
        fc.setDialogTitle("Seleccionar un archivo de texto (TXT)");
        // JFileChooser: Filter
        fc.setAcceptAllFileFilterUsed(false);
        // JFileChooser: Add filter
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
        // JFileChooser: Add filter to JFilerChooser
        fc.addChoosableFileFilter(filter);

        // 2. Save selection
        int select = fc.showOpenDialog(mainGUI);

        // 3. Success selection
        if (select == JFileChooser.APPROVE_OPTION) {
            String originFile = fc.getSelectedFile().getAbsolutePath();
            return originFile;
        } else {
            Utils.error("ERROR! Occurrió un problema seleccionando el nuevo archivo. Para evitar problemas, se va a cerrar el programa, cargue de nuevo el archivo correctamente", true);
            return null;
        }
    }

    /**
     * Rewrites the contents of the origin file into the destination file.
     *
     * @param originPath The path of the origin file.
     */
    private void fileRewriter(String originPath) {
        try {
            FileReader fileReader = new FileReader(originPath);
            BufferedWriter bufferedWriter;
            try ( BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                FileWriter fileWriter = new FileWriter(absolutePath);
                bufferedWriter = new BufferedWriter(fileWriter);
                String line;
                // 1.3.3 Read origin file linea each line & write in the destination file
                while ((line = bufferedReader.readLine()) != null) {
                    bufferedWriter.write(line);
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();

        } catch (IOException e) {
            Utils.error("ERROR! Occurrió un problema leyendo el nuevo archivo. Para evitar problemas, se va a cerrar el programa, cargue de nuevo el archivo correctamente", true);
        }
    }

    /**
     * Reads the contents of the file and stores them in the lines LinkedList.
     */
    private void fileWork() {
        try {
            File file = new File(absolutePath);
            Scanner scanner = new Scanner(file);

            if (!scanner.hasNextLine()) {
                Utils.error("ERROR! El archivo está vacío, cargue un archivo para que el programa funcione. Saliendo del programa...!", true);
            } else {
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    this.lines.addLast(line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            Utils.error("No se encontró el archivo", true);
        }
    }

    /**
     * Processes the lines in the LinkedList to add users and relations to their
     * respective LinkedLists.
     */
    private void linesWork() {
        // 1. Users
        {
            Node aux = this.lines.getHead();

            while (aux != null) {
                String value = (String) aux.getData().toString().toLowerCase().replace(" ", "").replace("@", "");

                if ("relaciones".equals(value)) {
                    break;
                }
                if (!"usuarios".equals(value)) {
                    String[] userSplit = value.split(",");
                    User userAdding = new User(Integer.parseInt(userSplit[0]), userSplit[1]);
                    usersList.addLast(userAdding);
                }

                aux = aux.getNextNode();
            }
        }

        // 2. Relations
        {
            Node aux = this.lines.getHead();

            while (aux != null) {
                String value = (String) aux.getData().toString().toLowerCase();

                if ("relaciones".equals(value)) {
                    aux = aux.getNextNode();
                    break;
                }

                aux = aux.getNextNode();
            }

            while (aux != null) {
                String value = (String) aux.getData().toString().toLowerCase().replace(" ", "");
                String[] relationsSplit = value.split(",");
                Relations relationsAdding = new Relations(Integer.parseInt(relationsSplit[0]), Integer.parseInt(relationsSplit[1]), Integer.parseInt(relationsSplit[2]));
                this.relationsList.addLast(relationsAdding);

                aux = aux.getNextNode();
            }
        }
    }
    // </editor-fold>
}
