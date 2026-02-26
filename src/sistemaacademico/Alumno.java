
package sistemaacademico;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author rescatemio
 */
public class Alumno  {
    private int nroLegajo;//id
    private String apellido;
    private String nombre;
    private Date fechaNacimiento;
    private String email;

    public Alumno() {
    }

    public Alumno(int nroLegajo, String apellido, String nombre, Date fechaNacimiento, String email) {
        this.nroLegajo = nroLegajo;
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public int getNroLegajo() {
        return nroLegajo;
    }

    public void setNroLegajo(int nroLegajo) {
        this.nroLegajo = nroLegajo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Alumno: \n" + "nroLegajo: " + nroLegajo + "\napellido: " + apellido + "\nnombre: " + nombre + "\nfechaNacimiento: " + fechaNacimiento + "\nemail: " + email;
    }
    
    
    
    
}
