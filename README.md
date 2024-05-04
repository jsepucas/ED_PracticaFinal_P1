# ED_PracticaFinal_P1

Link ---> https://github.com/jsepucas/ED_PracticaFinal_P1.git


# Aplicación para gestionar cultivos de bacterias

## Descripción

Este proyecto es una aplicación de escritorio para un laboratorio de biología que ayuda a recoger la información de los experimentos de cultivo de bacterias. En cada experimento se parte de una población de bacterias inicial. En el medio donde viven las bacterias se añade una determinada cantidad de comida. Esta cantidad de comida inicial irá incrementando linealmente durante varios días, y a continuación disminuye linealmente hasta un valor final. Todos los experimentos duran 30 días.

La aplicación permite gestionar la información relativa a las poblaciones de bacterias asociadas con un experimento. Cada experimento se guarda en un archivo diferente, y cada experimento puede estar compuesto por múltiples poblaciones de bacterias. Para cada población de bacterias, inicialmente el científico indicará: un nombre asociado a esa población, la fecha de comienzo de la población, la fecha de fin de la población, el número de bacterias iniciales, la temperatura a la cual se van a someter las bacterias, las condiciones de luminosidad ("Alta", "Media" y "Baja") y la dosis de comida.

Al compilar la clase `Principal`, se inicia una pantalla donde se puede iniciar sesión. Una vez autenticado, se tiene acceso al proyecto completo. En la parte superior izquierda hay una barra que se despliega y ofrece distintas opciones sobre la creación, edición, eliminación, etc. de experimentos.

## Estructura del Proyecto

El proyecto está organizado en varios paquetes, cada uno con responsabilidades específicas. A continuación se describen las clases más importantes de cada paquete:

### Paquete `A_Interfaz_Usuario`

- `VentanaPrincipal`: Esta es la ventana principal de la aplicación. Proporciona la interfaz de usuario para gestionar los experimentos.
- `VentanaDetallesExperimento`: Esta clase proporciona la interfaz de usuario para ver y editar los detalles de un experimento específico.
- `VentanaDetallesPoblacion`: Esta clase proporciona la interfaz de usuario para ver los detalles de una población de bacterias en un experimento.

### Paquete `B_Gestion_Datos`

- `Experimento`: Esta clase representa un experimento. Contiene detalles como el nombre, la bacteria, la fecha de inicio y fin, el número inicial de bacterias, la temperatura, la condición de luz y la dosis de comida.
- `PoblacionBacterias`: Esta clase representa una población de bacterias en un experimento.
- `AdministradorDatos`: Esta clase proporciona métodos para guardar y abrir experimentos desde archivos.

### Paquete `C_Logica_Negocio`

- `CalculadoraDosisComida`: Esta clase proporciona un método para calcular la dosis de comida para una población de bacterias en un experimento.

### Paquete `D_Autenticacion`

- `VentanaInicioSesion`: Esta clase proporciona la interfaz de usuario para iniciar sesión en la aplicación.
- `GestorAutenticacion`: Esta clase proporciona un método para autenticar a un usuario.

### Paquete `E_App`

- `Principal`: Esta es la clase principal del proyecto. Al compilar esta clase, se inicia la aplicación.
