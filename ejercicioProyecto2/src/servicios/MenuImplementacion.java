package servicios;

import controladores.inicio;

public class MenuImplementacion implements MenuInterfaz{

	OperacionInterfaz op = new OperacionImplementacion();
	
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
	
		
		do {
			try {
				opcionUsuario = mostrarMenuUsuario();
				
				switch(opcionUsuario) {
				
				case 0:
					cerrarMenu = true;
					break;
				case 1:
					op.altaUsuario();
					cerrarMenu = true;
					break;
				case 2:
					
					cerrarMenu = true;
					break;
				case 3:
					
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
					op.altaClub();
					cerrarMenu = true;
					break;
				case 2:
					
					cerrarMenu = true;
					break;
				case 3:
					consul.modificarClubBD();
					cerrarMenu = true;
					break;
					//BORRAR
				case 4: 
					consul.listaBaseDatoClubs();
					break;
				}
				
			}catch(Exception e) {
				
				System.out.println("ERROR[]" + e.getMessage());
			}
		}while(!cerrarMenu);
	}
}
