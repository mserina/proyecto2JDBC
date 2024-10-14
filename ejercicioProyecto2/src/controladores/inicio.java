package controladores;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import dtos.ClubDto;
import dtos.UsuarioDto;
import servicios.ConexionPostgreSQLImplementacion;
import servicios.ConsultaSQLImplementacion;
import servicios.ConsultaSQLInterfaz;
import servicios.MenuImplementacion;
import servicios.MenuInterfaz;

public class inicio {

	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<UsuarioDto> listaUsuario = new ArrayList<UsuarioDto>();
	public static ArrayList<ClubDto> listaClub = new ArrayList<ClubDto>();	
	
	public static ConexionPostgreSQLImplementacion creacionConexion = new ConexionPostgreSQLImplementacion();
	public static Connection conexion = creacionConexion.generaConexion(); 
	public static ConsultaSQLInterfaz consultaSQL = new ConsultaSQLImplementacion();
	
	public static void main(String[] args) {
		
		boolean cerrarMenu = false;
		byte opcionUsuario = 0;
		
		
		MenuInterfaz mi = new MenuImplementacion();
		
		
		do {
			try {
				opcionUsuario = mi.mostrarMenu();
				
				switch(opcionUsuario) {
				
				case 0:
					cerrarMenu = true;
					break;
				case 1:
					mi.menuUsuario();
					break;
				case 2:
					mi.menuClub();
					break;
				}
				
			}catch(Exception e) {
				
				System.out.println("ERROR[]" + e.getMessage());
			}
		}while(!cerrarMenu);
	}
}
