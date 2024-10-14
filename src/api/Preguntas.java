package api;

import java.util.Objects;



public class Preguntas {

    
    private String pregunta;// Almacena el texto de la pregunta
    private String respuestaCorrecta;// Almacena la respuesta correcta
    private String respuestaIncorrecta1;// Almacena la primera respuesta incorrecta
    private String respuestaIncorrecta2;
    private String respuestaIncorrecta3;

    public Preguntas(String pregunta, String respuestaCorrecta, String respuestaIncorrecta1, String respuestaIncorrecta2, String respuestaIncorrecta3) {
        
        //Inicializa los atributos de la pregunta
        
        this.pregunta = pregunta;
        this.respuestaCorrecta = respuestaCorrecta;
        this.respuestaIncorrecta1 = respuestaIncorrecta1;
        this.respuestaIncorrecta2 = respuestaIncorrecta2;
        this.respuestaIncorrecta3 = respuestaIncorrecta3;

    }
    
    
    
    
    // Devuelve una representación en cadena de texto (String) del objeto Preguntas.
    @Override
    public String toString() {
        return "Preguntas{" + "pregunta: " + pregunta + ", respuestaCorrecta: " + respuestaCorrecta + ", respuestaIncorrecta1: " + respuestaIncorrecta1 + ", respuestaIncorrecta2: " + respuestaIncorrecta2 + ", respuestaIncorrecta3: " + respuestaIncorrecta3 + '}';
    }

    
    // Método para obtener una representación de la pregunta en formato CSV
    public String tuCSV() {
        return this.pregunta + ";" + this.respuestaCorrecta + ";" + this.respuestaIncorrecta1 + ";" + this.respuestaIncorrecta2 + ";" + this.respuestaIncorrecta3;
    }
    
     // Sobrescribimos el método equals() para comparar los atributos relevantes
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Si es el mismo objeto, son iguales
        if (obj == null || getClass() != obj.getClass()) return false; // Si es de otra clase, no son iguales
        
        Preguntas otraPregunta = (Preguntas) obj;

        // Comparamos cada campo relevante para decidir si dos objetos son iguales
        return pregunta.equals(otraPregunta.pregunta) &&
               respuestaCorrecta.equals(otraPregunta.respuestaCorrecta) &&
               respuestaIncorrecta1.equals(otraPregunta.respuestaIncorrecta1) &&
               respuestaIncorrecta2.equals(otraPregunta.respuestaIncorrecta2) &&
               respuestaIncorrecta3.equals(otraPregunta.respuestaIncorrecta3);
    }

    // Sobrescribimos hashCode() para que coincida con el resultado de equals()
    @Override
    public int hashCode() {
        return Objects.hash(pregunta, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3);
    }

    
   
    // Métodos getter y setter para acceder y modificar los atributos de la pregunta
   
    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getRespuestaIncorrecta1() {
        return respuestaIncorrecta1;
    }

    public void setRespuestaIncorrecta1(String respuestaIncorrecta1) {
        this.respuestaIncorrecta1 = respuestaIncorrecta1;
    }

    public String getRespuestaIncorrecta2() {
        return respuestaIncorrecta2;
    }

    public void setRespuestaIncorrecta2(String respuestaIncorrecta2) {
        this.respuestaIncorrecta2 = respuestaIncorrecta2;
    }

    public String getRespuestaIncorrecta3() {
        return respuestaIncorrecta3;
    }

    public void setRespuestaIncorrecta3(String respuestaIncorrecta3) {
        this.respuestaIncorrecta3 = respuestaIncorrecta3;
    }

}
