package pSystem.SistemaDeParticipacion.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.ManageUserDB;
import pSystem.SistemaDeParticipacion.ManageCitizen;
import pSystem.model.User;

@Service
public class ManageCitizenImpl implements ManageCitizen {
	
	@Autowired
	private ManageUserDB manageUserDB;

	@Override
	public User addUser(User user) {
		return manageUserDB.addUser(user);
	}

	@Override
	public User findByUserAndPassword(String usuario, String contraseña) {
		return manageUserDB.findByUserAndPassword(usuario, contraseña);
	}
}
