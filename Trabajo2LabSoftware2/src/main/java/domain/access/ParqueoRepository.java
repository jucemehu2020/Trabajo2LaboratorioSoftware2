package domain.access;

import domain.Parqueo;
import domain.VehiculoEnum;
import domain.service.Servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cristian Pinto,Julio Mellizo
 */
public class ParqueoRepository implements IParqueoRepository{

    private Connection conn;

    public ParqueoRepository() {
        initDatabase();
    }

    @Override
    public boolean save(Parqueo newParking) {

        try {
            //Validate product
            if (newParking == null || newParking.getMinutosParqueo()<= 0 || newParking.getTipoVehiculo() == null) {
                return false;
            }
            //this.connect();

            String sql = "INSERT INTO Parking ( ParqueoId, TipoVehiculo, MinutosParqueo ) "
                    + "VALUES ( ?, ?, ? )";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newParking.getParqueoId());
            pstmt.setString(2, newParking.getTipoVehiculo().name());
            pstmt.setDouble(3, newParking.getMinutosParqueo());
            pstmt.executeUpdate();
            //this.disconnect();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<Parqueo> list() {
        List<Parqueo> parking = new ArrayList<>();
        try {

            String sql = "SELECT ParqueoId, TipoVehiculo, MinutosParqueo FROM Parking";
            //this.connect();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Parqueo newParking = new Parqueo();
                newParking.setParqueoId(rs.getInt("ParqueoId"));
                String upperString = rs.getString("TipoVehiculo").toUpperCase();
                VehiculoEnum vehicleEnum = VehiculoEnum.valueOf(upperString);
                newParking.setTipoVehiculo(vehicleEnum);
                newParking.setMinutosParqueo(rs.getInt("MinutosParqueo"));

                parking.add(newParking);   

            }
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parking;
    }

    private void initDatabase() {
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS Parking (\n"
                + "	ParqueoId integer PRIMARY KEY,\n"
                + "	TipoVehiculo text NOT NULL,\n"
                + "	MinutosParqueo int\n"
                + ");";

        try {
            this.connect();
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            //this.disconnect();

        } catch (SQLException ex) {
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect() {
        // SQLite connection string
        //String url = "jdbc:sqlite:./mydatabase.db";
        String url = "jdbc:sqlite::memory:";

        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException ex) {
            Logger.getLogger(Servicios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void disconnect() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
