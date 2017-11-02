package DAO;

import Entidades.DTOLicencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAOLicencia {
    String url, usuario, contrasenia;
    java.sql.Statement st;
    Connection conexion;
    
    public DAOLicencia(){
        //Se crean los parametros de conexión
        url = "jdbc:postgresql://localhost:5432/postgres";
        usuario = "postgres";
        contrasenia = "metodosagiles";
    }
    
    public boolean guardarLicencia(DTOLicencia licencia) {
        //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            //Permite realizar consultas sobre la base de datos
            st = conexion.createStatement();
            
            Integer id = proximoId();
            //Consulta
            String sql = "INSERT INTO \"MetodosAgiles\".\"Licencia\"(\"Id_licencia\", \"Clase\", \"Id_titular\", \"Fecha_emision\", \"Fecha_vencimiento\", \"Id_usuario\", \"Vigencia\") "
            + "VALUES ("+ id + ", '"+ licencia.getTipo() + "' , '" + licencia.getTitular().getId() + "', '" + licencia.getFechaEmision() + "', '" + licencia.getFechaVencimiento() + "', " + licencia.getUsuario().getId() + ", " + licencia.getVigencia() + ");";
            
            //Ejecución de la consulta
            ResultSet resultado =  st.executeQuery(sql);
            
            resultado.close();
            st.close();
            conexion.close();
            return true;
            
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

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
            String sql = "SELECT MAX(\"Id_licencia\") FROM \"MetodosAgiles\".\"Licencia\";";
            
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
