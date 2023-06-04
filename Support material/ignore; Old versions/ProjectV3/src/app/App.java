/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import graph.list.ListGraph;
import graph.matrix.MatrixGraph;
import gui.GUI;
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

    private String titleProgram = "";

    public LinkedList<String> lines;
    public LinkedList<User> usersList;
    public LinkedList<Relations> relationsList;

    private String nameFile = "graph.txt";
    private String absolutePath = System.getProperty("user.dir") + File.separator + "src\\App" + File.separator + nameFile;

    // READY
    // <editor-fold defaultstate="collapsed" desc="Constructor">
    /**
     * Constructor for the App class.Initializes the lines, usersList, and
     * relationsList.
     *
     * @param title Title of GUI
     */
    public App(String title) {
        this.titleProgram = title;

        this.lines = new LinkedList();
        this.usersList = new LinkedList();
        this.relationsList = new LinkedList();
    }
    // </editor-fold>

    // READY
    // <editor-fold defaultstate="collapsed" desc="Start function">
    public void start() {
        this.gui();
    }
    // </editor-fold>

    // READY
    // <editor-fold defaultstate="collapsed" desc="File manager: Load/New file">
    /**
     * Performs the file algorithm to read and process the file.
     *
     * @param newGraph Indicates whether to use a new file or the existing file.
     * @param mainGUI The main JFrame object.
     * @return Return value to enable buttons
     */
    public int fileAlgorithm(boolean newGraph, JFrame mainGUI) {
        // 0. Zero: Reset all
        this.lines = new LinkedList();
        this.usersList = new LinkedList();
        this.relationsList = new LinkedList();
        this.fileChangeAppareanceOfJFileChoose();

        // 1. Firts: Verify exist file
        this.fileExists();

        // 2. Second: Work with param to use a new graph or actual graph. Next is to create work with new graph
        if (newGraph) {
            String pathFile;
            int verification;

            // File select
            {
                pathFile = this.fileGetPathFile(mainGUI);
                // Control error: File select
                if (pathFile == null) {
                    return -1;
                }
            }

            // Rewrite database
            {
                verification = this.fileRewriter(pathFile);
                if (verification == -1) {
                    return -1;
                }
            }

            // File work
            {
                verification = this.fileWork();
                if (verification == -1) {
                    return -1;
                }
            }

        } else {
            int verification;

            // File work
            {
                verification = this.fileWork();
                if (verification == -1) {
                    return -1;
                }
            }
        }

        {
            int verification = this.linesWork();

            if (verification == -1) {
                return -1;
            }

            Utils.information("Los usuarios fueron cargados en minúsculas");
            Utils.information("Todos los usuarios fueron transformados a nodos. Pueden haber subgrupos de nodos en un mismo grafo llamados así grafos dentro de un grafo principal");

            return 0;
        }
    }

    /**
     * Checks if the file exists and creates if it doesn't exist
     */
    private void fileExists() {
        File file = new File(absolutePath);

        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                } else {
                }
            } catch (IOException e) {
                Utils.error("ERROR FATAL! No se puede crear el archivo 'graph.txt' en la ruta app/graph.txt.", true);
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
            Utils.error("ERROR! Occurrió un problema seleccionando el nuevo archivo.", false);
            return null;
        }
    }

    /**
     * Rewrites the contents of the origin file into the destination file.
     *
     * @param originPath The path of the origin file.
     */
    private int fileRewriter(String originPath) {
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
            return 0;

        } catch (IOException e) {
            Utils.error("ERROR! Occurrió un problema leyendo el nuevo archivo.", false);
            return -1;
        }
    }

    /**
     * Reads the contents of the file and stores them in the lines LinkedList.
     */
    private int fileWork() {
        try {
            File file = new File(absolutePath);
            try ( Scanner scanner = new Scanner(file)) {
                if (!scanner.hasNextLine()) {
                    Utils.error("ERROR! El archivo está vacío!", false);
                    return -1;
                } else {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        lines.addLast(line);
                    }
                }
            }
            return 0;
        } catch (FileNotFoundException e) {
            Utils.error("ERROR! No se encontró el archivo 'graph.txt'. Por favor abra el programa otra vez para que este se reinicie...)", true);
            return -1;
        }
    }

    /**
     * Processes the lines in the LinkedList to add users and relations to their
     * respective LinkedLists.
     */
    private int linesWork() {
        try {
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

                return 0;
            }
        } catch (NumberFormatException e) {
            Utils.error("ERROR! Este archivo no es válido, Por favor cargue un nuevo archivo.", false);
            return -1;
        }
    }
    // </editor-fold>

    // READY
    // <editor-fold defaultstate="collapsed" desc="File manager: Save changes">
    public void saveChanges(LinkedList<String> lines) {
        Node<String> linesNode = lines.getHead();

        try {
            try (FileWriter writter = new FileWriter(absolutePath)) {
                while (linesNode != null) {
                    String line = linesNode.getData();
                    writter.write(line + "\n");
                    linesNode = linesNode.getNextNode();
                }
            }
            
            Utils.information("Se han guardado los cambios!");
        } catch (IOException e) {
            Utils.error("ERROR! Ocurrió un error inesperado", false);
        }
    }

    public void deleteFileData() {
        try {
            File archivo = new File(absolutePath);
            if (!archivo.exists()) {
                this.fileExists();
            }

            try ( FileWriter writter = new FileWriter(archivo)) {
                writter.write("");
            }

            Utils.information("Los datos del archivo han sido borrados!");
        } catch (IOException e) {
            Utils.error("ERROR! ocurrió un error inesperado", false);
        }
    }
    // </editor-fold>

    // READY
    // <editor-fold defaultstate="collapsed" desc="GUI">
    public void gui() {
        GUI gui = new GUI(titleProgram, this);
    }
    // </editor-fold>

    // READY
    // <editor-fold defaultstate="collapsed" desc="Graphs">
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

    public ListGraph getListGraph() {
        ListGraph graph = new ListGraph(true, usersList.getSize());
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
    // </editor-fold>
}
