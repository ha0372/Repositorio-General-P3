/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unab.DAO;

import com.unab.DB.ConnectMySql;
import com.unab.Entidades.Estudiante;
import java.sql.*;
import java.util.*;

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
            CallableStatement cd = conexion.prepareCall("Select * from Estudiante");
            ResultSet resultado = cd.executeQuery();

            while (resultado.next()) {
                Estudiante es = new Estudiante();
                es.setNombre(resultado.getString("Nombre"));
                es.setApellido(resultado.getString("Apellido"));
                listado.add(es);
            }

        } 
        catch (Exception e) {
            
        }
        
        return listado;

    }
}
