package servicios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import dtos.ClubDto;
import dtos.UsuarioDto;

public interface ConsultaSQLInterfaz {

	public ResultSet listaBaseDatoClubs() throws SQLException;
	
	
	/*
	 * --------------------CLUBS-------------------------------
	 */
	public void modificarClubBD() throws SQLException;
	
	public void añadirClubBD() throws SQLException;
	
	public void eliminarClubBD() throws SQLException;
	/*
	 * ---------------------USUARIO------------------------------
	 */
	public void añadirUsuarioBD() throws SQLException;
	
	public void modificarUsuarioBD() throws SQLException;
	
	public void eliminarUsuarioBD() throws SQLException;
	

}
