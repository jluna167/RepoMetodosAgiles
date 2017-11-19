/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;
import DAO.DAOUsuario;
import Entidades.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Ignacio
 */
public class GestorUsuario {
    
    DAOUsuario dao;
    
    public GestorUsuario(){
        
    }
    
    public boolean guardarUsuario(Usuario usuario){
        
        dao = new DAOUsuario();
        
                       
        if (!existeUsuario(usuario)){
           
            return dao.guardarUsuario(usuario);
        }
        else
            return false;
    }
    
    public boolean existeUsuario(Usuario usuario) {
        dao = new DAOUsuario();
        
        return dao.existeUsuario(usuario);
    }
}
