package B_Gestion_Datos;

import java.util.Date;

public class Experimento {
    private String nombre;
    private String bacteria;
    private Date fechaInicio;
    private Date fechaFin;
    private int numeroInicialBacterias;
    private double temperatura;
    private String condicionLuz;
    private double dosisComida;

    // Add getters and setters for the new fields
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getBacteria() {
        return bacteria;
    }

    public void setBacteria(String bacteria) {
        this.bacteria = bacteria;
    }


