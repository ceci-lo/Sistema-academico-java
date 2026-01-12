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
public class Persona {
   private int IDPersona;
   private String nombre;
   private String apellido;
   private long dni;
   private LocalDate fechaNacimiento;
   private String lugarNacimiento;

    public Persona(int IDPersona, String nombre, String apellido, long dni, LocalDate fechaNacimiento, String lugarNacimiento) {
        this.IDPersona = IDPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
        this.lugarNacimiento = lugarNacimiento;
    }

    public Persona(int IDPersona, String nombre, String apellido, long dni) {
        this.IDPersona = IDPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public int getIDPersona() {
        return IDPersona;
    }

    public void setIDPersona(int IDPersona) {
        this.IDPersona = IDPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    @Override
    public String toString() {
        return " La persona con: " + "IDPersona= " + IDPersona + ", nombre= " + nombre + ", apellido= " + apellido + ", dni= " + dni + ", fechaNacimiento= " + fechaNacimiento + ", lugarNacimiento= " + lugarNacimiento ;
    }
   
   


}
