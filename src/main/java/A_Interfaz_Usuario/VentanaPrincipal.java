package A_Interfaz_Usuario;

import B_Gestion_Datos.AdministradorDatos;
import B_Gestion_Datos.Experimento;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class VentanaPrincipal extends JFrame {
    private Experimento experimentoActual; // Mantiene el experimento actual
    private JLabel labelBienvenida;

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

        itemNuevo.addActionListener(e -> crearNuevoExperimento());
        itemAbrir.addActionListener(e -> abrirExperimento());
        itemGuardar.addActionListener(e -> guardarExperimento());
        itemSalir.addActionListener(e -> System.exit(0));

        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemGuardar);
        menuArchivo.add(new JSeparator());
        menuArchivo.add(itemSalir);
        menuBar.add(menuArchivo);
        setJMenuBar(menuBar);

        // Panel de visualización
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        labelBienvenida = new JLabel("Bienvenido al Sistema de Gestión de Experimentos de la UAX", SwingConstants.CENTER);
        panelCentral.add(labelBienvenida, BorderLayout.CENTER);
        add(panelCentral);
    }

    public void setExperimentoActual(Experimento experimento) {
        this.experimentoActual = experimento;
        actualizarUI();
    }

    private void actualizarUI() {
        if (experimentoActual != null) {
            labelBienvenida.setText("Experimento cargado: " + experimentoActual.getNombre());
        } else {
            labelBienvenida.setText("Bienvenido al Sistema de Gestión de Experimentos de la UAX");
        }
    }

    private void crearNuevoExperimento() {
        DialogoCrearExperimento dialogo = new DialogoCrearExperimento(this);
        dialogo.setVisible(true);
    }

    private void abrirExperimento() {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File seleccionado = fileChooser.getSelectedFile();
            try {
                experimentoActual = AdministradorDatos.abrirExperimento(seleccionado);
                actualizarUI();
            } catch (IOException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Error al abrir el archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void guardarExperimento() {
        if (experimentoActual != null) {
            JFileChooser fileChooser = new JFileChooser();
            int resultado = fileChooser.showSaveDialog(this);
            if (resultado == JFileChooser.APPROVE_OPTION) {
                File seleccionado = fileChooser.getSelectedFile();
                try {
                    AdministradorDatos.guardarExperimento(experimentoActual, seleccionado);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay experimento para guardar", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }
}
