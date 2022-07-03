
package proyectogrupo6.Modelos;

/**
 * @author Grupo 6 
 *  Fernandez Valentina
 *  Amieva Agustina
 *  Romero Jorge
 *  Gutierrez Manuel
 */
public class Materia {
    //                                              ATRIBUTOS
    //---------------------------------------------------------------------------------------------------------------
    private int idMateria;
    private String nombre;
    private int anio;
    private boolean activo;
    //                                  CONSTRUCTORES, GETTERS Y SETTERS
    //---------------------------------------------------------------------------------------------------------------
    public Materia() {}

    public Materia(String nombre, int anio, boolean activo) {
        this.nombre = nombre;
        this.anio = anio;
        this.activo = activo;
    }

    public Materia(int idMateria, String nombre, int anio, boolean activo) {
        this.idMateria = idMateria;
        this.nombre = nombre;
        this.anio = anio;
        this.activo = activo;
    }
    
    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    //                                          METODOS PUBLICOS
    //---------------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return nombre + " (" + anio + ')';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.idMateria;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Materia other = (Materia) obj;
        if (this.idMateria != other.idMateria) {
            return false;
        }
        return true;
    }
    //                                          METODOS PRIVADOS
    //---------------------------------------------------------------------------------------------------------------
    
}
