/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademico;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Materia> materias = new ArrayList<Materia>();

        MenuAgregarMateria();
        int opcionSeleccionada = sc.nextInt();
        sc.nextLine();

        if (opcionSeleccionada == 1) {
            System.out.println("USted seleccionó la opcion dde registrar materia\n");
            System.out.println("Por favor ingrese el id (tres letras que especifican el nombre de la materia) y el nombre de la materia en sí\n");
            System.out.println("Ingrese el id :");
            String idMat = sc.nextLine();
            System.out.println("Ingrese el nombrfe de la materia :");
            String nomMat = sc.nextLine();
            Materia m1 = new Materia(idMat, nomMat);
            materias.add(m1);

            System.out.println("Usted ha creado la materia : " + nomMat + " exitosamente. \n");

            MenuGestionarMateria();
            int opcionSeleccionadaGM = sc.nextInt();
            sc.nextLine();

            //Matricular alumno
            if (opcionSeleccionadaGM == 1) {
                
                  MatricularAlumno(m1,sc) ;
            }
        } else if (opcionSeleccionada == 9) {

            System.out.println("Usted ha salido del menu inicio. Muchas Gracias.");

        }
        sc.close();
    }

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
            
            
            
            Alumno a = new Alumno(nroLegajo,apellido,nombre,fecha,email);
            materia.matricularAlumno(a);
            
            
            sc.close();
        } catch (ParseException ex) {
            Logger.getLogger(SistemaAcademico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
