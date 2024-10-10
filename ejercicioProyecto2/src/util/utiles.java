package util;

import controladores.inicio;

public class utiles {

	public long idGeneratorUsuarios() {
		
		long idNuevo;
		int tamano = inicio.listaClub.size() -1;
		
		if(inicio.listaClub.size() > 0) {
			
			idNuevo = inicio.listaClub.get(tamano).getIdClubC()+1;
		}
		else {
			idNuevo = 1;
		}
		
		return idNuevo;
	}
	
	public long idGeneratorClubs() {
	
		long idNuevo;
		int tamano = inicio.listaClub.size() -1;
		
		if(inicio.listaClub.size() > 0) {
			
			idNuevo = inicio.listaClub.get(tamano).getIdClubC()+1;
		}
		else {
			idNuevo = 1;
		}
		
		return idNuevo;
	}
}
