package paqueteTest;
import java.text.ParseException;
import org.junit.Test;
import domain.Parqueo;
import domain.VehiculoEnum;
import domain.service.ServiciosParqueo;
import static org.junit.Assert.*;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */

public class TestTarifaMoto {
@Test
    public void testMotoRedondeo() throws ParseException {
        System.out.println("Moto mas de 60 minutos");
        Parqueo parqueo = new Parqueo(1,VehiculoEnum.MOTO,80); 
        int precio = new ServiciosParqueo().calcularTarifaParqueo(parqueo);
        assertEquals(1200, precio);
        }

    @Test
    public void testMotoMenosTiempo() throws ParseException {
        System.out.println("Moto menos de 60 minutos");
        Parqueo parqueo = new Parqueo(1,VehiculoEnum.MOTO,10); 
        int precio = new ServiciosParqueo().calcularTarifaParqueo(parqueo);
        assertEquals(1000, precio);
       }
}
