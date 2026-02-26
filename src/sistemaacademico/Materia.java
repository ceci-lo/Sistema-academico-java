package sistemaacademico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author ceci-lo
 */
public class Materia    {

    private String idMateria;
    private String nombreMateria;
    private Set <Alumno> alumnosInscriptos;

    public Materia() {
    }

    public Materia(String idMateria, String nombreMateria) {
        this.idMateria = idMateria;
        this.nombreMateria = nombreMateria;
        this.alumnosInscriptos = new HashSet<Alumno>();
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

    public Set<Alumno> getAlumnosInscriptos() {
        return alumnosInscriptos;
    }

    //Metodo para mostrar alumnos matriculasdos a esa materia
    public void mostrarListadosInscriptos() {
      System.out.println("---------------------------------------------------------------\n"
                + "Programación Básica - Alumnos Inscriptos 2026"
                + "\n--------------------------------------------------------------\n"
                + "Legajo | Apellido, Nombre\n"
                + "\n--------------------------------------------------------------\n"
);
       alumnosInscriptos.stream()
        .sorted(Comparator.comparing(Alumno::getApellido)
                .thenComparing(Alumno::getNombre))
        .forEach(alumno -> System.out.println(
            alumno.getNroLegajo() + " | " + alumno.getApellido() + ", " + alumno.getNombre()
        ));
        System.out.println("---------------------------------------------------------------\n");
        System.out.println("TOTAL inscriptos: " + alumnosInscriptos.size());
    }
    
    //Busca Alumnos por id
    public Alumno buscarAlumnosId(int idBuscado) {
        Alumno aEncontrado = null;
        for(Alumno a : alumnosInscriptos){
            if(a.getNroLegajo() == idBuscado){
                aEncontrado = a;
            }
        }
        return aEncontrado;
    }
    
    public Asistencia cargarAsistencia(LocalDate fecha){

        return  new Asistencia(fecha, this);

    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (!Objects.equals(this.alumnosInscriptos, other.alumnosInscriptos)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Materia \n" + "id Materia: " + idMateria + ", nombreMateria: " + nombreMateria;
    }

   

}
