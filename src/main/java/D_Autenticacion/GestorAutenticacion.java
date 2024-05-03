package D_Autenticacion;

public class GestorAutenticacion {
    public static boolean autenticar(String usuario, String contraseña) {
        // Implementación simple de ejemplo
        // Deberías reemplazar esto con una verificación real, posiblemente contra una base de datos
        return "admin".equals(usuario) && "admin".equals(contraseña);
    }
}