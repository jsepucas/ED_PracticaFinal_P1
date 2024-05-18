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

    private void inicializarBacterias() {
        int centro = TAMANO_PLATO / 2;
        for (int i = centro - 2; i <= centro + 1; i++) {
            for (int j = centro - 2; j <= centro + 1; j++) {
                bacterias.add(new Bacteria(i, j));
            }
        }
    }


    public void simularDia() {
        List<Bacteria> nuevasBacterias = new ArrayList<>();
        for (Bacteria bacteria : bacterias) {
            int x = bacteria.getX();
            int y = bacteria.getY();
            if (comida[x][y] >= 100) {
                comida[x][y] -= 20;
                moverOBacteria(nuevasBacterias, x, y, 20, 100);
            } else if (comida[x][y] >= 10) {
                comida[x][y] -= 10;
                moverOBacteria(nuevasBacterias, x, y, 10, 99);
            } else {
                moverOBacteria(nuevasBacterias, x, y, 0, 59);
            }
        }
        bacterias.addAll(nuevasBacterias);
    }

    private void moverOBacteria(List<Bacteria> nuevasBacterias, int x, int y, int comidaConsumida, int probabilidadMovimiento) {
        int destino = random.nextInt(100);
        if (destino < 3 || (comidaConsumida == 0 && destino < 20)) {
            return;
        } else if (destino < 60 || (comidaConsumida == 0 && destino < 60)) {
            nuevasBacterias.add(new Bacteria(x, y));
        } else {
            moverBacteria(nuevasBacterias, x, y);
        }
    }

    private void moverBacteria(List<Bacteria> nuevasBacterias, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int direccion = random.nextInt(4);
        int nuevoX = x + dx[direccion];
        int nuevoY = y + dy[direccion];
        if (nuevoX >= 0 && nuevoX < TAMANO_PLATO && nuevoY >= 0 && nuevoY < TAMANO_PLATO) {
            nuevasBacterias.add(new Bacteria(nuevoX, nuevoY));
        } else {
            nuevasBacterias.add(new Bacteria(x, y));
        }
    }

    public int[][] getComida() {
        return comida;
    }

    public List<Bacteria> getBacterias() {
        return bacterias;
    }

    public static class Bacteria {
        private int x;
        private int y;

        public Bacteria(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
