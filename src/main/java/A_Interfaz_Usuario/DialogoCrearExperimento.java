package A_Interfaz_Usuario;

import B_Gestion_Datos.Experimento;
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
        if (!nombreExperimento.isEmpty()) {
            Experimento nuevoExperimento = new Experimento(nombreExperimento);
            ((VentanaPrincipal) getOwner()).setExperimentoActual(nuevoExperimento);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "El nombre del experimento no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
