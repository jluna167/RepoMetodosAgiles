package Persistencia;

import Entidades.DTOLicencia;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class GestorLicencia {
    
    public GestorLicencia(){
    }
    
    public boolean validarLicenciaSolicitada(DTOLicencia licencia) throws ParseException{
        Calendar fechaNacimiento = Calendar.getInstance();
        //Se crea un objeto con la fecha actual
        Calendar fechaActual = Calendar.getInstance();
        //Se asigna la fecha recibida a la fecha de nacimiento.
        fechaNacimiento.setTime(licencia.getTitular().getFechaNacimiento());
        //Se restan el año actual y el año de nacimiento
        int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        
        if (año<17){
            return false;
        }
        else if (año<21 && (licencia.getTipo().equalsIgnoreCase("c")
                         || licencia.getTipo().equalsIgnoreCase("d")
                         || licencia.getTipo().equalsIgnoreCase("e"))){
            return false;
        }
        else if((año>=21 && año<65) && (licencia.getTipo().equalsIgnoreCase("c")
                                     || licencia.getTipo().equalsIgnoreCase("d")
                                     || licencia.getTipo().equalsIgnoreCase("e"))){
            return comprobarLicenciaB();
        }
        //En cualquier otro caso se valida la licencia
        else
            return true;
    }

    private boolean comprobarLicenciaB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
