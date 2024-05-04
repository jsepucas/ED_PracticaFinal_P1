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
        initializeUI();
    }

    private void initializeUI() {
        setLayout(new BorderLayout());
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Initialize fields
        nombreField = new JTextField(20);
        bacteriaField = new JTextField(20);
        fechaInicioField = new JTextField(20);
        fechaFinField = new JTextField(20);
        numeroInicialBacteriasField = new JTextField(20);
        temperaturaField = new JTextField(20);
        condicionLuzField = new JTextField(20);
        dosisComidaField = new JTextField(20);

        // Add components to panel
        addField(panel, "Nombre del experimento:", nombreField, c, 0);
        addField(panel, "Nombre de la bacteria:", bacteriaField, c, 1);
        addField(panel, "Fecha de inicio (dd/MM/yyyy):", fechaInicioField, c, 2);
        addField(panel, "Fecha de finalización (dd/MM/yyyy):", fechaFinField, c, 3);
        addField(panel, "Número inicial de bacterias:", numeroInicialBacteriasField, c, 4);
        addField(panel, "Temperatura:", temperaturaField, c, 5);
        addField(panel, "Condición de luz:", condicionLuzField, c, 6);
        addField(panel, "Dosis de comida:", dosisComidaField, c, 7);

        JButton crearButton = new JButton("Crear");
        crearButton.addActionListener(e -> crearExperimento());
        add(crearButton, BorderLayout.SOUTH);
        add(panel, BorderLayout.CENTER);
    }

    private void addField(JPanel panel, String label, JTextField field, GridBagConstraints c, int gridy) {
        c.gridx = 0;
        c.gridy = gridy;
        panel.add(new JLabel(label), c);
        c.gridx = 1;
        panel.add(field, c);
    }

    private void crearExperimento() {
        Experimento experimento = new Experimento();
        experimento.setNombre(nombreField.getText());
        experimento.setBacteria(bacteriaField.getText());
        experimento.setFechaInicio(parseDate(fechaInicioField.getText()));
        experimento.setFechaFin(parseDate(fechaFinField.getText()));
        experimento.setNumeroInicialBacterias(Integer.parseInt(numeroInicialBacteriasField.getText()));
        experimento.setTemperatura(Double.parseDouble(temperaturaField.getText()));
        experimento.setCondicionLuz(condicionLuzField.getText());
        experimento.setDosisComida(Double.parseDouble(dosisComidaField.getText()));
        dispose();
    }

    private Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al analizar la fecha: " + dateStr, "Error de Análisis de Fecha", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
