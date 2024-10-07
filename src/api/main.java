package api;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class main {

//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//
//        String ruta = "src/api/datos.csv";
//        
//        ArrayList<Preguntas> al = listaPreguntas(sc);
//        
//        
//     
//        
//
//        crearArchivoCsv( ruta, al);
//        
//        leerElArchivo(ruta, al);
//        
//        eliminarPreguntaCsv(ruta, 0, al, ruta);
//       
// 
//
//    }
//    
       
    public static void eliminarPreguntaCsv(String archivoCSV, int indicePregunta, ArrayList<Preguntas> arrayL) {
        
        if (indicePregunta >= 0 && indicePregunta < arrayL.size()) {           
            
            //Eliminar la pregunta del ArrayList
            arrayL.remove(indicePregunta);
            
            File archivo = new File(archivoCSV);
            
            //Si el archivo ya existe lo borra.
            if(archivo.exists()) {
                
                archivo.delete();
            }
            
            //Crea un archivo csv con las preguntas resantes.
            crearArchivoCsv(archivoCSV, arrayL);
            
            System.out.println("Preguta eliminada y archivo actualizado.");
        }else {
            System.out.println("Indice fuera de rango");
        }
       
        
    }
    
    
    public static ArrayList<Preguntas> leerElArchivo(String rutaArchivo, ArrayList<Preguntas> arrayL){
        
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
            System.err.println("Error");
        }
        
        for (Preguntas pregunta : arrayL) {
            System.out.println(pregunta);
        }
        return arrayL;
    }
   
    
    public static boolean crearArchivoCsv( String rutaArchivo, ArrayList<Preguntas> arrayPreguntas) {

        // Crea un nuevo archivo CSV en la ruta especificada
        File f = new File(rutaArchivo);
       
        // Intenta escribir en el archivo
        try (FileWriter fw = new FileWriter(f, true)) {

            // Itera sobre cada pregunta en la lista
            for (Preguntas preguntas : arrayPreguntas) {

                
                // Obtiene la representación en CSV de la pregunta y la escribe en el archivo
                fw.write(preguntas.tuCSV() + "\n");
            }
            return true;

        } catch (Exception e) {
            System.out.println("Se ha producido un error");
            
        }
        return false;
    }

    
    //Este método crea una lista de preguntas a partir de una entrada del usuario por consola.
    public static ArrayList<Preguntas> listaPreguntas(Scanner sc) {

        // Crea una lista vacía para almacenar las preguntas
        ArrayList<Preguntas> array = new ArrayList<Preguntas>();

        // Variables para almacenar la pregunta y las respuestas
        String pregunta;
        String respuestaCorrecta;
        String respuestaIncorrecta1;
        String respuestaIncorrecta2;
        String respuestaIncorrecta3;

        Preguntas p;

        // Bucle que se repite hasta que el usuario ingresa "Fin"
        do {

            // Solicita al usuario que ingrese una pregunta
            System.out.println("Pregunta (o 'Fin' para terminar: ");
            pregunta = sc.nextLine();

            // Si la pregunta no es "Fin", sigue solicitando las respuestas y crea un objeto Pregunta
            if (!pregunta.equalsIgnoreCase("Fin")) {
                System.out.println("Respuesta Correcta: ");
                respuestaCorrecta = sc.nextLine();
                System.out.println("Respuesta Incorrecta1: ");
                respuestaIncorrecta1 = sc.nextLine();
                System.out.println("Respuesta Incorrecta2: ");
                respuestaIncorrecta2 = sc.nextLine();
                System.out.println("Respuesta Incorrecta3: ");
                respuestaIncorrecta3 = sc.nextLine();

                // Crea un nuevo objeto Pregunta con los datos ingresados
                p = new Preguntas(pregunta, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3);

                // Agrega el objeto Pregunta a la lista
                array.add(p);
            }

        } while (!pregunta.equalsIgnoreCase("Fin"));

        // Devuelve la lista de preguntas completa
        return array;

    }
    
 

}
