package DAO;

import Entidades.Titular;
import Entidades.Titular;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAOTitular {
    String url, usuario, contrasenia;
    java.sql.Statement st;
    java.sql.Connection conexion;
    int tipoDni;
    boolean donante;
    
    public DAOTitular (){
        //Se crean los parametros de conexión
        url = "jdbc:postgresql://localhost:5432/postgres";
        usuario = "postgres";
        contrasenia = "metodosagiles";       
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
            
            Statement consulta = conexion.createStatement();
            
            Integer id = proximoId();
            
           
            if(!buscarTitular(titular)){
            
            titular.telefono = 0;
            titular.borrado = false;
            
            if(titular.tipoDni.equals("DNI"))
                 tipoDni = 1;
            if(titular.tipoDni.equals("LE"))
                 tipoDni = 2;
            if(titular.tipoDni.equals("LC"))
                 tipoDni = 3;
            if(titular.donante.equals("SI"))
                 donante = true;
            if(titular.donante.equals("NO"))
                 donante = false;
                
            consulta.executeUpdate("INSERT INTO \"MetodosAgiles\".\"Titular\"" + "VALUES ('"+id+"','"+titular.dni+"','"+tipoDni+"','"+titular.nombre+"','"+titular.apellido+"','"+titular.fechaNacimiento+"','Argentina','Santa Fe','"+titular.localidad+"','"+titular.calle+"','"+titular.numero+"','"+titular.piso+"','"+titular.departamento+"','"+titular.telefono+"','"+donante+"','"+titular.grupo+"','"+titular.factor+"','"+titular.fechaAlta+"','"+titular.borrado+"')");
                        
            return true;
            }
            else{
                JOptionPane.showMessageDialog(null,"El titular correspondiente a ese dni ya fue agregado anteriormente"); 
                return false;
            }
            
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error inesperado");
            return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"El usuario ya existe");
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
            
            String sql = "SELECT * FROM \"MetodosAgiles\".\"Titular\" WHERE \"Titular\".\"Numero_documento\" = '"+titular.dni+"'";
           
            //Ejecución de la consulta
            
           
            ResultSet resultado =  st.executeQuery(sql);
            
            if(resultado.next()){             
                    Integer dni = resultado.getInt("Numero_documento");
                    
                    if(dni.equals(titular.dni)){
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

    public boolean esContribuyente(Titular titular) {
        //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            //Permite realizar consultas sobre la base de datos
            st = conexion.createStatement();
            
            //Consulta
            String sql = "SELECT * FROM \"MetodosAgiles\".\"Contribuyente\" WHERE \"Contribuyente\".\"Dni\" = '"+ titular.dni +"'";
           
            
            //Ejecución de la consulta
            ResultSet resultado =  st.executeQuery(sql);
            
            if(resultado.next()){             
                String Apellido = resultado.getString("Apellido");
                String Nombre = resultado.getString("Nombre");
                JOptionPane.showMessageDialog(null, "Contribuyente Encontrado: " + Apellido + " " + Nombre );
                return true;
            }
            else
                JOptionPane.showMessageDialog(null, "La persona solicitada no es contribuyente");
            
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

    public void cargarContenido(Titular titular) {
    //Se hace la conexion
        try{
            Class.forName("org.postgresql.Driver");
            
            //Permite abrir la conexión a la base de datos
            conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
            //Permite realizar consultas sobre la base de datos
            st = conexion.createStatement();
            
            String sql = "SELECT * FROM \"MetodosAgiles\".\"Titular\" WHERE \"Titular\".\"Numero_documento\" = '"+titular.dni+"'";
           
            //Ejecución de la consulta
           
            ResultSet resultado =  st.executeQuery(sql);
            
            if(resultado.next()){             
                titular.idTitular = resultado.getInt(1);
                switch (resultado.getInt(3)){
                    case 1:titular.tipoDni = "Dni";
                    case 2: titular.tipoDni = "LE";
                    case 3: titular.tipoDni = "LC";
                    case 4: titular.tipoDni = "Pasaporte";
                }
                titular.nombre = resultado.getString(4);
                titular.apellido = resultado.getString(5);
                titular.fechaNacimiento = resultado.getDate(6);
                if (resultado.getBoolean(15))
                    titular.donante = "Si";
                else 
                    titular.donante = "No";
                titular.grupo = resultado.getString(16);
                titular.factor = resultado.getString(17);
                titular.fechaAlta = resultado.getDate(18);
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error inesperado");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en SQL");
        }        
    }
    
}
