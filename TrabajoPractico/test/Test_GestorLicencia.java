
import DTO.DTOLicencia;
import DTO.DTOTitular;
import Persistencia.GestorLicencia;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class Test_GestorLicencia {
    GestorLicencia gestor;
    DTOTitular titularUno;
    DTOLicencia licenciaUno;
    
    public Test_GestorLicencia(){
        
    }
    
    @Before
    public void setUp() throws ParseException {
            gestor = new GestorLicencia();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            
            // Persona con 20 años que le falta un dia para los 21, 
            // y quiere sacar licencia D
            java.util.Date fechaCumpleaños = formato.parse("22/03/1996");
            titularUno = new DTOTitular(35651167, "Juan Andres", "Luna", "0 RH +", "Lalala 123", "si", fechaCumpleaños);
            java.util.Date fechaEmis = formato.parse("23/03/2017");
            java.util.Date fechaVenc = formato.parse("22/03/2021");
            licenciaUno = new DTOLicencia("D", titularUno, fechaEmis, fechaVenc, 4);
    }
    
    @Test
    public void testValidarLicencia(){
        try {
            assertTrue(gestor.validarLicenciaSolicitada(licenciaUno));
        } catch (ParseException ex) {
            Logger.getLogger(Test_GestorLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
