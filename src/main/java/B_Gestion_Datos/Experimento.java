package B_Gestion_Datos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Experimento {
    private String nombre;
    private List<PoblacionBacterias> poblaciones;
    private Date fechaInicio;
    private Date fechaFin;
    private int numeroInicialBacterias;
    private double temperatura;
    private String condicionLuz;
    private double dosisComida;

    public Experimento() {
        this.poblaciones = new ArrayList<>();
    }

    // Getters and setters

    public void addPoblacion(PoblacionBacterias poblacion) {
        this.poblaciones.add(poblacion);
    }

    public List<PoblacionBacterias> getPoblaciones() {
        return this.poblaciones;
    }
}
