package app;

import api.Preguntas;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

public class panelPregunta extends javax.swing.JPanel {

    public main padre;

    Dimension botonEliminarDimension = new Dimension(14, 14);

    public panelPregunta() {
        initComponents();

        utility.SetImageLabel(jLabelBotonEliminar, "src/app/InterfazMobile/Menos_Off.png", botonEliminarDimension);
    }

    public panelPregunta(String nuevo) {
        initComponents();

        jTextAreaPregunta.setEditable(true);
        jTextFieldRespuestaCorrecta.setEditable(true);
        jTextFieldRespuestaIncorrecta1.setEditable(true);
        jTextFieldRespuestaIncorrecta2.setEditable(true);
        jTextFieldRespuestaIncorrecta3.setEditable(true);

        utility.SetImageLabel(jLabelBotonEliminar, "src/app/InterfazMobile/Menos_Off.png", botonEliminarDimension);
    }

    public void iniciar(int index, ArrayList<Preguntas> lista, ArrayList<panelPregunta> listaPaneles) {

        if (index < lista.size()) {

            String pregunta = lista.get(index).getPregunta();
            String respuestaCorrecta = lista.get(index).getRespuestaCorrecta();
            String respuestaIncorrecta1 = lista.get(index).getRespuestaIncorrecta1();
            String respuestaIncorrecta2 = lista.get(index).getRespuestaIncorrecta2();
            String respuestaIncorrecta3 = lista.get(index).getRespuestaIncorrecta3();

            jTextAreaPregunta.setText(pregunta);
            jTextFieldRespuestaCorrecta.setText(respuestaCorrecta);
            jTextFieldRespuestaIncorrecta1.setText(respuestaIncorrecta1);
            jTextFieldRespuestaIncorrecta2.setText(respuestaIncorrecta2);
            jTextFieldRespuestaIncorrecta3.setText(respuestaIncorrecta3);

            System.out.println(jTextAreaPregunta.getText().length());

            if (jTextAreaPregunta.getText().length() < 50) {
                EmptyBorder borde = new EmptyBorder(11, 3, 11, 3);
                jTextAreaPregunta.setBorder(borde);
            }
        }

        jLabelBotonEliminar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                eliminarPanel();

            }
        });
    }

    // Eliminar el panel del contenedor padre
    private void eliminarPanel() {
        this.padre.eliminarPanel(this);
    }

    // Métodos para obtener los textos de los JTextField
    public String getPreguntaText() {
        return jTextAreaPregunta.getText();
    }

    public String getRespuestaCorrectaText() {
        return jTextFieldRespuestaCorrecta.getText();
    }

    public String getRespuestaIncorrecta1Text() {
        return jTextFieldRespuestaIncorrecta1.getText();
    }

    public String getRespuestaIncorrecta2Text() {
        return jTextFieldRespuestaIncorrecta2.getText();
    }

    public String getRespuestaIncorrecta3Text() {
        return jTextFieldRespuestaIncorrecta3.getText();
    }
    // Establezco las dimensiones e imagen del botón de eliminar

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelFondo = new javax.swing.JPanel();
        roundedPanel1 = new app.RoundedPanel();
        jLabelPregunta = new javax.swing.JLabel();
        roundedPanelPregunta = new app.RoundedPanel();
        jTextAreaPregunta = new javax.swing.JTextArea();
        jLabelRespuestaCorrecta = new javax.swing.JLabel();
        roundedPanelRespuestaCorrecta = new app.RoundedPanel();
        jTextFieldRespuestaCorrecta = new javax.swing.JTextField();
        jLabelRespuestasIncorrectas = new javax.swing.JLabel();
        jPanelPreguntasIncorrectas = new javax.swing.JPanel();
        roundedPanelRespuestaIncorrecta1 = new app.RoundedPanel();
        jTextFieldRespuestaIncorrecta1 = new javax.swing.JTextField();
        roundedPanelRespuestaIncorrecta2 = new app.RoundedPanel();
        jTextFieldRespuestaIncorrecta2 = new javax.swing.JTextField();
        roundedPanelRespuestaIncorrecta3 = new app.RoundedPanel();
        jTextFieldRespuestaIncorrecta3 = new javax.swing.JTextField();
        jLabelBotonEliminar = new javax.swing.JLabel();

        jPanelFondo.setBackground(new java.awt.Color(4, 19, 37));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel1.setBackground(new java.awt.Color(26, 40, 55));
        roundedPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelPregunta.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPregunta.setText("Pregunta");
        roundedPanel1.add(jLabelPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 160, 20));

        roundedPanelPregunta.setBackground(new java.awt.Color(72, 82, 93));
        roundedPanelPregunta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextAreaPregunta.setEditable(false);
        jTextAreaPregunta.setBackground(new java.awt.Color(73, 83, 92));
        jTextAreaPregunta.setColumns(3);
        jTextAreaPregunta.setForeground(new java.awt.Color(255, 255, 255));
        jTextAreaPregunta.setLineWrap(true);
        jTextAreaPregunta.setRows(2);
        jTextAreaPregunta.setWrapStyleWord(true);
        jTextAreaPregunta.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 6, 3, 6));
        jTextAreaPregunta.setOpaque(false);
        jTextAreaPregunta.setPreferredSize(new java.awt.Dimension(125, 125));
        roundedPanelPregunta.add(jTextAreaPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 40));

        roundedPanel1.add(roundedPanelPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 310, 40));

        jLabelRespuestaCorrecta.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRespuestaCorrecta.setText("Respuesta correcta");
        roundedPanel1.add(jLabelRespuestaCorrecta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 160, 20));

        roundedPanelRespuestaCorrecta.setBackground(new java.awt.Color(72, 82, 93));
        roundedPanelRespuestaCorrecta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldRespuestaCorrecta.setEditable(false);
        jTextFieldRespuestaCorrecta.setBackground(new java.awt.Color(72, 83, 93));
        jTextFieldRespuestaCorrecta.setColumns(2);
        jTextFieldRespuestaCorrecta.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldRespuestaCorrecta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6));
        jTextFieldRespuestaCorrecta.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldRespuestaCorrecta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRespuestaCorrectaActionPerformed(evt);
            }
        });
        roundedPanelRespuestaCorrecta.add(jTextFieldRespuestaCorrecta,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 20));

        roundedPanel1.add(roundedPanelRespuestaCorrecta,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 310, 20));

        jLabelRespuestasIncorrectas.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRespuestasIncorrectas.setText("Respuesta incorrecta");
        roundedPanel1.add(jLabelRespuestasIncorrectas,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 160, 20));

        jPanelPreguntasIncorrectas.setOpaque(false);
        jPanelPreguntasIncorrectas.setLayout(new java.awt.GridBagLayout());

        roundedPanelRespuestaIncorrecta1.setBackground(new java.awt.Color(72, 82, 93));
        roundedPanelRespuestaIncorrecta1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldRespuestaIncorrecta1.setEditable(false);
        jTextFieldRespuestaIncorrecta1.setBackground(new java.awt.Color(72, 83, 93));
        jTextFieldRespuestaIncorrecta1.setColumns(2);
        jTextFieldRespuestaIncorrecta1.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldRespuestaIncorrecta1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6));
        jTextFieldRespuestaIncorrecta1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldRespuestaIncorrecta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRespuestaIncorrecta1ActionPerformed(evt);
            }
        });
        roundedPanelRespuestaIncorrecta1.add(jTextFieldRespuestaIncorrecta1,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 20));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanelPreguntasIncorrectas.add(roundedPanelRespuestaIncorrecta1, gridBagConstraints);

        roundedPanelRespuestaIncorrecta2.setBackground(new java.awt.Color(72, 82, 93));
        roundedPanelRespuestaIncorrecta2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldRespuestaIncorrecta2.setEditable(false);
        jTextFieldRespuestaIncorrecta2.setBackground(new java.awt.Color(72, 83, 93));
        jTextFieldRespuestaIncorrecta2.setColumns(2);
        jTextFieldRespuestaIncorrecta2.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldRespuestaIncorrecta2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6));
        jTextFieldRespuestaIncorrecta2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldRespuestaIncorrecta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRespuestaIncorrecta2ActionPerformed(evt);
            }
        });
        roundedPanelRespuestaIncorrecta2.add(jTextFieldRespuestaIncorrecta2,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 20));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 0);
        jPanelPreguntasIncorrectas.add(roundedPanelRespuestaIncorrecta2, gridBagConstraints);

        roundedPanelRespuestaIncorrecta3.setBackground(new java.awt.Color(72, 82, 93));
        roundedPanelRespuestaIncorrecta3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldRespuestaIncorrecta3.setEditable(false);
        jTextFieldRespuestaIncorrecta3.setBackground(new java.awt.Color(72, 83, 93));
        jTextFieldRespuestaIncorrecta3.setColumns(2);
        jTextFieldRespuestaIncorrecta3.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldRespuestaIncorrecta3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 6, 0, 6));
        jTextFieldRespuestaIncorrecta3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextFieldRespuestaIncorrecta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRespuestaIncorrecta3ActionPerformed(evt);
            }
        });
        roundedPanelRespuestaIncorrecta3.add(jTextFieldRespuestaIncorrecta3,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 20));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanelPreguntasIncorrectas.add(roundedPanelRespuestaIncorrecta3, gridBagConstraints);

        roundedPanel1.add(jPanelPreguntasIncorrectas,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 310, 70));

        jLabelBotonEliminar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBotonEliminar
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/InterfazMobile/Menos_Off.png"))); // NOI18N
        jLabelBotonEliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 1, 1, 3));
        jLabelBotonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelBotonEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelBotonEliminarMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelBotonEliminarMouseExited(evt);
            }
        });
        roundedPanel1.add(jLabelBotonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 20, 20));

        jPanelFondo.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelFondo, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldRespuestaCorrectaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldRespuestaCorrectaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldRespuestaCorrectaActionPerformed

    private void jTextFieldRespuestaIncorrecta1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldRespuestaIncorrecta1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldRespuestaIncorrecta1ActionPerformed

    private void jTextFieldRespuestaIncorrecta2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldRespuestaIncorrecta2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldRespuestaIncorrecta2ActionPerformed

    private void jTextFieldRespuestaIncorrecta3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldRespuestaIncorrecta3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldRespuestaIncorrecta3ActionPerformed

    private void jLabelBotonEliminarMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabelBotonEliminarMouseEntered
        utility.SetImageLabel(jLabelBotonEliminar, "src/app/InterfazMobile/Menos_On.png", botonEliminarDimension);
    }// GEN-LAST:event_jLabelBotonEliminarMouseEntered

    private void jLabelBotonEliminarMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabelBotonEliminarMouseExited
        utility.SetImageLabel(jLabelBotonEliminar, "src/app/InterfazMobile/Menos_Off.png", botonEliminarDimension);
    }// GEN-LAST:event_jLabelBotonEliminarMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelBotonEliminar;
    private javax.swing.JLabel jLabelPregunta;
    private javax.swing.JLabel jLabelRespuestaCorrecta;
    private javax.swing.JLabel jLabelRespuestasIncorrectas;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelPreguntasIncorrectas;
    private javax.swing.JTextArea jTextAreaPregunta;
    private javax.swing.JTextField jTextFieldRespuestaCorrecta;
    private javax.swing.JTextField jTextFieldRespuestaIncorrecta1;
    private javax.swing.JTextField jTextFieldRespuestaIncorrecta2;
    private javax.swing.JTextField jTextFieldRespuestaIncorrecta3;
    private app.RoundedPanel roundedPanel1;
    private app.RoundedPanel roundedPanelPregunta;
    private app.RoundedPanel roundedPanelRespuestaCorrecta;
    private app.RoundedPanel roundedPanelRespuestaIncorrecta1;
    private app.RoundedPanel roundedPanelRespuestaIncorrecta2;
    private app.RoundedPanel roundedPanelRespuestaIncorrecta3;
    // End of variables declaration//GEN-END:variables
}
