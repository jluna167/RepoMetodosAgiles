/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
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
    
}
