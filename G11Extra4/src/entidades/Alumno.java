/*
El sistema de votación de Egg tiene una clase llamada Alumno con los siguientes atributos:
nombre completo, DNI y cantidad de votos.
 */
package entidades;

import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class Alumno {

    private String nombreCompleto;
    private String dni;
    private Integer cantVotos;
    private String[] votados;

    public Alumno() {
    }

    public Alumno(String nombreCompleto, String dni) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.cantVotos = 0;
        this.votados = new String[]{"", "", ""};
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getCantVotos() {
        return cantVotos;
    }

    public void setCantVotos(Integer cantVotos) {
        this.cantVotos = cantVotos;
    }

    public String[] getVotados() {
        return votados;
    }

    public void setVotados(String[] votados) {
        this.votados = votados;
    }

    public String mostrarVotados() {
        String aux = "";
        for (String votado : this.votados) {
            aux += votado + ", ";
        }
        return aux;
    }

    public static Comparator<Alumno> compararMayor = new Comparator<Alumno>() {
        @Override
        public int compare(Alumno t, Alumno t1) {
            return t1.getCantVotos().compareTo(t.getCantVotos());
        }
    };

}
