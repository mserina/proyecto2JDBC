package servicios;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import controladores.inicio;
import dtos.ClubDto;
import dtos.UsuarioDto;

public class ConsultaSQLImplementacion implements ConsultaSQLInterfaz {

	public void añadirUsuarioBD(Connection conexionGenerada, UsuarioDto nuevoUsuario ) {
		
		String sql = "INSERT INTO \"esquemaclub\".\"usuario\" (idusuario, nombres, apellidos, telefono, correo, \"idClub\") VALUES (?, ?, ?, ?, ?, ?)";
		
		 try (PreparedStatement preparedStatement = conexionGenerada.prepareStatement(sql)) {
			 
		        // Asignamos los valores del DTO a los parámetros de la consulta SQL
		        preparedStatement.setLong(1, nuevoUsuario.getIdUsuario()); // Primer parámetro: id del usuario
		        preparedStatement.setString(2, nuevoUsuario.getNombreC()); // Segundo parámetro: nombre
		        preparedStatement.setString(3, nuevoUsuario.getApellidoC()); // Tercer parámetro: apellido
		        preparedStatement.setInt(4, nuevoUsuario.getTelefono()); // Cuarto parámetro: telefono
		        preparedStatement.setString(5, nuevoUsuario.getCorreo()); //Quinto parametro: correo
		        preparedStatement.setLong(6, nuevoUsuario.getIdClubCF()); //Sexto parametro: id del club donde el usuario esta
		        
		        // Ejecutamos el INSERT
		        int filasInsertadas = preparedStatement.executeUpdate();
		        
		        // Confirmamos si la inserción fue exitosa
		        if (filasInsertadas > 0) {
		            System.out.println("¡Inserción exitosa!");
		        }
		        
		    }catch(SQLException e) {
			System.err.println("[ERROR] Error generando o ejecutando la declaracionSQL: " + e.getLocalizedMessage());
		}
	}
	
	public void añadirClubBD(Connection conexionGenerada, ClubDto nuevoClub ) throws SQLException {
		ResultSet resultado = listaBaseDatoClubs();
		boolean usuarioRepetido = false;
		int contador = 0;
		
		while(resultado.next()) {
			
			if(resultado.getString("nombreClub").equals(nuevoClub.getNombreClubC())) {
				
				usuarioRepetido = true;
				break;
			}
			contador ++;
		}
		
		if(!usuarioRepetido) {
			
			String sql = "INSERT INTO \"esquemaclub\".\"club\" (idclub, nombreclub, sedeprincipal, fechacreacion, entradapublica, codigoprivado) VALUES (?, ?, ?, ?, ?, ?)";
			
			 try (PreparedStatement preparedStatement = conexionGenerada.prepareStatement(sql)) {
				 
			        // Asignamos los valores del DTO a los parámetros de la consulta SQL
			        preparedStatement.setLong(1, contador + 1); 
			        preparedStatement.setString(2, nuevoClub.getNombreClubC()); 
			        preparedStatement.setString(3, nuevoClub.getSedePrincipalC()); 
			        preparedStatement.setDate(4, java.sql.Date.valueOf(nuevoClub.getFechaCreacionC())); 
			        preparedStatement.setBoolean(5, nuevoClub.isEntradaPublicaC()); 
			        preparedStatement.setString(6, nuevoClub.getCodigoPrivado()); 
			        
			        // Ejecutamos el INSERT
			        int filasInsertadas = preparedStatement.executeUpdate();
			        
			        // Confirmamos si la inserción fue exitosa
			        if (filasInsertadas > 0) {
			            System.out.println("¡Inserción exitosa!");
			        }
			        
			    }catch(SQLException e) {
				System.err.println("[ERROR] Error generando o ejecutando la declaracionSQL: " + e.getLocalizedMessage());
			}
		}
		else {
			
			System.out.println("AVISO[] YA EXISTE UN CLUB CON ESE NOMBRE");
		}
	}
	
	
	public ResultSet listaBaseDatoClubs() throws SQLException {
		Statement consulta = inicio.conexion.createStatement();
		String query = "SELECT * FROM esquemaclub.\"club\"";
		ResultSet resultadoQuery = consulta.executeQuery(query);
		
		return resultadoQuery;
	}
	
	
	public void modificarClubBD() throws SQLException{
		Connection conexion = inicio.conexion;
		ResultSet resultado = listaBaseDatoClubs();
		String sql;
		String opcion;
		String nombreInsertado;
		PreparedStatement sentencia = null;
		int filasModificadas;
		
		System.out.println("Inserte nombre del club a modificar");
		nombreInsertado = inicio.sc.next();
		
		System.out.println("¿Que campo quiere cambiar?");
		opcion = inicio.sc.next();
				
		switch(opcion) {
		
		case "nombre":
			//Se  crea la estructura de la query
			sql = "UPDATE esquemaclub.\"club\" SET nombreclub = ? WHERE nombreclub = ?"; 
			
			//Se guarda dicha estructura en un PreparedStatement (de forma que la query tenga una estructura fija, evitando inyecciones sql)
			sentencia = conexion.prepareStatement(sql);
			System.out.println("Inserte el nuevo del nombre del club");
			
			//Se pide el valor a cambiar
			sentencia.setString(1, inicio.sc.next());
			
			//Aqui se especifica el nombre del club al que queremos cambiarle el nombre (se le paso antes)
			sentencia.setString(2, nombreInsertado);
			break;
		case "sede":
			sql = "UPDATE esquemaclub.\"club\" SET sedeprincipal = ? WHERE nombreclub = ?"; 
			sentencia = conexion.prepareStatement(sql);
			System.out.println("Inserte la nueva sede del club");
			sentencia.setString(1, inicio.sc.next());
			sentencia.setString(2, nombreInsertado);
			break;
		case "fecha":
			sql = "UPDATE esquemaclub.\"club\" SET fechacreacion = ? WHERE nombreclub = ?"; 
			sentencia = conexion.prepareStatement(sql);
			System.out.println("Inserte la fecha del club");
			sentencia.setDate(1, Date.valueOf(inicio.sc.next()));
			sentencia.setString(2, nombreInsertado);
			break;
		case "entrada":
			sql = "UPDATE esquemaclub.\"club\" SET entradapublica = ? WHERE nombreclub = ?"; 
			sentencia = conexion.prepareStatement(sql);
			System.out.println("¿Como quiere establecer el tipo de entrada? publica/privada");
			String respuesta = inicio.sc.next();
			if(respuesta.equals("publica")) {
				sentencia.setBoolean(1, false);
			}
			else {
				sentencia.setBoolean(1, true);
			}
			sentencia.setString(2, nombreInsertado);
			break;
		}
		
		//Aqui es donde se coge el Prepared Statement que estuvimos usando para modificar datos y ejecutamos la query, lo que nos da un numero de filas como resultado
		filasModificadas = sentencia.executeUpdate();
        System.out.println("Filas afectadas: " + filasModificadas);
		
	}
	
