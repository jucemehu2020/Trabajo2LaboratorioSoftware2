package domain.service;

import domain.Parqueo;
import java.util.ArrayList;
import java.util.List;
import domain.access.IParqueoRepository;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public class Servicios {
    
    private IParqueoRepository repository;
    
    public Servicios(IParqueoRepository repository) {
        this.repository = repository;
    }
    
    public boolean guardarParqueo(Parqueo newParking) {

        if (newParking == null || newParking.getMinutosParqueo()<= 0 || 
                newParking.getTipoVehiculo() == null || newParking.getParqueoId() <= 0) {
            return false;
        }
        if (repository == null)
            return false;
        repository.save(newParking);
        return true;

    }

    public List<Parqueo> listParqueo() {
        List<Parqueo> parking = new ArrayList<>();
        parking = repository.list();;

        return parking;
    }
    
    public int calculateFee(Parqueo parking){
        return new ServiciosParqueo().calcularTarifaParqueo(parking);
    }
}
