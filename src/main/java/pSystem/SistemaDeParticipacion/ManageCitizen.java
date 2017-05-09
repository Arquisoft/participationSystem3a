package pSystem.SistemaDeParticipacion;

import pSystem.model.User;

public interface ManageCitizen {
	public User addUser(User user);
	public User findByUserAndPassword(String usuario, String contraseña);
}