	public void eliminarClubBD() throws SQLException{
		
		//ESTA SELECCION ES MUY PARECIDA A MODIFICAR, CON LA DIFERENCIA DE QUE AQUI SOLO NECESITAMOS INSERTAR EL NOMBRE DEL CLUB A BORRAR, ADEMAS DE LA QUERY, QUE SE USARA DELETE
		Connection conexion = inicio.conexion;
		String sql;
		String opcion;
		String nombreInsertado;
		PreparedStatement sentencia = null;
		int filasBorradas;
		
		System.out.println("Inserte nombre del club que quiera dar de baja");
		
		nombreInsertado = inicio.sc.next();
		sql = "DELETE FROM esquemaclub.\"club\" WHERE nombreclub = ?"; 
		sentencia = conexion.prepareStatement(sql);
		sentencia.setString(1, nombreInsertado);
				
		//Aqui es donde se coge el Prepared Statement que estuvimos usando para modificar datos y ejecutamos la query, lo que nos da un numero de filas como resultado
		filasBorradas = sentencia.executeUpdate();
        System.out.println("Filas afectadas: " + filasBorradas);
		
	}
	
	
	
	
	/**
	 * 
	 * public void cargaInicalC() throws SQLException{
		Statement consulta = inicio.conexion.createStatement();
		String query = "SELECT * FROM esquemaclub.\"club\"";
		ResultSet resultadoQuery = consulta.executeQuery(query);
		
		inicio.listaClub.clear();
		while (resultadoQuery.next()) {
			long idClubC = resultadoQuery.getInt("idClub");
			String nombreClubC = resultadoQuery.getString("nombreclub");
			String sedePrincipalC = resultadoQuery.getString("sedeprincipal");
			LocalDate fechaCreacionC = resultadoQuery.getDate("fechacreacion").toLocalDate();
            boolean entradaPublicaC = resultadoQuery.getBoolean("entradapublica");
            String codigoPrivado = resultadoQuery.getString("codigoprivado");
			
            ClubDto nuevoClub = new ClubDto(idClubC, nombreClubC, sedePrincipalC, entradaPublicaC, codigoPrivado, fechaCreacionC);
            inicio.listaClub.add(nuevoClub);
		}
	}
	
	public void cargaInicalU() throws SQLException{
		Statement consulta = inicio.conexion.createStatement();
		String query = "SELECT * FROM esquemaclub.\"usuario\"";
		ResultSet resultadoQuery = consulta.executeQuery(query);
		
		inicio.listaClub.clear();
		while (resultadoQuery.next()) {
			long idUsuario = resultadoQuery.getInt("idClub");
			String nombreC = resultadoQuery.getString("nombres");
			String apellidoC = resultadoQuery.getString("apellidos");
			int telefonoC = resultadoQuery.getInt("telefono");
            String correoC = resultadoQuery.getString("correo");
            long idClubCF = resultadoQuery.getLong("idClub");
			
            UsuarioDto nuevoUsuario = new UsuarioDto(idUsuario, nombreC, apellidoC, telefonoC, correoC, idClubCF);
            inicio.listaUsuario.add(nuevoUsuario);
		}
	}
	 */
	
	
}
