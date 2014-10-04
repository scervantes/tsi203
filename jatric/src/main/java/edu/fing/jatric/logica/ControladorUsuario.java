package edu.fing.jatric.logica;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.codec.digest.DigestUtils;

import edu.fing.jatric.modelo.Usuario;

@Stateless
public class ControladorUsuario implements IControladorUsuario {

	@PersistenceContext(unitName="jatric")
	EntityManager em;
	
	@Override
	public void agregarUsuario(String email, String username, String password) {
		Usuario usu = new Usuario(email, username, DigestUtils.sha256Hex(password));
		System.out.println("email:" + email + " - username:" + username + " - pass: " + password + "#" + DigestUtils.sha256Hex(password));
		em.persist(usu);
		em.flush();
	}

	@Override
	public void borrarUsuario(String email) {
		Usuario u = (Usuario)em.find(Usuario.class, email);
		em.remove(u);
	}

	@Override
	public void actualizarPassword(String email, String password) {
		Usuario u = (Usuario)em.find(Usuario.class, email);
		u.setPassword(password);
		em.merge(u);
	}

}
