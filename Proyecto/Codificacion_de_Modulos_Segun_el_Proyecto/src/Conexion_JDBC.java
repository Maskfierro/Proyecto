
import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion_JDBC {
	
	public static void main (String[] args){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //se instancia el Driver o una libreria externa, con la sentencia "Class.forName("");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Se necesita conectar al servidor por medio un usuario y una contraseña para acceder al igual que con la URL del servidor
		
		String Usuario = "root"; // Nombre de usuario del servidor
		String Contraseña = ""; // En este caso el servidor no tiene contraseña
		String url = "jdbc:mysql://localhost:3306/Modelo_Relacional_Proyecto"; // Link del servidor a la "DB" a la cual se accedera
		
		Connection Conexion ; //permite establecer conexion con el servidor
		ResultSet respuesta ; // Genera una respuesta desde la base de datos (reflejo de una tabla que se modificara o que se agregara)
		
		Statement estado;
		
		
		try {
			
			
			Conexion = DriverManager.getConnection(url,Usuario,Contraseña); //Se instancia la conexion con el drivermanager y el Try/Catch es para buscar ese driver que acabamos de agregar
			estado = Conexion.createStatement(); //Permitira ejecutar sentencias SQL a travez de la conexion
//**************************************************************************************************************************************************************************************************			
			
		int num;
		
		JOptionPane.showMessageDialog(null, "Buenas tardes isntructor recuerde que al ejecutar una opcion los datos de la tabla se cambiaran o se borran segun como esta escrito en el codigo");
		num = Integer.parseInt(JOptionPane.showInputDialog("1. VER DATOS\n\n"+ "2. CREAR DATOS PARA LA TABLA\n\n"+ "3. ACTUALIZAR DATOS PARA TABLA\n\n"+ "4. BORRAR DATOS PARA TABLA\n\n"+ "5. Salir"));
		
		switch (num) {
		
		case 1 : //VER LOS DATOS DE LA TALBA ACTUAL
				 respuesta = estado.executeQuery("SELECT * FROM pedido");//(reflejo de una tabla que se modificara o que se agregara)
				 respuesta.next(); //Permitira mostrar una columna de la tabla, luego la siguiente y asi sucesivamente
		
				 	do {//Se creara el bucle do while para que se pueda mostrar la tabla con sus columnas
		
				 			System.out.println(respuesta.getInt("ID")+ "|" +respuesta.getString("Direccion")+" | "+ respuesta.getString("Nombre")+ " | "+ respuesta.getString("Apellido")+" | "+respuesta.getInt("Cantidad") );
				 		}while (respuesta.next());
		break;
		
		case 2 : //CREAR MAS DATOS PARA LA TABLA
				 estado.executeUpdate("INSERT INTO pedido (ID, Direccion, Nombre, Apellido, Cantidad) VALUES ('5' ,'Bucaramanga', 'Johan', 'Tirado', '5')");
				 respuesta = estado.executeQuery("SELECT * FROM pedido");
				 respuesta.next();
				 
				 	do {//Se creara el bucle do while para que se pueda mostrar la tabla con sus columnas
						
			 				System.out.println(respuesta.getInt("ID")+ "|" +respuesta.getString("Direccion")+" | "+ respuesta.getString("Nombre")+ " | "+ respuesta.getString("Apellido")+" | "+respuesta.getInt("Cantidad") );
			 			}while (respuesta.next());
		break;	 	
				 	
		case 3 : //ACTUALIZAR LOS DATOS DE LA TALBA
				 estado.executeUpdate("UPDATE pedido SET Apellido = 'Juan' WHERE ID = '5' ");
				 respuesta = estado.executeQuery("SELECT * FROM pedido");
				 respuesta.next();
		 
				 	do {//Se creara el bucle do while para que se pueda mostrar la tabla con sus columnas
				
				 			System.out.println(respuesta.getInt("ID")+ "|" +respuesta.getString("Direccion")+" | "+ respuesta.getString("Nombre")+ " | "+ respuesta.getString("Apellido")+" | "+respuesta.getInt("Cantidad") );
				 		}while (respuesta.next());
		break;
				 	
		case 4 : //BORRAR DATOS DE LA TABLA
			 estado.executeUpdate("DELETE FROM pedido WHERE ID = 5");
			 respuesta = estado.executeQuery("SELECT * FROM pedido");
			 respuesta.next();
	 
			 	do {//Se creara el bucle do while para que se pueda mostrar la tabla con sus columnas
			
			 			System.out.println(respuesta.getInt("ID")+ "|" +respuesta.getString("Direccion")+" | "+ respuesta.getString("Nombre")+ " | "+ respuesta.getString("Apellido")+" | "+respuesta.getInt("Cantidad") );
			 		}while (respuesta.next());
		break;
			 	
		case 5 : break;
		
		};
				} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
		
	}

}
