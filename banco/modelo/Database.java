package banco.modelo;

import java.sql.*;
import java.util.*;

public class Database {
    private final String DRIVER ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=banco_5502";
    private final String USER = "sa";
    private final String PASSWORD = "sasa";
    private Connection con;
    
    public Database(){
        try{
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //Método para ejecutar consultas del tipo INSERT, UPDATE o DELETE
    public int actualizar(String consulta){
        int res = 0;
        try{
            Statement st = con.createStatement();
            res = st.executeUpdate(consulta);
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
    //Método para invocar procedimientos almacenados recibe: nombre(argumentos)
    public int invocarProcedimiento(String consulta){
        int res = 0;
        try{
            CallableStatement cs = con.prepareCall("{call " + consulta + "}");
            res = cs.executeUpdate();
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return res;
    }
    
    //Método para invocar consultas de tipo select
    public List<Map> ejecutar(String consulta){
        List<Map> registros = new ArrayList();
        try{
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            registros = convertirALista(rs);
            con.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return registros;
    }
    
    private List<Map> convertirALista(ResultSet rs){
        List<Map> registros = new ArrayList();
        try{
            int cantColumnas = rs.getMetaData().getColumnCount();
            while(rs.next()){
                Map<String, Object> renglon = new HashMap();
                for(int i = 1; i <= cantColumnas; i++){
                    String nombre = rs.getMetaData().getColumnName(i);
                    Object valor = rs.getObject(nombre);
                    renglon.put(nombre, valor);
                }
                registros.add(renglon);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        return registros;
    }
    
    
}
