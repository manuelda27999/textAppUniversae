package app;

import api.Preguntas;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

;

/**
 *
 * @author ManuelDa
 */
public class panelPregunta extends javax.swing.JPanel {

    public main padre;

    public panelPregunta() {

        initComponents();

    }

    public void iniciar(int index, ArrayList<Preguntas> lista) {

        // Crea un objeto Random para generar números aleatorios
        Random numeroRandom = new Random();

        // Genera un color aleatorio
        int red = numeroRandom.nextInt(256);
        int green = numeroRandom.nextInt(256);
        int blue = numeroRandom.nextInt(256);

        Color colorAletorio = new Color(red, green, blue);

        // Cambia el fondo del panel con el color aleatorio
        for (int i = 0; i < index; i++) {
            jPanelfondo.setBackground(colorAletorio);
        }

        
        if (index < lista.size()) {
            String pregunta = lista.get(index).getPregunta();
            String respuestaCorrecta = lista.get(index).getRespuestaCorrecta();
            String respuestaIncorrecta1 = lista.get(index).getRespuestaIncorrecta1();
            String respuestaIncorrecta2 = lista.get(index).getRespuestaIncorrecta2();
            String respuestaIncorrecta3 = lista.get(index).getRespuestaIncorrecta3();

            jTextFieldPregunta.setText(pregunta);
            jTextFieldPregunta1.setText(respuestaCorrecta);
            jTextFieldPregunta4.setText(respuestaIncorrecta1);
            jTextFieldPregunta3.setText(respuestaIncorrecta2);
            jTextFieldPregunta2.setText(respuestaIncorrecta3);
        }
        
        

//            String pregunta = jTextFieldPregunta.getText();
//            String respuestaCorrecta = jTextFieldPregunta1.getText();
//            String respuestaIncorrecta1 = jTextFieldPregunta4.getText();
//            String respuestaIncorrecta2 = jTextFieldPregunta3.getText();
//            String respuestaIncorrecta3 = jTextFieldPregunta2.getText();
            
//            Preguntas nuevaPregunta = new Preguntas(pregunta, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3);
//
//            if (!pregunta.isEmpty() && !respuestaCorrecta.isEmpty()
//                    && !respuestaIncorrecta1.isEmpty() && !respuestaIncorrecta2.isEmpty()
//                    && !respuestaIncorrecta3.isEmpty()) {
//
//                
//                lista.add(nuevaPregunta);
//
//            } else {
//                System.out.println("Los campos estan vacios.");
//            }
//        }

    }
    
    // Métodos para obtener los textos de los JTextField
    public String getPreguntaText() {
        return jTextFieldPregunta.getText();
    }

    public String getRespuestaCorrectaText() {
        return jTextFieldPregunta1.getText();
    }

    public String getRespuestaIncorrecta1Text() {
        return jTextFieldPregunta2.getText();
    }

    public String getRespuestaIncorrecta2Text() {
        return jTextFieldPregunta3.getText();
    }

    public String getRespuestaIncorrecta3Text() {
        return jTextFieldPregunta4.getText();
    }
    
   

    
   
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelfondo = new javax.swing.JPanel();
        jLabelPregunta = new javax.swing.JLabel();
        jTextFieldPregunta = new javax.swing.JTextField();
        jLabelPregunta1 = new javax.swing.JLabel();
        jTextFieldPregunta1 = new javax.swing.JTextField();
        jLabelPregunta2 = new javax.swing.JLabel();
        jTextFieldPregunta2 = new javax.swing.JTextField();
        jTextFieldPregunta3 = new javax.swing.JTextField();
        jTextFieldPregunta4 = new javax.swing.JTextField();

        jPanelfondo.setBackground(new java.awt.Color(26, 41, 54));
        jPanelfondo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(5, 20, 36), 3, true));
        jPanelfondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPregunta.setBackground(new java.awt.Color(26, 41, 54));
        jLabelPregunta.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPregunta.setText("Pregunta");
        jPanelfondo.add(jLabelPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 20));

        jTextFieldPregunta.setBackground(new java.awt.Color(72, 83, 93));
        jTextFieldPregunta.setColumns(2);
        jTextFieldPregunta.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextFieldPregunta.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPregunta.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextFieldPregunta.setBorder(javax.swing.BorderFactory.createEmptyBorder(6, 6, 6, 6));
        jTextFieldPregunta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPregunta.setOpaque(true);
        jPanelfondo.add(jTextFieldPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 300, 40));

        jLabelPregunta1.setBackground(new java.awt.Color(26, 41, 54));
        jLabelPregunta1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPregunta1.setText("Respuesta correcta");
        jPanelfondo.add(jLabelPregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 160, 20));

        jTextFieldPregunta1.setBackground(new java.awt.Color(72, 83, 93));
        jTextFieldPregunta1.setColumns(2);
        jTextFieldPregunta1.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextFieldPregunta1.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPregunta1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6));
        jTextFieldPregunta1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPregunta1.setOpaque(true);
        jPanelfondo.add(jTextFieldPregunta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 300, 20));

        jLabelPregunta2.setBackground(new java.awt.Color(26, 41, 54));
        jLabelPregunta2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPregunta2.setText("Respuestas incorrectas");
        jPanelfondo.add(jLabelPregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, 20));

        jTextFieldPregunta2.setBackground(new java.awt.Color(72, 83, 93));
        jTextFieldPregunta2.setColumns(2);
        jTextFieldPregunta2.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextFieldPregunta2.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPregunta2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6));
        jTextFieldPregunta2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPregunta2.setOpaque(true);
        jPanelfondo.add(jTextFieldPregunta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 300, 20));

        jTextFieldPregunta3.setBackground(new java.awt.Color(72, 83, 93));
        jTextFieldPregunta3.setColumns(2);
        jTextFieldPregunta3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextFieldPregunta3.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPregunta3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6));
        jTextFieldPregunta3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPregunta3.setOpaque(true);
        jPanelfondo.add(jTextFieldPregunta3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 300, 20));

        jTextFieldPregunta4.setBackground(new java.awt.Color(72, 83, 93));
        jTextFieldPregunta4.setColumns(2);
        jTextFieldPregunta4.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jTextFieldPregunta4.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPregunta4.setAlignmentY(0.3F);
        jTextFieldPregunta4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6));
        jTextFieldPregunta4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldPregunta4.setOpaque(true);
        jPanelfondo.add(jTextFieldPregunta4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 300, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelfondo, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelfondo, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelPregunta;
    private javax.swing.JLabel jLabelPregunta1;
    private javax.swing.JLabel jLabelPregunta2;
    private javax.swing.JPanel jPanelfondo;
    private javax.swing.JTextField jTextFieldPregunta;
    private javax.swing.JTextField jTextFieldPregunta1;
    private javax.swing.JTextField jTextFieldPregunta2;
    private javax.swing.JTextField jTextFieldPregunta3;
    private javax.swing.JTextField jTextFieldPregunta4;
    // End of variables declaration//GEN-END:variables
}
