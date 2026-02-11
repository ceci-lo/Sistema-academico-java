
package sistemaacademico;

import java.util.ArrayList;

/**
 *
 * @author ceci-lo
 */
public class Materia {
    private String idMateria;
    private String nombreMateria;
    private ArrayList<Alumno> alumnosInscriptos; 

    public Materia() {
    }

    public Materia(String idMateria, String nombreMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
    }

    public String getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(String idMateria) {
        this.idMateria = idMateria;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }
      // Método para matricular
    public void matricularAlumno(Alumno alumno) {
        this.alumnosInscriptos.add(alumno);
    }
    
    // Método para desmatricular
    public void desmatricularAlumno(int legajo) {
        alumnosInscriptos.removeIf(a -> a.getNroLegajo() == legajo);
    }

    @Override
    public String toString() {
        return "Materia \n" + "id Materia: " + idMateria + ", nombreMateria: " + nombreMateria;
    }
    
    
}
