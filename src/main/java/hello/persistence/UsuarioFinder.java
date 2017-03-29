package hello.persistence;

import java.util.List;

import hello.model.Usuario;

public class UsuarioFinder {
	public static Usuario findUsuarioByUserAndPassword(String user, String passw){
		/*List<Usuario> usuarios = Jpa.getManager().
				createNamedQuery("Usuario.findByUserAndPassword", Usuario.class)
				.setParameter(1, user).setParameter(2, passw).getResultList();
		
		return usuarios.isEmpty() ? null : usuarios.get(0);*/
		return null;
	}
}
