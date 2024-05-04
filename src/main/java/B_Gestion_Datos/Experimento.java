package B_Gestion_Datos;

import java.io.Serializable;

public class Experimento implements Serializable {
    private String nombre;

    // Constructor que acepta el nombre del experimento
    public Experimento(String nombre) {
        this.nombre = nombre;
    }

    // Getter para el nombre del experimento
    public String getNombre() {
        return nombre;
    }

    // Puedes agregar otros métodos y propiedades según sea necesario
}
