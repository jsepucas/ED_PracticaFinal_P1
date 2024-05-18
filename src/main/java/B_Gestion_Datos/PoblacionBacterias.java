package B_Gestion_Datos;

import java.util.Comparator;
import java.util.Date;

public class PoblacionBacterias {
    private String nombrePoblacion;
    private int comidaInicial;
    private int comidaFinal;
    private int diaIncremento;
    private int comidaIncremento;
    private Date fechaInicio; // Añadido para el comparador por fecha
    private int numeroBacterias; // Añadido para el comparador por número de bacterias


    public PoblacionBacterias(String nombrePoblacion) {
        this.nombrePoblacion = nombrePoblacion;
        // Inicializar otros campos si es necesario
    }

    public String getNombre() {
        return nombrePoblacion;
    }

    public int calcularDosisComida(int dia) {
        if (dia <= diaIncremento) {
            // La comida se incrementa linealmente hasta el día de incremento
            return comidaInicial + (comidaIncremento - comidaInicial) * dia / diaIncremento;
        } else {
            // La comida disminuye linealmente después del día de incremento
            return comidaIncremento + (comidaFinal - comidaIncremento) * (dia - diaIncremento) / (30 - diaIncremento);
        }
    }

    // Métodos añadidos para obtener fechaInicio y numeroBacterias
    public Date getFechaInicio() {
        return fechaInicio;
    }

    public int getNumeroBacterias() {
        return numeroBacterias;
    }

    // Implementación de comparadores
    public static Comparator<PoblacionBacterias> porFechaInicio() {
        return Comparator.comparing(PoblacionBacterias::getFechaInicio);
    }

    public static Comparator<PoblacionBacterias> porNombre() {
        return Comparator.comparing(PoblacionBacterias::getNombre);
    }

    public static Comparator<PoblacionBacterias> porNumeroBacterias() {
        return Comparator.comparingInt(PoblacionBacterias::getNumeroBacterias);
    }
}
