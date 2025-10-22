package com.julian.tresenraya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Ventana inicial del programa (menú principal).
 * Desde aquí el usuario puede elegir:
 * - Jugar (abre el tablero)
 * - Ver instrucciones
 * - Salir del programa
 */
public class MainWindow extends JFrame {

    public MainWindow() {
        // --- CONFIGURACIÓN BÁSICA DE LA VENTANA ---
        setTitle("Menú Principal — Tres en Raya"); // Título de la ventana
        setSize(400, 400); // Tamaño inicial (ancho x alto)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra el programa al salir
        setLocationRelativeTo(null); // Centra la ventana en pantalla
        setResizable(false); // ❌ No permite ampliar el tamaño

        // --- PANEL PRINCIPAL ---
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout()); // Divide en norte, centro, sur, etc.
        panel.setBackground(new Color(240, 240, 255)); // Color de fondo (azul muy claro)

        // --- TÍTULO ---
        JLabel titulo = new JLabel("TRES EN RAYA", SwingConstants.CENTER); // Texto centrado
        titulo.setFont(new Font("Arial", Font.BOLD, 28)); // Fuente grande y negrita
        titulo.setForeground(new Color(50, 50, 100)); // Color del texto (azul oscuro)
        panel.add(titulo, BorderLayout.NORTH); // Lo coloca en la parte superior

        // --- PANEL CENTRAL DE BOTONES ---
        JPanel botonesPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        // GridLayout(3,1,10,10) → 3 filas, 1 columna, separación de 10 px
        botonesPanel.setBackground(panel.getBackground());
        botonesPanel.setBorder(BorderFactory.createEmptyBorder(50, 80, 50, 80));
        // Margen interno para centrar los botones dentro del panel

        // --- CREACIÓN DE LOS BOTONES ---
        JButton botonJugar = new JButton("JUGAR");
        JButton botonInstrucciones = new JButton("INSTRUCCIONES");
        JButton botonSalir = new JButton("SALIR");

        // Aplica el mismo estilo visual a los tres botones
        JButton[] botones = { botonJugar, botonInstrucciones, botonSalir };
        for (JButton b : botones) {
            b.setFont(new Font("Arial", Font.BOLD, 16)); // Fuente y tamaño del texto
            b.setFocusPainted(false); // Quita el borde azul del enfoque
            b.setBackground(new Color(80, 120, 200)); // Fondo azul medio
            b.setForeground(Color.WHITE); // Texto blanco
            b.setBorder(BorderFactory.createLineBorder(new Color(60, 90, 150), 2));
        }

        // Se agregan los botones al panel en orden
        botonesPanel.add(botonJugar);
        botonesPanel.add(botonInstrucciones);
        botonesPanel.add(botonSalir);

        // Inserta el panel de botones en el centro de la ventana
        panel.add(botonesPanel, BorderLayout.CENTER);

        // Añade el panel principal a la ventana
        add(panel);

        // --- EVENTOS DE LOS BOTONES ---

        // Al presionar “JUGAR”, se cierra esta ventana y se abre la del juego
        botonJugar.addActionListener(e -> {
            dispose(); // Cierra esta ventana (sin terminar el programa)
            new VentanaJuego(); // Abre el tablero del juego
        });

        // Al presionar “INSTRUCCIONES”, muestra un cuadro de texto con las reglas
        botonInstrucciones.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "El juego consiste en alinear tres símbolos iguales (X o O).\n" +
                            "Cada jugador elige una casilla por turno.\n" +
                            "Gana quien logre alinear tres en línea.",
                    "Instrucciones",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        // Al presionar “SALIR”, cierra todo el programa
        botonSalir.addActionListener(e -> System.exit(0));

        // Hace visible la ventana
        setVisible(true);
    }
}