package org.nioun.essentials.mog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.nioun.essentials.mog.model.Employer;


@Repository
public interface EmployerRepository extends JpaRepository<Employer,Integer>{

}
