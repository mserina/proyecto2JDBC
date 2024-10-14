package servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
			System.err.println("[ERROR-ConsultasPostgresqlImplementacion-seleccionaTodosLibros] Error generando o ejecutando la declaracionSQL: " + e.getLocalizedMessage());
		}
	}
}
