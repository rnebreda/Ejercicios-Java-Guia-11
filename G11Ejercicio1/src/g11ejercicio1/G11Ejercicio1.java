/*
Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
atributos: nombre, apellido, edad, documento y Perro.
Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
la clase Persona, la información del Perro y de la Persona
 */
package g11ejercicio1;

import entidades.Perro;
import entidades.Persona;

/**
 *
 * @author Usuario
 */
public class G11Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Perro p1 = new Perro("Fer", "salchicha", 4, "chico");
        Perro p2 = new Perro("Chacha","callejero",5,"grande");
        Persona a1 = new Persona("Juan","Torres",25,40123543,p1);
        Persona a2 = new Persona("Rosa","Fuentes",40,35689452,p2);
        System.out.println(a1.getMascota().toString());

    }

}
