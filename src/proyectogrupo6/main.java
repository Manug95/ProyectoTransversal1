
package proyectogrupo6;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import proyectogrupo6.Modelos.Alumno;
import proyectogrupo6.Modelos.Cursada;
import proyectogrupo6.Modelos.Materia;
import proyectogrupo6.control.AlumnoData;
import proyectogrupo6.control.Conexion;
import proyectogrupo6.control.CursadaData;
import proyectogrupo6.control.MateriaData;

/**
 * @author Grupo 6 
 *  Fernandez Valentina
 *  Amieva Agustina
 *  Romero Jorge
 *  Gutierrez Manuel
 */
public class main {

    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        
        AlumnoData ad = new AlumnoData(conexion);
        MateriaData md = new MateriaData(conexion);
        CursadaData cd = new CursadaData(conexion);
        
        //nuevos alumnos
        Alumno valentina = new Alumno("Valentina", "Fernandez", LocalDate.of(2000, Month.JANUARY, 1), 12345678, true);
        Alumno jorge = new Alumno("Jorge", "Romero", LocalDate.of(2001, Month.FEBRUARY, 1), 87654321, true);
        Alumno manuel = new Alumno("Manuel", "Gutierrez", LocalDate.of(2002, Month.MARCH, 1), 12387654, true);
        
        /*if(ad.agregarAlumno(manuel)){
            JOptionPane.showMessageDialog(null, "Alumno Agregado con Éxito!");
        }
        if(ad.agregarAlumno(valentina)){
            JOptionPane.showMessageDialog(null, "Alumno Agregado con Éxito!");
        }
        if(ad.agregarAlumno(jorge)){
            JOptionPane.showMessageDialog(null, "Alumno Agregado con Éxito!");
        }
        */
        
        //nueva materia---------------------------------------------------------------------------------------------
        //Materia materia = new Materia("EDA", 1, true);
        
        /*if(md.agregarMateria(materia)){
            JOptionPane.showMessageDialog(null, "Materia Agregada con Éxito!");
        }else{
            JOptionPane.showMessageDialog(null, "Error al Agregar Materia!");
        }*/
        
        //inscribir los alumnos en una materia-----------------------------------------------------------------------
        /*Alumno alumno = ad.obtenerAlumnoPorId(4);
        Materia materia = md.obtenerMateriaXId(1);
        Cursada cursada = new Cursada(materia, alumno, 10);
        
        if(cd.agregarCursada(cursada)){
            JOptionPane.showMessageDialog(null, "Cursada Agregada con Éxito!");
        }else{
            JOptionPane.showMessageDialog(null, "Error al Agregar Cursada!");
        }
        
        alumno = ad.obtenerAlumnoPorId(5);
        materia = md.obtenerMateriaXId(2);
        cursada = new Cursada(materia, alumno, 10);
        
        if(cd.agregarCursada(cursada)){
            JOptionPane.showMessageDialog(null, "Cursada Agregada con Éxito!");
        }else{
            JOptionPane.showMessageDialog(null, "Error al Agregar Cursada!");
        }
        
        alumno = ad.obtenerAlumnoPorId(6);
        materia = md.obtenerMateriaXId(3);
        Cursada cursada2 = new Cursada(materia, alumno, 10);
        
        if(cd.agregarCursada(cursada2)){
            JOptionPane.showMessageDialog(null, "Cursada Agregada con Éxito!");
        }else{
            JOptionPane.showMessageDialog(null, "Error al Agregar Cursada!");
        }
        */
        
        //borrar una cursada-----------------------------------------------------------------------------------------
        /*if(cd.borrarCursada(3)){
            JOptionPane.showMessageDialog(null, "Cursada Borrada con Éxito!");
        }else{
            JOptionPane.showMessageDialog(null, "Error al Borrar Cursada!");
        }*/
        
        //listar materias y alumnos-----------------------------------------------------------------------------------
        /*ArrayList<Alumno> alumnos = ad.obtenerAlumnos();
        ArrayList<Materia> materias = (ArrayList<Materia>)md.obtenerMaterias();
        
        for(Alumno a : alumnos){
            System.out.println(a);
        }
        for(Materia m : materias){
            System.out.println(m);
        }
        */
        
        Alumno alumno = ad.obtenerAlumnoPorId(4);
        //ArrayList<Materia> materiasI = (ArrayList<Materia>)cd.obtenerMateriasInscriptas(alumno);
        ArrayList<Materia> materiasNI = (ArrayList<Materia>)cd.obtenerMateriasNoInscriptas(alumno);
        for(Materia m : materiasNI){
            System.out.println(m);
        }
        
    }

}
