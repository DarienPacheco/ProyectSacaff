
package Clases;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class Conexion {
    
    private final String user = "root";
    private final String password = "complejosacaff2022";
    private final String url = "jdbc:mysql://localhost:3306/Sacaff";
    private Connection con = null;
    
    public Conexion () throws SQLException {
        
        con = null;
        con = DriverManager.getConnection(url,user,password);
        if(con != null) System.out.println("Conectado a la base de datos del sistema.");      
    }
    
    public Connection getConnection (){
        return con;
    }
    
    public void disconnet () {
        con = null;
    }   
}
//falta integrar la base de datos con las canchas deportivas