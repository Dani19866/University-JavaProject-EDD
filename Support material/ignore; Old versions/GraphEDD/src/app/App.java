/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

/*
    1. Mejorar error de /File/verifyLines para evitar errores con archivos sin una estructura
 */
import gui.GraphsGUI;
import gui.InfoGraphs;
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
import classes.Relations;
import classes.User;
import graps.MatrixGraph;
import utils.Utils;
// <editor-fold defaultstate="collapsed" desc="...">
// </editor-fold>

/**
 *
 * @author Daniel
 */
public class App {

    public LinkedList<String> lines = new LinkedList();
    private final LinkedList<User> usersList = new LinkedList();
    private final LinkedList<Relations> relationsList = new LinkedList();
    
    public void tests(){
        MatrixGraph matrixGraph = new MatrixGraph(true, usersList.getSize());
        
        Node<User> users = usersList.getHead();
        while(users != null){
            User user = users.getData();
            // -------------------------------
            matrixGraph.addVertex(user);
            // -------------------------------
            users = users.getNextNode();
        }
        
        Node<Relations> relations = relationsList.getHead();
        while(relations != null){
            Relations relation = relations.getData();
            // -------------------------------
            matrixGraph.addEdge(relation);
            // -------------------------------
            relations = relations.getNextNode();
        }
        
        // -------------------------------
        matrixGraph.helperShowTable();
    }
    
    // <editor-fold defaultstate="collapsed" desc="GUI's"> 
    public void showInfoGraphs() {
        InfoGraphs infoGraphs = new InfoGraphs();
        infoGraphs.setVisible(true);
    }

    public void showGraphs() {
        GraphsGUI graphs = new GraphsGUI();
        graphs.setVisible(true);
    }
    // </editor-fold> 

    // <editor-fold defaultstate="collapsed" desc="File">
    public void fileReader(boolean aux, JFrame MainFrame) {
        // 1. New graph
        if (aux) {
            // 1.1. Change old to new window of JFileChooser
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            }

            // 1.2. JFileChoouse
            JFileChooser fc = new JFileChooser();
            fc.setDialogTitle("Seleccionar un archivo de texto (TXT)");
            fc.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
            fc.addChoosableFileFilter(filter);
            int select = fc.showOpenDialog(MainFrame);

            // 1.3. Success select
            if (select == JFileChooser.APPROVE_OPTION) {
                String originFile = fc.getSelectedFile().getAbsolutePath();
                String nameFile = "graph.txt";
                String destinationFile = System.getProperty("user.dir") + File.separator + "src\\App" + File.separator + nameFile;; // Ruta del archivo de destino
                System.out.println(destinationFile);
                try {
                    // 1.3.1 Open file mode reader
                    FileReader fileReader = new FileReader(originFile);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    // 1.3.2 Open file mode writer
                    FileWriter fileWriter = new FileWriter(destinationFile);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                    String linea;

                    // 1.3.3 Read origin file linea each line & write in the destination file
                    while ((linea = bufferedReader.readLine()) != null) {
                        bufferedWriter.write(linea);
                        bufferedWriter.newLine();
                    }

                    // 1.3.4 Close files
                    bufferedReader.close();
                    bufferedWriter.close();

                    // 1.3.5 Read file
                    this.fileReader(false, null);

                } catch (IOException e) {
                    Utils.error("Error al leer el archivo!", false);
                }
            }

        } // 2. Read graph
        else {
            // 1.1. Name file
            String nameFile = "graph.txt";

            // 1.2. Absolute path
            String routeFile = System.getProperty("user.dir") + File.separator + "src\\App" + File.separator + nameFile;

            // 1.3. Read file
            File file = new File(routeFile);

            // 1.4. Each lines of file
            try {
                // 1.4.1. Invoke scanner of lines
                Scanner scanner = new Scanner(file);

                // 1.4.2. ERROR: File empty
                if (!scanner.hasNextLine()) {
                    Utils.error("El archivo está vacío!", false);
                } // 1.4.2. Read file
                else {
                    while (scanner.hasNextLine()) {
                        // 1.4.3. Read line and save in linkedList
                        String line = scanner.nextLine();
                        this.lines.addLast(line);
                    }
                }

                // 1.4.-1. Close scanner
                scanner.close();
            } catch (FileNotFoundException e) {
                Utils.error("No se encontró el archivo", false);
            }
        }

    }

    public void verifyLines() {
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

    public void updateChanges() {

    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public LinkedList<User> getUserList() {
        return this.usersList;
    }

    public LinkedList<Relations> getRelationsList() {
        return this.relationsList;
    }
    // </editor-fold>
}
