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

public class TestTarifaCarro {

    public void testCarroRedondeo() throws ParseException {
        System.out.println("Carro mas de 60 minutos");
        Parqueo parqueo = new Parqueo(1,VehiculoEnum.CARRO,80); 
        int precio = new ServiciosParqueo().calcularTarifaParqueo(parqueo);
        assertEquals(2400, precio);
        }

    @Test
    public void testCarroMenosTiempo() throws ParseException {
        System.out.println("Carro menos de 60 minutos");
        Parqueo parqueo = new Parqueo(1,VehiculoEnum.CARRO,10); 
        int precio = new ServiciosParqueo().calcularTarifaParqueo(parqueo);
        assertEquals(2000, precio);
        }
}
    
    
