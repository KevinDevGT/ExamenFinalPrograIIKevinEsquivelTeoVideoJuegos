package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.json.simple.JSONObject;

public class BaseDatos {
    private conexion conn;
    private Connection cn;
    private PreparedStatement prstmt = null;
    private ResultSet result = null;
    
    //Update es actualizar 
    //set insertar o crear
    //get obtener
    //Delete es eliminar
    
    public void selectPartida (String id_partida, String id ){
        String sql = "UPDATE  jugador SET  id_partida = ? WHERE id_jugador = ? ";
        conn= new conexion();
        cn=conn.conectar();
        
        try{
            prstmt = cn.prepareStatement(sql);                           
            prstmt.setString(1, id_partida);
            prstmt.setString(2, id);
            prstmt.executeUpdate(); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
     }
    
    public void updateCategoria(String nombre, String descripcion,String id){
        String sql = "UPDATE categoria SET nombre = ?, descripcion = ? WHERE id_categoria = "+id;
        conn= new conexion();
        cn=conn.conectar();
        
        try{
            prstmt = cn.prepareStatement(sql);                           
            prstmt.setString(1, nombre);           
            prstmt.setString(2, descripcion);
            prstmt.executeUpdate(); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
          
    }
    public void updatePartida(String nombre, String capacidad, String tipo,String id){
        String sql = "UPDATE partida SET nombre = ?, capacidad = ?, tipo = ? WHERE id_partida = "+id;
        conn= new conexion();
        cn=conn.conectar();
        
        try{
            prstmt = cn.prepareStatement(sql);                           
            prstmt.setString(1, nombre);           
            prstmt.setInt(2, Integer.parseInt(capacidad));
            prstmt.setString(3, tipo);
            prstmt.executeUpdate(); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
        
     public void updateJugador (String nombre, String edad, String id_categoria, String id ){
        String sql = "UPDATE  jugador SET nombre = ? , edad = ? , id_categoria = ? WHERE id_jugador = ? ";
        conn= new conexion();
        cn=conn.conectar();
        
        try{
            prstmt = cn.prepareStatement(sql);                           
            prstmt.setString(1, nombre);   
            prstmt.setString(2, edad);
            prstmt.setString(3, id_categoria);
            prstmt.setString(4, id);
            prstmt.executeUpdate(); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
     }
    
    public JSONObject getDataPartida(String id){  
         PreparedStatement prstmt = null;
         ResultSet result = null;
        JSONObject respuesta = new JSONObject();
        try{
                prstmt = cn.prepareStatement("select * from partida where partida.id_partida = "+id); 
                result = prstmt.executeQuery();  
               while(result.next()){
                    respuesta.put("nombre",result.getString("nombre"));
                    respuesta.put("capacidad",result.getString("capacidad"));
               }
                
        }
        catch(SQLException ex){
            ex.printStackTrace();

        }  
         return respuesta;
    }
    
    public JSONObject getDataCategoria(String id){  
         PreparedStatement prstmt = null;
         ResultSet result = null;
         JSONObject respuesta = new JSONObject();
        try{
                prstmt = cn.prepareStatement("select * from categoria where categoria.id_categoria = "+id); 
                result = prstmt.executeQuery();  
               while(result.next()){
                    respuesta.put("nombre",result.getString("nombre"));
                    respuesta.put("descripcion",result.getString("descripcion"));
               }
                
        }
        catch(SQLException ex){
            ex.printStackTrace();

        }  
         return respuesta;
    }
    
    public JSONObject getDataJugador(String id){  
         PreparedStatement prstmt = null;
         ResultSet result = null;
         JSONObject respuesta = new JSONObject();
        try{
                prstmt = cn.prepareStatement("select * from jugador where jugador.id_jugador = "+id); 
                result = prstmt.executeQuery();  
               while(result.next()){
                    respuesta.put("nombre",result.getString("nombre"));
                    respuesta.put("edad",result.getString("edad"));
               }
                
        }
        catch(SQLException ex){
            ex.printStackTrace();

        }  
         return respuesta;
    }
    
    public void deletePartida(String id){
            String sql = "delete FROM partida where partida.id_partida = "+id;
            conn= new conexion();
            cn=conn.conectar();
            try{
                prstmt = cn.prepareStatement(sql);  
                prstmt.executeUpdate();
            }
            catch(SQLException e){
               e.printStackTrace(); 
            }
    }
    
    public void deleteJugador(String id){
            String sql = "delete FROM jugador where jugador.id_jugador = "+id;
            conn= new conexion();
            cn=conn.conectar();
            try{
                prstmt = cn.prepareStatement(sql);  
                prstmt.executeUpdate();
            }
            catch(SQLException e){
               e.printStackTrace(); 
            }
    }
    
    public void deleteCategoria(String id){
            String sql = "delete FROM categoria where categoria.id_categoria = "+id;
            conn= new conexion();
            cn=conn.conectar();
            try{
                prstmt = cn.prepareStatement(sql);  
                prstmt.executeUpdate();
            }
            catch(SQLException e){
               e.printStackTrace(); 
            }
    }
    
    public void setCategoria(String nombre, String descripcion){
        String sql = "INSERT INTO categoria (nombre, descripcion) VALUES(?,?)";
        conn= new conexion();
        cn=conn.conectar();
        
        try{
            prstmt = cn.prepareStatement(sql);                           
            prstmt.setString(1, nombre);           
            prstmt.setString(2, descripcion);
            prstmt.executeUpdate(); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
        
          
    }
    public void setPartida(String nombre, String capacidad, String tipo){
        String sql = "INSERT INTO partida (nombre, capacidad, tipo) VALUES(?,?,?)";
        conn= new conexion();
        cn=conn.conectar();
        
        try{
            prstmt = cn.prepareStatement(sql);                           
            prstmt.setString(1, nombre);           
            prstmt.setString(2, capacidad);
            prstmt.setString(3, tipo);
            prstmt.executeUpdate(); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
        
     public void setJugador (String nombre, String edad, String id_categoria, String id_partida){
        String sql = "INSERT INTO jugador (nombre, edad, id_categoria, id_partida) VALUES(?,?,?,?)";
        conn= new conexion();
        cn=conn.conectar();
        
        try{
            prstmt = cn.prepareStatement(sql);                           
            prstmt.setString(1, nombre);   
            prstmt.setString(2, edad);
            prstmt.setString(3, id_categoria);
            prstmt.setString(4, id_partida);
            prstmt.executeUpdate(); 
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        
     }
     
     public StringBuffer getPartidas(){
        String sql = "SELECT * FROM partida";
        conn= new conexion();
        cn=conn.conectar();
        StringBuffer respuestaSQL = new StringBuffer();
        
        try{
            
            prstmt = cn.prepareStatement(sql);  
            result = prstmt.executeQuery();
                while(result.next()){
                    respuestaSQL.append("<option value=\"").append(result.getString("id_partida")).append("\">").append(result.getString("nombre")).append("</option>");
                }
        }
        catch(SQLException e){
           e.printStackTrace(); 
        }
        return respuestaSQL;
        } 
    
      public StringBuffer getCategoria(){
        String sql = "SELECT * FROM categoria";
        conn= new conexion();
        cn=conn.conectar();
        StringBuffer respuestaSQL = new StringBuffer();
        
        try{
            
            prstmt = cn.prepareStatement(sql);  
            result = prstmt.executeQuery();
                while(result.next()){
                    respuestaSQL.append("<option value=\"").append(result.getString("id_categoria")).append("\">").append(result.getString("nombre")).append("</option>");
                }
        }
        catch(SQLException e){
           e.printStackTrace(); 
        }
        return respuestaSQL;
        }   
      
      public StringBuffer getTableCategoria(){  
        StringBuffer respuestaSQL = new StringBuffer();
         PreparedStatement prstmt = null;
         ResultSet result = null;
        try{
                prstmt = cn.prepareStatement("select * from categoria"); 
                result = prstmt.executeQuery();  
               while(result.next()){
                    respuestaSQL.append("<tr>");
                    respuestaSQL.append("<td >").append(result.getString("id_categoria")).append("</td>");
                    respuestaSQL.append("<td >").append(result.getString("nombre")).append("</td>");
                    respuestaSQL.append("<td >").append(result.getString("descripcion")).append("</td>");   
                                        respuestaSQL.append("<td >").append("<button class=\"btn btn-success mx-2\" onclick=\"actualizar(").append(result.getString("id_categoria")).append(")\">Editar</button>").append("<button class=\"btn btn-danger \" onclick=\"borrar(").append(result.getString("id_categoria")).append(")\">Borrar</button>").append("</td>");
                    respuestaSQL.append("</tr>");
               }
                
        }
        catch(SQLException ex){
            ex.printStackTrace();

        }  
         return respuestaSQL;
    }
      public StringBuffer getTableJugador(){  
        StringBuffer respuestaSQL = new StringBuffer();
         PreparedStatement prstmt = null;
         ResultSet result = null;
        try{
                prstmt = cn.prepareStatement("select jugador.*, categoria.nombre as categoria, partida.nombre as partida from jugador "+
                        " join categoria on categoria.id_categoria = jugador.id_categoria "+
                        " join partida on partida.id_partida = jugador.id_partida");
                result = prstmt.executeQuery();  
               while(result.next()){
                    respuestaSQL.append("<tr>");
                    respuestaSQL.append("<td >").append(result.getString("id_jugador")).append("</td>");
                    respuestaSQL.append("<td >").append(result.getString("nombre")).append("</td>");
                    respuestaSQL.append("<td >").append(result.getString("edad")).append("</td>");
                    respuestaSQL.append("<td >").append(result.getString("categoria")).append("</td>");
                    respuestaSQL.append("<td >").append(result.getString("partida")).append("</td>");
                    respuestaSQL.append("<td >").append("<button class=\"btn btn-success mx-2\" onclick=\"actualizar(").append(result.getString("id_jugador")).append(")\">Editar</button>").append("<button class=\"btn btn-danger \" onclick=\"borrar(").append(result.getString("id_jugador")).append(")\">Borrar</button>").append("<button class=\"btn btn-warning mx-2 \" onclick=\"elegir(").append(result.getString("id_jugador")).append(")\">Elegir Partida</button>").append("</td>");
                    respuestaSQL.append("</tr>");
               }
                
        }
        catch(SQLException ex){
            ex.printStackTrace();

        }  
         return respuestaSQL;
    }
      public StringBuffer getTablePartida(){  
        StringBuffer respuestaSQL = new StringBuffer();
         PreparedStatement prstmt = null;
         ResultSet result = null;
        try{
                prstmt = cn.prepareStatement("select * from partida"); 
                result = prstmt.executeQuery();  
               while(result.next()){
                    respuestaSQL.append("<tr>");
                    respuestaSQL.append("<td >").append(result.getString("id_partida")).append("</td>");
                    respuestaSQL.append("<td >").append(result.getString("nombre")).append("</td>");
                    respuestaSQL.append("<td >").append(result.getString("capacidad")).append("</td>");
                    respuestaSQL.append("<td >").append(result.getString("tipo")).append("</td>");
                    respuestaSQL.append("<td >").append("<button class=\"btn btn-success mx-2\" onclick=\"actualizar(").append(result.getString("id_partida")).append(")\">Editar</button>").append("<button class=\"btn btn-danger \" onclick=\"borrar(").append(result.getString("id_partida")).append(")\">Borrar</button>").append("</td>");
                    respuestaSQL.append("</tr>");
               }
                
        }
        catch(SQLException ex){
            ex.printStackTrace();

        }  
         return respuestaSQL;
    }
      
     
}
                

