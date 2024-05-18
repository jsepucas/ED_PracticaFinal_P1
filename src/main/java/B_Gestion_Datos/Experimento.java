package B_Gestion_Datos;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Experimento {
    private String nombre;
    private String bacteria;
    private Date fechaInicio;
    private Date fechaFin;
    private int duracionDias; // Nuevo campo para la duración variable de los experimentos
    private int numeroInicialBacterias;
    private double temperatura;
    private String condicionLuz;
    private double dosisComida;
    private List<PoblacionBacterias> poblaciones;

    public Experimento() {
        poblaciones = new ArrayList<>();
    }

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
        calcularFechaFin();
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    // Eliminado el setter para fechaFin, ya que se calculará automáticamente
    // public void setFechaFin(Date fechaFin) {
    //     this.fechaFin = fechaFin;
    // }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
        calcularFechaFin();
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
        poblaciones.add(poblacion);
    }

    // Método para calcular la fecha de fin basada en la fecha de inicio y la duración
    private void calcularFechaFin() {
        if (this.fechaInicio != null && this.duracionDias > 0) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(this.fechaInicio);
            cal.add(Calendar.DAY_OF_MONTH, this.duracionDias);
            this.fechaFin = cal.getTime();
        } else {
            this.fechaFin = null;
        }
    }
}
