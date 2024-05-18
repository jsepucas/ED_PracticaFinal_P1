package C_Logica_Negocio;

public class CalculadoraDosisComida {

    private static final int LIMITE_MAX_COMIDA = 300000; // en microgramos

    // Patrón de incremento y decremento lineal existente
    public static int[] calcularDosisComida(int comidaInicial, int diaPico, int comidaPico, int comidaFinal, int totalDias) {
        int[] dosisDiaria = new int[totalDias];

        // Incremento hasta el día pico
        double incrementoDiario = (comidaPico - comidaInicial) / (double) (diaPico - 1);
        for (int i = 0; i < diaPico; i++) {
            dosisDiaria[i] = (int) Math.round(comidaInicial + i * incrementoDiario);
        }

        // Decremento hasta el final
        double decrementoDiario = (comidaPico - comidaFinal) / (double) (totalDias - diaPico);
        for (int i = diaPico; i < totalDias; i++) {
            dosisDiaria[i] = (int) Math.round(comidaPico - (i - diaPico) * decrementoDiario);
        }

        return dosisDiaria;
    }

    // Nuevo patrón: Cantidad Constante
    public static int[] calcularDosisConstante(int cantidadFija, int totalDias) {
        int[] dosisDiaria = new int[totalDias];
        for (int i = 0; i < totalDias; i++) {
            dosisDiaria[i] = cantidadFija;
        }
        return dosisDiaria;
    }

    // Nuevo patrón: Incremento Lineal
    public static int[] calcularIncrementoLineal(int cantidadInicial, int cantidadFinal, int totalDias) {
        int[] dosisDiaria = new int[totalDias];
        double incrementoDiario = (cantidadFinal - cantidadInicial) / (double) (totalDias - 1);
        for (int i = 0; i < totalDias; i++) {
            dosisDiaria[i] = (int) Math.round(cantidadInicial + i * incrementoDiario);
        }
        return dosisDiaria;
    }

    // Nuevo patrón: Patrón Alternante
    public static int[] calcularPatronAlternante(int cantidad, int totalDias) {
        int[] dosisDiaria = new int[totalDias];
        for (int i = 0; i < totalDias; i++) {
            dosisDiaria[i] = (i % 2 == 0) ? cantidad : 0;
        }
        return dosisDiaria;
    }
}



