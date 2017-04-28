package pSystem.DBManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pSystem.DBManagement.CitizenService;
import pSystem.persistence.CitizenRepository;

@Service
@Transactional
public class CitizenServiceImpl implements CitizenService{

	@Autowired
	private CitizenRepository citizenRepository;
}
