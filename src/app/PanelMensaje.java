package app;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class PanelMensaje extends javax.swing.JPanel {

    private Timer timer;
    private int tiempoRestante;
    private int tiempoTotal;
    
    public PanelMensaje(String mensaje, int time, Color color) {
        initComponents();
        
        jLabelMensaje.setText(mensaje);
        jLabelMensaje.setForeground(color);
        
        jProgressBar.setMinimum(0);
        jProgressBar.setMaximum(time * 1000);
        jProgressBar.setStringPainted(true);
        jProgressBar.setForeground(Color.WHITE);
        jProgressBar.setBackground(Color.BLACK);
        
        this.tiempoRestante = time * 1000;
        this.tiempoTotal = tiempoRestante;
        
        timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tiempoRestante -= 10;
                jProgressBar.setValue(tiempoTotal - tiempoRestante);
                
                if(tiempoRestante <= 0) {
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
        jProgressBar = new javax.swing.JProgressBar();

        setBackground(new java.awt.Color(5, 21, 37));
        setLayout(new java.awt.BorderLayout());

        jLabelMensaje.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelMensaje.setForeground(new java.awt.Color(255, 255, 255));
        jLabelMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelMensaje.setText("Pregunta añadida (actualmente 5)");
        add(jLabelMensaje, java.awt.BorderLayout.CENTER);

        jProgressBar.setBackground(new java.awt.Color(5, 21, 37));
        jProgressBar.setForeground(new java.awt.Color(0, 0, 0));
        jProgressBar.setBorder(null);
        jProgressBar.setPreferredSize(new java.awt.Dimension(146, 6));
        jProgressBar.setString("");
        add(jProgressBar, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelMensaje;
    private javax.swing.JProgressBar jProgressBar;
    // End of variables declaration//GEN-END:variables
}
