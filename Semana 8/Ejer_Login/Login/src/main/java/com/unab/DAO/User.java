
package com.unab.DAO;

import com.unab.DB.ConnectMySql;
import com.unab.Entidades.Estudiante;

import java.sql.*;
import javax.swing.JOptionPane;

public class User {

    ConnectMySql connect = new ConnectMySql();
    Connection conn = connect.getConnection();
    int confirmation = 0;
    
    
    public int Acces(Estudiante st){
        
        String sqlQuery = "{call clase.SP_VALIDATION_USER(?,?)}";
        
        try {
            
            CallableStatement cs = conn.prepareCall(sqlQuery);
            cs.setString("VuserName", st.getUsername());
            cs.setString("Vpassword", st.getPasswordUser());
            ResultSet rs = cs.executeQuery();
            
            if (rs.next()) {
                
                confirmation = 1;
                
                return confirmation;
            }
            
        } catch (Exception ex) {
            
            JOptionPane.showMessageDialog(null, "Error" + ex.toString());
        }
        
        return confirmation;
    }
}
