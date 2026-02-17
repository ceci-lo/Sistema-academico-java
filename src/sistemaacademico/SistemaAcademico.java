
package sistemaacademico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ceci-lo
 */
public class SistemaAcademico {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        ArrayList<Materia> materias = new ArrayList<Materia>();

        MenuAgregarMateria();
        int opcionSeleccionada = sc.nextInt();
        sc.nextLine();

        if (opcionSeleccionada == 1) {
            System.out.println("Usted seleccionó la opcion de registrar materia\n");
            System.out.println("Por favor ingrese el id (tres letras que especifican el nombre de la materia) y el nombre de la materia en sí\n");
            System.out.println("Ingrese el id :");
            String idMat = sc.nextLine();

            System.out.println("Ingrese el nombre de la materia :");
            String nomMat = sc.nextLine();

            Materia m1 = new Materia(idMat, nomMat);
            materias.add(m1);

            System.out.println("Usted ha creado la materia : " + nomMat + " exitosamente. \n");
            int opcionSeleccionadaGM;
            do {
                MenuGestionarMateria();
                opcionSeleccionadaGM = sc.nextInt();
                sc.nextLine();
                //Matricular alumno
                if (opcionSeleccionadaGM == 1) {

                    int nro;
                    do {
                        MatricularAlumno(m1, sc);
                        System.out.println("El alumno se ha matriculado exitosamente");
                        System.out.println("¿Desea matricular otro alumno a esta materia?: \n1. si\n2. volver al menu GESTION MATERIA ");
                        nro = sc.nextInt();
                        sc.nextLine();
                    } while (nro == 1);

                    System.out.println("Finalizó la matriculación de alumnos.\n");
                }
                //Desmatricular alumnos
            else if (opcionSeleccionadaGM == 2) {
                        System.out.println("Ingrese el nro de legajo del alumno a desmatricular");
                        int nroLegajo = sc.nextInt();
                        sc.nextLine();

                        DesmatricularAlumnos(nroLegajo, m1);
                         System.out.println("El alumno ha sido desmatriculado exitosamente");

                        }
            //Gestionar asistencia
            else if (opcionSeleccionadaGM == 3) {
                
                        //fecha
                        System.out.println("Ingrese la fecha de la clase (dd/MM/yyyy):");
                        String fechaAsis = sc.nextLine();
                        LocalDate fecha = LocalDate.parse(fechaAsis, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                        
                         System.out.println("Ingrese el id del alumno a cargar asistencia");
                          int idAlumno = sc.nextInt();
                         sc.nextLine();
                         
                        GestionarAsistencia(fecha, m1,idAlumno);
                     
                        }
              else if (opcionSeleccionadaGM == 4) {
                System.out.println("\n--- ALUMNOS INSCRIPTOS EN " + m1.getNombreMateria() + " ---");
                m1.mostrarListadosInscriptos();
                System.out.println();
            }
            //Opcion Salir
            else if (opcionSeleccionada == 9) {

                        System.out.println("Usted ha salido del menu inicio. Muchas Gracias.");

                    }
        }
        while (opcionSeleccionada != 9);
        sc.close();
    }
    }
    
    // MENUS 
    public static void MenuGestionarMateria() {
        System.out.println("MENÚ GESTIONAR MATERIA\n"
                + "==========================\n"
                + "1.- Matricular Alumno\n"
                + "2.- Desmatricular Alumno\n"
                + "3.- Gestionar Asistencia\n\n"
                + "-- Consultas\n"
                + "  4.- Listado de Inscriptos\n"
                + "  5.- Visualizar Asistencia\n"
                + "9.- Salir\n Ingrese una opción\n");

    }

    public static void MenuAgregarMateria() {
        System.out.println("MENÚ INICIO\n"
                + "==========================\n"
                + "1.- Registrar Materia\n"
                + "9.- Salir\n"
                + "Ingrese una opción:");
    }
    
    //GESTION DE ALUMNOS

    public static void MatricularAlumno(Materia materia, Scanner sc) {
        try {

            System.out.println("Ingrese legajo:");
            int nroLegajo = sc.nextInt();
            sc.nextLine();

            System.out.println("Ingrese apellido:");
            String apellido = sc.nextLine();

            System.out.println("Ingrese nombre:");
            String nombre = sc.nextLine();

            System.out.println("Ingrese fecha de nacimiento (dd/MM/yyyy):");
            String fechaNac = sc.nextLine();
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNac);

            System.out.println("Ingrese email:");
            String email = sc.nextLine();

            Alumno a = new Alumno(nroLegajo, apellido, nombre, fecha, email);
            materia.matricularAlumno(a);
            

        } catch (ParseException ex) {
            Logger.getLogger(SistemaAcademico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void DesmatricularAlumnos(int nroLegajo, Materia materia) {
        materia.desmatricularAlumno(nroLegajo);
        System.out.println("El alumno ha sido desmatriculado exitosamente");
    }
    
    //GESTION ASISTENCIA ALUMNOS
    public static void GestionarAsistencia(LocalDate fecha, Materia m ,int idAlumnoBuscado){
       
        
       Alumno alumnoAsistente = m.buscarAlumnosId(idAlumnoBuscado);
        
       Asistencia asistencia = new Asistencia(fecha, m);
       
       asistencia.cargarAsistencia(alumnoAsistente);
       
    }

}
