/*
Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica 
si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero 
debe ser entre 1 y 6. Si no está en este rango, por defecto será 6. 
Métodos:
• disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
devuelve true, sino false.
 */
package servicios;

import entidades.Jugador;


/**
 *
 * @author Usuario
 */
public class JugadorServicio {

    private RevolverServicio rs = new RevolverServicio();

    public boolean disparo(Jugador j) {
        if (rs.mojar()) {
            j.setMojado(true);
            return true;
        } else {
            rs.siguienteChorro();
            return false;
        }
    }
}


