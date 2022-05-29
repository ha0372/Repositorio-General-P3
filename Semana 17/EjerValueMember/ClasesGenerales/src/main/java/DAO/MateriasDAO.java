package DAO;

import Entidades.*;
import com.william.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MateriasDAO {

    ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<Materia> ListadoM() {
        ArrayList<Materia> listado = null;

        try {
            listado = new ArrayList<Materia>();

            CallableStatement cb = conexion.prepareCall("{call clase.SP_R_MATERIA()}");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                //Llamar a el objeto de entidades.
                Materia m = new Materia();

                m.setIdMateria(resultado.getInt("idMateria"));
                m.setNombreMateria(resultado.getString("NombreMateria"));
                listado.add(m);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return listado;

    }
}
