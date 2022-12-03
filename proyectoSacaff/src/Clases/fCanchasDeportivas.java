/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import Datos.CanchasDeportivas;


import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Vichosty
 */

//intento de conectarme al mysql 
//todavía no se como
public class fCanchasDeportivas {
    @SuppressWarnings("FieldMayBeFinal")
    private Conexion mysql = new Conexion();
    @SuppressWarnings("FieldMayBeFinal")
    private Connection cn=mysql.conectar();
    private String sSql="";
    public Integer totalregistros;
    


public DefaultTableModel mostrar (String buscar){
    DefaultTableModel modelo;
    String [] titulos = {"ID", "Nombre", "Tipo", "Costo por hora"};
    
    String [] registro = new String[4];

    totalregistros = 0;
    modelo = new DefaultTableModel(null,titulos);
    
    //seleccionar desde una tabla de nombre canchas en la base de datos
    
    sSql="select * from canchas where nombreCancha like '%'"+ buscar + "'%' order by idCancha";
    try {
        PreparedStatement st=cn.prepareStatement(sSql);
        ResultSet rs=st.executeQuery(sSql); 
        while(rs.next()){
            registro [0] = rs.getString("idCancha");
            registro [1] = rs.getString("nombreCancha");
            registro [2] = rs.getString("tipoCancha");
            registro [3] = rs.getString("costoPorHora");
            totalregistros = totalregistros +1;
            modelo.addRow(registro);
        }
    }catch(Exception e){
        JOptionPane.showConfirmDialog(null, e);
    }
    return null;
}

    public boolean insertar(CanchasDeportivas dts){
        sSql = "insert into canchas(nombreCancha,tipoCancha,costoPorHora)" + "values (?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSql);

            pst.setString(1,dts.getNombreCancha());
            pst.setString(2,dts.getTipoCancha());
            pst.setInt(3,dts.getCostoPorHora());
            
            int n=pst.executeUpdate();
            if (n!= 0){
                
                return true; 
            }
            else {
            return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    
        
    }
    
    public boolean editar(CanchasDeportivas dts){
        sSql ="update canchas set nombreCancha=?,tipoCancha=?,costoPorHora=? where idCancha=?";
        try {
            PreparedStatement pst=cn.prepareStatement(sSql);

            pst.setString(1,dts.getNombreCancha());
            pst.setString(2,dts.getTipoCancha());
            pst.setInt(3,dts.getCostoPorHora());
            pst.setInt(4,dts.getIdCancha());
            int n=pst.executeUpdate();
            if (n!= 0){
                
                return true; 
            }
            else {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }  
    
    
    
    public boolean eliminar(CanchasDeportivas dts){
        sSql="delete from cancha where idCancha=?";    
        
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSql);

            pst.setString(1,dts.getNombreCancha());
            pst.setString(2,dts.getTipoCancha());
            pst.setInt(3,dts.getCostoPorHora());
            pst.setInt(4,dts.getIdCancha());
            int n=pst.executeUpdate();
            if (n!= 0){
                
                return true; 
            }
            else {
                return false;
            }
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }


}

