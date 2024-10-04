/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author ManuelDa
 */
public class utility {
    public static void SetImageLabel(JLabel labelName, String root, Dimension dimension) {
        ImageIcon image = new ImageIcon(root);
        Icon icon;

        icon = new ImageIcon(image.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_DEFAULT));

        labelName.setIcon(icon);

        labelName.repaint();
    };
}
