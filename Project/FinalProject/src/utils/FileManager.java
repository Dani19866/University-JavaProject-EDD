/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import app.App;
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
import linkedlist.LinkedList;
import linkedlist.Node;

/**
 * The FileManager class is responsible for managing file operations and
 * interactions. It provides methods for file existence check, changing the
 * appearance of JFileChooser, retrieving the path of a selected file, rewriting
 * file contents, working with file data, deleting file data, and saving changes
 * to a file.
 *
 * @author Daniel
 */
public class FileManager {

    /**
     * Name of file where data is saved 
     */
    private String nameFile = "graph.txt";
    /**
     * Absolute path of file
     * Ex: C:\Users\XXXXX\Documents\XXXXX\XXXXX\XXXXX\XXXXX\XXXXX\XXXXX\FinalProject\src\app\graph.txt
     */
    private String absolutePath = System.getProperty("user.dir") + File.separator + "src\\App" + File.separator + nameFile;

    /**
     * Checks if the file exists and creates it if it doesn't.
     */
    public void exists() {
        File file = new File(absolutePath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Utils.error("ERROR FATAL! No se puede crear el archivo 'graph.txt' en la ruta app/graph.txt.");
            }
        }
    }

    /**
     * Changes the appearance of JFileChooser to match the system look and feel.
     */
    public void changeAppareanceOfJFileChoose() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
        }
    }

    /**
     * Opens a JFileChooser dialog to select a text file.
     *
     * @param mainGUI the main JFrame instance
     * @return the absolute path of the selected file, or null if no file was
     * selected
     */
    public String pathFile(JFrame mainGUI) {
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
            Utils.error("ERROR! Occurrió un problema seleccionando el nuevo archivo.");
            return null;
        }
    }

    /**
     * Rewrites the contents of the destination file with the contents of the
     * origin file.
     *
     * @param originPath the path of the origin file
     * @return 0 if the rewriting was successful, -1 otherwise
     */
    public int rewriter(String originPath) {
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
            Utils.error("ERROR! Occurrió un problema leyendo el nuevo archivo.");
            return -1;
        }
    }

    /**
     * Reads the data from the file and populates the App object with the lines
     * of data.
     *
     * @param app the App instance
     * @return 0 if the file reading was successful, -1 otherwise
     */
    public int fileWork(App app) {
        try {
            File file = new File(absolutePath);
            try ( Scanner scanner = new Scanner(file)) {
                if (!scanner.hasNextLine()) {
                    Utils.error("ERROR! El archivo está vacío!");
                    return -1;
                } else {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        app.lines.addLast(line);
                    }
                }
            }
            return 0;
        } catch (FileNotFoundException e) {
            Utils.error("ERROR! No se encontró el archivo 'graph.txt'. Por favor abra el programa otra vez para que este se reinicie...)");
            return -1;
        }
    }

    /**
     * Processes the lines of data and extracts user and relation information,
     * adding them to the appropriate data structures in the App object.
     *
     * @param app the App instance
     * @return 0 if the lines processing was successful, -1 otherwise
     */
    public int linesWork(App app) {
        try {
            // 1. Users
            {
                Node aux = app.lines.pFirst;
                while (aux != null) {
                    String value = (String) aux.data.toString().toLowerCase().replace(" ", "").replace("@", "");
                    if ("relaciones".equals(value)) {
                        break;
                    }
                    if (!"usuarios".equals(value)) {
                        String[] userSplit = value.split(",");
                        User userAdding = new User(Integer.parseInt(userSplit[0]), userSplit[1]);
                        app.usersList.addLast(userAdding);
                    }
                    aux = aux.next;
                }
            }

            // 2. Relations
            {
                Node aux = app.lines.pFirst;
                while (aux != null) {
                    String value = (String) aux.data.toString().toLowerCase();
                    if ("relaciones".equals(value)) {
                        aux = aux.next;
                        break;
                    }
                    aux = aux.next;
                }
                while (aux != null) {
                    String value = (String) aux.data.toString().toLowerCase().replace(" ", "");
                    String[] relationsSplit = value.split(",");
                    Relations relationsAdding = new Relations(Integer.parseInt(relationsSplit[0]), Integer.parseInt(relationsSplit[1]), Integer.parseInt(relationsSplit[2]));
                    app.relationsList.addLast(relationsAdding);
                    aux = aux.next;
                }
                return 0;
            }
        } catch (NumberFormatException e) {
            Utils.error("ERROR! Este archivo no es válido, Por favor cargue un nuevo archivo.");
            return -1;
        }
    }

    /**
     * Deletes all data in the file, making it empty.
     */
    public void deleteFileData() {
        try {
            File archivo = new File(absolutePath);
            if (!archivo.exists()) {
                this.exists();
            }

            try ( FileWriter writter = new FileWriter(archivo)) {
                writter.write("");
            }

            Utils.information("Los datos del archivo han sido borrados!");
        } catch (IOException e) {
            Utils.error("Ocurrió un error inesperado!");
        }
    }

    /**
     * Saves the provided lines of data to the file, overwriting its previous
     * contents.
     *
     * @param lines the lines of data to be saved
     */
    public void saveChanges(LinkedList<String> lines) {
        Node<String> linesNode = lines.pFirst;

        try {
            try ( FileWriter writter = new FileWriter(absolutePath)) {
                while (linesNode != null) {
                    String line = linesNode.data;
                    writter.write(line + "\n");
                    linesNode = linesNode.next;
                }
            }

            Utils.information("Se han guardado los cambios!");
        } catch (IOException e) {
            Utils.error("ERROR! Ocurrió un error inesperado");
        }
    }
}
