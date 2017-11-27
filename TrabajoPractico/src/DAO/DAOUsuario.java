/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Ignacio
 */
public class DAOUsuario {
    
    String url, usuario, contrasenia;
    java.sql.Statement st;
    java.sql.Connection conexion;
    
    
    public DAOUsuario (){
        //Se crean los parametros de conexión
        url = "jdbc:postgresql://localhost:5432/postgres";
        usuario = "postgres";
        contrasenia = "metodosagiles";       
    }
    
   
    /*METODO QUE GUARDA UN USUARIO EN LA TABLA CORRESPONDIENTE DE LA BASE DE DATOS*/ 
    
    
    public boolean guardarUsuario(Usuario user) {
        //Se hace la conexion
        try{
            
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            Statement consulta = conexion.createStatement();
            
            Integer id = proximoId();
                       
                       
            consulta.executeUpdate("INSERT INTO \"MetodosAgiles\".\"Usuario\"" + "VALUES ('"+id+"','"+user.getDni()+"','"+user.getNombre()+"','"+user.getApellido()+"','"+user.getFechaNac()+"','"+user.getTipo()+"','"+user.getMail()+"','"+user.getUsuario()+"','"+user.getContrasenia()+"')");
                        
           
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error inesperado");
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"El usuario ya existe");
            return false;
        } 
        
        return true;
    }

    
    /*METODO QUE COMPRUEBA SI EXISTE UN USUARIO EN LA TABLA DE LA BASE DE DATOS*/
    
    public boolean existeUsuario(Usuario user) {
        //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            //Permite realizar consultas sobre la base de datos
            st = conexion.createStatement();
            
            String sql = "SELECT * FROM \"MetodosAgiles\".\"Usuario\" WHERE \"Usuario\".\"Dni\" = '"+user.getDni()+"'";
           
            //Ejecución de la consulta
            
           
            ResultSet resultado =  st.executeQuery(sql);
            
            if(resultado.next()){             
                    Integer dni = resultado.getInt("Dni");
                    
                    if(dni.equals(user.getDni())){
                                return true;}
                                        
                    return false;
            }
            else
                    return false;
            
           
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error inesperado");
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en SQL");
            return false;
        }
        
        
    }
    
    
    /*METODO DE GENERACION DE ID DE FORMA AUTOINCREMENTAL*/
    
    private Integer proximoId() {
        Integer id = 0;
        
        //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            //Permite realizar consultas sobre la base de datos
            st = conexion.createStatement();
            
            //Consulta
            String sql = "SELECT MAX(\"Id_usuario\") FROM \"MetodosAgiles\".\"Usuario\";";
            
            //Ejecución de la consulta
            ResultSet resultado =  st.executeQuery(sql);
            
            while (resultado.next()){
                id = resultado.getInt(1);
            }
            resultado.close();
            st.close();
            conexion.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOTitular.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOTitular.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id+1;
    }
    
}
