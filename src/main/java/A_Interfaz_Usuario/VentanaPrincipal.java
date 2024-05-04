package A_Interfaz_Usuario;

import B_Gestion_Datos.AdministradorDatos;
import B_Gestion_Datos.Experimento;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.URL;

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
        JMenu menuIcono = new JMenu();
        URL imageUrl = getClass().getResource("/images/icono.png");
        if (imageUrl != null) {
            ImageIcon imageIcon = new ImageIcon(new ImageIcon(imageUrl).getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
            menuIcono.setIcon(imageIcon);
        } else {
            System.out.println("Image not found");
        }

        JMenuItem itemArchivo = new JMenuItem("Archivo");
        JMenuItem itemNuevo = new JMenuItem("Nuevo Experimento");
        JMenuItem itemAbrir = new JMenuItem("Abrir Experimento");
        JMenuItem itemGuardar = new JMenuItem("Guardar");
        JMenuItem itemSalir = new JMenuItem("Salir");
        JMenuItem itemEditar = new JMenuItem("Editar Experimento");
        JMenuItem itemEliminar = new JMenuItem("Eliminar Experimento");

        itemNuevo.addActionListener(e -> crearNuevoExperimento());
        itemAbrir.addActionListener(e -> abrirExperimento());
        itemGuardar.addActionListener(e -> guardarExperimento());
        itemSalir.addActionListener(e -> System.exit(0));
        itemEditar.addActionListener(e -> editarExperimento());
        itemEliminar.addActionListener(e -> eliminarExperimento());

        menuIcono.add(itemArchivo);
        menuIcono.add(itemNuevo);
        menuIcono.add(itemAbrir);
        menuIcono.add(itemGuardar);
        menuIcono.add(itemEditar);
        menuIcono.add(itemEliminar);
        menuIcono.add(new JSeparator());
        menuIcono.add(itemSalir);

        menuBar.add(menuIcono);

        // Agregar el JMenu al menuBar
        setJMenuBar(menuBar);

        // Panel de visualización
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new BorderLayout());
        labelBienvenida = new JLabel("Bienvenido al Sistema de Gestión de Experimentos de la UAX", SwingConstants.CENTER);
        panelCentral.add(labelBienvenida, BorderLayout.CENTER);
        add(panelCentral);
    }

    private void crearNuevoExperimento() {
        DialogoCrearExperimento dialogo = new DialogoCrearExperimento(this, null);
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

    private void eliminarExperimento() {
        if (experimentoActual != null) {
            int confirm = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas eliminar este experimento?", "Eliminar Experimento", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                experimentoActual = null;
                actualizarUI();
            }
        } else {
            JOptionPane.showMessageDialog(this, "No hay experimento seleccionado para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarExperimento() {
        if (experimentoActual != null) {
            DialogoCrearExperimento dialogo = new DialogoCrearExperimento(this, experimentoActual);
            dialogo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "No hay experimento seleccionado para editar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarUI() {
        if (experimentoActual != null) {
            labelBienvenida.setText("Experimento cargado: " + experimentoActual.getNombre());
        } else {
            labelBienvenida.setText("Bienvenido al Sistema de Gestión de Experimentos de la UAX");
        }
    }
}
