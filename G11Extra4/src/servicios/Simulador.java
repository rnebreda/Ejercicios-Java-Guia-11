/*
crearemos una clase Simulador que va a
tener los métodos para manejar los alumnos y sus votaciones. Estos métodos serán llamados
desde el main.
• La clase Simulador debe tener un método que genere un listado de alumnos manera
aleatoria y lo retorne. Las combinaciones de nombre y apellido deben ser generadas de
manera aleatoria. Nota: usar listas de tipo String para generar los nombres y los apellidos.
• Ahora hacer un generador de combinaciones de DNI posibles, deben estar dentro de un
rango real de números de documentos. Y agregar a los alumnos su DNI. Este método
debe retornar la lista de dnis.
• Ahora tendremos un método que, usando las dos listas generadas, cree una cantidad de
objetos Alumno, elegidos por el usuario, y le asigne los nombres y los dnis de las dos
listas a cada objeto Alumno. No puede haber dos alumnos con el mismo dni, pero si con el
mismo nombre.
• Se debe imprimir por pantalla el listado de alumnos.

• Crearemos un método votación en la clase Simulador que, recibe el listado de alumnos y
para cada alumno genera tres votos de manera aleatoria. En este método debemos
guardar a el alumno que vota, a los alumnos a los que votó y sumarle uno a la cantidad de
votos a cada alumno que reciba un voto, que es un atributo de la clase Alumno.
Tener en cuenta que un alumno no puede votarse a sí mismo o votar más de una vez al
mismo alumno. Utilizar un hashset para resolver esto.
• Se debe crear un método que muestre a cada Alumno con su cantidad de votos y cuales
fueron sus 3 votos.
• Se debe crear un método que haga el recuento de votos, este recibe la lista de Alumnos y
comienza a hacer el recuento de votos.
• Se deben crear 5 facilitadores con los 5 primeros alumnos votados y se deben crear 5
facilitadores suplentes con los 5 segundos alumnos más votados. A continuación, mostrar
los 5 facilitadores y los 5 facilitadores suplentes.
 */
package servicios;

import entidades.Alumno;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Usuario
 */
public class Simulador {

    String[] nombres = {"Juan", "Carlos", "Rosario", "Oscar", "María", "Miguel", "Fabian", "Fernando", "Liliana", "Antonela"};
    String[] apellidos = {"Perez", "Sanchez", "Sosa", "Luna", "Martinez", "Suarez", "Roma", "Lima", "Benitez", "García"};
    final private int cantAlumnos = 30;
    Set<Alumno> alumnos = new HashSet();

    public void crearAlumnos() {
        int indiceNombre, indiceAp, dni;
        String dniString, completo;

        for (int i = 0; i < cantAlumnos; i++) {
            indiceNombre = (int) (Math.random() * nombres.length);
            indiceAp = (int) (Math.random() * apellidos.length);
            completo = nombres[indiceNombre] + " " + apellidos[indiceAp];
            dni = (int) ((Math.random() * 50000000) + 10000000);
            dniString = String.valueOf(dni);
            dniString = dniString.substring(0, 2) + "." + dniString.substring(2, 5) + "." + dniString.substring(5, 8);
            Alumno a = new Alumno(completo, dniString);
            if(!alumnos.contains(a)){
            alumnos.add(a);
            }else{
                System.out.println("El número de DNI "+dniString+ " ya existe");
            }
        }
    }

    public void mostrarAlumnos() {
        alumnos.forEach((a) -> {
            System.out.println(a.getNombreCompleto() + " - " + a.getDni());
        });
    }

    public String[] votoAlumno(String s) {

        List<Alumno> ls = new ArrayList(alumnos);
        Collections.shuffle(ls);
        boolean exito;
        int cont = 0;
        Alumno aux;
        String[] votados = new String[3];
        for (int i = 0; i < votados.length; i++) {
            do {
                exito = false;
                aux = ls.get(cont);
                if (!aux.getNombreCompleto().equals(s)) {
                    votados[i] = aux.getNombreCompleto();
                    aux.setCantVotos(aux.getCantVotos() + 1);
                    exito = true;
                }
                cont++;
            } while (!exito);
        }
        return votados;
    }

    public void votacion() {
        Alumno aux;
        Iterator<Alumno> it = alumnos.iterator();
        while (it.hasNext()) {
            aux = it.next();
            aux.setVotados(votoAlumno(aux.getNombreCompleto()));
            aux.mostrarVotados();
        }
    }

    public void mostrarVotados() {
        alumnos.forEach((a) -> {
            System.out.println(a.getNombreCompleto() + " Votos: " + a.getCantVotos() + " - votó a: " + a.mostrarVotados());
        });
    }

    public void facilitadores() {
        List<Alumno> ls = new ArrayList(alumnos);
        Collections.sort(ls, Alumno.compararMayor);
        System.out.println("Facilitadores titulares");
        for (int i = 0; i < 5; i++) {
            System.out.println(ls.get(i).getNombreCompleto() + " DNI: " + ls.get(i).getDni() + " Votos: " + ls.get(i).getCantVotos());
        }
        System.out.println("");
        System.out.println("Facilitadores suplentes");
        for (int i = 5; i < 10; i++) {
            System.out.println(ls.get(i).getNombreCompleto() + " DNI: " + ls.get(i).getDni() + " Votos: " + ls.get(i).getCantVotos());
        }
    }

}
