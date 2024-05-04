package B_Gestion_Datos;

import B_Gestion_Datos.Experimento;
import java.io.*;

public class AdministradorDatos {

    public static Experimento abrirExperimento(File archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            return (Experimento) ois.readObject();
        }
    }

    public static void guardarExperimento(Experimento experimento, File archivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(experimento);
        }
    }
}