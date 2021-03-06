package proyectogrupo6.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import proyectogrupo6.Modelos.Alumno;
import proyectogrupo6.Modelos.Cursada;
import proyectogrupo6.Modelos.Materia;

/**
 * @author Grupo 6 
 *  Fernandez Valentina
 *  Amieva Agustina
 *  Romero Jorge
 *  Gutierrez Manuel
 */
public class CursadaData {

    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    
    private Connection con = null;
    private AlumnoData ad;
    private MateriaData md;

    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    
    public CursadaData(Conexion con) {
        this.con = con.getConexion();
        ad = new AlumnoData(con);
        md = new MateriaData(con);
    }
    
    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------

    public boolean agregarCursada(Cursada cursada) {

        boolean insert = true;

        String sql = "INSERT INTO cursada (idMateria, idAlumno, nota)"
                + "VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, cursada.getMateria().getIdMateria());
            ps.setInt(2, cursada.getAlumno().getIdAlumno());
            ps.setDouble(3, cursada.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cursada.setId(rs.getInt("id")); //podria ir el numero de la columna o el nombre -mejor esta ultima-
            } else {
                insert = false;
            }
            ps.close();

        } catch (SQLException ex) {
            insert = false;
            if (ex instanceof java.sql.SQLIntegrityConstraintViolationException) {
                JOptionPane.showMessageDialog(null, "La cursada ya existe!");
            } else {
                JOptionPane.showMessageDialog(null, "Error: " + ex);
            }
        }

