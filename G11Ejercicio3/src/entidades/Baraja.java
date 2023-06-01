/*
La baraja estará compuesta por un conjunto de cartas, 40 exactamente.
 */
package entidades;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Baraja {
    private List<Carta> cartas;

    public Baraja(List<Carta> cartas) {
        this.cartas = cartas;
    }

    public Baraja() {
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(List<Carta> cartas) {
        this.cartas = cartas;
    }
    
    
    
}
