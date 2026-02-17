
package sistemaacademico;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author ceci-lo
 */
public class Asistencia {
   private LocalDate fecha ;
   private Materia materia;
   private ArrayList<Alumno> alumnosAsistencia;

    public Asistencia() {
    }

    public Asistencia(LocalDate fecha, Materia materia) {
        this.fecha = fecha;
        this.materia = materia;
        this.alumnosAsistencia = new ArrayList<Alumno>(); 
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public ArrayList<Alumno> getAlumnosAsistencia() {
        return alumnosAsistencia;
    }

    public void setAlumnosAsistencia(ArrayList<Alumno> alumnosAsistencia) {
        this.alumnosAsistencia = alumnosAsistencia;
    }
    
    
    public void cargarAsistencia(Alumno a){
            this.alumnosAsistencia.add(a);
       
    }
    public void mostrarListadosAsistencia() {
        Collections.sort(alumnosAsistencia,
                Comparator.comparing(Alumno::getApellido)
                        .thenComparing(Alumno::getNombre)
        );
        
        System.out.println("---------------------------------------------------------------\n"
                + "Programación Básica - Alumnos Asistencia 2026"+ this.fecha
                + "\n--------------------------------------------------------------\n"
                + "Legajo | Apellido, Nombre\n");
        
        alumnosAsistencia.forEach(alumno -> System.out.println(alumno.getNroLegajo() + " | " + alumno.getApellido() + ", " + alumno.getNombre()));
      
        System.out.println("---------------------------------------------------------------\n");
        System.out.println("TOTAL ASISTENTES: " + alumnosAsistencia.size());
    }
    
    @Override
    public String toString() {
        return "Asistencia\n" + "fecha: " + fecha + ", materia: " + materia + ", alumnosAsistencia=" + alumnosAsistencia + '}';
    }
   
   
}
