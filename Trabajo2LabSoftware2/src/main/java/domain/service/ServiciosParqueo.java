package domain.service;

import domain.Parqueo;
import domain.CRedondeo;
import domain.access.Factory;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public class ServiciosParqueo {
    
    public int calcularTarifaParqueo(Parqueo parking) {

       int result = 0;
        if (parking == null) {
            return result;
        }
 
        CRedondeo fee = Factory.getInstance().getVehiculo(parking.getTipoVehiculo());
        if (fee != null)
            result = fee.CalcularTarifa(parking.getMinutosParqueo());

        return result;
    }
    
}
