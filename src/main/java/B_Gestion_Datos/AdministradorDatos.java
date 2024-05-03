package B_Gestion_Datos;

import A_Interfaz_Usuario.Experimento;
import java.io.*;

public class AdministradorDatos {

    public static Experimento abrirExperimento(File archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Experimento) ois.readObject();
        }
    }
