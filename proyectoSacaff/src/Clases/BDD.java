
package Clases;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
    }
    
    
    private ResultSet query(String request) {
        
        ResultSet rs = null;
        
        try {
            
            rs = stmt.executeQuery(request);
            if(rs.next()) return rs;
            return null;
   
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(BDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        return rs;
    }
    
    
    public ResultSet searchUserByUsername(String username) {
        
        ResultSet rs;
        String request;
        
        request = "SELECT * FROM sacaff.usuarios where nombreUsuario = '"+username+"';";

        rs = query(request);
        
        
        return rs;
    }
    
    
    public ResultSet searchProductByID(String id) {
        
        ResultSet rs;
        String request;
        
        request = "SELECT * FROM sacaff.inventario where codigoProducto = '"+id+"';";

        rs = query(request);
        
        
        return rs;
    }
    
    public Integer getId() throws SQLException{
        ResultSet rs;
        String request;
        
        request = "SELECT COUNT(*) AS total FROM sacaff.reservas;";
        rs = query(request);
        
        
        int aInt = rs.getInt("total");
        
        return aInt;
    }
    
    public ResultSet showInventario() {
        
        ResultSet rs;
        String request;
        
        request = "SELECT * FROM sacaff.inventario;";

        rs = query(request);
        
        return rs;
    }

    public void setCantidad(String id, Integer num, String type) throws SQLException {
        ResultSet rs = searchProductByID(id);
        ResultSetMetaData rsMd;
        
        Integer n = Integer.parseInt(rs.getString("cantidadProducto"));
        System.out.println(n);
        int number = 0;
        
        if(type.equals("suma")){
            number = num+n;    
        }else{
            number = n-num;
        }
        
        String request = "UPDATE sacaff.inventario SET cantidadProducto = "+number +" WHERE codigoProducto = '"+id+"';";
        stmt.executeUpdate(request);
    }

    public void AgregarProducto(Integer codigoProducto, Integer cantidadProducto, String nombreProducto, Integer precioProducto) {
        codigoProducto = codigoProducto+1;
        
        try {
            stmt.executeUpdate("INSERT INTO sacaff.inventario VALUES("+codigoProducto+","+"'"+nombreProducto+"',"+cantidadProducto+","+precioProducto+")");
            
        } catch (SQLException ex) {
            System.out.println("ERROR AL Insertar");
            java.util.logging.Logger.getLogger(BDD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public ResultSet showCanchas(String tipo) {
        ResultSet rs;
        String request;
        
        request = "SELECT * FROM sacaff.canchas where tipoCancha = '" + tipo+"';";

        rs = query(request);
        
        return rs;
    }

    public ResultSet getHoras(String id, String fecha) {
        
        ResultSet rs;
        String request;
        
        request = "SELECT * FROM sacaff.reservas where idCancha = "+id+ " and fecha = '"+fecha+"';";

        rs = query(request);
        
        return rs;
    }

    public void Reservar(String id, String fecha, String hora_id, String cliente) throws SQLException {
        
        Integer id1 = this.getId()+1;
        
        System.out.println(id1);
        System.out.println(id);
        System.out.println(hora_id);
        System.out.println(fecha);
        System.out.println(cliente);
        String q = "INSERT INTO sacaff.reservas VALUES (" +id1 + "," + id + "," + hora_id +",'"+fecha+ ",'" + cliente + "')";
        System.out.println(q);
        stmt.executeUpdate("INSERT INTO sacaff.reservas VALUES(" +id1 + "," + id + "," + hora_id +",'"+fecha+ "','" + cliente + "')"); 
       
    }
}
