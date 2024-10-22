package servicios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConexionPostgreSQLImplementacion implements ConexionPostgreSQLInterfaz{

	@Override
	public Connection generaConexion() {
		Connection conexion = null;
		String[] parametrosConexion = configuracionConexion(); //url, user, pass
		
		if(!parametrosConexion[2].isEmpty()) { //Se controla que los parámetros de conexión se completen
			try {
				//Instancia un objeto de la clase interfaz que se le pasa
				Class.forName("org.postgresql.Driver");
				
				//Se establece la conexión
				//Si pgadmin no tiene abierta la bd, no será posible establecer conexion contra ella
				conexion = DriverManager.getConnection(parametrosConexion[0],parametrosConexion[1],parametrosConexion[2]);
				boolean esValida = conexion.isValid(50000);
				//Si la conexion falla se establece un valor null, haciendo que se ative el catch y salga un texto informando sobre error de conexion
				if(esValida == false) {
					conexion = null;
				}
				
				//Si todo es correcto imprime un texto informando que tuvo exito la conexion
				System.out.println(esValida ? "[INFORMACIÓN-ConexionPostgresqlImplementacion-generaConexion] Conexión a PostgreSQL válida" : "[ERROR-ConexionPostgresqlImplementacion-generaConexion] Conexión a PostgreSQL no válida");
	            
			} catch (ClassNotFoundException cnfe) {
				System.err.println("[ERROR-ConexionPostgresqlImplementacion-generaConexion] Error en registro driver PostgreSQL: " + cnfe);
				conexion = null;
			} catch (SQLException jsqle) {
				System.err.println("[ERROR-ConexionPostgresqlImplementacion-generaConexion] Error en conexión a PostgreSQL (" + parametrosConexion[0] + "): " + jsqle);
				conexion = null;
			}
			
		}else {
			System.out.println("[ERROR-ConexionPostgresqlImplementacion-generaConexion] Los parametros de conexion no se han establecido correctamente");	
			conexion = null;
		}
		return conexion;
		
	}
	
	private String[] configuracionConexion() {
		
		//Creamos la variables que contendra los parametros necesarios para establecer la conexion con nuestra base de datos (usuario, puerto, host, nombre de la base dato, url de la base dato)
		String user="", pass="", port="", host="", db="", url="";
		
		//Creamos un array que contenga los valores de las variables una vez se les asigne sus respectivos valores
		String[] stringConfiguracion = {"","",""};
		
		//Properties, que se utiliza para almacenar pares clave-valor en formato de texto
		Properties propiedadesConexion = new Properties();
		try {
			
			//Aqui cargamos los datos del fichero parametros, que contendra la clave (p ej: usuario) y el valor (p ej: Pedro)
			propiedadesConexion.load(new FileInputStream(new File("C:\\Users\\Alumno\\Desktop\\proyecto2JDBC\\ejercicioProyecto2\\src\\parametros.txt")));
			
			//Y se los vamos pasando a las variables 
			user = propiedadesConexion.getProperty("user");
			pass = propiedadesConexion.getProperty("pass");
			port = propiedadesConexion.getProperty("port");
			host = propiedadesConexion.getProperty("host");
			db = propiedadesConexion.getProperty("db");
			
			//Con los datos construimos la url
			url = "jdbc:postgresql://" + host + ":" + port + "/" + db;
			
			//Y vamos metiendo en el array el valor que le corresponda
			stringConfiguracion[0] = url;
			stringConfiguracion[1] = user;
			stringConfiguracion[2] = pass;
		} catch (FileNotFoundException e) {
			System.err.println("[ERROR-ConexionPostgresqlImplementacion-configuracionConexion] - Error al acceder al fichero propiedades de conexion.");
			stringConfiguracion[0] = "";
			stringConfiguracion[1] = "";
			stringConfiguracion[2] = "";
		} catch (IOException e) {
			System.err.println("[ERROR-ConexionPostgresqlImplementacion-configuracionConexion] - Error al acceder al fichero propiedades de conexion.");
			stringConfiguracion[0] = "";
			stringConfiguracion[1] = "";
			stringConfiguracion[2] = "";
		}

		//Y aqui se devuelve el array con los parametros para esatblecer la configuracion
		return stringConfiguracion;
	}

	
	
}
