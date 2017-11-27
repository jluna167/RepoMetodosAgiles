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
import java.time.LocalDate;
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
    
 /*DAO UTILIZADO PARA COMUNICARNOS CON LA TABLA CORRESPONDIENTE A LAS LICENCIAS*/
    
    
    public DAOLicencia(){
        //Se crean los parametros de conexión
        url = "jdbc:postgresql://localhost:5432/postgres";
        usuario = "postgres";
        contrasenia = "metodosagiles";
    }
  
    
    
    /*METODO PARA INSERTAR UNA LICENCIA EN LA TABLA*/
    
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

    
    /*GENERADOR AUTOMATICO DE IDS DE FORMA INCREMENTAL*/
    
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
    
    
    
    /*METODO QUE DEVUELVE LAS LICENCIAS EXPIRADAS A TRAVES DE UNA JTABLE*/
    
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
    
    
    /*METODO QUE DEVUELVE LAS LICENCIAS VIGENTES A TRAVES DE UN JTABLE*/ 
    
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

    
    /*METODO DE VALIDACION PARA VERIFICAR QUE EXISTA UNA LICENCIA TIPO B ANTES DE GENERAR OTRA QUE LA SOLICITE PREVIAMENTE*/
    
    public boolean validarLicenciaB(Titular titular) throws ClassNotFoundException, SQLException, ParseException{
        
        JTable tablaExpiradas = verExpiradas();
        
        Date fecha;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
            
        fecha =  strigToDate(dateFormat.format(date));
        
        int algo = tablaExpiradas.getRowCount();
        for (int i = 0; i< tablaExpiradas.getRowCount(); i++){
            if (titular.idTitular == (Integer) tablaExpiradas.getValueAt(i, 2)){
                if (tablaExpiradas.getValueAt(i, 1) == "B" && fecha.after((Date) tablaExpiradas.getValueAt(i,3)));
                    return true;
            }
        }
       
        return false;
    }
    
    /*METODO DE BUSQUEDA DE LICENCIAS BOOLEANO PARA USO INTERNO*/
    
    public boolean buscarLicenciasProfesionales(Titular titular) throws ClassNotFoundException, SQLException, ParseException{
        
        JTable tablaExpiradas = verExpiradas();
        
        Date fecha;
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
            
        fecha =  strigToDate(dateFormat.format(date));
        
        
        for (int i = 0; i<= tablaExpiradas.getRowCount(); i++){
            if (titular.idTitular == (Integer) tablaExpiradas.getValueAt(i, 2)){
                if ((tablaExpiradas.getValueAt(i, 1) == "C" || 
                     tablaExpiradas.getValueAt(i, 1) == "D" ||
                     tablaExpiradas.getValueAt(i, 1) == "E")&& 
                     fecha.after((Date) tablaExpiradas.getValueAt(i,3)));
                        return true;
            }
        }
       
        return false;
    }
    
    
    /*METODO QUE CONVIERTE UN STRING EN UN DATE*/
    
    private Date strigToDate (String fecha) throws ParseException {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String strFecha = fecha;
        Date fechaDate = null;
        
        fechaDate = formato.parse(strFecha);
        return fechaDate;
    }
 
    
    
    /*METODO DE SOPORTE PARA IMPORTAR UNA TABLA DESDE SQL HACIA EL CODIGO JAVA*/
    
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
