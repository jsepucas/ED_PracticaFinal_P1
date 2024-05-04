package A_Interfaz_Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DialogoAgregarPoblacion extends JDialog {
    private JTextField nombrePoblacionField;
    private JButton guardarBtn, cancelarBtn;

    public DialogoAgregarPoblacion(JFrame owner) {
        super(owner, "Agregar Población de Bacterias", true);
        setSize(300, 200);
        setLayout(new GridLayout(0, 2));

        add(new JLabel("Nombre de la Población:"));
        nombrePoblacionField = new JTextField();
        add(nombrePoblacionField);

        guardarBtn = new JButton("Guardar");
        guardarBtn.addActionListener(e -> guardarPoblacion());
        cancelarBtn = new JButton("Cancelar");
        cancelarBtn.addActionListener(e -> setVisible(false));

        add(guardarBtn);
        add(cancelarBtn);

        setLocationRelativeTo(owner);
    }

    private void guardarPoblacion() {
        String nombrePoblacion = nombrePoblacionField.getText();
        // Aquí implementar la lógica para añadir una nueva población
        // Ejemplo: controller.añadirPoblacion(nombrePoblacion);
        setVisible(false);
    }
}