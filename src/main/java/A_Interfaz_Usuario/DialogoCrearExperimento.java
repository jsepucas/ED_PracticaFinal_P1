package A_Interfaz_Usuario;

import B_Gestion_Datos.Experimento;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogoCrearExperimento extends JDialog {
    private JTextField nombreExperimentoField;
    private JButton guardarBtn, cancelarBtn;
    private Experimento experimentoActual; // Almacena el experimento actual si está editando

    // Constructor para crear un nuevo experimento
    public DialogoCrearExperimento(JFrame owner) {
        this(owner, null); // Llama al constructor sobrecargado con 'null' para el experimento
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


