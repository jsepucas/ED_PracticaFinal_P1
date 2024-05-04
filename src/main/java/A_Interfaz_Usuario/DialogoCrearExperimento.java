package A_Interfaz_Usuario;

import B_Gestion_Datos.Experimento;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DialogoCrearExperimento extends JDialog {
    private JTextField nombreField;
    private JTextField bacteriaField;
    private JTextField fechaInicioField;
    private JTextField fechaFinField;
    private JTextField numeroInicialBacteriasField;
    private JTextField temperaturaField;
    private JTextField condicionLuzField;
    private JTextField dosisComidaField;

    public DialogoCrearExperimento(JFrame parent, Experimento experimentoActual) {
        super(parent, "Crear Nuevo Experimento", true);

        // Initialize the text fields
        nombreField = new JTextField(20);
        bacteriaField = new JTextField(20);
        fechaInicioField = new JTextField(20);
        fechaFinField = new JTextField(20);
        numeroInicialBacteriasField = new JTextField(20);
        temperaturaField = new JTextField(20);
        condicionLuzField = new JTextField(20);
        dosisComidaField = new JTextField(20);

        // Create labels for each field
        JLabel nombreLabel = new JLabel("Nombre del experimento:");
        JLabel bacteriaLabel = new JLabel("Nombre de la bacteria:");
        JLabel fechaInicioLabel = new JLabel("Fecha de inicio (dd/MM/yyyy):");
        JLabel fechaFinLabel = new JLabel("Fecha de finalización (dd/MM/yyyy):");
        JLabel numeroInicialBacteriasLabel = new JLabel("Numero inicial de bacterias:");
        JLabel temperaturaLabel = new JLabel("Temperatura:");
        JLabel condicionLuzLabel = new JLabel("Condicion de luz:");
        JLabel dosisComidaLabel = new JLabel("Dosis de comida:");

        // Create a panel with a GridBagLayout to hold the labels and text fields
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;

        // Add the labels and text fields to the panel
        panel.add(nombreLabel, c);
        c.gridx++;
        panel.add(nombreField, c);
        c.gridx = 0;
        c.gridy++;
        panel.add(bacteriaLabel, c);
        c.gridx++;
        panel.add(bacteriaField, c);
        c.gridx = 0;
        c.gridy++;
        panel.add(fechaInicioLabel, c);
        c.gridx++;
        panel.add(fechaInicioField, c);
        c.gridx = 0;
        c.gridy++;
        panel.add(fechaFinLabel, c);
        c.gridx++;
        panel.add(fechaFinField, c);
        c.gridx = 0;
        c.gridy++;
        panel.add(numeroInicialBacteriasLabel, c);
        c.gridx++;
        panel.add(numeroInicialBacteriasField, c);
        c.gridx = 0;
        c.gridy++;
        panel.add(temperaturaLabel, c);
        c.gridx++;
        panel.add(temperaturaField, c);
        c.gridx = 0;
        c.gridy++;
        panel.add(condicionLuzLabel, c);
        c.gridx++;
        panel.add(condicionLuzField, c);
        c.gridx = 0;
        c.gridy++;
        panel.add(dosisComidaLabel, c);
        c.gridx++;
        panel.add(dosisComidaField, c);

        // Add the panel to the dialog
        this.add(panel, BorderLayout.CENTER);

        // Add a button that creates a new Experimento when clicked
        JButton crearButton = new JButton("Crear");
        crearButton.addActionListener(e -> {
            Experimento experimento = new Experimento();
            experimento.setNombre(nombreField.getText());
            experimento.setBacteria(bacteriaField.getText());
            experimento.setFechaInicio(parseDate(fechaInicioField.getText()));
            experimento.setFechaFin(parseDate(fechaFinField.getText()));
            experimento.setNumeroInicialBacterias(Integer.parseInt(numeroInicialBacteriasField.getText()));
            experimento.setTemperatura(Double.parseDouble(temperaturaField.getText()));
            experimento.setCondicionLuz(condicionLuzField.getText());
            experimento.setDosisComida(Double.parseDouble(dosisComidaField.getText()));

            // Add the new experimento to the parent VentanaPrincipal
            ((VentanaPrincipal) parent).setExperimentoActual(experimento);

            // Close the dialog
            dispose();
        });

        // Add the button to the dialog
        this.add(crearButton, BorderLayout.SOUTH);
    }

    private Date parseDate(String date) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch (Exception e) {
            // Handle the exception
            return null;
        }
    }
}