        return insert;
    }

    public List<Cursada> obtenerCursadas() {

        ArrayList<Cursada> cursadas = new ArrayList<>();
        String sql = "SELECT * "
                + "FROM cursada";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Cursada cursada;

            while (rs.next()) {
                cursada = new Cursada();
                cursada.setId(rs.getInt("id"));
                cursada.setNota(rs.getDouble("nota"));

                Alumno alumno = ad.obtenerAlumnoPorId(rs.getInt("idAlumno"));
                cursada.setAlumno(alumno);

                Materia materia = md.obtenerMateriaXId(rs.getInt("idMateria"));
                cursada.setMateria(materia);

                cursadas.add(cursada);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }

        return cursadas;
    }

    public Cursada obtenerCursadaPorId(int id) {

        Cursada cursada = null;

        try {
            String sql = "SELECT * FROM cursada WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cursada = new Cursada();
                cursada.setId(rs.getInt("id"));
                cursada.setNota(rs.getDouble("nota"));

                Alumno alumno = ad.obtenerAlumnoPorId(rs.getInt("idAlumno"));
                cursada.setAlumno(alumno);

                Materia materia = md.obtenerMateriaXId(rs.getInt("idMateria"));
                cursada.setMateria(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }

        return cursada;
    }

    public boolean borrarCursada(int id) {

        boolean borrado = false;
        String sql = "DELETE FROM cursada "
                + "WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            if (ps.executeUpdate() != 0) {
                borrado = true;
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }

        return borrado;
    }

    public boolean borrarCursada(Alumno alumno, Materia materia) {

        boolean borrado = false;
        String sql = "DELETE FROM cursada "
                + "WHERE idAlumno = ? AND idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ps.setInt(2, materia.getIdMateria());
            if (ps.executeUpdate() != 0) {
                borrado = true;
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }

        return borrado;
    }

    public boolean actualizarNota(Alumno alumno, Materia materia, double nota) {

        boolean actualizado = false;
        String sql = "UPDATE cursada SET nota = ? WHERE idAlumno = ? AND idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, alumno.getIdAlumno());
            ps.setInt(3, materia.getIdMateria());
            if (ps.executeUpdate() != 0) {
                actualizado = true;
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }

        return actualizado;
    }

    //devuelve listado de alumnos inscriptos en base a materia
    
    public List<Alumno> obtenerAlumnosInscriptos(Materia materia) {

        ArrayList<Alumno> alumnos = new ArrayList<>();
        String sql = "SELECT alumno.idAlumno, nombre, apellido, dni "
                   + "FROM cursada, alumno "
                   + "WHERE idMateria = ? AND cursada.idAlumno = alumno.idAlumno";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, materia.getIdMateria());
            ResultSet rs = ps.executeQuery();
            Alumno alumno;
            while (rs.next()) {
                alumno = new Alumno();
                alumno.setNombre(rs.getString("nombre"));
                alumno.setApellido(rs.getString("apellido"));
                alumno.setDni(rs.getInt("dni"));
                alumno.setIdAlumno(rs.getInt("idalumno"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        return alumnos;
    }
    
    //Devuelve listado de alumnos NO inscriptos en materia
    public List<Alumno> obtenerAlumnosNoInscriptos(Materia materia){
        Alumno alumno;
        ArrayList<Alumno> alumnos = new ArrayList<>();
        ArrayList<Alumno> aInscriptos = (ArrayList) obtenerAlumnosInscriptos(materia);
        String sql = "SELECT idAlumno " //(o *)
                + "FROM alumno "
                + "WHERE idAlumno NOT IN (SELECT idAlumno FROM cursada WHERE idMateria = ?)";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, materia.getIdMateria());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                alumno = ad.obtenerAlumnoPorId(rs.getInt("idAlumno"));
                alumnos.add(alumno);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        return alumnos;
    }

    //Devuelve listado de materias Inscriptas en base a alumno
    public List<Materia> obtenerMateriasInscriptas(Alumno alumno) {

        ArrayList<Materia> materias = new ArrayList<>();
        String sql = "SELECT materia.idMateria, materia.nombre, materia.anio "
                + "FROM cursada, materia "
                + "WHERE idAlumno = ? AND cursada.idMateria = materia.idMateria";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()) {
                materia = new Materia();
                materia.setAnio(rs.getInt("anio"));
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materias.add(materia);
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        return materias;
    }
    
        //devuelve listado de materias NO inscriptas en base a alumno
    public List<Materia> obtenerMateriasNoInscriptas(Alumno alumno){
        
        ArrayList<Materia> materias = (ArrayList) obtenerMateriasInscriptas(alumno);
        ArrayList<Materia> materiasNI = new ArrayList<>();

        String sql = "SELECT idMateria " 
                   + "FROM materia "
                   + "WHERE materia.activo = 1 AND idMateria NOT IN (SELECT idMateria FROM cursada WHERE idAlumno = ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ResultSet rs = ps.executeQuery();
            Materia materia;
            while (rs.next()){
                materia = md.obtenerMateriaXId(rs.getInt("idMateria"));
                materiasNI.add(materia);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        } 
        return materiasNI;
    }
    
    /**
     * obtiene una nota
     * @param idAlu id del ALUMNO del que se quiere la nota
     * @param idMat id de la MATERIA donde tiene la nota el alumno
     * @return la nota o -1 si ocurre algun error
     */
    public double obtenerNotaDeAlumnoEnUnaMateria(int idAlu, int idMat){
        double nota = -1;
        
        String sql = "SELECT nota FROM cursada WHERE idAlumno = ? AND idMAteria = ?;";
        
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idAlu);
            ps.setInt(2, idMat);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                nota = rs.getDouble("nota");
            }
            
            ps.close();
        }catch (SQLException sqle){
            JOptionPane.showMessageDialog(null, "No se Pudo Obtener la Nota!");
        }
        
        return nota;
    }
    
    public List<Cursada> obtenerCursadaXAlumno(Alumno alumno) {
        Cursada cursada = null;
        ArrayList<Cursada> cursadas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM cursada WHERE idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cursada = new Cursada();
                cursada.setId(rs.getInt("id"));
                cursada.setNota(rs.getDouble("nota"));
                cursada.setAlumno(alumno);
                Materia materia = md.obtenerMateriaXId(rs.getInt("idMateria"));
                cursada.setMateria(materia);
                cursadas.add(cursada);
            }            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);
        }
        return cursadas;
    }

}
