
    public boolean insertar(CanchasDeportivas dts){
        sSql = "insert into canchas(nombreCancha,tipoCancha,costoPorHora)" + "values (?,?,?)";
        try {
            PreparedStatement pst=cn.prepareStatement(sSql);

            pst.setString(1,dts.getNombreCancha());
            pst.setString(2,dts.getTipoCancha());
            pst.setDouble(3,dts.getCostoPorHora());
            
            int n=pst.executeUpdate();
            if (n!= 0){
                
                return true; 
            }
            else {
            return false;
            }
            
        } catch (SQLException e) {
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
            pst.setDouble(3,dts.getCostoPorHora());
            pst.setInt(4,dts.getIdCancha());
            int n=pst.executeUpdate();
            if (n!= 0){
                
                return true; 
            }
            else {
                return false;
            }
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }  
    
    
    
    public boolean eliminar(CanchasDeportivas dts){
        sSql="delete from cancha where idCancha=?";    
        
        
        try {
            PreparedStatement pst=cn.prepareStatement(sSql);
            pst.setInt(1,dts.getIdCancha());
            int n=pst.executeUpdate();
            if (n!= 0){
                
                return true; 
            }
            else {
                return false;
            }
            
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }


}


