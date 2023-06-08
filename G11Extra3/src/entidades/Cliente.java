/*
Gestión Integral de clientes. En este módulo vamos a registrar la información personal de 
cada cliente que posea pólizas en nuestra empresa. Nombre y apellido, documento, mail, 
domicilio, teléfono.
 */
package entidades;

import java.util.List;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private String NombreApellido;
    private String documento;
    private String mail;
    private String domicilio;
    private String telefono;
    private List<Poliza> polizas;
    private List<Vehiculo> vehiculos;
}
