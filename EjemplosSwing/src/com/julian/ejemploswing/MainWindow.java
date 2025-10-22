package com.julian.ejemploswing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ventana principal del proyecto EjemplosSwing.
 * Demuestra cómo capturar qué botón fue presionado mediante el parámetro 'e'.
 */
public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Ejemplos Swing — Menú Principal");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // --- PANEL PRINCIPAL ---
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(240, 240, 255));

        // --- TÍTULO ---
        JLabel titulo = new JLabel("Ejemplos Swing", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 26));
        titulo.setForeground(new Color(60, 60, 100));
        panel.add(titulo, BorderLayout.NORTH);

        // --- PANEL DE BOTONES ---
        JPanel botonesPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        botonesPanel.setBorder(BorderFactory.createEmptyBorder(40, 80, 40, 80));

        JButton botonGrid = new JButton("Ejemplo GridLayout");
        JButton botonBorder = new JButton("Ejemplo BorderLayout");
        JButton botonSalir = new JButton("Salir");

        JButton[] botones = { botonGrid, botonBorder, botonSalir };
        for (JButton b : botones) {
            b.setFont(new Font("Arial", Font.BOLD, 16));
            b.setFocusPainted(false);
            b.setBackground(new Color(100, 140, 220));
            b.setForeground(Color.WHITE);
        }

        botonesPanel.add(botonGrid);
        botonesPanel.add(botonBorder);
        botonesPanel.add(botonSalir);
        panel.add(botonesPanel, BorderLayout.CENTER);
        add(panel);

        // =====================================================
        // 🧠 USO DEL PARÁMETRO 'e' EN ActionListener
        // =====================================================
        ActionListener listener = e -> {
            // El parámetro 'e' contiene información sobre el evento
            // Como qué componente lo generó, hora, tipo de acción, etc.
            JButton source = (JButton) e.getSource(); // El botón que se presionó
            String texto = source.getText(); // Texto del botón

            // Mostrar mensaje en consola
            System.out.println("Botón presionado: " + texto);

            // O mostrarlo en una ventana emergente
            JOptionPane.showMessageDialog(this,
                    "Has presionado el botón: " + texto,
                    "Evento detectado", JOptionPane.INFORMATION_MESSAGE);

            // Abrir la ventana correspondiente
            switch (texto) {
                case "Ejemplo GridLayout" -> {
                    dispose();
                    new EjemploGrid();
                }
                case "Ejemplo BorderLayout" -> {
                    dispose();
                    new EjemploBorder();
                }
                case "Salir" -> System.exit(0);
            }
        };

        // Asignar el mismo ActionListener a todos los botones
        botonGrid.addActionListener(listener);
        botonBorder.addActionListener(listener);
        botonSalir.addActionListener(listener);

        setVisible(true);
    }
}