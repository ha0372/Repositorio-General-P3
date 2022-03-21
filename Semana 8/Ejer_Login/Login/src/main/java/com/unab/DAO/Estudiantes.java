/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.DAO;

import com.unab.DB.ConnectMySql;
import com.unab.Entidades.Estudiante;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Crob01
 */
public class Estudiantes {

    ConnectMySql con = new ConnectMySql();
    Connection conexion = con.getConnection();

    public ArrayList<Estudiante> listar() /*throws SQLException*/ {

        ArrayList<Estudiante> listado = null;

        try {
            listado = new ArrayList<Estudiante>();
            CallableStatement cd = conexion.prepareCall("{call SP_S_ESTUDIANTE()}");
            ResultSet resultado = cd.executeQuery();

            while (resultado.next()) {
                Estudiante es = new Estudiante();
                es.setNombre(resultado.getString("Nombre"));
                es.setApellido(resultado.getString("Apellido"));
                listado.add(es);
            }

        } 
        catch (Exception e) {
            System.out.println(e.toString());
        }
        
        return listado;

    }
    
    public void AddStudent(Estudiante est){
        
        try{
            CallableStatement cb = conexion.prepareCall("{call SP_I_ESTUDIANTE(?,?)}");
            cb.setString("PNombre",est.getNombre());
            cb.setString("PApellido", est.getApellido());
            
            cb.execute();
                  
            JOptionPane.showMessageDialog(null, "Estudiante Agregado","Mensaje sistema",1);
        }
        catch(Exception ex){
            
            JOptionPane.showMessageDialog(null, "Error" + ex.toString());
        }
    }
}