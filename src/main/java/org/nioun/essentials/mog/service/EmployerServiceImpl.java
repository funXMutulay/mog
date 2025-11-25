package org.nioun.essentials.mog.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.nioun.essentials.mog.model.Employer;
import org.nioun.essentials.mog.repository.EmployerRepository;

@Service
public class EmployerServiceImpl implements EmployerService{
    
    @Autowired
    EmployerRepository employerRepository;

    
    public EmployerRepository getEmployerRepository() {
        return employerRepository;
    }



    public void setEmployerRepository(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }
	
	//Get All Employers
	public List<Employer> findAll(){
		return employerRepository.findAll();
	}	
	
	//Get Employer By Id
	public Optional<Employer> findById(int id) {
		return employerRepository.findById(id);
	}	
	
	//Delete Employer
	public void delete(int id) {
		employerRepository.deleteById(id);
	}
	
	//Update Employer
	public void save( Employer employer) {
		employerRepository.save(employer);
	}

}
