/*
Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
persona.
Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
personas con sus respectivos perros
 */
package g11extra1;

import servicio.PersonaServicio;

/**
 *
 * @author Usuario
 */
public class G11Extra1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaServicio ps = new PersonaServicio();
        ps.crearPerros();
        ps.listarPerros();
        System.out.println("");
        ps.crearPersonas();
        ps.listarPersonas();
        ps.adoptarPerro();
        ps.listarPerros();
        System.out.println("");
        ps.mostrarMascotas();
    }

}
