package A_Interfaz_Usuario;

import B_Gestion_Datos.Experimento;
import javax.swing.*;
import java.awt.*;

public class VentanaDetallesExperimento extends JFrame {
    private Experimento experimento;
    private JTextField nombreField, bacteriaField, numeroInicialBacteriasField, temperaturaField, condicionLuzField, dosisComidaField;
    private JButton guardarButton;

    public VentanaDetallesExperimento(Experimento experimento) {
        this.experimento = experimento;
        setTitle("Detalles del Experimento");
        setSize(400, 400);
        setLayout(new BorderLayout());
        initializeUI();
        setLocationRelativeTo(null);
    }

    private void initializeUI() {
        JPanel panel = new JPanel(new GridLayout(6, 2));

        nombreField = new JTextField(experimento.getNombre());
        bacteriaField = new JTextField(experimento.getBacteria());
        numeroInicialBacteriasField = new JTextField(String.valueOf(experimento.getNumeroInicialBacterias()));
        temperaturaField = new JTextField(String.valueOf(experimento.getTemperatura()));
        condicionLuzField = new JTextField(experimento.getCondicionLuz());
        dosisComidaField = new JTextField(String.valueOf(experimento.getDosisComida()));

        panel.add(new JLabel("Nombre del experimento:"));
        panel.add(nombreField);
        panel.add(new JLabel("Nombre de la bacteria:"));
        panel.add(bacteriaField);
        panel.add(new JLabel("Número inicial de bacterias:"));
        panel.add(numeroInicialBacteriasField);
        panel.add(new JLabel("Temperatura:"));
        panel.add(temperaturaField);
        panel.add(new JLabel("Condición de luz:"));
        panel.add(condicionLuzField);
        panel.add(new JLabel("Dosis de comida:"));
        panel.add(dosisComidaField);

        add(panel, BorderLayout.CENTER);

        guardarButton = new JButton("Guardar");
        guardarButton.addActionListener(e -> guardarCambios());
        add(guardarButton, BorderLayout.SOUTH);
    }

    private void guardarCambios() {
        experimento.setNombre(nombreField.getText());
        experimento.setBacteria(bacteriaField.getText());
        experimento.setNumeroInicialBacterias(Integer.parseInt(numeroInicialBacteriasField.getText()));
        experimento.setTemperatura(Double.parseDouble(temperaturaField.getText()));
        experimento.setCondicionLuz(condicionLuzField.getText());
        experimento.setDosisComida(Double.parseDouble(dosisComidaField.getText()));
    }
}