package api;

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
