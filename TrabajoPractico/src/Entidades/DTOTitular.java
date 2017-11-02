package Entidades;

import java.util.Date;

public class DTOTitular {
    Integer dni;
    String nombres, apellido, grupoSanguineo, direccion, donante;
    Date fechaNacimiento;
    
    public DTOTitular(){
        
    }

    public DTOTitular(Integer dni, String nombres, String apellido, String grupoSanguineo, String direccion, String donante, Date fechaNacimiento) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellido = apellido;
        this.grupoSanguineo = grupoSanguineo;
        this.direccion = direccion;
        this.donante = donante;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getDonante() {
        return donante;
    }

    public void setDonante(String donante) {
        this.donante = donante;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
