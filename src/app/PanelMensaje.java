package app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PanelMensaje extends javax.swing.JPanel {

    private Timer timer;
    private int tiempoRestante;
    private int tiempoTotal;

    private String mensaje;
    private int tiempo;
    private Color color;
    private int cantidad;

    public PanelMensaje(int numeroMensaje) {
        initComponents();

        switch (numeroMensaje) {
            case 1:
                mensaje = "No se encontró el archivo de preguntas";
                tiempo = 3;
                color = Color.RED;
                break;
            case 2:
                mensaje = "Error en la estructura del archivo de preguntas";
                tiempo = 3;
                color = Color.RED;
                break;
            case 3:
                mensaje = "Algunas preguntas están vacías";
                tiempo = 3;
                color = Color.RED;
                break;
            case 4:
                mensaje = "No se pudo crear el archivo de preguntas";
                tiempo = 3;
                color = Color.RED;
                break;
            case 5:
                mensaje = "Este simulador no tiene preguntas";
                tiempo = 2;
                color = Color.YELLOW;
                break;
            case 6:
                mensaje = "Las preguntas se guardaron pero no se pudo comprimir el simulador";
                tiempo = 2;
                color = Color.YELLOW;
                break;
            case 7:
                mensaje = "Las preguntas han sido cargadas con éxito ";
                tiempo = 2;
                color = Color.GREEN;
                break;
            default:
                mensaje = "Este caso no existe o requiere cantidad";
                break;
        }

        jLabelMensaje.setText(mensaje);
        jLabelMensaje.setForeground(color);

        jProgressBar.setMinimum(0);
        jProgressBar.setMaximum(tiempo * 1000);
        jProgressBar.setStringPainted(true);
        jProgressBar.setForeground(Color.WHITE);
        jProgressBar.setBackground(Color.BLACK);

        this.tiempoRestante = tiempo * 1000;
        this.tiempoTotal = tiempoRestante;

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempoRestante -= 10;
                jProgressBar.setValue(tiempoTotal - tiempoRestante);

                if (tiempoRestante <= 0) {
                    timer.stop();

                    setVisible(false);
                }
            }
        });
        timer.start();
    }

    public PanelMensaje(int numeroMensaje, int cantidad) {
        initComponents();
        
        switch (numeroMensaje) {
            case 8:
                mensaje = "Las preguntas han sido guardadas (" + cantidad + " en total)";
                tiempo = 2;
                color = Color.GREEN;
                break;
            case 9:
                mensaje = "Las preguntas se guardaron y se exportó el simulador en: X/X.zip";
                tiempo = 2;
                color = Color.GREEN;
                break;
            case 10:
                mensaje = "Pregunta añadida (actualmente " + cantidad + ")";
                tiempo = 2;
                color = Color.WHITE;
                break;
            case 11:
                mensaje = "Pregunta eliminada (quedan " + cantidad + ")";
                tiempo = 2;
                color = Color.WHITE;
                break;
            default:
                mensaje = "Este caso no existe o requiere cantidad";
                break;
        }
        
        jLabelMensaje.setText(mensaje);
        jLabelMensaje.setForeground(color);

        jProgressBar.setMinimum(0);
        jProgressBar.setMaximum(tiempo * 1000);
        jProgressBar.setStringPainted(true);
        jProgressBar.setForeground(Color.WHITE);

        this.tiempoRestante = tiempo * 1000;
        this.tiempoTotal = tiempoRestante;

        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempoRestante -= 10;
                jProgressBar.setValue(tiempoTotal - tiempoRestante);

                if (tiempoRestante <= 0) {
                    timer.stop();

                    setVisible(false);
                }
            }
        });
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelMensaje = new javax.swing.JLabel();
        jProgressBar = new app.CustomProgressBar();

        setBackground(new java.awt.Color(5, 21, 37));
        setLayout(new java.awt.BorderLayout());

        jLabelMensaje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMensaje.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensaje.setText("Pregunta añadida (actualmente 5)");
        add(jLabelMensaje, java.awt.BorderLayout.CENTER);

        jProgressBar.setForeground(new java.awt.Color(255, 255, 255));
        jProgressBar.setPreferredSize(new java.awt.Dimension(146, 8));
        add(jProgressBar, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelMensaje;
    private app.CustomProgressBar jProgressBar;
    // End of variables declaration//GEN-END:variables
}
