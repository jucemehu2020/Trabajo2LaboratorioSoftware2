package domain;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public class TCarro extends CRedondeo {
      
    @Override
    public int CalcularTarifa(int minutos) {
         tarifa=2000;
        if (minutos>60){
            tarifa += (minutos-60)*(50/3);
            tarifa = calcularRedondeo(tarifa);
         }    
        return tarifa;
    }   
}
