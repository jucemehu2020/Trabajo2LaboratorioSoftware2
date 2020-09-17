package domain;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public class TCamion extends CRedondeo {

    @Override
    public int CalcularTarifa(int minutos) {
        tarifa = 15000;
        if (minutos <= 720) {
            tarifa = 10000;
        } else if (minutos > 1440) {
            tarifa += (minutos - 1440) * (125.0 / 12.0);
            tarifa = calcularRedondeo(tarifa);
        }
        if (Sortear()) {
            tarifa = 0;
        }
        return tarifa;
    }

    private boolean Sortear() {
        int numeroAleatorio = (int) (Math.random() * (1000 - 1)) + 1;;
        return tarifa % numeroAleatorio == 0;
    }

}
