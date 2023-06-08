/*
Gestión de Pólizas: Se registrará una póliza, donde se guardará los datos tanto de un 
vehículo, como los datos de un solo cliente. Los datos incluidos en ella son: número de 
póliza, fecha de inicio y fin de la póliza, cantidad de cuotas, forma de pago, monto total 
asegurado, incluye granizo, monto máximo granizo, tipo de cobertura (total, contra 
terceros, etc.). Nota: prestar atención al principio de este enunciado y pensar en las 
relaciones entre clases. Recuerden que pueden ser de uno a uno, de uno a muchos, de 
muchos a uno o de muchos a muchos. 
 */
package entidades;

import enumeraciones.Cobertura;
import enumeraciones.FormaPago;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class Poliza {
    private Vehiculo vehiculo;
    private String numPoliza;
    private FormaPago pago;
    private Cobertura cobertura;
    private Date fechaInicio;
    private Date fechaFin;
    private Double montoTotal;
    private Double montoGranizo;
    private Boolean granizo;
    private List<Cuota> cuotas;
    private Integer cantCuotas;
    
}
