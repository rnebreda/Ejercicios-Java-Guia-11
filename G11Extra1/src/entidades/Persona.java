/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private int documento;
    private List<Perro> mascota;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, int documento, List<Perro> mascota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.mascota = mascota;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public List<Perro> getMascota() {
        return mascota;
    }

    public void setMascota(List<Perro> mascota) {
        this.mascota = mascota;
    }

    @Override
    public String toString() {
        return "nombre= " + nombre + ", apellido= " + apellido + ", edad= " + edad + ", documento= " + documento + ", mascota=" + mascota + '}';
    }


    
    
}
