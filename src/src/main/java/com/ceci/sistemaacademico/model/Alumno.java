/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.main.java.com.ceci.sistemaacademico.model;

import java.time.LocalDate;

/**
 *
 * @author cecilia
 */
public class Alumno extends Persona {

    private int idLegajo;

    public Alumno(int idLegajo, int IDPersona, String nombre, String apellido, long dni) {
        super(IDPersona, nombre, apellido, dni);
        this.idLegajo = idLegajo;
    }

    public Alumno(int IDPersona, String nombre, String apellido, long dni, LocalDate fechaNacimiento, String lugarNacimiento, int idLegajo) {

        super(IDPersona, nombre, apellido, dni, fechaNacimiento, lugarNacimiento);
        this.idLegajo = idLegajo;

    }

    public int getIdLegajo() {
        return idLegajo;
    }

    public void setIdLegajo(int idLegajo) {
        this.idLegajo = idLegajo;
    }

    @Override
    public String toString() {
        return "id Legajo: " + idLegajo;
    }

}
