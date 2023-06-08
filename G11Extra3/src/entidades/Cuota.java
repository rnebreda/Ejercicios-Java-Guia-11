/*
Gestión de cuotas: Se registrarán y podrán consultar las cuotas generadas en cada póliza. 
Esas cuotas van a contener la siguiente información: número de cuota, monto total de la 
cuota, si está o no pagada, fecha de vencimiento, forma de pago (efectivo, transferencia, 
etc.).
 */
package entidades;

import enumeraciones.FormaPago;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Cuota {
    private String numCuota;
    private Double monto;
    private Boolean pagada;
    private Date vencimiento;
    private FormaPago pago;
}
