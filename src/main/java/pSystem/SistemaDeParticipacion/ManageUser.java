package pSystem.SistemaDeParticipacion;

import pSystem.model.User;

public interface ManageUser {
	public User addUser(User user);
	public User findByUserAndPassword(String usuario, String contraseña);
}
