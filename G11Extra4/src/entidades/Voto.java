/*
Una vez hecho esto debemos generar una clase Voto, esta clase tendrá como atributos,
un objeto Alumno que será el alumno que vota y una lista de los alumnos a los que votó.
 */
package entidades;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Voto {
    private Alumno alumno;
    private List<Alumno> votados;

    public Voto() {
    }

    public Voto(Alumno alumno, List<Alumno> votados) {
        this.alumno = alumno;
        this.votados = votados;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public List<Alumno> getVotados() {
        return votados;
    }

    public void setVotados(List<Alumno> votados) {
        this.votados = votados;
    }
    
    
}
