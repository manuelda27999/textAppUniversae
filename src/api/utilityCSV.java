package api;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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

            //Las preguntas han sido cargadas con éxito
        } catch (Exception e) {

            //No se encontró el archivo de preguntas
        }

        return arrayL;
    }

    //Crea o actualiza un archivo CSV con una lista de preguntas.
    public static void crearYAnexarAArchivoCsv(String rutaArchivo, ArrayList<Preguntas> arrayPreguntas) {

        // Crea un nuevo archivo CSV en la ruta especificada
        File f = new File(rutaArchivo);

        // Intenta escribir en el archivo
        try (FileWriter fw = new FileWriter(f, false)) {

            // Itera sobre cada pregunta en la lista
            for (Preguntas preguntas : arrayPreguntas) {

                // Obtiene la representación en CSV de la pregunta y la escribe en el archivo
                fw.write(preguntas.tuCSV() + "\n");
            }

            //Las preguntas han sido guardadas (X en total)
        } catch (Exception e) {
            System.out.println("Error al crear el archivo");

        }

    }

    public static void agregarArchivo(String ruta, String directorio, ZipOutputStream zip) throws Exception {

        //Crea un nuevo objeto File que representa el directorio.
        File archivo = new File(directorio);

        if (archivo.isDirectory()) {

            agregarCarpeta(ruta, directorio, zip);

        } else {

            //Crea un array de bytes con tamaño de 4096bytes
            byte[] buffer = new byte[4096];
            int longitud;

            FileInputStream entrada = new FileInputStream(archivo);

            zip.putNextEntry(new ZipEntry(ruta + "/" + archivo.getName()));

            while ((longitud = entrada.read(buffer)) >= 0) {
                zip.write(buffer, 0, longitud);
            }
        }
    }

    public static void agregarCarpeta(String ruta, String carpeta, ZipOutputStream zip) throws Exception {

        File directorio = new File(carpeta);

        for (String nombreArchivo : directorio.list()) {

            if (ruta.equals("")) {

                agregarArchivo(directorio.getName(), carpeta + "/" + nombreArchivo, zip);
            } else {

                agregarArchivo(ruta + "/" + directorio.getName(), carpeta + "/" + nombreArchivo, zip);
            }
        }
    }

    public static void comprimir(String archivo, String archivoZIP) throws Exception {

        //Implementa un filtro de flujo de salida para escribir archivos en formato ZIP.
        ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(archivoZIP));

        agregarCarpeta("", archivo, zip);

        //Sirve para vaciar la secuencia escribiendo cualquier salida almacenada en la secuencia subyacente.
        zip.flush();

        //Cierra este flujo y libera todos los recursos del sistema asociados a él.  
        zip.close();

        //Las preguntas se guardaron y se exportó el simulador en: X/X.zip
    }

    public static void copiarArchivoCSVEnRutaNueva() {
        Path rutaCSVOriginal = Paths.get("src/api/datos.csv");

        Path rutaCSVDestino = Paths.get("QuizDemo/QuizDemo_Data/StreamingAssets/Preguntas.csv");

        try {

            //Copia el archivo en la ruta destino.
            Files.copy(rutaCSVOriginal, rutaCSVDestino);

            System.out.println("Archivo copiado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al copiar el archivo: " + e.getMessage());
        }
    }

}
