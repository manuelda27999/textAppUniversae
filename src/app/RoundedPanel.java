/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author ManuelDa
 */
public class RoundedPanel extends JPanel{
    private int radius; // Radio para las esquinas redondas

    public RoundedPanel(int radius) {
        this.radius = radius;
        setOpaque(false); // Hacer el panel transparente
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        // Dibujar el fondo con esquinas redondeadas
        g2d.setColor(getBackground());
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), radius, radius));
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        repaint(); // Redibujar al cambiar el color de fondo
    }

}
