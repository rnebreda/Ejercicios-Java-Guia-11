/*
Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
persona.
Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
personas con sus respectivos perros
 */
package servicio;

import entidades.Perro;
import entidades.Persona;
import enumeraciones.Raza;
import enumeraciones.Tamanio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Usuario
 */
public class PersonaServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    List<Persona> personas = new ArrayList();
    List<Perro> enAdopcion = new ArrayList();
    String[] nombresDePerros = {"Cacho", "Cholo", "Chacho", "Chicho", "Checho"};
    //List<String> nombres=new ArrayList();
    //List<String> apellidos=new ArrayList();
    Raza[] razas = enumeraciones.Raza.values();
    Tamanio[] tamanios = enumeraciones.Tamanio.values();

    public void crearPerros() {
        Raza raza;
        Tamanio tamanio;
        int edad, randomRaza, randomTamanio;
        for (String nombre : nombresDePerros) {
            randomRaza = (int) (Math.random() * razas.length);
            raza = razas[randomRaza];
            randomTamanio = (int) (Math.random() * tamanios.length);
            tamanio = tamanios[randomTamanio];
            edad = (int) (Math.random() * 20);
            Perro p = new Perro(nombre, raza, edad, tamanio);
            enAdopcion.add(p);
        }
    }

    public void listarPerros() {
        for (Perro p : enAdopcion) {
            System.out.println(p.toString());
        }
    }

    public void crearPersonas() {
        String nombre, apellido;
        int edad, documento;
        do {
            System.out.println("Ingrese Nombre y Apellido");
            nombre = leer.next();
            apellido = leer.next();
            edad = (int) (Math.random() * 100);
            documento = (int) (Math.random() * 100000);
            Persona p = new Persona(nombre, apellido, edad, documento, null);
            personas.add(p);
            System.out.println("Desea ingresar otra Persona? (S=Si)");
        } while (leer.next().equalsIgnoreCase("S"));
    }

    public void listarPersonas() {
        for (Persona p : personas) {
            System.out.println(p.toString());
        }
    }

    public void adoptarPerro() {
        Persona aux;
        Perro auxPerro;
        String nombre, elegido;

        Iterator<Persona> it = personas.iterator();
        Iterator<Perro> ip = enAdopcion.iterator();
        List<Perro> ls = new ArrayList();
        boolean salida = false, encontrado = false, enLista = false;

        if (personas.isEmpty()) {
            System.out.println("Debe darse de alta en la Lista antes de adoptar");
        }
        System.out.println("Ingrese su nombre");
        nombre = leer.next();

        while (it.hasNext()) {
            aux = it.next();
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                enLista = true;
                do {

                    if (enAdopcion.isEmpty()) {
                        System.out.println("No hay perros en adopcion en este momento");
                        salida = true;
                    } else {
                        encontrado = false;
                        elegido = null;
                        ip = enAdopcion.iterator();
                        while (ip.hasNext()) {
                            System.out.println(ip.next().toString());
                        }
                        System.out.println("Elija el nombre de un perro");
                        elegido = leer.next();
                        auxPerro = null;
                        ip = enAdopcion.iterator();

                        while (ip.hasNext()) {
                            auxPerro = ip.next();
                            if (auxPerro.getNombre().equalsIgnoreCase(elegido)) {
                                ls.add(auxPerro);
                                ip.remove();
                                encontrado = true;
                                System.out.println("Desea adoptar otro perro? (S=Si)");
                                salida = !(leer.next().equalsIgnoreCase("S"));
                                break;
                            }
                        }
                        if (!encontrado) {
                            System.out.println("Ese perro no se encuentra en la lista");
                            salida = true;
                            break;
                        }
                    }

                } while (!salida);
                aux.setMascota(ls);
                break;
            }
            if (!enLista) {
                System.out.println("Su nombre no está en la lista de adoptar");
            }

        }

    }

    public void mostrarMascotas() {
        Persona aux;
        Iterator<Persona> it = personas.iterator();
        while (it.hasNext()) {
            aux = it.next();
            System.out.print(aux.getNombre() + " " + aux.getApellido() + ": ");
            if (aux.getMascota() == null) {
                System.out.println("Sin Perro");
            } else {
                for (Perro p : aux.getMascota()) {
                    System.out.print(p.getNombre() + ", ");
                }
                System.out.println("");
            }
        }
    }
}
