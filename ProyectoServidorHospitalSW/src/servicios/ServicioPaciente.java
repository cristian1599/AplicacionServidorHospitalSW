    package servicios;

import estructural.Paciente;

import java.rmi.RemoteException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicioPaciente {
    public ServicioPaciente() {
        super();
    }
    
     static Conexion conectar = new Conexion();
     private static Connection con;
     private static  PreparedStatement ps;
     private static  ResultSet rs;
      
    public static int agregarPaciente(Paciente paciente) {
          String sql = "insert into paciente (ID,Documento,Nombre,Correo,Telefono,Genero) values(PACIENTE2_SEQ.NEXTVAL,?,?,?,?,?)";
           try {
               con = conectar.getConnection();
               ps = con.prepareStatement(sql);
               ps.setString(1, paciente.getDocumento());
               ps.setString(2, paciente.getNombre());
               ps.setString(3, paciente.getCorreo());
               ps.setString(4, paciente.getTelefono());
               ps.setString(5, paciente.getGenero());
               ps.executeUpdate();
             
           } catch (Exception e) {
           }
           return 1;
       }
    
    
    public static List listar(){
           List<Paciente> listaPacinte = new ArrayList<Paciente>();
            String sql = "select * from paciente";
          
            try {
                con = conectar.getConnection();
               
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next())
                {
                    Paciente p = new Paciente();
                    p.setId(rs.getInt(1));
                    p.setDocumento(rs.getString(2));
                    p.setNombre(rs.getString(3));
                    p.setCorreo(rs.getString(4));
                    p.setTelefono(rs.getString(5));
                    p.setGenero(rs.getString(6));
                    listaPacinte.add(p);
                }
            } catch (Exception e) {
                
            }
            
            return listaPacinte;
             
        }
    
    
    public static Paciente buscarPaciente(String Documento) {
            Paciente p = null; 
            String documento;
            String nombre;
            String correo;
            String telefono;
            String genero;
            int id;
            String sql = "select * from paciente where DOCUMENTO = '"+ Documento +"'";
               try {
                con = conectar.getConnection(); 
                ps = con.prepareStatement(sql);
               //ps.setString(1, Documento);
                rs = ps.executeQuery();
                 if(rs.next())
                {
                    id= rs.getInt(1);
                    documento = rs.getString(2);
                    nombre = rs.getString(3);
                    correo  = rs.getString(4);
                    telefono = rs.getString(5);
                    genero = rs.getString(6);
                    p = new Paciente(id,documento,nombre,correo,telefono,genero);
                }
                
         } catch (Exception e) {
                
            }
           
            return p;
        } 

    public static int modificarPaciente(Paciente paciente, String Documento) {
           String sql = "update paciente set DOCUMENTO=?, NOMBRE=?, CORREO=?, TELEFONO =?, GENERO =? where DOCUMENTO = '"+ Documento +"'";
           int modificar = 0;
            try {
                con = conectar.getConnection();
                ps = con.prepareStatement(sql);
                ps.setString(1, paciente.getDocumento());
                ps.setString(2, paciente.getNombre());
                ps.setString(3, paciente.getCorreo());
                ps.setString(4, paciente.getTelefono());
                ps.setString(5, paciente.getGenero());
                modificar = ps.executeUpdate();
                if(modificar == 1)
                {
                    return 1;
                }else{
                    return 0;
                }
            } catch (Exception e) {
            }
            
            return  modificar;
        }
    
    public static void eliminarPaciente(String Documento){
            String sql = "delete from paciente where DOCUMENTO = '"+ Documento +"'";
            try {
                con = conectar.getConnection();
                ps = con.prepareStatement(sql);
                ps.executeUpdate();
            } catch (Exception e) {
            }
            
        }
    
    public static List listarPorParametro(String nombre) {
           List<Paciente> listaParametro = new ArrayList<>();
           String sql = "select * from paciente where NOMBRE = '"+ nombre +"'";
          // "select * from paciente where NOMBRE = '"+ Nombre +"'"+
          
           try {
               con = conectar.getConnection();
              
               ps = con.prepareStatement(sql);
               rs = ps.executeQuery();
               while(rs.next())
               {
                   Paciente p = new Paciente();
                   p.setId(rs.getInt(1));
                   p.setDocumento(rs.getString(2));
                   p.setNombre(rs.getString(3));
                   p.setCorreo(rs.getString(4));
                   p.setTelefono(rs.getString(5));
                   p.setGenero(rs.getString(6));
                   listaParametro.add(p);
               }
           } catch (Exception e) {
               
           }
           
           return listaParametro;
       }
}
