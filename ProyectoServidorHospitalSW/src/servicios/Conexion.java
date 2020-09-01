package servicios;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Conexion() {
        super();
    }
    
    Connection con;
    public Connection getConnection()
      {
       String url = "jdbc:oracle:thin:@localhost:1521:orcl";
       String user = "HOSPITAL";
       String pass = "HOSPITAL";
      
      
          try {
              Class.forName("oracle.jdbc.driver.OracleDriver");
              con = DriverManager.getConnection(url,user,pass);
             if(con != null)
             {
                 System.out.println("conexion exitosa");
             }else{
                 System.out.println("conexion fallida");
             }
                 
                      
          } catch (ClassNotFoundException | SQLException e) {
              System.out.println("Errado" + e.getMessage());
          }
          return con;
      }
}
