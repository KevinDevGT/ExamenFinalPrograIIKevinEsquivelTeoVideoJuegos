package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private String url="jdbc:mysql://localhost:3306/videojuegos?characterEncoding=latin1&useConfigs=maxPerformance";//url de MySQL
    private String usuario="root";
    private String clave="1234"; 
    private Connection conexion=null;    
    
    public Connection conectar(){   
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection( url, usuario, clave);
        }  catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {   
           ex.printStackTrace();
        }         
        return conexion;        
    }
}
