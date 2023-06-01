/*
Las operaciones que podrá realizar la baraja son:
• barajar(): cambia de posición todas las cartas aleatoriamente.
• siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o 
se haya llegado al final, se indica al usuario que no hay más cartas.
• cartasDisponibles(): indica el número de cartas que aún se puede repartir.
• darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de 
cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero 
debemos indicárselo al usuario.
• cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna 
indicárselo al usuario
• mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y 
luego se llama al método, este no mostrara esa primera carta
 */
package servicios;

import entidades.Baraja;
import entidades.Carta;
import enums.Palos;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class BarajaServicio {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Baraja b = new Baraja();
    List<Carta> monton = new ArrayList();
    Palos[] e = enums.Palos.values();

    public void crearBaraja() {
        List<Carta> aux = new ArrayList();
        for (int i = 1; i <= 12; i++) {
            if (i != 8 && i != 9) {
                for (int j = 0; j < 4; j++) {
                    Carta c = new Carta(i, e[j]);
                    aux.add(c);
                }
            }

        }
        b.setCartas(aux);
    }
    
    public void barajar(){
     Collections.shuffle(b.getCartas());
    }
    
    public Carta siguienteCarta(){
        Carta c=null;
        if (b.getCartas().isEmpty()) {
            System.out.println("No hay cartas en la baraja");
        }else{
        c=b.getCartas().get(0);
        b.getCartas().remove(0);
        }
        return c;
    }
    
    public void cartasDisponibles(){
        System.out.println("La cantidad de Cartas en la baraja es: "+b.getCartas().size());
    }
    
    public void darCartas(){
        System.out.println("Ingrese la cantidad de cartas deseadas");
        int cantidad = leer.nextInt();
        if (cantidad>b.getCartas().size()) {
            System.out.println("No es posible dar esa cantidad de cartas");
        }else{
            for (int i = 0; i < cantidad; i++) {
                monton.add(siguienteCarta());
            }
        }
    }
    
    public void cartasMonton(){
        if (monton.isEmpty()) {
            System.out.println("No hay cartas en el montón");
        }else{
            for (Carta c : monton) {
                System.out.println(c.toString());
            }
        }
    }
    
    public void mostrarBaraja(){
        if (b.getCartas().isEmpty()) {
                       System.out.println("No hay cartas en el montón");
        }else{
            b.getCartas().forEach((c) -> {
                System.out.println(c.toString());
            });
        }
    }
}
