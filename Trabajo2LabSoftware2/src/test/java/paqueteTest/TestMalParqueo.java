package paqueteTest;
import domain.Parqueo;
import domain.VehiculoEnum;
import domain.access.IParqueoRepository;
import domain.service.Servicios;
import domain.service.ServiciosParqueo;
import java.text.ParseException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Cristian Pinto - Julio Mellizo
 */
public class TestMalParqueo {
    
    IParqueoRepository repository;
    
    @Test
    public void testNullVehicle() throws ParseException {
        System.out.println("Null car parqueo");
        Parqueo parqueo = new Parqueo(); 
        int precio = new ServiciosParqueo().calcularTarifaParqueo(parqueo);
        assertEquals(0, precio);
        }

    @Test
    public void testwithoutMinutes() throws ParseException {
        System.out.println("Null car parqueo");
        Parqueo parqueo = new Parqueo(1, VehiculoEnum.CARRO, 0); 
        boolean methodSave = new Servicios(repository).guardarParqueo(parqueo);
        assertEquals(false, methodSave);
        }
    
    @Test
    public void testWithoutRepositoryInstantiated() throws ParseException {
        System.out.println("Null car parqueo");
        Parqueo parqueo = new Parqueo(1, VehiculoEnum.CARRO, 30); 
        boolean methodSave = new Servicios(repository).guardarParqueo(parqueo);
        assertEquals(false, methodSave);
        }
}
