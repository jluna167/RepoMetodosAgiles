

import Entidades.Titular;
import Interfaces.AltaTitular;
import Interfaces.AltaUsuario;
import Persistencia.GestorLicencia;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFormattedTextField;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class Test_InterfazAltaUsuario {
    GestorLicencia gestor;
    Titular titularUno;
    AltaUsuario altaUsuario;
    
    public Test_InterfazAltaUsuario(){
    }
    
    @Test
    public void testPantallaCorrecta(){
        altaUsuario = new AltaUsuario();
        ((JFormattedTextField) altaUsuario.textNumeroDNI).setValue("15792890");
        altaUsuario.textApellido.setText("Gonzales");
        altaUsuario.textNombres.setText("Roberto");
        altaUsuario.textFechaNac.setValue("12/02/1960");
        altaUsuario.tipoUsuario.setSelectedIndex(1);
        altaUsuario.textMail.setText("Rob_Gon@hotmail.com");
        altaUsuario.textUsuario.setText("RGonzales");
        assertTrue(altaUsuario.pantallaCorrecta());
    }
    
    @Test
    public void testValidarEmail(){
        altaUsuario = new AltaUsuario();
        
        altaUsuario.textMail.setText("@.");
        assertFalse(altaUsuario.validarEmail());        
        
        altaUsuario.textMail.setText("Robe.rto@Gonzales@hotmail");
        assertFalse(altaUsuario.validarEmail());
    }
    
    @Test
    public void testValidarFecha(){
        altaUsuario = new AltaUsuario();
        
        altaUsuario.textFechaNac.setValue("52/02/2010");
        assertFalse(altaUsuario.validarFecha());        
        
        altaUsuario.textMail.setText("12/30/2010");
        assertFalse(altaUsuario.validarFecha());
        
        altaUsuario.textMail.setText("12/02/2080");
        assertFalse(altaUsuario.validarFecha());
        
        //Mes que tuvo 30 días
        altaUsuario.textMail.setText("31/09/2017");
        assertFalse(altaUsuario.validarFecha());        
    }
}
