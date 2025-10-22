package com.julian.ejemploswing;

import javax.swing.*;
import java.awt.*;

/**
 * Ejemplo de BorderLayout: divide la ventana en 5 regiones.
 */
public class EjemploBorder extends JFrame {

    public EjemploBorder() {
        setTitle("Ejemplo BorderLayout");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panel.add(crearPanel("NORTE", Color.CYAN), BorderLayout.NORTH);
        panel.add(crearPanel("SUR", Color.PINK), BorderLayout.SOUTH);
        panel.add(crearPanel("OESTE", Color.ORANGE), BorderLayout.WEST);
        panel.add(crearPanel("ESTE", Color.MAGENTA), BorderLayout.EAST);
        panel.add(crearPanel("CENTRO", Color.LIGHT_GRAY), BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    private JPanel crearPanel(String texto, Color color) {
        JPanel p = new JPanel();
        p.setBackground(color);
        p.add(new JLabel(texto));
        return p;
    }
}