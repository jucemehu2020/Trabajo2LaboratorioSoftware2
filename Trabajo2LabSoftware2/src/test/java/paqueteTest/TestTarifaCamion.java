package paqueteTest;
import java.text.ParseException;
import org.junit.Test;
import domain.Parqueo;
import domain.VehiculoEnum;
import domain.service.ServiciosParqueo;
import static org.junit.Assert.*;


/**
 *
 * @author Cristian Pinto - Julio Mellizo
 */

public class TestTarifaCamion {
    
    @Test
    public void testCamionMasDelDia() throws ParseException {
        System.out.println("Camion más de un día completo");
        Parqueo parking = new Parqueo(1,VehiculoEnum.CAMION,1445); 
        int precio = new ServiciosParqueo().calcularTarifaParqueo(parking);
        assertEquals(15100, precio);
        }

    @Test
    public void testCamionDiaCompleto() throws ParseException {
        System.out.println("Camion día completo");
        Parqueo parking = new Parqueo(1,VehiculoEnum.CAMION,1440); 
        int precio = new ServiciosParqueo().calcularTarifaParqueo(parking);
        assertEquals(15000, precio);
       }

    @Test
    public void testCamionMasDeMedioDia() throws ParseException {
        System.out.println("Camion más de medio día");
        Parqueo parking = new Parqueo(1,VehiculoEnum.CAMION,800); 
        int precio = new ServiciosParqueo().calcularTarifaParqueo(parking);
        assertEquals(15000, precio);
       }
    
    @Test
    public void testCamionMedioDia() throws ParseException {
        System.out.println("Camion medio día");
        Parqueo parking = new Parqueo(1,VehiculoEnum.CAMION,720); 
        int precio = new ServiciosParqueo().calcularTarifaParqueo(parking);
        assertEquals(10000, precio);
        }
    
    @Test
    public void testCamionMenosMedioDia() throws ParseException {
        System.out.println("Camion menos de medio día");
        Parqueo parking = new Parqueo(1,VehiculoEnum.CAMION,600); 
        int precio = new ServiciosParqueo().calcularTarifaParqueo(parking);
        assertEquals(10000, precio);
        }
    
    }
