package servicios;

import java.sql.Connection;

import dtos.UsuarioDto;

public interface ConsultaSQLInterfaz {

	public void añadirUsuarioBD(Connection conexionGenerada, UsuarioDto nuevoUsuario );
	
}
