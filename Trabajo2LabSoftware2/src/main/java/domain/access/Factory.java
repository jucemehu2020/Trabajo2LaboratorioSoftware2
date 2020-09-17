package domain.access;

import domain.CRedondeo;
import domain.TCarro;
import domain.TMoto;
import domain.TCamion;
import domain.VehiculoEnum;
import java.util.EnumMap;
import java.util.Map;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public class Factory {

    private Map<VehiculoEnum, CRedondeo> diccionarioParqueo;

    // Singleton
    private static Factory instance;

    private Factory() {
        diccionarioParqueo = new EnumMap<>(VehiculoEnum.class);
        diccionarioParqueo.put(VehiculoEnum.CAMION, new TCamion());
        diccionarioParqueo.put(VehiculoEnum.CARRO, new TCarro());
        diccionarioParqueo.put(VehiculoEnum.MOTO, new TMoto());
        // Si se requie otro vehículo, se abre un registro en este diccionario
        // No se viola el principio porque este este modulo no está pensado
        // para que sea estable.
    }

    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public CRedondeo getVehiculo(VehiculoEnum vehiculo) {

        CRedondeo result = null;

        if (diccionarioParqueo.containsKey(vehiculo)) {
            result = diccionarioParqueo.get(vehiculo);
        }

        return result;

    }
     public IParqueoRepository getRepository(String type) {

        IParqueoRepository result = null;

        switch (type) {
            case "default":
                result = new ParqueoRepository();
                break;
        }

        return result;

    }
}