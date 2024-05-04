package A_Interfaz_Usuario;

import B_Gestion_Datos.PoblacionBacterias;
import javax.swing.*;
import java.awt.*;

public class VentanaDetallesPoblacion extends JFrame {
    private PoblacionBacterias poblacion;
    private JLabel[] labelsDosisComida;

    public VentanaDetallesPoblacion(PoblacionBacterias poblacion) {
        this.poblacion = poblacion;
        setTitle("Detalles de la Población de Bacterias");
        setSize(400, 800);
        setLayout(new GridLayout(32, 1));
        initializeUI();
        setLocationRelativeTo(null);
    }

    private void initializeUI() {
        add(new JLabel("Nombre de la población: " + poblacion.getNombre()));
        // ... (agrega más JLabels para otros detalles) ...

        labelsDosisComida = new JLabel[30];
        for (int i = 0; i < 30; i++) {
            labelsDosisComida[i] = new JLabel("Dosis de comida para el día " + (i + 1) + ": " + poblacion.calcularDosisComida(i + 1));
            add(labelsDosisComida[i]);
        }
    }
}