/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JProgressBar;

/**
 *
 * @author ManuelDa
 */
public class CustomProgressBar extends JProgressBar{
    
    public CustomProgressBar(){
            super();
            setStringPainted(true);
        }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Color color = new Color(5, 21, 37);
        g.setColor(color);
        int width = (int) (getWidth() * ((double) getValue()/ getMaximum()));
        g.fillRect(0, 0, width, getHeight());
    }
}
