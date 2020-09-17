package domain;

import java.util.Date;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public class Parqueo {
    
    private int parqueoId;
    private VehiculoEnum tipoVehiculo;
    private int MinutosParqueo;

    public Parqueo(int parqueoId, VehiculoEnum tipoVehiculo, int MinutosParqueo) {
        this.parqueoId = parqueoId;
        this.tipoVehiculo = tipoVehiculo;
        this.MinutosParqueo = MinutosParqueo;
    }

    public Parqueo() {
        
    }

    public int getParqueoId() {
        return parqueoId;
    }

    public VehiculoEnum getTipoVehiculo() {
        return tipoVehiculo;
    }

    public int getMinutosParqueo() {
        return MinutosParqueo;
    }

    public void setParqueoId(int parqueoId) {
        this.parqueoId = parqueoId;
    }

    public void setTipoVehiculo(VehiculoEnum tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setMinutosParqueo(int MinutosParqueo) {
        this.MinutosParqueo = MinutosParqueo;
    }
    
    @Override
    public String toString() {
        return "Ingreso: " + parqueoId + ", tipo de vehículo: " + 
                tipoVehiculo.toString().toLowerCase()+ ", tiempo =  " + MinutosParqueo + " minutos";
    }
}
