package DTO;

import java.util.Date;

public class DTOTitular {
    Integer dni, numero;
    String nombre, tipoDni, apellido, pais, provincia, localidad, calle, piso, departamento, factor, grupo, donante;
    Date fechaNacimiento, fechaAlta;

    
    public DTOTitular(){
        
    }

    public DTOTitular(int dni, String tipoDni, int numero, String nombre, String apellido, String pais, String provincia, String localidad, String calle, String piso, String departamento, String factor, String grupo, Date fechaNacimiento, Date fechaAlta, String donante) {
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
    
    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(String tipoDni) {
        this.tipoDni = tipoDni;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDonante() {
        return donante;
    }

    public void setDonante(String donante) {
        this.donante = donante;
    }

}
