package com.example.bonoboz.DAOServicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bonoboz.DAOServies.RoleDAOService;
import com.example.bonoboz.domain.Role;
import com.example.bonoboz.repo.RoleRepo;

@Service
public class RoleDAOServiceImpl implements RoleDAOService {

	@Autowired
	RoleRepo roleRepo;

	@Override
	public List<Role> listAllRoles() {
		List<Role> roleList = roleRepo.findAll();
		return roleList;
	}

	@Override
	public Optional<Role> getRoleByID(Integer id) {
		Optional<Role> r = roleRepo.findById(id);
		return r;
	}

	@Override
	public Role save(Role role) {
		roleRepo.save(role);
		return role;
	}

	@Override
	public void deleteRole(Integer id) {
		roleRepo.deleteById(id);
		return;
	}

	

}
