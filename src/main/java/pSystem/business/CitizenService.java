package pSystem.business;

import java.util.List;

import pSystem.model.Citizen;

public interface CitizenService {

	//CRUD
	public Citizen addCitizen (Citizen citizen);
	public void deleteCitizen (Citizen citizen);
	public void updateCitizen (Citizen citizen);
	public Citizen findCitizen (Long citizenId);
	
	//Otros 
	public Citizen findByDni (String dni);
	public List<Citizen> findAllCitizens ();
	
}