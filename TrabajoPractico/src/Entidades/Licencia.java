package Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Licencia {
    String tipo;
    Titular titular;
    Date fechaEmision, fechaVencimiento;
    //Usuario usuario;
    Integer vigencia;
    
    public Licencia(){
        tipo = new String();
        titular = new Titular();
        fechaEmision = new Date();
        fechaVencimiento = new Date();
        vigencia = 0;
    }
    
    public Licencia(String tipo, Titular titular, String fechaEmision, String fechaVencimiento, Integer vigencia) throws ParseException{
        this.tipo = tipo;
        this.titular = titular;
        this.fechaEmision = strigToDate(fechaEmision);
        this.fechaVencimiento = strigToDate(fechaVencimiento);
        this.vigencia = vigencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getVigencia() {
        return vigencia;
    }

    public void setVigencia(Integer vigencia) {
        this.vigencia = vigencia;
    }
    
    private Date strigToDate (String fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        
        fechaDate = formato.parse(strFecha);
        return fechaDate;
    }
}
