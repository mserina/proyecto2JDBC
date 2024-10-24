package servicios;

import controladores.inicio;

public class MenuImplementacion implements MenuInterfaz{

	
	public byte mostrarMenu(){
		inicio i = new inicio();
		
		byte opcionUsuario = 0;
		
		System.out.println(" ");
		System.out.println("MENU PRINCIPAL");
		System.out.println("---------------");
		System.out.println("0[] Cerrar");
		System.out.println("1[] Usuarios");
		System.out.println("2[] Clubs");
		System.out.println(" ");
		
		opcionUsuario = i.sc.nextByte();
		
		return opcionUsuario;
	}
	
	private byte mostrarMenuUsuario(){
		inicio i = new inicio();
		
		byte opcionUsuario = 0;
		
		System.out.println(" ");
		System.out.println("MENU USUARIO");
		System.out.println("---------------");
		System.out.println("0[] Cerrar");
		System.out.println("1[] Alta Usuario");
		System.out.println("2[] Baja Usuario");
		System.out.println("3[] Modificar Usuario");
		
		opcionUsuario = i.sc.nextByte();
		
		return opcionUsuario;
	}
	
	private byte mostrarMenuClub(){
		inicio i = new inicio();
		
		byte opcionUsuario = 0;
		
		System.out.println(" ");
		System.out.println("MENU CLUB");
		System.out.println("---------------");
		System.out.println("0[] Cerrar");
		System.out.println("1[] Alta Club");
		System.out.println("2[] Baja Club");
		System.out.println("3[] Modificar Club");
		
		opcionUsuario = i.sc.nextByte();
		
		return opcionUsuario;
	}
	
	
	public void menuUsuario() {
		boolean cerrarMenu = false;
		byte opcionUsuario = 0;
		ConsultaSQLInterfaz consulta = new ConsultaSQLImplementacion();
		
		
		do {
			try {
				opcionUsuario = mostrarMenuUsuario();
				
				switch(opcionUsuario) {
				
				case 0:
					cerrarMenu = true;
					break;
				case 1:
					consulta.añadirUsuarioBD();
					cerrarMenu = true;
					break;
				case 2:
					consulta.eliminarUsuarioBD();
					cerrarMenu = true;
					break;
				case 3:
					consulta.modificarUsuarioBD();
					cerrarMenu = true;
					break;
				}
				
			}catch(Exception e) {
				
				System.out.println("ERROR[]" + e.getMessage());
			}
		}while(!cerrarMenu);
	}
	
	
	public void menuClub() {
		boolean cerrarMenu = false;
		byte opcionUsuario = 0;
		//BORRAR
		ConsultaSQLInterfaz consul = new ConsultaSQLImplementacion();
		
		do {
			try {
				opcionUsuario = mostrarMenuClub();
				
				switch(opcionUsuario) {
				
				case 0:
					cerrarMenu = true;
					break;
				case 1:
					consul.añadirClubBD();
					cerrarMenu = true;
					break;
				case 2:
					consul.eliminarClubBD();
					cerrarMenu = true;
					break;
				case 3:
					consul.modificarClubBD();
					cerrarMenu = true;
					break;
				}
				
			}catch(Exception e) {
				
				System.out.println("ERROR[]" + e.getMessage());
			}
		}while(!cerrarMenu);
	}
}
