/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Entidades.Titular;
import Persistencia.GestorLicencia;
import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author juan
 */
public class Test_GestorLicencia {
    Date fechaNacimientoUno, fechaAltaUno, 
            fechaNacimientoDos, fechaAltaDos,
            fechaNacimientoTres, fechaAltaTres,
            fechaNacimientoCuatro, fechaAltaCuatro;
    Titular titularUno, titularDos, titularTres, titularCuatro;
    
    public Test_GestorLicencia() {

        //Titular con menos de 17 años
        fechaNacimientoUno = new Date(100, 11, 31);
        
        fechaAltaUno = new Date(106,3,22);
        titularUno = new Titular(1, 35651167, "DNI", "Juan", "Luna", fechaNacimientoUno, "Argentina", "Santa Fe", "Santa Fe", "Junin", 1111, "1", "3", 154454444, "Si", "RH", "+", fechaAltaUno, false);
        
        //Titular con 19 años
        fechaNacimientoDos = new Date(99, 3, 22);
        fechaAltaDos = new Date(106,3,22);
        titularDos = new Titular(1, 36771856, "DNI", "Victor", "Ojeda", fechaNacimientoDos, "Argentina", "Santa Fe", "Santa Fe", "Junin", 2222, "", "", 145654787, "Si", "RH", "+", fechaAltaDos, false);

        //Titular con 26 años
        fechaNacimientoTres = new Date(91, 3, 22);
        fechaAltaTres = new Date(106,3,22);
        titularTres = new Titular(1, 35651167, "DNI", "Juan", "Chiappero", fechaNacimientoTres, "Argentina", "Santa Fe", "Santa Fe", "Junin", 3333, "1", "8", 147774875, "Si", "RH", "+", fechaAltaTres, false);
        
        //Titular con 78 años
        fechaNacimientoCuatro = new Date(35, 4, 12);
        fechaAltaCuatro = new Date(2006,3,22);
        titularCuatro = new Titular(1, 35651167, "DNI", "Karen", "Cuadrado", fechaNacimientoCuatro, "Argentina", "Santa Fe", "Santa Fe", "Junin", 4444, "", "", 154454457, "Si", "RH", "+", fechaAltaCuatro, false);
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testCalcularVigencia() {
        GestorLicencia gestorLicencia = new GestorLicencia();
        //No debería calcular la vigencia para un titular menor a 17 años
        assertEquals(-1, gestorLicencia.calcularVigencia(titularUno));
        
        //La vigencia de la licencia para una persona entre 17 y 21 es de 1 año
        assertEquals(1, gestorLicencia.calcularVigencia(titularDos));
        
        //La vigencia de la licencia para una persona entre 21 y 46 es de 5 años
        assertEquals(5, gestorLicencia.calcularVigencia(titularTres));
            
        //La vigencia de la licencia para una persona mayor a 70 años es de 1 año
        assertEquals(1, gestorLicencia.calcularVigencia(titularCuatro));
        
    }
}
