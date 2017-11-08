package DAO;

import DTO.DTOTitular;
import Entidades.Titular;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAOTitular {
    String url, usuario, contrasenia;
    java.sql.Statement st;
    Connection conexion;
    
    public DAOTitular (){
        //Se crean los parametros de conexión
        url = "jdbc:postgresql://localhost:5432/postgres";
        usuario = "postgres";
        contrasenia = "metodosagiles";
        
        //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            //Permite realizar consultas sobre la base de datos
            st = conexion.createStatement();
            String sql = "SELECT * FROM \"MetodosAgiles\".\"Contribuyente\"";
            ResultSet resultado =  st.executeQuery(sql);
            while (resultado.next()){
                String dni = resultado.getString(1);
                String nombre = resultado.getString(2);
                String apellido = resultado.getString(3);
                String fNacimiento = resultado.getString(4);
                System.out.println(dni + " " + nombre + " " + apellido + " " + fNacimiento);
            }
            resultado.close();
            st.close();
            conexion.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DAOTitular.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DAOTitular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void todosLosDatos(){
        //Consulta
        String sql = "SELECT * FROM CONTRIBUYENTE";
        
        try {
            ResultSet resultado =  st.executeQuery(sql);
            while (resultado.next()){
                String dni = resultado.getString(1);
                String nombre = resultado.getString(2);
                String apellido = resultado.getString(3);
                String fNacimiento = resultado.getString(4);
                System.out.println(dni + " " + nombre + " " + apellido + " " + fNacimiento);
            }
            resultado.close();
            st.close();
            conexion.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOTitular.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public boolean insertTitular(Titular titular) {
        //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            //Permite realizar consultas sobre la base de datos
            
            int id = proximoId();
            
            st = conexion.createStatement();
            st.executeUpdate("INSERT INTO \"MetodosAgiles\".\"Titular\"" + "VALUES ('1','36201251','jose','lorenzo','26/11/1991','Argentina','Santa Fe','chascomus','quintana','2666','1','1','a','pos','08/11/2017','dni','si')");
                       
            //VALUES ('"+id+"','"+titular.dni+"','"+titular.nombre+"','"+titular.apellido+"','26/11/1991','Argentina','Santa Fe','"+titular.localidad+"','"+titular.calle+"','"+titular.numero+"','"+titular.piso+"','"+titular.departamento+"','"+titular.grupo+"','"+titular.factor+"','08/11/2017','"+titular.tipoDni+"','"+titular.donante+"')"
          
            st.close();
            conexion.close();
            return true;
            
        } catch (ClassNotFoundException ex) {
            return false;
        } catch (SQLException ex) {
            return false;
        }        
    }

    public boolean buscarTitular(Titular titular) {
        //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            //Permite realizar consultas sobre la base de datos
            st = conexion.createStatement();
            
            //Consulta
            String sql = "SELECT * FROM \"MetodosAgiles\".\"Titular\" WHERE \"Titular\".\"Id_Titular\" = '"+ titular.idTitular +"';";
            
            //Ejecución de la consulta
            ResultSet resultado =  st.executeQuery(sql);
            
            if (resultado.first()){
                resultado.close();
                st.close();
                conexion.close();
                return true;
            }
            else{
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

    public boolean esContribuyente(Integer dni) {
        //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            //Permite realizar consultas sobre la base de datos
            st = conexion.createStatement();
            
            //Consulta
            String sql = "SELECT * FROM \"MetodosAgiles\".\"Contribuyente\" WHERE \"Contribuyente\".\"Dni\" = '"+ dni +"'";
           
            
            //Ejecución de la consulta
            ResultSet resultado =  st.executeQuery(sql);
            
            if(resultado.next()){             
                    String Apellido = resultado.getString("Apellido");
                    String Nombre = resultado.getString("Nombre");
                    JOptionPane.showMessageDialog(null, "Contribuyente Encontrado: " + Apellido + " " + Nombre );}
            else
                    JOptionPane.showMessageDialog(null, "No hubo coincidencias");
            
            if (resultado.first()){
                resultado.close();
                st.close();
                conexion.close();
                return true;
            }
            else{
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
            String sql = "SELECT MAX(\"Id_Titular\") FROM \"MetodosAgiles\".\"Titular\";";
            
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
