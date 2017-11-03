
package Persistencia;
import DAO.DAOTitular;
import Entidades.DTOTitular;

public class GestorTitular {
    DAOTitular dao;
    
    public GestorTitular(){
        
    }
    
    public boolean guardarTitular(DTOTitular titular){
        dao = new DAOTitular();
        if (!existeTitular(titular) && esContribuyente(titular)){
            return dao.insertTitular(titular);
        }
        else
            return false;
    }

    public boolean existeTitular(DTOTitular titular) {
        dao = new DAOTitular();
        return dao.buscarTitular(titular);
    }

    private boolean esContribuyente(DTOTitular titular) {
        dao = new DAOTitular();
        return dao.esContribuyente(titular);
    }
}
