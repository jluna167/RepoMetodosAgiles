package Persistencia;

import DAO.DAOLicencia;
import Entidades.Licencia;
import Entidades.Titular;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.converter.LocalDateStringConverter;
import javax.swing.JTable;


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
        else if ((año>=65)&& (licencia.tipo.equalsIgnoreCase("c")
                                     || licencia.tipo.equalsIgnoreCase("d")
                                     || licencia.tipo.equalsIgnoreCase("e"))){
            return comprobarLicenciasPorfesionales(licencia);
        }
        //En cualquier otro caso se valida la licencia
        else
            return true;
    }

    private boolean comprobarLicenciaB(Licencia licencia) {
        DAOLicencia dao = new DAOLicencia();
        try {
            return dao.validarLicenciaB(licencia.titular);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorLicencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorLicencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GestorLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean comprobarLicenciasPorfesionales(Licencia licencia){
        DAOLicencia dao = new DAOLicencia();
        try {
            return dao.buscarLicenciasProfesionales(licencia.titular);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorLicencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GestorLicencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(GestorLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;        
    }
    
    public boolean almacenarLicencia(Licencia licencia){
        DAOLicencia dao = new DAOLicencia();
        return dao.insertLicencia(licencia); 
    }
    
    public int calcularVigencia(Titular titular){
        
        LocalDate ahora = LocalDate.now();
        
        int dia = Integer.valueOf(titular.fechaNacimiento.toString().substring(8, 10));
        int mes = Integer.valueOf(titular.fechaNacimiento.toString().substring(5,7));
        int anio = Integer.valueOf(titular.fechaNacimiento.toString().substring(0, 4));
        LocalDate fechaNacimento = LocalDate.of(anio,mes,dia);
        
        Period periodo = Period.between(fechaNacimento, ahora);
        
        if(periodo.getYears() >= 17 && periodo.getYears()<21){
                return 1;
        }
        else if (periodo.getYears()>=21 && periodo.getYears() <= 46)
            return 5;
        else if (periodo.getYears() <= 60 && periodo.getYears() > 46)
            return 4;
        else if (periodo.getYears() <= 70 && periodo.getYears() > 60)
            return 3;
        else if(periodo.getYears() > 70)
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
    
    public int calcularCosto(String clase, int vigencia){
        int matrizCosto[][] = {{40,30,25,20},
                               {40,30,25,20},
                               {47,35,30,23},
                               {59,44,39,29},
                               {40,30,25,20}};
        int gastoAdministrativo = 8;
        int i,j;
                                    
        
        switch (clase) {
            case "A": j = 0; break;
            case "B": j = 1; break;
            case "C": j = 2; break;
            case "E": j = 3; break;
            case "G": j = 4; break;
            default: j = -1;
        }
        switch(vigencia){
            case 5: i = 0; break;
            case 4: i = 1; break;
            case 3: i = 2; break;
            case 1: i = 3; break;
            default: i = -1;
        }
        if(i==-1 || j==-1){
            return -1; //en realidad iria una excepcion acá
        }
        else{
            return (matrizCosto[j][i] + gastoAdministrativo);
        }
    }
    
    public JTable verExpiradas() throws ParseException, ClassNotFoundException, SQLException{
        DAOLicencia dao = new DAOLicencia();
        
        return dao.verExpiradas();
    
    }
    
    public JTable verVigentes() throws ParseException, ClassNotFoundException, SQLException{
        DAOLicencia dao = new DAOLicencia();
        
        return dao.verVigentes();
    
    }
}
