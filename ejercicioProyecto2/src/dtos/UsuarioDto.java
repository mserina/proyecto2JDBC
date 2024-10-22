package dtos;

public class UsuarioDto {

	long idUsuario;
	String nombreC = "aaa";
	String apellidoC = "aaa";
	int telefonoC = 0;
	String correoC = "aaa";
	long idClubCF = 9999;
	String contrasena = "aaaa";
	
	public long getIdClubCF() {
		return idClubCF;
	}
	public void setIdClubCF(long idClubCF) {
		this.idClubCF = idClubCF;
	}
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreC() {
		return nombreC;
	}
	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}
	public String getApellidoC() {
		return apellidoC;
	}
	public void setApellidoC(String apellidoC) {
		this.apellidoC = apellidoC;
	}
	public int getTelefono() {
		return telefonoC;
	}
	public void setTelefono(int telefono) {
		this.telefonoC = telefono;
	}
	public String getCorreo() {
		return correoC;
	}
	public void setCorreo(String correo) {
		this.correoC = correo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public UsuarioDto(long idUsuario, String nombreC, String apellidoC, int telefono, String correo, String contrasena) {
		this.idUsuario = idUsuario;
		this.nombreC = nombreC;
		this.apellidoC = apellidoC;
		this.telefonoC = telefono;
		this.correoC = correo;
		this.contrasena = contrasena;
	}
	
	public UsuarioDto() {
		super();
	}
	@Override
	public String toString() {
		return "UsuarioDto [idUsuario=" + idUsuario + ", nombreC=" + nombreC + ", apellidoC=" + apellidoC
				+ ", telefonoC=" + telefonoC + ", correoC=" + correoC + ", idClubCF=" + idClubCF + "]";
	}
	
	
	
	
	
	
	
}
