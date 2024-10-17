package servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dtos.ClubDto;
import dtos.UsuarioDto;

public interface ConsultaSQLInterfaz {

	public void añadirUsuarioBD(Connection conexionGenerada, UsuarioDto nuevoUsuario );
	public ResultSet listaBaseDatoClubs() throws SQLException;
	
	
	/*
	 * --------------------CLUBS-------------------------------
	 */
	public void modificarClubBD() throws SQLException;
	
	public void añadirClubBD(Connection conexionGenerada, ClubDto nuevoClub ) throws SQLException;

}
