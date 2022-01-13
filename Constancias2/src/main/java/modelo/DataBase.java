package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.pool.OracleDataSource;
import oracle.jdbc.OracleConnection;
import java.sql.DatabaseMetaData;

/**
 * @author ing. Atzin Antonio Acosta Zavala
 * @contact ing.AntonioAcosta@gmail.com
 *
 */
public class DataBase {

    //Atributos:
    final static String DB_URL = "jdbc:oracle:thin:@sdbtest_high?TNS_ADMIN=C:/Users/Tzinacantli/Documents/SD/base/wallets/Wallet_SDBtest/";
    final static String DB_USER = "ADMIN";
    final static String DB_PASSWORD = "docenteAZC2021";

    OracleConnection conexion;

//    String url = "jdbc:mysql://10.5.50.99:3306/";
//    String user = "admin";
//    String pass = "876036";
//    String schema = "docencia";
//    String driver = "com.mysql.cj.jdbc.Driver";
//    Connection conexion;
//    String url = "jdbc:mysql://localhost:3306/";
//    String user = "root";
//    String pass = "Chiscu57";
//    String schema = "docencia";
//    String driver = "com.mysql.jdbc.Driver";
//    Connection ;
    //Constructores:
    public DataBase() {
        try {
            conectar();
            System.out.println("db creada");
        } catch (SQLException e) {
            System.out.println("No se pudo conectar");
        }

    }

    //Métodos
//    public void conectar(){
//        try {
//            if (conexion == null || conexion.isClosed()) {
//                Class.forName(driver);
//                this.conexion = DriverManager.getConnection(url + schema, user, pass);
//            }
//        } catch (SQLException sQLException) {
//            System.out.println("No se pudo conectar");
//        } catch (ClassNotFoundException classNotFoundException) {
//            System.out.println("Clas no found e:"+classNotFoundException.getMessage());
//        }
//    }
    public void conectar() throws SQLException {
        
        if (conexion == null || conexion.isClosed()) {
        Properties info = new Properties();
        info.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER);
        info.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASSWORD);
        info.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH, "20");

        OracleDataSource ods = new OracleDataSource();
        ods.setURL(DB_URL);
        ods.setConnectionProperties(info);

        conexion = (OracleConnection) ods.getConnection();
        // Get the JDBC driver name and version 
        DatabaseMetaData dbmd = conexion.getMetaData();
        System.out.println("Driver Name: " + dbmd.getDriverName());
        System.out.println("Driver Version: " + dbmd.getDriverVersion());
        // Print some connection properties
        System.out.println("Default Row Prefetch Value is: "
                + conexion.getDefaultRowPrefetch());
        System.out.println("Database Username is: " + conexion.getUserName());
        System.out.println();
        // Perform a database operation 
//            printConstancias(connection);
        this.conexion = conexion;
        }
    }

//    public void reConectar() throws SQLException {
//        this.conexion.close();
//        this.conexion = DriverManager.getConnection(url + schema, user, pass);
//    }
    public void cerrarConexion() throws SQLException {
        this.conexion.close();
    }

    //Getters & Setters:
    public Connection getConexion() {
        return conexion;
    }

    public boolean isConectada() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            return false;
        } else {
            return true;
        }
    }

}
