/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DTO.DTOTitular;
import DTO.DTOUsuario;
import java.text.ParseException;
import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Licencia {
    public int idLicencia;
    public String tipo;
    public Titular titular;
    public Date fechaEmision, fechaVencimiento;
    public DTOUsuario usuario;
    public int vigencia;
    
    public Licencia(){
        tipo = "";
        titular = new Titular();
        fechaEmision = new Date();
        fechaVencimiento = new Date();
        vigencia = 0;
    }
    
    public Licencia(int idLicencia, String tipo, Titular titular, Date fechaEmision, Date fechaVencimiento, Integer vigencia) throws ParseException{
        this.idLicencia = idLicencia;
        this.tipo = tipo;
        this.titular = titular;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.vigencia = vigencia;
    }
}
