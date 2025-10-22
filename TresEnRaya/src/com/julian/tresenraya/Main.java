package com.julian.tresenraya;

import javax.swing.SwingUtilities;

/**
 * Clase principal del programa.
 * Aquí es donde inicia la ejecución del juego.
 * 
 * El método main usa SwingUtilities.invokeLater para asegurar
 * que la interfaz gráfica (Swing) se cree correctamente en
 * el hilo de eventos de la interfaz.
 */
public class Main {
    public static void main(String[] args) {
        // Se lanza la ventana principal del menú.
        // Es la primera pantalla que ve el usuario.
        SwingUtilities.invokeLater(() -> new MainWindow());
    }
}