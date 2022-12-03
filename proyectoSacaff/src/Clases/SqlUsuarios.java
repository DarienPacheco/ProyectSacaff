
package Clases;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlUsuarios extends Conexion {
    
    public boolean registrar(Usuario usr) throws SQLException{
        
        PreparedStatement ps = null;
        Connection con = getConnection();
        
        String sql = "INSERT INTO Usuarios (nombreUsuario,contraseñaUsuario,correoUsuario) VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, usr.getNombreUsuario());
            ps.setString(2, usr.getContraseñaUsuario());
            ps.setString(3, usr.getCorreoUsuario());
            ps.execute();
            return true;
        } catch (SQLException ex){
            Logger.getLogger(SqlUsuarios.class.getName()).log(Level.SEVERE,null,ex);
            return false;
        }
        
        
    }
    
}
