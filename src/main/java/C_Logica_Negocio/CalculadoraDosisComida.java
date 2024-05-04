package C_Logica_Negocio;

public class CalculadoraDosisComida {

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
}