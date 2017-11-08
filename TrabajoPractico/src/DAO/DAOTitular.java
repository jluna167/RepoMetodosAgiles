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
            st = conexion.createStatement();
            
            int id = proximoId();
            
            //Consulta
            String sql = "INSERT INTO Titular (Id_Titular, Numero_documento, Tipo_Documento, Nombre, Apellido, Fecha_Nacimiento, Pais, Provincia, Localidad, Calle, Numero, Piso, Departamento, Telefono, Donante, Grupo, Factor, Fecha_alta, Borrado)"+ 
                    "values('"+id+"','"+titular.dni+"','"+titular.tipoDni+"','"+titular.nombre+"','"+titular.apellido+"','"+titular.fechaNacimiento+"','"+titular.pais+"','"+titular.provincia+"','"+titular.localidad+"','"+titular.calle+"','"+titular.numero+"','"+titular.piso+"','"+titular.departamento+"','1','"+titular.donante+"','"+titular.grupo+"','"+titular.factor+"','"+titular.fechaAlta+"','false')";
            
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
