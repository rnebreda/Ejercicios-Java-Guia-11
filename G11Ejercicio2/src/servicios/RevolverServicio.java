/*
Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición 
del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del 
tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.

Métodos:
• llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
deben ser aleatorios.
• mojar(): devuelve true si la posición del agua coincide con la posición actual
• siguienteChorro(): cambia a la siguiente posición del tambor
• toString(): muestra información del revolver (posición actual y donde está el agua)
 */
package servicios;

import entidades.Revolver;

/**
 *
 * @author Usuario
 */
public class RevolverServicio {


    private Revolver revolver;
    private final int cantidadTambor = 10;

    public Revolver llenarRevolver() {
        int actual = (int) (Math.random() * cantidadTambor);
        int agua = (int) (Math.random() * cantidadTambor);
        return new Revolver(actual, agua);
    }

    public boolean mojar() {
        return (revolver.getPosActual() == revolver.getPosAgua());
    }

    public void siguienteChorro() {
        if (revolver.getPosActual() < (cantidadTambor - 1)) {
            revolver.setPosActual(revolver.getPosActual() + 1);
        } else {
            revolver.setPosActual(0);
        }
    }
    
    public Revolver cargarRevolver(){
        return revolver;
    }

}
