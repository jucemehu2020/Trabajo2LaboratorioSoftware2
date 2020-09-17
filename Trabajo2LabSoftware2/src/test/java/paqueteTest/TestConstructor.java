
package paqueteTest;

import domain.Parqueo;
import domain.VehiculoEnum;
import java.text.ParseException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Cristian Pinto - Julio Mellizo
 */
public class TestConstructor {
    
     @Test
    public void testCamion() throws ParseException {
        System.out.println("Camion más de un día completo");
        Parqueo parking = new Parqueo(1,VehiculoEnum.CAMION,1445); 
        assertEquals(parking.getParqueoId(), 1);
        assertEquals(parking.getMinutosParqueo(), 1445);
        assertEquals(parking.getTipoVehiculo(), VehiculoEnum.CAMION);
        }

    @Test
    public void testCarro() throws ParseException {
        System.out.println("Camion día completo");
        Parqueo parking = new Parqueo(1,VehiculoEnum.CARRO,1440); 
        assertEquals(parking.getParqueoId(), 1);
        assertEquals(parking.getMinutosParqueo(), 1440);
        assertEquals(parking.getTipoVehiculo(), VehiculoEnum.CARRO);
        }

    @Test
    public void testMoto() throws ParseException {
        System.out.println("Camion más de medio día");
        Parqueo parking = new Parqueo(1,VehiculoEnum.MOTO,800); 
        assertEquals(parking.getParqueoId(), 1);
        assertEquals(parking.getMinutosParqueo(), 800);
        assertEquals(parking.getTipoVehiculo(), VehiculoEnum.MOTO);
        }
    
}
