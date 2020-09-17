package domain;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public abstract class CRedondeo {

    protected int tarifa;

    protected int calcularRedondeo(int valor) {
        int residuo = valor % 100;
        if (residuo != 0) {
            valor += 100 - residuo;
        }
        return valor;
    }

    abstract public int CalcularTarifa(int minutos);

}
