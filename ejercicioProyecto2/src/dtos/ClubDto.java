package dtos;

import java.time.LocalDate;
import java.util.Date;

public class ClubDto {

	long idClubC;
	String nombreClubC = "aaa";
	String sedePrincipalC = "aaa";
	LocalDate fechaCreacionC = LocalDate.now();
	boolean entradaPublicaC = false;
	String codigoPrivado = "aaaa";
	
	
	public long getIdClubC() {
		return idClubC;
	}
	public void setIdClubC(long idClubC) {
		this.idClubC = idClubC;
	}
	public String getNombreClubC() {
		return nombreClubC;
	}
	public void setNombreClubC(String nombreClubC) {
		this.nombreClubC = nombreClubC;
	}
	public String getSedePrincipalC() {
		return sedePrincipalC;
	}
	public void setSedePrincipalC(String sedePrincipalC) {
		this.sedePrincipalC = sedePrincipalC;
	}
	public LocalDate getFechaCreacionC() {
		return fechaCreacionC;
	}
	public void setFechaCreacionC(LocalDate fechaCreacionC) {
		this.fechaCreacionC = fechaCreacionC;
	}
	public boolean isEntradaPublicaC() {
		return entradaPublicaC;
	}
	public void setEntradaPublicaC(boolean entradaPublicaC) {
		this.entradaPublicaC = entradaPublicaC;
	}
	public String getCodigoPrivado() {
		return codigoPrivado;
	}
	public void setCodigoPrivado(String codigoPrivado) {
		this.codigoPrivado = codigoPrivado;
	}
	
	public ClubDto(long idClubC, String nombreClubC, String sedePrincipalC, boolean entradaPublicaC, String codigoPrivado) {
		super();
		this.idClubC = idClubC;
		this.nombreClubC = nombreClubC;
		this.sedePrincipalC = sedePrincipalC;
		this.entradaPublicaC = entradaPublicaC;
		this.codigoPrivado = codigoPrivado;
	}
	
	public ClubDto() {
		super();
	}
	
	@Override
	public String toString() {
		return "ClubDto [idClubC=" + idClubC + ", nombreClubC=" + nombreClubC + ", sedePrincipalC=" + sedePrincipalC
				+ ", fechaCreacionC=" + fechaCreacionC + ", entradaPublicaC=" + entradaPublicaC + ", codigoPrivado="
				+ codigoPrivado + "]";
	}
	
	
	
	
}
