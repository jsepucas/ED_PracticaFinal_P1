package B_Gestion_Datos;

import java.io.Serializable;

public class Experimento implements Serializable {
    private String nombre;
    // Otros atributos según necesidad

    // Constructor que acepta el nombre del experimento
    public Experimento(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para el nombre
    public String getNombre() {
        return nombre;
    }

    // Método setter para el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Otros métodos y lógica según necesidad
}
