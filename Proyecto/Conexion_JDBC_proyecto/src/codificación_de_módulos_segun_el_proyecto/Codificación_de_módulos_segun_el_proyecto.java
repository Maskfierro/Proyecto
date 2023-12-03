
package codificación_de_módulos_segun_el_proyecto;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Codificación_de_módulos_segun_el_proyecto {
    
    public static void main(String[] args) {
        
        String User = "root";
        String Password = "";
        String url = "jdbc:mysql://localhost:3306/modelo_relacional_proyect";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Codificación_de_módulos_segun_el_proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Connection conexion;
        Statement estado;
        Statement eliminar;
        ResultSet rs;
        
       
        try {
     
        conexion = DriverManager.getConnection(url,User,Password);
        estado = conexion.createStatement();
        /*estado.executeUpdate("INSERT INTO registro (Nombre, Numero_Compras) VALUES ('Nicolas', '3') ");*/
        eliminar = conexion.createStatement();
        eliminar.executeUpdate("DELETE FROM registro WHERE ID = 10");
        rs = estado.executeQuery("SELECT * FROM registro");
        
        rs.next();
        do{
          System.out.println(rs.getInt("ID") + "-" + rs.getString("Nombre") + ":" + rs.getString("Numero_Compras"));
        } while(rs.next());
            
                    } catch (SQLException ex) {
            Logger.getLogger(Codificación_de_módulos_segun_el_proyecto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
