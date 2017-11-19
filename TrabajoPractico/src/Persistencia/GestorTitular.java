
package Persistencia;
import DAO.DAOTitular;
import Entidades.Titular;
import javax.swing.JOptionPane;

public class GestorTitular {
    DAOTitular dao;
    
    public GestorTitular(){
        
    }
    
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

    public boolean existeTitular(Titular titular) {
        dao = new DAOTitular();
        return dao.buscarTitular(titular);
    }

    public boolean esContribuyente(Titular titular) {
        dao = new DAOTitular();
        return dao.esContribuyente(titular);
    }
    
    public void cargarTitular(Titular titular){
        dao = new DAOTitular();
        dao.cargarContenido(titular);
    }
}
