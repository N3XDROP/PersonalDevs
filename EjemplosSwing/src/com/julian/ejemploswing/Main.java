package com.julian.ejemploswing;

import javax.swing.SwingUtilities;

/**
 * Punto de entrada del programa.
 * Muestra la ventana principal del menú de ejemplos.
 */
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainWindow());
    }
}