package B_Gestion_Datos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Experimento {
    private String nombre;
    private String bacteria;
    private Date fechaInicio;
    private Date fechaFin;
    private int numeroInicialBacterias;
    private double temperatura;
    private String condicionLuz;
    private double dosisComida;
    private List<PoblacionBacterias> poblaciones;

    public Experimento() {
        this.poblaciones = new ArrayList<>();
    }

    // Getters y Setters
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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getNumeroInicialBacterias() {
        return numeroInicialBacterias;
    }

    public void setNumeroInicialBacterias(int numeroInicialBacterias) {
        this.numeroInicialBacterias = numeroInicialBacterias;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public String getCondicionLuz() {
        return condicionLuz;
    }

    public void setCondicionLuz(String condicionLuz) {
        this.condicionLuz = condicionLuz;
    }

    public double getDosisComida() {
        return dosisComida;
    }

    public void setDosisComida(double dosisComida) {
        this.dosisComida = dosisComida;
    }

    public List<PoblacionBacterias> getPoblaciones() {
        return poblaciones;
    }

    public void addPoblacion(PoblacionBacterias poblacion) {
        this.poblaciones.add(poblacion);
    }
}
