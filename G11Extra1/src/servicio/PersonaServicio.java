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
        System.out.println("Ingrese su nombre");
        String nombre = leer.next();
        Iterator<Persona> it = personas.iterator();
        List<Perro> ls = new ArrayList();
        boolean salida = false;

        if (personas.isEmpty()) {
            System.out.println("Debe darse de alta en la Lista antes de adoptar");
        }

        while (it.hasNext()) {
            aux = it.next();
            if (aux.getNombre().equalsIgnoreCase(nombre)) {
                do {
                    if (enAdopcion.isEmpty()) {
                        System.out.println("No hay perros en adopcion en este momento");
                        salida=false;
                    } else {
                        listarPerros();
                        System.out.println("Elija el nombre de un perro");
                        String elegido = leer.next();
                        Iterator<Perro> ip = enAdopcion.iterator();

                        while (ip.hasNext()) {
                            auxPerro = ip.next();
                            if (auxPerro.getNombre().equalsIgnoreCase(elegido)) {
                                ls.add(auxPerro);
                                ip.remove();
                                System.out.println("Desea adoptar otro perro? (S=Si)");
                                salida = leer.next().equalsIgnoreCase("S");
                            } else {
                                System.out.println("Ese perro no se encuentra en la lista");
                            }
                        }
                    }

                } while (!salida);
                aux.setMascota(ls);

            } else {
                System.out.println("Debe darse de alta en la Lista antes de adoptar");
            }

        }

    }
    
    public void mostrarMascotas(Persona p){
        for (Perro perro : p.getMascota()) {
            System.out.println(perro.getNombre());
        }
    }

}
