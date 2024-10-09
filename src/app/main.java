package app;

import api.Preguntas;
import api.utilityCSV;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import javax.swing.JScrollPane;

public class main extends javax.swing.JFrame {

    private ArrayList<Preguntas> listaPreguntas = new ArrayList<>(); // Crea una lista de objetos de tipo 'Preguntas'.
    private ArrayList<panelPregunta> listaPanelesPreguntas = new ArrayList<>(); // Lista que almacena instancias de panelPregunta, cada una representando un panel de preguntas en la interfaz.
    private int contadorPaneles = 0;// Variable para contar el número de paneles que se han agregado.
    public String rutaCSV = "src/api/datos.csv";// Ruta al archivo CSV que contiene los datos.

    public main() {

        initComponents();

        
        // Lee el archivo CSV y almacena las preguntas en la lista.
        utilityCSV.leerElArchivo(rutaCSV, listaPreguntas);
        System.out.println(listaPreguntas);

        // Recorre la lista de preguntas y actualiza los paneles en la interfaz según los datos del CSV.
        actualizarPanelesConWhile(listaPreguntas);

        // Establecer imagen y dimensiones del desplegable
        Dimension desplegableDimension = new Dimension(346, 40);
        utility.SetImageLabel(jLabelDesplegable, "src/app/InterfazMobile/Desplegable_On.png", desplegableDimension);

        // Establecer imagen y dimensiones de los botones
        Dimension buttonDimension = new Dimension(20, 20);
        utility.SetImageLabel(jLabelButtonInfo, "src/app/InterfazMobile/Info_Off.png", buttonDimension);
        utility.SetImageLabel(jLabelButtonAñadir, "src/app/InterfazMobile/Mas_Off.png", buttonDimension);

        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.getVerticalScrollBar().setUnitIncrement(20);

        // Añade un listener al botón de añadir para capturar eventos de clic.
        jLabelButtonAñadir.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                AgregarPanelPreguntas(listaPreguntas);// Agrega un nuevo panel de preguntas a la interfaz.
                System.out.println(contadorPaneles);
            }

        });

        
        // Añade un listener al botón jLabelButton para capturar eventos de clic.
        jLabelButton.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                
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
                    if (pregunta != null && respuestaCorrecta != null
                            && respuestaIncorrecta1 != null && respuestaIncorrecta2 != null
                            && respuestaIncorrecta3 != null) {
                        
                        // Crea un nuevo objeto Preguntas
                        Preguntas nuevaPregunta = new Preguntas(pregunta, respuestaCorrecta, respuestaIncorrecta1, respuestaIncorrecta2, respuestaIncorrecta3);

                        // Agrega la nueva pregunta a la lista
                        listaPreguntas.add(nuevaPregunta);
                        System.out.println("Nueva pregunta añadida: " + nuevaPregunta);
 
                    } else {
                        System.out.println("No se puede agregar una pregunta vacía.");
                    }
                }
                utilityCSV.crearYAnexarAArchivoCsv(rutaCSV, listaPreguntas);
                System.out.println(listaPreguntas);
                System.out.println(contadorPaneles);

            }

        }
        );

    }

    // Método para agregar un panel con preguntas que se encuentran el csv.
    public void actualizarPanelesConWhile(ArrayList<Preguntas> listaPreguntas) {
        int indice = 0;
        while (indice < listaPreguntas.size()) {
            
            panelPregunta nuevoPanel = new panelPregunta();
            nuevoPanel.padre = this;
            nuevoPanel.iniciar(indice, listaPreguntas);
            showPanel(nuevoPanel);
            listaPanelesPreguntas.add(nuevoPanel);
            indice++;
            contadorPaneles++;

        }
    }

    // Método para agregar un panel con preguntas a la interfaz.
    public void AgregarPanelPreguntas(ArrayList<Preguntas> lista) {

        contadorPaneles++;// Incrementa el contador de paneles.
        panelPregunta nuevoPanel = new panelPregunta();// Crea un nuevo panel de preguntas.
        nuevoPanel.padre = this;// Establece la referencia del padre (ventana principal).
        showPanel(nuevoPanel);// Muestra el nuevo panel en la interfaz.
        listaPanelesPreguntas.add(nuevoPanel);
        nuevoPanel.iniciar(contadorPaneles, lista);// Inicializa el panel con el número de panel y la lista de preguntas.

        // Muestra la lista de preguntas en la consola para verificar
        System.out.println("Preguntas actuales en la lista: " + lista);

    }

    private void showPanel(JPanel panelName) {

        panelName.setSize(344, 200);
        panelName.setLocation(0, 0);
        panelName.setVisible(true);

        jPanelListadoPreguntas.add(panelName);
        jPanelListadoPreguntas.revalidate();
        jPanelListadoPreguntas.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
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
        jScrollPane = new javax.swing.JScrollPane();
        jPanelListadoPreguntas = new javax.swing.JPanel();
        jPanelButton = new javax.swing.JPanel();
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
        jPanelDesplegable.add(jLabelTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 170, 50));

        jLabelDesplegable.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabelDesplegable.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDesplegable.setMaximumSize(new java.awt.Dimension(346, 40));
        jLabelDesplegable.setMinimumSize(new java.awt.Dimension(346, 40));
        jLabelDesplegable.setPreferredSize(new java.awt.Dimension(346, 40));
        jPanelDesplegable.add(jLabelDesplegable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 350, 50));

        jPanelPrincipal.add(jPanelDesplegable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 360, 50));

        jPanelAñadirUnaPregunta.setOpaque(false);
        jPanelAñadirUnaPregunta.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelAñadirUnaPregunta.setFont(new java.awt.Font("Raleway", 0, 14)); // NOI18N
        jLabelAñadirUnaPregunta.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAñadirUnaPregunta.setText("Añadir una pregunta");
        jPanelAñadirUnaPregunta.add(jLabelAñadirUnaPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jLabelButtonAñadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/InterfazMobile/Mas_Off.png"))); // NOI18N
        jLabelButtonAñadir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelButtonAñadir.setMaximumSize(new java.awt.Dimension(20, 20));
        jLabelButtonAñadir.setMinimumSize(new java.awt.Dimension(20, 20));
        jLabelButtonAñadir.setPreferredSize(new java.awt.Dimension(20, 20));
        jPanelAñadirUnaPregunta.add(jLabelButtonAñadir, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 20, 20));

        jLabelButtonInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/InterfazMobile/Info_Off.png"))); // NOI18N
        jLabelButtonInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelAñadirUnaPregunta.add(jLabelButtonInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 20, 20));

        jPanelPrincipal.add(jPanelAñadirUnaPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 360, -1));

        jScrollPane.setBackground(new java.awt.Color(255, 0, 255));
        jScrollPane.setBorder(null);

        jPanelListadoPreguntas.setBackground(new java.awt.Color(51, 255, 204));
        jPanelListadoPreguntas.setLayout(new javax.swing.BoxLayout(jPanelListadoPreguntas, javax.swing.BoxLayout.PAGE_AXIS));
        jScrollPane.setViewportView(jPanelListadoPreguntas);

        jPanelPrincipal.add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 350, 630));

        jPanelButton.setOpaque(false);
        jPanelButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelButtonText.setFont(new java.awt.Font("Raleway SemiBold", 0, 18)); // NOI18N
        jLabelButtonText.setForeground(new java.awt.Color(31, 45, 57));
        jLabelButtonText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButtonText.setText("Crear");
        jPanelButton.add(jLabelButtonText, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 16, 230, 60));

        jLabelButton.setBackground(new java.awt.Color(0, 0, 0));
        jLabelButton.setForeground(new java.awt.Color(0, 0, 0));
        jLabelButton.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/InterfazMobile/Boton_On.png"))); // NOI18N
        jPanelButton.add(jLabelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 240, 70));

        jPanelPrincipal.add(jPanelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 830, 430, 110));

        jLabelfondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/InterfazMobile/Fondo.png"))); // NOI18N
        jPanelPrincipal.add(jLabelfondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 940));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 932, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel jPanelDesplegable;
    private javax.swing.JPanel jPanelListadoPreguntas;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane;
    // End of variables declaration//GEN-END:variables
}
