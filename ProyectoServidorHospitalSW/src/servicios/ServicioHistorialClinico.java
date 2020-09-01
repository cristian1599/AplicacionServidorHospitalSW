package servicios;

import estructural.Enfermedad;
import estructural.HistorialClinico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicioHistorialClinico {
    public ServicioHistorialClinico() {
        super();
    }
    static Conexion conectar = new Conexion();
    private static Connection con;
    private static  PreparedStatement ps;
    private static  ResultSet rs;
    
    public static int agregarHistorial(HistorialClinico historial) {
          String sql = "insert into HISTORIAL_CLINICO (IDHISTORIAL,NUMEROHISTORIA,NOMBRE_DOCTOR,FK_IDPACIENTE,FK_IDENFERMEDAD) VALUES(HISTORIAL_SEQ.NEXTVAL,?,?,?,?)";
          
           try {
               con = conectar.getConnection();
               ps = con.prepareStatement(sql);
               
               ps.setInt(1, historial.getNumeroHistoria());
               ps.setString(2,historial.getNombreDoctor());
               ps.setString(3, historial.getFk_paciente());
               ps.setInt(4, historial.getFk_enfermedad());
               ps.executeUpdate();
               
           } catch (Exception e) {
           }
       
           return 1;
       }
    
    public static HistorialClinico buscarHistorial(int pNumero,String pDocumento){
          HistorialClinico h = null;
          int id;
          int numero;
          String nombre;
          String documento;
          int codigo;
          String sql = "select * from HISTORIAL_CLINICO  where NUMEROHISTORIA = '"+ pNumero +"' OR FK_IDPACIENTE = '"+ pDocumento +"'";
           try {
                con = conectar.getConnection(); 
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if(rs.next())
                {
                    id = rs.getInt(1);
                    numero = rs.getInt(2);
                    nombre = rs.getString(3);
                    documento = rs.getString(4);
                    codigo = rs.getInt(5);
                    h = new HistorialClinico(id,numero,nombre,documento,codigo);
                }
           } catch (Exception e) {
           }
           
           return h;
       }
    
    public static HistorialClinico buscarHistorialSolo(int pNumero){
          HistorialClinico h = null;
          int id;
          int numero;
          String nombre;
          String documento;
          int codigo;
          String sql = "select * from HISTORIAL_CLINICO  where NUMEROHISTORIA = '"+ pNumero +"'";
           try {
                con = conectar.getConnection(); 
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                if(rs.next())
                {
                    id = rs.getInt(1);
                    numero = rs.getInt(2);
                    nombre = rs.getString(3);
                    documento = rs.getString(4);
                    codigo = rs.getInt(5);
                    h = new HistorialClinico(id,numero,nombre,documento,codigo);
                }
           } catch (Exception e) {
           }
           
           return h;
       }
    
    public static int modificarHistorial(HistorialClinico historial, int numero) {
          String sql = "update HISTORIAL_CLINICO set NUMEROHISTORIA=?,NOMBRE_DOCTOR=?, FK_IDPACIENTE=?, FK_IDENFERMEDAD=? where NUMEROHISTORIA = '"+ numero +"'" ;
           int modificado = 0;
           try {
               con = conectar.getConnection();
               ps = con.prepareStatement(sql);
               ps.setInt(1, historial.getNumeroHistoria());
               ps.setString(2, historial.getNombreDoctor());
               ps.setString(3, historial.getFk_paciente());
               ps.setInt(4, historial.getFk_enfermedad());
               modificado = ps.executeUpdate();
               if(modificado == 1)
                 
               {
                   return 1;
               }else{
                   return 0;
               }
               
                 
           } catch (Exception e) {
           }
           return modificado;
       }
    
    public static void eliminarHistorial(int pNumero) {
           String sql = "delete from HISTORIAL_CLINICO  where NUMEROHISTORIA = '"+ pNumero +"'" ;
           try {
               con = conectar.getConnection();
               ps = con.prepareStatement(sql);
               ps.executeUpdate();
           } catch (Exception e) {
           }
       }
    
    public static List listarHistorial() {
            List<HistorialClinico> listaHistorial = new ArrayList<>();
            String sql = "select * from HISTORIAL_CLINICO";
            try {
                con = conectar.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
               while(rs.next())
               {
                   HistorialClinico h = new HistorialClinico();
                   h.setCodigo(rs.getInt(1));
                   h.setNumeroHistoria(rs.getInt(2));
                   h.setNombreDoctor(rs.getString(3));
                   h.setFk_paciente(rs.getString(4));
                   h.setFk_enfermedad(rs.getInt(5));
                   listaHistorial.add(h);
               }
            } catch (Exception e) {
                
            }
            return listaHistorial;
        }
    
    public static List listarHistorialPorParametro(String nombre) {
             List<HistorialClinico> listaHistorial = new ArrayList<>();
            String sql = "select * from HISTORIAL_CLINICO WHERE NOMBRE_DOCTOR = '"+ nombre +"'";
            try {
                con = conectar.getConnection();
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
               while(rs.next())
               {
                   HistorialClinico h = new HistorialClinico();
                   h.setCodigo(rs.getInt(1));
                   h.setNumeroHistoria(rs.getInt(2));
                   h.setNombreDoctor(rs.getString(3));
                   h.setFk_paciente(rs.getString(4));
                   h.setFk_enfermedad(rs.getInt(5));
                   listaHistorial.add(h);
               }
            } catch (Exception e) {
                
            }
            return listaHistorial;
        }
    
   


    
}
