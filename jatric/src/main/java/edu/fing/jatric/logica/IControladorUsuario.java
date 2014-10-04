package edu.fing.jatric.logica;

public interface IControladorUsuario {

	public void agregarUsuario(String email, String username, String password);
	
	public void borrarUsuario(String email);
	
	public void actualizarPassword(String email, String password);
	
}
