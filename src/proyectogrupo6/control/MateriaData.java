
package proyectogrupo6.control;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectogrupo6.Modelos.Materia;

/**
 * @author Grupo 6 
 * Fernandez Valentina 
 * Amieva Agustina 
 * Romero Jorge 
 * Gutierrez Manuel
 */
public class MateriaData {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private Connection con = null;
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public MateriaData(Conexion conexion) {
        con = conexion.getConexion();
    }
    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------
    public boolean agregarMateria(Materia materia) {
        boolean insert = true;
        String sql = "INSERT INTO materia (nombre, anio, activo) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isActivo());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                materia.setIdMateria(rs.getInt(1));
            } else {
                insert = false;
            }
            ps.close();
        } catch (SQLException ex) {
            insert = false;
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "Ya existe esa materia ");
            } else {
                JOptionPane.showMessageDialog(null, "Error de sintaxis " + ex);
            }
        }
        return insert;
    }
    
    public List<Materia> obtenerMaterias() {
        ArrayList<Materia> todasLasMaterias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM materia WHERE activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            Materia unaMateria;
            while (resultSet.next()) {
                unaMateria = new Materia();
                unaMateria.setNombre(resultSet.getString("Nombre"));
                unaMateria.setAnio(resultSet.getInt("anio"));
                unaMateria.setActivo(resultSet.getBoolean("Activo"));
                unaMateria.setIdMateria(resultSet.getInt("idMateria"));
                todasLasMaterias.add(unaMateria);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener materia");
        }
        return todasLasMaterias;
    }
    
    public Materia obtenerMateriaXId(int id) {
        Materia unaMateria = null;
        try {
            String sql = "SELECT * FROM materia WHERE idMateria = ? AND activo = 1;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                unaMateria = new Materia();
                unaMateria.setNombre(resultSet.getString("Nombre"));
                unaMateria.setAnio(resultSet.getInt("anio"));
                unaMateria.setActivo(resultSet.getBoolean("Activo"));
                unaMateria.setIdMateria(resultSet.getInt("idMateria"));                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener materia");
        }
        return unaMateria;
    }
    
    public boolean borrarMateria(int id) {
        boolean borrado = false;
        String sql = "UPDATE materia SET activo = 0 WHERE idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                borrado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis ");
        }
        return borrado;
    }
    
    public boolean modificarMateria(Materia materia) {
        String sql = "UPDATE materia SET nombre = ?, anio = ?, activo = ? WHERE idMateria = ?";
        boolean modificado = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, materia.getNombre());
            ps.setInt(2, materia.getAnio());
            ps.setBoolean(3, materia.isActivo());
            ps.setInt(4, materia.getIdMateria());

            if (ps.executeUpdate() != 0) {
                modificado = true;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error de sintaxis ");
        }
        return modificado;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
}