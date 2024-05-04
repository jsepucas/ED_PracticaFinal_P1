package A_Interfaz_Usuario;

import B_Gestion_Datos.Experimento;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogoCrearExperimento extends JDialog {
    private JTextField nombreField;
    private JTextField bacteriaField;
    private JTextField fechaInicioField;
    private JTextField fechaFinField;
    private JTextField numeroInicialBacteriasField;
    private JTextField temperaturaField;
    private JTextField condicionLuzField;
    private JTextField dosisComidaField;
    private JTextField nombreExperimentoField;
    private JButton guardarBtn, cancelarBtn;
    private Experimento experimentoActual;

    // Constructor para crear un nuevo experimento
    public DialogoCrearExperimento(JFrame owner) {
        this(owner, null); // Llama al constructor sobrecargado con 'null' para el experimento

        nombreField = new JTextField(20);
        bacteriaField = new JTextField(20);
        fechaInicioField = new JTextField(20);
        fechaFinField = new JTextField(20);
        numeroInicialBacteriasField = new JTextField(20);
        temperaturaField = new JTextField(20);
        condicionLuzField = new JTextField(20);
        dosisComidaField = new JTextField(20);


    }

    // Constructor sobrecargado para editar un experimento existente
    public DialogoCrearExperimento(JFrame owner, Experimento experimento) {
        super(owner, experimento == null ? "Crear Nuevo Experimento" : "Editar Experimento", true);
        this.experimentoActual = experimento;
        initializeUI();
    }

    private void initializeUI() {
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));

        add(new JLabel("Nombre del Experimento:"));
        nombreExperimentoField = new JTextField();
        if (experimentoActual != null) {
            nombreExperimentoField.setText(experimentoActual.getNombre()); // Setear el nombre si está editando
        }
        add(nombreExperimentoField);

        guardarBtn = new JButton("Guardar");
        guardarBtn.addActionListener(e -> guardarExperimento());
        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.addActionListener(e -> setVisible(false));

        add(guardarBtn);
        add(cancelarBtn);

        setLocationRelativeTo(getOwner());
    }

    private void guardarExperimento() {
        String nombreExperimento = nombreExperimentoField.getText().trim();
        if (!nombreExperimento.isEmpty()) {
            if (experimentoActual == null) {
                experimentoActual = new Experimento(nombreExperimento); // Crear nuevo si no estaba editando
            } else {
                experimentoActual.setNombre(nombreExperimento); // Actualizar nombre si estaba editando
            }
            ((VentanaPrincipal) getOwner()).setExperimentoActual(experimentoActual);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "El nombre del experimento no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}