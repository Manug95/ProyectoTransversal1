package proyectogrupo6.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private String url = "jdbc:mysql://localhost/universidadg6";
    private String usuario = "root";
    private String password = "";

    private Connection conexion;

    public Conexion() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            JOptionPane.showMessageDialog(null, "Driver de Conexión Cargado!");
        }catch (ClassNotFoundException cnfe) {
            JOptionPane.showMessageDialog(null, "Error al Cargar Driver de Conexión!");
        }
    }

    public Connection getConexion() {
        try{
            if (conexion == null) {
            // Setup the connection with the DB
            conexion = DriverManager
                    .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + password);
            }
            JOptionPane.showMessageDialog(null, "Conexión Exitosa a la Base de Datos!");
        } catch(SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al Conectarse a la Base de Datos!");
        }
        
        return conexion;
    }
}
