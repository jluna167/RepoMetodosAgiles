package Persistencia;

import DAO.DAOLicencia;
import Entidades.Licencia;
import Entidades.Titular;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import javafx.util.converter.LocalDateStringConverter;


public class GestorLicencia {
    
    public GestorLicencia(){
    }
    
    public boolean validarLicenciaSolicitada(Licencia licencia) throws ParseException{
        Calendar fechaNacimiento = Calendar.getInstance();
        //Se crea un objeto con la fecha actual
        Calendar fechaActual = Calendar.getInstance();
        //Se asigna la fecha recibida a la fecha de nacimiento.
        fechaNacimiento.setTime(licencia.titular.fechaNacimiento);
        //Se restan el año actual y el año de nacimiento
        int año = fechaActual.get(Calendar.YEAR)- fechaNacimiento.get(Calendar.YEAR);
        
        if (año<17){
            return false;
        }
        else if (año<21 && (licencia.tipo.equalsIgnoreCase("c")
                         || licencia.tipo.equalsIgnoreCase("d")
                         || licencia.tipo.equalsIgnoreCase("e"))){
            return false;
        }
        else if((año>=21 && año<65) && (licencia.tipo.equalsIgnoreCase("c")
                                     || licencia.tipo.equalsIgnoreCase("d")
                                     || licencia.tipo.equalsIgnoreCase("e"))){
            return comprobarLicenciaB(licencia);
        }
        //En cualquier otro caso se valida la licencia
        else
            return true;
    }

    private boolean comprobarLicenciaB(Licencia licencia) {
        DAOLicencia dao = new DAOLicencia();
        return false; //dao.buscarPorClaseYTitular(licencia.getTitular(), "B");
    }

    public boolean almacenarLicencia(Licencia licencia){
        DAOLicencia dao = new DAOLicencia();
        dao.insertLicencia(licencia);
        return false; // 
    }
    
    public int calcularVigencia(Titular titular){
        
        LocalDate ahora = LocalDate.now();
        
        int dia = Integer.valueOf(titular.fechaNacimiento.toString().substring(8, 10));
        int mes = Integer.valueOf(titular.fechaNacimiento.toString().substring(5,7));
        int anio = Integer.valueOf(titular.fechaNacimiento.toString().substring(0, 4));
        LocalDate fechaNacimento = LocalDate.of(anio,mes,dia);
        
        Period periodo = Period.between(fechaNacimento, ahora);
        int anios = periodo.getYears();
        
        if(anios >= 18 && anios<21){
           // if(dao.buscarPorTitular(titular))
            //    return 3;
           // else
                return 1;
        }
        else if (anios <= 46)
            return 5;
        else if (anios <= 60)
            return 4;
        else if (anios <= 70)
            return 3;
        else if(anios > 70)
            return 1;
        else
            return -1;
    }
    public Date sumarVigencia (Titular titular){
        Date fechaNacimiento = titular.fechaNacimiento;
        int vigencia = this.calcularVigencia(titular);
        
        Date nuevaFecha = new Date();
        
        nuevaFecha.setDate(fechaNacimiento.getDate());
        nuevaFecha.setMonth(fechaNacimiento.getMonth());
        nuevaFecha.setYear(LocalDate.now().getYear() + vigencia);
        
        return nuevaFecha;
    }
}
