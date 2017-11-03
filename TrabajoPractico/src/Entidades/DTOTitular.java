package Entidades;

import java.util.Date;

public class DTOTitular {
    Integer id, dni, tipoDni, numero, telefono;
    String nombre, apellido, grupoSanguineo, direccion, pais, provincia, localidad, calle, piso, departamento, factor, grupo;
    Date fechaNacimiento, fechaAlta;
    Boolean donante, borrado;
    
    public DTOTitular(){
        
    }

    public DTOTitular(Integer dni, Integer tipoDni, Integer numero, Integer telefono, String nombre, String apellido, String grupoSanguineo, String direccion, String pais, String provincia, String localidad, String calle, String piso, String departamento, String factor, String grupo, Date fechaNacimiento, Date fechaAlta, Boolean donante, Boolean borrado) {
        this.dni = dni;
        this.tipoDni = tipoDni;
        this.numero = numero;
        this.telefono = telefono;
        this.nombre = nombre;
        this.apellido = apellido;
        this.grupoSanguineo = grupoSanguineo;
        this.direccion = direccion;
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
        this.borrado = borrado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer idTitular) {
        this.id = idTitular;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public Integer getTipoDni() {
        return tipoDni;
    }

    public void setTipoDni(Integer tipoDni) {
        this.tipoDni = tipoDni;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
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

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public Boolean getDonante() {
        return donante;
    }

    public void setDonante(Boolean donante) {
        this.donante = donante;
    }

    public Boolean getBorrado() {
        return borrado;
    }

    public void setBorrado(Boolean borrado) {
        this.borrado = borrado;
    }
}
