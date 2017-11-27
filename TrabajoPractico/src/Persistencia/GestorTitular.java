
package Persistencia;
import DAO.DAOTitular;
import Entidades.Titular;
import javax.swing.JOptionPane;

public class GestorTitular {
    DAOTitular dao;
    
    public GestorTitular(){
        
    }
    
    
    /*METODO QUE COMPRUEBA QUE UN TITULAR PASADO POR PARAMETRO NO ESTE YA AGREGADO Y A SU VEZ SEA CONTIBUYENTE PARA PODER INSERTARLO*/
    
    public boolean guardarTitular(Titular titular){
        dao = new DAOTitular();
               
        if (!existeTitular(titular) && esContribuyente(titular)){
            return dao.insertTitular(titular);
        }
        else{
            if(existeTitular(titular))
                JOptionPane.showMessageDialog(null,"El titular con ese numero de DNI ya fue agregado");
            return false;
        }
    }

    
    /*METODO DE BUSQUEDA PARA VER SI EXISTE UN TITULAR*/
    
    public boolean existeTitular(Titular titular) {
        dao = new DAOTitular();
        return dao.buscarTitular(titular);
    }

    
    /*METODO DE BUSQUEDA PARA VERIFICAR SI UNA PERSONA ESTA DADA DE ALTA COMO CONTRIBUYENTE*/
    
    public boolean esContribuyente(Titular titular) {
        dao = new DAOTitular();
        return dao.esContribuyente(titular);
    }
    
    
    /*METODO PARA PRECARGAR UN TITULAR*/
    
    public void cargarTitular(Titular titular){
        dao = new DAOTitular();
        dao.cargarContenido(titular);
    }
    
    /*METODO PARA PRECARGAR UN TITULAR DESDE LA TABLA CONTRIBUYENTES*/
    
    public void cargarContribuyente(Titular titular){       
        dao = new DAOTitular();
        dao.cargarContribuyente(titular);
    }
}
