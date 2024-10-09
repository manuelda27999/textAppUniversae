package api;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class utilityCSV {

    public static ArrayList<Preguntas> leerElArchivo(String rutaArchivo, ArrayList<Preguntas> arrayL) {

        // Crea un objeto Preguntas para almacenar los datos de cada línea
        Preguntas p;

        String[] datos;

        // Intenta abrir el archivo especificado en rutaArchivo
        try (Scanner scFile = new Scanner(new File(rutaArchivo))) {

            // Mientras haya líneas en el archivo
            while (scFile.hasNextLine()) {

                // Lee la siguiente línea del archivo y la divide en partes separadas por ";"
                datos = scFile.nextLine().split(";");

                // Crea un objeto Preguntas con los datos obtenidos
                p = new Preguntas(datos[0], datos[1], datos[2], datos[3], datos[4]);

                arrayL.add(p);
            }

        } catch (Exception e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return arrayL;
    }

    //Crea o actualiza un archivo CSV con una lista de preguntas.
    public static void crearYAnexarAArchivoCsv(String rutaArchivo, ArrayList<Preguntas> arrayPreguntas) {

        // Crea un nuevo archivo CSV en la ruta especificada
        File f = new File(rutaArchivo);

        // Si el archivo existe, anexamos datos
        if (f.exists()) {
            System.out.println("El archivo ya existe");
        }

        // Intenta escribir en el archivo
        try (FileWriter fw = new FileWriter(f, false)) {

            // Itera sobre cada pregunta en la lista
            for (Preguntas preguntas : arrayPreguntas) {

                // Obtiene la representación en CSV de la pregunta y la escribe en el archivo
                fw.write(preguntas.tuCSV() + "\n");
            }

        } catch (Exception e) {
            System.out.println("Error al crear el archivo");

        }

    }

}
