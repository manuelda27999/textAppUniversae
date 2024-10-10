package app;

import api.Preguntas;
import api.utilityCSV;
import java.awt.Dimension;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class main extends javax.swing.JFrame {

    private ArrayList<Preguntas> listaPreguntas = new ArrayList<>(); // Crea una lista de objetos de tipo 'Preguntas'.
    private ArrayList<panelPregunta> listaPanelesPreguntas = new ArrayList<>(); // Lista que almacena instancias de panelPregunta                                                                           
    private int contadorPaneles = listaPanelesPreguntas.size();
    public String rutaCSV = "src/api/datos.csv";// Ruta al archivo CSV que contiene los datos.
    private String rutaArchivo = "QuizDemo";
    private String rutaArchivoFinal = "NuevoQuizDemo.zip";

    Dimension buttonDimension = new Dimension(20, 20);

    public main() {
        initComponents();

        showMessage(7);

        //Funcionalidad de la barra de scroll
        jScrollPane.getVerticalScrollBar().addAdjustmentListener(new AdjustmentListener() {

            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {

                double heightScrollPane = jScrollPane.getHeight();
                double heightPanelListadoPreguntas = jPanelListadoPreguntas.getHeight();

                double porcentaje = heightScrollPane / heightPanelListadoPreguntas;

                double newHeight = heightScrollPane * porcentaje;
                double newY = e.getValue() * porcentaje;

                int altoScroll = jScrollPane.getHeight();
                roundedPanelBarritaScroll.setBounds(0, (int) newY, 10, (int) newHeight);
                roundedPanelBarritaScroll.revalidate();
                roundedPanelBarritaScroll.repaint();
            }
        });

        // Lee el archivo CSV y almacena las preguntas en la lista.
        utilityCSV.leerElArchivo(rutaCSV, listaPreguntas);
        System.out.println(listaPreguntas);

        
        // Recorre la lista de preguntas y actualiza los paneles en la interfaz según
        // los datos del CSV.
        actualizarPanelesConWhile(listaPreguntas);

        //Establecer imagen y dimensiones del desplegable
        Dimension desplegableDimension = new Dimension(340, 40);

        utility.SetImageLabel(jLabelDesplegable, "src/app/InterfazMobile/Desplegable_On.png", desplegableDimension);

        // Establecer imagen y dimensiones de los botones
        utility.SetImageLabel(jLabelButtonInfo, "src/app/InterfazMobile/Info_Off.png", buttonDimension);
        utility.SetImageLabel(jLabelButtonAñadir, "src/app/InterfazMobile/Mas_Off.png", buttonDimension);


        //Elimina la barra de scroll en el scrollPanel
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane.getVerticalScrollBar().setValue(0);

        // Añade un listener al botón de añadir para capturar eventos de clic.
        jLabelButtonAñadir.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
                int preguntasAñadidas = 0;
                
                
                AgregarPanelPreguntas(listaPreguntas);// Agrega un nuevo panel de preguntas a la interfaz.
                
                //Pregunta añadida (preguntasAñadidas++)
                //Las preguntas han sido guardadas (contadorPaneles.size())


            }

        });

        // Añade un listener al botón jLabelButton para capturar eventos de clic.
        jLabelButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                boolean todoCorrecto = true;

                // Limpiar la listaPreguntas para evitar duplicados al guardar
                listaPreguntas.clear();

                // Iterar a través de todos los paneles y capturar los datos
                for (panelPregunta panel : listaPanelesPreguntas) {

                    // Captura los datos del panel
                    String pregunta = panel.getPreguntaText(); // Obtiene la pregunta
                    
                    String respuestaCorrecta = panel.getRespuestaCorrectaText(); // Obtiene la respuesta correcta
                    
                    String respuestaIncorrecta1 = panel.getRespuestaIncorrecta1Text(); // Obtiene la primera respuesta incorrecta
                                                                                        
                    String respuestaIncorrecta2 = panel.getRespuestaIncorrecta2Text(); // Obtiene la segunda respuesta incorrecta
                                                                                       
                    String respuestaIncorrecta3 = panel.getRespuestaIncorrecta3Text(); // Obtiene la tercera respuesta incorrecta
                                                                                       


                    // Verifica que todos los campos tengan texto antes de crear una nueva pregunta
                    if (!pregunta.isEmpty() && !respuestaCorrecta.isEmpty() && !respuestaIncorrecta1.isEmpty()
                            && !respuestaIncorrecta2.isEmpty() && !respuestaIncorrecta3.isEmpty()) {

                        // Crea un nuevo objeto Preguntas
                        Preguntas nuevaPregunta = new Preguntas(pregunta, respuestaCorrecta, respuestaIncorrecta1,
                                respuestaIncorrecta2, respuestaIncorrecta3);

                        // Agrega la nueva pregunta a la lista
                        listaPreguntas.add(nuevaPregunta);

                    } else {
                        todoCorrecto = false;
                    }
                }

                if (todoCorrecto) {
                    utilityCSV.crearYAnexarAArchivoCsv(rutaCSV, listaPreguntas);
                    showMessage(8, listaPreguntas.size());
                } else {
                    showMessage(3);

                }

            }

            //Establecer dimensiones de los paneles de preguntas
            Dimension panelPreguntaDimension = new Dimension(350, 220);

        });
        
        
    }

    // Método para agregar un panel con preguntas que se encuentran el csv.
    public void actualizarPanelesConWhile(ArrayList<Preguntas> listaPreguntas) {
        int indice = 0;

        if (listaPreguntas.size() == 0) {
            showMessage(5);
        }

        while (indice < listaPreguntas.size()) {

            panelPregunta nuevoPanel = new panelPregunta();
            nuevoPanel.padre = this;
            nuevoPanel.iniciar(indice, listaPreguntas, listaPanelesPreguntas);
            nuevoPanel.setSize(344, 200);
            nuevoPanel.setLocation(0, 0);
            nuevoPanel.setVisible(true);

            jPanelListadoPreguntas.add(nuevoPanel);
            jScrollPane.getVerticalScrollBar().setValue(0);
            jPanelListadoPreguntas.revalidate();
            jPanelListadoPreguntas.repaint();
            listaPanelesPreguntas.add(nuevoPanel);
            indice++;
            contadorPaneles++;

            jScrollPane.revalidate();
            jScrollPane.repaint();

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    jScrollPane.getVerticalScrollBar().setValue(0);
                }
            });
        }
    }

    // Método para agregar un panel con preguntas a la interfaz.
    public void AgregarPanelPreguntas(ArrayList<Preguntas> lista) {

        contadorPaneles++;// Incrementa el contador de paneles.
        panelPregunta nuevoPanel = new panelPregunta("nuevo");// Crea un nuevo panel de preguntas.
        nuevoPanel.padre = this;// Establece la referencia del padre (ventana principal).
        nuevoPanel.setSize(344, 200);
        nuevoPanel.setLocation(0, 0);
        nuevoPanel.setVisible(true);

        jPanelListadoPreguntas.add(nuevoPanel, 0);
        jPanelListadoPreguntas.revalidate();
        jPanelListadoPreguntas.repaint();
        listaPanelesPreguntas.add(0, nuevoPanel);
        nuevoPanel.iniciar(contadorPaneles, lista, listaPanelesPreguntas);// Inicializa el panel con el número de panel y la lista de                                          

        // Muestra la lista de preguntas en la consola para verificar
        System.out.println("Preguntas actuales en la lista: " + lista);

        jScrollPane.getVerticalScrollBar().setValue(0);
        showMessage(10, listaPanelesPreguntas.size());
    }

    
    
    public void eliminarPanelPadre(panelPregunta panel) {

        // Elimina el panel del contenedor visual
        jPanelListadoPreguntas.remove(panel);

        // Elimina el panel de la lista.
        listaPanelesPreguntas.remove(panel);

        // Actualiza la vista
        jPanelListadoPreguntas.revalidate();
        jPanelListadoPreguntas.repaint();

        showMessage(11, listaPanelesPreguntas.size());
    }

    //Crea un panel de mensaje
    private void showMessage(int numeroMensaje) {
        PanelMensaje panelMensaje = new PanelMensaje(numeroMensaje);
        jPanelContainerMensaje.add(panelMensaje);
        jPanelContainerMensaje.revalidate();
        jPanelContainerMensaje.repaint();
    }

    private void showMessage(int numeroMensaje, int cantidad) {
        PanelMensaje panelMensaje = new PanelMensaje(numeroMensaje, cantidad);
        jPanelContainerMensaje.add(panelMensaje);
        jPanelContainerMensaje.revalidate();
        jPanelContainerMensaje.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelPrincipal = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelTipoSimulador = new javax.swing.JLabel();
        jPanelDesplegable = new javax.swing.JPanel();
        jLabelTexto = new javax.swing.JLabel();
        jLabelDesplegable = new javax.swing.JLabel();
        jPanelAñadirUnaPregunta = new javax.swing.JPanel();
        jLabelAñadirUnaPregunta = new javax.swing.JLabel();
        jLabelButtonAñadir = new javax.swing.JLabel();
        jLabelButtonInfo = new javax.swing.JLabel();
        roundedPanelContenedorBarritaScroll = new app.RoundedPanel();
        roundedPanelBarritaScroll = new app.RoundedPanel();
        jScrollPane = new javax.swing.JScrollPane();
        jPanelListadoPreguntas = new javax.swing.JPanel();
        jPanelButton = new javax.swing.JPanel();
        jPanelContainerMensaje = new javax.swing.JPanel();
        jLabelButtonText = new javax.swing.JLabel();
        jLabelButton = new javax.swing.JLabel();
        jLabelfondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelPrincipal.setMaximumSize(new java.awt.Dimension(430, 932));
        jPanelPrincipal.setMinimumSize(new java.awt.Dimension(430, 932));
        jPanelPrincipal.setName(""); // NOI18N
        jPanelPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitulo.setFont(new java.awt.Font("Raleway", 0, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Crea tu simulador teórico");
        jLabelTitulo.setMaximumSize(new java.awt.Dimension(370, 50));
        jLabelTitulo.setMinimumSize(new java.awt.Dimension(370, 50));
        jLabelTitulo.setPreferredSize(new java.awt.Dimension(370, 50));
        jPanelPrincipal.add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 330, 40));

        jLabelTipoSimulador.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabelTipoSimulador.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTipoSimulador.setText("Tipo de Simulador");
        jLabelTipoSimulador.setMaximumSize(new java.awt.Dimension(430, 30));
        jLabelTipoSimulador.setMinimumSize(new java.awt.Dimension(430, 30));
        jLabelTipoSimulador.setPreferredSize(new java.awt.Dimension(430, 30));
        jPanelPrincipal.add(jLabelTipoSimulador, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 140, -1));

        jPanelDesplegable.setOpaque(false);
        jPanelDesplegable.setPreferredSize(new java.awt.Dimension(380, 40));
        jPanelDesplegable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTexto.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabelTexto.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTexto.setText("Como ordeñar una vaca");
        jPanelDesplegable.add(jLabelTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 180, 50));

        jLabelDesplegable.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabelDesplegable.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesplegable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelDesplegable.setMaximumSize(new java.awt.Dimension(346, 40));
        jLabelDesplegable.setMinimumSize(new java.awt.Dimension(346, 40));
        jLabelDesplegable.setPreferredSize(new java.awt.Dimension(346, 40));
        jPanelDesplegable.add(jLabelDesplegable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 50));

        jPanelPrincipal.add(jPanelDesplegable, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 350, 50));

        jPanelAñadirUnaPregunta.setOpaque(false);
        jPanelAñadirUnaPregunta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelAñadirUnaPregunta.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabelAñadirUnaPregunta.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAñadirUnaPregunta.setText("Añadir una pregunta");
        jPanelAñadirUnaPregunta.add(jLabelAñadirUnaPregunta,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jLabelButtonAñadir
                .setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/InterfazMobile/Mas_Off.png"))); // NOI18N
        jLabelButtonAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonAñadir.setMaximumSize(new java.awt.Dimension(20, 20));
        jLabelButtonAñadir.setMinimumSize(new java.awt.Dimension(20, 20));
        jLabelButtonAñadir.setPreferredSize(new java.awt.Dimension(20, 20));
        jLabelButtonAñadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonAñadirMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonAñadirMouseExited(evt);
            }
        });
        jPanelAñadirUnaPregunta.add(jLabelButtonAñadir,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 20, 20));

        jLabelButtonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/InterfazMobile/Info_Off.png"))); // NOI18N
        jLabelButtonInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelButtonInfoMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelButtonInfoMouseExited(evt);
            }
        });
        jPanelAñadirUnaPregunta.add(jLabelButtonInfo,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 20, 20));

        jPanelPrincipal.add(jPanelAñadirUnaPregunta,
                new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 360, -1));

        roundedPanelContenedorBarritaScroll.setBackground(new java.awt.Color(73, 82, 92));
        roundedPanelContenedorBarritaScroll.setLayout(null);

        roundedPanelBarritaScroll.setBackground(new java.awt.Color(105, 254, 254));

        javax.swing.GroupLayout roundedPanelBarritaScrollLayout = new javax.swing.GroupLayout(roundedPanelBarritaScroll);
        roundedPanelBarritaScroll.setLayout(roundedPanelBarritaScrollLayout);
        roundedPanelBarritaScrollLayout.setHorizontalGroup(
            roundedPanelBarritaScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        roundedPanelBarritaScrollLayout.setVerticalGroup(
            roundedPanelBarritaScrollLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );

        roundedPanelContenedorBarritaScroll.add(roundedPanelBarritaScroll);
        roundedPanelBarritaScroll.setBounds(0, 0, 10, 70);

        jPanelPrincipal.add(roundedPanelContenedorBarritaScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 10, 630));

        jScrollPane.setBackground(new java.awt.Color(255, 0, 255));
        jScrollPane.setBorder(null);
        jScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jPanelListadoPreguntas.setBackground(new java.awt.Color(5, 21, 37));
        jPanelListadoPreguntas
                .setLayout(new javax.swing.BoxLayout(jPanelListadoPreguntas, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane.setViewportView(jPanelListadoPreguntas);

        jPanelPrincipal.add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 370, 630));

        jPanelButton.setOpaque(false);
        jPanelButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelContainerMensaje.setOpaque(false);
        jPanelContainerMensaje.setLayout(new java.awt.BorderLayout());
        jPanelButton.add(jPanelContainerMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 430, 40));

        jLabelButtonText.setFont(new java.awt.Font("Raleway SemiBold", 0, 18)); // NOI18N
        jLabelButtonText.setForeground(new java.awt.Color(31, 45, 57));
        jLabelButtonText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonText.setText("Crear");
        jLabelButtonText.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelButton.add(jLabelButtonText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 210, 50));

        jLabelButton.setBackground(new java.awt.Color(0, 0, 0));
        jLabelButton.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/InterfazMobile/Boton_On.png"))); // NOI18N
        jLabelButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelButton.add(jLabelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 210, 50));

        jPanelPrincipal.add(jPanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 830, 430, 110));

        jLabelfondo.setBackground(new java.awt.Color(73, 82, 92));
        jLabelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/InterfazMobile/Fondo.png"))); // NOI18N
        jPanelPrincipal.add(jLabelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 940));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING,
                                javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelButtonAñadirMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabelButtonAñadirMouseExited
        utility.SetImageLabel(jLabelButtonAñadir, "src/app/InterfazMobile/Mas_Off.png", buttonDimension);
    }// GEN-LAST:event_jLabelButtonAñadirMouseExited

    private void jLabelButtonAñadirMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabelButtonAñadirMouseEntered
        utility.SetImageLabel(jLabelButtonAñadir, "src/app/InterfazMobile/Mas_On.png", buttonDimension);
    }// GEN-LAST:event_jLabelButtonAñadirMouseEntered

    private void jLabelButtonInfoMouseEntered(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabelButtonInfoMouseEntered
        utility.SetImageLabel(jLabelButtonInfo, "src/app/InterfazMobile/Info_On.png", buttonDimension);
    }// GEN-LAST:event_jLabelButtonInfoMouseEntered

    private void jLabelButtonInfoMouseExited(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabelButtonInfoMouseExited
        utility.SetImageLabel(jLabelButtonInfo, "src/app/InterfazMobile/Info_Off.png", buttonDimension);
    }// GEN-LAST:event_jLabelButtonInfoMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelAñadirUnaPregunta;
    private javax.swing.JLabel jLabelButton;
    private javax.swing.JLabel jLabelButtonAñadir;
    private javax.swing.JLabel jLabelButtonInfo;
    private javax.swing.JLabel jLabelButtonText;
    private javax.swing.JLabel jLabelDesplegable;
    private javax.swing.JLabel jLabelTexto;
    private javax.swing.JLabel jLabelTipoSimulador;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelfondo;
    private javax.swing.JPanel jPanelAñadirUnaPregunta;
    private javax.swing.JPanel jPanelButton;
    private javax.swing.JPanel jPanelContainerMensaje;
    private javax.swing.JPanel jPanelDesplegable;
    private javax.swing.JPanel jPanelListadoPreguntas;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane;
    private app.RoundedPanel roundedPanelBarritaScroll;
    private app.RoundedPanel roundedPanelContenedorBarritaScroll;
    // End of variables declaration//GEN-END:variables
}
