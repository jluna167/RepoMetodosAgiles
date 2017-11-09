
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
               
        if (!existeTitular(titular) && esContribuyente(titular.dni)){
            return dao.insertTitular(titular);
        }
        else
            return false;
    }

    public boolean existeTitular(Titular titular) {
        dao = new DAOTitular();
        return dao.buscarTitular(titular);
    }

    private boolean esContribuyente(Integer dni) {
        dao = new DAOTitular();
        return dao.esContribuyente(dni);
    }
}
