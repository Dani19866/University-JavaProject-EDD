/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphproject.App;

import graphproject.LinkedList.LinkedList;
import graphproject.LinkedList.Node;
import graphproject.User.User;
import graphproject.Utils.Utils;
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

/**
 *
 * @author Daniel
 */
public class App {

    public LinkedList<String> lines = new LinkedList();
    private final LinkedList<String> usersList = new LinkedList();
    private final LinkedList<String> relationsList = new LinkedList();

    // <editor-fold defaultstate="collapsed" desc="GUI's"> 
    public void showIslands() {
    }

    public void showGraphs() {
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
                String destinationFile = System.getProperty("user.dir") + File.separator + "src\\graphproject" + "\\App" + File.separator + nameFile;; // Ruta del archivo de destino

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
            String routeFile = System.getProperty("user.dir") + File.separator + "src\\graphproject" + "\\App" + File.separator + nameFile;

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
        // 1. Obtain head of linkedList
        Node aux = this.lines.getHead();

        // 2. Loop for size of linkedList
        for (int i = 0; i < this.lines.getSize(); i++) {
            // 2.1. Extract value of node
            String value = (String) aux.getData();

            // 2.2. Filters
            if ("Usuarios".equals(value)) {
                Node auxUsers = aux;

                while (auxUsers != null) {
                    // 2.2.1. Get data of node 
                    String user = (String) auxUsers.getData();

                    // 2.2.2. Cut if line if "Relaciones"
                    if ("Relaciones".equals(user)) {
                        break;
                    } else {
                        // 2.2.2.1. Add if value is different at "Usuarios"
                        if (!"Usuarios".equals(value)) {
                            this.usersList.addLast(user);
                        }

                    }

                    auxUsers = auxUsers.getNextNode();
                }
            } else if ("Relaciones".equals(value)) {
                Node auxUsers = aux;

                while (auxUsers != null) {
                    // 2.2.1. Get data of node
                    String relations = (String) auxUsers.getData();

                    // 2.2.2. Add if value is different at "Relaciones"
                    if (!"Relaciones".equals(relations)) {
                        this.relationsList.addLast(relations);
                    }

                    auxUsers = auxUsers.getNextNode();
                }
            }

            aux = aux.getNextNode();
        }
    }
    
    public void updateChanges(){
        
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters">
    public LinkedList<String> getUserList() {
        return this.usersList;
    }

    public LinkedList<String> getRelationsList() {
        return this.relationsList;
    }
    // </editor-fold>
}
