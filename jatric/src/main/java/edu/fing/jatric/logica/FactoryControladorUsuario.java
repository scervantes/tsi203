package edu.fing.jatric.logica;

import javax.ejb.Local;
import javax.naming.InitialContext;
import javax.naming.NamingException;

//@Local
public class FactoryControladorUsuario {

	public IControladorUsuario getControladorUsuario() throws NamingException {
		
		IControladorUsuario c = (IControladorUsuario) InitialContext.doLookup("java:global/jatric/ControladorUsuario");
		return c;
	}
	
}
