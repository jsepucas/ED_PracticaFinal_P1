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

