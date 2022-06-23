
package proyectogrupo6.control;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectogrupo6.Modelos.Alumno;

/**
 * @author Manuel Gutierrez
 */
public class AlumnoData {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private Connection conect = null;
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public AlumnoData(Conexion conexion){
        conect = conexion.getConexion();
    }
    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------
    public boolean agregarAlumno(Alumno alumno){
        boolean insert = true;
        String sql = "INSERT INTO alumno (nombre, apellido, fechNac, dni, activo) VALUES (?, ?, ?, ?, ?);";
        
        try{
            PreparedStatement ps = conect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setDate(3, Date.valueOf(alumno.getFechNac()));
            ps.setLong(4, alumno.getDni());
            ps.setBoolean(5, alumno.isActivo());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                alumno.setIdAlumno(rs.getInt(1));
            }else{
                insert = false;
            }
            
            ps.close();
            
        }catch(SQLException sqle) {
            insert = false;
            if(sqle instanceof SQLIntegrityConstraintViolationException){
                JOptionPane.showMessageDialog(null, "Error al Agregar Alumno! El Alumno ya Existe!");
            }else{
                JOptionPane.showMessageDialog(null, "Error al Agregar Alumno! Error de Sintaxis!" + sqle);
            }
        }
        
        return insert;
    }
    
    public ArrayList<Alumno> obtenerAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        Alumno alumno;
        
        try{
            String sql = "SELECT * FROM alumno WHERE activo = 1;";
            
            PreparedStatement ps = conect.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                alumno = new Alumno();
                
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechNac(rs.getDate("fechNac").toLocalDate());
                alumno.setDni(rs.getLong("dni"));
                alumno.setActivo(rs.getBoolean("activo"));
                
                alumnos.add(alumno);
            }
            ps.close();
        }catch(SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al Obtener Alumnos!");
        }
        
        return alumnos;
    }
    
    public Alumno obtenerAlumnoPorId(int id){
        Alumno alumno = null;
        
        try{
            String sql = "SELECT * FROM alumno WHERE idAlumno = ? AND activo = 1;";
            
            PreparedStatement ps = conect.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechNac(rs.getDate("fechNac").toLocalDate());
                alumno.setDni(rs.getInt("dni"));
                alumno.setActivo(rs.getBoolean("activo"));
            }
            rs.close();
        }catch(SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al Obtener Alumnos!");
        }
        
        return alumno;
    }
    
    public Alumno obtenerAlumnoPorDni(long dni){
        Alumno alumno = null;
        
        try{
            String sql = "SELECT * FROM alumno WHERE dni = ? AND activo = 1;";
            
            PreparedStatement ps = conect.prepareStatement(sql);
            
            ps.setLong(1, dni);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                alumno = new Alumno();
                alumno.setIdAlumno(rs.getInt("idAlumno"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setFechNac(rs.getDate("fechNac").toLocalDate());
                alumno.setDni(rs.getInt("dni"));
                alumno.setActivo(rs.getBoolean("activo"));
            }
            rs.close();
        }catch(SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error al Obtener Alumnos!");
        }
        
        return alumno;
    }
    
    public boolean borrarAlumno(int id){
        boolean borrado = false;
        try{
            String sql = "UPDATE alumno SET activo = 0 WHERE idAlumno = ?;";
            
            PreparedStatement ps = conect.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            if(ps.executeUpdate() != 0){
                borrado = true;
            }
            
            ps.close();
        }catch(SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error de Sintaxis!");
        }
        
        return borrado;
    }
    
    public boolean modificarAlumno(Alumno alumno){
        boolean modificado = false;
        
        try{
            String sql = "UPDATE alumno SET nombre = ?, apellido = ?, fechNac = ?, dni = ?, activo = ? WHERE idAlumno = ?";
            
            PreparedStatement ps = conect.prepareStatement(sql);
            
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setDate(3, Date.valueOf(alumno.getFechNac()));
            ps.setLong(4, alumno.getDni());
            ps.setBoolean(5, alumno.isActivo());
            ps.setInt(6, alumno.getIdAlumno());
            
            if(ps.executeUpdate() != 0){
                modificado = true;
            }
        }catch(SQLException sqle) {
            JOptionPane.showMessageDialog(null, "Error de Sintaxis!");
        }
        
        return modificado;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
}
