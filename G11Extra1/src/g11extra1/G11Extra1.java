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

import java.util.Scanner;
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
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int opcion;

        PersonaServicio ps = new PersonaServicio();
        ps.crearPerros();
        ps.listarPerros();
        System.out.println("");
        ps.crearPersonas();
        ps.listarPersonas();
   
        do {
            System.out.println("1 - Alta de Persona");
            System.out.println("2 - Alta de Perro");
            System.out.println("3 - Adoptar Perro");
            System.out.println("99 - Salir");
            System.out.println("Ingrese una opción");
            opcion = leer.nextInt();
            switch (opcion){
                case 1: ps.agregarPersona(); break;
                case 2: ps.agregarPerro(); break;
                case 3: ps.adoptarPerro(); break;
            }

        } while(opcion!=99);
            ps.listarPerros();
        System.out.println("");
        ps.mostrarMascotas();
    
    }

}
