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
        public void crearJugadores() {
        boolean control = false;
        List<Jugador> ls=new ArrayList();
        RevolverServicio rs=new RevolverServicio();
        //Revolver r = rs.cargarRevolver();
        do {
            System.out.println("Ingrese la cantidad de Jugadores (1 a 6)");
            int cant = leer.nextInt();
            if (0 > cant && cant <= 6) {
                for (int i = 0; i < cant; i++) {
                    Jugador j = new Jugador(i + 1);
                    ls.add(j);
                }
                control = true;
            }
        } while (!control);
        Juego juego = new Juego(ls,rs.cargarRevolver());
    }
        
        public void ronda(){
    //Falta
}
    
}
