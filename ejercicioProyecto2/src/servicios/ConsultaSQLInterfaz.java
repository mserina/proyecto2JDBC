package servicios;

import java.sql.Connection;
import java.sql.ResultSet;

import dtos.ClubDto;
import dtos.UsuarioDto;

public interface ConsultaSQLInterfaz {

	public void añadirUsuarioBD(Connection conexionGenerada, UsuarioDto nuevoUsuario );
	
	public void añadirClubBD(Connection conexionGenerada, ClubDto nuevoClub );
	
	public ResultSet listaBaseDato();
	
}
