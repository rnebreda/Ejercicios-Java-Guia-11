/*
Por último, del espectador, nos interesa saber su
nombre, edad y el dinero que tiene disponible.
 */
package entidades;

import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class Espectador {
    private String nombre;
    private int edad;
    private double dinero;
    private Asiento ticket;

    public Espectador(String nombre, int edad, double dinero, Asiento ticket) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
        this.ticket = ticket;
    }

    public Espectador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public Asiento getTicket() {
        return ticket;
    }

    public void setTicket(Asiento ticket) {
        this.ticket = ticket;
    }
    
        public static Comparator<Espectador> compararMenor = new Comparator<Espectador>() {
        @Override
        public int compare(Espectador t, Espectador t1) {
          return t.getNombre().compareTo(t1.getNombre());
        }
    };
    
}
