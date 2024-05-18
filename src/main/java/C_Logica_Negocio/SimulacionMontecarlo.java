package C_Logica_Negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulacionMontecarlo {

    private static final int TAMANO_PLATO = 20;
    private int[][] comida;
    private List<Bacteria> bacterias;
    private Random random;

    public SimulacionMontecarlo(int comidaInicial) {
        this.comida = new int[TAMANO_PLATO][TAMANO_PLATO];
        this.bacterias = new ArrayList<>();
        this.random = new Random();
        inicializarPlato(comidaInicial);
        inicializarBacterias();
    }

    private void inicializarPlato(int comidaInicial) {
        for (int i = 0; i < TAMANO_PLATO; i++) {
            for (int j = 0; j < TAMANO_PLATO; j++) {
                comida[i][j] = comidaInicial;
            }
        }
    }