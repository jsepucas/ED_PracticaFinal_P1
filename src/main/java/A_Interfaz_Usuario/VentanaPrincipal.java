package A_Interfaz_Usuario;

import javax.swing.*;
import java.awt.*;
public class VentanaPrincipal extends JFrame {
    public VentanaPrincipal() {
        setTitle("Sistema de Gestión de Experimentos");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI();
    }

    private void initUI() {
        // Menú principal
        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemNuevo = new JMenuItem("Nuevo Experimento");
        JMenuItem itemAbrir = new JMenuItem("Abrir Experimento");
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemSalir = new JMenuItem("Salir");