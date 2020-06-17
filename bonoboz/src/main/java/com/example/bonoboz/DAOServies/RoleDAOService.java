package com.example.bonoboz.DAOServies;

import java.util.List;
import java.util.Optional;

import com.example.bonoboz.domain.Role;

public interface RoleDAOService {
	
	List<Role> listAllRoles();

	Optional<Role> getRoleByID(Integer id);

	Role save(Role Role);

	void deleteRole(Integer id);
	

}
