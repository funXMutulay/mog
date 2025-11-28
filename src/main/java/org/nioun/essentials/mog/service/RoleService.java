package org.nioun.essentials.mog.service;

import java.util.List;

import org.nioun.essentials.mog.model.Role;

public interface RoleService {

	Role saveRole(Role role);

	Role updateRole(Role role);

	void deleteRole(Role role);

	Role getRoleById(Long id);

	List<Role> getAllRoles();
	
}
