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

        itemSalir.addActionListener(e -> System.exit(0));
        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemGuardar);
        menuArchivo.add(new JSeparator());
        menuArchivo.add(itemSalir);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        // Panel de visualización (Aquí podrías añadir pestañas o paneles según necesidad)
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        JLabel labelBienvenida = new JLabel("Bienvenido al Sistema de Gestión de Experimentos", SwingConstants.CENTER);
        panelCentral.add(labelBienvenida, BorderLayout.CENTER);
        add(panelCentral);
    }
}