/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class Asiento {
    private String filaColumna;
    private Boolean ocupado;

    public Asiento(String filaColumna, Boolean ocupado) {
        this.filaColumna = filaColumna;
        this.ocupado = ocupado;
    }

    public Asiento() {
    }

    public String getFilaColumna() {
        return filaColumna;
    }

    public void setFilaColumna(String filaColumna) {
        this.filaColumna = filaColumna;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    public static Comparator<Asiento> compararMayor = new Comparator<Asiento>() {
        @Override
        public int compare(Asiento t, Asiento t1) {
          return t1.getFilaColumna().compareTo(t.getFilaColumna());
        }
    };
    
}
    

