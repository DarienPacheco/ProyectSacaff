
package Clases;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDD {
    
    private Conexion conDB;
    private Statement stmt;
    
    public BDD (Conexion conDB) throws SQLException{
        
        this.conDB = conDB;
        stmt = conDB.getConnection().createStatement();  
    }
    
    public Conexion getConnectionDB() {
        return conDB;
    }
    
    public void disconnectDB() {
        
        conDB.disconnet();
        conDB = null;
    }
    
     public void registrar(String nombreUsuario, String contraseñaUsuario, String correoUsuario) throws SQLException {
        
        stmt.executeUpdate("INSERT INTO usuarios VALUES("+"'"+nombreUsuario+"',"+"'"+contraseñaUsuario+"',"+"'"+correoUsuario+"')");
        
        //System.out.println(rut+","+seguro+","+nombre+","+sexo+","+fechaNacimiento+","+direccion);
    }
    
    
    
}
