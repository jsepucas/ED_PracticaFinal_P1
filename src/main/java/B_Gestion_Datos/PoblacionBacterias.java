package B_Gestion_Datos;

public class PoblacionBacterias {
    private String nombrePoblacion;
    private int comidaInicial;
    private int comidaFinal;
    private int diaIncremento;
    private int comidaIncremento;

    public PoblacionBacterias(String nombrePoblacion, int comidaInicial, int comidaFinal, int diaIncremento, int comidaIncremento) {
        this.nombrePoblacion = nombrePoblacion;
        this.comidaInicial = comidaInicial;
        this.comidaFinal = comidaFinal;
        this.diaIncremento = diaIncremento;
        this.comidaIncremento = comidaIncremento;
    }

    public String getNombre() {
        return nombrePoblacion;
    }

    public int calcularDosisComida(int dia) {
        if (dia <= diaIncremento) {
            // La comida se incrementa linealmente hasta el día de incremento
            return comidaInicial + (comidaIncremento - comidaInicial) * dia / diaIncremento;
        } else {
            // La comida disminuye linealmente después del día de incremento
            return comidaIncremento + (comidaFinal - comidaIncremento) * (dia - diaIncremento) / (30 - diaIncremento);
        }
    }
}