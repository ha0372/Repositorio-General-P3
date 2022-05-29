/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Estudiante;
import Entidades.Nota;
import ViewModel.NotaVM;
import com.william.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author William
 */
public class Notas {

    ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<NotaVM> ListadoEstudiantesConNotas() {
        ArrayList<NotaVM> listado = null;

        try {
            listado = new ArrayList<NotaVM>();

            CallableStatement cb = conexion.prepareCall("{call SP_S_MOSTRARNOTAS()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                NotaVM es = new NotaVM();

                es.setNombre(resultado.getString("Nombre"));
                es.setNombre(resultado.getString("Apellido"));
                es.setNombremateria(resultado.getString("NombreMateria"));
                es.setNota(resultado.getString("nota"));
//                es.setFechadeNcimiento(resultado.getString("FechaNc"));
                listado.add(es);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }

    public void AgregarNota(Nota n) {

        String query = "{call SP_I_NOTA(?,?,?)}";

        try {
            CallableStatement cb = conexion.prepareCall(query);
            cb.setString("Pnota", n.getNota());
            cb.setInt("PfkMateria", n.getFkMateria());
            cb.setInt("PfkEstudiante", n.getFkEstudiante());

            cb.execute();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.toString(), "Mensje sistems", 1);

        }

    }
//    public void ex(){
//    
//    String inicio = null;
//    String fin = null;
//    
//    inicio = "";
//    if (inicio.isEmpty()== inicio.equals("")){
//    
//    }
//        
//    }

}
