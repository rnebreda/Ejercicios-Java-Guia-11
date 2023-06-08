/*
Para representar la sala con los espectadores vamos a utilizar una matriz. Los asientos son 
etiquetados por una letra y un número la fila A1 empieza al final del mapa como se muestra en 
la tabla. También deberemos saber si el asiento está ocupado por un espectador o no, si esta 
ocupado se muestra una X, sino un espacio vacío.
8 A X | 8 B X | 8 C X | 8 D | 8 E X | 8 F X
7 A X | 7 B X | 7 C X | 7 D X | 7 E | 7 F X
6 A X | 6 B X | 6 C | 6 D X | 6 E X | 6 F 
5 A X | 5 B X | 5 C X | 5 D X | 5 E X | 5 F X
4 A X | 4 B X | 4 C X | 4 D X | 4 E X | 4 F X
3 A X | 3 B X | 3 C X | 3 D | 3 E X | 3 F X
2 A X | 2 B | 2 C X | 2 D X | 2 E X | 2 F 
1 A X | 1 B X | 1 C X | 1 D X | 1 E X | 1 F X
Se debe realizar una pequeña simulación, en la que se generen muchos espectadores y se los
ubique en los asientos aleatoriamente (no se puede ubicar un espectador donde ya este
ocupado el asiento).
Los espectadores serán ubicados de uno en uno y para ubicarlos tener en cuenta que sólo se
podrá sentar a un espectador si tiene el dinero suficiente para pagar la entrada, si hay espacio
libre en la sala y si tiene la edad requerida para ver la película. En caso de que el asiento este
ocupado se le debe buscar uno libre.
Al final del programa deberemos mostrar la tabla, podemos mostrarla con la letra y numero de
cada asiento o solo las X y espacios vacíos.
 */
package servicios;

import entidades.Asiento;
import entidades.Cine;
import entidades.Espectador;
import entidades.Pelicula;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author Usuario
 */
public class CineServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    Map<Asiento, Boolean> sala = new TreeMap(Asiento.compararMayor);
    List<Espectador> espectadores = new ArrayList();
    public Cine cine;
    final int filas = 8;
    String[] columnas = {"A", "B", "C", "D", "E", "F"};

    public void crearCine() {

        Pelicula p = new Pelicula("ET", 120, 16, "Spilberg");

        for (int i = 1; i <= filas; i++) {
            for (int j = 0; j < columnas.length; j++) {
                Asiento aux = new Asiento();
                aux.setFilaColumna(String.valueOf(i) + columnas[j]);
                Boolean ocupado = false;
                sala.put(aux, ocupado);
            }

        }
        cine = new Cine(p, sala, 1000, filas * columnas.length);
        mostrarSala();

    }

    public void crearEspectadores() {
        Espectador aux;
        String esp;
        int cantidad = (int) (Math.random() * 60);
        for (int i = 1; i <= cantidad; i++) {
            if (i < 10) {
                esp = "0";
            } else {
                esp = "";
            }
            String nombre = "Espectador" + esp + i;
            int edad = (int) (Math.random() * 100);
            int dinero = (int) (Math.random() * 10000);
            aux = new Espectador(nombre, edad, dinero, null);
            espectadores.add(aux);
        }
        System.out.println("La cantidad de espectadores es: " + espectadores.size());
    }

    public void llenarSala(Cine c) {
        Asiento k = null, butaca = null;
        Boolean v, disponible = true;
        int indice = 0;
        Espectador aux;
        Collections.shuffle(espectadores);
        Iterator<Espectador> it = espectadores.iterator();
        List<Asiento> ls = new ArrayList(sala.keySet());
        Collections.shuffle(ls);

        while (it.hasNext()) {
            aux = it.next();
            disponible = true;
            if (aux.getEdad() >= c.getPelicula().getEdadMin()) {

                if (aux.getDinero() >= c.getPrecio()) {

                    if (c.getAsientosDisponibles() > 0) {
                        if (sala.containsKey(ls.get(indice))) {
                            for (Map.Entry<Asiento, Boolean> entry : c.getSala().entrySet()) {
                                if (entry.getKey().equals(ls.get(indice)) && !entry.getValue() && disponible) {
                                    k = entry.getKey();
                                    entry.setValue(true);
                                    v = entry.getValue();
                                    //indice = entry.hashCode();
                                    c.setAsientosDisponibles(c.getAsientosDisponibles() - 1);
                                    disponible = false;
                                    break;
                                }
                            }

                        } else {

                            for (Map.Entry<Asiento, Boolean> e : c.getSala().entrySet()) {
                                if (!e.getValue() && disponible) {
                                    k = e.getKey();
                                    e.setValue(true);
                                    v = e.getValue();
                                    //indice = entry.hashCode();
                                    c.setAsientosDisponibles(c.getAsientosDisponibles() - 1);
                                    disponible = false;
                                    break;

                                } else {
                                    System.out.println("No quedan asientos disponibles");
                                }
                            }
                        }
                    }

                } else {
                    System.out.println(aux.getNombre() + ": No tiene suficiente dinero. Disponible: " + aux.getDinero());
                }
            } else {
                System.out.println(aux.getNombre() + ": No tiene suficiente edad para esta película. Edad: " + aux.getEdad());
            }
            if (!disponible) {
                aux.setTicket(k);
                aux.setDinero(aux.getDinero() - 1000);
                sala.put(k, true);
                c.setSala(sala);
            }
            indice++;

        }
    }

    public void mostrarSala() {
        int aux = 1;
        String k = "";
        Boolean v = false;

        for (Map.Entry<Asiento, Boolean> entry : sala.entrySet()) {
            k = entry.getKey().getFilaColumna();
            v = entry.getValue();

            System.out.print(k);
            if (v) {
                System.out.print("X ");
            } else {
                System.out.print("0 ");
            }
            if ((aux % columnas.length) == 0) {
                System.out.println("");
            }
            aux++;
        }
    }

    public void mostrarEspectadores() {
        Collections.sort(espectadores, Espectador.compararMenor);
        for (Espectador e : espectadores) {
            if (e.getTicket() == null) {
                System.out.println(e.getNombre() + " Sin ticket" + " disponible= " + e.getDinero());
            } else {
                System.out.println(e.getNombre() + " " + e.getTicket() + " disponible= " + e.getDinero());
            }
        }

    }
}
