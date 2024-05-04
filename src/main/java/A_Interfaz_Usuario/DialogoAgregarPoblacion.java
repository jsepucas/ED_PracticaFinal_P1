package A_Interfaz_Usuario;

import B_Gestion_Datos.Experimento;
import B_Gestion_Datos.PoblacionBacterias;
import javax.swing.*;
import java.awt.*;

public class DialogoAgregarPoblacion extends JDialog {
    private JTextField nombrePoblacionField;
    private Experimento experimento;

    public DialogoAgregarPoblacion(JFrame owner, Experimento experimento) {
        super(owner, "Agregar Población de Bacterias", true);
        this.experimento = experimento;
        setSize(300, 200);
        setLayout(new GridLayout(0, 2));

        add(new JLabel("Nombre de la Población:"));
        nombrePoblacionField = new JTextField();
        add(nombrePoblacionField);

        JButton guardarBtn = new JButton("Guardar");
        guardarBtn.addActionListener(e -> guardarPoblacion());
        JButton cancelarBtn = new JButton("Cancelar");
        cancelarBtn.addActionListener(e -> setVisible(false));

        add(guardarBtn);
        add(cancelarBtn);

        setLocationRelativeTo(owner);
    }

    private void guardarPoblacion() {
        String nombrePoblacion = nombrePoblacionField.getText();
        PoblacionBacterias nuevaPoblacion = new PoblacionBacterias(nombrePoblacion);
        experimento.addPoblacion(nuevaPoblacion);
        setVisible(false);
    }
}