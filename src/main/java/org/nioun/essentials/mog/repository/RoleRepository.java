package org.nioun.essentials.mog.repository;

import org.nioun.essentials.mog.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import java.util.Collection;


@Repository
public interface RoleRepository extends JpaRepository<Role , Long> {

	
	public  Role findByName(String name);
	
}
