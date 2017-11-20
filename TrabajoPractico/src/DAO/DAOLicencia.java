package DAO;

import Entidades.Licencia;
import Entidades.Titular;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOLicencia {
    String url, usuario, contrasenia;
    java.sql.Statement st;
    Connection conexion;
    ResultSet tabla;
    
    
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
                    
            licencia.idLicencia = proximoId();
                       
            consulta.executeUpdate("INSERT INTO \"MetodosAgiles\".\"Licencia\"" + "VALUES ('"+licencia.idLicencia+"','"+licencia.tipo+"','"+licencia.titular.idTitular+"','"+licencia.fechaEmision+"','"+licencia.fechaVencimiento+"',1,'"+licencia.vigencia+"')");
                 
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
    
    public JTable verExpiradas() throws ClassNotFoundException, SQLException, ParseException {
        //Se hace la conexion
           JTable resultado = null;
           Date fecha;
            
           Class.forName("org.postgresql.Driver");
            
           //Permite abrir la conexión a la base de datos
           conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
           Statement consulta = conexion.createStatement();
                    
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
           Date date = new Date();
            
           fecha =  strigToDate(dateFormat.format(date));           
           
                       
           tabla = consulta.executeQuery("SELECT * FROM \"MetodosAgiles\".\"Licencia\" WHERE \"Licencia\".\"Fecha_vencimiento\" < '"+fecha+"'");
                  
           resultado = new JTable(buildTableModel(tabla));
            
           return resultado;            
          
    }
    
    public JTable verVigentes() throws ClassNotFoundException, SQLException, ParseException {
        //Se hace la conexion
           JTable resultado = null;
           Date fecha;
            
           Class.forName("org.postgresql.Driver");
            
           //Permite abrir la conexión a la base de datos
           conexion = DriverManager.getConnection(url,usuario,contrasenia);
            
           Statement consulta = conexion.createStatement();
                    
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
           Date date = new Date();
            
           fecha =  strigToDate(dateFormat.format(date));           
           
                       
           tabla = consulta.executeQuery("SELECT * FROM \"MetodosAgiles\".\"Licencia\" WHERE \"Licencia\".\"Fecha_vencimiento\" > '"+fecha+"'");
                  
           resultado = new JTable(buildTableModel(tabla));
            
           return resultado;            
          
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
 private Date strigToDate (String fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        
        fechaDate = formato.parse(strFecha);
        return fechaDate;
    }
 
 public static DefaultTableModel buildTableModel(ResultSet rs)
        throws SQLException {

    ResultSetMetaData metaData = rs.getMetaData();

    // names of columns
    Vector<String> columnNames = new Vector<String>();
    int columnCount = metaData.getColumnCount();
    for (int column = 1; column <= columnCount; column++) {
        columnNames.add(metaData.getColumnName(column));
    }

    // data of the table
    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
    while (rs.next()) {
        Vector<Object> vector = new Vector<Object>();
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
            vector.add(rs.getObject(columnIndex));
        }
        data.add(vector);
    }

    return new DefaultTableModel(data, columnNames);

}
    
}
