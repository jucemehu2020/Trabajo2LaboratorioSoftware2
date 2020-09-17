package main;

import domain.Parqueo;
import domain.VehiculoEnum;
import domain.access.Factory;
import domain.service.Servicios;
import domain.access.IParqueoRepository;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public class Main {

    public static void main(String[] args) {
 
        IParqueoRepository repository = Factory.getInstance().getRepository("default");
        Servicios service = new Servicios(repository);

        Parqueo newParking = new Parqueo(1, VehiculoEnum.CAMION, 2078);
        service.guardarParqueo(newParking);

        newParking = new Parqueo(2, VehiculoEnum.MOTO, 190);
        service.guardarParqueo(newParking);
        
        newParking = new Parqueo(3, VehiculoEnum.CARRO, 200);
        service.guardarParqueo(newParking);

        for (Parqueo p : service.listParqueo()) {
            System.out.println(p.toString());
            System.out.println(service.calculateFee(p));
        }
    }
}
