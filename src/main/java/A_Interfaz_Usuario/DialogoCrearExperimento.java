package A_Interfaz_Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogoCrearExperimento extends JDialog {
    private JTextField nombreExperimentoField;
    private JButton guardarBtn, cancelarBtn;

    public DialogoCrearExperimento(JFrame owner) {
        super(owner, "Crear Nuevo Experimento", true);
        setSize(300, 200);
        setLayout(new GridLayout(0, 2));

        add(new JLabel("Nombre del Experimento:"));
        nombreExperimentoField = new JTextField();
        add(nombreExperimentoField);

        guardarBtn = new JButton("Guardar");
        guardarBtn.addActionListener(e -> guardarExperimento());
        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.addActionListener(e -> setVisible(false));

        add(guardarBtn);
        add(cancelarBtn);

        setLocationRelativeTo(owner);
    }

    private void guardarExperimento() {
        String nombreExperimento = nombreExperimentoField.getText();
        // lógica para crear un nuevo experimento
        // Ejemplo: controller.crearExperimento(nombreExperimento);
        setVisible(false);
    }
}