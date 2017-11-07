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
    
    public int idTitular, dni, numero;
    public String nombre, tipoDni, apellido, pais, provincia, localidad, calle, piso, departamento, factor, grupo, donante;
    public Date fechaNacimiento, fechaAlta;
    
    
    public Titular(){
        
    }
    
    public Titular(int idTitular, int dni, String tipoDni, int numero, String nombre, String apellido, String pais, String provincia, String localidad, String calle, String piso, String departamento, String factor, String grupo, Date fechaNacimiento, Date fechaAlta, String donante) {
        this.idTitular = idTitular;
        this.dni = dni;
        this.tipoDni = tipoDni;
        this.numero = numero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.provincia = provincia;
        this.localidad = localidad;
        this.calle = calle;
        this.piso = piso;
        this.departamento = departamento;
        this.factor = factor;
        this.grupo = grupo;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaAlta = fechaAlta;
        this.donante = donante;
    }


}
