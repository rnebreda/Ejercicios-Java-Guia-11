/*
Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y 
Revolver
Métodos:
• llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
y el revolver para guardarlos en los atributos del juego.
• ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
mojar. Al final del juego, se debe mostrar que jugador se mojó.
Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
 */
package servicios;

import entidades.Jugador;
import entidades.Juego;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class JuegoServicio {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");
    public Juego juego;
    RevolverServicio rs = new RevolverServicio();

    public void llenarJuego() {
        boolean control = false;
        List<Jugador> ls = new ArrayList();

        do {
            System.out.println("Ingrese la cantidad de Jugadores (1 a 6)");
            int cant = leer.nextInt();
            if (0 < cant && cant <= 6) {
                for (int i = 1; i <= cant; i++) {
                    Jugador j = new Jugador(i);
                    ls.add(j);
                }
                control = true;
            }
        } while (!control);
        juego = new Juego(ls, rs.llenarRevolver());
    }

    public void ronda() {
        int posJugador = ((int) (Math.random() * juego.getJugadores().size()) + 1);
        Jugador j;
        boolean terminado = false;
        do {
            if (posJugador == juego.getJugadores().size()) {
                posJugador = 0;
            }
            j = juego.jugadores.get(posJugador);
            System.out.println("Es el turno del Jugador: "+j.getNombre());

            if (!rs.mojar()) {
                System.out.println("No se moja, pasa al siguiente jugador");
                rs.siguienteChorro();
                posJugador++;

            } else {
                j.setMojado(true);
                terminado=true;
            }
        } while (!terminado);
        System.out.println("El jugador mojado es: "+j.getNombre());
    }
}
