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
    private Map<String,Boolean> sala;
    private double precio;

    public Cine(Pelicula pelicula, Map sala, double precio) {
        this.pelicula = pelicula;
        this.sala = sala;
        this.precio = precio;
    }

    public Cine() {
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Map getSala() {
        return sala;
    }

    public void setSala(Map sala) {
        this.sala = sala;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
