package pSystem.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.business.CitizenService;
import pSystem.model.Citizen;
import pSystem.persistence.CitizenRepository;


@Service
public class CitizenServiceImpl implements CitizenService{

	@Autowired
	private CitizenRepository citizenRepository;

	@Override
	public Citizen addCitizen(Citizen citizen) {
		return citizenRepository.save(citizen);
	}

	@Override
	public void deleteCitizen(Citizen citizen) {
		citizenRepository.delete(citizen);
	}

	@Override
	public void updateCitizen(Citizen citizen) {
		citizenRepository.save(citizen);
	}

	@Override
	public Citizen findCitizen(Long citizenId) {
		return citizenRepository.findOne(citizenId);
	}

	@Override
	public Citizen findByDni(String dni) {
		return citizenRepository.findByDni(dni);
	}

	@Override
	public List<Citizen> findAllCitizens() {
		return citizenRepository.findAll();
	}
	
}