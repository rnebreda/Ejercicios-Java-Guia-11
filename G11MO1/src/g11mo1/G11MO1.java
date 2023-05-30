/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g11mo1;

import entidades.DNI;
import entidades.Persona;

/**
 *
 * @author Usuario
 */
public class G11MO1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DNI miDni = new DNI('A', 12345);
        Persona yo = new Persona("Rolando", "Nebreda", miDni);

    }

}
