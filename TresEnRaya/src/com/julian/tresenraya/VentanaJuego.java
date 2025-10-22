package com.julian.tresenraya;

import javax.swing.*;
import java.awt.*;

/**
 * Ventana del juego con disposición visual ajustable:
 * - Tablero en la derecha.
 * - Panel lateral con información o botones en la izquierda.
 */
public class VentanaJuego extends JFrame {

    private JButton[] casillas = new JButton[9];

    public VentanaJuego() {
        setTitle("Tres en Raya — Juego");
        setSize(800, 500); // 🔹 Tamaño más amplio para acomodar dos secciones
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true); // ✅ Puedes hacerlo redimensionable si lo prefieres

        // --- PANEL PRINCIPAL ---
        // Usamos un BorderLayout general (nos deja dividir en zonas)
        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(245, 245, 245));

        // --- TÍTULO EN LA PARTE SUPERIOR ---
        JLabel titulo = new JLabel("¡Comienza el juego!", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(new Color(60, 60, 90));
        titulo.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Margen superior/inferior
        panelPrincipal.add(titulo, BorderLayout.NORTH);

        // --- PANEL CENTRAL (dividido en 2 columnas) ---
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1, 2, 10, 0)); // 1 fila, 2 columnas, espacio horizontal de 10px
        panelCentral.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelCentral.setBackground(panelPrincipal.getBackground());

        // --- PANEL IZQUIERDO (información, botones, marcador, etc.) ---
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BorderLayout());
        panelInfo.setBackground(new Color(220, 230, 255)); // Azul muy suave

        JLabel infoLabel = new JLabel("<html><center>Panel de Información<br><br>" +
                "Aquí puedes mostrar:<br>" +
                "- Turno actual<br>" +
                "- Puntuación<br>" +
                "- Tiempo<br>" +
                "- Botón de reinicio</center></html>", SwingConstants.CENTER);
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        infoLabel.setForeground(new Color(40, 40, 80));
        panelInfo.add(infoLabel, BorderLayout.CENTER);

        // --- TABLERO A LA DERECHA ---
        JPanel tablero = new JPanel(new GridLayout(3, 3, 5, 5));
        tablero.setBackground(Color.DARK_GRAY);
        tablero.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // 🔹 Aquí puedes cambiar el tamaño del tablero relativo:
        // - Si lo quieres más pequeño, usa setPreferredSize().
        tablero.setPreferredSize(new Dimension(350, 350));

        for (int i = 0; i < 9; i++) {
            JButton casilla = new JButton("");
            casilla.setFont(new Font("Arial", Font.BOLD, 48));
            casilla.setFocusPainted(false);
            casilla.setBackground(Color.WHITE);
            casilla.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            tablero.add(casilla);
            casillas[i] = casilla;
        }

        // --- AGREGA PANEL INFO Y TABLERO AL PANEL CENTRAL ---
        panelCentral.add(panelInfo); // Izquierda
        panelCentral.add(tablero); // Derecha

        // --- AGREGA TODO AL PANEL PRINCIPAL ---
        panelPrincipal.add(panelCentral, BorderLayout.CENTER);
        add(panelPrincipal);

        setVisible(true);
    }
}