package DAO;

import Entidades.Licencia;
import Entidades.Titular;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
    
    public boolean insertLicencia(Licencia licencia) {
        //Se hace la conexion
        try{
            
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            Statement consulta = conexion.createStatement();
                                  
                       
            consulta.executeUpdate("INSERT INTO \"MetodosAgiles\".\"Licencia\"" + "VALUES ('"+licencia.idLicencia+"','"+licencia.tipo+"','"+licencia.titular.idTitular+"','"+licencia.fechaEmision+"','"+licencia.fechaVencimiento+"','1','"+licencia.vigencia+"')");
                  
            return true;
            
                       
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error inesperado");
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"El usuario ya existe");
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
            Logger.getLogger(DAOLicencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOLicencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id+1;
    }

  /*  public boolean buscarPorClaseYTitular(DTOTitular titular, String clase) {
        
        //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            //Permite realizar consultas sobre la base de datos
            st = conexion.createStatement();
            
            //Consulta
            String sql = "SELECT * FROM \"MetodosAgiles\".\"Licencia\" WHERE \"Licencia\".\"Clase\" = '"+ clase.toUpperCase() +"' AND \"Licencia\".\"Id_titular\" = "+ titular.getId() +";";
            
            //Ejecución de la consulta
            ResultSet resultado =  st.executeQuery(sql);
            
            //Si existe al menos una fila, 
            if (resultado.first()){
                resultado.close();
                st.close();
                conexion.close();
                return true;                
            }
            else {
                resultado.close();
                st.close();
                conexion.close();
                return false;
            }
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }
    */
      /*  public boolean buscarPorTitular(DTOTitular titular) {
        
        //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            //Permite realizar consultas sobre la base de datos
            st = conexion.createStatement();
            
            //Consulta
            String sql = "SELECT * FROM \"MetodosAgiles\".\"Licencia\" WHERE \"Licencia\".\"Id_titular\" = "+ titular.getId() +";";
            
            //Ejecución de la consulta
            ResultSet resultado =  st.executeQuery(sql);
            
            //Si existe al menos una fila, 
            if (resultado.first()){
                resultado.close();
                st.close();
                conexion.close();
                return true;                
            }
            else {
                resultado.close();
                st.close();
                conexion.close();
                return false;
            }
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }
    */

    
}
