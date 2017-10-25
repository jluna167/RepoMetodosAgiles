package Persistencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


public class GestorLicencia {
    
    public GestorLicencia(){
    }
    
    
    
    public boolean validarLicenciaSolicitada(String tipoLicencia, String fechaNacimiento) throws ParseException{
        Calendar fechaNac = Calendar.getInstance();
        //Se crea un objeto con la fecha actual
        Calendar fechaActual = Calendar.getInstance();
        //Se asigna la fecha recibida a la fecha de nacimiento.
        fechaNac.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(fechaNacimiento));
        //Se restan el año actual y el año de nacimiento
        int año = fechaActual.get(Calendar.YEAR)- fechaNac.get(Calendar.YEAR);
        
        if (año<17){
            return false;
        }
        else if (año<21 && (tipoLicencia.equalsIgnoreCase("c")
                         || tipoLicencia.equalsIgnoreCase("d")
                         || tipoLicencia.equalsIgnoreCase("e"))){
            return false;
        }
        else if((año>=21 && año<65) && (tipoLicencia.equalsIgnoreCase("c")
                                     || tipoLicencia.equalsIgnoreCase("d")
                                     || tipoLicencia.equalsIgnoreCase("e"))){
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
