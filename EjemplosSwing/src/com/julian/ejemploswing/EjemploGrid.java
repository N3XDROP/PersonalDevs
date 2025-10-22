package com.julian.ejemploswing;

import javax.swing.*;
import java.awt.*;

/**
 * Ejemplo de GridLayout (2 filas, 2 columnas),
 * donde la última fila tiene un panel que ocupa el ancho completo.
 */
public class EjemploGrid extends JFrame {

    public EjemploGrid() {
        setTitle("Ejemplo GridLayout — 2x2 Combinado");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal (2 filas)
        JPanel panelPrincipal = new JPanel(new GridLayout(2, 1, 10, 10));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelPrincipal.setBackground(new Color(245, 245, 255));

        // Fila superior (2 columnas)
        JPanel filaSuperior = new JPanel(new GridLayout(1, 2, 10, 0));
        JPanel panelA = crearPanel("Panel A", Color.CYAN);
        JPanel panelB = crearPanel("Panel B", Color.ORANGE);
        filaSuperior.add(panelA);
        filaSuperior.add(panelB);

        // Fila inferior (1 panel ancho completo)
        JPanel panelC = crearPanel("Panel C (ocupa todo el ancho)", Color.LIGHT_GRAY);

        panelPrincipal.add(filaSuperior);
        panelPrincipal.add(panelC);

        add(panelPrincipal);
        setVisible(true);
    }

    private JPanel crearPanel(String texto, Color color) {
        JPanel p = new JPanel();
        p.setBackground(color);
        p.add(new JLabel(texto, SwingConstants.CENTER));
        return p;
    }
}