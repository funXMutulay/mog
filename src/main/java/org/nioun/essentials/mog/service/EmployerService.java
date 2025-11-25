package org.nioun.essentials.mog.service;

import java.util.List;
import java.util.Optional;

import org.nioun.essentials.mog.model.Employer;


public interface EmployerService {

     List<Employer> findAll();

     Optional<Employer> findById(int id);

     void delete(int id);

     void save(Employer employer);
	

}
