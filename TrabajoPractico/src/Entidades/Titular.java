/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Titular {
    
    public int idTitular, dni, numero, telefono;
    public String nombre, apellido, pais, provincia, localidad, calle, piso, departamento, factor, grupo, tipoDni, donante;
    public Date fechaNacimiento, fechaAlta;
    public Boolean  borrado;
    
    
    public Titular(){
        
    }
    
    public Titular(int idTitular, int dni, String tipoDni, String nombre, String apellido, Date fechaNacimiento, String pais, String provincia, String localidad, String calle, int numero, String piso, String departamento, int telefono, String donante, String grupo, String factor, Date fechaAlta, Boolean borrado ) {
        this.idTitular = idTitular;
        this.dni = dni;
        this.tipoDni = tipoDni;        
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.provincia = provincia;
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.departamento = departamento;
        this.telefono = telefono;
        this.donante = donante;
        this.grupo = grupo;    
        this.factor = factor;           
        this.fechaAlta = fechaAlta;
        this.borrado = borrado;
        
    }


}
