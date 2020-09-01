package servicios;

import estructural.Enfermedad;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class SerivicioEnfermedad {
    public SerivicioEnfermedad() {
        super();
    }
    static Conexion conectar = new Conexion();
    private static Connection con;
    private static  PreparedStatement ps;
    private static  ResultSet rs;
    
    public static int agregarEnfermedad(Enfermedad enfermedad) {
          String sql = "insert into enfermedad (CODIGO,NOMBRE,TIPO) values(?,?,?)";
           try {
               con = conectar.getConnection();
               ps = con.prepareStatement(sql);
               ps.setInt(1, enfermedad.getCodigo());
               ps.setString(2, enfermedad.getNombre());
               ps.setString(3, enfermedad.getNombre());
              
               ps.executeUpdate();
             
           } catch (Exception e) {
           }
           return 1;
       }
    
    public static List listarEnfermedades() {
               
        List<Enfermedad> listaEnfermedad = new ArrayList<>();
        String sql = "select * from enfermedad";
           try {
               con = conectar.getConnection();
               ps = con.prepareStatement(sql);
               rs = ps.executeQuery();
               while(rs.next())
               {
                   Enfermedad e = new Enfermedad();
                   e.setCodigo(rs.getInt(1));
                   e.setNombre(rs.getString(2));
                   e.setTipo(rs.getString(3));
                   listaEnfermedad.add(e);
               }
           } catch (Exception e) {
           }
        return listaEnfermedad;
       }
}
