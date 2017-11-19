package Entidades;

import java.util.Date;

public class Usuario {
    
    int id, dni;
    String nombre, apellido, usuario, contrasenia, tipo, mail;
    Date fechaNac;

    public Usuario() {
    }

    public Usuario(Integer id, Integer dni, String nombre, String apellido, Date fechaNac, String tipo, String mail, String usuario) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.tipo = tipo;
        this.mail = mail;
        this.usuario = usuario;
        this.contrasenia = dni.toString();
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDni() {
        return dni;
    }

    public void setDni(Integer dni) {
        this.dni = dni;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
    
    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fecha) {
        this.fechaNac = fecha;
    }
    
}
