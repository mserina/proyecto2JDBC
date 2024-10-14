package servicios;

import controladores.inicio;
import dtos.ClubDto;
import dtos.UsuarioDto;
import util.utiles;

public class OperacionImplementacion implements OperacionInterfaz{

	
	utiles util = new utiles();
	//Usuarios
	public void altaUsuario() throws Exception{
		UsuarioDto usuario = new UsuarioDto();
		System.out.println("Inserte Nombre");
		usuario.setNombreC(inicio.sc.next());
		System.out.println("Inserte Apellidos");
		usuario.setApellidoC(inicio.sc.next());
		System.out.println("Inserte Telefono");
		usuario.setTelefono(inicio.sc.nextInt());
		System.out.println("Inserte Correo");
		usuario.setCorreo(inicio.sc.next());
		usuario.setIdUsuario(util.idGeneratorUsuarios());
		System.out.println("¿Estas en un club? s/n");
		String respuesta = inicio.sc.next();
		
		if(respuesta == "s") {
			System.out.println("Inserte id del club al que pertenece");
			usuario.setIdClubCF(inicio.sc.nextLong());
		}
		
		inicio.listaUsuario.add(usuario);
		mostrarUsuario();
		
		//Aqui es donde se añade el usuario a la base de da
		inicio.consultaSQL.añadirUsuarioBD(inicio.conexion, usuario);
		
		
	}
	
	private void mostrarUsuario() throws Exception {
		
		for(UsuarioDto usu : inicio.listaUsuario) {
			
			System.out.println(" ");
			System.out.println(usu.toString());
			System.out.println(" ");
			
		}
	}
	
	//Club
	public void altaClub() throws Exception{
		ClubDto club = new ClubDto();
		
		System.out.println("Inserte nombre del club ");
		club.setNombreClubC(inicio.sc.next());
		System.out.println("Inserte sede principal");
		club.setSedePrincipalC(inicio.sc.next());
		System.out.println("La entrada sera publica s/n");
		String respuesta = inicio.sc.next();
		if(respuesta.equals("s")) 
		{
			club.setEntradaPublicaC(true);
			
		}else {
			
			club.setEntradaPublicaC(false);
			System.out.println(" ");
			System.out.println("Inserte codigo privado para acceder");
			club.setCodigoPrivado(inicio.sc.next());
		}
		club.setIdClubC(util.idGeneratorClubs());
		
		inicio.listaClub.add(club);
		
		mostrarClub();
		
	}
	
	private void mostrarClub() throws Exception {
		
		for(ClubDto club : inicio.listaClub) {
			
			System.out.println(" ");
			System.out.println(club.toString());
			System.out.println(" ");
			
		}
	}
}
