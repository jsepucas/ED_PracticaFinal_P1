package A_Interfaz_Usuario;

import B_Gestion_Datos.Experimento;
import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class DialogoCrearExperimento extends JDialog {
    private JTextField nombreField, bacteriaField, numeroInicialBacteriasField, temperaturaField, condicionLuzField, dosisComidaField;
    private JFormattedTextField fechaInicioField, fechaFinField;
    private JButton crearButton;

    public DialogoCrearExperimento(JFrame parent) {
        super(parent, "Crear Nuevo Experimento", true);
        setSize(400, 400);
        setLayout(new BorderLayout());
        initializeUI();
        setLocationRelativeTo(parent);
    }

    private void initializeUI() {
        JPanel panel = new JPanel(new GridLayout(8, 2));

        nombreField = new JTextField();
        bacteriaField = new JTextField();
        fechaInicioField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        fechaFinField = new JFormattedTextField(new SimpleDateFormat("dd/MM/yyyy"));
        numeroInicialBacteriasField = new JTextField();
        temperaturaField = new JTextField();
        condicionLuzField = new JTextField();
        dosisComidaField = new JTextField();

        panel.add(new JLabel("Nombre del experimento:"));
        panel.add(nombreField);
        panel.add(new JLabel("Nombre de la bacteria:"));
        panel.add(bacteriaField);
        panel.add(new JLabel("Fecha de inicio (dd/MM/yyyy):"));
        panel.add(fechaInicioField);
        panel.add(new JLabel("Fecha de finalización (dd/MM/yyyy):"));
        panel.add(fechaFinField);
        panel.add(new JLabel("Número inicial de bacterias:"));
        panel.add(numeroInicialBacteriasField);
        panel.add(new JLabel("Temperatura:"));
        panel.add(temperaturaField);
        panel.add(new JLabel("Condición de luz:"));
        panel.add(condicionLuzField);
        panel.add(new JLabel("Dosis de comida:"));
        panel.add(dosisComidaField);

        add(panel, BorderLayout.CENTER);

        crearButton = new JButton("Crear");
        crearButton.addActionListener(e -> crearExperimento());
        add(crearButton, BorderLayout.SOUTH);
    }

    private void crearExperimento() {
        try {
            Experimento experimento = new Experimento();
            experimento.setNombre(nombreField.getText());
            experimento.setBacteria(bacteriaField.getText());
            experimento.setFechaInicio(new SimpleDateFormat("dd/MM/yyyy").parse(fechaInicioField.getText()));
            experimento.setFechaFin(new SimpleDateFormat("dd/MM/yyyy").parse(fechaFinField.getText()));
            experimento.setNumeroInicialBacterias(Integer.parseInt(numeroInicialBacteriasField.getText()));
            experimento.setTemperatura(Double.parseDouble(temperaturaField.getText()));
            experimento.setCondicionLuz(condicionLuzField.getText());
            experimento.setDosisComida(Double.parseDouble(dosisComidaField.getText()));

            ((VentanaPrincipal) getParent()).setExperimentoActual(experimento);
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al crear el experimento: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
