/*
De Cine nos interesa conocer la película que se está reproduciendo, la
sala con los espectadores y el precio de la entrada.
 */
package entidades;

import java.util.Map;

/**
 *
 * @author Usuario
 */
public class Cine {
    private Pelicula pelicula;
    private Map<Asiento,Boolean> sala;
    private double precio;
    private int asientosDisponibles;

    public Cine(Pelicula pelicula, Map<Asiento, Boolean> sala, double precio, int asientosDisponibles) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.precio = precio;
        this.asientosDisponibles = asientosDisponibles;
    }

    public Cine() {
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Map<Asiento, Boolean> getSala() {
        return sala;
    }

    public void setSala(Map<Asiento, Boolean> sala) {
        this.sala = sala;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

     
}
