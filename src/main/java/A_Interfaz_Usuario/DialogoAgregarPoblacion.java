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