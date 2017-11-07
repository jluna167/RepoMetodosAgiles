
package Persistencia;
import DAO.DAOTitular;
import DTO.DTOTitular;
import Entidades.Titular;

public class GestorTitular {
    DAOTitular dao;
    
    public GestorTitular(){
        
    }
    
    public boolean guardarTitular(DTOTitular titular){
        dao = new DAOTitular();
        Titular tit = new Titular();
        tit.apellido = titular.getApellido();
        tit.calle = titular.getCalle();
        tit.departamento = titular.getDepartamento();
        tit.dni = titular.getDni();
        tit.donante = titular.getDonante();
        tit.factor = titular.getFactor();
        tit.fechaAlta = titular.getFechaAlta();
        tit.fechaNacimiento = titular.getFechaNacimiento();
        tit.grupo = titular.getGrupo();
        tit.idTitular = -1;
        tit.localidad = titular.getLocalidad();
        tit.nombre = titular.getNombre();
        tit.numero = titular.getNumero();
        tit.pais = titular.getPais();
        tit.piso = titular.getPiso();
        tit.provincia = titular.getProvincia();
        tit.tipoDni = titular.getTipoDni();
        if (!existeTitular(tit) && esContribuyente(tit)){
            return dao.insertTitular(tit);
        }
        else
            return false;
    }

    public boolean existeTitular(Titular titular) {
        dao = new DAOTitular();
        return dao.buscarTitular(titular);
    }

    private boolean esContribuyente(Titular titular) {
        dao = new DAOTitular();
        return dao.esContribuyente(titular);
    }
}
