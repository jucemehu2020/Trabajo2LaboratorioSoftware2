package domain.access;

import domain.Parqueo;
import java.util.List;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public interface IParqueoRepository {
    boolean save(Parqueo newParking);

    List<Parqueo> list();
}
